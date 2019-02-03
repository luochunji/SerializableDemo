package com.demo;

/**
 * description :
 *
 * @author : chunji.luo
 * @date : 2019/2/1
 */
public abstract class AbstractSerializableString implements ISerializable {

	public <T> AbstractSerializableString(T object) {
		init(object);
		for (int i = 0; i < Constant.total; i++) {
			doSerializable(object);
		}
	}

	protected <T> void init(T object) {

	}

	@Override
	public <T> void doSerializable(T object) {
		String str = serializableStr(object);
		deSerializable((Class<T>) object.getClass(), str);
	}

	protected abstract <T> String serializableStr(T object);

	protected abstract <T> T deSerializable(Class<T> clazz, String strIn);
}
