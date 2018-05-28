package com.microsilver.mrcard.basicservice;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;





@MapperScan("com.microsilver.mrcard.basicservice")
@ServletComponentScan
@SpringBootApplication	
@EnableDiscoveryClient
@EnableFeignClients
public class Application {
	// 启动的时候要注意，由于我们在controller中注入了RestTemplate，所以启动的时候需要实例化该类的一个实例 
    @Autowired 
    private RestTemplateBuilder builder; 
   
    // 使用RestTemplateBuilder来实例化RestTemplate对象，spring默认已经注入了RestTemplateBuilder实例 
    @Bean 
    public RestTemplate restTemplate() { 
        return builder.build(); 
    } 
   

	public static void main(String[] args) {  
       SpringApplication.run(Application.class, args);  
		
    }
	
}
