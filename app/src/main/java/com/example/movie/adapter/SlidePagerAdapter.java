package com.example.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.movie.R;
import com.example.movie.model.Slide;

import java.util.List;

public class SlidePagerAdapter extends PagerAdapter {

    private Context mContext;
    private List<Slide> mlist;

    public SlidePagerAdapter(Context mContext,List<Slide> mlist)
    {
        this.mContext=mContext;
        this.mlist=mlist;
    }
    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater inflater=(LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View slideLayout=inflater.inflate(R.layout.slider_item,null);

        ImageView sliceImg= slideLayout.findViewById(R.id.slide_img);
        TextView slidetext= slideLayout.findViewById(R.id.slite_title);
        sliceImg.setImageResource(mlist.get(position).getImage());
        slidetext.setText(mlist.get(position).getTitle());
        container.addView(slideLayout);
        return slideLayout;

    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {

        return view == o;
    }
}
