package cn.yearcon.shop.pojo;

/**
 * 接收订单页面提交的数据
 *
 * @author itguang
 * @create 2017-10-23 11:14
 **/
public class OrderBean {
    /**
     * 收货人地址id
     */
    private String addressId;
    /**
     * 产品id
     */
    private String productId;
    /**
     * 产品规格id
     */
    private  String productSpecificationId;
    /**
     * 产品数量
     */
    private Integer productAmount;
    /**
     * 发票要求
     */
    private String invoiceRequest;
    /**
     * 买家留言
     */
    private String remarkBuyer;
    /**
     * 发票抬头
     */
    private String invoiceTitle;

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
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

    public Integer getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(Integer productAmount) {
        this.productAmount = productAmount;
    }

    public String getInvoiceRequest() {
        return invoiceRequest;
    }

    public void setInvoiceRequest(String invoiceRequest) {
        this.invoiceRequest = invoiceRequest;
    }

    public String getRemarkBuyer() {
        return remarkBuyer;
    }

    public void setRemarkBuyer(String remarkBuyer) {
        this.remarkBuyer = remarkBuyer;
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
    }

    @Override
    public String toString() {
        return "OrderBean{" +
                "addressId='" + addressId + '\'' +
                ", productId='" + productId + '\'' +
                ", productSpecificationId='" + productSpecificationId + '\'' +
                ", productAmount=" + productAmount +
                ", invoiceRequest='" + invoiceRequest + '\'' +
                ", remarkBuyer='" + remarkBuyer + '\'' +
                ", invoiceTitle='" + invoiceTitle + '\'' +
                '}';
    }
}
