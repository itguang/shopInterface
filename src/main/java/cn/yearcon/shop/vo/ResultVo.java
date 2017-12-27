package cn.yearcon.shop.vo;

import cn.yearcon.shop.enums.ResultEnum;
import lombok.Data;

import javax.xml.transform.Result;
import java.io.Serializable;

/**
 * http请求返回的最外层对象
 * @author itguang
 * @create 2017-12-27 11:06
 **/
@Data
public class ResultVo<T> implements Serializable{



    /**
     * 状态码
     */
    private Integer status;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private T data;

    public ResultVo() {
    }

    public ResultVo(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public ResultVo(ResultEnum resultEnum, T data) {
        this.status = resultEnum.getStatus();
        this.msg = resultEnum.getMsg();
        this.data = data;
    }

    public ResultVo(ResultEnum resultEnum) {
        this.status = resultEnum.getStatus();
        this.msg = resultEnum.getMsg();
    }

    /**
     * 返回操作成功的消息
     * @param resultEnum
     * @return
     */
    public static ResultVo success(ResultEnum resultEnum){
        return new ResultVo(resultEnum);

    }

}
