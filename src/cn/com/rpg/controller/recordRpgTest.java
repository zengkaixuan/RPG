package cn.com.rpg.controller;

import java.util.ArrayList;
import java.util.List;

import cn.com.rpg.dao.recordRpgDao;
import cn.com.rpg.daoImp.recordRpgDaoImp;
import cn.com.rpg.entity.recordRpg;
import cn.com.rpg.service.recordRpgService;
import cn.com.rpg.serviceImp.recordRpgServiceImp;

public class recordRpgTest {
	public static void main(String[] args) {
		recordRpgDao recordDao=new recordRpgDaoImp();
		List<recordRpg> list=new ArrayList<recordRpg>();
		recordRpg record=new recordRpg();
		recordRpgService recordService=new recordRpgServiceImp();
		
		
	}
}
