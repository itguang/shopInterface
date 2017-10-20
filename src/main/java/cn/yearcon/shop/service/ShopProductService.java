package cn.yearcon.shop.service;

import cn.yearcon.shop.entity.ShopProduct;
import cn.yearcon.shop.mapper.ShopProductMapper;
import cn.yearcon.shop.service.common.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ShopProduct 业务逻辑层
 *
 * @author itguang
 * @create 2017-10-20 14:31
 **/
@Service
@Transactional
public class ShopProductService extends CrudService<ShopProductMapper,ShopProduct> {

    @Autowired
    private ShopProductMapper shopProductMapper;


}
