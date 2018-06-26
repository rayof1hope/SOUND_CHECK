package com.example.android.sound_check;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mBands = new ArrayList <> (  );
    private ArrayList<Integer> mImage = new ArrayList <> (  );
    private ArrayList<String> mSongs = new ArrayList <> (  );
    private Context mContext;

    public RecyclerViewAdapter(Context context, ArrayList <String> songs, ArrayList <String> bands, ArrayList <Integer> image) {
        mBands = bands;
        mImage = image;
        mSongs = songs;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from ( parent.getContext () ).inflate ( R.layout.layout_listitem, parent,false );
        ViewHolder holder = new ViewHolder ( view );
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d ( TAG, "onBindViewHolder: called." );

        Glide.with(mContext)
                .asDrawable ()
                .load(mImage.get(position))
                .into(holder.image);

        holder.bands.setText ( mBands.get ( position ) );
        holder.songs.setText ( mSongs.get ( position ) );

        holder.parentLayout.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Log.d ( TAG, "onClick: clicked on:" + mBands.get(position));

                Toast.makeText ( mContext, mBands.get ( position ), Toast.LENGTH_SHORT ).show ();
            }
        } );

    }

    @Override
    public int getItemCount() {
        return mBands.size ();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView image;
        TextView bands;
        TextView songs;
        RelativeLayout parentLayout;


        public ViewHolder(View itemView) {
            super ( itemView );
            image = itemView.findViewById ( R.id.image );
            bands = itemView.findViewById ( R.id.bands );
            songs = itemView.findViewById ( R.id.songs );
            parentLayout = itemView.findViewById ( R.id.parent_layout );

        }
    }

}
