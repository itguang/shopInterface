package cn.yearcon.shop.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

/**
 * 测试
 *
 * @author itguang
 * @create 2017-10-26 17:17
 **/
@RestController
public class PointUtil {

    @Autowired
    private static HttpClientUtil httpClientUtil;

    static String appkey = "2000005";
    static String appsecret = "3d9aa8c0707aa7cb16050beabe2b89ee";
    static String BASE_URL = "http://192.168.1.216:8080/rest";


    /**
     * 查询积分
     *
     * @param openid
     * @return
     */
    public static String quryPoint(String openid) {
        String url = BASE_URL + "/plt/point/get";
        String timestamp = String.valueOf(System.currentTimeMillis());
        String sign = "";
        try {
            sign = createSign(appsecret, timestamp);
            System.out.println("sign=" + sign);
            System.out.println("timestamp="+timestamp);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        HashMap<String, Object> map = new HashMap(16);
        map.put("appkey", appkey);
        map.put("timestamp", timestamp);
        map.put("sign", sign);
        map.put("openid", openid);
        String body = null;
        try {
            System.out.println("url="+url);
            body = httpClientUtil.doGet(url, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return body;
    }

    public static String createSign(String appSecret, String timestamp) {
        String str = timestamp + "&" + appSecret;
        String strUrlencode = null;
        try {
            strUrlencode = URLEncoder.encode(str.toLowerCase(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String strMd5 = DigestUtils.md5Hex(strUrlencode.toLowerCase());
        return strMd5.toLowerCase();
    }


}
