package com.lemon1234.util;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.lemon1234.entity.dict.Constants;

/**
 * 随机密码生成
 */
@Component
public class RandomCodeUtil {
	
	private Logger logger = LoggerFactory.getLogger(RandomCodeUtil.class);
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	private final String[] code = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",
			"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
			"1","2","3","4","5","6","7","8","9","0",
			"+","-","*",".",",",".",";","'","[","]","~","!","@","#","$","%",
			"^","&","*","(",")","_","+","{","}",":",">","?","<"};
	
	/**
	 * 生成 count 位随机码
	 * 
	 * @param count
	 * @return 明码 和 加密后的明码
	 * @throws Exception
	 */
	public Map<String, String> randomCode(int count) throws Exception {
		
		if(count < 10 || count > 20) {
			count = 18;
		}
		
		StringBuffer sBuffer = new StringBuffer();
		
		int codeLength = code.length;
		
		for(int i = 0; i < count; i++) {
			sBuffer.append(code[(int)(Math.random()*codeLength)]);
		}
		
		String plainCode = sBuffer.toString();
		
		String encryptCode = bCryptPasswordEncoder.encode(plainCode);
		
		logger.info("随机密码生成：" + plainCode + "，生成加密密码" + encryptCode);
		
		Map<String, String> result = new HashMap<String, String>();
		result.put(Constants.PLAINCODE, plainCode);
		result.put(Constants.ENCRYPTCODE, encryptCode);
		
		return result;
	}
	
}
