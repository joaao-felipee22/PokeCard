package com.example.pokelist.model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetApi {

    @GET("pokemon")
    Call<PokeList> getAllCards();
}
