package com.demo.fastjson;

import com.alibaba.fastjson.JSONObject;
import com.demo.AbstractSerializableString;

/**
 * description :
 *
 * @author : chunji.luo
 * @date : 2019/1/31
 */
public class FastJsonSerializable extends AbstractSerializableString {

	public <T> FastJsonSerializable(T object) {
		super(object);
	}

	@Override
	public <T> void doSerializable(T object) {
		String str = serializableStr(object);
		deSerializable((Class<T>) object.getClass(), str);
	}

	@Override
	public <T> String serializableStr(T object) {
		return JSONObject.toJSONString(object);
	}

	@Override
	public <T> T deSerializable(Class<T> clazz, String strIn) {
		return JSONObject.parseObject(strIn, clazz);
	}
}
