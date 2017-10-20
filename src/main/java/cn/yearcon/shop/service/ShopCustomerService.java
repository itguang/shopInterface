package cn.yearcon.shop.service;

import cn.yearcon.shop.entity.ShopCustomer;
import cn.yearcon.shop.mapper.ShopCustomerMapper;
import cn.yearcon.shop.service.common.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ShopCustomer 业务逻辑层
 *
 * @author itguang
 * @create 2017-10-20 14:21
 **/
@Service
@Transactional
public class ShopCustomerService extends CrudService<ShopCustomerMapper,ShopCustomer> {

    @Autowired
    private ShopCustomerMapper shopCustomerMapper;

}
