package com.example.woc.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

//用户登录实体类
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "account 对象", description = "")

public class AccountLogin {

    @ApiModelProperty(value = "用户名", required = true) // require 必填
    private String username;
    @ApiModelProperty(value = "密码", required = true)
    private String password;
}
