package cn.yearcon.shop.fliter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author itguang
 * 自定义过滤器,用来拦截所有请求,检查cookie和session中是否有openid存在,
 * 如果没有重定向到 微信的网页授权链接 进行网页授权登陆
 * 如果有openid,放行即可
 */
public class CheckOpenidFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CheckOpenidFilter init...");

    }

    /**
     * 进行openid检查,
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //服务端设置允许跨域
        response.setHeader("Access-Control-Allow-Origin", "*");
        Boolean hasOpenid=false;
        String openid;

//        有的话放行
        System.out.println("拦截" + request.getRequestURL());

        //判断cookie中是否有openid
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for (int i = 0; i < cookies.length; i++) {
                //依次取出cookie
                Cookie cookie = cookies[i];
                if("openid".equals(cookie.getName())){
                     openid = cookie.getValue();
                    System.out.println("Cookie中的="+openid);
                     hasOpenid = true;
                }
            }
        }

        //判断session中是否有openid
        HttpSession session = request.getSession();
        String openidSession = (String) session.getAttribute("openid");
        System.out.println("session中的openid="+openidSession);
        if(openidSession!=null){
            //有
            openid = openidSession;
            hasOpenid = true;
        }
        System.out.println("hasOpenid="+hasOpenid);
        //如果有
        if(hasOpenid){
            //放行
            filterChain.doFilter(servletRequest, servletResponse);
        }else{
            //        没有的话,重定向到微信网页授权登陆页面
//           String loginUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx1642c5a5400c82e2&redirect_uri=http://www.yearcontest.com&response_type=code&scope=snsapi_userinfo&#wechat_redirect";
//            response.sendRedirect(loginUrl);

            //开发接口时为了方便,先放行
            filterChain.doFilter(servletRequest, servletResponse);

        }

    }

    @Override
    public void destroy() {
        System.out.println("CheckOpenidFilter destroy...");
    }

}
