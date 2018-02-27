package com.mrrun.lib.mvp.mvpcommon;


public interface MvpLceView extends MvpView {

	/**
	 * <b>方法功能描述:</b><br>
	 * 显示加载视图
	 * 
	 * @param pullToRefresh
	 *            是否允许下拉刷新
	 */
	public void showLoadingView(boolean pullToRefresh);

	/**
	 * <b>方法功能描述:</b><br>
	 * 隐藏加载视图
	 */
	public void hideLoadingView();

	/**
	 * <b>方法功能描述:</b><br>
	 * 显示加载错误视图
	 * 
	 * @param e
	 *            错误信息
	 * @param pullToRefresh
	 *            是否允许下拉刷新
	 */
	public void showErrorView(Throwable e, boolean pullToRefresh);

	/**
	 * <b>方法功能描述:</b><br>
	 * 隐藏加载错误视图
	 */
	public void hideErrorView();
	
	/**
	 * <b>方法功能描述:</b><br>
	 * 加载数据。通常调用对应的Presenter方法加载所需的数据。
	 * @param pullToRefresh 是否允许下拉刷新
	 */
	public void loadData(boolean pullToRefresh);
}
