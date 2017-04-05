package cn.sz.kg.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.sz.kg.dao.IDeptDao;
import cn.sz.kg.pojo.Dept;
@Repository
public class DeptDaoImpl extends SqlSessionDaoSupport implements IDeptDao {

	@Override
	public List<Dept> find() {
		
		return super.getSqlSession().selectList("cn.sz.kg.pojo.Dept.find");
	}

}
