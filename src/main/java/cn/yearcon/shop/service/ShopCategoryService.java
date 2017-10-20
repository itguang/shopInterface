package cn.yearcon.shop.service;

import cn.yearcon.shop.entity.ShopCategory;
import cn.yearcon.shop.mapper.ShopCategoryMapper;
import cn.yearcon.shop.mapper.ShopCustomerMapper;
import cn.yearcon.shop.service.common.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * ShopCategory 业务逻辑层
 *
 * @author itguang
 * @create 2017-10-20 14:04
 **/
@Service
@Transactional
public class ShopCategoryService extends CrudService<ShopCategoryMapper,ShopCategory> {

    @Autowired
    private ShopCustomerMapper shopCustomerMapper;

}
