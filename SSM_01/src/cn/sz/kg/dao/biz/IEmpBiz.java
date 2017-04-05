package cn.sz.kg.dao.biz;

import java.util.List;

import cn.sz.kg.pojo.Emp;

public interface IEmpBiz {

	public List<Emp> findall();
	public int checkemp(String ename);
	public void savaemp(Emp vo);
}
