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

        TextView titleView = (TextView) currentView.findViewById(R.id.title);
        TextView sectionView = (TextView) currentView.findViewById(R.id.section);
        TextView dateView = (TextView) currentView.findViewById(R.id.date);

        titleView.setText(news.getWebtitle());
        sectionView.setText(news.getSectionName());
        dateView.setText(formatDate(news.getWebPublicationDate()));

        return currentView;
    }

    private String formatDate(String date) {
        String result = date.substring(0,date.indexOf("T"));
        return result;
    }

    @Nullable
    @Override
    public News getItem(int position) {
        return news.get(position);
    }

}
