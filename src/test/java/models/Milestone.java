package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Milestone {
    private boolean is_completed;
    private boolean is_started;
    private int limit;
    private int offset;
    //required
    private String name;
    //not required
    private String description;
    private int due_on;
    private  Integer parent_id;
    private String refs;
    private int start_on;
}
