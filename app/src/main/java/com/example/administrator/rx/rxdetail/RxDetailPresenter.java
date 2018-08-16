package com.example.administrator.rx.rxdetail;


import com.bumptech.glide.Glide;
import com.example.administrator.rx.R;

import api.callback.SubscriberCallBack;
import base.mvp.BasePresenter;
import bean.ShopperDetail;
import util.GlideRoundTransform;

public class RxDetailPresenter extends BasePresenter<RxDetailContract.IView, RxDetailModel> implements RxDetailContract.IListener {

    public RxDetailPresenter(RxDetailContract.IView view) {
        attachView(view);
    }

    @Override
    protected RxDetailModel createModel() {
        return new RxDetailModel(this);
    }

    @Override
    protected void initData() { //页面初始化时，做一些数据初始化的工作

    }

    public void getDate() {
        addSubscription(model.getData(), new SubscriberCallBack<ShopperDetail>() {

            @Override
            protected void onSuccess(ShopperDetail result) {
                view.setEtMsg(result);
            }

            @Override
            protected void onFailure(String errorMsg) {

            }

            @Override
            protected void onFinish() {
                view.hideDialog();
            }
        });

    }

    public void loadIm(String url) {
        Glide.with(view.getActivity())
                .load(url)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .transform(new GlideRoundTransform(view.getActivity()))
                //圆形图片
                //.transform(new GlideCircleTransform(view.getActivity()))
                .into(view.getIm());

    }

}
