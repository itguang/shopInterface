package cn.yearcon.shop.handler;

import cn.yearcon.shop.exception.ShopException;
import cn.yearcon.shop.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 * @author itguang
 * @create 2017-12-27 12:59
 **/

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandle {

    @ExceptionHandler(value = ShopException.class)
    @ResponseBody
    public ResultVo handleShopException(ShopException e){
        log.info("[发生异常:]ShopException={}:{}",e.getStatus(),e.getMessage());
        return new ResultVo(e.getStatus(),e.getMessage());


    }



}
