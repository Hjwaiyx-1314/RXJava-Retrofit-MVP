package base.mvp;

public interface Presenter<V> {

    void attachView(V view);

    void detachView();

}
