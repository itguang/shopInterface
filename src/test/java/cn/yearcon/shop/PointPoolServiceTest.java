package cn.yearcon.shop;


import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Map;

public class PointPoolServiceTest {

    String BASE_URL = "http://192.168.1.216:8080/rest";

    HttpClient httpclient = new HttpClient();// 创建一个客户端，类似打开一个浏览器

    @Test
    public void test() throws UnsupportedEncodingException, FileNotFoundException  {

        String[][] data = new String[][]{
                {"2000005", "3d9aa8c0707aa7cb16050beabe2b89ee",
                        "/plt/point/get",
                        "{\"openid\":\"oeIqJuORK4ThFP7siwepco9zR9zA\"}"
                }
        };
        String[][] data1 = new String[][]{
                {"2000005", "3d9aa8c0707aa7cb16050beabe2b89ee",
                        "/plt/point/put",
                        "{\"openid\":\"oeIqJuORK4ThFP7siwepco9zR9zA\",\"ChangePoint\":\"100\",\"Channel\":\"wechat\",\"Remark\":\"测试积分变更\"}"
                }
        };
        String[][] data2 = new String[][]{
                {"2000005", "3d9aa8c0707aa7cb16050beabe2b89ee",
                        "/plt/userInfo/get",
                        "{\"openid\":\"oeIqJuORK4ThFP7siwepco9zR9zA\"}"
                }
        };
        //查询积分
//        for (String[] apidata: data) {
//            String appkey = apidata[0];
//            String appsecret = apidata[1];
//            String url = BASE_URL + apidata[2];
//            String jsonStr = apidata[3];
//            testGet(appkey, appsecret, url, jsonStr);
//        }
        //积分变更
        for (String[] apidata: data1) {
            String appkey = apidata[0];
            String appsecret = apidata[1];
            String url = BASE_URL + apidata[2];
            String jsonStr = apidata[3];
            testPut(appkey, appsecret, url, jsonStr);
        }
        //会员信息查询
//        for (String[] apidata: data2) {
//            String appkey = apidata[0];
//            String appsecret = apidata[1];
//            String url = BASE_URL + apidata[2];
//            String jsonStr = apidata[3];
//            testGet(appkey, appsecret, url, jsonStr);
//        }


    }

    public void testGet(String appkey, String appsecret, String url, String jsonStr) {
        String timestamp= String.valueOf(new Date().getTime());
        String sign="";
        try {
            sign = createSign(appsecret, timestamp); //SignFilter.createSign(appsecret, timestamp);
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        GetMethod getMethod = new GetMethod(url);
        getMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"utf-8");//设置客户端请求字符集！
        Map map = JSONObject.parseObject(jsonStr, Map.class);
        //Query Perameter
        NameValuePair[] params = new NameValuePair[map.size()+3];
        params[0] = new NameValuePair("appkey", appkey);
        params[1] = new NameValuePair("timestamp", timestamp);
        params[2] = new NameValuePair("sign", sign);
        int i=3;
        for (Object key : map.keySet()){
            params[i] =  new NameValuePair((String)key, (String)map.get(key));
            i=i+1;
        }
        getMethod.setQueryString(params);
        try {
            System.out.println(url+"?appkey="+appkey+":timestamp=" + timestamp + ":sign=" + sign + "");
            System.out.println("HTTP_STATUS="+httpclient.executeMethod(getMethod));

            InputStream is = getMethod.getResponseBodyAsStream();
            String resp = IOUtils.toString(is, "UTF-8");
            System.out.println(resp);

        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testPut(String appkey, String appsecret, String url, String jsonStr) {
        String timestamp= String.valueOf(new Date().getTime());
        String sign="";
        try {
            sign = createSign(appsecret, timestamp); //SignFilter.createSign(appsecret, timestamp);
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        PostMethod postMethod = new PostMethod(url);
        postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"utf-8");//设置客户端请求字符集！

        //Query Perameter
        NameValuePair[] params = {
                new NameValuePair("appkey", appkey),
                new NameValuePair("timestamp", timestamp),
                new NameValuePair("sign", sign),

        };
        postMethod.setQueryString(params);

        //Form Perameter
        postMethod.addParameter("jsondata", jsonStr);



        try {
            System.out.println(url+"?appkey="+appkey+":timestamp=" + timestamp + ":sign=" + sign + ""+ ":appsecret=" + appsecret+"jsonStr="+jsonStr);
            System.out.println("HTTP_STATUS="+httpclient.executeMethod(postMethod));
            NameValuePair[] parameters = postMethod.getParameters();


            InputStream is = postMethod.getResponseBodyAsStream();
            String resp = IOUtils.toString(is, "UTF-8");
            System.out.println(resp);

        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
        String strMd5 =DigestUtils.md5Hex(strUrlencode.toLowerCase());
        return strMd5.toLowerCase();
    }

}
