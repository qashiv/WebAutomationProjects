package com.lizt.automation.utils;

import java.io.InputStream;
import java.util.Properties;

public final class Config {
	private static final Properties P = new Properties();
	static {
		try (InputStream in = Config.class.getClassLoader().getResourceAsStream("config.properties")) {
			if (in != null)
				P.load(in);
		} catch (Exception e) {
			throw new RuntimeException("Unable to load config.properties", e);
		}
	}

	private Config() {
	}

	public static String get(String key) {
		return System.getProperty(key, P.getProperty(key));
	}

	public static String appPath() {
		return get("app");
	}

	public static String deviceName() {
		return get("deviceName");
	}

	public static String appPackage() {
		return get("appPackage");
	}

	public static String appActivity() {
		return get("appActivity");
	}

	public static String server() {
		return get("appiumServer");
	}
}
