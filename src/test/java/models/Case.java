package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Case {
    //required
    private int section_id;
    private String title;
    //not required
    private Integer estimate;
    private Integer milestone_id;
   private String refs;
}
