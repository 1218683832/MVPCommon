package com.mrrun.lib.mvp.network.executor.base;


public interface BaseBackgroundExecutor {
	
	<T> void execute(NetworkCallRunnable<T> runnable);

    <T> void execute(BackgroundCallRunnable<T> runnable);
}
