package cn.yearcon.shop;

import cn.yearcon.shop.common.PointUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import java.awt.*;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 积分接口测试
 *
 * @author itguang
 * @create 2017-10-24 8:57
 **/
public class PointUtilTest {

    @Test
    public void  test1(){

        String body = PointUtil.quryPoint("oeIqJuORK4ThFP7siwepco9zR9zA");
        System.out.println(body);
        String timestamp= String.valueOf(System.currentTimeMillis());
        String sign = createSign("2000005", timestamp);
        System.out.println(sign);
    }
    public  String createSign(String appSecret, String timestamp) {
        String str=timestamp+"&" + appSecret;
        String strUrlencode = null;
        try {
            strUrlencode = URLEncoder.encode(str.toLowerCase(),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String strMd5 = DigestUtils.md5Hex(strUrlencode.toLowerCase());
        return strMd5.toLowerCase();
    }


}
