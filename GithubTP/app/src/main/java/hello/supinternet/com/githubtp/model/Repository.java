package hello.supinternet.com.githubtp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by user on 02/02/2018.
 */

public class Repository {
    private String name;

    @SerializedName("full_name")
    private String fullName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString(){
        return "Repository{" +
                "name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                "}";
    }
}
