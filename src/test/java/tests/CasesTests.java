package tests;

import baseEntities.BaseTest;
import dbEntries.CasesTable;
import models.Case;
import models.Project;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import steps.CaseSteps;
import steps.ProjectSteps;
import utils.Randomization;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CasesTests extends BaseTest {
    public static Logger logger = Logger.getLogger(MilestonesTests.class);
    CasesTable casesTable = new CasesTable(dataBaseService);
    @Test
    public void add(){
        casesTable.dropTable();
        casesTable.createTable();
        casesTable.addCase("ABC_case");
        casesTable.addCase("ABC_case");
        casesTable.addCase("ABC_case");
        ResultSet rs = casesTable.getAllCases();
        try {
            while (rs.next()) {
                String name = rs.getString("name");
                logger.info("name: " + name);
            }
        } catch (
                SQLException e) {
            logger.error(e.toString());
        }
    }
    Project project = Project.builder()
            .name("TMS" + Randomization.getRandomString(5))
            .build();

    @Test
    public void CRUD() {
        ResultSet rs3 = casesTable.getCaseById(1);
        Case case_first = null;
        {
            try {
                case_first = Case.builder()
                        .name(rs3.getString(2))
                        .build();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        ResultSet rs4 = casesTable.getCaseById(2);
        Case case_second = null;
        {
            try {
                case_second= Case.builder()
                        .name(rs4.getString(2))
                        .build();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        ProjectSteps projectSteps=new ProjectSteps();
        projectSteps.AddProject(project);
        CaseSteps caseSteps=new CaseSteps();
        caseSteps.AddCase(project,case_first);
        caseSteps.UpdateCase(project,case_first,case_second);
        caseSteps.DeleteCase(project,case_second);
    }
}
