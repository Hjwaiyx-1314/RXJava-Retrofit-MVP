package base.mvp;


import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by hjw on 2016/7/19.
**/
public abstract class BasePresenter<V, M extends BaseModel> implements Presenter<V> {

    public V view;
    //此处保存的是Model的引用，方便在Presenter中从Model模块传递数据请求，以及在Presenter销毁Model
    public M model;

    private CompositeSubscription mCompositeSubscription;

    @Override
    public void attachView(V view) {
        this.view = view;
        this.model = createModel();
        initData();
    }

    @Override
    public void detachView() {
        this.view = null;
        if (model != null) {
            model.detachModel();
            model = null;
        }
        unSubscribe();
    }

    protected abstract M createModel();

    protected abstract void initData();

    public void addSubscription(Subscription subscription) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(subscription);
    }

    public <T> void addSubscription(Observable<T> observable, Subscriber<T> subscriber) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(observable
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
    }

    public <T> void addSubscription(Observable<T> observable, Action1<T> action1) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(observable
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(action1));
    }

    public <T, R> void addSubscription(Observable<T> observable, Func1<T, R> func1, Subscriber<R> subscriber) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(observable
                .map(func1)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
    }

    //RXjava取消注册，以避免内存泄露
    public void unSubscribe() {
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }
}
