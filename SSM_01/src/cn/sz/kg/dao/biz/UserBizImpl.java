package cn.sz.kg.dao.biz;

import org.springframework.stereotype.Service;

import cn.sz.kg.dao.IUserDao;
import cn.sz.kg.pojo.Users;

@Service
public class UserBizImpl implements IUserBiz {

	private IUserDao userDaoImpl;
	@Override
	public Users findUser(Users vo) {
		
		return userDaoImpl.findUser(vo);
	}
	public IUserDao getUserDaoImpl() {
		return userDaoImpl;
	}
	public void setUserDaoImpl(IUserDao userDaoImpl) {
		this.userDaoImpl = userDaoImpl;
	}
	
}
