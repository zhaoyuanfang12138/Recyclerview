package com.example.lenovo.recyclerviewweek3.mvp.presenter;

import com.example.lenovo.recyclerviewweek3.mvp.bean.News;
import com.example.lenovo.recyclerviewweek3.mvp.inter.ICallBack;
import com.example.lenovo.recyclerviewweek3.mvp.model.RecyclerModel;
import com.example.lenovo.recyclerviewweek3.mvp.view.IView;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by lenovo on 2018/10/21.
 */

public class RecyclerPresenter {

    private IView iv;
    private RecyclerModel model;

    public void attach(IView iv){
        this.iv=iv;
        model = new RecyclerModel();
    }


    public void getNews(){

        Type type = new TypeToken<News>(){}.getType();

        model.getData("http://www.xieast.com/api/news/news.php?type=top&page=1", new ICallBack() {
            @Override
            public void onsuccess(Object obj) {

                News news = (News) obj;

                if (news !=null){
                    List<News.DataBean> list = news.getData();
                    iv.success(list);
                }


            }

            @Override
            public void onfaied(Exception e) {

                iv.faied(e);
            }
        },type);


    }

}
