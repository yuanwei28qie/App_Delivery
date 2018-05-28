/**
 * 
 */
package com.microsilver.mrcard.basicservice.utils;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

import com.microsilver.mrcard.basicservice.common.Consts;

/**
 * 
 * @Name com.heyin.Huoquwenjian
 * @Description
 * 
 * @Author huwei
 * @Version 2018年4月4日 上午10:27:54
 * @Copyright Micro Silver-SuperDelivery
 *
 */
public class GetAllPictures {
	/*
	 * 获取一个想要的指定文件的集合，获取文件夹下(包含子目录的所有.java的文件对象，并存储到集合中) 思路： 1，既然包含子目录，就需要递归。
	 * 2，在递归过程中需要过滤器 3，满足条件，都添加到集合中
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File dir = new File(Consts.PICTURES_ADDRESS);
		List<File> list = new ArrayList<File>();
		FileFilter filterbyjava = new Filterbyjava(".jpg");
		getFileList(dir, list, filterbyjava);
		for (File list1 : list) {
			System.out.println(list1);
			System.out.println(list1.getPath());
		}
	}

	public static void getFileList(File dir, List<File> list, FileFilter filterbyjava) {

		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				getFileList(file, list, filterbyjava);
			} else {
				if (filterbyjava.accept(file)) {
					list.add(file);
				}
			}
		}
	}
}
