package com.online.taxi.entity;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @Auther: lsk
 * @Date: 2022/7/16 - 07 - 16 - 20:40
 * @Description: com.online.taxi.entity
 * @version: 1.0
 */
@Slf4j
public class EncriptUtil {
    private static final String KEY = "pio-tech";

    /**
     * 解密数据
     */
    public static String decrypt(String message){
        try {
            byte[] bytesrc = convertHexString(message);
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            DESKeySpec desKeySpec = new DESKeySpec(KEY.getBytes("UTF-8"));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
            IvParameterSpec iv = new IvParameterSpec(KEY.getBytes("UTF-8"));
            cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
            byte[] bytes = cipher.doFinal(bytesrc);
            return new String(bytes);

        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }


    /**
     * 加密数据
     */
    public static byte[] encrypt(String message){
        try {
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            DESKeySpec desKeySpec = new DESKeySpec(KEY.getBytes("UTF-8"));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
            IvParameterSpec iv = new IvParameterSpec(KEY.getBytes("UTF-8"));
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
            return cipher.doFinal(message.getBytes("UTF-8"));
        }catch (Exception e){

        }
        return new byte[0];
    }

    public static byte[] convertHexString(String ss){
        byte[] digest = new byte[ss.length() / 2];
        for(int i = 0; i < digest.length; i++){
            String byteString = ss.substring(2 * i, 2 * i + 2);
            int byteValue = Integer.parseInt(byteString, 16);
            digest[i] = (byte) byteValue;
        }
        return digest;
    }


    public static String toHexString(byte[] b){
        StringBuffer hexString = new StringBuffer();
        for(int i = 0; i < b.length; i++){
            String plainText = Integer.toHexString(0xff & b[i]);
            if(plainText.length() < 2){
                plainText = "0" + plainText;
            }
            hexString.append(plainText);
        }
        return hexString.toString();
    }

    /**
     * 手机号加密
     *
     * @param phoneNumber
     * @return
     */
    public static String encryptionPhoneNumber(String phoneNumber){
        log.info("手机号===" + phoneNumber);
        String passengerPhoneNumber = null;
        try {
            String phoneNumbers = URLEncoder.encode(phoneNumber, "utf-8").toLowerCase();
            passengerPhoneNumber = toHexString(EncriptUtil.encrypt(phoneNumbers)).toUpperCase();
            log.info("加密手机号===" + passengerPhoneNumber);
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return passengerPhoneNumber;
    }

    /**
     * 手机号解密
     *
     * @param phoneNumber
     * @return
     */
    public static String decryptionPhoneNumber(String phoneNumber){
        log.info("加密的手机号===" + phoneNumber);
        String phoneNumbers = null;
        try {
            phoneNumbers = URLDecoder.decode(decrypt(phoneNumber), "utf-8");
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();;
        }
        log.info("解密后的手机号===" + phoneNumbers);
        return phoneNumbers;
    }


    public static void main(String[] args) {
        String pn = "18755175162";
        String enPn = encryptionPhoneNumber(pn);
        System.out.println(enPn);
        String dePn = decryptionPhoneNumber(enPn);
        System.out.println(dePn);

        String message = "你好!";
        byte[] bytes = encrypt(message);
        String enCodeme = toHexString(bytes).toUpperCase();
        System.out.println(enCodeme);
        System.out.println(decrypt(enCodeme));
    }


}
