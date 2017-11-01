/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package cn.yearcon.shop.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;


/**
 * 订单Entity
 * @author itguang
 * @version 2017-10-20
 */
@Entity//要使用spring data jpa 要在实体类上加上此注解
public class ShopOrder implements Serializable {
	/**
	 * 订单id
	 */
	@Id
	private String id;
	/**
	 *订单号
	 */
	private String orderNumber;
	/**
	 *运费
	 */
	private Double wayCost;
	/**
	 *运单号
	 */
	private String waybillNumber;
	/**
	 *交易号
	 */
	private String transactionNo;
	/**
	 *卖家备注
	 */
	private String remarkSeller;
	/**
	 *顾客id
	 */
	private String customerId;
	/**
	 *产品id
	 */
	private String productId;
	/**
	 * 产品规格id
	 */
	private String productSpecificationId;
	/**
	 *商品编码
	 */
	private String productCode;
	/**
	 *商品名称
	 */
	private String productName;
	/**
	 *商品简称
	 */
	private String productSimplename;
	/**
	 *商品数量
	 */
	private Integer productAmount;
	/**
	 *单价
	 */
	private Double price;
	/**
	 *销售属性
	 */
	private String salesAttribute;
	/**
	 *收货人姓名
	 */
	private String consignee;
	/**
	 *收件人手机
	 */
	private String consigneeMobile;
	/**
	 *收件人电话
	 */
	private String consigneeCall;
	/**
	 *应付积分
	 */
	private Integer amountPayable;
	/**
	 *实付积分
	 */
	private Integer amountPaid;
	/**
	 *发票抬头
	 */
	private String invoiceTitle;
	/**
	 *发票要求
	 */
	private String invoiceRequest;
	/**
	 *配送方式
	 */
	private String deliveryType;
	/**
	 *支付状态(0未支付/1已支付,默认为0)
	 */
	private Integer payStatus;
	/**
	 *买家留言
	 */
	private String remarkBuyer;
	/**
	 *下单时间
	 */
	private Date addTime;
	/**
	 *付款时间
	 */
	private Date payTime;
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
	 *收获人详细地址
	 */
	private String shoppingAddressId;
	/**
	 *收货人邮政编码
	 */
	private String consigneeCode;
	/**
	 *  物流状态(1未发货,2已发货,3确认收货  默认1)
	 */
	private Integer deliveryStatus;

	/**
	 *快递公司
	 *
	 */
	private String courierCompany;

	/**
	 *快递单号
	 */
	private String courierNumber;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Double getWayCost() {
		return wayCost;
	}

	public void setWayCost(Double wayCost) {
		this.wayCost = wayCost;
	}

	public String getWaybillNumber() {
		return waybillNumber;
	}

	public void setWaybillNumber(String waybillNumber) {
		this.waybillNumber = waybillNumber;
	}

	public String getTransactionNo() {
		return transactionNo;
	}

	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}

	public String getRemarkSeller() {
		return remarkSeller;
	}

	public void setRemarkSeller(String remarkSeller) {
		this.remarkSeller = remarkSeller;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductSpecificationId() {
		return productSpecificationId;
	}

	public void setProductSpecificationId(String productSpecificationId) {
		this.productSpecificationId = productSpecificationId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductSimplename() {
		return productSimplename;
	}

	public void setProductSimplename(String productSimplename) {
		this.productSimplename = productSimplename;
	}

	public Integer getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(Integer productAmount) {
		this.productAmount = productAmount;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getSalesAttribute() {
		return salesAttribute;
	}

	public void setSalesAttribute(String salesAttribute) {
		this.salesAttribute = salesAttribute;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getConsigneeMobile() {
		return consigneeMobile;
	}

	public void setConsigneeMobile(String consigneeMobile) {
		this.consigneeMobile = consigneeMobile;
	}

	public String getConsigneeCall() {
		return consigneeCall;
	}

	public void setConsigneeCall(String consigneeCall) {
		this.consigneeCall = consigneeCall;
	}

	public Integer getAmountPayable() {
		return amountPayable;
	}

	public void setAmountPayable(Integer amountPayable) {
		this.amountPayable = amountPayable;
	}

	public Integer getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(Integer amountPaid) {
		this.amountPaid = amountPaid;
	}

	public String getInvoiceTitle() {
		return invoiceTitle;
	}

	public void setInvoiceTitle(String invoiceTitle) {
		this.invoiceTitle = invoiceTitle;
	}

	public String getInvoiceRequest() {
		return invoiceRequest;
	}

	public void setInvoiceRequest(String invoiceRequest) {
		this.invoiceRequest = invoiceRequest;
	}

	public String getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}

	public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public String getRemarkBuyer() {
		return remarkBuyer;
	}

	public void setRemarkBuyer(String remarkBuyer) {
		this.remarkBuyer = remarkBuyer;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
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

	public String getShoppingAddressId() {
		return shoppingAddressId;
	}

	public void setShoppingAddressId(String shoppingAddressId) {
		this.shoppingAddressId = shoppingAddressId;
	}

	public String getConsigneeCode() {
		return consigneeCode;
	}

	public void setConsigneeCode(String consigneeCode) {
		this.consigneeCode = consigneeCode;
	}

	public Integer getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(Integer deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public String getCourierCompany() {
		return courierCompany;
	}

	public void setCourierCompany(String courierCompany) {
		this.courierCompany = courierCompany;
	}

	public String getCourierNumber() {
		return courierNumber;
	}

	public void setCourierNumber(String courierNumber) {
		this.courierNumber = courierNumber;
	}

	@Override
	public String toString() {
		return "ShopOrder{" +
				"id='" + id + '\'' +
				", orderNumber='" + orderNumber + '\'' +
				", wayCost=" + wayCost +
				", waybillNumber='" + waybillNumber + '\'' +
				", transactionNo='" + transactionNo + '\'' +
				", remarkSeller='" + remarkSeller + '\'' +
				", customerId='" + customerId + '\'' +
				", productId='" + productId + '\'' +
				", productSpecificationId='" + productSpecificationId + '\'' +
				", productCode='" + productCode + '\'' +
				", productName='" + productName + '\'' +
				", productSimplename='" + productSimplename + '\'' +
				", productAmount=" + productAmount +
				", price=" + price +
				", salesAttribute='" + salesAttribute + '\'' +
				", consignee='" + consignee + '\'' +
				", consigneeMobile='" + consigneeMobile + '\'' +
				", consigneeCall='" + consigneeCall + '\'' +
				", amountPayable=" + amountPayable +
				", amountPaid=" + amountPaid +
				", invoiceTitle='" + invoiceTitle + '\'' +
				", invoiceRequest='" + invoiceRequest + '\'' +
				", deliveryType='" + deliveryType + '\'' +
				", payStatus=" + payStatus +
				", remarkBuyer='" + remarkBuyer + '\'' +
				", addTime=" + addTime +
				", payTime=" + payTime +
				", province='" + province + '\'' +
				", city='" + city + '\'' +
				", area='" + area + '\'' +
				", shoppingAddressId='" + shoppingAddressId + '\'' +
				", consigneeCode='" + consigneeCode + '\'' +
				", deliveryStatus=" + deliveryStatus +
				", courierCompany='" + courierCompany + '\'' +
				", courierNumber='" + courierNumber + '\'' +
				'}';
	}
}