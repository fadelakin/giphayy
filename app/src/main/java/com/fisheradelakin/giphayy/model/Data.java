package com.fisheradelakin.giphayy.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Fisher on 9/28/15.
 */
public class Data implements Serializable {
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("image_original_url")
    @Expose
    private String imageOriginalUrl;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("image_mp4_url")
    @Expose
    private String imageMp4Url;
    @SerializedName("image_frames")
    @Expose
    private String imageFrames;
    @SerializedName("image_width")
    @Expose
    private String imageWidth;
    @SerializedName("image_height")
    @Expose
    private String imageHeight;
    @SerializedName("fixed_height_downsampled_url")
    @Expose
    private String fixedHeightDownsampledUrl;
    @SerializedName("fixed_height_downsampled_width")
    @Expose
    private String fixedHeightDownsampledWidth;
    @SerializedName("fixed_height_downsampled_height")
    @Expose
    private String fixedHeightDownsampledHeight;
    @SerializedName("fixed_width_downsampled_url")
    @Expose
    private String fixedWidthDownsampledUrl;
    @SerializedName("fixed_width_downsampled_width")
    @Expose
    private String fixedWidthDownsampledWidth;
    @SerializedName("fixed_width_downsampled_height")
    @Expose
    private String fixedWidthDownsampledHeight;
    @SerializedName("fixed_height_small_url")
    @Expose
    private String fixedHeightSmallUrl;
    @SerializedName("fixed_height_small_still_url")
    @Expose
    private String fixedHeightSmallStillUrl;
    @SerializedName("fixed_height_small_width")
    @Expose
    private String fixedHeightSmallWidth;
    @SerializedName("fixed_height_small_height")
    @Expose
    private String fixedHeightSmallHeight;
    @SerializedName("fixed_width_small_url")
    @Expose
    private String fixedWidthSmallUrl;
    @SerializedName("fixed_width_small_still_url")
    @Expose
    private String fixedWidthSmallStillUrl;
    @SerializedName("fixed_width_small_width")
    @Expose
    private String fixedWidthSmallWidth;
    @SerializedName("fixed_width_small_height")
    @Expose
    private String fixedWidthSmallHeight;

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getImageOriginalUrl() {
        return imageOriginalUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getImageMp4Url() {
        return imageMp4Url;
    }

    public String getImageFrames() {
        return imageFrames;
    }

    public String getImageWidth() {
        return imageWidth;
    }

    public String getImageHeight() {
        return imageHeight;
    }

    public String getFixedHeightDownsampledUrl() {
        return fixedHeightDownsampledUrl;
    }

    public String getFixedHeightDownsampledWidth() {
        return fixedHeightDownsampledWidth;
    }

    public String getFixedHeightDownsampledHeight() {
        return fixedHeightDownsampledHeight;
    }

    public String getFixedWidthDownsampledUrl() {
        return fixedWidthDownsampledUrl;
    }

    public String getFixedWidthDownsampledWidth() {
        return fixedWidthDownsampledWidth;
    }

    public String getFixedWidthDownsampledHeight() {
        return fixedWidthDownsampledHeight;
    }

    public String getFixedHeightSmallUrl() {
        return fixedHeightSmallUrl;
    }

    public String getFixedHeightSmallStillUrl() {
        return fixedHeightSmallStillUrl;
    }

    public String getFixedHeightSmallWidth() {
        return fixedHeightSmallWidth;
    }

    public String getFixedHeightSmallHeight() {
        return fixedHeightSmallHeight;
    }

    public String getFixedWidthSmallUrl() {
        return fixedWidthSmallUrl;
    }

    public String getFixedWidthSmallStillUrl() {
        return fixedWidthSmallStillUrl;
    }

    public String getFixedWidthSmallWidth() {
        return fixedWidthSmallWidth;
    }

    public String getFixedWidthSmallHeight() {
        return fixedWidthSmallHeight;
    }
}
