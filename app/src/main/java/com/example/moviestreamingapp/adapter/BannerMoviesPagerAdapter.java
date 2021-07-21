package com.example.moviestreamingapp.adapter;


import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.moviestreamingapp.MovieDetail;
import com.example.moviestreamingapp.R;
import com.example.moviestreamingapp.models.BannerMovies;

import java.util.List;

public class BannerMoviesPagerAdapter extends PagerAdapter {
Context context;
List<BannerMovies> bannerMoviesList;

    public BannerMoviesPagerAdapter(Context context, List<BannerMovies> bannerMoviesList) {
        this.context = context;
        this.bannerMoviesList = bannerMoviesList;
    }

    @Override
    public int getCount() {
        return bannerMoviesList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view ==object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);

    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.banner_moview_layout,null);

        ImageView bannerImage = view.findViewById(R.id.imageView);

        Glide.with(context).load(bannerMoviesList.get(position).getImageUrl()).into(bannerImage);
        container.addView(view);

        bannerImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MovieDetail.class);
                intent.putExtra("movieID",bannerMoviesList.get(position).getId());
                intent.putExtra("movieName",bannerMoviesList.get(position).getMovieName());
                intent.putExtra("movieImageURL",bannerMoviesList.get(position).getImageUrl());
                intent.putExtra("movieFileURL",bannerMoviesList.get(position).getFileUrl());
                context.startActivity(intent);

            }
        });

        return view;

    }
}

