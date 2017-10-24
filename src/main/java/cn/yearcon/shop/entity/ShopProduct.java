/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package cn.yearcon.shop.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 商品信息Entity
 * @author itguang
 * @version 2017-10-20
 */
@Entity//要使用spring data jpa 要在实体类上加上此注解
public class ShopProduct{
	/**
	 * 商品id
	 */
	@Id
	private String id;
	

	/**
	 *产品货号
	 */
	private String productNo;
	/**
	 * 品牌
	 */
	private String brand;
	/**
	 *产品名称
	 */
	private String name;
	/**
	 * 上市年份
	 */
	private String marketDate;
	/**
	 * 分类表id
	 */
	private String categoryId;
	/**
	 * 访问量
	 */
	private Integer visits;
	/**
	 *产品分类
	 */
	private String productType;
	/**
	 * 场合
	 */
	private String occasion;
	/**
	 *款式
	 */
	private String size;
	/**
	 *风格
	 */
	private String style;
	/**
	 *功能
	 */
	private String function;
	/**
	 *适用对象
	 */
	private String target;
	/**
	 *鞋面内里材质
	 */
	private String vampTexture;
	/**
	 *低帮鞋品名
	 */
	private String lowShoesName;
	/**
	 *鞋垫材质
	 */
	private String insoleTexture;
	/**
	 *排序值
	 */
	private Integer sortNo;
	/**
	 *关键词
	 */
	private String keyword;
	/**
	 *产品摘要
	 */
	private String summary;
	/**
	 *上架数量
	 */
	private Integer stores;
	/**
	 *零售价
	 */
	private Integer price;
	/**
	 *产品积分
	 */
	private Integer points;
	/**
	 *产品描述
	 */
	private String description;
	/**
	 *产品详情
	 */
	private String details;
	/**
	 *销量
	 */
	private Integer sales;
	/**
	 *产品剩余
	 */
	private Integer residue;
	/**
	 *是否新品(0否/1是  默认0)
	 */
	private Integer isNew;
	/**
	 *是否热门(0否/1是 默认为0)
	 */
	private Integer isHot;
	/**
	 *上下架状态(0否/1是 默认1)
	 */

	private Integer isAlive;
	/**
	 *产品图片/轮播图1
	 */
	private String pictureUrlDefault;
	/**
	 * 轮播图2
	 */
	private String pictureUrl2;
	/**
	 *轮播图3
	 */
	private String pictureUrl3;
	/**
	 *轮播图4
	 */
	private String pictureUrl4;
	/**
	 *轮播图5
	 */
	private String pictureUrl5;
	/**
	 *轮播图6
	 */
	private String pictureUrl6;
	/**
	 *添加日期
	 */
	private Date addTime;
	/**
	 *开始 产品积分
	 */
	private Integer beginPoints;
	/**
	 *结束 产品积分
	 */
	private Integer endPoints;

	/**
	 * 开始索引
	 */
	private  int startIndex;

	/**
	 * 页大小
	 */
	private int pageSize;

	/**
	 * 当前页数
	 */
	private int pagenum;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMarketDate() {
		return marketDate;
	}

