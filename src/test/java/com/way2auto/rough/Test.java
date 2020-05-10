package com.way2auto.rough;

import java.io.FileInputStream;

import java.util.Properties;

public class Test {

	public static void main(String[] args) throws Throwable {
		
		System.out.println(System.getProperty("user.dir"));
		Properties config = new Properties();
		Properties or = new Properties();
		FileInputStream input = new FileInputStream((System.getProperty("user.dir")) + "\\src\\test\\resources\\properties\\config.properties");
		//System.out.println((System.getProperty("user.dir")));
		FileInputStream input2 = new FileInputStream("E:\\frameworkmindq\\datadriven\\src\\test\\resources\\properties\\OR.properties");
		config.load(input);
		or.load(input2);
		System.out.println(config.getProperty("browser"));
		System.out.println(or.getProperty("bmlBtn"));

	}

}
