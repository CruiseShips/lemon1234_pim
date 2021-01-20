package com.lemon1234.util;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;

import com.lemon1234.entity.dict.Constants;

/**
 * RSA 加密
 */
public class RSAUtil {
	
	private static final String TYPE = "RSA";
	
	public static Map<String, String> getKey() throws Exception {
		// KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
		KeyPairGenerator kGenerator = KeyPairGenerator.getInstance(TYPE);
		// 初始化密钥对生成器，密钥大小为96-1024位
		kGenerator.initialize(1024, new SecureRandom());
		KeyPair keyPair = kGenerator.generateKeyPair();
		// 得到公钥
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		String publicKeyString = new String(Base64.encodeBase64(publicKey.getEncoded()));
		// 得到私钥
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
		
		String privateKeyString = new String(Base64.encodeBase64((privateKey.getEncoded())));
		
		Map<String, String> result = new HashMap<String, String>();
		result.put(Constants.RSA_PUBLIC_KEY, publicKeyString);
		result.put(Constants.RSA_PRIVATE_KEY, privateKeyString);
		return result;
	}

	/**
	 * RSA 公钥加密
	 * @param password
	 * @param publicKey
	 */
	public static String encryption(String password, String publicKey) throws Exception {
		byte[] decoded = Base64.decodeBase64(publicKey);
		RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, pubKey);
		cipher.init(Cipher.ENCRYPT_MODE, pubKey);
		return Base64.encodeBase64String(cipher.doFinal(password.getBytes("UTF-8")));
	}
	
	/**
	 * 私钥解密
	 * @param password
	 * @param privateKey
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String password, String privateKey) throws Exception {
		byte[] inputByte = Base64.decodeBase64(password.getBytes("UTF-8"));
		byte[] decoded = Base64.decodeBase64(privateKey);
		RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, priKey);
		return new String(cipher.doFinal(inputByte));
	}
	
	public static void main(String[] args) throws Exception {
		//加密字符串
		String message = "lemon1234+.--8";
		Map<String, String> key = RSAUtil.getKey();
		String megmi = RSAUtil.encryption(message, key.get(Constants.RSA_PUBLIC_KEY));
		System.out.println(megmi);
		System.out.println(RSAUtil.decrypt(megmi, key.get(Constants.RSA_PRIVATE_KEY)));
	}
	
}
