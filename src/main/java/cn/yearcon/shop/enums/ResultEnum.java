package cn.yearcon.shop.enums;

import lombok.Getter;

/**
 * 消息枚举类
 * @author itguang
 */
@Getter
public enum ResultEnum {
    SUCCESS(0,"成功"),

    FAIL(1,"失败"),

    ORDER_NOT_EXIT(101,"订单不存在"),

    PAY_PASSWORD_ERROR(102,"支付密码错误"),

    POINT_NOT_ENOUGH(103,"积分不足")
;

    private Integer status;
    private  String msg;

    ResultEnum(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
