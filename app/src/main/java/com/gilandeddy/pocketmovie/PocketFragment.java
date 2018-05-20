package com.gilandeddy.pocketmovie;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gilandeddy.pocketmovie.model.Movie;
import com.gilandeddy.pocketmovie.model.PocketedMoviesManager;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PocketFragment extends Fragment implements MovieRecyclerAdapter.ListItemClickListener{
    public static MovieRecyclerAdapter pocketRecyclerAdapter;
    private static ArrayList<Movie> pocketMovies = new ArrayList<>();



    public PocketFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pocket, container, false);
        RecyclerView pocketRecyclerView = view.findViewById(R.id.pocketMovieRecycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        pocketRecyclerView.setLayoutManager(linearLayoutManager);
        pocketRecyclerAdapter = new MovieRecyclerAdapter(this);
        pocketRecyclerView.setAdapter(pocketRecyclerAdapter);
        pocketMovies.addAll(PocketedMoviesManager.getInstance().getAllMovies());
        pocketRecyclerAdapter.setMovies(pocketMovies);
        return view;
        //TODO get the fragment to refresh the pocketmovies on each load (onresume?)
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {

    }
}
