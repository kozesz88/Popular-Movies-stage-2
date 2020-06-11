package com.example.popularmoviesstage2.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.popularmoviesstage2.database.Repository;
import com.example.popularmoviesstage2.model.Movie;

public class MovieDetailViewModel extends AndroidViewModel {

    private Repository repository;

    public MovieDetailViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    public boolean isFavorite(int movie_id) {
        return repository.isFavorite(movie_id);
    }

    public void addFavoriteMovie(Movie movie) {
        repository.addFavoriteMovies(movie);
    }

    public void updateFavoriteMovie(int movie_id, boolean isFavorite) {
        repository.updateFavoriteMovie(movie_id, isFavorite);
    }

    public void deleteFavoriteMovie(Movie movie) {
        repository.deleteFavoriteMovie(movie);
    }

}
