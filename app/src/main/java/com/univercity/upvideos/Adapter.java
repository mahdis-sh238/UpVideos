package com.univercity.upvideos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private String[]items;

    public Adapter(Context context, String[] items) {
        this.context = context;
        this.items = items;
    }




    class ViewHolder extends RecyclerView.ViewHolder{

        TextView titleMovie;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titleMovie=itemView.findViewById(R.id.title_movie);
        }

        void bindView(String movies){
            titleMovie.setText(movies);
        }
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View v=inflater.inflate(R.layout.items_movies,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ((ViewHolder)holder).bindView(items[position]);
    }

    @Override
    public int getItemCount() {
        return items.length;
    }
}
