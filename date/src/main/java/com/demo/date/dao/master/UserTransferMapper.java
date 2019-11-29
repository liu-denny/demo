package com.demo.date.dao.master;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author yudong
 * @create 2019-11-21 12:25
 */
@Mapper
public interface UserTransferMapper {

    @Insert("INSERT INTO c_user_transfer  VALUES (#{id},#{name},#{avatar},#{shimoMail},#{identifier},#{unionid},#{actualName}) ")
    void insert(@Param("id")Long id,@Param("name")String name,@Param("avatar")String avatar,@Param("shimoMail")String shimoMail,@Param("identifier")String identifier
                ,@Param("unionid")String unionid,@Param("actualName")String actualName);
}
