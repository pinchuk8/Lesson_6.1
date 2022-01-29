package models;

import com.google.gson.annotations.SerializedName;
import emum.ProjectType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectBuilder {
    private String name;
    private String announcement;
    private boolean isShowAnnouncement;
    @SerializedName(value = "suite_mode")//преобразовывает имя для json
    private int typeOfProject;//преобразовываем тип в int для json
    @SerializedName(value = "is_completed")
    private boolean isCompleted;
    private User user;
}
