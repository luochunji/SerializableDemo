package com.demo.gson;

import com.demo.AbstractSerializableString;
import com.google.gson.Gson;

/**
 * description :
 *
 * @author : chunji.luo
 * @date : 2019/1/31
 */
public class GsonSerializable extends AbstractSerializableString {

	private Gson gson;

	public <T> GsonSerializable(T object) {
		super(object);
	}

	@Override
	protected <T> void init(T object) {
		gson = new Gson();
	}

	@Override
	public <T> String serializableStr(T object) {
		return gson.toJson(object);
	}

	@Override
	public <T> T deSerializable(Class<T> clazz, String strIn) {
		return gson.fromJson(strIn, clazz);
	}
}
