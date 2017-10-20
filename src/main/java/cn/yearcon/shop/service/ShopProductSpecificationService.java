package cn.yearcon.shop.service;

import cn.yearcon.shop.entity.ShopProductSpecification;
import cn.yearcon.shop.mapper.ShopProductSpecificationMapper;
import cn.yearcon.shop.service.common.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ShopProductSpecification 产品规格表业务逻辑层
 *
 * @author itguang
 * @create 2017-10-20 14:33
 **/
@Service
@Transactional
public class ShopProductSpecificationService extends CrudService<ShopProductSpecificationMapper,ShopProductSpecification> {

    @Autowired
    private ShopProductSpecificationMapper shopProductSpecificationMapper;
}
