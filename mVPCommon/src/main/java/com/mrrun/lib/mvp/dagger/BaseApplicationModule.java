package com.mrrun.lib.mvp.dagger;

import android.content.Context;

import com.mrrun.lib.mvp.app.MvpApplication;
import com.mrrun.lib.mvp.dagger.scope.ApplicationScope;
import com.mrrun.lib.mvp.network.executor.LPBackgroudExecutor;
import com.mrrun.lib.mvp.network.executor.base.BaseBackgroundExecutor;
import com.mrrun.lib.mvp.network.manager.ThreadPool;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lipin on 2017/6/28.
 * 说明：在具体的项目中继承这些基本的类与接口，编写符合实际的类与接口，这里提供一些必要的模板方法；
 * 当然你也可以复制到项目中直接使用它们。
 */
@Module
public class BaseApplicationModule {

    protected final MvpApplication application;

    public BaseApplicationModule(MvpApplication application) {
        this.application = application;
    }

    /**
     * 提供Applicaiton的Context
     * @return
     */
    @ApplicationScope
    @Provides
    Context provideApplicationContext() {
        return MvpApplication.appContext;
    }

    /**
     * 提供后台网络服务的执行器
     * @return
     */
    @ApplicationScope
    @Provides
    BaseBackgroundExecutor provideBackgroundExecutor() {
        return new LPBackgroudExecutor(
                ThreadPool.getThreadPool());
    }

    /**
     * 提供后台网络服务的API接口
     * 注意：这里要把BaseApiService换成使用者自己实现的ApiService
     * @return
     */
//    @ApplicationScope
//    @Provides
//    BaseApiService provideApiService() {
//        return Retrofit1xUtils.createApiService(API.BASE_URL,
//                BaseApiService.class);
//    }
}
