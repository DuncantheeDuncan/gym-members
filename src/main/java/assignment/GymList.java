package assignment;
//

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class GymList {


    public void tableList() {


        get("/list/:button", (req, res) -> {
            String studentnumber = req.params("button");
            HashMap<String, Object> gymMap = new HashMap<>();

            List<String> names = new ArrayList<>();
            List<String> surnameNames = new ArrayList<>();
            List<Long> idNumbers = new ArrayList<>();
            List<Integer> dateofbirth = new ArrayList<>();
            List<Integer> orderIds = new ArrayList<>();
            List<Integer> age = new ArrayList<>();
            List<Integer> Amount_due = new ArrayList<>();
            List<Integer> Amount_paid = new ArrayList<>();
            List<Integer> balance = new ArrayList<>();


//            List<Object> collect = new ArrayList<Object>();

            try (Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/gymdb", "coder", "pg123"); Statement statement = conn.createStatement()) {

                if (conn == null)
                    System.out.println("Failed to make connection to the DATABASE!");


                String sql = "SELECT MEMBERID,ID_ ," +
                        "NAME_, " +
                        "SURNAME," +
                        "DATEOFBIRTH," +
                        "AGE, " +
                        "TABLEPAYMENT.AMOUNT" +
                        " FROM TABLEMEMBER  " +
                        "FULL OUTER JOIN TABLEPAYMENT  " +
                        "ON TABLEMEMBER.MEMBERID =   TABLEPAYMENT.PAYMENTID";
//TODO LAST STEP!!
                ResultSet resultSet = statement.executeQuery(sql);


                while (resultSet.next()) {
                    int MEMBERID = resultSet.getInt("MEMBERID");
                    long ID_ = resultSet.getLong("ID_");
                    int DOB = resultSet.getInt("DATEOFBIRTH");
                    int AGE = resultSet.getInt("AGE");
                    String NAME_ = resultSet.getString("NAME_");
                    String SURNAME = resultSet.getString("SURNAME");
                    int AMOUNT = resultSet.getInt("AMOUNT");

                    int amoutDue, remainig_amount = 2200;


                    amoutDue = 200;
                    remainig_amount -= AMOUNT;
                    names.add(NAME_);
                    idNumbers.add(ID_);
                    surnameNames.add(SURNAME);
                    dateofbirth.add(DOB);
                    orderIds.add(MEMBERID);
                    age.add(AGE);
                    Amount_paid.add(AMOUNT);
                    Amount_due.add(amoutDue);
                    balance.add(remainig_amount);


                }

            } catch (SQLException e) {
                System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }


//            System.out.println("checking how many stuff inside " +collect );
//            gymMap.put("collect list", collect);
            gymMap.put("names", names);
            gymMap.put("surnameNames", surnameNames);
            gymMap.put("idNumbers", idNumbers);
            gymMap.put("orderIds", orderIds);
            gymMap.put("dateofbirth", dateofbirth);
            gymMap.put("age", age);
            gymMap.put("Amount_paid", Amount_paid);
            gymMap.put("Amount_due", Amount_due);
            gymMap.put("balance", balance);

            System.out.println("Map " + gymMap);


            return new HandlebarsTemplateEngine().render(new ModelAndView(gymMap, "list.handlebars"));
        });


        post("/list", (req, res) -> {
            String ordeid_name = "Order ID";
            HashMap<String, Object> gymMap = new HashMap<>();

            List<String> names = new ArrayList<>();
            List<String> surnameNames = new ArrayList<>();
            List<Long> idNumbers = new ArrayList<>();
            List<Integer> dateofbirth = new ArrayList<>();
            List<Integer> orderIds = new ArrayList<>();
            List<Integer> age = new ArrayList<>();
            List<Integer> Amount_due = new ArrayList<>();
            List<Integer> Amount_paid = new ArrayList<>();
            List<Integer> balance = new ArrayList<>();


//            List<Object> collect = new ArrayList<Object>();


            // populate students from the database

            try (Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/gymdb", "coder", "pg123"); Statement statement = conn.createStatement()) {

                if (conn == null)
                    System.out.println("Failed to make connection to the DATABASE!");


                String sql = "SELECT MEMBERID,ID_ ," +
                        "NAME_, " +
                        "SURNAME," +
                        "DATEOFBIRTH," +
                        "AGE, " +
                        "TABLEPAYMENT.AMOUNT" +
                        " FROM TABLEMEMBER  " +
                        "FULL OUTER JOIN TABLEPAYMENT  " +
                        "ON TABLEMEMBER.MEMBERID =   TABLEPAYMENT.PAYMENTID";
//TODO LAST STEP!!
                ResultSet resultSet = statement.executeQuery(sql);

//                String sql1 = "SELECT AMOUNT FROM TABLEPAYMENT ";
//                ResultSet resultSet1 = statement.executeQuery(sql1);
//
//                while (resultSet1.next()) {
//                    int AMOUNT = resultSet.getInt("AMOUNT");
//
//                    Amount_paid.add(AMOUNT);
//                }

                while (resultSet.next()) {
                    int MEMBERID = resultSet.getInt("MEMBERID");
                    long ID_ = resultSet.getInt("ID_");
                    int DOB = resultSet.getInt("DATEOFBIRTH");
                    int AGE = resultSet.getInt("AGE");
                    String NAME_ = resultSet.getString("NAME_");
                    String SURNAME = resultSet.getString("SURNAME");
                    int AMOUNT = resultSet.getInt("AMOUNT");

                    int amoutDue, remainig_amount = 2200;


                    amoutDue = 200;
                    remainig_amount -= AMOUNT;
                    names.add(NAME_);
                    idNumbers.add(ID_);
                    surnameNames.add(SURNAME);
                    dateofbirth.add(DOB);
                    orderIds.add(MEMBERID);
                    age.add(AGE);
                    Amount_paid.add(AMOUNT);
                    Amount_due.add(amoutDue);
                    balance.add(remainig_amount);


                }

            } catch (SQLException e) {
                System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }


//            System.out.println("checking how many stuff inside " +collect );
//            gymMap.put("collect list", collect);
            gymMap.put("names", names);
            gymMap.put("surnameNames", surnameNames);
            gymMap.put("idNumbers", idNumbers);
            gymMap.put("orderIds", orderIds);
            gymMap.put("dateofbirth", dateofbirth);
            gymMap.put("age", age);
            gymMap.put("Amount_paid", Amount_paid);
            gymMap.put("Amount_due", Amount_due);
            gymMap.put("balance", balance);

            System.out.println("Map " + gymMap);


            return new HandlebarsTemplateEngine().render(new ModelAndView(gymMap, "list.handlebars"));
        });

    }
}