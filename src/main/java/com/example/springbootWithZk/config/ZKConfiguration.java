package com.example.springbootWithZk.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zkoss.zk.au.http.DHtmlUpdateServlet;
import org.zkoss.zk.ui.http.DHtmlLayoutServlet;
import org.zkoss.zk.ui.http.HttpSessionListener;

/**
 * Created by preecha on 5/12/67
 */
@Configuration
class ZKConfiguration {

	@Bean
	ServletRegistrationBean<DHtmlLayoutServlet> dHtmlLayoutServlet() {
		// zk config
		ServletRegistrationBean<DHtmlLayoutServlet> reg = 
				new ServletRegistrationBean<DHtmlLayoutServlet>(new DHtmlLayoutServlet(), "*.zul");
		reg.setLoadOnStartup(10);

		Map<String, String> params = new HashMap<>();
		params.put("update-uri", "/zkau");
		reg.setInitParameters(params);

		return reg;
	}

	@Bean
	ServletRegistrationBean<DHtmlUpdateServlet> dHtmlUpdateServlet() {
		// zk config
		ServletRegistrationBean<DHtmlUpdateServlet> reg = 
				new ServletRegistrationBean<DHtmlUpdateServlet>(new DHtmlUpdateServlet(), "/zkau/*");
		reg.setLoadOnStartup(11);

		Map<String, String> params = new HashMap<>();
		params.put("update-uri", "/zkau/*");
		reg.setInitParameters(params);

		return reg;
	}

	@Bean
	HttpSessionListener httpSessionListener() {
		return new HttpSessionListener();
	}

}