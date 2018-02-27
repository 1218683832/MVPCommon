package com.mrrun.lib.mvp.dagger;

import com.mrrun.lib.mvp.mvpcommon.BaseMvpActivity;

/**
 * Created by lipin on 2017/7/1.
 * 说明：在具体的项目中继承这些基本的类与接口，编写符合实际的类与接口，这里提供一些必要的模板方法；
 * 当然你也可以复制到项目中直接使用它们。
 */
//@Module
public class BaseActivityModule<A extends BaseMvpActivity> {

    protected final A mActivity;

    public BaseActivityModule(A mActivity) {
        this.mActivity = mActivity;
    }

//    @ActivityScope
//    @Provides
}
