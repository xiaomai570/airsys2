package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototype.IAccountDao;
import entity.Account;
import service.prototype.IAccountService;
import util.MiniPager;
import util.Pager;
/*
 * Accountҵ��ʵ����
 */
@Service("accountServiceDaoImpl")
public class AccountServiceDaoImpl implements IAccountService{
     @Autowired
	 private IAccountDao actDao;
	@Override    //�漰������   Spring ����ʽ��Transaction����(AOP��̬����ģʽ��Ӧ��)
	public void transfer(Account from, Account to, double money) {
	     
		
	}

	@Override	
	public Account searchAccount(int id) {
		// TODO Auto-generated method stub
		return actDao.find(id);
	}

	@Override	
	public List<Account> listAccounts(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> listPaged(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return  actDao.find((pageNo-1)*pageSize, pageSize);
		
	}
                 
}
