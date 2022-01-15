package models;

import core.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Random;

public class Project {
    private String project_name;
    private String announcement;
    protected By type1 = By.id("suite_mode_single");
    protected By type2 = By.id("suite_mode_single_baseline");
    protected By type3 = By.id("suite_mode_multi");



    public Project(String project_name, String announcement) {
        this.project_name = project_name;
        this.announcement = announcement;
    }

    public Project() {
    }

    public String getProject_name() {
        return project_name;
    }

    public Project setProject_name(String project_name) {
        this.project_name = project_name;
        return this;
    }

    public String getAnnouncement() {
        return announcement;
    }
    public Project setAnnouncement(String announcement) {
        this.announcement = announcement;
        return this;
    }

    public By getType1() {
        return type1;
    }

    public void setType1(By type1) {
        this.type1 = type1;
    }

    public By getType2() {
        return type2;
    }

    public void setType2(By type2) {
        this.type2 = type2;
    }

    public By getType3() {
        return type3;
    }

    public void setType3(By type3) {
        this.type3 = type3;
    }
    public static void Number (String[]args){
        int min=1;
        int max=3;
        int diff=max-min;
        Random random=new Random();
        int number = random.nextInt(diff+1)+min;
    }
    public void chooseProjectType(){
        int min=1;
        int max=3;
        int diff=max-min;
        Random random=new Random();
        int number = random.nextInt(diff+1)+min;
            switch (number) {
                case  1:
                    Project project1=new Project();
                    setProject_name(ReadProperties.getProject_name1());
                    setAnnouncement(ReadProperties.getAnnouncement2());
                    setType1(type1);
                    break;
                case 2:
                    Project project2=new Project();
                    setProject_name(ReadProperties.getProject_name2());
                    setAnnouncement(ReadProperties.getAnnouncement2());
                    setType2(type2);
                    break;
                case 3:
                    Project project3=new Project();
                    setProject_name(ReadProperties.getProject_name3());
                    setAnnouncement(ReadProperties.getAnnouncement3());
                    setType3(type3);
                    break;

                    default:
                    System.out.println("Проект не создан");
                    break;
            }
        }
    }

