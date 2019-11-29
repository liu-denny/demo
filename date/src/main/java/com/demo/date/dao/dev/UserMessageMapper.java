package com.demo.date.dao.dev;

import com.demo.date.entity.UserMessage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author yudong
 * @create 2019-11-21 12:25
 */
@Mapper
public interface UserMessageMapper {

    @Select("SELECT um.id,um.userName AS `name`,um.headPic AS avatar,um.shimoMail,li.identifier AS identifier,um.unionid,uc.actualName FROM`userMessage` AS um INNER JOIN loginInfo AS li INNER JOIN usercontactinformation AS uc ON um.id = li.userId and uc.userId = um.id WHERE um.writer = 1 and li.loginType = 0 and li.sysType = 3;")
    List<UserMessage> find();
}
