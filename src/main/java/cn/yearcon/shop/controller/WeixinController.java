package cn.yearcon.shop.controller;

import cn.yearcon.shop.utils.HttpClientUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class WeixinController {

    @Autowired
    private HttpClientUtil httpClientUtil;
    @Autowired
    private ObjectMapper objectMapper;

    @Value("${weixin.appid}")
    String appid ;
    @Value("${weixin.secret}")
    String secret;
    @Value("${weixin.grant_type}")
    String grant_type;
    @Value("${pointShop.index}")
    String pointShopIndex;


    @RequestMapping(value = {"", ""})
    public String getOpenid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 用户同意授权后，能获取到code
        String code = request.getParameter("code");
        if(code==null){
            return "获取微信code失败!";

        }
        System.out.println("code=" + code);
        //https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx1642c5a5400c82e2&redirect_uri=http://www.yearcontest.com&response_type=code&scope=snsapi_userinfo&#wechat_redirect
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token";
        HashMap<String, Object> map = new HashMap<String, Object>(16);

        map.put("appid",appid);
        map.put("secret",secret);
        map.put("grant_type",grant_type);
        map.put("code",code);

        String  body = httpClientUtil.doGet(url, map);
        Map result = objectMapper.readValue(body, Map.class);
        System.out.println(result);
        String access_token =(String) result.get("access_token");
        String openid = (String)result.get("openid");
        System.out.println("access_token="+access_token);
        System.out.println("openid="+openid);

//      把openid保存到cookie和session,发送给客户端,并且重定向到积分商城首页
        Cookie cookie = new Cookie("openid",openid);//往cookie中设置openid(没有过期时间)
        cookie.setMaxAge(60*60*24*365);//cookie有效期一年
        HttpSession session = request.getSession();

        session.setAttribute("openid",openid);//往session里设置openid
        session.setMaxInactiveInterval(2*60*60);//设置session过期时间 2小时.
        try {
            response.addCookie(cookie);
            //跳转到商城首页
            response.sendRedirect(pointShopIndex);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }


    @RequestMapping(value = "shop/test")
    public String test(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "redirect:https://www.baidu.com";
    }
}
