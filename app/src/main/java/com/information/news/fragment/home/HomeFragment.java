package com.information.news.fragment.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.information.news.R;
import com.information.news.core.Result;
import com.information.news.model.News;
import com.information.news.util.HttpUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home, container, false);

//        List<News> list = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//            News news = new News();
//            news.setTitle("测试" + i);
//            news.setOpenUrl("http://www.baidu.com");
//            news.setImageUrl("https://tojoycloud-app-online.oss-cn-beijing.aliyuncs.com//tojoy/tojoyClould/busOpportunity/202009/11/image/94a762ed497fb14fc13362d1ac4116011599806100954whRatio=0.75.png");
//            list.add(news);
//        }
//        List<News> newsList = HttpUtils.result();
        Call call = HttpUtils.list();

        call.enqueue(new Callback<Result<List<News>>>() {
            @Override
            public void onResponse(Call<Result<List<News>>> call, Response<Result<List<News>>> response) {
                if (view instanceof RecyclerView) {
                    Context context = view.getContext();
                    RecyclerView recyclerView = (RecyclerView) view;
                    // 一行布局
                    recyclerView.setLayoutManager(new LinearLayoutManager(context));
                    // 两行布局
//                  recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
                    recyclerView.setAdapter(new HomeRecyclerViewAdapter(response.body().getData()));
                }
            }

            @Override
            public void onFailure(Call<Result<List<News>>> call, Throwable t) {

            }
        });

//        if (view instanceof RecyclerView) {
//            Context context = view.getContext();
//            RecyclerView recyclerView = (RecyclerView) view;
//            // 一行布局
//            recyclerView.setLayoutManager(new LinearLayoutManager(context));
//            // 两行布局
////            recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
//            recyclerView.setAdapter(new HomeRecyclerViewAdapter(newsList));
//        }
        return view;
    }
}