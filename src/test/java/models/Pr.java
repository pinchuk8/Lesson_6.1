package models;


public class Pr {
    private String project_name;
    private String announcement;

    public Pr(String project_name, String announcement) {
        this.project_name = project_name;
        this.announcement = announcement;
    }

    public Pr() {
    }

    public String getProject_name() {
        return project_name;
    }

    public Pr setProject_name(String project_name) {
        this.project_name = project_name;
        return this;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public Pr setAnnouncement(String announcement) {
        this.announcement = announcement;
        return this;
    }

}
