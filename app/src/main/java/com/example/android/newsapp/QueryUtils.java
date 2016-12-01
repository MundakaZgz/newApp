package com.example.android.newsapp;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by joherreromoriana on 09/11/2016.
 */

public class QueryUtils {

    private static String result = "{\"response\":{\"status\":\"ok\",\"userTier\":\"developer\",\"total\":22812,\"startIndex\":1,\"pageSize\":10,\"currentPage\":1,\"pages\":2282,\"orderBy\":\"relevance\",\"results\":[{\"id\":\"us-news/2016/sep/26/presidential-debates-nixon-kennedy-1960\",\"type\":\"article\",\"sectionId\":\"us-news\",\"sectionName\":\"US news\",\"webPublicationDate\":\"2016-09-26T15:57:34Z\",\"webTitle\":\"The Nixon-Kennedy presidential debates: from the archive, 1960\",\"webUrl\":\"https://www.theguardian.com/us-news/2016/sep/26/presidential-debates-nixon-kennedy-1960\",\"apiUrl\":\"https://content.guardianapis.com/us-news/2016/sep/26/presidential-debates-nixon-kennedy-1960\",\"isHosted\":false},{\"id\":\"commentisfree/2016/sep/23/presidential-debates-real-time-reactions-notifications-mobile\",\"type\":\"article\",\"sectionId\":\"commentisfree\",\"sectionName\":\"Opinion\",\"webPublicationDate\":\"2016-09-23T21:43:23Z\",\"webTitle\":\"Get real-time reactions during the presidential debates | Guardian Mobile Innovation Lab\",\"webUrl\":\"https://www.theguardian.com/commentisfree/2016/sep/23/presidential-debates-real-time-reactions-notifications-mobile\",\"apiUrl\":\"https://content.guardianapis.com/commentisfree/2016/sep/23/presidential-debates-real-time-reactions-notifications-mobile\",\"isHosted\":false},{\"id\":\"us-news/2016/sep/25/us-presidential-debates-famous-moments\",\"type\":\"article\",\"sectionId\":\"us-news\",\"sectionName\":\"US news\",\"webPublicationDate\":\"2016-09-25T10:00:31Z\",\"webTitle\":\"Make or break: the defining moments of presidential debates\",\"webUrl\":\"https://www.theguardian.com/us-news/2016/sep/25/us-presidential-debates-famous-moments\",\"apiUrl\":\"https://content.guardianapis.com/us-news/2016/sep/25/us-presidential-debates-famous-moments\",\"isHosted\":false},{\"id\":\"us-news/2016/sep/02/presidential-debate-moderators-martha-raddatz-anderson-cooper\",\"type\":\"article\",\"sectionId\":\"us-news\",\"sectionName\":\"US news\",\"webPublicationDate\":\"2016-09-02T16:53:02Z\",\"webTitle\":\"The Clinton-Trump presidential debates: who are the moderators?\",\"webUrl\":\"https://www.theguardian.com/us-news/2016/sep/02/presidential-debate-moderators-martha-raddatz-anderson-cooper\",\"apiUrl\":\"https://content.guardianapis.com/us-news/2016/sep/02/presidential-debate-moderators-martha-raddatz-anderson-cooper\",\"isHosted\":false},{\"id\":\"science/political-science/2016/oct/24/hinkley-c-shows-the-value-of-social-science-in-the-most-toxic-public-debates\",\"type\":\"article\",\"sectionId\":\"science\",\"sectionName\":\"Science\",\"webPublicationDate\":\"2016-10-24T06:30:07Z\",\"webTitle\":\"Hinkley C shows the value of social science in the most toxic public debates\",\"webUrl\":\"https://www.theguardian.com/science/political-science/2016/oct/24/hinkley-c-shows-the-value-of-social-science-in-the-most-toxic-public-debates\",\"apiUrl\":\"https://content.guardianapis.com/science/political-science/2016/oct/24/hinkley-c-shows-the-value-of-social-science-in-the-most-toxic-public-debates\",\"isHosted\":false},{\"id\":\"us-news/2016/oct/19/where-is-climate-change-in-the-trump-v-clinton-presidential-debates\",\"type\":\"article\",\"sectionId\":\"us-news\",\"sectionName\":\"US news\",\"webPublicationDate\":\"2016-10-19T12:00:07Z\",\"webTitle\":\"Why has climate change been ignored in the US election debates?\",\"webUrl\":\"https://www.theguardian.com/us-news/2016/oct/19/where-is-climate-change-in-the-trump-v-clinton-presidential-debates\",\"apiUrl\":\"https://content.guardianapis.com/us-news/2016/oct/19/where-is-climate-change-in-the-trump-v-clinton-presidential-debates\",\"isHosted\":false},{\"id\":\"us-news/2016/oct/22/clinton-trump-debate-analysis-foreign-policy-economy-scandals\",\"type\":\"article\",\"sectionId\":\"us-news\",\"sectionName\":\"US news\",\"webPublicationDate\":\"2016-10-22T11:00:15Z\",\"webTitle\":\"What did Clinton and Trump talk about in the debates – and for how long?\",\"webUrl\":\"https://www.theguardian.com/us-news/2016/oct/22/clinton-trump-debate-analysis-foreign-policy-economy-scandals\",\"apiUrl\":\"https://content.guardianapis.com/us-news/2016/oct/22/clinton-trump-debate-analysis-foreign-policy-economy-scandals\",\"isHosted\":false},{\"id\":\"politics/2016/jun/02/eu-referendum-tv-debates-when-where-watch-them\",\"type\":\"article\",\"sectionId\":\"politics\",\"sectionName\":\"Politics\",\"webPublicationDate\":\"2016-06-09T12:53:46Z\",\"webTitle\":\"EU referendum debates: when and where to watch them\",\"webUrl\":\"https://www.theguardian.com/politics/2016/jun/02/eu-referendum-tv-debates-when-where-watch-them\",\"apiUrl\":\"https://content.guardianapis.com/politics/2016/jun/02/eu-referendum-tv-debates-when-where-watch-them\",\"isHosted\":false},{\"id\":\"uk-news/2016/mar/04/slough-debates-whether-to-change-its-name\",\"type\":\"article\",\"sectionId\":\"uk-news\",\"sectionName\":\"UK news\",\"webPublicationDate\":\"2016-03-04T17:54:54Z\",\"webTitle\":\"Slough debates whether to change its name\",\"webUrl\":\"https://www.theguardian.com/uk-news/2016/mar/04/slough-debates-whether-to-change-its-name\",\"apiUrl\":\"https://content.guardianapis.com/uk-news/2016/mar/04/slough-debates-whether-to-change-its-name\",\"isHosted\":false},{\"id\":\"us-news/2016/sep/27/clinton-trump-debate-analysis\",\"type\":\"article\",\"sectionId\":\"us-news\",\"sectionName\":\"US news\",\"webPublicationDate\":\"2016-09-27T09:07:22Z\",\"webTitle\":\"Hillary Clinton shows strength over Trump in one of history's weirdest, wildest debates\",\"webUrl\":\"https://www.theguardian.com/us-news/2016/sep/27/clinton-trump-debate-analysis\",\"apiUrl\":\"https://content.guardianapis.com/us-news/2016/sep/27/clinton-trump-debate-analysis\",\"isHosted\":false}]}}";
    private static final String LOG_TAG = QueryUtils.class.getCanonicalName();

