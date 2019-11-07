package dao.prototype;

import java.sql.Connection;
import java.util.List;

import org.springframework.stereotype.Repository;

import entity.Account;
import util.Pager;


public interface IAccountDao {
     //   void modify(Account act,Connection con);
        //查询id查询账户的方法
        
     //   void modify(Account act);
	    Account find(int id);
        List<Account>find(int offset,int pageSize);   //--0, Integer.MaxValue
        Pager<Account>findPaged(int offset,int pageSize);
        int totalItems();
        void delete(int id);
        List<Account>findAll();
	      void saveOrUpdate(Account act);
        
}
