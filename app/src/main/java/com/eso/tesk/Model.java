package com.eso.tesk;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Model {

    @Expose
    @SerializedName("info")
    private List<Info> info = new ArrayList<>();
    @Expose
    @SerializedName("Result")
    private int Result;

    public List<Info> getInfo() {
        return info;
    }

    public void setInfo(List<Info> info) {
        this.info = info;
    }

    public int getResult() {
        return Result;
    }

    public void setResult(int Result) {
        this.Result = Result;
    }

    public static class Info {
        @Expose
        @SerializedName("OverAllResult")
        private int OverAllResult;
        @Expose
        @SerializedName("CityName")
        private String CityName;
        @Expose
        @SerializedName("Id")
        private int Id;

        public int getOverAllResult() {
            return OverAllResult;
        }

        public void setOverAllResult(int OverAllResult) {
            this.OverAllResult = OverAllResult;
        }

        public String getCityName() {
            return CityName;
        }

        public void setCityName(String CityName) {
            this.CityName = CityName;
        }

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }
    }
}
