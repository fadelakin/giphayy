package com.fisheradelakin.giphayy.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Fisher on 9/28/15.
 */
public class FixedWidth {
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
    @SerializedName("mp4")
    @Expose
    public String mp4;
    @SerializedName("mp4_size")
    @Expose
    public String mp4Size;
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

    public String getMp4() {
        return mp4;
    }

    public String getMp4Size() {
        return mp4Size;
    }

    public String getWebp() {
        return webp;
    }

    public String getWebpSize() {
        return webpSize;
    }
}
