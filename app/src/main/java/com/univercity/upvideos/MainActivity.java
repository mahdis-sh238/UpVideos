package com.univercity.upvideos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.icu.text.IDNA;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.android.volley.Request.*;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewPooster;
    private RequestQueue mQueue;
    private ImageView img;
    private ProgressBar progressBar;
    private TextView txt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txt=findViewById(R.id.tv_TitelRecyclerView);
        progressBar=findViewById(R.id.progressBar);
        img=findViewById(R.id.imageView3);
        recyclerViewPooster=findViewById(R.id.show_pooster);

        mQueue= Volley.newRequestQueue(this);
        recyclerViewPooster.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
       // recyclerViewPooster.setAdapter(new Adapter(this,);

         getData();

    }

    private void getData() {

        String url="https://api.themoviedb.org/3/movie/popular?api_key=0ebff7292167899387c245d3463241cd&language=en-US&page=1";

        JsonObjectRequest request=new JsonObjectRequest(Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                progressBar.setVisibility(View.GONE);
                try {
                    JSONArray jsonArray=response.getJSONArray("results");
                    for (int i=0;i<jsonArray.length();i++){
                        JSONObject res=jsonArray.getJSONObject(i);
                        String original_title=res.getString("original_title");


                    }
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
        mQueue.add(request);
    }
}
