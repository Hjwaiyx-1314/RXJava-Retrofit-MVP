package base.mvp;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.example.administrator.rx.R;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.ButterKnife;
import util.DialogFactory;


/**
 * Created by hjw on 2016/7/20.
 */
public abstract class MVPFragment<P extends BasePresenter> extends Fragment {

    private String TAG = "MVPFragment";
    protected P presenter;
    protected Dialog dialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int layout = setMainLayout();
        View view = inflater.inflate(layout, null);
        ButterKnife.bind(this, view);
        initView();
        presenter = createPresenter();
        dialog = DialogFactory.createDialog(getActivity());

        return view;
    }

    /**
     * 初始化布局
     */
    protected abstract int setMainLayout();

    /**
     * 实例化Presenter
     */
    protected abstract P createPresenter();

    /**
     * 初始化界面
     */
    protected abstract void initView();


    /**
     * 弹出输入法
     */
    public void showKeyboard(EditText et) {

        try {
            final EditText editText = et;
            editText.setFocusableInTouchMode(true);
            editText.requestFocus();

            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    InputMethodManager imm = (InputMethodManager) editText.getContext()
                            .getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.showSoftInput(editText, InputMethodManager.SHOW_FORCED);
                }
            }, 300);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 隐藏输入法
     */
    public void hideKeyboard() {
        View view = getActivity().getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    //根据传入的类(class)打开指定的activity
    protected void openActivity(Class<?> pClass) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), pClass);
        openActivityByIntent(intent);
    }

    protected void openActivityByIntent(Intent intent) {
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.slide_right_in, R.anim.slide_left_out);
    }


    /**
     * 背景改变的方法
     */
    protected void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
        lp.alpha = bgAlpha;
        getActivity().getWindow().setAttributes(lp);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (presenter != null) {
            presenter.detachView();
        }
    }

}
