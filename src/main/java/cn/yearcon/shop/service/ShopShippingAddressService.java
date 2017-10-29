package cn.yearcon.shop.service;

import cn.yearcon.shop.entity.ShopShippingAddress;
import cn.yearcon.shop.mapper.ShopShippingAddressMapper;
import cn.yearcon.shop.service.common.CrudService;
import cn.yearcon.shop.utils.IdGen;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Autowired
    private ShopCustomerService shopCustomerService;

    /**
     * 通过openid获取该用户的收货地址列表
     * @param openid
     * @return
     */
   public List<ShopShippingAddress> getShopShippingAddressesByOpenid( String openid){
        List<ShopShippingAddress> list = shopShippingAddressMapper.getShopShippingAddressesByOpenid(openid);
        return list;
    }

    /**
     *增加一个收货地址
     * @param shippingAddress
     * @return
     */
    public Integer  saveShopShippingAddress(ShopShippingAddress shippingAddress){
        //设置主键
        String uuid = IdGen.uuid();
        shippingAddress.setId(uuid);
        //设置所属顾客id
       String CustomerId =  shopCustomerService.findUniqueByOPenid(shippingAddress.getOpenid()).getId();
        shippingAddress.setCustomerId(CustomerId);

        int i = shopShippingAddressMapper.insert(shippingAddress);

        return i;
    }

    /**
     *修改一个收货地址
     * @param shippingAddress
     * @return
     */
    public Integer updateShopShippingAddress(ShopShippingAddress shippingAddress){
        int i = shopShippingAddressMapper.update(shippingAddress);

        return i;
    }

    public Integer deleteShopShippingAddressById(String id){
        int i = shopShippingAddressMapper.delete(id);
        return i;


    }

    /**
     * 根据收货地址id设置默认收货地址
     * @param addressId
     * @return
     */
    @Transactional
    public Integer setDefaultShopShippingAddress(String addressId){

        //把默认的收货地址去掉
        ShopShippingAddress shopShippingAddress = shopShippingAddressMapper.get(addressId);
        shopShippingAddressMapper.clearDefaultAddress(shopShippingAddress.getCustomerId());
        //再设置默认地址
        Integer i = shopShippingAddressMapper.setDefaultShopShippingAddress(addressId);
        return i;

    }


}
