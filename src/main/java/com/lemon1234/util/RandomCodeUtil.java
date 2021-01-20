package com.lemon1234.util;

import java.util.Map;

import com.lemon1234.entity.dict.Constants;

public class RandomCodeUtil {

	private static final String[] code = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",
			"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
			"1","2","3","4","5","6","7","8","9","0",
			"+","-","*",".",",",".",";","'","[","]","~","!","@","#","$","%",
			"^","&","*","(",")","_","+","{","}",":",">","?","<"};
	
	/**
	 * 生成 count 位随机码
	 * 
	 * @param count
	 * @return
	 * @throws Exception
	 */
	public static String randomCode(int count) throws Exception {
		StringBuffer sBuffer = new StringBuffer();
		
		int codeLength = code.length;
		
		for(int i = 0; i < count; i++) {
			sBuffer.append(code[(int)(Math.random()*codeLength)]);
		}
		
		return sBuffer.toString();
	}
	
	public static void main(String[] args) throws Exception {
		String a = RandomCodeUtil.randomCode(8);
		System.out.println(a);
		Map<String, String> key = RSAUtil.getKey();
		String megmi = RSAUtil.encryption(a, key.get(Constants.RSA_PUBLIC_KEY));
		System.out.println(megmi);
		System.out.println(RSAUtil.decrypt(megmi, key.get(Constants.RSA_PRIVATE_KEY)));
	}
	
}
