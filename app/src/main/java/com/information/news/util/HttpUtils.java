package com.information.news.util;


import com.information.news.model.News;
import com.information.news.service.NewsService;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

public class HttpUtils {

    private static final String BASE_NEWS_URL = "https://www.toutiao.com";

    public static List<News> get(String url) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_NEWS_URL)
                .build();

        NewsService service = retrofit.create(NewsService.class);
        Call<List<News>> list = service.list();
        return list.execute().body();
    }

}
