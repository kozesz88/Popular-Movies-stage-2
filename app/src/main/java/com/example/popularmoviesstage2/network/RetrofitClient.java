package com.example.popularmoviesstage2.network;

import android.content.Context;


import com.example.popularmoviesstage2.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static MovieService service;

    public static MovieService getRetrofitClient(Context context) {

        if (service == null) {

            Gson gson = new GsonBuilder().create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(context.getString(R.string.BASE_URL))
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            service = retrofit.create(MovieService.class);

        }

        return service;
    }

}
