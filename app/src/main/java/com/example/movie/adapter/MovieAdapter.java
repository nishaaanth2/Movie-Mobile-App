package com.example.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.movie.model.Movie;
import com.example.movie.R;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    Context mContext;
    List<Movie> movieList=new ArrayList<>();
    MovieItemClickListener movieItemClickListener;
    public MovieAdapter(Context mContext,List<Movie> movieList,MovieItemClickListener listener)
    {
        this.mContext=mContext;
        this.movieList=movieList;
        movieItemClickListener=listener;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.item_movie,viewGroup,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.movie_title.setText(movieList.get(i).getTitle());
        myViewHolder.movie_image.setImageResource(movieList.get(i).getThumbnail());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView movie_title;
        ImageView movie_image;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            movie_image=itemView.findViewById(R.id.item_mov_img);
            movie_title=itemView.findViewById(R.id.item_mov_title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    movieItemClickListener.onMovieClick(movieList.get(getAdapterPosition()),movie_image);
                }
            });
        }
    }
}
