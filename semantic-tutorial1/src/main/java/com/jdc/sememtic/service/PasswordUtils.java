package com.jdc.sememtic.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PasswordUtils {

	public static String encript(String pass) {

		try {
			byte[] data = pass.getBytes();
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			data = digest.digest(data);
			return Base64.getEncoder().encodeToString(data);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void main(String[] args) {
		System.out.println(encript("admin"));
	}
}
