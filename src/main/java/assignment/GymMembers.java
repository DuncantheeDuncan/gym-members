package assignment;
import spark.ModelAndView;
import spark.Request;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import static spark.Spark.*;
import static spark.Spark.staticFiles;

public class GymMembers {


HashMap<String , Object> gymMap = new HashMap<>();

    private static final String SQL_TABLE_CREATE_TABLEMEMBER = new StringBuilder()
            .append("CREATE TABLE TABLEMEMBER")
            .append("(")
            .append("MEMBERID serial not null PRIMARY KEY,")
            .append("NAME_ VARCHAR(25),")
            .append("SURNAME VARCHAR(25),")
            .append("ID_ BIGINT,")
            .append("CONTACT BIGINT,")
            .append("DATEOFBIRTH integer,")
            .append("DATEJOINED DATE NOT NULL DEFAULT CURRENT_DATE,")
            .append("MEMEMBERTYPE VARCHAR(15)")
            .append(")")
            .toString();

    private static final String SQL_TABLE_CREATE_TABLEPAYMENT = new StringBuilder()
            .append("CREATE TABLE TABLEPAYMENT")
            .append("(")
            .append(" PAYMENTID serial not null PRIMARY KEY,")
            .append("AMOUNT integer,")
            .append("PAYMENTDATE integer,")
            .append("foreign key (PAYMENTID) references TABLEMEMBER(MEMBERID)")
            .append(")")
            .toString();


     final String SQL_INSERT_TABLEMEMBER = "INSERT INTO TABLEMEMBER ( NAME_, SURNAME, ID_, CONTACT, DATEOFBIRTH, MEMEMBERTYPE ) VALUES (?,?,?,?,?,?)";
     final String SQL_INSERT_TABLEPAYMENT = "INSERT INTO TABLEPAYMENT ( AMOUNT, PAYMENTDATE ) VALUES (?,?)";

     final String SQL_TABLE_DROP_TABLEMEMBER = "DROP TABLE IF EXISTS TABLEMEMBER, TABLEPAYMENT CASCADE ";
     final String SQL_UPDATE= "UPDATEe TABLEMEMBER";

final String GREET_DATABASE_URL = /*"jdbc:h2:~/GymMembers"*/ "jdbc:postgresql://127.0.0.1:5432/gymdb";



