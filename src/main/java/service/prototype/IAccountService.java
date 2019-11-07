package service.prototype;

import java.util.List;

import entity.Account;
import util.MiniPager;
import util.Pager;

public interface IAccountService {
	// 转帐
       void transfer(Account from,Account to,double money);
       //--查询账号
       Account searchAccount(int id);
      //--分页查询账号信息
       List<Account>listAccounts(int pageNo,int pageSize);
       //--分页查询账号信息
       @MiniPager(tableName = "account")
       List<Account> listPaged(int pageNo,int pageSize);
      
} 
