package com.demo.date;

import com.demo.date.dao.dev.UserMessageMapper;
import com.demo.date.dao.master.UserTransferMapper;
import com.demo.date.entity.UserMessage;
import com.demo.date.entity.UserTransfer;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yudong
 * @create 2019-11-21 14:35
 */
@RestController
@RequestMapping("/test")
@Api(value = "1", tags = {"1"})
public class TestController {
    @Resource
    private UserMessageMapper userMessageMapper;

    @Resource
    private UserTransferMapper userTransferMapper;

    @RequestMapping("/1")
    public String find(){
        List<UserMessage> userMessageList = userMessageMapper.find();
        System.out.println("userMessageList = " + userMessageList.size());
        System.out.println("开始迁移");
        for (UserMessage message : userMessageList) {
            UserTransfer userTransfer = new UserTransfer();
            //message->userTransfer
            BeanUtils.copyProperties(message,userTransfer);
            try{
                userTransferMapper.insert(userTransfer.getId(),userTransfer.getName(),userTransfer.getAvatar(),userTransfer.getShimoMail(),userTransfer.getIdentifier(),userTransfer.getUnionid(),userTransfer.getActualName());
            }catch (Exception e){
                System.out.println(userTransfer.getId());
            }
        }
        return "re";
    }

}
