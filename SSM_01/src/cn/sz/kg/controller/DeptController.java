package cn.sz.kg.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sz.kg.dao.biz.IDeptBiz;
import cn.sz.kg.pojo.Dept;

@Controller
@RequestMapping("dc")
public class DeptController {

	private IDeptBiz deptBizImpl;
	
	@RequestMapping(value="find")
	public String findAll(Model m){
		List<Dept> deptlist=deptBizImpl.findall();
		m.addAttribute("deptlist", deptlist);
		return "addemp";
		
	}

	public IDeptBiz getDeptBizImpl() {
		return deptBizImpl;
	}

	public void setDeptBizImpl(IDeptBiz deptBizImpl) {
		this.deptBizImpl = deptBizImpl;
	}
	
}
