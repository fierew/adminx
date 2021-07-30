package com.fierew.adminx.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author xuyang
 */
@Data
@Schema(name = "Result", description = "通用返回对象")
public class ResultVO {
    @Schema(name = "code", description = "状态码")
    private Integer code;

    @Schema(name = "message", description = "提示信息")
    private String message;

    @Schema(name = "data", description = "数据封装")
    private Object data;

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
