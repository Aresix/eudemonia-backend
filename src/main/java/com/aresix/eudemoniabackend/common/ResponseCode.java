package com.aresix.eudemoniabackend.common;

public enum ResponseCode {

    USERNAME_EMPTY(1, "用户名不能为空"),
    PASSWORD_EMPTY(2, "密码不能为空"),
    USERNAME_NOT_EXIST(3, "用户名不存在"),
    PASSWORD_ERROR(4, "密码错误"),
    PARAMETER_EMPTY(5, "参数为空"),
    USER_GENDER_EMPTY(6, "性别不能为空"),
    USER_AGE_INVALID(7, "年龄无效"),
    USERNAME_REGISTERED(8, "改用户名已注册"),
    REGISTER_FAIL(9, "注册失败"),
    NEED_LOGIN(10, "用户未登录"),
    USERINFO_UPDATE_FAIL(11, "用户信息修改失败"),
    USER_NOT_EXIST(12, "查无此人"),
    ;
    private int code;
    private String msg;

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
