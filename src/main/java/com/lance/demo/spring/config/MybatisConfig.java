package com.lance.demo.spring.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * Created by perdonare on 2017/5/10.
 */
@Configuration
@MapperScan(basePackages = {"com.lance.demo.spring.dao.mapper"})
public class MybatisConfig {
    @Bean
    public DataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        // dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://192.168.1.72:3306/demo?useUnicode=true&characterEncoding=utf-8&useSSL=false");//防止乱码
        dataSource.setUsername("root");
        dataSource.setPassword("xb-12345");
        dataSource.setInitialSize(5);
        dataSource.setMaxTotal(50);
        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/lance/demo/spring/dao/mapper/*.xml"));
        return sessionFactory;
    }
}
