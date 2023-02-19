package ru.ecole39.ext.api.models.responses;

import com.google.gson.annotations.SerializedName;
import ru.ecole39.ext.api.utils.Gsonable;

public final class User implements Gsonable {
    public Integer id;
    @SerializedName("join_time") public Integer joinTime;
    @SerializedName("student_id") public Integer studentId;
    @SerializedName("uch_id") public Integer uchId;
    public String username;
    public String name;
}
