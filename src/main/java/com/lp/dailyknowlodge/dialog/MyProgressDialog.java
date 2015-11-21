package com.lp.dailyknowlodge.dialog;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.widget.TextView;

import com.lp.dailyknowlodge.R;

/**
 * Created by linpe at  2015/8/18.
 */
public class MyProgressDialog extends Dialog{
    public MyProgressDialog(Context context) {
        super(context, R.style.progress_dialog);
    }
    public MyProgressDialog(Context context, int theme) {
        super(context, theme);
    }

    public static MyProgressDialog builderProgressDialogAndShow(Context context,String title){
        MyProgressDialog myProgressDialog = new MyProgressDialog(context);
        myProgressDialog.setContentView(R.layout.layout_dialog);
        myProgressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        TextView textView = (TextView) myProgressDialog.findViewById(R.id.id_tv_loadingmsg);
        textView.setText(title);
        myProgressDialog.show();
//        btProgressDialog.set
        return myProgressDialog;
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void cancel() {
        if(isShowing()){
            super.cancel();
        }
    }
}
