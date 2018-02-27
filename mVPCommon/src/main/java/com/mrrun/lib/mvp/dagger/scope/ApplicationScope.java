package com.mrrun.lib.mvp.dagger.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by lipin on 2017/6/30.
 * <li>加在Component上表示此Component生命周期在应用程序范围内
 * <li>加在Module的provide方法上表示提供的对象是应用程序范围内的单例
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ApplicationScope {
}
