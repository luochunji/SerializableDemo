package com.demo.kryo;

import com.demo.AbstractSerializableByte;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * description :
 *
 * @author : chunji.luo
 * @date : 2019/1/31
 */
public class KryoSerializable extends AbstractSerializableByte {

	private Kryo kryo;

	public <T> KryoSerializable(T object) {
		super(object);
	}

	@Override
	public <T> void init(T object) {
		kryo = new Kryo();
		kryo.setReferences(false);
		//无需强制注册
		kryo.setRegistrationRequired(false);
	}

	@Override
	public <T> byte[] serializableByte(T object) {
		ByteArrayOutputStream bos = null;
		Output output = null;
		try {
			bos = new ByteArrayOutputStream();
			output = new Output(bos);
			kryo.writeObject(output, object);
		} finally {
			try {
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			output.close();
		}
		return bos.toByteArray();
	}

	@Override
	public <T> T deSerializable(Class<T> clazz, byte[] byteIn) {
		ByteArrayInputStream bis = new ByteArrayInputStream(byteIn);
		Input input = new Input(bis);
		try {
			return kryo.readObject(input, clazz);
		} finally {
			try {
				bis.close();
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
