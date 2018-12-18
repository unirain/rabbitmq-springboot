package com.example.demo.moredatasource;

import com.example.demo.entity.Ac01;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
@Mapper
public interface Ac01DAO {
    @Select("select count(*) from ac01 ")
    int getCount();

    @Select("select * from ac01 where aac001=#{ac001}")
    Ac01 selectAc01(long aac001);
}
