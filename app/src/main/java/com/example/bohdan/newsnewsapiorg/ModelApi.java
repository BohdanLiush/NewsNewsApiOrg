package com.example.bohdan.newsnewsapiorg;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ModelApi {

    @GET("top-headlines?apiKey=3854d116d20c4a14ba694dae41d898f6")
    Call<Model> idsInfo(@Query("sources") String number);


}
