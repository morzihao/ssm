package cn.sz.kg.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.sz.kg.dao.IEmpDao;
import cn.sz.kg.pojo.Emp;
@Repository
public class EmpDaoImpl extends SqlSessionDaoSupport implements IEmpDao {

	@Override
	public List<Emp> findall() {
		
		return super.getSqlSession().selectList("cn.sz.kg.pojo.Emp.findall");
	}

	@Override
	public int checkemp(String ename) {
		
		return super.getSqlSession().selectOne("cn.sz.kg.pojo.Emp.checkemp",ename);
	}

	@Override
	public void savaemp(Emp vo) {
		
		super.getSqlSession().insert("cn.sz.kg.pojo.Emp.savaemp", vo);
	}

}
