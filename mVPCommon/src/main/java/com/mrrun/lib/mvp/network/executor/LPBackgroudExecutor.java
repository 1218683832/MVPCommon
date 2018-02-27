package com.mrrun.lib.mvp.network.executor;

import retrofit.RetrofitError;

import com.mrrun.lib.mvp.network.executor.base.BackgroundCallRunnable;
import com.mrrun.lib.mvp.network.executor.base.BaseBackgroundExecutor;
import com.mrrun.lib.mvp.network.executor.base.NetworkCallRunnable;
import com.mrrun.lib.mvp.network.manager.ThreadPool;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;

public class LPBackgroudExecutor implements BaseBackgroundExecutor {

	private static final Handler sHandler = new Handler(Looper.getMainLooper());

	private final ThreadPool mNetThreadPool;

	public LPBackgroudExecutor(ThreadPool netThreadPool) {
		super();
		this.mNetThreadPool = netThreadPool;
	}

	// 使用代理的方式
	@Override
	public <T> void execute(NetworkCallRunnable<T> runnable) {
		this.mNetThreadPool.execute(new NetworkCallRunnableProxy<T>(runnable));
	}

	// 使用代理的方式
	@Override
	public <T> void execute(BackgroundCallRunnable<T> runnable) {
		this.mNetThreadPool.execute(new BackgroundCallRunner<T>(runnable));
	}


	private class BackgroundCallRunner<R> implements Runnable {

		private final BackgroundCallRunnable<R> mBackgroundRunnable;

		BackgroundCallRunner(BackgroundCallRunnable<R> runnable) {
			mBackgroundRunnable = runnable;
		}

		@Override
		public final void run() {
			Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);

			sHandler.post(new Runnable() {
				@Override
				public void run() {
					mBackgroundRunnable.preExecute();
				}
			});

			R result = mBackgroundRunnable.runAsync();

			sHandler.post(new ResultCallback(result));
		}

		private class ResultCallback implements Runnable {
			private final R mResult;

			private ResultCallback(R result) {
				mResult = result;
			}

			@Override
			public void run() {
				mBackgroundRunnable.postExecute(mResult);
			}
		}
	}

	private class NetworkCallRunnableProxy<T> implements Runnable {

		private final NetworkCallRunnable<T> realObject;

		public NetworkCallRunnableProxy(NetworkCallRunnable<T> runnable) {
			this.realObject = runnable;
		}

		@Override
		public void run() {
			Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);

			// 网络请求之前的操作
			sHandler.post(new Runnable() {
				@Override
				public void run() {
					realObject.onPreCall();
				}
			});

			T result = null;
			RetrofitError retrofitError = null;
			try {
				// 网络请求操作
				result = realObject.doBackgroundCall();
			} catch (RetrofitError re) {
				retrofitError = re;
			}

			// 网络请求之后的操作
			sHandler.post(new ResultCallback(result, retrofitError));
		}

		private class ResultCallback implements Runnable {

			private final T mResult;

			private final RetrofitError mRetrofitError;

			private ResultCallback(T result, RetrofitError retrofitError) {
				mResult = result;
				mRetrofitError = retrofitError;
			}

			@Override
			public void run() {
				// 网络请求成功及结果
				if (mResult != null) {
					realObject.onSuccess(mResult);
				} else if (mRetrofitError != null) {// 网络请求失败及错误信息
					realObject.onError(mRetrofitError);
				} else if (mResult == null) {
					Throwable e = new Throwable("doBackgroundCall method can't be return null!");
					realObject.onError(e);
				}
				// 一次网络请求结束
				realObject.onFinished();
			}
		}
	}
}
