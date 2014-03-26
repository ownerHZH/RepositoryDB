package com.cqjt.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil {
	public static Gson getGson() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		return gsonBuilder.setDateFormat("yyyy/MM/dd HH:mm:ss").create();
	}
}
