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
import com.information.news.model.News;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        List<News> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            News news = new News();
            news.setTitle("测试" + i);
            news.setOpenUrl("http://www.baidu.com");
            news.setImageUrl("https://tojoycloud-app-online.oss-cn-beijing.aliyuncs.com//tojoy/tojoyClould/busOpportunity/202009/11/image/94a762ed497fb14fc13362d1ac4116011599806100954whRatio=0.75.png");
            list.add(news);
        }

        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            // 一行布局
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            // 两行布局
//            recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
            recyclerView.setAdapter(new HomeRecyclerViewAdapter(list));
        }
        return view;
    }
}