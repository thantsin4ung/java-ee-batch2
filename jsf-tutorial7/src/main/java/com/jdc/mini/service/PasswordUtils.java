package com.jdc.mini.service;

import java.security.MessageDigest;
import java.util.Base64;

public class PasswordUtils {

	public static String encript(String password) {
		try {

			byte[] array = password.getBytes();
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(array);
			return Base64.getEncoder().encodeToString(hash);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(encript("admin"));
	}

}
