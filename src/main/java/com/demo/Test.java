package com.demo;


import com.demo.protobuf.ProtobufSerializable;

/**
 * description :
 *
 * @author : chunji.luo
 * @date : 2019/1/31
 */
public class Test {

	public static void main(String[] args) throws Exception {
		User user = new User();
		user.setName("小明");
		user.setAge(18);

		long total = 0L;
		ISerializable serializable = new ProtobufSerializable(user);
		//测试次数
		int loop = 100;
		for (int i = 0; i < loop; i++) {
			long start = System.currentTimeMillis();
			for (int j = 0; j < Constant.total; j++) {
				serializable.doSerializable(user);
			}
			long time = System.currentTimeMillis() - start;
			System.out.printf("第%d次耗时:%dms \n", i + 1, time);
			total += time;
		}
		System.out.printf("平均耗时:%dms \n", (total / loop));
	}
}
