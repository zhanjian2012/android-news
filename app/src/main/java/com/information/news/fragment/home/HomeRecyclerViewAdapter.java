package com.information.news.fragment.home;

import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.information.news.R;
import com.information.news.model.News;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link }.
 * TODO: Replace the implementation with code for your data type.
 */
public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewAdapter.ViewHolder> {

    private final List<News> newsList;

    public HomeRecyclerViewAdapter(List<News> items) {
        newsList = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_home_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.news = newsList.get(position);
//        holder.newsTitle.setText(newsList.get(position).getTitle());
        String imgUrl = "https://tojoycloud-app-online.oss-cn-beijing.aliyuncs.com//tojoy/tojoyClould/busOpportunity/202009/11/image/94a762ed497fb14fc13362d1ac4116011599806100954whRatio=0.75.png";
        System.err.println("http:" + newsList.get(position).getImage_url());
        Picasso.get().load(imgUrl).into(holder.newsImage);
        String htmlhref = "<a href='" + newsList.get(position).getOpen_url() + "'>" + newsList.get(position).getTitle() + "</a>";
        holder.newsTitle.setText(Html.fromHtml(htmlhref));
        holder.newsTitle.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView newsImage;
        public final TextView newsTitle;
        public News news;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            newsImage = view.findViewById(R.id.news_image);
            newsTitle = view.findViewById(R.id.news_title);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + newsTitle.getText() + "'";
        }
    }
}