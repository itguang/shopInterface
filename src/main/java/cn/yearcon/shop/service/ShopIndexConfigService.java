package cn.yearcon.shop.service;

import cn.yearcon.shop.entity.ShopCategory;
import cn.yearcon.shop.entity.ShopIndexConfig;
import cn.yearcon.shop.entity.ShopProduct;
import cn.yearcon.shop.mapper.ShopIndexConfigMapper;
import cn.yearcon.shop.service.common.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * 首页配置service
 *
 * @author itguang
 * @create 2017-10-19 14:27
 **/
@Service
@Transactional
public class ShopIndexConfigService extends CrudService<ShopIndexConfigMapper,ShopIndexConfig> {

    @Autowired
    private ShopIndexConfigMapper shopIndexConfigMapper;



    public List<ShopIndexConfig> getByType(Integer type){
        List<ShopIndexConfig> lists = shopIndexConfigMapper.getByType(type);
        return lists;
    }

    @Cacheable(value = "index/image")
    public List<ShopIndexConfig> getIndexImage(){
        List<ShopIndexConfig> lists = shopIndexConfigMapper.getIndexImage();
        return lists;
    }


    /**
     * 查找首页分类信息
     * @return
     */
    @Cacheable("product")
    public HashMap<String, List<ShopProduct>> findIndexCategory(){
        List<ShopCategory> allCategory = findAllCategory();
        HashMap<String, List<ShopProduct>> map = new HashMap<>();
        for (ShopCategory category : allCategory) {
            String categoryName  = category.getCategoryName();
            String categoryId = category.getId();
            List<ShopProduct> indexCategoryByCategoryId = shopIndexConfigMapper.findIndexCategoryByCategoryId(categoryId);
            map.put(categoryName,indexCategoryByCategoryId);
        }
        return map;
    }


    /**
     * 查询所有分类信息
     * @return
     */
    public List<ShopCategory> findAllCategory(){
        List<ShopCategory> list = shopIndexConfigMapper.findAllCategory();
        return list;
    }


    public List<ShopIndexConfig> findINdexMenu(){
        List<ShopIndexConfig> list = shopIndexConfigMapper.findINdexMenu();
        return list;
    }

    /**
     * 得到导航栏信息
     * @return
     */
    public List<ShopIndexConfig> findTabMenu(){
        List<ShopIndexConfig> list = shopIndexConfigMapper.findTabMenu();
        return list;
    }

}
