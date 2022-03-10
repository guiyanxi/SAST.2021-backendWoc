package com.example.woc.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespBean {
    @ApiModelProperty(value = "success")// 本次请求成功与否
    private Boolean success;
    @ApiModelProperty(value = "Msg")//such as "权限不足"errMsg 此处未和需求完全一致
    private String Msg;
    @ApiModelProperty(value = "errCode")//表示请求失败的错误码
    private Integer errCode;
    @ApiModelProperty(value = "data")//真正返回的数据
    private Object data;

    public static RespBean success(String msg){

        return new RespBean(true,msg,null,null);
    }
    public static RespBean success(String msg,Object data){

        return new RespBean(true,msg,null,data);
    }

    public static RespBean error(String errMsg){

        return new RespBean(true,errMsg,550,null);
    }
    //失败返回message,obj
    public static RespBean error(String message, Object obj) {

        return new RespBean(true, message,550, obj);
    }
}



