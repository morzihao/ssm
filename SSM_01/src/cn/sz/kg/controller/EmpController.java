package cn.sz.kg.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;






import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.sz.kg.dao.biz.IEmpBiz;
import cn.sz.kg.pojo.Emp;

@Controller
@RequestMapping("ec")
public class EmpController {

	private IEmpBiz empBizImpl;
	
	
	@RequestMapping(value="findEmp")
	public String findEmp(Model m){
		List<Emp> list= empBizImpl.findall();
		
		m.addAttribute("list", list);
		
		return "emplist";
		
	}
	
	@ResponseBody
	@RequestMapping(value="checkEmp",method=RequestMethod.POST)
	public String checkEmp(String ename){
		
		int res=empBizImpl.checkemp(ename);
		boolean f=res>0?true:false;
		System.out.println(f);
		return f+"";
		
	}
	
	@RequestMapping(value="addEmp",method=RequestMethod.POST)
	public String addEmp(Emp emp,@RequestParam MultipartFile pic,HttpServletRequest req){
		/*String job = emp.getJob();
		try {
			job = new String(job.getBytes("ISO-8859-1"),"utf-8");
			emp.setJob(job);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}*/
		empBizImpl.savaemp(emp);
		String realpath = req.getServletContext().getRealPath("/upload");
		System.out.println(realpath);
		OutputStream out=null;
		try {
			out=new FileOutputStream(new File(realpath+"/"+pic.getOriginalFilename()));
			FileCopyUtils.copy(pic.getInputStream(), out);
			return "suc";
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return "";
		
	}
	
	
	
	
	public IEmpBiz getEmpBizImpl() {
		return empBizImpl;
	}
	public void setEmpBizImpl(IEmpBiz empBizImpl) {
		this.empBizImpl = empBizImpl;
	}
	
	
}
