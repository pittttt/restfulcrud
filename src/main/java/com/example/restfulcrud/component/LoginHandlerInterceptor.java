package com.example.restfulcrud.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 拦截器进行登录检查
 * 
 * @author pitt
 *
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
	// 目标方法执行之前
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Object user = request.getSession().getAttribute("loginUser");
		if (user == null) {
			// 未登录，返回登录页面
			request.setAttribute("msg", "请先进行登录！");
			request.getRequestDispatcher("/index.html").forward(request, response);
			return false;
		} else {
			// 已登录
			return true;
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

	}
}
