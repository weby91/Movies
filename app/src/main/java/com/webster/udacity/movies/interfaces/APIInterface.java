package com.webster.udacity.movies.interfaces;

import com.webster.udacity.movies.models.Movies;
import com.webster.udacity.movies.util.AppConstants;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by webster on 10/07/17.
 */

public interface APIInterface {

    @GET(AppConstants.POPULAR_MOVIE_ENDPOINT + AppConstants.QUERY_STRING_TAG)
    Call<Movies> getPopularMovies(@Query(AppConstants.API_KEY_QUERY) String api_key);

    @GET(AppConstants.TOP_RATED_MOVIE_ENDPOINT + AppConstants.QUERY_STRING_TAG)
    Call<Movies> getTopRatedMovies(@Query(AppConstants.API_KEY_QUERY) String api_key);
}
