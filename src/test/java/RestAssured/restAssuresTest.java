package RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class restAssuresTest {

    @Test
    public static void getStudentAPI(){
        given().when().get("http://localhost:8080/students/1").then().statusCode(200).log()
                .all();
    }
}
