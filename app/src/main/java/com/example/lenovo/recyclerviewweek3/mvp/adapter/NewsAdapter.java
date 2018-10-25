package com.example.lenovo.recyclerviewweek3.mvp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.recyclerviewweek3.R;
import com.example.lenovo.recyclerviewweek3.mvp.bean.News;

import java.util.List;

/**
 * Created by lenovo on 2018/10/21.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.Holder>{

    private Context context;
    private List<News.DataBean> list;

    public NewsAdapter(Context context, List<News.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = View.inflate(context, R.layout.item_recycler,null);

        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        holder.txtTitle.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getThumbnail01()).into(holder.imgLogo);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{

        private final ImageView imgLogo;
        private final TextView txtTitle;

        public Holder(View itemView) {
            super(itemView);
            imgLogo = itemView.findViewById(R.id.img_logo);
            txtTitle = itemView.findViewById(R.id.txt_Title);
        }
    }

}
