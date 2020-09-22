package com.information.news.fragment.home;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.information.news.R;
import com.information.news.core.Result;
import com.information.news.model.News;
import com.information.news.util.HttpUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home, container, false);
        Call call = HttpUtils.list();
        call.enqueue(new Callback<Result<List<News>>>() {
            @Override
            public void onResponse(Call<Result<List<News>>> call, Response<Result<List<News>>> response) {
                Log.d("TEST", new Gson().toJson(response));
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
                Log.e("列表查询异常", t.getMessage());
            }
        });
        return view;
    }
}