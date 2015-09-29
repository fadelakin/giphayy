package com.fisheradelakin.giphayy.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Fisher on 9/28/15.
 */
public class FixedHeightDownsampled {
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("width")
    @Expose
    private String width;
    @SerializedName("height")
    @Expose
    private String height;
    @SerializedName("size")
    @Expose
    private String size;
    @SerializedName("webp")
    @Expose
    private String webp;
    @SerializedName("webp_size")
    @Expose
    private String webpSize;

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
