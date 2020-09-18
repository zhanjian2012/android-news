package com.information.news.service;


import com.information.news.core.Result;
import com.information.news.model.News;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NewsService {

    @GET("/api/pc/realtime_news/")
    Call<ResponseBody> list();

    @GET("/api/pc/realtime_news/")
    Call<Result<List<News>>> result();
}
