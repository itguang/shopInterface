package cn.yearcon.shop.service;

import cn.yearcon.shop.entity.ShopIndexConfig;
import cn.yearcon.shop.mapper.ShopIndexConfigMapper;
import cn.yearcon.shop.service.common.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 首页配置service
 *
 * @author itguang
 * @create 2017-10-19 14:27
 **/
@Service
@Transactional
public class ShopIndexConfigService extends CrudService<ShopIndexConfigMapper,ShopIndexConfig> {

    @Autowired
    private ShopIndexConfigMapper shopIndexConfigMapper;



    public List<ShopIndexConfig> getByType(Integer type){
        List<ShopIndexConfig> lists = shopIndexConfigMapper.getByType(type);
        return lists;
    }
    public List<ShopIndexConfig> getIndexImage(){
        List<ShopIndexConfig> lists = shopIndexConfigMapper.getIndexImage();
        return lists;
    }
}
