package com.fisheradelakin.giphayy.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fisher on 9/28/15.
 */
public class Gif {
    @SerializedName("data")
    @Expose
    public List<Datum> data = new ArrayList<Datum>();
    @SerializedName("meta")
    @Expose
    public Meta meta;
    @SerializedName("pagination")
    @Expose
    public Pagination pagination;

    public List<Datum> getData() {
        return data;
    }

    public Meta getMeta() {
        return meta;
    }

    public Pagination getPagination() {
        return pagination;
    }
}
