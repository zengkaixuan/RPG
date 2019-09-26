package cn.com.rpg.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class configManager {//�����ļ�����
	private static Properties properties;
	private static configManager configMa;
	
	private configManager() {
		//��ȡ�����ļ�
		String configFile="database.properties";
		properties=new Properties();
		//ͨ��class��·������ȡ�����ļ�
		InputStream is=configManager.class.getClassLoader().getResourceAsStream(configFile);
		try {
			//�������ļ����ص�properties������
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
		//ͨ��properties�ķ�����ȡ�����ļ���key��Ӧ��valueֵ
		return properties.getProperty(key);
	}
	
}
