/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package cn.yearcon.shop.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 基础设置Entity
 * @author itguang
 * @version 2017-10-20
 */
@Entity//要使用spring data jpa 要在实体类上加上此注解
public class ShopConfig implements Serializable {

	@Id
	private String id;
	/**
	 *网站标题
	 */
	private String title;
	/**
	 *公众号appid
	 */
	private String appid;
	/**
	 *公众号secret
	 */
	private String secret;
	/**
	 *会员中心地址
	 */
	private String vipCenterUrl;
	/**
	 *我要咨询地址
	 */
	private String consultUrl;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getVipCenterUrl() {
		return vipCenterUrl;
	}

	public void setVipCenterUrl(String vipCenterUrl) {
		this.vipCenterUrl = vipCenterUrl;
	}

	public String getConsultUrl() {
		return consultUrl;
	}

	public void setConsultUrl(String consultUrl) {
		this.consultUrl = consultUrl;
	}

	@Override
	public String toString() {
		return "ShopConfig{" +
				"id='" + id + '\'' +
				", title='" + title + '\'' +
				", appid='" + appid + '\'' +
				", secret='" + secret + '\'' +
				", vipCenterUrl='" + vipCenterUrl + '\'' +
				", consultUrl='" + consultUrl + '\'' +
				'}';
	}
}