package com.oldneighborhood.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CorsConfig extends WebMvcConfigurerAdapter{
	@Override
	public void addCorsMappings(CorsRegistry crosRegistry) {
		crosRegistry.addMapping("/**").allowedOrigins("*")
					.allowedMethods("GET","HEAD","POST","PUT","DELETE","OPTIONS")
					.allowCredentials(false).maxAge(3600);
		System.out.println("使用cors实现跨域访问！>>>>>>>>>>>>");
	}

}
