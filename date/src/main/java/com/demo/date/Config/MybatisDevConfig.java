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
 * @create 2019-11-21 12:20
 */
@Configuration
@MapperScan(basePackages = {"com.demo.date.dao.dev"}, sqlSessionFactoryRef = "sqlSessionFactoryDev")
public class MybatisDevConfig {

    @Autowired
    @Qualifier("DataSources.dev")
    private DataSource dev;

    @Bean
    public SqlSessionFactory sqlSessionFactoryDev() throws Exception{
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dev);
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplateDev() throws Exception{
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactoryDev());
        return template;
    }
}
