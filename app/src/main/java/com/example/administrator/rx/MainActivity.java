package com.example.administrator.rx;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.rx.rxdetail.RxDetailActivity;

import api.ApiManager;
import api.callback.SubscriberCallBack;
import base.mvp.BasePresenter;
import base.mvp.MVPActivity;
import butterknife.Bind;
import butterknife.OnClick;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends MVPActivity {

    @Bind(R.id.btn_gotomvp)
    Button button;

    @Bind(R.id.et_code)
    EditText et_code;

    @Bind(R.id.et_phone)
    EditText et_phone;


    private String code;
    private String phone;

    @Override
    protected void setMainLayout() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initView() {
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("-->robin");
                subscriber.onCompleted();
                Log.i("robin","0-->"+Thread.currentThread().getName());
            }
        })
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        Log.i("robin","1-->"+Thread.currentThread().getName());
                        return s;
                    }
                })

                .subscribeOn(Schedulers.io())

                .map(new Func1<String, String>() {
                    @Override
                    public String call(String o) {
                        Log.i("robin","2-->"+Thread.currentThread().getName());
                        return o;
                    }
                })
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        Log.i("robin","SBHU-->"+Thread.currentThread().getName());
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())

                .observeOn(AndroidSchedulers.mainThread())

                .map(new Func1<String, String>() {
                    @Override
                    public String call(String o) {
                        Log.i("robin","3-->"+Thread.currentThread().getName());
                        return o;
                    }
                })

                .observeOn(Schedulers.io())
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String o) {
                        Log.i("robin","5-->"+Thread.currentThread().getName());
                        return o;
                    }
                })

                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String o) {
                        Log.i("robin","4-->"+Thread.currentThread().getName()+o);
                    }
                });
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @OnClick({R.id.btn_gotomvp, R.id.btn_post_msg, R.id.btn_try_msg})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_gotomvp:
                openActivity(RxDetailActivity.class);
                break;

            case R.id.btn_try_msg:
                phone = et_phone.getText().toString().trim();
                code = et_code.getText().toString().trim();
                addSubscription(ApiManager.getPhone().tryPhone(phone, code), new SubscriberCallBack<String>() {
                    @Override
                    protected void onSuccess(String result) {
                    }

                    @Override
                    protected void onFailure(String errorMsg) {
                    }

                    @Override
                    protected void onFinish() {

                    }
                });
                break;
            case R.id.btn_post_msg:
                phone = et_phone.getText().toString().trim();
                addSubscription(ApiManager.getPhone().getPthone(phone), new SubscriberCallBack<String>() {
                    @Override
                    protected void onSuccess(String result) {
                    }

                    @Override
                    protected void onFailure(String errorMsg) {
                    }

                    @Override
                    protected void onFinish() {

                    }
                });
                break;


            default:
                break;
        }
    }

}
