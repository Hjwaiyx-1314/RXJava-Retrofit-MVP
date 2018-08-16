package base.mvp;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.example.administrator.rx.R;

import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Actions;
import rx.internal.util.ActionSubscriber;
import rx.internal.util.InternalObservableUtils;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;
import util.DialogFactory;


/**
 * Created by hjw on 2016/7/19.
 */
public abstract class MVPActivity<P extends BasePresenter> extends AppCompatActivity {

    //此处保存Presenter的引用，方便在子Activity中向P中传递业务，并在Activity销毁的时候，销毁Presenter
    protected P presenter;
    protected Dialog dialog;

    private CompositeSubscription mCompositeSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setMainLayout();
            ButterKnife.bind(this);
            dialog = DialogFactory.createDialog(this);
            initView();
            presenter = createPresenter();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 设置布局
     */
    protected abstract void setMainLayout();

    /**
     * 初始化界面
     */
    protected abstract void initView();

    /**
     * 实例化Presenter
     */
    protected abstract P createPresenter();

    //回调为Action1
    protected <T> void addSubscription(Observable<T> observable, Action1<T> action1) {
        Action1<Throwable> onError = InternalObservableUtils.ERROR_NOT_IMPLEMENTED;
        Action0 onCompleted = Actions.empty();
        addSubscription(observable, new ActionSubscriber<T>(action1, onError, onCompleted));
    }

    //回调为Subscriber
    protected <T> void addSubscription(Observable<T> observable, Subscriber<T> subscriber) {
        addSubscription(observable
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
    }

    //传入完整的事件链
    protected void addSubscription(Subscription subscription) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(subscription);
    }

    //RxJava取消注册，以避免内存泄露
    protected void unSubscribe() {
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (null != this.getCurrentFocus()) {
            //点击空白位置 隐藏软键盘
            InputMethodManager mInputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            return mInputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
        }

        return super.onTouchEvent(event);
    }


    //根据传入的类(class)打开指定的activity
    protected void openActivity(Class<?> pClass) {
        Intent intent = new Intent();
        intent.setClass(this, pClass);
        openActivityByIntent(intent);
    }

    protected void openActivityByIntent(Intent intent) {
        startActivity(intent);
        overridePendingTransition(R.anim.slide_right_in, R.anim.slide_left_out);
    }

    protected void openActivityForResult(Intent intent, int requestCode) {
        startActivityForResult(intent, requestCode);
        overridePendingTransition(R.anim.slide_right_in, R.anim.slide_left_out);
    }

    //销毁的时候右侧退出
    protected void closeActivity() {
        finish();
        overridePendingTransition(R.anim.slide_left_out, R.anim.slide_right_in);
    }

    /**
     * 隐藏输入法
     */
    public void hideKeyboard() {
        View view = getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    /**
     * 背景改变的方法
     */
    public void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = bgAlpha;
        getWindow().setAttributes(lp);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            closeActivity();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
        }
        unSubscribe();
        ButterKnife.unbind(this);
//        MyApplication.getRefWatcher(this).watch(this);
    }
}
