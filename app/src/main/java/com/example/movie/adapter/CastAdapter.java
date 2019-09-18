package com.example.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.movie.R;
import com.example.movie.model.Cast;

import java.util.ArrayList;
import java.util.List;

public class CastAdapter extends RecyclerView.Adapter<CastAdapter.MyCastViewHolder> {
    Context mContext;
    List<Cast> mcdata=new ArrayList<>();
    public CastAdapter(Context mContext,List<Cast> mcdata)
    {
        this.mContext=mContext;
        this.mcdata=mcdata;
    }
    @NonNull
    @Override
    public MyCastViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.item_cast,viewGroup,false);
        return new MyCastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyCastViewHolder myCastViewHolder, int i) {
        myCastViewHolder.ct_name.setText(mcdata.get(i).getCast_name());
        myCastViewHolder.ct_img.setImageResource(mcdata.get(i).getCast_img());


    }

    @Override
    public int getItemCount() {
        return mcdata.size();
    }

    public class MyCastViewHolder extends RecyclerView.ViewHolder{
        public TextView ct_name;
        public ImageView ct_img;
        public MyCastViewHolder(@NonNull View itemView) {
            super(itemView);
            ct_img=itemView.findViewById(R.id.cast_img);
            ct_name=itemView.findViewById(R.id.cast_name);
        }
    }
}
