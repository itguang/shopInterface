package cn.yearcon.shop;

import cn.yearcon.shop.service.PointService;
import cn.yearcon.shop.utils.PointUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * 积分接口测试
 *
 * @author itguang
 * @create 2017-10-24 8:57
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class PointServiceTest {

    @Autowired
    private PointService pointService;
    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void  test1(){


        String quryPoint = pointService.quryPoint("oeIqJuORK4ThFP7siwepco9zR9zA");
        try {
            Map map = objectMapper.readValue(quryPoint, Map.class);
            Integer code = (Integer)map.get("code");
            if(code==0){
                Map map1 = (Map) map.get("jsondata");
                String points= (String)map1.get("points");
                System.out.println("points="+Integer.parseInt(points));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }





    }

    @Test
    public void  test2(){
        String body = pointService.QueryVipByOpenid("oeIqJuORK4ThFP7siwepco9zR9zA");
        System.out.println("body="+body);

    }


    @Test
    public void  test3(){
        String body = pointService.updatePoint("oeIqJuORK4ThFP7siwepco9zR9zA","500","测试一下");
        try {
            Map map = objectMapper.readValue(body, Map.class);
            Integer code = (Integer) map.get("code");
            Map jsondata = (Map) map.get("jsondata");

            System.out.println("code="+code);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }








}
