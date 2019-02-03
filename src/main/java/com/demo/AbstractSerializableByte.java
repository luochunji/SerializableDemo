package com.demo;

/**
 * description :
 *
 * @author : chunji.luo
 * @date : 2019/2/1
 */
public abstract class AbstractSerializableByte implements ISerializable{

	public <T> AbstractSerializableByte(T object) {
		init(object);
		for (int i = 0; i < Constant.total; i++) {
			doSerializable(object);
		}
	}

	public <T> void init(T object) {
	}

	@Override
	public <T> void doSerializable(T object){
		byte[] bytes = serializableByte(object);
		deSerializable((Class<T>) object.getClass(),bytes);
	}

	protected abstract <T> byte[] serializableByte(T object);

	protected abstract <T> T deSerializable(Class<T> clazz,byte[] byteIn);
}
