package com.zhonghua.dileber.mvp.presenter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.zhonghua.dileber.mvp.view.IViewDelegate;
import com.zhonghua.dileber.tools.annotation.CloseStatusBar;
import com.zhonghua.dileber.tools.annotation.CloseTitle;


/**
 * Created by shidawei on 16/1/10.
 */
public abstract class ActivityPresenter<T extends IViewDelegate> extends Activity implements View.OnClickListener{

    protected T viewDelegate;

    public ActivityPresenter() {
        try {
            viewDelegate = getDelegateClass().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException("create IViewDelegate error");
        } catch (IllegalAccessException e) {
            throw new RuntimeException("create IViewDelegate error");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (this.getClass().isAnnotationPresent(CloseTitle.class)) {
            if(this.getClass().getAnnotation(CloseTitle.class).value()){
                this.requestWindowFeature(Window.FEATURE_NO_TITLE);
            }
        }
        if (this.getClass().isAnnotationPresent(CloseStatusBar.class)) {
            if(this.getClass().getAnnotation(CloseStatusBar.class).value()){
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            }
        }
        viewDelegate.create(getLayoutInflater(), null, savedInstanceState);
        setContentView(viewDelegate.getRootView());
        viewDelegate.initWidget();
        bindEvenListener();
    }

    protected void bindEvenListener() {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewDelegate = null;
    }

    protected abstract Class<T> getDelegateClass();

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (viewDelegate == null) {
            try {
                viewDelegate = getDelegateClass().newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException("create IViewDelegate error");
            } catch (IllegalAccessException e) {
                throw new RuntimeException("create IViewDelegate error");
            }
        }
    }


}
