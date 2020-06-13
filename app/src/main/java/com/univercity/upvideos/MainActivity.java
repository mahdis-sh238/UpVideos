package com.univercity.upvideos;
import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private Adapter mAdapter;
    private ArrayList<ExampleItems>mExampleList;
    private RequestQueue mRequestQueue;
    private ProgressBar progressBar;

    String url;
    String Result_url;
    String url_Image="https://image.tmdb.org/t/p/w500";
    String Base_url="https://api.themoviedb.org/3/movie/";
    String Api_Key="?api_key=0ebff7292167899387c245d3463241cd";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        mRecyclerView=findViewById(R.id.recycle_rview);
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

                progressBar.setVisibility(View.GONE);
                try {
                    JSONArray jsonArray=response.getJSONArray("results");

                    for (int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject res=jsonArray.getJSONObject(i);

                        String CreatorName=res.getString("original_title");
                        String imageUrl=res.getString("poster_path");
                        imageUrl=url_Image+imageUrl+Api_Key;
                        int likeCount=res.getInt("vote_count");

                        mExampleList.add(new ExampleItems(imageUrl,CreatorName,likeCount));
                    }

                    mAdapter=new Adapter(MainActivity.this,mExampleList);
                    mRecyclerView.setAdapter(mAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mRequestQueue.add(request);
    }
}

