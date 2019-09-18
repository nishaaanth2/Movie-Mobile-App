package com.example.movie.model;

public class Slide {
    private  int image;
    private String Title;

    public Slide(int image, String Title)
    {
        this.image=image;
        this.Title=Title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
