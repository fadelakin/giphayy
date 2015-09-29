package com.fisheradelakin.giphayy.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Fisher on 9/28/15.
 */
public class DownsizedStill {
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("width")
    @Expose
    private String width;
    @SerializedName("height")
    @Expose
    private String height;

    public String getUrl() {
        return url;
    }

    public String getWidth() {
        return width;
    }

    public String getHeight() {
        return height;
    }
}
