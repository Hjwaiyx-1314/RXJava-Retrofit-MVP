package util;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;

import com.example.administrator.rx.R;


/**
 * Created by hjw on 2016/9/8.
 */
public class DialogFactory {

    public static Dialog createDialog(Context context) {
        //创建diaog
        Dialog dialog = new Dialog(context, R.style.dialog_noTitle);
        //给dialog设置布局
        dialog.setContentView(R.layout.dialog_loading);

        //设置dialog属性
        Window window = dialog.getWindow();
        //设置dialog背景透明
        window.setBackgroundDrawableResource(R.color.transparent);
        WindowManager.LayoutParams params = window.getAttributes();
        params.dimAmount = 0.4f;
        window.setAttributes(params);
        //设置点击dialog外部，dialog不消失
        dialog.setCanceledOnTouchOutside(false);
        return dialog;
    }

}
