package com.example.movie.ui;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.example.movie.model.Movie;
import com.example.movie.adapter.MovieAdapter;
import com.example.movie.adapter.MovieItemClickListener;
import com.example.movie.R;
import com.example.movie.model.Slide;
import com.example.movie.adapter.SlidePagerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class HomeActivity extends AppCompatActivity implements MovieItemClickListener {
    private List<Slide> lstSlide;
    private ViewPager slidepager;
    private TabLayout indicator;
    private RecyclerView mov_recycle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        slidepager=findViewById(R.id.slider_pager);
        indicator=findViewById(R.id.indicator);
        mov_recycle=findViewById(R.id.rv_mov);


        lstSlide=new ArrayList<>();
        lstSlide.add(new Slide(R.drawable.slide_black,"Black Panther \nMarvel Studio"));
        lstSlide.add(new Slide(R.drawable.slide_constantine,"Constantine \nLucifer will be back"));
        lstSlide.add(new Slide(R.drawable.slide_black,"Black Panther \nMarvel Studio"));
        lstSlide.add(new Slide(R.drawable.slide_constantine,"Constantine \nLucifer will be back"));
        lstSlide.add(new Slide(R.drawable.slide_black,"Black Panther \nMarvel Studio"));
        lstSlide.add(new Slide(R.drawable.slide_constantine,"Constantine \nLucifer will be back"));
        SlidePagerAdapter adapter = new SlidePagerAdapter(this,lstSlide);
        slidepager.setAdapter(adapter);
        Timer timer=new Timer();
        timer.scheduleAtFixedRate(new HomeActivity.SliderTimer(),4000,6000);
        indicator.setupWithViewPager(slidepager,true);

        List<Movie> movieList=new ArrayList<>();
        movieList.add(new Movie("Aladdin",R.drawable.mov_ala,R.drawable.cover_god));
        movieList.add(new Movie("Annabella",R.drawable.mov_anna,R.drawable.cover_annabelle));
        movieList.add(new Movie("Dark Phownix",R.drawable.mov_dark));
        movieList.add(new Movie("Yesterday",R.drawable.mov_yesy));
        movieList.add(new Movie("Spiderman",R.drawable.mov_far,R.drawable.cover_spi));
        movieList.add(new Movie("Godzilla",R.drawable.mov_god,R.drawable.cover_god));
        MovieAdapter movieAdapter=new MovieAdapter(getApplicationContext(),movieList,this);
        mov_recycle.setAdapter(movieAdapter);
        mov_recycle.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));



    }

    @Override
    public void onMovieClick(Movie movie, ImageView movieImageView) {

//        Toast.makeText(this, "click uhh", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,MovieDetialActivity.class);
        intent.putExtra("titlecode",movie.getTitle());
        intent.putExtra("imgcode",movie.getThumbnail());
        intent.putExtra("imgcover",movie.getCover());

        ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(HomeActivity.this,movieImageView,"sharedNamez");
        startActivity(intent,options.toBundle());
    }

    class SliderTimer extends TimerTask
    {

        @Override
        public void run() {
            HomeActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(slidepager.getCurrentItem()<lstSlide.size()-1)
                    {
                        slidepager.setCurrentItem(slidepager.getCurrentItem()+1);
                    }
                    else
                        slidepager.setCurrentItem(0);
                }
            });
        }
    }

}
