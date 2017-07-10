package com.webster.udacity.movies.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.webster.udacity.movies.R;

/**
 * Created by webster on 10/07/17.
 */

public class MovieDetailFragment extends Fragment {

    private TextView tvMovieTitle;
    private TextView tvReleaseDate;
    private TextView tvVoteAverage;
    private TextView tvOverview;
    private ImageView ivMovieDetail;
    private View vFragment;
    private Context context;
    private String posterPath;
    private String title;
    private String releaseDate;
    private double voteAverage;
    private String overview;
    private Bundle bundle;

    public MovieDetailFragment newInstance(Bundle bundle) {
        MovieDetailFragment fragment = new MovieDetailFragment();

        fragment.setArguments(bundle);

        this.context = getContext();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        vFragment = inflater.inflate(R.layout.fragment_movie_detail, container, false);

        initData();

        initUi();

        return vFragment;
    }

    private void initData() {
        ivMovieDetail = (ImageView) vFragment.findViewById(R.id.ivMovieDetail);

        tvMovieTitle = (TextView) vFragment.findViewById(R.id.tvMovieTitle);

        tvReleaseDate = (TextView) vFragment.findViewById(R.id.tvReleaseDate);

        tvVoteAverage = (TextView) vFragment.findViewById(R.id.tvVoteAverage);

        tvOverview = (TextView) vFragment.findViewById(R.id.tvOverview);

        this.bundle = getArguments();

        posterPath = this.bundle.getString("poster_path");

        title = this.bundle.getString("title");

        releaseDate = this.bundle.getString("release_date");

        voteAverage = this.bundle.getDouble("vote_average");

        overview = this.bundle.getString("overview");

    }

    private void initUi() {
        Picasso.with(context)
                .load(posterPath)
                .resize(0, 600)
                .into(ivMovieDetail);

        tvMovieTitle.setText("Title: " + title);

        tvReleaseDate.setText("Release date: " + releaseDate);

        tvVoteAverage.setText("Vote Average: " + voteAverage);

        tvOverview.setText("Plot Synopsis: " + overview);

    }


}
