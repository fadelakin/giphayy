package com.fisheradelakin.giphayy.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Fisher on 9/28/15.
 */
public class Pagination implements Serializable {
    @SerializedName("total_count")
    @Expose
    public Integer totalCount;
    @SerializedName("count")
    @Expose
    public Integer count;
    @SerializedName("offset")
    @Expose
    public Integer offset;

    public Integer getTotalCount() {
        return totalCount;
    }

    public Integer getCount() {
        return count;
    }

    public Integer getOffset() {
        return offset;
    }
}
