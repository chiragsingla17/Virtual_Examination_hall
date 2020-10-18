package com.example.fliplearn.network;

import com.google.gson.JsonObject;
import com.example.fliplearn.ui.profile.coins.allOrders.AllOrders;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface APIs {

    @FormUrlEncoded
    @POST("api/mobile/users/otp")
    Call<JsonObject> sendNumber(@Field("phone") String number);

    @FormUrlEncoded
    @POST("api/mobile/users/submitOtp")
    Call<JsonObject> submitOtp(@Field("otp") String otp);

    @FormUrlEncoded
    @POST("api/mobile/users/signUp/google")
    Call<JsonObject> uploadInformation(@Field("phone") String phone,
                                       @Field("address") String address,
                                       @Field("name") String name,
                                       @Field("district") String district,
                                       @Field("token") String token,
                                       @Field("email") String email);

    @GET("api/mobile/users/test")
    Call<JsonObject> isLoggedIn();


    @GET("api/mobile/farmer/allOrders")
    Call<AllOrders> getAllOrders();

}
