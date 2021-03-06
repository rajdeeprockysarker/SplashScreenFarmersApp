package com.example.splashscreenfarmersapp.retrofit;

import com.example.splashscreenfarmersapp.model.User;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetroInterface {
    //    @GET("api/unknown")
//    Call<ResponseBody> getResults();

    @GET("/GetApi.php")
    Call<ResponseBody> get(@Query("order_id") int companyNo);

    @FormUrlEncoded
    @POST("/Post.php")
    Call<ResponseBody> createuser(
            @Field("price") String price

    );

    @FormUrlEncoded
    @POST("/PostRegistration.php")
    Call<List<User>> checkMobileNo(
            @Field("mobile_no") String mobile_no

    );
}
