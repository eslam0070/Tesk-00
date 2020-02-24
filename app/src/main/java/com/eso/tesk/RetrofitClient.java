package com.eso.tesk;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitClient {
    //implementation 'com.squareup.retrofit2:retrofit:2.6.2'
    //implementation 'com.squareup.retrofit2:converter-gson:2.6.2'
    //implementation 'com.squareup.okhttp3:okhttp:4.2.2'
    //implementation 'com.squareup.okhttp3:logging-interceptor:4.2.2'

    public final String BASE_URL = "http://blinkappservices.com/DriverService.asmx/";
    private static RetrofitClient mInstance;
    private Retrofit retrofit;
    public RetrofitClient() {
        Gson gson = new GsonBuilder().setLenient().create();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
    public static synchronized RetrofitClient getInstance() {
        if (mInstance == null) {
            mInstance = new RetrofitClient();
        }
        return mInstance;
    }

    public ApiInterface getApi() {
        return retrofit.create(ApiInterface.class);
    }
}
