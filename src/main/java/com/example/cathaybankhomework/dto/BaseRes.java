package com.example.cathaybankhomework.dto;

import lombok.Data;

@Data
public class BaseRes extends BaseObject{

    /**
     * 狀態碼 0表示成功過，1表示處理中，-1 表示失敗
     */
    private Integer code;

    /**
     * 業務數據
     */
    private Object resultData;

    /**
     * 信息表示
     */
    private String msg;

    public BaseRes(){}

    public BaseRes(Integer code, Object resultData, String msg){
        this.code = code;
        this.resultData = resultData;
        this.msg = msg;
    }


    /**
     * 成功，不用返回數據
     * @return
     */
    public static BaseRes buildSuccess(){
        return new BaseRes(0,null,null);
    }

    /**
     * 成功，返回數據
     * @param data
     * @return
     */
    public static BaseRes buildSuccess(Object data){
        return new BaseRes(0,data,null);
    }


    /**
     * 失敗，固定狀態碼
     * @param msg
     * @return
     */
    public static BaseRes buildError(String resultData, String  msg){
        return new BaseRes(-1 , resultData, msg);
    }


    /**
     * 失敗，自定義錯誤碼(狀態碼)和信息
     * @param code
     * @param msg
     * @return
     */
    public static BaseRes buildError(Integer code , String  msg){
        return new BaseRes(code ,null,msg);
    }
}
