package com.fisheradelakin.giphayy.ui.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fisheradelakin.giphayy.Constants;
import com.fisheradelakin.giphayy.R;
import com.fisheradelakin.giphayy.adapters.TrendingAdapter;
import com.fisheradelakin.giphayy.data.Giphy;
import com.fisheradelakin.giphayy.model.Gif;
import com.github.rahatarmanahmed.cpv.CircularProgressView;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrendingFragment extends Fragment {

    public static final String TAG = "TrendingFragment";

    @Bind(R.id.progress_view) CircularProgressView mProgressView;
    @Bind(R.id.trending_recyclerview) RecyclerView mRecyclerView;

    public TrendingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_trending, container, false);
        ButterKnife.bind(this, v);

        mProgressView.startAnimation();

        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mRecyclerView.setHasFixedSize(true);

        Giphy giphy = new Giphy();
        giphy.getSERVICE().getTrendingGifs(Constants.PUBLIC_BETA_KEY).enqueue(new Callback<Gif>() {
            @Override
            public void onResponse(Response<Gif> response, Retrofit retrofit) {
                Log.i(TAG, "Trending works!");
                mRecyclerView.setAdapter(new TrendingAdapter(getActivity(), response.body().getData()));
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

        return v;
    }


}
