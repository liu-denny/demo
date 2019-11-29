package com.demo.date.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户
 * @author yudong
 * @create 2019-09-17 10:54
 */
@Data
public class UserMessage {
    private Long id;

    private String name;

    private String avatar;

    private String shimoMail;

    private String identifier;

    private String unionid;

    private String actualName;


}
