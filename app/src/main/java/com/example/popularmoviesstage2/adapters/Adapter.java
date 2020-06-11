package com.example.popularmoviesstage2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.popularmoviesstage2.R;
import com.example.popularmoviesstage2.model.Movie;
import com.example.popularmoviesstage2.util.OnItemClickListener;

import java.util.List;


public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    List<Movie> moviesData;
    OnItemClickListener listener;
    Context context;

    public Adapter(List<Movie> moviesData, Context context) {
        this.moviesData = moviesData;
        this.context = context;
    }

    public Adapter(Context context) {
        this.context = context;
    }

    public Adapter(List<Movie> moviesData, OnItemClickListener listener) {
        this.moviesData = moviesData;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.item_movie_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.onBind(moviesData.get(position), listener);

    }

    @Override
    public int getItemCount() {
        return moviesData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView poster;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            poster = itemView.findViewById(R.id.im_movie_main);

        }

        public void onBind(final Movie movie, final OnItemClickListener listener) {

            Glide.with(itemView.getContext())
                    .load(imagePath(movie.getPosterPath()))
                    .into(poster);

            itemView.setOnClickListener(view -> listener.onItemClick(movie));
        }
    }

    public static String imagePath(String path) {
        return "https://image.tmdb.org/t/p/" +
                "w500" +
                path;
    }

    public void setData(List<Movie> movies) {
        this.moviesData = movies;
        notifyDataSetChanged();
    }

    public void clear() {
        this.moviesData.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<Movie> movies) {
        this.moviesData.addAll(movies);
        notifyDataSetChanged();
    }

}

