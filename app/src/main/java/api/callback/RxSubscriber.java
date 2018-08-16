package api.callback;


import api.error.ExceptionEngine;
import api.exception.ApiException;
import rx.Subscriber;

/**
 * Created by hjw on 2017-11-18.
 */
public abstract class RxSubscriber<T> extends Subscriber<T> {


    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        ApiException ex = ExceptionEngine.handleException(e);
        onFailure(ex.getMsg());
        onCompleted();
    }

    @Override
    public void onCompleted() {

    }

    protected abstract void onSuccess(T result);

    protected abstract void onFailure(String errorMsg);
}
