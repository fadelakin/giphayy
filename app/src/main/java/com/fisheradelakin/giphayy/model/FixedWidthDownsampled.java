package com.fisheradelakin.giphayy.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Fisher on 9/28/15.
 */
public class FixedWidthDownsampled implements Serializable {
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("width")
    @Expose
    public String width;
    @SerializedName("height")
    @Expose
    public String height;
    @SerializedName("size")
    @Expose
    public String size;
    @SerializedName("webp")
    @Expose
    public String webp;
    @SerializedName("webp_size")
    @Expose
    public String webpSize;

    public String getUrl() {
        return url;
    }

    public String getWidth() {
        return width;
    }

    public String getHeight() {
        return height;
    }

    public String getSize() {
        return size;
    }

    public String getWebp() {
        return webp;
    }

    public String getWebpSize() {
        return webpSize;
    }
}
