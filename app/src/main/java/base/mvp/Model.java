package base.mvp;

/**
 * Created by hjw on 2016/8/4.
 */
public interface Model<L> {

    void attachModel(L listener);

    void detachModel();
}
