package com.mrrun.lib.mvp.api.okhttp2;

import java.util.concurrent.TimeUnit;

import com.squareup.okhttp.OkHttpClient;

public class OkHttp2xUtils {

	private static OkHttpClient instance = null;

	public static OkHttpClient getClient() {
		if (null == instance) {
			synchronized (OkHttp2xUtils.class) {
				if (null == instance) {
					instance = new OkHttpClient();
					instance.setConnectTimeout(20, TimeUnit.SECONDS);
					instance.setReadTimeout(20, TimeUnit.SECONDS);
					instance.setWriteTimeout(20, TimeUnit.SECONDS);
				}
			}
		}
		return instance;
	}
}
