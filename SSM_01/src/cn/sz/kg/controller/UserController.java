package cn.sz.kg.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.sz.kg.dao.biz.IUserBiz;
import cn.sz.kg.pojo.Users;
@Controller
@RequestMapping("log")
public class UserController {

	private IUserBiz userBizImpl;
	@RequestMapping(value="check",method=RequestMethod.POST)
	public ModelAndView check(Users vo,HttpSession session){
		ModelAndView modelAndView = new ModelAndView();
		Users user = userBizImpl.findUser(vo);
		String view ="index";
		if(user!=null){
			
			//view ="forward:/ec/findEmp";
			view="main";
			session.setAttribute("us", user);
		}
		modelAndView.setViewName(view);
		
		return modelAndView;
		
	}
	public IUserBiz getUserBizImpl() {
		return userBizImpl;
	}
	public void setUserBizImpl(IUserBiz userBizImpl) {
		this.userBizImpl = userBizImpl;
	}
	
}
