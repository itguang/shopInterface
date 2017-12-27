package cn.yearcon.shop.exception;

import cn.yearcon.shop.enums.ResultEnum;
import lombok.Data;

/**
 * @author itguang
 * @create 2017-12-27 10:59
 **/
@Data
public class ShopException extends RuntimeException{


    private Integer status;

    public ShopException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.status = resultEnum.getStatus();

    }
}
