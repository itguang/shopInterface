/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package cn.yearcon.shop.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 顾客信息Entity
 * @author itguang
 * @version 2017-10-20
 */
@Entity//要使用spring data jpa 要在实体类上加上此注解
public class ShopCustomer {
	/**
	 * 顾客id
	 */
	@Id
	private String id;
	/**
	 *微信认证授权
	 */
	private String openid;
	/**
	 *收货地址
	 */
	private Integer shippingAddressId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public Integer getShippingAddressId() {
		return shippingAddressId;
	}

	public void setShippingAddressId(Integer shippingAddressId) {
		this.shippingAddressId = shippingAddressId;
	}

	@Override
	public String toString() {
		return "ShopCustomer{" +
				"id='" + id + '\'' +
				", openid='" + openid + '\'' +
				", shippingAddressId=" + shippingAddressId +
				'}';
	}
}