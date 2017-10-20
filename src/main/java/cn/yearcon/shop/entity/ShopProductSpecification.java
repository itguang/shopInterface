/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package cn.yearcon.shop.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 商品信息Entity
 * @author itguang
 * @version 2017-10-20
 */
@Entity//要使用spring data jpa 要在实体类上加上此注解
public class ShopProductSpecification{
	/**
	 * 商品规格id
	 */
	@Id
	private String id;
	/**
	 *  商品外键
	 */
	private String productId;
	/**
	 * 产品规格名称
	 */
	private String name;
	/**
	 *颜色名称
	 */
	private String colorName;
	/**
	 * 库存
	 */
	private Integer inventory;
	/**
	 * 所需积分
	 */
	private Integer needIntegration;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public Integer getInventory() {
		return inventory;
	}

	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}

	public Integer getNeedIntegration() {
		return needIntegration;
	}

	public void setNeedIntegration(Integer needIntegration) {
		this.needIntegration = needIntegration;
	}

	@Override
	public String toString() {
		return "ShopProductSpecification{" +
				"id='" + id + '\'' +
				", productId='" + productId + '\'' +
				", name='" + name + '\'' +
				", colorName='" + colorName + '\'' +
				", inventory=" + inventory +
				", needIntegration=" + needIntegration +
				'}';
	}
}