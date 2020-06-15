package com.univercity.upvideos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
        int likeCount = intent.getIntExtra( EXTRA_Likes, 0 );
        //
            String year=intent.getStringExtra(EXTRA_YEAR);
            String summery=intent.getStringExtra(EXTRA_SUMMERY);
            String lang=intent.getStringExtra(EXTRA_LANG);
            String Bimg=intent.getStringExtra(EXTRA_IMG);
        //

        ImageView imageView = findViewById( R.id.image_View_Detail );
        TextView textViewCreator = findViewById( R.id.tv_nameMovie );
        TextView textViewLikes = findViewById( R.id.tv_like );
        //
            TextView textViewYear=findViewById( R.id.tv_year_Movie );
            TextView textViewSummery=findViewById( R.id.tv_summery );
            TextView textViewLang=findViewById(R.id.tv_langMovie);
            ImageView bimageView=findViewById(R.id.background_img);

            //

        Picasso.with( this ).load( imageUrl ).fit().centerInside().into( imageView );
        Picasso.with( this ).load( Bimg ).fit().centerInside().into( bimageView );
        textViewCreator.setText( creatorName );
        textViewLikes.setText( "like : " + likeCount );

        //
            textViewYear.setText(year);
            textViewSummery.setText(summery);
            textViewLang.setText(lang);
        //


    }
}