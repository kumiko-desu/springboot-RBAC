package com.hm.Utils;

import org.springframework.util.DigestUtils;

import java.util.UUID;

public class UserUtils {

    /**
        * @return java.lang.String
        * @date 2021/6/29 11:20
        * @description 生成salt返回
    */
    public static String createSalt(){
//        SecureRandom random = new SecureRandom();
//        byte bytes[] = new byte[15];
//        random.nextBytes(bytes);
//        Base64.Encoder encoder = Base64.getUrlEncoder().withoutPadding();
//        return encoder.encodeToString(bytes);
        return UUID.randomUUID().toString();
    }

    /**
        * @return java.lang.String
        * @date 2021/6/29 11:20
        * @description 根据密码和盐计算哈希密码
    */
    public static String calcHashPwd(String password, String salt){
        String base = password + salt;
        String hashPwd = DigestUtils.md5DigestAsHex(base.getBytes());
        return hashPwd;
    }
}
