package com.example.splashscreenfarmersapp.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class POSTCardService {
    private Retrofit retrofit = null;


    public RetroInterface getAPI() {
        String BASE_URL = "https://framerapp.000webhostapp.com/";

        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(RetroInterface.class);
    }
}