package cn.com.rpg.util;

import java.util.ArrayList;
import java.util.List;

public class limitList<E> {
	private List<E> list;	//��Ҫ��ҳ��list
	private int pageTotal;	//��ҳ��
	private int amountPerPage;	//ÿҳ��ʾ����Ŀ��
	
	//�вι���
	/**
	 * ��ʼ����Ҫ��ҳ������
	 * @param list:List<E>:��Ҫ��ҳ��list
	 * @param amountPerPage:int:ÿҳ��ʾ����Ŀ��
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

	//����ҳ�뽫��ԭList���Ͻ�ȡ������µ�list������
	/**
	 * ����ҳ�뽫��ԭList���Ͻ�ȡ������µ�list������
	 * @param pageNum:int:��ǰҳ��
	 * @return List<E>:��ǰҳ��list����
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
	
	//��ȡ��ҳ��
	/**
	 * ��ȡ��ҳ��
	 * @return ��ҳ��
	 */
	public int getPageTotal(){
		return this.pageTotal;
	}
}
