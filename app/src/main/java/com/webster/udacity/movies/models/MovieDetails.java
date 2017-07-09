package com.webster.udacity.movies.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by webster on 09/07/17.
 */

public class MovieDetails {
    @SerializedName("vote_count")
    private long voteCount;

    @SerializedName("id")
    private long id;

    @SerializedName("video")
    private boolean video;

    @SerializedName("vote_average")
    private double voteAverage;

    @SerializedName("title")
    private String title;

    @SerializedName("popularity")
    private double popularity;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("original_language")
    private String originalLanguage;

    @SerializedName("original_title")
    private String originalTitle;

    @SerializedName("genre_ids")
    private long[] genreIds;

    @SerializedName("backdrop_path")
    private String backdropPath;

    @SerializedName("adult")
    private boolean adult;

    @SerializedName("overview")
    private String overview;

    @SerializedName("release_date")
    private String releaseDate;

    public void setVoteCount(final long voteCount) {
        this.voteCount = voteCount;
    }

    public long getVoteCount() {
        return this.voteCount;
    }

    public void setIsVideo(final boolean isVideo) {
        this.video = isVideo;
    }

    public boolean getIsVideo() {
        return this.video;
    }

    public void setVoteAverage(final double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public double getVoteAverage() {
        return this.voteAverage;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setPopularity(final double popularity) {
        this.popularity = popularity;
    }

    public double getPopularity() {
        return this.popularity;
    }

    public void setPosterPath(final String posterPath) {
        this.posterPath = posterPath;
    }

    public String getPosterPath() {
        return this.posterPath;
    }

    public void setOriginalLanguage(final String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalLanguage() {
        return this.originalLanguage;
    }

    public void setOriginalTitle(final String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOriginalTitle() {
        return this.originalTitle;
    }

    public void setGenreIds(final long[] genreIds) {
        this.genreIds = genreIds;
    }

    public long[] getGenreIds() {
        return this.genreIds;
    }

    public void setBackdropPath(final String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getBackdropPath() {
        return this.backdropPath;
    }

    public void setIsAdult(final boolean isAdult) {
        this.adult = isAdult;
    }

    public boolean getIsAdult() {
        return this.adult;
    }

    public void setOverview(final String overview) {
        this.overview = overview;
    }

    public String getOverview() {
        return this.overview;
    }

    public void setReleaseDate(final String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String  getReleaseDate() {
        return this.releaseDate;
    }
}
