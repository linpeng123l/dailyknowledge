package com.lp.dailyknowlodge.activity;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.lp.dailyknowlodge.R;
import com.lp.dailyknowlodge.dialog.MyProgressDialog;
import com.lp.dailyknowlodge.domain.Share;
import com.lp.dailyknowlodge.service.BaseService;
import com.lp.dailyknowlodge.service.ShareService;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.activity_share)
public class ShareActivity extends BaseToolbarActivity {

    @ViewInject(R.id.share_edt_subject)
    private EditText editTextSubject;
    @ViewInject(R.id.share_edt_contact)
    private EditText editTextContact;

    private MyProgressDialog myProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState,"分享");
    }

    public void publishClick(View view){
        Share share = new Share();
        share.setContact(editTextContact.getText().toString());
        share.setSubject(editTextSubject.getText().toString());
        myProgressDialog = MyProgressDialog.builderProgressDialogAndShow(this, "上传中请稍后...");
        ShareService.publishShare(share,msgResultCallback);
    }
    BaseService.MsgResultCallback msgResultCallback = new BaseService.MsgResultCallback() {
        @Override
        public void onSuccess(String response) {
            editTextContact.setText("as");
            myProgressDialog.cancel();
        }
        @Override
        public void onError(String msg) {
        }
    };
}
