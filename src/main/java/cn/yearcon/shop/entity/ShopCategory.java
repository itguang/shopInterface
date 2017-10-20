/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package cn.yearcon.shop.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 商品分类Entity
 * @author itguang
 * @version 2017-10-20
 */
@Entity//要使用spring data jpa 要在实体类上加上此注解
public class ShopCategory {
	/**
	 * 商品分类id
	 */
	@Id
	private  String id;
	/**
	 * 分类名称
	 */
	private String categoryName;
	/**
	 *分类图片
	 */
	private String categoryPictureUrl;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryPictureUrl() {
		return categoryPictureUrl;
	}

	public void setCategoryPictureUrl(String categoryPictureUrl) {
		this.categoryPictureUrl = categoryPictureUrl;
	}

	@Override
	public String toString() {
		return "ShopCategory{" +
				"id='" + id + '\'' +
				", categoryName='" + categoryName + '\'' +
				", categoryPictureUrl='" + categoryPictureUrl + '\'' +
				'}';
	}
}