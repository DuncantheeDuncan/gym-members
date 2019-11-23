package assignment;
import static spark.Spark.port;
import static spark.Spark.staticFiles;

public class Run {


    public static void main(String[] args) {

        GymMembers gym = new GymMembers();
        GymList list = new GymList();

        port(8080);
        staticFiles.location("/public");
        staticFiles.location("/templates");

        gym.runMethod();
        list.tableList();
    }
}
