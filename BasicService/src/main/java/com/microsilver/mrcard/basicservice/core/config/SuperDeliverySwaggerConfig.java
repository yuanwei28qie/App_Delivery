/**
 * 
 */
package com.microsilver.mrcard.basicservice.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @Name com.microsilver.mrcard.basicservice.core.SuperDeliverySwaggerConfig
 * @Description 
 * 
 * @Author huwei
 * @Version 2018年3月27日 下午6:33:38
 * @Copyright  Micro Silver-SuperDelivery
 *
 */
@Configuration
@EnableSwagger2
public class SuperDeliverySwaggerConfig {
	 @Bean
	    public Docket ProductApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .genericModelSubstitutes(DeferredResult.class)
	                .useDefaultResponseMessages(false)
	                .forCodeGeneration(true)
	                .pathMapping("")
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("com.microsilver.mrcard.basicservice"))
	                .build()
	                .apiInfo(productApiInfo());
	    }

	    private ApiInfo productApiInfo() {
	    	  return new ApiInfoBuilder()
	                  .title("微银超级跑腿API文档")
	                  .description("超级跑腿接口文档,主要分为骑手端和用户端")
	                  //.termsOfServiceUrl("http://www.baidu.com/")
	                  .version("1.0")
	                  .build();
	    }
}
