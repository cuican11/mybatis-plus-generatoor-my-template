//package com.hwgif.jwtauth.config;
//import com.alibaba.druid.pool.DruidDataSource;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//import java.sql.SQLException;
//
///**
// * Created by lc.huang on 2019/11/20.
// * Description    网上说Springboot不支持自动配置druid连接池（即无法通过配置项直接支持相应的连接池连接池）
// * 这里配置项可以通过定制化DataSource来实现
// * 定置化DataSource类：
// */
//
//@Configuration
////扫描 Mapper 接口并容器管理
//@MapperScan(basePackages = DatasourceConfig.PACKAGE, sqlSessionFactoryRef = "sqlSessionFactory")
//public class DatasourceConfig {
//    // 精确到 master 目录，以便跟其他数据源隔离
//    static final String PACKAGE = "com.hwgif.jwtauth.dao.impl";
//    static final String MAPPER_LOCATION = "classpath:conf/mapper/*.xml";
//
//    @Value("${spring.datasource.url}")
//    private String url;
//    @Value("${spring.datasource.username}")
//    private String user;
//    @Value("${spring.datasource.password}")
//    private String password;
//    @Value("${spring.datasource.driver-class-name}")
//    private String driverClass;
//
//    @Value("${spring.datasource.druid.max-active}")
//    private Integer maxActive;
//    @Value("${spring.datasource.druid.min-idle}")
//    private Integer minIdle;
//    @Value("${spring.datasource.druid.initial-size}")
//    private Integer initialSize;
//    @Value("${spring.datasource.druid.max-wait}")
//    private Long maxWait;
//    @Value("${spring.datasource.druid.time-between-eviction-runs-millis}")
//    private Long timeBetweenEvictionRunsMillis;
//    @Value("${spring.datasource.druid.min-evictable-idle-time-millis}")
//    private Long minEvictableIdleTimeMillis;
//    @Value("${spring.datasource.druid.test-while-idle}")
//    private Boolean testWhileIdle;
//    @Value("${spring.datasource.druid.test-on-borrow}")
//    private Boolean testOnBorrow;
//    @Value("${spring.datasource.druid.test-on-return}")
//    private Boolean testOnReturn;
//
//    @Bean(name = "dataSource")
//    @Primary
//    public DataSource dataSource() {
//        //jdbc配置
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName(driverClass);
//        dataSource.setUrl(url);
//        dataSource.setUsername(user);
//        dataSource.setPassword(password);
//
//        //连接池配置
//        dataSource.setMaxActive(maxActive);
//        dataSource.setMinIdle(minIdle);
//        dataSource.setInitialSize(initialSize);
//        dataSource.setMaxWait(maxWait);
//        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
//        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
//        dataSource.setTestWhileIdle(testWhileIdle);
//        dataSource.setTestOnBorrow(testOnBorrow);
//        dataSource.setTestOnReturn(testOnReturn);
//        dataSource.setValidationQuery("SELECT 'x'");
//
//        dataSource.setPoolPreparedStatements(true);
//        dataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
//
//        try {
//            dataSource.setFilters("stat");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return dataSource;
//    }
//
////    @Bean(name = "transactionManager")
////    @Primary
////    public DataSourceTransactionManager transactionManager() {
////        return new DataSourceTransactionManager(dataSource());
////    }
////
////    @Bean(name = "sqlSessionFactory")
////    @Primary
////    public SqlSessionFactory ds1SqlSessionFactory(@Qualifier("dataSource") DataSource dataSource)
////            throws Exception {
////        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
////        sessionFactory.setDataSource(dataSource);
////        sessionFactory.setTypeAliasesPackage("com.hwgif.**.bean");
////        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
////                .getResources(DatasourceConfig.MAPPER_LOCATION));
////        return sessionFactory.getObject();
////    }
//}
//
