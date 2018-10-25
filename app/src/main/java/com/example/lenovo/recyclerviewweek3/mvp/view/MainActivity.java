package com.example.lenovo.recyclerviewweek3.mvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.lenovo.recyclerviewweek3.R;
import com.example.lenovo.recyclerviewweek3.mvp.adapter.NewsAdapter;
import com.example.lenovo.recyclerviewweek3.mvp.bean.News;
import com.example.lenovo.recyclerviewweek3.mvp.presenter.RecyclerPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IView{

    private RecyclerView rvList;
    private List<News.DataBean> list;
    private RecyclerPresenter presenter;
    private NewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvList = findViewById(R.id.rv_list);

        initData();

        list = new ArrayList<>();
        //适配器
        adapter = new NewsAdapter(this,list);

        //瀑布流管理器
        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        //添加管理器
        rvList.setLayoutManager(layoutManager);

        rvList.setAdapter(adapter);


    }

    private void initData() {
        presenter = new RecyclerPresenter();
        presenter.attach(this);
        presenter.getNews();


    }

    @Override
    public void success(List<News.DataBean> dataBeans) {
        list.addAll(dataBeans);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void faied(Exception e) {
        Toast.makeText(this, "网络异常" + e.getMessage(), Toast.LENGTH_SHORT).show();
    }


}
