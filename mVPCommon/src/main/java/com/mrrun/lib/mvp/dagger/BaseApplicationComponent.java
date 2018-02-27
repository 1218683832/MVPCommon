package com.mrrun.lib.mvp.dagger;

import android.content.Context;

import com.mrrun.lib.mvp.dagger.scope.ApplicationScope;
import com.mrrun.lib.mvp.network.executor.base.BaseBackgroundExecutor;

import dagger.Component;

/**
 * Created by lipin on 2017/6/28.
 * Application注入组件
 * 说明：在具体的项目中继承这些基本的类与接口，编写符合实际的类与接口，这里提供一些必要的模板方法；
 * 当然你也可以复制到项目中直接使用它们。
 */
@ApplicationScope
@Component(modules = BaseApplicationModule.class)
public interface BaseApplicationComponent {
    /**
     * 提供Applicaiton的Context
     * @return
     */
    Context context();

    /**
     * 提供后台网络服务的执行器
     * @return
     */
    BaseBackgroundExecutor backgroundExecutor();

    /**
     * 提供后台网络服务的API接口
     * 这个BaseApiService会放到BasePresenter中，且这个BaseApiService的生命周期跟随应用生命周期。
     * 注意：使用者需要创建一个ApiServic但不必继承此BaseApiService。
     * @return
     */
//    BaseApiService apiService();
}
