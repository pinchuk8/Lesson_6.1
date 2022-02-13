package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Case {
    private int id;
    private String name;
}
