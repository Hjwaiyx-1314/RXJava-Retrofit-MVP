package com.example.administrator.rx.rxdetail;

import android.app.Activity;
import android.widget.ImageView;

import bean.ShopperDetail;
import rx.Observable;

public interface RxDetailContract {

    //V层接口,用于操作UI层,如显示隐藏进度条
    interface IView {
        void showDialog();

        void hideDialog();

        void setEtMsg(ShopperDetail result);

        ImageView getIm();

        Activity getActivity();
    }

    //M层定义接口，对外提供数据源
    interface IModel {

        Observable<ShopperDetail> getData();
    }

    //M层和P层交互的监听..ps:个人感觉这层鸡肋
    interface IListener {

    }
}
