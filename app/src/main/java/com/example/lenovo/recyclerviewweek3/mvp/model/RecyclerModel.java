package com.example.lenovo.recyclerviewweek3.mvp.model;

import com.example.lenovo.recyclerviewweek3.mvp.inter.ICallBack;
import com.example.lenovo.recyclerviewweek3.mvp.utils.HttpUtils;

import java.lang.reflect.Type;

/**
 * Created by lenovo on 2018/10/21.
 */

public class RecyclerModel {

    public void getData(String url, ICallBack callBack, Type type){
        HttpUtils.getInstance().get(url,callBack,type);
    }
}
