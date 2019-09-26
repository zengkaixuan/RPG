package cn.com.rpg.util;

import java.util.ArrayList;
import java.util.List;

public class limitList<E> {
	private List<E> list;	//需要分页的list
	private int pageTotal;	//总页数
	private int amountPerPage;	//每页显示的条目数
	
	//有参构造
	/**
	 * 初始化需要分页的数据
	 * @param list:List<E>:需要分页的list
	 * @param amountPerPage:int:每页显示的条目数
	 */
	public limitList(List<E> list,int amountPerPage) {
		super();
		this.list = list;
		this.amountPerPage = amountPerPage;
		
		this.pageTotal=
				(list.size()%amountPerPage>0)?
						((list.size()/amountPerPage)+1):
							(list.size()/amountPerPage);
	}

	//根据页码将将原List集合截取后放入新的list集合中
	/**
	 * 根据页码将将原List集合截取后放入新的list集合中
	 * @param pageNum:int:当前页码
	 * @return List<E>:当前页的list集合
	 */
	public List<E> limitListElement(int pageNum){
		List<E> newList=new ArrayList<E>();
		if(pageNum<this.pageTotal+1){
			int pageStartIndex=(pageNum-1)*this.amountPerPage;
			int pageEndIndex=pageStartIndex+this.amountPerPage;
			if(pageNum*this.amountPerPage>this.list.size()){
				newList=this.list.subList(pageStartIndex,this.list.size());
			}else{
				newList=this.list.subList(pageStartIndex, pageEndIndex);
			}
		}
		return newList;
	}
	
	//获取总页数
	/**
	 * 获取总页数
	 * @return 总页数
	 */
	public int getPageTotal(){
		return this.pageTotal;
	}
}
