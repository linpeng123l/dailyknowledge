package com.lp.dailyknowlodge.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.LinearLayout;

import com.lp.dailyknowlodge.R;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.Console;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.Utils;
import me.imid.swipebacklayout.lib.app.SwipeBackActivityBase;
import me.imid.swipebacklayout.lib.app.SwipeBackActivityHelper;

/**
 * Created by linpeng123l on 2015/11/15.
 */
public class BaseToolbarActivity extends BaseActivity implements SwipeBackActivityBase {

    private int menuId = 0;
    @ViewInject(R.id.toolbar)
    protected Toolbar toolbar;
    private LinearLayout linearLayout;

    protected void onCreate(Bundle savedInstanceState,String title) {
        onCreate(savedInstanceState,title,0,true);
    }
    protected void onCreate(Bundle savedInstanceState,String title,int menuId) {
        onCreate(savedInstanceState,title,menuId,true);
    }
    protected void onCreate(Bundle savedInstanceState,String title,int menuId,boolean showBackBtn) {
        super.onCreate(savedInstanceState);
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        this.menuId = menuId;
        if(showBackBtn){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        mHelper = new SwipeBackActivityHelper(this);
        mHelper.onActivityCreate();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if(menuId!=0){
            getMenuInflater().inflate(menuId, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


    private SwipeBackActivityHelper mHelper;

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mHelper.onPostCreate();
    }

    @Override
    public View findViewById(int id) {
        View v = super.findViewById(id);
        if (v == null && mHelper != null)
            return mHelper.findViewById(id);
        return v;
    }

    @Override
    public SwipeBackLayout getSwipeBackLayout() {
        return mHelper.getSwipeBackLayout();
    }

    @Override
    public void setSwipeBackEnable(boolean enable) {
        getSwipeBackLayout().setEnableGesture(enable);
    }

    @Override
    public void scrollToFinishActivity() {
        Utils.convertActivityToTranslucent(this);
        getSwipeBackLayout().scrollToFinishActivity();
    }
}
