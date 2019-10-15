package com.stu.sec.md;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * MD4校验
 * 
 * @author
 * @version 1.0
 * @since 1.0
 */
public class BCMD4CoderTest {

	/**
	 * 测试MD4
	 * 
	 * @throws Exception
	 */
	@Test
	public final void testEncodeMD4() throws Exception {
		String str = "MD4消息摘要";

		// 获得摘要信息
		byte[] data1 = BCMD4Coder.encodeMD4(str.getBytes());
		byte[] data2 = BCMD4Coder.encodeMD4(str.getBytes());

		// 校验
		assertArrayEquals(data1, data2);
	}

	/**
	 * 测试MD4Hex
	 * 
	 * @throws Exception
	 */
	@Test
	public final void testEncodeMD4Hex() throws Exception {
		String str = "MD4Hex消息摘要";

		// 获得摘要信息
		String data1 = BCMD4Coder.encodeMD4Hex(str.getBytes());
		String data2 = BCMD4Coder.encodeMD4Hex(str.getBytes());

		System.err.println("原文：\t" + str);

		System.err.println("MD4Hex-1：\t" + data1);
		System.err.println("MD4Hex-2：\t" + data2);

		// 校验
		assertEquals(data1, data2);
	}

}
