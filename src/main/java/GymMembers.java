import spark.ModelAndView;
import spark.Request;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.sql.*;
import java.util.HashMap;

import static spark.Spark.*;
import static spark.Spark.staticFiles;

public class GymMembers {

    private Request req;

    // initializing variables with inputs fields
    String add_surname = req.queryParams("element_3_1");
    String add_name = /*"name(s)" +*/req.queryParams("element_3_2");
    String add_id_number = req.queryParams("element_14_1_1");
    String add_membership_type = req.queryParams("element_17");
    String add_student_email = req.queryParams("element_14_10");
    String add_cellphone_number = req.queryParams("element_10_1");
    //TODO: last stop!!..
    add_cellphone_number += req.queryParams("element_10_2");
    add_cellphone_number += req.queryParams("element_10_3");

    String add_parents_email_address = req.queryParams("element_14_120");
    String add_parent_number = req.queryParams("element_10_01");
    add_parent_number += req.queryParams("element_10_02");
    add_parent_number += req.queryParams("element_10_03");


    int s_number = Integer.parseInt(add_student_cellphone_number);
    int s_student_number = Integer.parseInt(add_student_number);
    int p_number = Integer.parseInt(add_parent_number);



HashMap<String , Object> gymMap = new HashMap<>();
    private static final String SQL_TABLE_CREATE = new StringBuilder()
            .append("CREATE TABLE TABLEMEMBERS")
            .append("(")
            .append("MEMBERID integer not null primary key,")
            .append("NAME VARCHAR(25),")
            .append("SURNAME VARCHAR(25),")
            .append("ID integer,")
            .append("CONTACT integer,")
            .append("DATEJOINED DATE NOT NULL DEFAULT CURRENT_DATE,")
            .append("MEMEMBERTYPE VARCHAR(15),")
            .append(")")
            .toString();
    private static final String SQL_INSERT = "INSERT INTO TABLEMEMBERS (MEMBERID, NAME, SURNAME, ID, CONTACT, DATEJOINED,  MEMEMBERTYPE ) VALUES (?,?,?,?,?,?,?)";

    private static final String SQL_TABLE_DROP = "DROP TABLE TABLEMEMBERS";

    public void runMethod(){
        port(8080);
        staticFiles.location("/public");
        staticFiles.location("/templates");


        get("/details", (req, res) -> {

            HashMap<String , Object> gymMap = new HashMap<>();
//
            try (Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/gymdb", "coder", "pg123");
                 Statement statement = conn.createStatement()){

                if (conn != null){
                    System.out.println("Connected");
                }else {
                    System.out.println("Failed to make connection to the DATABASE!");
                }




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

            try (Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/gymdb", "coder", "pg123");
                 Statement statement = conn.createStatement()){

                if (conn != null){
                    System.out.println("Connected");
                }else {
                    System.out.println("Failed to make connection to the DATABASE!");
                }




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