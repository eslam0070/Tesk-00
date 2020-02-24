package com.eso.tesk;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<Model> models = new ArrayList<>();
    private RecyclerView mRecyclerView;
    InfoAdapter infoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*RetrofitClient.getInstance().getApi().getCity(100).enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                if (response.body() != null && response.isSuccessful()){
                    Model info = response.body();
                    mTexrt.setText();
                }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

            }
        });*/
        /*mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mRecyclerView.setHasFixedSize(true);*/
        RetrofitClient.getInstance().getApi().getCity(100).enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                Toast.makeText(MainActivity.this, response.body().getInfo().get(0).getCityName(), Toast.LENGTH_SHORT).show();
                Log.i("Result",response.body().getInfo().get(0).getCityName());
                /*infoAdapter = new InfoAdapter(MainActivity.this,models);
                mRecyclerView.setAdapter(infoAdapter);*/
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

            }
        });

    }
}
