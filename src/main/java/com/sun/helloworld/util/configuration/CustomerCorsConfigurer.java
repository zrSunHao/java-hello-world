package com.sun.helloworld.util.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomerCorsConfigurer  implements WebMvcConfigurer{
	
	@Override
    public void addCorsMappings(CorsRegistry registry) {
		
        registry.addMapping("/api/**")//设置允许跨域的路径
                .allowedOrigins("http://localhost:4200")//设置允许跨域请求的域名
                //.allowCredentials(true)//是否允许证书 不再默认开启
                .allowedMethods("GET", "POST", "PUT", "DELETE")//设置允许的方法
                .maxAge(3600);//跨域允许时间
    }
	
}
