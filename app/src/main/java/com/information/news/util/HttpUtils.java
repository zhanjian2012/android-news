package com.information.news.util;


import com.google.gson.Gson;
import com.information.news.core.Result;
import com.information.news.model.News;
import com.information.news.service.NewsService;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;

public class HttpUtils {

    private static final String BASE_NEWS_URL = "https://www.toutiao.com";

    public static List<News> result() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_NEWS_URL)
                .build();

        NewsService service = retrofit.create(NewsService.class);
        Call<Result<List<News>>> result = service.result();
        try {
            Result<List<News>> body = result.execute().body();
            System.out.println(body);
//            ResponseBody body = result.execute().body();
//            Result result1 = new Gson().fromJson(body.toString(), Result.class);
//            return (List)result1.getData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<News> list() {

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(BASE_NEWS_URL)
//                .build();
//
//        NewsService service = retrofit.create(NewsService.class);
//        Call<List<News>> list = service.list();
//        try {
//            return list.execute().body();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return null;
    }
}
