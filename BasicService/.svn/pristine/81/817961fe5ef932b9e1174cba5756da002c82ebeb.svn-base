/**
 * 
 */
package com.microsilver.mrcard.basicservice.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * @Name com.heyin.GetPictureMd5
 * @Description 
 * 
 * @Author huwei
 * @Version 2018年4月4日 下午5:59:24
 * @Copyright  Micro Silver-SuperDelivery
 *
 */
public class GetPictureMd5 {
	public static void main(String[] args) {
		String name = "C:\\Users\\Administrator\\Desktop\\背面.png";
		String name1 = "C:\\Users\\Administrator\\Desktop\\aaa.jpg";
		System.out.println(getPictureMd5(name));
		System.out.println(getPictureMd5(name1));
		System.out.println(getPictureMd5(name).equals(getPictureMd5(name1)));
	}
	
	public static String getPictureMd5(String name) {
		String str =null;
		File file = new File(name);
		try {
		            FileInputStream fis = new FileInputStream(file);
		            MessageDigest md = MessageDigest.getInstance("MD5");
		            byte[] buffer = new byte[1024];
		            int length = -1;
		            while ((length = fis.read(buffer, 0, 1024)) != -1) {
		                md.update(buffer, 0, length);
		            }
		            BigInteger bigInt = new BigInteger(1, md.digest());
		            //生成的MD5码，有时会是31位，需要补全为32位
		             str = bigInt.toString(16);
		            int strlength = str.length();
		            if( strlength > 0 && strlength!= 32 ){
		                String val = "";
		                for( int i = strlength ; i < 32 ; i++){
		                    val = "0" + val;
		                }
		                str = val + str; 
		            }
		            //System.out.println("文件md5值：" + bigInt.toString(16));
		        } catch (FileNotFoundException e) {
		            e.printStackTrace();
		        } catch (NoSuchAlgorithmException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		return str;
	}
}
