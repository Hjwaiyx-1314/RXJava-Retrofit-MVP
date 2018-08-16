package base.mvp;

/**
 * Created by hjw on 2016/8/4.
 */
public interface ModelListener<R> {

    void onSuccess(R r);

    void onFailure(String errorMsg);

    void onCompleted();

}
