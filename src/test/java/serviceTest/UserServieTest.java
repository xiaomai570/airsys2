package serviceTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.AppConfig;
import entity.Account;
import entity.User;
import service.impl.UserServiceDaoImpl;
import service.prototype.IAccountService;
import service.prototype.IUserService;
import util.Pager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class UserServieTest {
	      @Autowired
          private IUserService uservice; 
	      
	      @Test
	      public void test01() {
	    	 Pager<User>pager=(Pager<User>) uservice.listPaged(1, 5);
	    	 
	    	  for(User act:pager.getData()) {
	    		  System.out.println(act);
	    	  }
	    	   System.out.println(pager.getTotal());
	      }
	      
}           
