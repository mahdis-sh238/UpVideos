package com.univercity.upvideos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;


import static com.univercity.upvideos.MainActivity.EXTRA_CREATOR;
import static com.univercity.upvideos.MainActivity.EXTRA_IMG;
import static com.univercity.upvideos.MainActivity.EXTRA_LANG;
import static com.univercity.upvideos.MainActivity.EXTRA_Likes;
import static com.univercity.upvideos.MainActivity.EXTRA_SUMMERY;
import static com.univercity.upvideos.MainActivity.EXTRA_URL;
import static com.univercity.upvideos.MainActivity.EXTRA_YEAR;

public class Second_Activity extends AppCompatActivity {

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_second_ );

        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra( EXTRA_URL );
        String creatorName = intent.getStringExtra( EXTRA_CREATOR );
        String likeCount = intent.getStringExtra( EXTRA_Likes);
        String year=intent.getStringExtra(EXTRA_YEAR);
        String summery=intent.getStringExtra(EXTRA_SUMMERY);
        String lang=intent.getStringExtra(EXTRA_LANG);
        String Bimg=intent.getStringExtra(EXTRA_IMG);


        ImageView imageView = findViewById( R.id.image_View_Detail );
        TextView textViewCreator = findViewById( R.id.tv_nameMovie );
        TextView textViewLikes = findViewById( R.id.tv_like );
        TextView textViewYear=findViewById( R.id.tv_year_movie );
        TextView textViewSummery=findViewById( R.id.tv_summery );
        TextView textViewLang=findViewById(R.id.tv_langMovie);
        ImageView bimageView=findViewById(R.id.background_img);



        Picasso.with( this ).load( imageUrl ).placeholder(R.drawable.placeholder).fit().centerInside().into( imageView );
        Picasso.with( this ).load( Bimg ).fit().placeholder(R.drawable.placeholder).centerInside().into( bimageView );
        textViewCreator.setText( creatorName );
        textViewLikes.setText("Vote Count : "+likeCount);
        textViewYear.setText( year );
        textViewSummery.setText(summery);
        textViewLang.setText(lang);



    }
}