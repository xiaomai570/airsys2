package util;

import java.util.ArrayList;
import java.util.List;

/*
 * ��װ��ҳ��Ҳ������
 * ���ͱ��
 * 
 */
public class Pager<T> extends ArrayList<T>{
      private List<T> data;    //--���ݱ���
      private int total;        //--��ҳ��
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
      
}
