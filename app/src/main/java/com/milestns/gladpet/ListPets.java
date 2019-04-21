package com.milestns.gladpet;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ListPets implements Serializable {

    @SerializedName("list")
    private List<Pets> petsList;

    public List<Pets> getListPets() {
        return petsList;
    }

    public void setPetsList(List<Pets> petsList) {
        this.petsList = petsList;
    }



}
