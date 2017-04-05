package cn.sz.kg.dao.biz;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.sz.kg.dao.IEmpDao;
import cn.sz.kg.pojo.Emp;
@Service
public class EmpBizImpl implements IEmpBiz {

	private IEmpDao empDaoImpl;
	@Override
	public List<Emp> findall() {
		
		return empDaoImpl.findall();
	}
	
	@Override
	public int checkemp(String ename) {
		
		return empDaoImpl.checkemp(ename);
	}
	
	
	
	public IEmpDao getEmpDaoImpl() {
		return empDaoImpl;
	}
	public void setEmpDaoImpl(IEmpDao empDaoImpl) {
		this.empDaoImpl = empDaoImpl;
	}

	@Override
	public void savaemp(Emp vo) {
		empDaoImpl.savaemp(vo);
		
	}






	
	
	
}
