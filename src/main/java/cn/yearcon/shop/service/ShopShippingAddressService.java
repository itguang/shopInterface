package cn.yearcon.shop.service;

import cn.yearcon.shop.entity.ShopShippingAddress;
import cn.yearcon.shop.mapper.ShopShippingAddressMapper;
import cn.yearcon.shop.service.common.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ShopShippingAddress 收货地址业务逻辑层
 *
 * @author itguang
 * @create 2017-10-20 14:35
 **/
@Service
@Transactional
public class ShopShippingAddressService extends CrudService<ShopShippingAddressMapper,ShopShippingAddress> {

    @Autowired
    private ShopShippingAddressMapper shopShippingAddressMapper;
}
