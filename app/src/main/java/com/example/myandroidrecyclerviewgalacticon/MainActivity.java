package com.example.myandroidrecyclerviewgalacticon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ImageRequester.ImageRequesterResponse {

    private ArrayList<Photo> mPhotosList;
    private ImageRequester mImageRequester;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        mPhotosList = new ArrayList<>();
        mImageRequester = new ImageRequester(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    private void requestPhoto() {

        try {
            mImageRequester.getPhoto();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void receivedNewPhoto(final Photo newPhoto) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mPhotosList.add(newPhoto);
            }
        });

    }
}
