package com.example.popularmoviesstage2.database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.popularmoviesstage2.model.Movie;
import com.example.popularmoviesstage2.util.Executors;

import java.util.List;


public class Repository {
    private MovieDao movieDao;
    private Executors executors;
    private LiveData<List<Movie>> movies;

    public Repository(Application application) {
        movieDao = Database.getInstance(application).movieDao();
        movies = movieDao.loadAllFavoriteMovies();
        executors = Executors.getInstance();
    }

    public LiveData<List<Movie>> loadAllFavoriteMovies() {
        return movies;
    }

    public boolean isFavorite(int movie_id) {
        return movieDao.isFavorite(movie_id);
    }

    public void addFavoriteMovies(final Movie movie) {
        executors.diskIO().execute(() -> movieDao.insertFavoriteMovie(movie));
    }

    public void updateFavoriteMovie(int movie_id, boolean isFavorite) {
        executors.diskIO().execute(() -> {
            movieDao.updateFavoriteMovies(movie_id, isFavorite);
        });
    }

    public void deleteFavoriteMovie(Movie movie) {
        executors.diskIO().execute(() -> movieDao.deleteFavoriteMovie(movie));
    }
}
