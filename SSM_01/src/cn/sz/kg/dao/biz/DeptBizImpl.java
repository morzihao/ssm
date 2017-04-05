package cn.sz.kg.dao.biz;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.sz.kg.dao.IDeptDao;
import cn.sz.kg.pojo.Dept;
@Service
public class DeptBizImpl implements IDeptBiz {

	private IDeptDao deptDaoImpl;
	@Override
	public List<Dept> findall() {
		
		return deptDaoImpl.find();
	}
	public IDeptDao getDeptDaoImpl() {
		return deptDaoImpl;
	}
	public void setDeptDaoImpl(IDeptDao deptDaoImpl) {
		this.deptDaoImpl = deptDaoImpl;
	}
	

}