	public void setMarketDate(String marketDate) {
		this.marketDate = marketDate;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getVisits() {
		return visits;
	}

	public void setVisits(Integer visits) {
		this.visits = visits;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getOccasion() {
		return occasion;
	}

	public void setOccasion(String occasion) {
		this.occasion = occasion;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getVampTexture() {
		return vampTexture;
	}

	public void setVampTexture(String vampTexture) {
		this.vampTexture = vampTexture;
	}

	public String getLowShoesName() {
		return lowShoesName;
	}

	public void setLowShoesName(String lowShoesName) {
		this.lowShoesName = lowShoesName;
	}

	public String getInsoleTexture() {
		return insoleTexture;
	}

	public void setInsoleTexture(String insoleTexture) {
		this.insoleTexture = insoleTexture;
	}

	public Integer getSortNo() {
		return sortNo;
	}

	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Integer getStores() {
		return stores;
	}

	public void setStores(Integer stores) {
		this.stores = stores;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Integer getSales() {
		return sales;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}

	public Integer getResidue() {
		return residue;
	}

	public void setResidue(Integer residue) {
		this.residue = residue;
	}

	public Integer getIsNew() {
		return isNew;
	}

	public void setIsNew(Integer isNew) {
		this.isNew = isNew;
	}

	public Integer getIsHot() {
		return isHot;
	}

	public void setIsHot(Integer isHot) {
		this.isHot = isHot;
	}

	public Integer getIsAlive() {
		return isAlive;
	}

	public void setIsAlive(Integer isAlive) {
		this.isAlive = isAlive;
	}

	public String getPictureUrlDefault() {
		return pictureUrlDefault;
	}

	public void setPictureUrlDefault(String pictureUrlDefault) {
		this.pictureUrlDefault = pictureUrlDefault;
	}

	public String getPictureUrl2() {
		return pictureUrl2;
	}

	public void setPictureUrl2(String pictureUrl2) {
		this.pictureUrl2 = pictureUrl2;
	}

	public String getPictureUrl3() {
		return pictureUrl3;
	}

	public void setPictureUrl3(String pictureUrl3) {
		this.pictureUrl3 = pictureUrl3;
	}

	public String getPictureUrl4() {
		return pictureUrl4;
	}

	public void setPictureUrl4(String pictureUrl4) {
		this.pictureUrl4 = pictureUrl4;
	}

	public String getPictureUrl5() {
		return pictureUrl5;
	}

	public void setPictureUrl5(String pictureUrl5) {
		this.pictureUrl5 = pictureUrl5;
	}

	public String getPictureUrl6() {
		return pictureUrl6;
	}

	public void setPictureUrl6(String pictureUrl6) {
		this.pictureUrl6 = pictureUrl6;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Integer getBeginPoints() {
		return beginPoints;
	}

	public void setBeginPoints(Integer beginPoints) {
		this.beginPoints = beginPoints;
	}

	public Integer getEndPoints() {
		return endPoints;
	}

	public void setEndPoints(Integer endPoints) {
		this.endPoints = endPoints;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPagenum() {
		return pagenum;
	}

	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}

	@Override
	public String toString() {
		return "ShopProduct{" +
				"id='" + id + '\'' +
				", productNo='" + productNo + '\'' +
				", brand='" + brand + '\'' +
				", name='" + name + '\'' +
				", marketDate='" + marketDate + '\'' +
				", categoryId='" + categoryId + '\'' +
				", visits=" + visits +
				", productType='" + productType + '\'' +
				", occasion='" + occasion + '\'' +
				", size='" + size + '\'' +
				", style='" + style + '\'' +
				", function='" + function + '\'' +
				", target='" + target + '\'' +
				", vampTexture='" + vampTexture + '\'' +
				", lowShoesName='" + lowShoesName + '\'' +
				", insoleTexture='" + insoleTexture + '\'' +
				", sortNo=" + sortNo +
				", keyword='" + keyword + '\'' +
				", summary='" + summary + '\'' +
				", stores=" + stores +
				", price=" + price +
				", points=" + points +
				", description='" + description + '\'' +
				", details='" + details + '\'' +
				", sales=" + sales +
				", residue=" + residue +
				", isNew=" + isNew +
				", isHot=" + isHot +
				", isAlive=" + isAlive +
				", pictureUrlDefault='" + pictureUrlDefault + '\'' +
				", pictureUrl2='" + pictureUrl2 + '\'' +
				", pictureUrl3='" + pictureUrl3 + '\'' +
				", pictureUrl4='" + pictureUrl4 + '\'' +
				", pictureUrl5='" + pictureUrl5 + '\'' +
				", pictureUrl6='" + pictureUrl6 + '\'' +
				", addTime=" + addTime +
				", beginPoints=" + beginPoints +
				", endPoints=" + endPoints +
				'}';
	}
}