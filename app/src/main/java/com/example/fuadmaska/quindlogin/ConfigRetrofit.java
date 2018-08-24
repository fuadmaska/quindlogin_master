package com.example.fuadmaska.quindlogin;

import com.example.fuadmaska.quindlogin.Response.ApiServices;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConfigRetrofit {
    public static Retrofit retrofitget() {
        return new Retrofit.Builder().baseUrl("https://quind-api.herokuapp.com/v1/user/login/").
                addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiServices getInstanceRetrofit() {
        return ConfigRetrofit.retrofitget().create(ApiServices.class);
    }
}
