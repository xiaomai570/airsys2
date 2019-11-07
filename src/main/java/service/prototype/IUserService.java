package service.prototype;

import java.util.List;

import entity.Account;
import entity.User;
import util.MiniPager;
import util.Pager;

public interface IUserService {
	@MiniPager(tableName = "user")
    List<User> listPaged(int pageNo,int pageSize);
	
}
