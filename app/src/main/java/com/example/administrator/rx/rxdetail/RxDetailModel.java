package com.example.administrator.rx.rxdetail;


import api.ApiManager;
import base.mvp.BaseModel;
import bean.ShopperDetail;
import rx.Observable;

public class RxDetailModel extends BaseModel<RxDetailContract.IListener> implements RxDetailContract.IModel {
    public RxDetailModel(RxDetailContract.IListener listener) {
        attachModel(listener);
    }

    @Override
    public Observable<ShopperDetail> getData() {
        return ApiManager.getBean().getshopInfo("9356", "5117");
    }
}