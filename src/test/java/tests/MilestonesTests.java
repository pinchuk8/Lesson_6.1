package tests;

import baseEntities.BaseTest;
import dbEntries.MilestonesTable;
import models.Milestone;
import models.Project;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import steps.MilestoneSteps;
import steps.ProjectSteps;
import utils.Randomization;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MilestonesTests extends BaseTest {
    public static Logger logger = Logger.getLogger(MilestonesTests.class);
    MilestonesTable milestonesTable = new MilestonesTable(dataBaseService);
    @Test
    public void add(){
        milestonesTable.dropTable();
        milestonesTable.createTable();
        milestonesTable.addMilestone("ABC_milestone", "description");
        milestonesTable.addMilestone("BCD_milestone", "description");
        milestonesTable.addMilestone("CDE_milestone", "description");
        ResultSet rs = milestonesTable.getAllMilestones();
        try {
            while (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                logger.info("firstname: " + name);
                logger.info("lastname: " + description);

            }
        } catch (
                SQLException e) {
            logger.error(e.toString());
        }
    }

   @Test
    public void crud() {
       Project project = Project.builder()
               .name("TMS" + Randomization.getRandomString(5))
               .build();

       ResultSet rs1 = milestonesTable.getMilestoneById(1);
       Milestone milestone_first = null;
       {
           try {
               milestone_first= Milestone.builder()
                       .name(rs1.getString(2))
                       .description(rs1.getString(3))
                       .build();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
       ResultSet rs2 = milestonesTable.getMilestoneById(2);
       Milestone milestone_second = null;
       {
           try {
               milestone_second= Milestone.builder()
                       .name(rs2.getString(2))
                       .description(rs2.getString(3))
                       .build();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
        ProjectSteps projectSteps=new ProjectSteps();
        projectSteps.AddProject(project);
        MilestoneSteps milestoneSteps = new MilestoneSteps();
        milestoneSteps.addMilestone(project, milestone_first);
        milestoneSteps.UpdateMilestone(milestone_first, milestone_second);
        milestoneSteps.DeleteMilestone(project, milestone_second);
    }
}