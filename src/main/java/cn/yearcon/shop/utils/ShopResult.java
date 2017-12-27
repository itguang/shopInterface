package cn.yearcon.shop.utils;

import java.io.Serializable;


/**
 * 封装积分商城返回结果
 *
 * @author itguang
 * @create 2017-10-19 15:37
 **/
public class ShopResult implements Serializable {
    /**
     *响应业务状态
     */
    private Integer status;

    /**
     * 响应消息
     *
     */
    private String msg;

    /**
     * 响应中的数据
     */
    private Object data;


    public static ShopResult build(Integer status, String msg, Object data) {
        return new ShopResult(status, msg, data);
    }

    public static ShopResult ok(Object data) {
        return new ShopResult(data);
    }

    public static ShopResult ok() {
        return new ShopResult(null);
    }

    public ShopResult() {

    }

    public static ShopResult build(Integer status, String msg) {
        return new ShopResult(status, msg, null);
    }

    public ShopResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
    public ShopResult(Integer status, String msg) {
        this.status = status;
        this.msg = msg;

    }


    public ShopResult(Object data) {
        this.status = 1;
        this.msg = "OK";
        this.data = data;
    }




    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "ShopResult{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
