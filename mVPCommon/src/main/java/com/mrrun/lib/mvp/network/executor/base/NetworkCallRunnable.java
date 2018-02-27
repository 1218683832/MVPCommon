package com.mrrun.lib.mvp.network.executor.base;

import retrofit.RetrofitError;

public abstract class NetworkCallRunnable<T>{

	public void onPreCall() {}

    public abstract T doBackgroundCall() throws RetrofitError;

    public abstract void onSuccess(T result);

    public abstract void onError(Throwable re);

    public void onFinished() {}
}
