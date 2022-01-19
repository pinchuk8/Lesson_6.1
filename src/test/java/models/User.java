package models;

import lombok.*;

//@Data
@Builder
@ToString
@EqualsAndHashCode
@Getter
@Setter
//@ToString(exclude = "email") исключить при сравнении поле email
public class User {
    private String email;
    private String password;

}


