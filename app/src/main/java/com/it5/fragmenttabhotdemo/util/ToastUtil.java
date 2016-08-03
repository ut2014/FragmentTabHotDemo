package com.it5.fragmenttabhotdemo.util;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.widget.Toast;

import com.it5.fragmenttabhotdemo.R;

import cn.bingoogolapple.badgeview.BGABadgeViewUtil;

/**
 * Created by IT5 on 2016/8/3.
 */
public class ToastUtil {
    private static Toast toast;
    private static TextView smsgTv;
    private ToastUtil(){}

    public static void init(Context context){
        toast=new Toast(context);
        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL,0, BGABadgeViewUtil.dp2px(context, 70));
        smsgTv=(TextView) LayoutInflater.from(context).inflate(R.layout.view_toast, null);
        toast.setView(smsgTv);
        toast.setDuration(Toast.LENGTH_SHORT);
    }

    public static void show(CharSequence text){
        smsgTv.setText(text);
        toast.show();
    }
}
