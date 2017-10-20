package cn.yearcon.shop.dao.repository;

import cn.yearcon.shop.entity.ShopProductSpecification;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 商品规格
 * @author itguang
 */
public interface ShopProductSpecificationRepository extends JpaRepository<ShopProductSpecification,String> {

}
