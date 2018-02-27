package com.mrrun.lib.mvp.api.retrofit1;

import com.mrrun.lib.mvp.api.okhttp2.OkHttp2xUtils;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

public class Retrofit1xUtils {

	public static <T> T createApiService(String endpoint, Class<T> clz) {
		RestAdapter restAdapter = new RestAdapter.Builder()
				.setEndpoint(endpoint)
				.setClient(new OkClient(OkHttp2xUtils.getClient()))
				.setLogLevel(RestAdapter.LogLevel.FULL)
				.build();
		T service = restAdapter.create(clz);
		return service;
	}
}
