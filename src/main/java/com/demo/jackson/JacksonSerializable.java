package com.demo.jackson;

import com.demo.AbstractSerializableByte;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * description :
 *
 * @author : chunji.luo
 * @date : 2019/1/31
 */
public class JacksonSerializable extends AbstractSerializableByte {

	private ObjectMapper mapper;

	public <T> JacksonSerializable(T object) {
		super(object);
	}

	@Override
	public <T> void init(T object) {
		mapper = new ObjectMapper();
	}

	@Override
	public <T> byte[] serializableByte(T object) {
		try {
			return mapper.writeValueAsBytes(object);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public <T> T deSerializable(Class<T> clazz, byte[] byteIn) {
		try {
			return mapper.readValue(byteIn,clazz);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
