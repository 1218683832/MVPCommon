package com.mrrun.lib.mvp.mvpcommon;

import android.os.Bundle;

import com.mrrun.lib.androidbase.base.activity.BaseActivity;
import com.mrrun.lib.mvp.app.MvpApplication;
import com.mrrun.lib.mvp.dagger.BaseApplicationComponent;

import javax.inject.Inject;

public abstract class BaseMvpActivity<P extends BaseMvpPresenter<?>> extends
		BaseActivity implements MvpView {

	@Inject
	protected P mPresenter;

	/**
	 * 是否保存View实例
	 */
	protected boolean mRetainView = false;

	/**
	 * <b>方法功能描述:</b><br>
	 * 用于创建Presenter和判断是否使用MVP模式(由子类实现)
	 * 
	 * @return P
	 */
	public abstract P createPresenter();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainView(mRetainView);
		createPresenter();
		injectDependencies();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (null != mPresenter) {
			mPresenter.detachView(mRetainView);
		}
	}

	/**
	 * <b>方法功能描述:</b><br>
	 * 注入依赖关系
	 */
	protected abstract void injectDependencies();

	/**
	 * <b>方法功能描述:</b><br>
	 * 获取是否保留View实例
	 * 
	 * @return
	 */
	public final boolean isRetainView() {
		return mRetainView;
	}

	/**
	 * <b>方法功能描述:</b><br>
	 * 设置是否在Presenter中保留View实例
	 * 
	 * @param retainView
	 */
	public final void setRetainView(boolean retainView) {
		this.mRetainView = retainView;
	}

	protected BaseApplicationComponent getApplicationComponent() {
		return ((MvpApplication) getApplication()).getApplicationComponent();
//		return ((MvpApplication)MvpApplication.appContext).getApplicationComponent();
	}
}
