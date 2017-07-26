package com.example.myandroidrecyclerviewgalacticon;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter <RecyclerAdapter.PhotoHolder>{

    private ArrayList<Photo> mPhotos;

    public RecyclerAdapter(ArrayList<Photo> photos) {
        mPhotos = photos;
    }

    @Override
    public RecyclerAdapter.PhotoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.PhotoHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mPhotos.size();
    }

    //1
    public static class PhotoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //2
        private ImageView mItemImage;
        private TextView mItemDate;
        private TextView mItemDescription;
        private Photo mPhoto;

        //3
        private static final String PHOTO_KEY = "PHOTO";

        //4
        public PhotoHolder(View v) {
            super(v);

            mItemImage = v.findViewById(R.id.item_image);
            mItemDate = v.findViewById(R.id.item_date);
            mItemDescription = v.findViewById(R.id.item_description);
            v.setOnClickListener(this);
        }

        //5
        @Override
        public void onClick(View v) {
            Log.d("RecyclerView", "CLICK!");
        }
    }

}
