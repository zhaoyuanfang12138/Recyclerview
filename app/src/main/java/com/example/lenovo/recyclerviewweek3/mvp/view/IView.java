package com.example.lenovo.recyclerviewweek3.mvp.view;

import com.example.lenovo.recyclerviewweek3.mvp.bean.News;

import java.util.List;

/**
 * Created by lenovo on 2018/10/21.
 */

public interface IView {

    void success(List<News.DataBean> list);

    void faied(Exception e);

}
