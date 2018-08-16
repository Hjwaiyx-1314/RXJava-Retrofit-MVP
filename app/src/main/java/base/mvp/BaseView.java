package base.mvp;

/**
 * Created by Administrator on 2016/8/7.
 */
public interface BaseView<T> {

    void onSuccess(T result);

    void onFailure(String errorMsg);

    void showLoading();

    void hideLoading();

}
