package tests.api;

import baseEntities.BaseApiTest;
import io.restassured.mapper.ObjectMapperType;
import models.Case;
import models.Milestone;
import models.ProjectBuilder;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import utils.Endpoints;
import utils.Randomization;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class Cases_HW extends BaseApiTest {
    int projectID = 5;
    int caseID;
    Case case1 = Case.builder()
            .title(Randomization.getRandomString(3))
            .section_id(1)
            .build();
    Case case2 = Case.builder()
            .title(Randomization.getRandomString(3))
            .section_id(1)
            .build();
    Case update_case = Case.builder()
            .title(Randomization.getRandomString(3))
            .section_id(1)
            .build();

    @Test
    public void addCases() {
        caseID =given()
                .body(case1, ObjectMapperType.GSON)
                .pathParam("section_id", case1.getSection_id())
                .when()
                .post(Endpoints.ADD_CASES)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("id");
        System.out.println(caseID);
        /*given()
                .body(case2, ObjectMapperType.GSON)
                .pathParam("section_id", case2.getSection_id())
                .when()
                .post(Endpoints.ADD_CASES)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
        given()
                .body(case3, ObjectMapperType.GSON)
                .pathParam("section_id", case3.getSection_id())
                .when()
                .post(Endpoints.ADD_CASES)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);*/
    }
    @Test
    public void getCase(){
        given()
                .pathParam("case_id", caseID)
                .when()
                .get(Endpoints.GET_CASE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);}
    @Test
    public void updateCase(){
        caseID = given()
                .pathParam("case_id", caseID)
                .body(update_case, ObjectMapperType.GSON)
                .when()
                .post(Endpoints.UPDATE_CASE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("id");
        System.out.println(caseID);
    }
}

