package com.example.android.newsapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by joherreromoriana on 09/11/2016.
 */

public class NewsAdapter extends ArrayAdapter<News> {


    Context context;
    List<News> news;

    public NewsAdapter(Context context, List<News> news) {
        super(context, R.layout.news_layout, news);
        this.context = context;
        this.news = news;
    }

    @Override
    public void addAll(News... items) {
        this.news = new ArrayList<News>(Arrays.asList(items));
        super.addAll(items);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View currentView = convertView;

        if (currentView == null) {
            currentView = LayoutInflater.from(getContext()).inflate(R.layout.news_layout, parent, false);
        }

        News news = this.news.get(position);

//        TextView titleView = (TextView) currentView.findViewById(R.id.title);
//        TextView subtitleView = (TextView) currentView.findViewById(R.id.subtitle);
//        TextView authorsView = (TextView) currentView.findViewById(R.id.authors);
//
//        titleView.setText(news.getTitle());
//        subtitleView.setText(news.getSubtitle());
//        authorsView.setText(formatAuthors(news.getAuthors()));

        return currentView;
    }

//    private String formatAuthors(String[] authors) {
//
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 0; i < authors.length; i++) {
//            sb.append(authors[i]);
//            if(i < authors.length-1) {
//                sb.append(", ");
//            }
//        }
//
//        return sb.toString();
//    }

    @Nullable
    @Override
    public News getItem(int position) {
        return news.get(position);
    }

}
