package tests.api;

import baseEntities.BaseApiTest;
import core.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestRailApiTest extends BaseApiTest {

    @Test
    public void getAllUsers() {
        // Setup RestAssured
        RestAssured.baseURI = ReadProperties.getUrl();

        // Setup endpoint
        String endpoint = "/index.php?/api/v2/get_users";

        // Setup request Object
        RequestSpecification httpRequest = given();
        httpRequest.header(HTTP.CONTENT_TYPE, ContentType.JSON);//информация из документации, которая говорит о формате данных, которые  мы отправляем
        httpRequest.auth().preemptive().basic(ReadProperties.getUsername(), ReadProperties.getPassword());

        // Setup Response Object
        Response response = httpRequest.request(Method.GET, endpoint);

        // Get Response Status
        int statusCode = response.getStatusCode();
        System.out.println("Status Code: " + statusCode);
        Assert.assertEquals(statusCode, 200);
        Assert.assertEquals(statusCode, HttpStatus.SC_OK);

        // Get Response Body
        String responseBody = response.getBody().asString();
        System.out.println("Response: " + responseBody);
    }

    @Test
    public void getAllUsers1() {
        // Setup endpoint
        String endpoint = "/index.php?/api/v2/get_users";

        given()
                .when()
                .get(endpoint)//отправляем запрос на endpoint
                .then()//затем
                .log().status()//вывод  на экран status code в отформатированном виде
                .log().body()//вывод на экран отформатированного body
                .statusCode(HttpStatus.SC_OK);//проверяем равен ли статус 200
    }
}
