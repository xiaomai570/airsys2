package service.prototype;

import java.util.List;

import entity.Account;
import util.MiniPager;
import util.Pager;

public interface IAccountService {
	// ת��
       void transfer(Account from,Account to,double money);
       //--��ѯ�˺�
       Account searchAccount(int id);
      //--��ҳ��ѯ�˺���Ϣ
       List<Account>listAccounts(int pageNo,int pageSize);
       //--��ҳ��ѯ�˺���Ϣ
       @MiniPager(tableName = "account")
       List<Account> listPaged(int pageNo,int pageSize);
      
} 
