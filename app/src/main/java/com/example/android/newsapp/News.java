package com.example.android.newsapp;

/**
 * Created by joherreromoriana on 09/11/2016.
 */

public class News {

    private String webtitle;
    private String sectionName;
    private String webPublicationDate;
    private String webUrl;

    public String getWebtitle() {
        return webtitle;
    }

    public String getSectionName() {
        return sectionName;
    }

    public String getWebPublicationDate() {
        return webPublicationDate;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public News(String webtitle, String sectionName, String webPublicationDate, String webUrl) {
        this.webtitle = webtitle;
        this.sectionName = sectionName;
        this.webPublicationDate = webPublicationDate;
        this.webUrl = webUrl;
    }
}
