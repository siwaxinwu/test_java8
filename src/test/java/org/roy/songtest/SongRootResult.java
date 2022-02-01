package org.roy.songtest;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2022/1/10 14:01
 */
public class SongRootResult<T> {

    private int code;
    private String msg;
    private String requestId;
    private String ext;
    private T data;
    public void setCode(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public String getMsg() {
        return msg;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
    public String getRequestId() {
        return requestId;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }
    public String getExt() {
        return ext;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
