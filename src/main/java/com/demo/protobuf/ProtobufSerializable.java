package com.demo.protobuf;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.demo.AbstractSerializableByte;

import java.io.IOException;

/**
 * description :
 *
 * @author : chunji.luo
 * @date : 2019/1/31
 */
public class ProtobufSerializable extends AbstractSerializableByte {

	private Codec userCodec;

	public <T> ProtobufSerializable(T object) {
		super(object);
	}

	@Override
	public <T> void init(T object) {
		this.userCodec = ProtobufProxy.create(object.getClass());
	}

	@Override
	public <T> byte[] serializableByte(T object) {
		try {
			return userCodec.encode(object);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public <T> T deSerializable(Class<T> clazz, byte[] byteIn) {
		return deSerializable(byteIn);
	}

	private <T> T deSerializable(byte[] byteIn) {
		try {
			return (T) userCodec.decode(byteIn);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
