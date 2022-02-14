package tests;

import baseEntities.BaseTest;
import models.Milestone;
import models.Project;
import org.testng.annotations.Test;
import steps.MilestoneSteps;
import steps.ProjectSteps;
import utils.Randomization;

public class MilestonesTests extends BaseTest {
    Project project = Project.builder()
            .name("TMS" + Randomization.getRandomString(5))
            .build();
    Milestone milestone = Milestone.builder()
            .name(Randomization.getRandomString(5))
            .description(Randomization.getRandomString(5))
            .build();
    Milestone update_milestone = Milestone.builder()
            .name(Randomization.getRandomString(5))
            .description(Randomization.getRandomString(5))
            .build();
    @Test
    public void CRUD() {
        ProjectSteps projectSteps=new ProjectSteps();
        projectSteps.AddProject(project);
        MilestoneSteps milestoneSteps = new MilestoneSteps();
        milestoneSteps.addMilestone(project, milestone);
        milestoneSteps.UpdateMilestone(milestone, update_milestone);
        milestoneSteps.DeleteMilestone(project, update_milestone);
    }
}