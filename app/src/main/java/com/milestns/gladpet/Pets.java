package com.milestns.gladpet;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Pets implements Serializable {

    @SerializedName("name")
    private String name;


    @SerializedName("email")
    private String email;

    @SerializedName("website")
    private String website;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

}
