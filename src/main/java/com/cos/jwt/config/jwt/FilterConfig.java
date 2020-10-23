package com.cos.jwt.config.jwt;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cos.jwt.domain.person.PersonRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class FilterConfig {
	
	private final PersonRepository personRepository;
	
	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter(){
		System.out.println("CORS 필터 등록");
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter());
		bean.addUrlPatterns("/*");
		bean.setOrder(0);
		
		return bean;
	}
	
	
	@Bean
	public FilterRegistrationBean<JwtAuthenticationFilter> jwtAuthenticationFilter(){
		System.out.println("JwtAuthenticationFilter 필터 등록");
		
		FilterRegistrationBean<JwtAuthenticationFilter> bean =
				new FilterRegistrationBean<>(new JwtAuthenticationFilter(personRepository));
		
		bean.addUrlPatterns("/loginProc");
		bean.setOrder(1);
		
		return bean;
	}

}
