package com.baizhi.cmfz.util;

import java.util.Random;

import org.apache.commons.codec.digest.DigestUtils;

public class EncryptionUtil {

	public static String encryption(String str){
		return DigestUtils.md5Hex(str);
	}
	
	public static String getRandomSalt(int length){
		char[] c = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		
		Random ran = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sb.append(c[ran.nextInt(c.length)]);
		}
		return String.valueOf(sb);
	}
	
//	public static void main(String[] args) {
//		System.out.println(getRandomSalt(6));
//	}
}
