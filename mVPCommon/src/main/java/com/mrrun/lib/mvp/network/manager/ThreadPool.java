package com.mrrun.lib.mvp.network.manager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

	private static ThreadPool singleton = null;

	private ExecutorService executorService;

	private ThreadPool() {
		final int numberCores = Runtime.getRuntime().availableProcessors();
		this.executorService = Executors
				.newFixedThreadPool(numberCores * 2 + 1);
	}

	public static ThreadPool getThreadPool() {
		if (null == singleton) {
			synchronized (ThreadPool.class) {
				if (null == singleton) {
					singleton = new ThreadPool();
				}
			}
		}
		return singleton;
	}

	public void execute(Runnable runnable) {
		executorService.execute(runnable);
	}
}
