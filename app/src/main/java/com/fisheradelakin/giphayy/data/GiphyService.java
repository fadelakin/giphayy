package com.fisheradelakin.giphayy.data;

import com.fisheradelakin.giphayy.model.Gif;
import com.fisheradelakin.giphayy.model.RandomGif;

import retrofit.Call;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by Fisher on 9/28/15.
 */
public interface GiphyService {

    // search all giphy gifs for a word or phrase
    @GET("search?limit=100")
    Call<Gif> search(@Query("q") String query, @Query("api_key") String apiKey);

    // get meta-data for a gif using gif id
    @GET("{gif_id}")
    Call<Gif> getDetailGif(@Path("gif_id") String gifId, @Query("api_key") String apiKey, Callback callback);

    // translate term into a gif
    @GET("translate")
    Call<Gif> translateSearch(@Query("s") String s);

    // get a random gif from giphy
    @GET("random")
    Call<RandomGif> getRandomGif(@Query("api_key") String apiKey);

    // get a list of gifs from trending section of giphy
    Call<Gif> getTrendingGifs(@Query("api_key") String apiKey);
}
