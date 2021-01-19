package com.lemon1234.entity.dict;

public class Constants {

	/**
	 * RSA 公钥私钥
	 */
	public static enum KEY_TYPE {
		// 公钥
        PUBLICKEY("SYS_GYSY_001"),
        // 私钥
        PRIVATEKEY("SYS_GYSY_002");
		
        String dictValue;
        
        KEY_TYPE(String dictValue){
            this.dictValue = dictValue;
        }

        public String getDictValue() {
            return dictValue;
        }
    }
	
	
	/**
	 * 系统返回状态
	 */
	public static enum REQUESTCODE {
		HTTP_200(200),
		HTTP_500(500);
		
		Integer dictValue;
        
		REQUESTCODE(Integer dictValue){
            this.dictValue = dictValue;
        }

        public Integer getDictValue() {
            return dictValue;
        }
	}
	
	/**
	 * jwt token 状态返回
	 */
	public static enum JWT_TOKEN_ERROR {
		// Token不存在
		JWT_ERRCODE_NULL(4000),
		// Token过期
		JWT_ERRCODE_EXPIRE(4001),
		// 验证不通过
		JWT_ERRCODE_FAIL(4002);
		
		Integer dictValue;
        
		JWT_TOKEN_ERROR(Integer dictValue){
            this.dictValue = dictValue;
        }

        public Integer getDictValue() {
            return dictValue;
        }
	}
}
