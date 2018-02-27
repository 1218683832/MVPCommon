package com.mrrun.lib.mvp.app;

import com.mrrun.lib.androidbase.base.app.BaseApp;
import com.mrrun.lib.mvp.dagger.BaseApplicationComponent;
import com.mrrun.lib.mvp.dagger.BaseApplicationModule;
import com.mrrun.lib.mvp.dagger.DaggerBaseApplicationComponent;

/**
 * Created by lipin on 2017/6/28.
 */

public abstract class MvpApplication extends BaseApp {

    protected BaseApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
    }

    /**
     * <b>方法功能描述:</b><br>
     * Dagger2-初始化ApplicationComponent组件注射器
     */
    protected void initializeInjector() {
        mApplicationComponent = DaggerBaseApplicationComponent.builder().baseApplicationModule(new BaseApplicationModule(this)).build();
    }

    /**
     * 向Activity等提供ApplicationComponent
     * @return
     */
    public BaseApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
