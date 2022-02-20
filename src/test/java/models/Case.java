package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Case {
    private String name;
    private String precondition;
}
