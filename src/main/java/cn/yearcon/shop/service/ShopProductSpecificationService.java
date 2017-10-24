package cn.yearcon.shop.service;

import cn.yearcon.shop.entity.ShopProductSpecification;
import cn.yearcon.shop.mapper.ShopProductSpecificationMapper;
import cn.yearcon.shop.service.common.CrudService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    /**
     * 通过商品id查询商品规格参数
     * @param id 商品id
     * @return
     */
   public List<ShopProductSpecification> getShopProductSpecificationById( String id){
        List<ShopProductSpecification> list = shopProductSpecificationMapper.getShopProductSpecificationById(id);


        return list;
    }

}
