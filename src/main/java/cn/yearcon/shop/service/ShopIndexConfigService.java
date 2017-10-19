package cn.yearcon.shop.service;

import cn.yearcon.shop.entity.ShopIndexConfig;
import cn.yearcon.shop.mapper.ShopIndexConfigMapper;
import cn.yearcon.shop.service.common.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * 首页配置cervice
 *
 * @author itguang
 * @create 2017-10-19 14:27
 **/
@Service
@Transactional
public class ShopIndexConfigService extends CrudService<ShopIndexConfigMapper,ShopIndexConfig> {

    @Autowired
    private ShopIndexConfigMapper shopIndexConfigMapper;

    @Override
    public ShopIndexConfig get(String id) {
        return super.get(id);
    }

    @Override
    public ShopIndexConfig get(ShopIndexConfig entity) {
        return super.get(entity);
    }

    @Override
    public List<ShopIndexConfig> findList(ShopIndexConfig entity) {
        return super.findList(entity);
    }

    @Override
    public void save(ShopIndexConfig entity) {
        super.save(entity);
    }

    @Override
    public void delete(ShopIndexConfig entity) {
        super.delete(entity);
    }

    @Override
    public void deleteAll(Collection<ShopIndexConfig> entitys) {
        super.deleteAll(entitys);
    }

    @Override
    public ShopIndexConfig findUniqueByProperty(String propertyName, Object value) {
        return super.findUniqueByProperty(propertyName, value);
    }

    public List<ShopIndexConfig> getByType(Integer type){
        List<ShopIndexConfig> lists = shopIndexConfigMapper.getByType(type);
        return lists;
    }
    public List<ShopIndexConfig> getIndexImage(){
        List<ShopIndexConfig> lists = shopIndexConfigMapper.getIndexImage();
        return lists;
    }
}
