package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Data
@Builder
public class User {
    @Expose
    private String name;
    private String email;
    private String password;
    @SerializedName(value = "is_active")
    private boolean isActive;
    @SerializedName(value="role_id")
    private int roleId;
    private String role;

}


