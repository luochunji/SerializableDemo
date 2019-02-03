package com.demo;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import org.msgpack.annotation.Message;

import java.io.Serializable;

/**
 * description :
 *
 * @author : chunji.luo
 * @date : 2019/1/31
 */
@Message
public class User implements Serializable {

	@Protobuf(fieldType = FieldType.STRING,order = 1)
	private String name;

	@Protobuf(fieldType = FieldType.INT32,order = 2)
	private int age;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
