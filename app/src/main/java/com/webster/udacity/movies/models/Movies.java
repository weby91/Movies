package com.webster.udacity.movies.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by webster on 09/07/17.
 */

public class Movies {
    @SerializedName("page")
    private long page;

    @SerializedName("total_results")
    private long totalResults;

    @SerializedName("total_pages")
    private long totalPages;

    @SerializedName("results")
    private List<MovieDetails> results;

    public void setPage(final long page) {
        this.page = page;
    }

    public long getPage() {
        return this.page;
    }

    public void setTotalResults(final long totalResults) {
        this.totalResults = totalResults;
    }

    public long getTotalResults() {
        return this.totalResults;
    }

    public void setTotalPages(final long totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalPages() {
        return this.totalPages;
    }

    public void setResults(final List<MovieDetails> results) {
        this.results = results;
    }

    public List<MovieDetails> getResults() {
        return this.results;
    }
}
