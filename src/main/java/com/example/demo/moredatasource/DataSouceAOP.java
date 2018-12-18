package com.example.demo.moredatasource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/********************************************************************************
 *
 * Title: 
 *
 * Description:
 *
 * @author chenlm
 * create date on 2018/12/18
 *
 *******************************************************************************/
@Aspect
@Component
public class DataSouceAOP {

    @Pointcut("execution(public * com.example.demo.moredatasource.*DAO.*(..))")
    public  void doAop(){}

    @Before("doAop()")
    public void before(JoinPoint joinPoint){
        String prefix=joinPoint.getSignature().getName();
        if (prefix.startsWith("get")){
            DynamicRoutingDataSource.setCur("primary");
        }else {
            DynamicRoutingDataSource.setCur("second");
        }

    }
    @After("doAop()")
    public void after(){
        DynamicRoutingDataSource.clearCur();
    }
}
