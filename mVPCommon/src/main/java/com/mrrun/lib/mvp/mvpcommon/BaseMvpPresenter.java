package com.mrrun.lib.mvp.mvpcommon;

import java.lang.ref.WeakReference;

public abstract class BaseMvpPresenter<V extends MvpView> implements
		MvpPresenter<V> {

	/**
	 * 为了避免内存泄露，它只持有View的弱引用
	 */
	protected WeakReference<V> mViewRef;

	public BaseMvpPresenter(V view) {
		super();
		this.attachView(view);
	}

	/**
	 * 绑定View层
	 * @param view
	 */
	@Override
	public void attachView(V view) {
		mViewRef = new WeakReference<V>(view);
	}

	/**
	 * 解绑View层
	 * @param retainView
	 */
	@Override
	public void detachView(boolean retainView) {
		if (mViewRef != null) {
			mViewRef.clear();
			mViewRef = null;
		}
	}

	@Override
	public boolean isViewAttached() {
		return mViewRef != null && mViewRef.get() != null;
	}

	@Override
	public V getView() {
		return mViewRef == null ? null : mViewRef.get();
	}
}
