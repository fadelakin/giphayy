package com.fisheradelakin.giphayy;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.fisheradelakin.giphayy.data.Giphy;
import com.fisheradelakin.giphayy.model.RandomGif;
import com.fisheradelakin.giphayy.ui.SearchActivity;
import com.fisheradelakin.giphayy.ui.fragments.RandomFragment;
import com.fisheradelakin.giphayy.ui.fragments.TranslateFragment;
import com.fisheradelakin.giphayy.ui.fragments.TrendingFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final long DRAWER_CLOSE_DELAY_MS = 250;
    private static final String NAV_ITEM_ID = "navItemId";
    private static final String TAG = "MainActivity";

    private final Handler mDrawerActionHandler = new Handler();
    private ActionBarDrawerToggle mDrawerToggle;
    private int mNavItemId;

    private RandomFragment mRandomFragment;
    private TranslateFragment mTranslateFragment;
    private TrendingFragment mTrendingFragment;

    // butterknife bindings
    @Bind(R.id.drawer_layout) DrawerLayout mDrawerLayout;
    @Bind(R.id.navigation) NavigationView mNavigationView;
    @Bind(R.id.toolbar) Toolbar mToolbar;
    @Bind(R.id.gif_header) ImageView mDrawerHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        // the three fragments i need in my sidebar
        mRandomFragment = new RandomFragment();
        mTranslateFragment = new TranslateFragment();
        mTrendingFragment = new TrendingFragment();

        // load saved navigation state if present
        if (null == savedInstanceState) {
            mNavItemId = R.id.drawer_random;
        } else {
            mNavItemId = savedInstanceState.getInt(NAV_ITEM_ID);
        }

        mNavigationView.setNavigationItemSelectedListener(this);

        // select the correct nav menu item
        mNavigationView.getMenu().findItem(mNavItemId).setChecked(true);

        // set up the hamburger icon to open and close the drawer
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open,
                R.string.close);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        // set header of drawer layout to contain a gif
        // > takes a while to load though :(
        Giphy giphy = new Giphy();
        giphy.getSERVICE().getRandomGif(Constants.PUBLIC_BETA_KEY).enqueue(new Callback<RandomGif>() {
            @Override
            public void onResponse(Response<RandomGif> response, Retrofit retrofit) {
                Log.i(TAG, "Whoo!");
                RandomGif randomGif = response.body();
                Glide.with(MainActivity.this)
                        .load(randomGif.getData().getImageUrl())
                        .into(mDrawerHeader);
            }

            @Override
            public void onFailure(Throwable t) {
                Log.i(TAG, "Awhh");
                t.printStackTrace();
            }
        });

        navigate(mNavItemId);
    }

    private void navigate(int navItemId) {
        // perform actual navigation logic, updating the main content fragment
        switch(navItemId) {
            // add more cases for more selections
            // pass in the arguments for other topics except inbox like i'm doing for topics fragment
            // > actually just pass them into topics fragment. reuse topicsfragment rather than creating new fragments
            // files
            case R.id.drawer_random:
                getFragmentManager().beginTransaction().replace(R.id.container, mRandomFragment).commit();
                mToolbar.setTitle("Random");
                break;
            case R.id.drawer_translate:
                getFragmentManager().beginTransaction().replace(R.id.container, mTranslateFragment).commit();
                mToolbar.setTitle("Translate");
                break;
            case R.id.drawer_trending:
                getFragmentManager().beginTransaction().replace(R.id.container, mTrendingFragment).commit();
                mToolbar.setTitle("Trending");
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch(id) {
            case android.support.v7.appcompat.R.id.home:
                return mDrawerToggle.onOptionsItemSelected(item);
            case R.id.action_search:
                Intent intent = new Intent(this, SearchActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
                return true;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        mNavItemId = menuItem.getItemId();

        // allow some time after closing the drawer before performing real navigation
        // so the user can see what is happening
        mDrawerLayout.closeDrawer(GravityCompat.START);
        mDrawerActionHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                navigate(mNavItemId);
            }
        }, DRAWER_CLOSE_DELAY_MS);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(NAV_ITEM_ID, mNavItemId);
    }
}
