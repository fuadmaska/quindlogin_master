package com.example.fuadmaska.quindlogin.Response;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiServices {
    @FormUrlEncoded
    @POST("login")
    Call<ResponseLogin> request_login(
            @Field("email") String email,
            @Field("password") String password

    );
}
