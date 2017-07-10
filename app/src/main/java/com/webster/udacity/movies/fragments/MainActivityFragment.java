package com.webster.udacity.movies.fragments;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.webster.udacity.movies.R;
import com.webster.udacity.movies.interfaces.APIInterface;
import com.webster.udacity.movies.models.Movies;
import com.webster.udacity.movies.network.APIClient;
import com.webster.udacity.movies.util.AppConstants;
import com.webster.udacity.movies.util.RecyclerAdapter;

import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by webster on 10/07/17.
 */

public class MainActivityFragment extends Fragment {

    APIInterface apiInterface;

    ArrayList<Movies> movies;

    RecyclerView recyclerView;

    RecyclerAdapter recyclerAdapter;

    protected View vFragment;

    private static int TYPE_WIFI = 1;

    private static int TYPE_MOBILE = 2;

    private static int TYPE_NOT_CONNECTED = 0;

    private static String currentFilter = "";

    public static MainActivityFragment newInstance(Bundle bundle) {

        MainActivityFragment fragment = new MainActivityFragment();

        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        vFragment = inflater.inflate(R.layout.fragment_main_activity, container, false);

        initData();

        return vFragment;
    }

    private void initData() {
        try {
            recyclerView = (RecyclerView) vFragment.findViewById(R.id.card_recycler_view);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

            if (getConnectivityStatus(getContext()) != TYPE_NOT_CONNECTED) {
                webCall();
            } else {
                Toast.makeText(getContext(),
                        "Check your internet connection", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Log.e("error", e.getMessage());
        }
    }

    private void webCall() {
        apiInterface = APIClient.getClient().create(APIInterface.class);

        Call<Movies> call;

        if (currentFilter.equals("") ||
                currentFilter.equals(AppConstants.TOP_RATED_MOVIE_ENDPOINT)) {
            setCurrentFilter(AppConstants.POPULAR_MOVIE_ENDPOINT);
            call = apiInterface.getPopularMovies(AppConstants.API_KEY);
        } else {
            setCurrentFilter(AppConstants.TOP_RATED_MOVIE_ENDPOINT);
            call = apiInterface.getTopRatedMovies(AppConstants.API_KEY);
        }

        call.enqueue(new Callback<Movies>() {
            @Override
            public void onResponse(Call<Movies> call, Response<Movies> response) {

                try {
                    Movies movies = response.body();

                    recyclerAdapter = new RecyclerAdapter(getContext(), movies);

                    recyclerView.setAdapter(recyclerAdapter);
                } catch (Exception e) {
                    Log.d("error", e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<Movies> call, Throwable t) {
                Log.d("error", t.getMessage());
            }

        });
    }

    public static int getConnectivityStatus(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (null != activeNetwork) {
            if(activeNetwork.getType() == ConnectivityManager.TYPE_WIFI)
                return TYPE_WIFI;

            if(activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)
                return TYPE_MOBILE;
        }
        return TYPE_NOT_CONNECTED;
    }

    private static void setCurrentFilter(String filter) {
        currentFilter = filter;
    }

    public static String getCurrentFilter() {
        return currentFilter;
    }
}
