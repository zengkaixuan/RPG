package cn.com.rpg.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class configManager {//配置文件对象
	private static Properties properties;
	private static configManager configMa;
	
	private configManager() {
		//读取配置文件
		String configFile="database.properties";
		properties=new Properties();
		//通过class的路径来获取配置文件
		InputStream is=configManager.class.getClassLoader().getResourceAsStream(configFile);
		try {
			//将配置文件加载到properties对象中
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static configManager getConfig(){
		if(configMa==null){
			configMa=new configManager();
		}
		return configMa;
	}
	
	public String getValue(String key){
		//通过properties的方法获取配置文件中key对应的value值
		return properties.getProperty(key);
	}
	
}
