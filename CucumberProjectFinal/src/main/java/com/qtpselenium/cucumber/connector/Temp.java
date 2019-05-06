package com.qtpselenium.cucumber.connector;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;

public class Temp {

	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d.toString().replaceAll(":", "-"));
		new File("D://XYZ//ABC").mkdirs();
		
		try {
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//project.properties");
		prop.load(fs);
		String env = prop.getProperty("env");
		System.out.println(env);
		fs = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//"+env+".properties");
		prop.load(fs);
		System.out.println(prop.getProperty("loginURL"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
