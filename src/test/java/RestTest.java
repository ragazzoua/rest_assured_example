import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static constants.ApiConstants.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RestTest {

    @Test
    public void getUsers() {
        given()
                .baseUri(BASE_URI)
                .basePath(USERS_PATH)
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                .statusCode(CODE_200);
    }

    @Test
    public void saveUsersToString() {
        String s = given()
                .baseUri(BASE_URI)
                .basePath(USERS_PATH)
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                .statusCode(CODE_200)
                .extract().asString();
        System.out.println(s);
    }

    @Test
    public void getValueForSomeKey() {
        given()
                .baseUri(BASE_URI)
                .basePath(USERS_PATH)
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                .statusCode(CODE_200)
                .body("data[0].email", equalTo("george.bluth@reqres.in")) ;
    }
}
