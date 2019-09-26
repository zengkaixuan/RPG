package cn.com.rpg.controller;

import java.util.List;

import cn.com.rpg.dao.areaRpgDao;
import cn.com.rpg.daoImp.areaRpgDaoImp;
import cn.com.rpg.entity.areaRpg;
import cn.com.rpg.service.areaRpgService;
import cn.com.rpg.serviceImp.areaRpgServiceImp;

public class areaRpgTest {
	public static void main(String[] args) {
		areaRpgService areaS=new areaRpgServiceImp();
		areaRpgDao areaD=new areaRpgDaoImp();
		areaRpg area=areaD.selectById(5);
		System.out.println(area);
		/*List<areaRpg> list=areaD.selectAll();
		System.out.println(list);*/
	}
}
