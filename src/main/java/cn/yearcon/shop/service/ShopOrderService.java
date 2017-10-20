package cn.yearcon.shop.service;

import cn.yearcon.shop.entity.ShopOrder;
import cn.yearcon.shop.mapper.ShopOrderMapper;
import cn.yearcon.shop.service.common.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ShopOrder 业务逻辑层
 *
 * @author itguang
 * @create 2017-10-20 14:23
 **/
@Service
@Transactional
public class ShopOrderService extends CrudService<ShopOrderMapper,ShopOrder> {

    @Autowired
    private ShopOrderMapper shopOrderMapper;
}
