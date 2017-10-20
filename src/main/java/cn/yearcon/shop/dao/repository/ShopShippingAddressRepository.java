package cn.yearcon.shop.dao.repository;

import cn.yearcon.shop.entity.ShopShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 收货地址
 * @author itguang
 *
 */
public interface ShopShippingAddressRepository extends JpaRepository<ShopShippingAddress,String> {
}