    /***
     *
     * @param url
     * @param apiKey
     * @return
     * @throws MalformedURLException
     */
    public static String getConnectionUrl(String url, String apiKey) {

        if (TextUtils.isEmpty(url)) {
            return null;
        }

        StringBuilder urlString = new StringBuilder();
        urlString.append(url);

        // Append apiKey
        urlString.append("&api-key=");
        urlString.append(apiKey);

        return urlString.toString();

    }

    private static List<News> extractNewsFromJson(String booksJSON) {
        // If the JSON string is empty or null, then return early.
        if (TextUtils.isEmpty(booksJSON)) {
            return null;
        }

        // Create an empty ArrayList that we can start adding books to
        List<News> news = new ArrayList<>();

        // Try to parse the JSON response string. If there's a problem with the way the JSON
        // is formatted, a JSONException exception object will be thrown.
        // Catch the exception so the app doesn't crash, and print the error message to the logs.
        try {

            // Create a JSONObject from the JSON response string
            JSONObject baseJsonResponse = new JSONObject(booksJSON);

            JSONObject response = baseJsonResponse.getJSONObject("response");


            // Extract the JSONArray associated with the key called "results",
            // which represents a list of items (or Books).
            JSONArray newsArray = response.getJSONArray("results");

            // For each news in newsArray, create a News object
            for (int i = 0; i < newsArray.length(); i++) {
                // Get one news at position i within the list of news
                JSONObject currentNews =  newsArray.getJSONObject(i);

                String sectionName = currentNews.getString("sectionName");
                String webPublicationDateString = currentNews.getString("webPublicationDate");
                String webTitle = currentNews.getString("webTitle");
                String webUrl = currentNews.getString("webUrl");

                News createdNews = new News(webTitle, sectionName, webPublicationDateString, webUrl);
                news.add(createdNews);

            }

        } catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("QueryUtils", "Problem parsing the news JSON results", e);
        }

        // Return the list of books
        return news;

    }

    /*
    * Returns new URL object from the given string URL.
    */
    public static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Problem building the URL ", e);
        }
        return url;
    }

    public static List<News> fetchNewsData(String requestUrl) {

        URL url = createUrl(requestUrl);

        // Perform HTTP request to the URL and receive a JSON response back
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem making the HTTP request.", e);
        }

        // Extract relevant fields from the JSON response and create a list of Books
        List<News> news = extractNewsFromJson(jsonResponse);

        return news;
    }

    /**
     * Make an HTTP request to the given URL and return a String as the response.
     */
    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";

        // If the URL is null, then return early.
        if (url == null) {
            return jsonResponse;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // If the request was successful (response code 200),
            // then read the input stream and parse the response.
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retrieving the books JSON results.", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                // Closing the input stream could throw an IOException, which is why
                // the makeHttpRequest(URL url) method signature specifies than an IOException
                // could be thrown.
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    /**
     * Convert the {@link InputStream} into a String which contains the
     * whole JSON response from the server.
     */
    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

}
