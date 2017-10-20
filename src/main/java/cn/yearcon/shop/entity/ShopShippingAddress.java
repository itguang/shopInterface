/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package cn.yearcon.shop.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 收货地址Entity
 * @author itguang
 * @version 2017-10-20
 */
@Entity//要使用spring data jpa 要在实体类上加上此注解
public class ShopShippingAddress {
	/**
	 *顾客id
	 */
	@Id
	private String id;
	/**
	 *省
	 */
	private String province;
	/**
	 *市
	 */
	private String city;
	/**
	 *区
	 */
	private String area;
	/**
	 *详细地址
	 */
	private String completeAddress;
	/**
	 *邮政编码
	 */
	private String postcode;
	/**
	 *收货人
	 */
	private String name;
	/**
	 *手机号
	 */
	private String mobile;
	/**
	 *是否默认收货地址(0否/1是  默认0)
	 */
	private Integer isDefault;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCompleteAddress() {
		return completeAddress;
	}

	public void setCompleteAddress(String completeAddress) {
		this.completeAddress = completeAddress;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}

	@Override
	public String toString() {
		return "ShopShippingAddress{" +
				"id='" + id + '\'' +
				", province='" + province + '\'' +
				", city='" + city + '\'' +
				", area='" + area + '\'' +
				", completeAddress='" + completeAddress + '\'' +
				", postcode='" + postcode + '\'' +
				", name='" + name + '\'' +
				", mobile='" + mobile + '\'' +
				", isDefault=" + isDefault +
				'}';
	}
}