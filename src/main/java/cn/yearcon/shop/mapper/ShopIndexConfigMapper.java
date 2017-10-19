/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package cn.yearcon.shop.mapper;

import cn.yearcon.shop.entity.ShopIndexConfig;
import cn.yearcon.shop.mapper.common.CrudDao;

import java.util.List;

/**
 * 积分商城首页配置DAO接口
 * @author itguang
 * @version 2017-10-19
 */

public interface ShopIndexConfigMapper extends CrudDao<ShopIndexConfig> {
    List<ShopIndexConfig> getByType(Integer type);
    List<ShopIndexConfig> getIndexImage();



	
}