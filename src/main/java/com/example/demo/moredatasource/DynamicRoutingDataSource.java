package com.example.demo.moredatasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/********************************************************************************
 *
 * Title: 动态数据源
 *
 * Description:
 *
 * @author chenlm
 * create date on 2018/12/18
 *
 *******************************************************************************/
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {
    //当前数据源
    private final  static  ThreadLocal<String> currentDataSource=new ThreadLocal<>();

    /**
     * 设置当前数据源
     * @param curDataSourceName
     */
    public static void setCur(String curDataSourceName){
        currentDataSource.set(curDataSourceName);
    }

    /**
     * 移除当前数据源
     */
    public static  void clearCur(){
        currentDataSource.remove();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return currentDataSource.get();
    }


}
