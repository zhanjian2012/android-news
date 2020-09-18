package com.information.news.util;


import com.google.gson.Gson;
import com.information.news.core.Result;
import com.information.news.model.News;
import com.information.news.service.NewsService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpUtils {

    private static final String BASE_NEWS_URL = "https://www.toutiao.com";

    public static List<News> result() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_NEWS_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NewsService service = retrofit.create(NewsService.class);
        Call<Result<List<News>>> result = service.result();
        try {
            Result<List<News>> body = result.execute().body();
            return body.getData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static Call list() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_NEWS_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NewsService service = retrofit.create(NewsService.class);
        Call<Result<List<News>>> call = service.result();
        // 不同的是如果是Android系统回调方法执行在主线程

        return call;
    }

//    public List<News> result(Call call) {
//        call.enqueue(new Callback<Result<List<News>>>() {
//            @Override
//            public void onResponse(Call<Result<List<News>>> call, Response<Result<List<News>>> response) {
//                try {
//                    response.body().getData();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Result<List<com.information.news.model.News>>> call, Throwable t) {
//                t.printStackTrace();
//            }
//        });
//    }
}
