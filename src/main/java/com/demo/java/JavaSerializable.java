package com.demo.java;


import com.demo.AbstractSerializableByte;

import java.io.*;

/**
 * description :
 *
 * @author : chunji.luo
 * @date : 2019/1/31
 */
public class JavaSerializable extends AbstractSerializableByte {


	public <T> JavaSerializable(T object) {
		super(object);
	}

	@Override
	public <T> byte[] serializableByte(T object) {
		ByteArrayOutputStream bos = null;
		ObjectOutputStream oos = null;

		try {
			bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			oos.writeObject(object);
			oos.flush();
			return bos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bos != null) {
					bos.close();
				}
				if (oos != null) {
					oos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public <T> T deSerializable(Class<T> clazz, byte[] byteIn) {
		ByteArrayInputStream bis = null;
		ObjectInputStream ois = null;
		try {
			bis = new ByteArrayInputStream(byteIn);
			ois = new ObjectInputStream(bis);
			return (T) ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != bis) {
					bis.close();
				}
				if (null != ois) {
					ois.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
