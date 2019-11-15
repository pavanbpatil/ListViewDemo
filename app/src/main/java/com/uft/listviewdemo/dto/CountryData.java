package com.uft.listviewdemo.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
/**
 * Created by pavan on 15/11/2019.
 */
public class CountryData {

    @Expose
    @SerializedName("rows")
    private List<Rows> rows;
    @Expose
    @SerializedName("title")
    private String title;

    public List<Rows> getRows() {
        return rows;
    }

    public void setRows(List<Rows> rows) {
        this.rows = rows;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
