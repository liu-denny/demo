package com.demo.date.Config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author yudong
 * @create 2019-11-21 12:19
 */
@Configuration
//扫描的包，sqlSessionFactoryRef使用下方配置的工厂类
@MapperScan(basePackages = {"com.demo.date.dao.master"}, sqlSessionFactoryRef = "sqlSessionFactory")
public class MybatisMasterConfig {

    @Autowired
    @Qualifier("DataSources.master")
    private DataSource master;//上一步配置的bean


    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(master); // 使用master数据源, 连接master库
        return factoryBean.getObject();

    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory()); // 使用上面配置的Factory
        return template;
    }
}
