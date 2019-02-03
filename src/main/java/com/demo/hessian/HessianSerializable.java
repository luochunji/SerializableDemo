package com.demo.hessian;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import com.demo.AbstractSerializableByte;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * description :
 *
 * @author : chunji.luo
 * @date : 2019/1/31
 */
public class HessianSerializable extends AbstractSerializableByte {

	public <T> HessianSerializable(T object){
		super(object);
	}

	@Override
	public <T> byte[] serializableByte(T object) {
		ByteArrayOutputStream bos = null;
		Hessian2Output ho = null;
		try {
			bos = new ByteArrayOutputStream();
			ho = new Hessian2Output(bos);
			ho.writeObject(object);
			ho.flush();
			return bos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != bos) {
					bos.close();
				}
				if (null != ho) {
					ho.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public <T> T deSerializable(Class<T> clazz, byte[] byteIn) {
		return deSerializable(byteIn);
	}

	private  <T> T deSerializable(byte[] byteIn) {
		ByteArrayInputStream bis = new ByteArrayInputStream(byteIn);
		Hessian2Input hInput = new Hessian2Input(bis);
		try {
			return (T) hInput.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bis.close();
				hInput.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
