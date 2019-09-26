package cn.com.rpg.controller;

import java.util.List;

import cn.com.rpg.dao.characterRpgDao;
import cn.com.rpg.daoImp.characterRpgDaoImp;
import cn.com.rpg.entity.characterRpg;

public class characterRpgTest {
	public static void main(String[] args) {
		characterRpgDao characterDao=new characterRpgDaoImp();
		characterRpg character=new characterRpg();
		List<characterRpg> list=null;
		
		list=characterDao.selectAll();
		System.out.println(list);
	}
}
