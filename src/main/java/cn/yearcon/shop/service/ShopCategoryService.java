package cn.yearcon.shop.service;

import cn.yearcon.shop.entity.ShopCategory;
import cn.yearcon.shop.entity.ShopProduct;
import cn.yearcon.shop.mapper.ShopCategoryMapper;
import cn.yearcon.shop.mapper.ShopCustomerMapper;
import cn.yearcon.shop.service.common.CrudService;
import cn.yearcon.shop.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * ShopCategory 业务逻辑层
 *
 * @author itguang
 * @create 2017-10-20 14:04
 **/
@Service
@Transactional
public class ShopCategoryService extends CrudService<ShopCategoryMapper, ShopCategory> {

    @Autowired
    private ShopCategoryMapper shopCategoryMapper;

    public List<ShopCategory> getAllShopCategory() {
        List<ShopCategory> list = shopCategoryMapper.getAllShopCategory();
        return list;
    }

    /**
     * 通过商品分类id 和分页参数,获取商品信息
     * @param id 商品分类id
     * @param curPage 页数
     * @param pageSize 页大小
     * @return
     */
    public List<ShopProduct> getShopProductByCategoryId(String id, int curPage, int pageSize) {
        int total = findCountByCategoryId(id);
        Page page = new Page(curPage, pageSize, total);
        int startIndex = page.getStartIndex();

        List<ShopProduct> list = shopCategoryMapper.getShopProductByCategoryId(id,startIndex, pageSize);
        return list;
    }

    /**
     * 查询某个分类下所有商品总数
     *
     * @param id
     * @return
     */
    public int findCountByCategoryId(String id) {
        return shopCategoryMapper.findCountByCategoryId(id);

    }


}
