package com.fisheradelakin.giphayy.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Fisher on 9/28/15.
 */
public class Images implements Serializable {
    @SerializedName("fixed_height")
    @Expose
    public FixedHeight fixedHeight;
    @SerializedName("fixed_height_still")
    @Expose
    public FixedHeightStill fixedHeightStill;
    @SerializedName("fixed_height_downsampled")
    @Expose
    public FixedHeightDownsampled fixedHeightDownsampled;
    @SerializedName("fixed_width")
    @Expose
    public FixedWidth fixedWidth;
    @SerializedName("fixed_width_still")
    @Expose
    public FixedWidthStill fixedWidthStill;
    @SerializedName("fixed_width_downsampled")
    @Expose
    public FixedWidthDownsampled fixedWidthDownsampled;
    @SerializedName("fixed_height_small")
    @Expose
    public FixedHeightSmall fixedHeightSmall;
    @SerializedName("fixed_height_small_still")
    @Expose
    public FixedHeightSmallStill fixedHeightSmallStill;
    @SerializedName("fixed_width_small")
    @Expose
    public FixedWidthSmall fixedWidthSmall;
    @SerializedName("fixed_width_small_still")
    @Expose
    public FixedWidthSmallStill fixedWidthSmallStill;
    @SerializedName("downsized")
    @Expose
    public Downsized downsized;
    @SerializedName("downsized_still")
    @Expose
    public DownsizedStill downsizedStill;
    @SerializedName("downsized_large")
    @Expose
    public DownsizedLarge downsizedLarge;
    @SerializedName("original")
    @Expose
    public Original original;
    @SerializedName("original_still")
    @Expose
    public OriginalStill originalStill;

    public FixedHeight getFixedHeight() {
        return fixedHeight;
    }

    public FixedHeightStill getFixedHeightStill() {
        return fixedHeightStill;
    }

    public FixedHeightDownsampled getFixedHeightDownsampled() {
        return fixedHeightDownsampled;
    }

    public FixedWidth getFixedWidth() {
        return fixedWidth;
    }

    public FixedWidthStill getFixedWidthStill() {
        return fixedWidthStill;
    }

    public FixedWidthDownsampled getFixedWidthDownsampled() {
        return fixedWidthDownsampled;
    }

    public FixedHeightSmall getFixedHeightSmall() {
        return fixedHeightSmall;
    }

    public FixedHeightSmallStill getFixedHeightSmallStill() {
        return fixedHeightSmallStill;
    }

    public FixedWidthSmall getFixedWidthSmall() {
        return fixedWidthSmall;
    }

    public FixedWidthSmallStill getFixedWidthSmallStill() {
        return fixedWidthSmallStill;
    }

    public Downsized getDownsized() {
        return downsized;
    }

    public DownsizedStill getDownsizedStill() {
        return downsizedStill;
    }

    public DownsizedLarge getDownsizedLarge() {
        return downsizedLarge;
    }

    public Original getOriginal() {
        return original;
    }

    public OriginalStill getOriginalStill() {
        return originalStill;
    }
}
