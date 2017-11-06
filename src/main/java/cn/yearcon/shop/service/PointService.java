package cn.yearcon.shop.service;

import cn.yearcon.shop.utils.HttpClientUtil2;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.HashMap;

/**
 * 积分接口服务类
 *
 * @author itguang
 * @create 2017-10-26 16:48
 **/
@Component
public class PointService {

//    @Autowired
//    private static HttpClientUtil httpClientUtil;

    String appkey = "2000005";
    String appsecret = "3d9aa8c0707aa7cb16050beabe2b89ee";

    @Value("${shuyu.BASE_URL}")
    String BASE_URL ;


    /**
     * 根据openid查询积分
     *
     * @param openid
     * @return
     */
    public String quryPoint(String openid) {
        String url = BASE_URL + "/plt/point/get";
        String timestamp = String.valueOf(System.currentTimeMillis());
        String sign = "";
        try {
            sign = createSign(appsecret, timestamp);

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

            body = HttpClientUtil2.httpGetRequest(url, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return body;
    }

    /**
     * 查询会员信息
     *
     * @param openid
     * @return
     */
    public String QueryVipByOpenid(String openid) {
        String url = BASE_URL + "/plt/userInfo/get";
        String timestamp = String.valueOf(System.currentTimeMillis());
        String sign = "";
        try {
            sign = createSign(appsecret, timestamp);

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        System.out.println("timestamp=" + timestamp);
        System.out.println("sign=" + sign);

        HashMap<String, Object> map = new HashMap<>(16);
        map.put("appkey", appkey);
        map.put("timestamp", timestamp);
        map.put("sign", sign);
        map.put("openid", openid);
        String body = null;

        try {
            body = HttpClientUtil2.httpGetRequest(url, map);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }


        return body;
    }


    /**
     * 积分变更
     *
     * @param openid
     * @param ChangePoint 积分数据  负为减少,正为增加
     * @param Remark      本次积分变更备注信息
     * @return
     */
    public String updatePoint(String openid, String ChangePoint, String Remark) {
        String jsondata = "{\"openid\":\""+openid+"\",\"ChangePoint\":\""+ChangePoint+"\",\"Channel\":\"wechat\",\"Remark\":\""+Remark+"\"}";

        String url = BASE_URL + "/plt/point/put";
        String timestamp = String.valueOf(System.currentTimeMillis());
        String sign = "";
        try {
            sign = createSign(appsecret, timestamp);

        } catch (Exception e1) {
            e1.printStackTrace();
        }


        System.out.println("timestamp=" + timestamp);
        System.out.println("sign=" + sign);

        HashMap<String, Object> map = new HashMap<>(16);
        map.put("appkey", appkey);
        map.put("timestamp", timestamp);
        map.put("sign", sign);
        map.put("jsondata", jsondata);

        String body = null;
        try {
            body = HttpClientUtil2.httpPostRequest(url, map);
        } catch (UnsupportedEncodingException e) {
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
