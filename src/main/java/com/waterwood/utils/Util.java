package com.waterwood.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.InetAddress;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

/**
 * 通用工具类
 */
public class Util {
	/**
	 * 对字符串进行MD5加密
	 * 
	 * @param str
	 * @return String
	 */
	/*public static String md5Encryption(String str) {
		String newStr = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			BASE64Encoder base = new BASE64Encoder();
			newStr = base.encode(md5.digest(str.getBytes("UTF-8")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newStr;
	}*/
	

	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 *            字符串
	 * @return true：为空； false：非空
	 */
	public static boolean isNull(String str) {
		if (str != null && !str.trim().equals("")) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * 得到抛异常的信息
	 * @param t
	 * @return
	 */
	public static String getTrace(Throwable t) {
        StringWriter stringWriter= new StringWriter();
        PrintWriter writer= new PrintWriter(stringWriter);
        t.printStackTrace(writer);
        StringBuffer buffer= stringWriter.getBuffer();
        return buffer.toString();
    }
	
	// 全局时间格式化器
	public static final SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	public static final SimpleDateFormat shortsdf = new SimpleDateFormat(
			"yyyy-MM-dd");
	public static final SimpleDateFormat misdf = new SimpleDateFormat(
			"HH:mm:ss");
	public static final SimpleDateFormat directorySdf = new SimpleDateFormat(
			"yyyyMMdd");// 通常用于目录建立
	public static final SimpleDateFormat nameSdf = new SimpleDateFormat(
			"yyyyMMddHHmmssSSS");
	
	/**
	 * Return http://域名/server名
	 * http://localhost:8080/traces/
	 * */
	public static String getServerFullPath(HttpServletRequest request){
		return request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
	}
	
	private static Random myRand;
	private static SecureRandom mySecureRand;
	private static String s_id;
	private static final int PAD_BELOW = 0x10;
	private static final int TWO_BYTES = 0xFF;
	/**
	 * 生成12位数GUID
	 * @param secure
	 * @return
	 */
	public static String getRandomGUID(boolean secure){
		String valueBeforeMD5 = "";
        String valueAfterMD5 = "";
		mySecureRand = new SecureRandom();
	    long secureInitializer = mySecureRand.nextLong();
	    myRand = new Random(secureInitializer);
	    MessageDigest md5 = null;
	    StringBuffer sbValueBeforeMD5 = new StringBuffer(128);
	    StringBuffer sb2 = new StringBuffer(64);
	    try {
	    	s_id = InetAddress.getLocalHost().toString();
	    	md5 = MessageDigest.getInstance("MD5");
	    	
	    	long time = System.currentTimeMillis();
	         long rand = 0;

	         if (secure) {
	            rand = mySecureRand.nextLong();
	         } else {
	            rand = myRand.nextLong();
	         }
	         sbValueBeforeMD5.append(s_id);
	         sbValueBeforeMD5.append(":");
	         sbValueBeforeMD5.append(Long.toString(time));
	         sbValueBeforeMD5.append(":");
	         sbValueBeforeMD5.append(Long.toString(rand));

	         valueBeforeMD5 = sbValueBeforeMD5.toString();
	         md5.update(valueBeforeMD5.getBytes());

	         byte[] array = md5.digest();
	         StringBuffer sb = new StringBuffer(32);
	         for (int j = 0; j < array.length; ++j) {
	            int b = array[j] & TWO_BYTES;
	            if (b < PAD_BELOW)
	               sb.append('0');
	            sb.append(Integer.toHexString(b));
	         }

	         valueAfterMD5 = sb.toString();
	         
	         String raw = valueAfterMD5.toUpperCase();
		     
		     
		     sb2.append(raw.substring(0, 4));
		     //sb2.append("-");
		     sb2.append(raw.substring(4, 8));
		     //sb2.append("-");
		     sb2.append(raw.substring(8, 12));
		     //sb2.append("-");
		     sb2.append(raw.substring(12, 16));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return sb2.toString();
	}
	
	/**
	 * 随机生成UUID
	 * 
	 * @return
	 */
	public static synchronized String getUUID() {
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		String uuidStr = str.replace("-", "");
		return uuidStr;
	}
}
