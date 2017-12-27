package cn.yearcon.shop.controller;

import cn.yearcon.shop.entity.ShopConfig;
import cn.yearcon.shop.service.ShopConfigService;
import cn.yearcon.shop.service.ShopCustomerService;
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

/**
 * @author itguang
 */
@RestController
@RequestMapping(value = "shop/")
public class WeixinController {

    @Autowired
    private ShopCustomerService shopCustomerService;

    @Autowired
    private ShopConfigService shopConfigService;

    @Autowired
    private HttpClientUtil httpClientUtil;
    @Autowired
    private ObjectMapper objectMapper;

    String appid;
    String secret;
    @Value("${weixin.grant_type}")
    String grant_type;
    @Value("${pointShop.index}")
    String pointShopIndex;


    @RequestMapping(value = "weixin")
    public String weixinLogin(HttpServletRequest request, HttpServletResponse response) {

        //从数据库获取 weixin.appid 和 weixin.secret
        ShopConfig shopConfig = null;
        try {
            shopConfig = shopConfigService.getById("1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (shopConfig == null) {
            return "尚未在后台设置微信公共号基本配置";
        }
        appid = shopConfig.getAppid();
        secret = shopConfig.getSecret();


        // 用户同意授权后，能获取到code
        String code = request.getParameter("code");
        if (code == null) {
            return "获取微信code失败!";
        }

        System.out.println("code=" + code);
        String openid = getOpenidByCode(code);

        if (openid == null) {
            return "获取微信openid失败!";
        }

        //如果第一次访问,保存openid到数据库中
        saveOpenidToDataBase(openid);
        System.out.println("openid=" + openid);
        Cookie cookie = saveOpenid(openid, request);

        try {
            response.addCookie(cookie);
            //重定向到商城首页
            response.sendRedirect(pointShopIndex);
            System.out.println("pointShopIndex="+pointShopIndex);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 把openid保存到cookie和session,发送给客户端,并且重定向到积分商城首页
     *
     * @param openid
     * @return 保存了openid的Cookie
     */
    private Cookie saveOpenid(String openid, HttpServletRequest request) {
        //往cookie中设置openid
        Cookie cookie = new Cookie("openid", openid);
        //cookie有效期一年
        cookie.setMaxAge(60 * 60 * 24 * 365);
//        cookie.setDomain("dsjfcrm.yearcon.com");

        HttpSession session = request.getSession();
        //往session里设置openid
        session.setAttribute("openid", openid);
        //设置session过期时间 2小时.
        session.setMaxInactiveInterval(2 * 60 * 60);
        return cookie;
    }

    /**
     * 通过code获取openid
     *
     * @param code
     * @return openid
     */
    private String getOpenidByCode(String code) {
        //https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx1642c5a5400c82e2&redirect_uri=http://dsjfcrm.yearcon.com/shop/weixin&response_type=code&scope=snsapi_userinfo&#wechat_redirect
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token";
        HashMap<String, Object> map = new HashMap(16);

        map.put("appid", appid);
        map.put("secret", secret);
        map.put("grant_type", grant_type);
        map.put("code", code);


        Map result = null;
        try {
            String body = httpClientUtil.doGet(url, map);
            if (body != null) {
                result = objectMapper.readValue(body, Map.class);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(result);
        String access_token = (String) result.get("access_token");
        String openid = (String) result.get("openid");
        return openid;
    }

    /**
     * 保存openid到数据库Customer表,如果数据库表中已有则什么都不做
     *
     * @param openid
     * @return
     */
    public Integer saveOpenidToDataBase(String openid) {
        Integer i = shopCustomerService.saveOPenid(openid);
        return i;
    }


    @RequestMapping(value = "shop/test")
    public String test(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "redirect:https://www.baidu.com";
    }





}
