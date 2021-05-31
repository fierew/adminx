package com.fierew.adminx.vo;

import lombok.Data;

import java.util.Collection;

/**
 * @author xuyang
 */
@Data
public class ResultVO {
    private Integer code;
    private String message;
    private Object data;

    private ResultVO() {

    }

    public static ResultVO error(int code, String message) {
        ResultVO result = new ResultVO();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static ResultVO success() {
        ResultVO result = new ResultVO();
        result.setCode(0);
        result.setMessage("success");
        return result;
    }

    public static ResultVO success(Object data) {
        ResultVO result = new ResultVO();
        result.setCode(200);
        result.setMessage("success");
        result.setData(data);
        return result;
    }

}
