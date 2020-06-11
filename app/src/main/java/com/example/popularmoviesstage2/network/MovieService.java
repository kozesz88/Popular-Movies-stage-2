package com.example.popularmoviesstage2.network;

import com.example.popularmoviesstage2.model.MovieResults;
import com.example.popularmoviesstage2.model.MovieReview;
import com.example.popularmoviesstage2.model.MovieTrailer;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieService {

    @GET("movie/top_rated")
    Call<MovieResults> getTopRatedMovies(@Query("page") int page, @Query("api_key") String apiKey);

    @GET("movie/popular")
    Call<MovieResults> getPopularMovies(@Query("page") int page, @Query("api_key") String apiKey);

    @GET("movie/{id}/videos")
    Call<MovieTrailer> getMovieTrailers(@Path("id") int movieId, @Query("api_key") String apiKey);

    @GET("movie/{id}/reviews")
    Call<MovieReview> getMovieReviews(@Path("id") int moveId, @Query("api_key") String apiKey, @Query("page") int page);

}
