package com.univercity.upvideos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.net.PortUnreachableException;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ExampleViewHolder> {
    private Context mContext;
    private ArrayList<ExampleItems>mExampleList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener
    {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener)
    {
        mListener=listener;
    }


    public Adapter(Context context,ArrayList<ExampleItems> exampleList)
    {
        mContext=context;
        mExampleList=exampleList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(mContext).inflate(R.layout.items_movie,parent,false);
        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {

        ExampleItems currentItem=mExampleList.get(position);

        String imageUrl=currentItem.getImageUrl();
        String creatorName=currentItem.getCreator();
        int likeCount=currentItem.getLikes();

        holder.mTextViewCreator.setText(creatorName);
        holder.mTextViewLikes.setText("Like : "+likeCount);

        //Glide.with(mContext).load(imageUrl).fitCenter().centerInside().into(holder.mImageView);
        Picasso.with(mContext).load(imageUrl).fit().centerInside().into(holder.mImageView);

    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }


    public class ExampleViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView mImageView;
        public TextView mTextViewCreator;
        public TextView mTextViewLikes;


        public ExampleViewHolder(@NonNull View itemView) {
            super( itemView );

            mImageView=itemView.findViewById(R.id.image_view);
            mTextViewCreator=itemView.findViewById(R.id.text_view_creator);
            mTextViewLikes=itemView.findViewById(R.id.text_view_like);

            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    if(mListener!=null)
                    {
                        int position=getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION)
                        {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });

        }
    }
}
