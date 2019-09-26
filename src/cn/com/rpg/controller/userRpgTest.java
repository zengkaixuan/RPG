package cn.com.rpg.controller;

import java.util.List;

import cn.com.rpg.dao.userRpgDao;
import cn.com.rpg.daoImp.userRpgDaoImp;
import cn.com.rpg.entity.userRpg;
import cn.com.rpg.service.userRpgService;
import cn.com.rpg.serviceImp.userRpgServiceImp;

public class userRpgTest {
	public static void main(String[] args) {
		userRpgService userService=new userRpgServiceImp();
		List<userRpg> list=null;
		userRpg user=null;
		
		user=userService.selectById(1);
		System.out.println(user);
	}
}
