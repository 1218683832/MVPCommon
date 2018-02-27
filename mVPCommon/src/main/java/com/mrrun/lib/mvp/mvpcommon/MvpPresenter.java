package com.mrrun.lib.mvp.mvpcommon;

/**
 * <b>类功能描述:</b><br>
 * 核心类<br>
 * lib中所有Presenter的基类是 {@link MvpPresenter}. 这个接口里面有两个方法 <li>
 * {@link #attachView(MvpView)} <li>
 * {@link #detachView(boolean)} <br>
 * 用于跟对应的 View关联.<br> <li>{@link #attachView(MvpView)} <li>
 * {@link #detachView(boolean)}
 * 
 * @author lipin
 * @version 1.0
 * @date 2017/06/06
 * 
 */
public interface MvpPresenter<V extends MvpView> {

	/**
	 * <b>方法功能描述:</b><br>
	 * View被创建则调用这个方法，将View附加到对应的Presenter里面
	 * 
	 * @param view
	 */
	public void attachView(V view);

	/**
	 * <b>方法功能描述:</b><br>
	 * View销毁则调用这个方法。
	 * 
	 * @param retainView
	 *            是否保留View实例
	 */
	public void detachView(boolean retainView);

	/**
	 * <b>方法功能描述:</b><br>
	 * Checks if a view is attached to this presenter. You should always call
	 * this method before calling {@link #getView()} to get the view instance.
	 */
	public boolean isViewAttached();

	/**
	 * Get the attached view. You should always call {@link #isViewAttached()}
	 * to check if the view is attached to avoid NullPointerExceptions.
	 * 
	 * @return <code>null</code>, if view is not attached, otherwise the
	 *         concrete view instance
	 */
	public V getView();
}
