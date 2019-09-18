package com.example.movie.model;

public class Movie  {
    private String title;
    private String description;
    private int thumbnail;
    private String studio, rating, streamimgLink;
    private int cover;


    public Movie( String title, int thumbnail)
    {
        this.title=title;
        this.thumbnail=thumbnail;
    }
    public Movie( String title, int thumbnail,int cover)
    {
        this.title=title;
        this.thumbnail=thumbnail;
        this.cover=cover;
    }
    public Movie( String title, String description,int thumbnail,String studio,String rating,String streamimgLink)
    {
        this.title=title;
        this.description=description;
        this.thumbnail=thumbnail;
        this.studio=studio;
        this.rating=rating;
        this.streamimgLink=streamimgLink;
    }

    public void setCover(int cover) {
        this.cover = cover;
    }

    public int getCover() {
        return cover;
    }

    public String getTitle() {
        return title;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public String getRating() {
        return rating;
    }

    public String getStreamimgLink() {
        return streamimgLink;
    }

    public String getStudio() {
        return studio;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setStreamimgLink(String streamimgLink) {
        this.streamimgLink = streamimgLink;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }
}
