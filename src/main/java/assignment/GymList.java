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

public class GymList  {


    public void tableList() {



get("one",(req,res)->"phumlani");

        get("/list", (req, res) -> {
             String ordeid_name = "Order ID";
            HashMap<String , Object> gymMap = new HashMap<>();

            List<String>names = new ArrayList<>();
            List<String>surnameNames = new ArrayList<>();
            List<Integer>idNumbers = new ArrayList<>();
            List<Integer>dateofbirth = new ArrayList<>();
            List<Integer>orderIds = new ArrayList<>();
            List <Integer> age = new ArrayList<>();
            List <Integer> Amount_due = new ArrayList<>();
            List <Integer> Amount_paid = new ArrayList<>();
            List <Integer> balance = new ArrayList<>();







//            List<Object> collect = new ArrayList<Object>();


            // populate students from the database

            try (Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/gymdb", "coder", "pg123"); Statement statement = conn.createStatement()) {

                if (conn == null)
                    System.out.println("Failed to make connection to the DATABASE!");



                String sql = "SELECT MEMBERID,ID_ ,NAME_, SURNAME,DATEOFBIRTH FROM TABLEMEMBER ";
                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    int MEMBERID = resultSet.getInt("MEMBERID");
                    int ID_ = resultSet.getInt("ID_");
                    int DOB = resultSet.getInt("DATEOFBIRTH");
                    String NAME_ = resultSet.getString("NAME_");
                    String SURNAME = resultSet.getString("SURNAME");

                    names.add(NAME_);
                    idNumbers.add(ID_);
                    surnameNames.add(SURNAME);
                    dateofbirth.add(DOB);
                    orderIds.add(MEMBERID);
                    System.out.println("date OFFFFF "+ ID_);


                }

            } catch (SQLException e) {
                System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }


//            System.out.println("checking how many stuff inside " +collect );
//            gymMap.put("collect list", collect);
            gymMap.put("names",names);
            gymMap.put("surnameNames",surnameNames);
            gymMap.put("idNumbers",idNumbers);
            gymMap.put("orderIds",orderIds);
            gymMap.put("dateofbirth",dateofbirth);

            System.out.println("Map " +gymMap);




            return new HandlebarsTemplateEngine().render(new ModelAndView(gymMap, "list.handlebars"));
        });


        post("/list", (req, res) -> {
//             String ordeid_name = "Order ID";
            HashMap<String , Object> gymMap = new HashMap<>();

            List<String>names = new ArrayList<>();
            List<String>surnameNames = new ArrayList<>();
            List<Integer>idNumbers = new ArrayList<>();
            List<Integer>dateofbirth = new ArrayList<>();
            List<Integer>orderIds = new ArrayList<>();
            List <Integer> age = new ArrayList<>();
            List <Integer> Amount_due = new ArrayList<>();
            List <Integer> Amount_paid = new ArrayList<>();
            List <Integer> balance = new ArrayList<>();





//            List<Object> collect = new ArrayList<Object>();


            // populate students from the database

            try (Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/gymdb", "coder", "pg123"); Statement statement = conn.createStatement()) {

                if (conn == null)
                    System.out.println("Failed to make connection to the DATABASE!");



                String sql = "SELECT MEMBERID,ID_ ,NAME_, SURNAME,DATEOFBIRTH FROM TABLEMEMBER ";
                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    int MEMBERID = resultSet.getInt("MEMBERID");
                    int ID_ = resultSet.getInt("ID_");
                    int DOB = resultSet.getInt("DATEOFBIRTH");
                    String NAME_ = resultSet.getString("NAME_");
                    String SURNAME = resultSet.getString("SURNAME");

                    names.add(NAME_);
                    idNumbers.add(ID_);
                    surnameNames.add(SURNAME);
                    dateofbirth.add(DOB);
                    orderIds.add(MEMBERID);


//                    collect.add(NAME_);
//                    collect.add(SURNAME);
//                    collect.add(MEMBERID);
//                    collect.add(ID_);
//                    collect.add(DOB);


                }

            } catch (SQLException e) {
                System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }


//            System.out.println("checking how many stuff inside " +collect );
//            gymMap.put("collect list", collect);
            gymMap.put("names",names);
            gymMap.put("surnameNames",surnameNames);
            gymMap.put("idNumbers",idNumbers);
            gymMap.put("orderIds",orderIds);
            gymMap.put("dateofbirth",dateofbirth);

            System.out.println("Map " +gymMap);


//            gymMap.put("student_surnames", student_surnames);
//            gymMap.put("studentnumbers", studentnumbers);


            return new HandlebarsTemplateEngine().render(new ModelAndView(gymMap, "list.handlebars"));
        });




//
//        post("/list", (req, response) -> {
//
//            HashMap<String , Object> gymMap = new HashMap<>();
//            List<Object> list = new ArrayList<>();
//
//
//            // populate students from the database
//
//            try (Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/gymdb", "coder", "pg123"); Statement statement = conn.createStatement()) {
//
//                if (conn == null)
//                    System.out.println("Failed to make connection to the DATABASE!");
//
//
//                String sql = "SELECT STUDENT_NUMBER ,STUDENT_NAME, SURNAME FROM STUDENT";
//                ResultSet resultSet = statement.executeQuery(sql);
//                while (resultSet.next()) {
//                    int student_number = resultSet.getInt("STUDENT_NUMBER");
//                    String student_name = resultSet.getString("STUDENT_NAME");
//                    String surname = resultSet.getString("SURNAME");
//
//
//
//                    list.add(student_name);
//                    list.add(surname);
//                    list.add(student_number);
////TODO last stop!!!
//                    gymMap.put("student_name", student_name);
//                    gymMap.put("surname", surname);
//                    gymMap.put("student_number", student_number);
//
//
//                }
//
//            } catch (SQLException e) {
//                System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
//                e.printStackTrace();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//
//
//            return new HandlebarsTemplateEngine().render(new ModelAndView(gymMap, "list.handlebars"));
//        });
    }
//
}
//
//
////        {{#each studentnumbers}}
////<tr>
////<td>
////<label class="main"><a class="main" href="/studentList/{{this}}"><span class="geekmark"></span></a></label>
////        {{this.student}}
////</td>
////</tr>
////        {{/each}}
