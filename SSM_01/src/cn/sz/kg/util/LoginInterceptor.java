package cn.sz.kg.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	private static String [] arr={
		"log/check",
		"log/reg"
	};
	public Boolean check(String url){
		for (int i = 0; i < arr.length; i++) {
			if(arr[i].equals(url)){
				return true;
			}
		}
		if(url!=null&&!"".equals(url)&&url.endsWith(".js")){
			return true;
		}
		return false;
		
	}
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("进入业务之前》》》》》》");
		
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("us");
		String uri=request.getRequestURI();
		String contextpath = request.getContextPath();
		String url = uri.substring(contextpath.length()+1, uri.length());
		if(obj==null){
			
			if(this.check(url)){
				System.out.println(url);
				return true;
			}
			String path = request.getContextPath();
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
			response.sendRedirect(basePath+"index.jsp");
			//request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		
	}
}
