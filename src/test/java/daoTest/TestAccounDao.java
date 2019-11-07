package daoTest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.AppConfig;
import dao.prototype.IAccountDao;
import entity.Account;

/*
 * Springµ¥Ôª²âÊÔ
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class TestAccounDao {
	  @Autowired
       private IAccountDao actDao;        
	  @Test
	  public void testFindByID() {
		  Account act=actDao.find(1);
		  System.out.println(act);
		   List<Account> list=actDao.findAll();
		   System.out.println(list);
		   Account act1=new Account();
		   act1.setId(11);
		   act1.setName("HAN");
		    act1.setBalance(100);
		  actDao.saveOrUpdate(act1);
	  }
	  
	  
}
