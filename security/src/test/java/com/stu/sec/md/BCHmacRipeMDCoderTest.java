package com.stu.sec.md;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * HmacRipeMD校验
 * 
 * @author
 * @version 1.0
 * @since 1.0
 */
public class BCHmacRipeMDCoderTest {

	/**
	 * 测试HmacRipeMD128
	 * 
	 * @throws Exception
	 */
	@Test
	public final void testEncodeHmacRipeMD128() throws Exception {

		String str = "HmacRipeMD128消息摘要";

		// 初始化密钥
		byte[] key = BCHmacRipeMDCoder.initHmacRipeMD128Key();

		// 获得摘要信息
		byte[] data1 = BCHmacRipeMDCoder.encodeHmacRipeMD128(str.getBytes(), key);
		byte[] data2 = BCHmacRipeMDCoder.encodeHmacRipeMD128(str.getBytes(), key);

		// 校验
		assertArrayEquals(data1, data2);
	}

	/**
	 * 测试HmacRipeMD128Hex
	 * 
	 * @throws Exception
	 */
	@Test
	public final void testEncodeHmacRipeMD128Hex() throws Exception {

		String str = "HmacRipeMD128Hex消息摘要";

		// 初始化密钥
		byte[] key = BCHmacRipeMDCoder.initHmacRipeMD128Key();

		// 获得摘要信息
		String data1 = BCHmacRipeMDCoder.encodeHmacRipeMD128Hex(str.getBytes(), key);
		String data2 = BCHmacRipeMDCoder.encodeHmacRipeMD128Hex(str.getBytes(), key);

		System.err.println("原文：\t" + str);

		System.err.println("HmacRipeMD128Hex-1：\t" + data1);
		System.err.println("HmacRipeMD128Hex-2：\t" + data2);

		// 校验
		assertEquals(data1, data2);
	}

	/**
	 * 测试HmacRipeMD160
	 * 
	 * @throws Exception
	 */
	@Test
	public final void testEncodeHmacRipeMD160() throws Exception {

		String str = "HmacRipeMD160消息摘要";

		// 初始化密钥
		byte[] key = BCHmacRipeMDCoder.initHmacRipeMD160Key();

		// 获得摘要信息
		byte[] data1 = BCHmacRipeMDCoder.encodeHmacRipeMD160(str.getBytes(), key);
		byte[] data2 = BCHmacRipeMDCoder.encodeHmacRipeMD160(str.getBytes(), key);

		// 校验
		assertArrayEquals(data1, data2);
	}

	/**
	 * 测试HmacRipeMD160Hex
	 * 
	 * @throws Exception
	 */
	@Test
	public final void testEncodeHmacMD4Hex() throws Exception {

		String str = "HmacRipeMD160Hex消息摘要";

		// 初始化密钥
		byte[] key = BCHmacRipeMDCoder.initHmacRipeMD160Key();

		// 获得摘要信息
		String data1 = BCHmacRipeMDCoder.encodeHmacRipeMD160Hex(str.getBytes(), key);
		String data2 = BCHmacRipeMDCoder.encodeHmacRipeMD160Hex(str.getBytes(), key);

		System.err.println("原文：\t" + str);

		System.err.println("HmacRipeMD160Hex-1：\t" + data1);
		System.err.println("HmacRipeMD160Hex-2：\t" + data2);

		// 校验
		assertEquals(data1, data2);
	}

}
