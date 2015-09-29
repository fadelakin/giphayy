package com.fisheradelakin.giphayy.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Fisher on 9/28/15.
 */
public class Datum implements Serializable {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("bitly_gif_url")
    @Expose
    private String bitlyGifUrl;
    @SerializedName("bitly_url")
    @Expose
    private String bitlyUrl;
    @SerializedName("embed_url")
    @Expose
    private String embedUrl;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("caption")
    @Expose
    private String caption;
    @SerializedName("content_url")
    @Expose
    private String contentUrl;
    @SerializedName("import_datetime")
    @Expose
    private String importDatetime;
    @SerializedName("trending_datetime")
    @Expose
    private String trendingDatetime;
    @SerializedName("images")
    @Expose
    private Images images;

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getBitlyGifUrl() {
        return bitlyGifUrl;
    }

    public String getBitlyUrl() {
        return bitlyUrl;
    }

    public String getEmbedUrl() {
        return embedUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getSource() {
        return source;
    }

    public String getRating() {
        return rating;
    }

    public String getCaption() {
        return caption;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public String getImportDatetime() {
        return importDatetime;
    }

    public String getTrendingDatetime() {
        return trendingDatetime;
    }

    public Images getImages() {
        return images;
    }
}
