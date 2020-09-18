package com.information.news.service;


import com.information.news.model.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NewsService {

    @GET("/api/pc/realtime_news/")
    Call<List<News>> list();
}
