package com.information.news.fragment.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.information.news.model.News;
import com.information.news.util.HttpUtils;

import java.io.IOException;
import java.util.List;


public class HomeViewModel extends ViewModel {

//    private MutableLiveData<List<News>> newsList;
//
//    public LiveData<List<News>> getNewsList() throws IOException {
//        List<News> news = HttpUtils.get("/api/pc/realtime_news/");
//        newsList = new MutableLiveData<>();
//        newsList.setValue(news);
//        return newsList;
//    }

}