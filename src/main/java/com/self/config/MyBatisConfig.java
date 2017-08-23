package com.self.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.google.common.base.Preconditions;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * 作者：boys
 * 创建时间：2017-08-23 17:00
 * 类描述：
 * 修改人：
 * 修改时间：
 */
//设置为配置项
@Configuration
// 开启事务管理
@EnableTransactionManagement
public class MyBatisConfig implements ApplicationContextAware, EnvironmentAware{

    @Autowired
    private Environment evn;

    private ApplicationContext context;

    private static final String DB_URL = "db.url";
    private static final String DB_USERNAME = "db.username";
    private static final String DB_PASSWORD = "db.password";
    private static final String DB_MAX_ACTIVE = "db.maxActive";


    /**
     * 获取数据源 使用阿里的数据库连接池
     * @return
     */
    @Bean
    public DruidDataSource dataSource() {
        final String url = Preconditions.checkNotNull(evn.getProperty(DB_URL));
        final String username = Preconditions.checkNotNull(evn.getProperty(DB_USERNAME));
        final String  password = Preconditions.checkNotNull(evn.getProperty(DB_PASSWORD));
        final int maxActive = Integer.parseInt(evn.getProperty(DB_MAX_ACTIVE, "200"));
       /* final String url = "jdbc:mysql://127.0.0.1:3306/dubbokeeper?prepStmtCacheSize=517&cachePrepStmts=true&autoReconnect=true&characterEncoding=utf-8";
        final String username = "root";
        final String  password = "root";
        final int maxActive = 20;*/

        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setMaxActive(maxActive);
        return druidDataSource;
    }

    /**
     * 连接工厂类
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setMapperLocations(context.getResources("classpath:/mapper/*.xml"));
        return factoryBean.getObject();
    }


    /**
     * 开启事务管理
     * @return
     */
    @Bean
    public DataSourceTransactionManager transactionManager() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource());
        return transactionManager;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() throws Exception {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.self.repository");
        return mapperScannerConfigurer;
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public void setEnvironment(Environment environment) {
        this.evn = environment;
    }
}
