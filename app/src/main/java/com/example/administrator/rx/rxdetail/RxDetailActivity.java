package com.example.administrator.rx.rxdetail;


import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.administrator.rx.R;

import base.mvp.MVPActivity;
import bean.ShopperDetail;
import butterknife.Bind;
import butterknife.OnClick;

public class RxDetailActivity extends MVPActivity<RxDetailPresenter> implements RxDetailContract.IView {


    @Bind(R.id.et_get)
    EditText editText;

    @Bind(R.id.im_home)
    ImageView im_home;

    private String url;

    @Override
    protected RxDetailPresenter createPresenter() {
        return new RxDetailPresenter(this);
    }

    @Override
    protected void setMainLayout() {
        setContentView(R.layout.activity_rx_detail);
    }

    @Override
    protected void initView() {
        url = "http://img.blibao.com/upload/board/1511861452228.png";
    }

    @Override
    public void setEtMsg(ShopperDetail result) {
        editText.setText(result.getCRT_ALIPAY_VERSION_NUM() + "");
    }

    @Override
    public ImageView getIm() {
        return im_home;
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @OnClick({R.id.btn_post, R.id.btn_glide})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.btn_post:
                showDialog();
                presenter.getDate();
                break;
            case R.id.btn_glide:
                presenter.loadIm(url);
                break;
            default:
                break;


        }
    }

    @Override
    public void showDialog() {
        if (dialog != null && !dialog.isShowing()) {
            dialog.show();
        }
    }

    @Override
    public void hideDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

}
