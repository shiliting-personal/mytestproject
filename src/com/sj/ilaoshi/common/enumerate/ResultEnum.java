package com.sj.ilaoshi.common.enumerate;

/**
 * 接口返回值枚举信息
 * Created by slt on 2017/3/27.
 */
public enum ResultEnum{

    SUCCESS(200, "ok"),
    BAD_REQUEST(400, "请求缺少secretId"),
    FORBIDDEN(401,"secretId错误"),
    SIGNATURE_FAILURE(410,"签名验证失败"),
    SERVICE_UNAVAILABLE(503,"接口异常"),
    ;

    private final int code;
    private final String value;
    ResultEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
