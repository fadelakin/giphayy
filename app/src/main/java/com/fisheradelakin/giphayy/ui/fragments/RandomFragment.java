package com.fisheradelakin.giphayy.ui.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.fisheradelakin.giphayy.Constants;
import com.fisheradelakin.giphayy.R;
import com.fisheradelakin.giphayy.data.Giphy;
import com.fisheradelakin.giphayy.model.RandomGif;
import com.github.rahatarmanahmed.cpv.CircularProgressView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 */
public class RandomFragment extends Fragment {

    @Bind(R.id.swipe_refresh_layout) SwipeRefreshLayout mSwipeRefreshLayout;
    @Bind(R.id.random_image_view) ImageView mRandomGifImageView;
    @Bind(R.id.progress_view) CircularProgressView mProgressView;

    private Giphy mGiphy;
    private RandomGif mRandomGif;

    public RandomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_random, container, false);
        ButterKnife.bind(this, view);

        mGiphy = new Giphy();

        mSwipeRefreshLayout.setColorSchemeColors(getActivity().getResources().getColor(R.color.colorPrimary));
        mProgressView.startAnimation();

        getRandomGif();

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getRandomGif();
            }
        });

        return view;
    }

    private void getRandomGif() {
        mGiphy.getSERVICE().getRandomGif(Constants.PUBLIC_BETA_KEY).enqueue(new Callback<RandomGif>() {
            @Override
            public void onResponse(Response<RandomGif> response, Retrofit retrofit) {
                mRandomGif = response.body();
                Glide.with(RandomFragment.this).load(mRandomGif.getData().getFixedWidthDownsampledUrl()).asGif().into(mRandomGifImageView);

                if (mSwipeRefreshLayout.isRefreshing()) {
                    mSwipeRefreshLayout.setRefreshing(false);
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }


    @OnClick(R.id.random_image_view)
    public void shareGif() {
        Intent gifIntent = new Intent(Intent.ACTION_SEND);
        gifIntent.setType("text/*");
        gifIntent.putExtra(Intent.EXTRA_TEXT, mRandomGif.getData().getImageUrl());
        startActivity(Intent.createChooser(gifIntent, "Share with... "));
    }

}
