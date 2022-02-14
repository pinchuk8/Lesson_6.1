package tests.api;

import baseEntities.BaseApiTest;
import com.google.gson.Gson;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.*;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Endpoints;
import utils.Randomization;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Cases_HW extends BaseApiTest {
    int projectID;
    int sectionID;
    int caseID_1;
    int caseID_2;
    ProjectBuilder project = ProjectBuilder.builder()
            .name(Randomization.getRandomString(3))
            .typeOfProject(Randomization.getRandomType())
            .build();
    Section section = Section.builder()
            .name(Randomization.getRandomString(3))
            .build();
    Case case1 = Case.builder()
            .title(Randomization.getRandomString(3))
            .section_id(1)
            .build();
    Case case2 = Case.builder()
            .title(Randomization.getRandomString(3))
            .section_id(1)
            .build();
    Case update_case1 = Case.builder()
            .title(Randomization.getRandomString(3))
            .section_id(1)
            .build();

    @Test
    public void addProject() {
        projectID = given()
                .body(project, ObjectMapperType.GSON)
                .post(Endpoints.ADD_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("id");
        System.out.println(projectID);
    }

    @Test(dependsOnMethods = "addProject")
    public void addCases() {
        caseID_1 = given()
                .body(case1, ObjectMapperType.GSON)
                .pathParam("section_id", case1.getSection_id())
                .post(Endpoints.ADD_CASES)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("id");
        System.out.println(caseID_1);
        caseID_2 = given()
                .body(case2, ObjectMapperType.GSON)
                .pathParam("section_id", case2.getSection_id())
                .post(Endpoints.ADD_CASES)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("id");
        System.out.println(caseID_2);
    }

    @Test(dependsOnMethods = "addCases")
    public void getCase() {
        Gson gson = new Gson();
        Response response = given()
                .pathParam("case_id", caseID_1)
                .get(Endpoints.GET_CASE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        Case actualCase = gson.fromJson(response.getBody().asString(), Case.class);
        Assert.assertEquals(actualCase, case1);
    }

    @Test(dependsOnMethods = "addCases")
    public void updateCase() {
        caseID_1 = given()
                .pathParam("case_id", caseID_1)
                .body(update_case1, ObjectMapperType.GSON)
                .post(Endpoints.UPDATE_CASE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("id");
        System.out.println(caseID_1);
    }

    @Test(dependsOnMethods = "addCases")
    public void addSection() {
        sectionID = given()
                .pathParam("project_id", projectID)
                .body(section, ObjectMapperType.GSON)
                .post(Endpoints.ADD_SECTION)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("id");
        System.out.println(sectionID);
    }

    @Test(dependsOnMethods = "addSection")
    public void moveCaseToSection() {
        int[] myList = {caseID_1, caseID_2};
        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("case_ids", myList);
        given()
                .pathParam("section_id", sectionID)
                .body(jsonAsMap)
                .post(Endpoints.MOVE_CASE_TO_SECTION)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test(dependsOnMethods = "moveCaseToSection")
    public void deleteCase() {
        given()
                .pathParam("case_id", caseID_1)
                .post(Endpoints.DELETE_CASE)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}

