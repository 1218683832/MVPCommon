package com.mrrun.lib.mvp.dagger;

import com.mrrun.lib.mvp.mvpcommon.BaseMvpActivity;

/**
 * Created by lipin on 2017/6/28.
 * Activity注入组件
 * 说明：在具体的项目中继承这些基本的类与接口，编写符合实际的类与接口，这里提供一些必要的模板方法；
 * 当然你也可以复制到项目中直接使用它们。
 */
//@ActivityScope
//@Component(modules = BaseActivityModule.class)
public interface BaseActivityComponent<A extends BaseMvpActivity> {
    void inject(A mActivity);
}