    public void runMethod(){


        get("/details", (req, res) -> {

            HashMap<String , Object> gymMap = new HashMap<>();

            try  (/*Connection conn = DriverManager.getConnection(GREET_DATABASE_URL,"sa","") */ Connection conn = DriverManager.getConnection(GREET_DATABASE_URL,"coder","pg123");
                 Statement statement = conn.createStatement();
             PreparedStatement psinsert = conn.prepareStatement(SQL_INSERT_TABLEMEMBER);
                 PreparedStatement psinsert2 = conn.prepareStatement(SQL_INSERT_TABLEPAYMENT);
             PreparedStatement psupdate = conn.prepareStatement("SQL_UPDATE")){
                

                if (conn != null){

                    System.out.println("Connected");
               }else {
                    System.out.println("Failed to make connection to the DATABASE!");
                }
//
//                statement.execute(SQL_TABLE_DROP_TABLEMEMBER); //JUST TO CLEAN THE DATABASE
//                        statement.execute(SQL_TABLE_DROP_TABLEPAYMENT);
//                        statement.execute(SQL_TABLE_CREATE_TABLEMEMBER);
//                        statement.execute(SQL_TABLE_CREATE_TABLEPAYMENT);


            }catch (SQLException e) {
                System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return new HandlebarsTemplateEngine().render(new ModelAndView(gymMap, "store.handlebars"));
        });




        post("/details", (req, res) -> {

            HashMap<String , Object> gymMap = new HashMap<>();
            List <Object> list =  new ArrayList<>();

            // initializing variables with inputs fields
            String add_surname = req.queryParams("element_3_2");
            String add_name = /*"name(s)" +*/req.queryParams("element_3_1");
            String add_id_number = req.queryParams("element_14_1_1");
            String add_membership_type = req.queryParams("element_17");
            String add_cellphone_number = req.queryParams("element_10_1");
                   add_cellphone_number += req.queryParams("element_10_2");
                   add_cellphone_number += req.queryParams("element_10_3");
            String add_dateofbirth = req.queryParams("element_9_1");
                   add_dateofbirth+=req.queryParams("element_9_2");
                   add_dateofbirth+=req.queryParams("element_9_3");

                   // trying to get the last four digits
           String lastFourDigits = add_dateofbirth.substring(add_dateofbirth.length() - 4);


            String add_payment_date = req.queryParams("element_99_1");
            add_payment_date+=req.queryParams("element_99_2");
            add_payment_date+=req.queryParams("element_99_3");
            String add_amount = req.queryParams("element_6_1");
//                   add_amount += req.queryParams("element_6_2");




            gymMap.put("surname",add_surname);
            gymMap.put("Name",add_name);
            gymMap.put("ID_Number",add_id_number);
            gymMap.put("membership",add_membership_type);
            gymMap.put("contact",add_cellphone_number);
            gymMap.put("dateOfBirth",add_dateofbirth);
            gymMap.put("payment_date",add_payment_date);
            gymMap.put("amount",add_amount);

            System.out.println(gymMap);
            list.add(gymMap);

            long id_number =Long.parseLong(add_id_number);
            long cell_number = Long.parseLong(add_cellphone_number);
            int dateOfBirth = Integer.parseInt(add_dateofbirth);
            int payment_date = Integer.parseInt(add_payment_date);
            int amount = Integer.parseInt(add_amount);
            // still to add
            int year = Integer.parseInt(lastFourDigits) - 2019;
            int year2 = Calendar.getInstance().get(Calendar.YEAR);
            System.out.println("last for digits " +lastFourDigits + " " +year+ " " +year2);

            Class.forName("org.h2.Driver");// reg jdbc drive
            try  (/*Connection conn = DriverManager.getConnection(GREET_DATABASE_URL,"sa","") */ Connection conn = DriverManager.getConnection(GREET_DATABASE_URL,"coder","pg123");
                  Statement statement = conn.createStatement();
                  PreparedStatement psinsert = conn.prepareStatement(SQL_INSERT_TABLEMEMBER);
                  PreparedStatement psinsert2 = conn.prepareStatement(SQL_INSERT_TABLEPAYMENT);
                  PreparedStatement psupdate = conn.prepareStatement("SQL_UPDATE")){

                if (conn != null){
                    System.out.println("Connected");
                }else {
                    System.out.println("Failed to make connection to the DATABASE!");
                }


                        // statement.execute(SQL_TABLE_DROP_TABLEMEMBER); //JUST TO CLEAN THE DATABASE
//                        statement.execute(SQL_TABLE_DROP_TABLEPAYMENT);
                        // statement.execute(SQL_TABLE_CREATE_TABLEMEMBER);
                        // statement.execute(SQL_TABLE_CREATE_TABLEPAYMENT);

                       

                psinsert.setString(1, add_name);
                psinsert.setString(2, add_surname);
                psinsert.setLong(3, id_number);
                psinsert.setLong(4, cell_number);
                psinsert.setInt(5, dateOfBirth);
                psinsert.setString(6, add_membership_type);
                psinsert.execute();

//                INSERT INTO TABLEPAYMENT ( AMOUNT, PAYMENTDATE ) VALUES (?,?)";
//                int payment_date = Integer.parseInt(add_payment_date);
//                float amount = Float.parseFloat(add_amount);
                psinsert2.setInt(1,payment_date);
                psinsert2.setInt(2,amount);
                psinsert2.execute();


            }catch (SQLException e) {
                System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }


      return new HandlebarsTemplateEngine().render(new ModelAndView(gymMap, "store.handlebars"));
        });
    }








}