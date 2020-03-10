package com.dyz.dev.configuration;

import com.alibaba.druid.pool.DruidDataSource;

import com.alibaba.druid.support.http.StatViewServlet;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement

public class DBConfig {

    @Bean("druidServlet")

    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new StatViewServlet());
        servletRegistrationBean.addUrlMappings("/druid/*");
        Map<String, String> initParameters = new HashMap<String, String>();
        // initParameters.put("loginUsername", "druid");// 用户名
        // initParameters.put("loginPassword", "druid");// 密码
        initParameters.put("resetEnable", "false");// 禁用HTML页面上的“Reset All”功能
//        initParameters.put("allow", "127.0.0.1"); // IP白名单 (没有配置或者为空，则允许所有访问)
        // initParameters.put("deny", "192.168.20.38");// IP黑名单
        // (存在共同时，deny优先于allow)
        servletRegistrationBean.setInitParameters(initParameters);
        return servletRegistrationBean;
    }
    /**
     * 第一个数据源配置
     * @return
     */
    @Bean("oneDataSource")
    @ConfigurationProperties("db.properties.one")
    @Primary
    public DataSource setOneDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        //dataSource.setUrl("");
        return dataSource;
    }

    @Bean("oneSqlSessionFactory")
    @Primary
    public SqlSessionFactory oneSqlSessionFactory(@Qualifier("oneDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:oneMapper/*.xml"));
        return sqlSessionFactory.getObject();
    }


    @Bean("oneSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate oneSqlSessionTemplate(@Qualifier("oneSqlSessionFactory") SqlSessionFactory  sqlSessionFactory) {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        return sqlSessionTemplate;
    }

    @Bean("oneMapperSacn")
    @Primary
    public MapperScannerConfigurer oneMapperSacn() {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage("com.dyz.dev.oneDao");
        configurer.setSqlSessionFactoryBeanName("oneSqlSessionFactory");
        return configurer;
    }


    /////////////////////////////////

    /**
     * 第二个数据源配置
     * @return
     */
    @Bean("towDataSource")
    @ConfigurationProperties("db.properties.tow")
    public DataSource setTowDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://119.29.4.88:3306/testredis?useUnicode=true&characterEncoding=utf-8");
        return dataSource;
    }

    @Bean("towSqlSessionFactory")
    public SqlSessionFactory towSqlSessionFactory(@Qualifier("towDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:towMapper/*.xml"));
        return sqlSessionFactory.getObject();
    }


    @Bean("towSqlSessionTemplate")
    public SqlSessionTemplate towSqlSessionTemplate(@Qualifier("towSqlSessionFactory") SqlSessionFactory  sqlSessionFactory) {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        return sqlSessionTemplate;
    }

    @Bean("towMapperSacn")
    public MapperScannerConfigurer towMapperSacn() {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage("com.dyz.dev.towDao");
        configurer.setSqlSessionFactoryBeanName("towSqlSessionFactory");
        return configurer;
    }
}
