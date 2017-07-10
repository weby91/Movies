package com.webster.udacity.movies.util;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.webster.udacity.movies.MainActivity;
import com.webster.udacity.movies.R;
import com.webster.udacity.movies.fragments.MovieDetailFragment;
import com.webster.udacity.movies.models.Movies;

import java.util.ArrayList;

/**
 * Created by webster on 09/07/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private Movies alMovies;
    private Context context;
    private View view;

    public RecyclerAdapter(Context context, Movies alMovies) {
        this.context = context;
        this.alMovies = alMovies;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
        Picasso.with(context)
                .load(AppConstants.BASE_URL + AppConstants.W185 + alMovies
                        .getResults()
                        .get(i).getPosterPath())
                .resize(0, 600)
                .into(viewHolder.ivMovie);

        viewHolder.ivMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();

                Bundle bundle = new Bundle();

                bundle.putString("title", alMovies.getResults().get(position).getTitle());
                bundle.putString("release_date",
                        alMovies.getResults().get(position).getReleaseDate());
                bundle.putString("poster_path", AppConstants.BASE_URL + AppConstants.W185 +
                        alMovies.getResults().get(position).getPosterPath());
                bundle.putDouble("vote_average",
                        alMovies.getResults().get(position).getVoteAverage());
                bundle.putString("overview",
                        alMovies.getResults().get(position).getOverview());

                MainActivity mainActivity = (MainActivity) v.getContext();
                MovieDetailFragment movieDetailFragment = new MovieDetailFragment();

                mainActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.flContainer, movieDetailFragment.newInstance(bundle))
                        .addToBackStack(null)
                        .commit();

            }
        });
    }

    @Override
    public int getItemCount() {
        return alMovies.getResults().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivMovie;

        public ViewHolder(View view) {
            super(view);

            ivMovie = (ImageView) view.findViewById(R.id.ivMovie);
        }
    }
}
