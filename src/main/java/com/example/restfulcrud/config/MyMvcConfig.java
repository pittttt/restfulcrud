package com.example.restfulcrud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.example.restfulcrud.component.MyLocaleResolver;

//使用WebMvcConfigurerAdapter来扩展SpringMVC的功能
//@EnableWebMvc的作用是全面接管SpringMVC，使所有Springboot的web相关自动配置失效
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {
	// 新建一个WebMvcConfigurerAdapter组件，自定义添加的组件会和Springboot的组件一起生效
	@Bean // 将组件注册在容器中
	public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
		WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
			@Override
			public void addViewControllers(ViewControllerRegistry registry) {
				registry.addViewController("/").setViewName("login");
				// springboot会自动将首页导向public下的index.html，则需要重新进行跳转
				registry.addViewController("/index.html").setViewName("login");
				registry.addViewController("/main.html").setViewName("dashboard");
			}
		};
		return adapter;
	}

	// 注册拦截器
	// @Override
	// public void addInterceptors(InterceptorRegistry registry) {
	// // springboot已经做好了静态资源映射，可以直接访问，不用排除
	// registry.addInterceptor(new
	// LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html",
	// "/", "/user/login");
	// }

	// 将自己的区域解析器添加到容器中
	@Bean
	public MyLocaleResolver localeResolver() {
		return new MyLocaleResolver();
	}
}
