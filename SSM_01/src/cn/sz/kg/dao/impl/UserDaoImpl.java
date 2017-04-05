package cn.sz.kg.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.sz.kg.dao.IUserDao;
import cn.sz.kg.pojo.Users;
@Repository
public class UserDaoImpl extends SqlSessionDaoSupport implements IUserDao  {

	@Override
	public Users findUser(Users vo) {
		
		return super.getSqlSession().selectOne("cn.sz.kg.pojo.Users.findUser",vo);
	}

}
