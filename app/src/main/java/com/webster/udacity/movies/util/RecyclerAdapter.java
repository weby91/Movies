package com.webster.udacity.movies.util;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.webster.udacity.movies.R;
import com.webster.udacity.movies.models.Movies;

import java.util.ArrayList;

/**
 * Created by webster on 09/07/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private ArrayList<Movies> alMovies;
    private Context context;

    public RecyclerAdapter(Context context, ArrayList<Movies> alMovies) {
        this.context = context;
        this.alMovies = alMovies;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Picasso.with(context)
                .load(alMovies
                        .get(i)
                        .getResults()
                        .get(i).getPosterPath())
                .resize(120, 60).into(viewHolder.img_android);
    }

    @Override
    public int getItemCount() {
        return android_versions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_android;
        ImageView img_android;
        public ViewHolder(View view) {
            super(view);

            tv_android = (TextView)view.findViewById(R.id.tv_android);
            img_android = (ImageView)view.findViewById(R.id.img_android);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivMovie;
        public ViewHolder(View view) {
            super(view);

            ivMovie = (ImageView)view.findViewById(R.id.ivMovie);
        }
    }
}
