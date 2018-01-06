package com.jdc.sdoctor.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PasswordUtils {

	public static String encript(String pass) {
		try {
			byte[] data = pass.getBytes();
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] encdata = digest.digest(data);
			return Base64.getEncoder().encodeToString(encdata);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(encript("admin"));
	}
}
