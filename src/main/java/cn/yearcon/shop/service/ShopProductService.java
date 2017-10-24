package cn.yearcon.shop.service;


import cn.yearcon.shop.entity.ShopProduct;
import cn.yearcon.shop.mapper.ShopProductMapper;
import cn.yearcon.shop.service.common.CrudService;


import cn.yearcon.shop.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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



    /**
     * 在商品表中查找新品,返回特定属性值
     * @param size 查找新品数据的数量,
     * @return  List<ShopProduct>
     */
    public List<ShopProduct> findIsNew(Integer size){
        List<ShopProduct> list = shopProductMapper.findIsNew(size);
        return list;
    }

    /**
     * 通过商品id查找商品信息
     * @param id
     * @return
     */
    public ShopProduct findShopProductByid(String id){
        ShopProduct shopProduct = shopProductMapper.findShopProductByid(id);
        //商品访问量+1
        incrementShopProductVisits(id);
        return shopProduct;

    }

    /**
     * 商品访问量+1
     * @param id
     * @return
     */
    @Transactional(readOnly = false)
   public Integer incrementShopProductVisits(String id){
      Integer i =  shopProductMapper.incrementShopProductVisits(id);
      return i;

   }

    /**
     * 商品销量+1
     * @param id
     * @return
     */
   @Transactional(readOnly = false)
   public Integer incrementShopProductSales(String id){
      Integer i =  shopProductMapper.incrementShopProductSales(id);
      return i;

   }

    /**
     * 通过商品分类页面的条件查找相关商品信息
     * @param shopProduct
     * @return
     */
    public List<ShopProduct> findListByCondition(ShopProduct shopProduct){
        int count = findListCount(shopProduct);
        int pagenum = shopProduct.getPagenum();
        int pageSize = shopProduct.getPageSize();
        Page page = new Page(pagenum, pageSize, count);
        int startIndex = page.getStartIndex();
        shopProduct.setStartIndex(startIndex);

        List<ShopProduct> list = shopProductMapper.findList(shopProduct);
        return list;

    }


    public Integer findListCount(ShopProduct shopProduct){
        Integer i = shopProductMapper.findListCount(shopProduct);
        return i;

    }







}
