package com.fisheradelakin.giphayy.ui;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.fisheradelakin.giphayy.Constants;
import com.fisheradelakin.giphayy.R;
import com.fisheradelakin.giphayy.data.Giphy;
import com.fisheradelakin.giphayy.data.GiphyService;
import com.fisheradelakin.giphayy.model.Gif;
import com.github.rahatarmanahmed.cpv.CircularProgressView;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class SearchActivity extends AppCompatActivity {

    private static final String TAG = "SearchActivity";

    private SearchView mSearchView;

    @Bind(R.id.search_recyclerview) RecyclerView mSearchRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // give toolbar back the same behavior as to when the user presses the back button
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            toolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    NavUtils.navigateUpFromSameTask(SearchActivity.this);
                    overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
                }
            });
        }

        String query = getIntent().getStringExtra(SearchManager.QUERY);
        query = query == null ? "" : query;
        //String mQuery = query;

        if(mSearchView != null) {
            mSearchView.setQuery(query, false);
        }

        mSearchRecyclerView.setHasFixedSize(true);
        mSearchRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        if(searchItem != null) {
            SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
            mSearchView = (SearchView) searchItem.getActionView();
            if(mSearchView == null) {
                Log.i(TAG, "Could not set up search view, searchview is null");
            } else {
                mSearchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
                mSearchView.setIconified(false);
                mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        mSearchView.clearFocus();
                        startSearching(query);
                        return true;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        startSearching(newText);
                        return true;
                    }
                });
            }
        }

        return true;
    }

    // run search query to giphy api
    private void startSearching(String query) {
        Giphy giphy = new Giphy();
        giphy.getSERVICE().search(query, Constants.PUBLIC_BETA_KEY).enqueue(new Callback<Gif>() {
            @Override
            public void onResponse(Response<Gif> response, Retrofit retrofit) {
                Log.i(TAG, "Whoo");

            }

            @Override
            public void onFailure(Throwable t) {
                Log.i(TAG, "Awhh");
                t.printStackTrace();
            }
        });
    }

}
