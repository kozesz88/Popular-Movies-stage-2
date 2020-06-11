package com.example.popularmoviesstage2.ui;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.popularmoviesstage2.database.Repository;
import com.example.popularmoviesstage2.model.Movie;

import java.util.List;


public class MainViewModel extends AndroidViewModel {
    private static final String TAG = MainViewModel.class.getSimpleName();
    private LiveData<List<Movie>> movies;

    public MainViewModel(@NonNull Application application) {
        super(application);
        Repository repository = new Repository(application);
        Log.d(TAG, "Retrieving tasks from database via ViewModel");
        movies = repository.loadAllFavoriteMovies();
    }

    public LiveData<List<Movie>> getFavoriteMovies() {
        return movies;
    }
}
