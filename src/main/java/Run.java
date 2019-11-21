import static spark.Spark.port;
import static spark.Spark.staticFiles;

public class Run {


    public static void main(String[] args) {

        GymMembers gym = new GymMembers();


        gym.runMethod();
    }
}
