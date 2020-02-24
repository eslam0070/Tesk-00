package com.eso.tesk;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("GetCity")
    Call<Model> getCity(@Query("CountryID") int country);
    
}
