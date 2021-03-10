package com.aresix.eudemoniabackend.utils;

import com.aresix.eudemoniabackend.common.ResponseCode;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 封装前端返回的统一实体类
 *
 * @param <T>
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ServerResponse<T> {
    private int status; // 状态0：接口调用成功
    private T data;
    private String msg;

    private ServerResponse() {
    }

    private ServerResponse(int status) {
        this.status = status;
    }

    private ServerResponse(int status, T data) {
        this.status = status;
        this.data = data;

    }

    private ServerResponse(int status, T data, String msg) {
        this.status = status;
        this.data = data;
        this.msg = msg;

    }

    @JsonIgnore
    public boolean isSuccess(){
        return status==0;
    }

    public static ServerResponse createServerResponseBySuccess() {
        return new ServerResponse(0);
    }

    public static <T> ServerResponse createServerResponseBySuccess(T data) {
        return new ServerResponse(0, data);
    }

    public static <T> ServerResponse createServerResponseBySuccess(T data, String msg) {
        return new ServerResponse(0, data, msg);
    }

    public static ServerResponse createServerResponseByFailure(int errCode) {
        return new ServerResponse(errCode);
    }

    public static <T> ServerResponse createServerResponseByFailure(int errCode, String msg) {
        return new ServerResponse(errCode, null, msg);
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static ServerResponse getFailServerResponse(ResponseCode code) {
        return ServerResponse.createServerResponseByFailure(code.getCode(), code.getMsg());
    }
}
