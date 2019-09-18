package com.example.movie.ui;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.movie.R;
import com.example.movie.adapter.CastAdapter;
import com.example.movie.model.Cast;

import java.util.ArrayList;
import java.util.List;

public class MovieDetialActivity extends AppCompatActivity {

    private ImageView mov_thumb,mov_cover_img;
    private TextView tv_title,tv_description;
    private FloatingActionButton floatingActionButton;
    private RecyclerView CastRecyclerview;
    List<Cast> mcdata=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        iniViwqs();
        castsetadap();

    }

    private void castsetadap() {
        mcdata.add(new Cast("Robert Downey Jr.",R.drawable.cast_robert));
        mcdata.add(new Cast("Benedict Cumberbatch",R.drawable.cast_benedict));
        mcdata.add(new Cast("Chris Hemsworth",R.drawable.cast_chris));
        mcdata.add(new Cast("Chris Evans",R.drawable.cast_cris_evan));
        mcdata.add(new Cast("Don Cheadle",R.drawable.cast_donald));
        mcdata.add(new Cast("Scarlett Johansson",R.drawable.cast_scarlett));
        mcdata.add(new Cast("Mark Ruffalo",R.drawable.cast_mark));
        mcdata.add(new Cast("Jeremy Renner",R.drawable.cast_jeremy));
        CastAdapter castAdapter=new CastAdapter(getApplicationContext(),mcdata);
        CastRecyclerview.setAdapter(castAdapter);
        CastRecyclerview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }

    void iniViwqs()
    {
        CastRecyclerview=findViewById(R.id.rv_cast);
        mov_thumb=findViewById(R.id.detail_mov);
        floatingActionButton=findViewById(R.id.floatingActionButtonnn);
        tv_title=findViewById(R.id.detail_mov_title);
        tv_description=findViewById(R.id.details_mov_desc);
        mov_cover_img=findViewById(R.id.details_mov_cover);
        String movie_title=getIntent().getExtras().getString("titlecode");
        int movie_image_waterwash=getIntent().getExtras().getInt("imgcode");
        int movie_image_cover=getIntent().getExtras().getInt("imgcover");
        mov_thumb.setImageResource(movie_image_waterwash);
        Glide.with(this).load(movie_image_cover).into(mov_cover_img);
        tv_title.setText(movie_title);
        getSupportActionBar().setTitle(movie_title);

        mov_cover_img.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_animation));
        floatingActionButton.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_animation));

    }
}
