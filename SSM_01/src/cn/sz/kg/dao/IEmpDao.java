package cn.sz.kg.dao;

import java.util.List;

import cn.sz.kg.pojo.Emp;

public interface IEmpDao {

	public List<Emp> findall();
	public int checkemp(String ename);
	public void savaemp(Emp vo);
}
