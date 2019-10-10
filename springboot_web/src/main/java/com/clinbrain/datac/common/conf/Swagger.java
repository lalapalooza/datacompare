package com.clinbrain.datac.common.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
* Swagger 配置文件
* @ClassName: Swagger
* @Description: TODO(配置文件)
* @author fuce
* @date 2018年6月3日
*
 */
@Configuration(value="false")
@EnableSwagger2 //启动swagger注解 启动服务，浏览器输入"http://服务名:8080/swagger-ui.html"
public class Swagger {
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.clinbrain.datac"))
				.paths(PathSelectors.any())
				.build();
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("springboot_v2 API文档")
				.description("简单优雅的restfun风格，https://gitee.com/bdj/SpringBoot_v2")
				.termsOfServiceUrl("https://gitee.com/bdj/SpringBoot_v2")
				.version("1.0")
				.build();
	}

}
