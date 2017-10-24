package cn.yearcon.shop.common;

import cn.yearcon.shop.utils.HttpClientUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import java.util.HashMap;

/**
 * 积分变更,查询
 *
 * @author itguang
 * @create 2017-10-24 8:07
 **/
public class PointUtil {
    @Autowired
    private static HttpClientUtil httpClientUtil;

   static String appkey = "2000005";
    static String appsecret = "3d9aa8c0707aa7cb16050beabe2b89ee";
    static String BASE_URL = "http://192.168.1.216:8080/rest";





    /**
     * 查询积分
     * @param openid
     * @return
     */
    public static String  quryPoint(String openid){
        String url = BASE_URL+"/plt/point/get";
        String timestamp= String.valueOf(System.currentTimeMillis());
        String sign="";
        try {
            sign = createSign(appsecret, timestamp);
            System.out.println("sign="+sign);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        HashMap<String, Object> map = new HashMap(16);
        map.put("appkey", appkey);
        map.put("timestamp", timestamp);
        map.put("sign", sign);
        map.put("openid",openid);
        String body=null;
        try {
             body = httpClientUtil.doGet(url, map);



        } catch (Exception e) {
            e.printStackTrace();
        }


        return body;

    }
    //积分变更
    //会员信息查询

    /* 生成签名算法
     * @param appSecret 应用密钥
     * @param timestamp 时间戳
     * @return
     * @throws java.io.UnsupportedEncodingException
*/

    public static String createSign(String appSecret, String timestamp) {
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
