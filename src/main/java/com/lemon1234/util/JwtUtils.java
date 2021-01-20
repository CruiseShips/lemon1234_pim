package com.lemon1234.util;

import java.util.Base64;
import java.util.Date;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.lemon1234.entity.dict.Constants;
import com.lemon1234.sys.result.JwtResult;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

public class JwtUtils {
	
	private static final Integer TIMEOUT = 1800 * 1000;
	private static final String SECERT = "112d25046a59c37892bed1547e062ad5";
	
	/**
     * 签发JWT
     * @param id
     * @param subject 可以是JSON数据 尽可能少
     * @param ttlMillis
     * @return
     */
    public static String createJWT(String id, String subject, long ttlMillis) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        SecretKey secretKey = generalKey();
        JwtBuilder builder = Jwts.builder()
                .setId(id)
                .setSubject(subject)
                .setIssuer("Lemon1234")
                .setIssuedAt(now)
                .signWith(signatureAlgorithm, secretKey);
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date expDate = new Date(expMillis);
            builder.setExpiration(expDate);
        }
        return builder.compact();
    }

    /**
     * 验证JWT
     * @param jwtStr
     * @return
     */
    public static JwtResult validateJWT(String jwtStr) {
    	JwtResult jwtResult = new JwtResult();
        Claims claims = null;
        try {
            claims = parseJWT(jwtStr);
            jwtResult.setSuccess(true);
            jwtResult.setClaims(claims);
        } catch (ExpiredJwtException e) {
        	jwtResult.setErrCode(Constants.JWT_ERRCODE_EXPIRE);
        	jwtResult.setSuccess(false);
        } catch (SignatureException e) {
        	jwtResult.setErrCode(Constants.JWT_ERRCODE_FAIL);
            jwtResult.setSuccess(false);
        } catch (Exception e) {
        	jwtResult.setErrCode(Constants.JWT_ERRCODE_FAIL);
            jwtResult.setSuccess(false);
        }
        return jwtResult;
    }

    /**
     * 生成加密Key
     * @return
     */
    public static SecretKey generalKey() {
        byte[] encodedKey = Base64.getDecoder().decode(SECERT);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }


    /**
     * 解析JWT字符串
     * @param jwt
     * @return
     * @throws Exception
     */
    public static Claims parseJWT(String jwt) throws Exception {
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();
    }

    public static void main(String[] args) throws InterruptedException {
         // 后端生成token
        String sc=createJWT("1","jack", TIMEOUT);
        System.out.println(sc);

        // 后端验证token
        JwtResult checkResult = validateJWT(sc);
        System.out.println(checkResult.isSuccess());
        System.out.println(checkResult.getErrCode());
        Claims claims=checkResult.getClaims();
        System.out.println(claims);
        System.out.println(claims.getId());
        System.out.println(claims.getSubject());

        // 刷新token 重新生成token
        Claims claims2=validateJWT(sc).getClaims();
        String sc2=createJWT(claims2.getId(),claims2.getSubject(), TIMEOUT);
        System.out.println(sc2);
    }
}
