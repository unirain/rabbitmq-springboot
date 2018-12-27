package com.example.demo.moredatasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.awt.dnd.DropTarget;
import java.util.HashMap;
import java.util.Map;

/********************************************************************************
 *
 * Title: 数据源配置
 *
 * Description:
 *
 * @author chenlm
 * create date on 2018/12/17
 *
 *******************************************************************************/

@Configuration
public class DataSourceConfig {
    @Value("${spring.datasource.type}")
    private Class<? extends DataSource> dataSourceType;
    @Value("${spring.primary.url}")
    private String url;
    /**
     * 第一数据源
     *
     * @return
     */
    @Bean("primary")
    @ConfigurationProperties(prefix = "spring.primary")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

    /**
     * 第二数据源
     * @return
     */

    @Bean("second")
    @ConfigurationProperties(prefix = "spring.second")
    public DataSource secondDataSource() {
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

    /**
     * 动态数据源
     * @param primary
     * @param second
     * @return
     */
    @Bean("dynamic")
    public DynamicRoutingDataSource dynamicDataSource(DataSource primary,DataSource second){
        Map<Object,Object> dataSourceMap=new HashMap<>();
        dataSourceMap.put("primary",primary);
        dataSourceMap.put("second",second);
        DynamicRoutingDataSource dynamicRoutingDataSource=new DynamicRoutingDataSource();
        dynamicRoutingDataSource.setTargetDataSources(dataSourceMap);
        dynamicRoutingDataSource.setDefaultTargetDataSource(primary);
        return dynamicRoutingDataSource;
    }

    /**
     * session
     * @param dynamicRoutingDataSource
     * @return
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactorys(DynamicRoutingDataSource dynamicRoutingDataSource)  {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dynamicRoutingDataSource);
        return sqlSessionFactoryBean;
    }




}
