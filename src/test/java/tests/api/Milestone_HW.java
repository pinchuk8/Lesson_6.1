package tests.api;

import baseEntities.BaseApiTest;
import io.restassured.mapper.ObjectMapperType;
import models.Milestone;
import models.ProjectBuilder;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import utils.Endpoints;
import utils.Randomization;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class Milestone_HW extends BaseApiTest {
    int projectID;
    int milestoneID;
    ProjectBuilder project = ProjectBuilder.builder()
            .name(Randomization.getRandomString(3))
            .typeOfProject(Randomization.getRandomType())
            .build();
    Milestone milestone = Milestone.builder()
            .name(Randomization.getRandomString(5))
            .description(Randomization.getRandomString(3))
            .due_on(30)
            .is_completed(true)
            .refs(Randomization.getRandomString(5))
            .build();
    Milestone update_milestone = Milestone.builder()
            .name(Randomization.getRandomString(3))
            .description(Randomization.getRandomString(4))
            .start_on(30)
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

    @Test(dependsOnMethods = "addMilestone")
    public void getMilestones() {
        given()
                .pathParam("project_id", projectID)
                .get(Endpoints.GET_MILESTONES)
                .then()
                .log().body()
                .body("milestones.get(0).name", equalTo(milestone.getName()))
                .body("milestones.get(0).description", equalTo(milestone.getDescription()))
                .statusCode(HttpStatus.SC_OK);
    }

    @Test(dependsOnMethods = "addProject")
    public void addMilestone() {
        milestoneID = given()
                .body(milestone, ObjectMapperType.GSON)
                .pathParam("project_id", projectID)
                .post(Endpoints.ADD_MILESTONE)
                .then()
                .log().body()
                .body("name", is(milestone.getName()))
                .body("description", equalTo(milestone.getDescription()))
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("id");
    }

    @Test(dependsOnMethods = "getMilestones")
    public void updateMilestone() {
        milestoneID = given()
                .pathParam("milestone_id", milestoneID)
                .body(update_milestone, ObjectMapperType.GSON)
                .post(Endpoints.UPDATE_MILESTONE)
                .then()
                .log().body()
                .body("name", is(update_milestone.getName()))
                .body("description", equalTo(update_milestone.getDescription()))
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("id");
        System.out.println(milestoneID);
    }

    @Test(dependsOnMethods = "updateMilestone")
    public void deleteMilestone() {
        given()
                .pathParam("milestone_id", milestoneID)
                .post(Endpoints.DELETE_MILESTONE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }
}
