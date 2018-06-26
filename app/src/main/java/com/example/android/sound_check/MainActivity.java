package com.example.android.sound_check;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";

    //Images
    int[] image = {
            R.drawable.believe,
            R.drawable.corridor,
            R.drawable.wild,
            R.drawable.escape,
            R.drawable.helper,
            R.drawable.reef,
            R.drawable.streak,
            R.drawable.bridge};



    //variables
    private ArrayList<Integer> mImage = new ArrayList<> ();
    private ArrayList<String> mBands = new ArrayList<> ();
    private ArrayList<String> mSongs = new ArrayList<> ();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        Log.d ( TAG, "onCreate: started." );

        initImage ();
    }

    private void initImage() {
        Log.d ( TAG, "initImage: images." );

        mImage.add ( R.drawable.believe );
        mBands.add ( "Castings" );
        mSongs.add ( "Believer" );

        mImage.add ( R.drawable.corridor );
        mBands.add ( "Crowns" );
        mSongs.add ( "The Corridor" );

        mImage.add ( R.drawable.wild );
        mBands.add ( "Riders" );
        mSongs.add ( "The Wild" );

        mImage.add ( R.drawable.escape );
        mBands.add ( "Runners" );
        mSongs.add ( "Escape It All" );

        mImage.add ( R.drawable.helper );
        mBands.add ( "The Help" );
        mSongs.add ( "Reach" );

        mImage.add ( R.drawable.reef );
        mBands.add ( "Ocean 5" );
        mSongs.add ( "The View" );

        mImage.add ( R.drawable.streak );
        mBands.add ( "Chargers" );
        mSongs.add ( "The Streak" );

        mImage.add ( R.drawable.bridge );
        mBands.add ( "The Way" );
        mSongs.add ( "Bridge The Gap" );

        initRecyclerView ();

    }

    private void initRecyclerView() {
        Log.d ( TAG, "initRecyclerView: init recyclerView" );
        RecyclerView recyclerView = findViewById ( R.id.recycler_view );
        RecyclerViewAdapter adapter = new RecyclerViewAdapter ( this, mBands, mSongs, mImage );
        recyclerView.setAdapter ( adapter );
        recyclerView.setLayoutManager ( new LinearLayoutManager ( this ) );
    }
}
