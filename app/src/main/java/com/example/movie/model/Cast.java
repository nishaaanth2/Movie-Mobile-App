package com.example.movie.model;

public class Cast {
    String Cast_name;
    int Cast_img;
    public Cast(String Cast_name,int Cast_img)
    {
        this.Cast_img=Cast_img;
        this.Cast_name=Cast_name;
    }

    public int getCast_img() {
        return Cast_img;
    }

    public String getCast_name() {
        return Cast_name;
    }

    public void setCast_img(int cast_img) {
        Cast_img = cast_img;
    }

    public void setCast_name(String cast_name) {
        Cast_name = cast_name;
    }
}
