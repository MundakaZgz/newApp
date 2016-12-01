package com.example.android.newsapp;

import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<News>> {

    private static final String NEWS_API = "http://content.guardianapis.com/search?q=debates";
    private static final String API_KEY = "test";
    public static final int NEWS_LOADER_ID = 1;
    private NewsAdapter mAdapter;
    private TextView mEmptyStateTextView;
    private String query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find reference to the listView in the layout
        ListView newsListView = (ListView) findViewById(R.id.list);

        // Create a new adapter that takes a list of news as input
        mAdapter = new NewsAdapter(this, new ArrayList<News>());

        // Find reference to the TextView for the empty state
        mEmptyStateTextView = (TextView) findViewById(R.id.empty_view);

        // Set the adapter on the ListView
        newsListView.setAdapter(mAdapter);
        // Set the empty state view
        newsListView.setEmptyView(mEmptyStateTextView);

        // Add click listener to navigate to the detail of the book
        newsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Find the current book that was clicked on
                News news = mAdapter.getItem(position);

                // Convert the String URL into a URI object
                Uri newsUri = Uri.parse(news.getWebUrl());
                // Create a new intent to view the news details
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, newsUri);

                // Create the intent to launch the new activity
                startActivity(websiteIntent);

            }
        });

        getData(newsListView);

    }

    public void getData(View view) {

        showLoadingIndicator();
        // Get a reference to ConnectivityManager
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);

        // Get details on the current active default data network
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if(networkInfo != null && networkInfo.isConnected()) {
            getLoaderManager().initLoader(NEWS_LOADER_ID, null, this);
        } else {
            hideLoadingIndicator();
            mEmptyStateTextView.setText(R.string.no_internet_connection);
        }

    }

    private void showLoadingIndicator() {
        View loadingIndicator = findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.VISIBLE);
    }

    private void hideLoadingIndicator() {
        View loadingIndicator = findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.GONE);
    }

    private static class NewsLoader extends AsyncTaskLoader<List<News>> {

        private String mUrl;

        public NewsLoader(Context context, String url) {
            super(context);
            this.mUrl = url;
        }

        @Override
        public List<News> loadInBackground() {
            if (mUrl == null) {
                return null;
            }

            // Perform the network request, parse the response, and extract a list of news.
            return QueryUtils.fetchNewsData(mUrl);
        }

        @Override
        protected void onStartLoading() {
            forceLoad();
        }
    }

    /**
     * LoaderManager.LoaderCallbacks<List<News>> methods
     */

    @Override
    public Loader<List<News>> onCreateLoader(int id, Bundle args) {
        return new NewsLoader(this, QueryUtils.getConnectionUrl(NEWS_API, API_KEY));
    }

    @Override
    public void onLoadFinished(Loader<List<News>> loader, List<News> news) {
        // Hide loading indicator because the data has been loaded
        hideLoadingIndicator();

        // Set empty state text to display "There are no news."
        mEmptyStateTextView.setText(R.string.no_news);

        // Clear the adapter of previous news data
        mAdapter.clear();

        // If there is a valid list of news, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (news != null && !news.isEmpty()) {
            mAdapter.addAll(news);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<News>> loader) {
        mAdapter.clear();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}

