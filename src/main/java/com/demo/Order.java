package com.demo;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import org.msgpack.annotation.Message;

import java.io.Serializable;

/**
 * description :
 *
 * @author : chunji.luo
 * @date : 2019/2/1
 */
@Message
public class Order implements Serializable {

	@Protobuf(fieldType = FieldType.INT64,order = 1)
	private long id;

	@Protobuf(fieldType = FieldType.STRING,order = 2)
	private String orderNo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
}
