package assignment;

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

//        get("/studentlist/:studentNo", (req, res) -> {
//            Map<String, Object> school_form_map = new HashMap<>();
//
//            List<String> student_names = new ArrayList<String>();
//            List<String> student_surnames = new ArrayList<String>();
//            List<Integer> studentnumbers = new ArrayList<Integer>();
//            List<Integer> student_contacts = new ArrayList<>();
//            List<Integer> parents_contatcs = new ArrayList<>();
//
//
//            String studentnumber = req.params("studentNo");
//            System.out.println(studentnumber + " <- student");
//
//
//            // qury the db to find the student for the studentnumber
//            try (Connection conn = DriverManager.getConnection(
//                    "jdbc:postgresql://127.0.0.1:5432/onlineRegister", "coder", "pg123"); Statement statement = conn.createStatement()) {
//
//                if (conn == null)
//                    System.out.println("Failed to make connection to the DATABASE!");
//
//
//                String sql = "SELECT STUDENT_NAME, SURNAME,STUDENT_NUMBER,PARENT_CONTACT ,CONTACT FROM STUDENT WHERE  STUDENT_NUMBER = ?";
//
//                PreparedStatement preparedStatement = conn.prepareStatement(sql);
//                preparedStatement.setInt(1, Integer.parseInt(studentnumber));
//
//                //"INSERT INTO STUDENT (STUDENT_NUMBER, STUDENT_NAME, SECOND_NAME," +
//                //      "SURNAME, CONTACT, EMAIL, GENDER, TITLE,PARENT_CONTACT,PARENT_EMAIL) VALUES (?,?,?,?,?,?,?,?,?,?)";
//
//                ResultSet resultSet = preparedStatement.executeQuery();
//                while (resultSet.next()) {
//                    int student_number = resultSet.getInt("STUDENT_NUMBER");
//                    String student_name = resultSet.getString("STUDENT_NAME");
//                    String surname = resultSet.getString("SURNAME");
//                    int student_contact = resultSet.getInt("CONTACT");
//                    int parents_contact = resultSet.getInt("PARENT_CONTACT");
//
//
//                    student_names.add(student_name);
//                    student_surnames.add(surname);
//                    studentnumbers.add(student_number);
//                    student_contacts.add(student_contact);
//                    parents_contatcs.add(parents_contact);
//
//                    System.out.println(student_name + " " +parents_contact);
//
//                    school_form_map.put("student_names", student_names);
//                    school_form_map.put("surname", surname);
//                    school_form_map.put("student_number", student_number);
//                    school_form_map.put("student_contact", student_contact);
//                    school_form_map.put("parents_contact", parents_contact);
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
//            return new HandlebarsTemplateEngine().render(new ModelAndView(school_form_map, "Student.handlebars"));
//
//        });


        get("/list", (req, res) -> {

            Map<String, Object> school_form_map = new HashMap<>();

            List<String> student_names = new ArrayList<String>();
            List<String> student_surnames = new ArrayList<String>();
            List<Integer> studentnumbers = new ArrayList<Integer>();
//
            List<Object> collect = new ArrayList<Object>();


            // populate students from the database

            try (Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/onlineRegister", "coder", "pg123"); Statement statement = conn.createStatement()) {

                if (conn == null)
                    System.out.println("Failed to make connection to the DATABASE!");


                String sql = "SELECT STUDENT_NUMBER ,STUDENT_NAME, SURNAME FROM STUDENT";
                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    int student_number = resultSet.getInt("STUDENT_NUMBER");
                    String student_name = resultSet.getString("STUDENT_NAME");
                    String surname = resultSet.getString("SURNAME");


                    student_names.add(student_name);
                    student_surnames.add(surname);
                    studentnumbers.add(student_number);

                    collect.add(student_names);
                    collect.add(student_surnames);
                    collect.add(student_number);

                }

            } catch (SQLException e) {
                System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }


            school_form_map.put("student_names", student_names);
            school_form_map.put("student_surnames", student_surnames);
            school_form_map.put("studentnumbers", studentnumbers);


            return new HandlebarsTemplateEngine().render(new ModelAndView(school_form_map, "studentlist.handlebars"));
        });


        post("/list", (req, response) -> {

//            Map<String, Object> school_form_map = new HashMap<>();
            HashMap<String , Object> gymMap = new HashMap<>();
            List<Object> list = new ArrayList<>();
//            List<String> student_names = new ArrayList<String>();
//            List<String> student_surnames = new ArrayList<String>();
//            List<Integer> studentnumbers = new ArrayList<Integer>();


            // populate students from the database

            try (Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/onlineRegister", "coder", "pg123"); Statement statement = conn.createStatement()) {

                if (conn == null)
                    System.out.println("Failed to make connection to the DATABASE!");


                String sql = "SELECT STUDENT_NUMBER ,STUDENT_NAME, SURNAME FROM STUDENT";
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    int student_number = resultSet.getInt("STUDENT_NUMBER");
                    String student_name = resultSet.getString("STUDENT_NAME");
                    String surname = resultSet.getString("SURNAME");



                    list.add(student_name);
                    list.add(surname);
                    list.add(student_number);
//TODO last stop!!!
                    gymMap.put("student_name", student_name);
                    gymMap.put("surname", surname);
                    gymMap.put("student_number", student_number);


                }

            } catch (SQLException e) {
                System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }



            return new HandlebarsTemplateEngine().render(new ModelAndView(gymMap, "list.handlebars"));
        });
    }

}


//        {{#each studentnumbers}}
//<tr>
//<td>
//<label class="main"><a class="main" href="/studentList/{{this}}"><span class="geekmark"></span></a></label>
//        {{this.student}}
//</td>
//</tr>
//        {{/each}}
