package tests;

import baseEntities.BaseTest;
import models.Case;
import models.Project;
import org.testng.annotations.Test;
import steps.CaseSteps;
import steps.ProjectSteps;
import utils.Randomization;

public class CasesTests extends BaseTest {
    Project project = Project.builder()
            .name("TMS" + Randomization.getRandomString(5))
            .build();
    Case update_case = Case.builder()
            .name(Randomization.getRandomString(5))
            .build();
    Case base_case = Case.builder()
            .name(Randomization.getRandomString(5))
            .build();
    @Test
    public void CRUD() {
        ProjectSteps projectSteps=new ProjectSteps();
        projectSteps.AddProject(project);
        CaseSteps caseSteps=new CaseSteps();
        caseSteps.AddCase(project,base_case);
        caseSteps.UpdateCase(project,base_case,update_case);
        caseSteps.DeleteCase(project,update_case);
    }
}
