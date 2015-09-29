package com.fisheradelakin.giphayy.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Fisher on 9/28/15.
 */
public class RandomGif {
    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("meta")
    @Expose
    private Meta meta;

    public Data getData() {
        return data;
    }

    public Meta getMeta() {
        return meta;
    }
}
