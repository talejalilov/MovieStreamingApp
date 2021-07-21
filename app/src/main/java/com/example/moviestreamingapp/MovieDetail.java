package com.example.moviestreamingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MovieDetail extends AppCompatActivity {
    ImageView movieImage;
    TextView movieName;
    Button playBtn;

    String mId,mImage,mName,mFileUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        movieImage = findViewById(R.id.movie_image);
        movieName= findViewById(R.id.movie_name);
        playBtn = findViewById(R.id.play_button);

        mId = getIntent().getStringExtra("movieID");
        mName = getIntent().getStringExtra("movieName");
        mImage = getIntent().getStringExtra("movieImageURL");
        mFileUrl = getIntent().getStringExtra("movieFileURL");

        Glide.with(this).load(mImage).into(movieImage);
        movieName.setText(mName);

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MovieDetail.this,VideoPlayerActivity.class);
                intent.putExtra("url",mFileUrl);
                startActivity(intent);
            }
        });

    }
}