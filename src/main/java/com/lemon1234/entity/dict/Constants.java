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

        public static String getDictFlag(){
            return KEY_TYPE.class.getSimpleName();
        }
    }
	
	
	/**
	 * 系统返回状态
	 */
	public static enum REQUESTCODE {
		HTTP_200("SYS_REQUEST_200"),
		HTTP_500("SYS_REQUEST_200");
		
		String dictValue;
        
		REQUESTCODE(String dictValue){
            this.dictValue = dictValue;
        }

        public String getDictValue() {
            return dictValue;
        }

        public static String getDictFlag(){
            return KEY_TYPE.class.getSimpleName();
        }
	}
}
