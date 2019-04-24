package com.milestns.gladpet.api;


import com.milestns.gladpet.model.ListPets;

import retrofit2.Call;
import retrofit2.http.GET;



public interface ApiService {

    @GET("api/pet/list")
    Call<ListPets> loadPets();

}
