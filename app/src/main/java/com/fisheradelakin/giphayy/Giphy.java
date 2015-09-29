package com.fisheradelakin.giphayy;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Fisher on 9/28/15.
 */
public class Giphy {

    public static final String API_URL = "http://api.giphy.com/v1/gifs/";

    Retrofit mRetrofit = new Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public GiphyService getSERVICE() {
        return SERVICE;
    }

    GiphyService SERVICE = mRetrofit.create(GiphyService.class);
}
