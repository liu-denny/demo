package com.demo.swagger;

import cn.hutool.core.bean.DynaBean;
import cn.hutool.log.StaticLog;
import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author yudong
 * @create 2019-11-15 11:57
 */
@Order
@Component
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class SwaggerInit implements ApplicationListener<ContextRefreshedEvent> {
    @Value("${spring.swagger.enabled}")
    private Boolean enabled;
    @Value("${spring.swagger.title}")
    private String title;
    @Value("${spring.swagger.description}")
    private String description;
    @Value("${spring.swagger.version}")
    private String version;
    @Value("${spring.swagger.base-package}")
    private String basePackage;

    public SwaggerInit() {
    }

    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Docket docket = (new Docket(DocumentationType.SWAGGER_2)).groupName("权限模块").enable(this.enabled).apiInfo(this.apiInfo()).select().apis(RequestHandlerSelectors.basePackage(this.basePackage)).paths(PathSelectors.any()).build();
        new DynaBean(docket);
        if (this.enabled) {
            StaticLog.info("swagger2 初始化完成", new Object[0]);
        } else {
            StaticLog.info("swagger2 关闭", new Object[0]);
        }

    }

    private ApiInfo apiInfo() {
        return (new ApiInfoBuilder()).title(this.title).description(this.description).version(this.version).build();
    }
}
