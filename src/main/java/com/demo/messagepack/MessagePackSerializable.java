package com.demo.messagepack;

import com.demo.AbstractSerializableByte;
import org.msgpack.MessagePack;

import java.io.IOException;

/**
 * description :
 *
 * @author : chunji.luo
 * @date : 2019/1/31
 */
public class MessagePackSerializable extends AbstractSerializableByte {

	private MessagePack msgpack;

	public <T> MessagePackSerializable(T object) {
		super(object);
	}

	@Override
	public <T> void init(T object) {
		msgpack = new MessagePack();
	}

	@Override
	public <T> byte[] serializableByte(T object) {
		try {
			return msgpack.write(object);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public <T> T deSerializable(Class<T> clazz, byte[] byteIn) {
		try {
			return msgpack.read(byteIn, clazz);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
