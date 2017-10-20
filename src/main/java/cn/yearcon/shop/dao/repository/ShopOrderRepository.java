package cn.yearcon.shop.dao.repository;

import cn.yearcon.shop.entity.ShopOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopOrderRepository extends JpaRepository<ShopOrder,String> {

}
