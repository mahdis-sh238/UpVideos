package com.univercity.upvideos;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Adapter.OnItemClickListener {

    public static final String EXTRA_URL="imageUrl";
    public static final String EXTRA_CREATOR="creatorName";
    public static final String EXTRA_Likes="likeCount";
//
    public static final String EXTRA_YEAR="year";
    public static final String EXTRA_SUMMERY="summery";
    public static final String EXTRA_LANG="lang";
    public static final String EXTRA_IMG="B_img";


    private static final String TAG=MainActivity.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private Adapter mAdapter;
    private ArrayList<ExampleItems>mExampleList;
    private RequestQueue mRequestQueue;
    private ProgressBar progressBar;

    String url;
    String Result_url;
    String url_Image="https://image.tmdb.org/t/p/w500";
    String Base_url="https://api.themoviedb.org/3/movie/";
    String Api_Key="?api_key=0ebff7292167899387c245d3463241cd&language=en-US&page=1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        mRecyclerView=findViewById(R.id.RecyclerView);

//        LinearLayoutManager manager=new LinearLayoutManager(this);
//        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        progressBar=findViewById(R.id.progressBar);

        mExampleList=new ArrayList<>();

        mRequestQueue=Volley.newRequestQueue(this);

        getData();
    }


   private void getData()
    {
        //String url="https://api.themoviedb.org/3/movie/popular?api_key=0ebff7292167899387c245d3463241cd&language=en-US&page=1";

        Result_url="popular";
        url=Base_url+Result_url+Api_Key;

        JsonObjectRequest request=new JsonObjectRequest( Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                progressBar.setVisibility( View.GONE );

                if(response!=null) {
                    Log.e( TAG, "on Responce:" + response );

                    try {
                        JSONArray jsonArray = response.getJSONArray( "results" );


                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject res = jsonArray.getJSONObject( i );

                            String CreatorName=null;
                            try {
                                 CreatorName = res.getString( "original_title" );
                            } catch (JSONException e)
                            {
                                e.printStackTrace();
                            }

                            String imageUrl=null;
                            try {
                                imageUrl = res.getString( "poster_path" );
                                imageUrl = url_Image + imageUrl + Api_Key;
                            } catch (JSONException e)
                            {
                                e.printStackTrace();
                            }




                            String likeCount=null;
                            try{
                                likeCount = res.getString( "vote_count" );
                            } catch (JSONException e)
                            {
                                e.printStackTrace();
                            }


                            String summery=null;
                            try{
                                summery = res.getString( "overview" );
                            } catch (JSONException e)
                            {
                            e.printStackTrace();
                            }


                            String year=null;
                            try {
                                 year = res.getString( "release_date" );
                            }catch (JSONException e){
                                e.printStackTrace();
                            }


                            String lang=null;
                            try {
                                lang = res.getString( "original_language" );
                            }catch (JSONException e){
                                e.printStackTrace();
                            }

                            String B_img=null;
                            try {
                                B_img = res.getString( "backdrop_path" );
                                B_img = url_Image + B_img + Api_Key;

                            }catch (JSONException e){
                                e.printStackTrace();
                            }

                            //

                            mExampleList.add( new ExampleItems( imageUrl, CreatorName, likeCount, summery, lang, B_img, year ) );
                        }


                        ///////////////

                        mAdapter = new Adapter( MainActivity.this, mExampleList );
                        mRecyclerView.setAdapter( mAdapter );
                        mAdapter.setOnItemClickListener( MainActivity.this );

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
        },
                new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e( TAG, "on Responce:" + error );


            }
        });

        mRequestQueue.add(request);
    }

    @Override
    public void onItemClick(int position) {
        Intent detailIntent=new Intent(this,Second_Activity.class);
        ExampleItems clickedItem=mExampleList.get(position);

        detailIntent.putExtra(EXTRA_URL,clickedItem.getImageUrl());
        detailIntent.putExtra(EXTRA_CREATOR,clickedItem.getCreator());
        detailIntent.putExtra(EXTRA_Likes,clickedItem.getLikes());
//
        detailIntent.putExtra(EXTRA_YEAR,clickedItem.getYear());
        detailIntent.putExtra(EXTRA_SUMMERY,clickedItem.getSummery());
        detailIntent.putExtra(EXTRA_LANG,clickedItem.getLang());
        detailIntent.putExtra( EXTRA_IMG,clickedItem.getBimg());


        startActivity(detailIntent);


    }
}

