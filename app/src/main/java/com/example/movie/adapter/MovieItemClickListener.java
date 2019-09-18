package com.example.movie.adapter;

import android.widget.ImageView;

import com.example.movie.model.Movie;

public interface MovieItemClickListener {

    void onMovieClick(Movie movie, ImageView movieImageView);
}
