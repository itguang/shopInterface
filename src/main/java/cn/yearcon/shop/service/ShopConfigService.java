package cn.yearcon.shop.service;

import cn.yearcon.shop.entity.ShopConfig;
import cn.yearcon.shop.mapper.ShopConfigMapper;
import cn.yearcon.shop.mapper.ShopCustomerMapper;
import cn.yearcon.shop.service.common.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ShopConfig 业务逻辑层
 *
 * @author itguang
 * @create 2017-10-20 14:18
 **/
@Service
@Transactional
public class ShopConfigService extends CrudService<ShopConfigMapper,ShopConfig>{

    @Autowired
    private ShopConfigMapper shopConfigMapper;

    public ShopConfig getById(String id){
        ShopConfig shopConfig = shopConfigMapper.get(id);
        return shopConfig;

    }

}
