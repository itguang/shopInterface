/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package cn.yearcon.shop.mapper;


import cn.yearcon.shop.entity.ShopOrder;
import cn.yearcon.shop.mapper.common.CrudDao;
import cn.yearcon.shop.utils.ShopResult;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 订单DAO接口
 * @author itguang
 * @version 2017-10-20
 */
public interface ShopOrderMapper extends CrudDao<ShopOrder> {

    /**
     * 查找未付款订单
     * @param CustomerId
     * @return
     */
    @Select("SELECT\n" +
            "\ta.id AS 'id',\n" +
            "\t\ta.order_number AS 'orderNumber',\n" +
            "\t\ta.way_cost AS 'wayCost',\n" +
            "\t\ta.waybill_number AS 'waybillNumber',\n" +
            "\t\ta.transaction_no AS 'transactionNo',\n" +
            "\t\ta.remark_seller AS 'remarkSeller',\n" +
            "\t\ta.customer_id AS 'customerId',\n" +
            "\t\ta.product_id AS 'productId',\n" +
            "\t\ta.product_specification_id AS 'productSpecificationId',\n" +
            "\t\ta.product_code AS 'productCode',\n" +
            "\t\ta.product_name AS 'productName',\n" +
            "\t\ta.product_simplename AS 'productSimplename',\n" +
            "\t\ta.product_amount AS 'productAmount',\n" +
            "\t\ta.price AS 'price',\n" +
            "\t\ta.sales_attribute AS 'salesAttribute',\n" +
            "\t\ta.consignee AS 'consignee',\n" +
            "\t\ta.consignee_mobile AS 'consigneeMobile ',\n" +
            "\t\ta.consignee_call AS 'consigneeCall',\n" +
            "\t\ta.amount_payable AS 'amountPayable',\n" +
            "\t\ta.amount_paid AS 'amountPaid',\n" +
            "\t\ta.invoice_title AS 'invoiceTitle',\n" +
            "\t\ta.invoice_request AS 'invoiceRequest',\n" +
            "\t\ta.delivery_type AS 'deliveryType',\n" +
            "\t\ta.pay_status AS 'payStatus',\n" +
            "\t\ta.remark_buyer AS 'remarkBuyer',\n" +
            "\t\ta.add_time AS 'addTime',\n" +
            "\t\ta.pay_time AS 'payTime',\n" +
            "\t\ta.province AS 'province',\n" +
            "\t\ta.city AS 'city',\n" +
            "\t\ta.area AS 'area',\n" +
            "\t\ta.shopping_address_id AS 'shoppingAddressId',\n" +
            "\t\ta.consignee_code AS 'consigneeCode',\n" +
            "\t\ta.delivery_status AS 'deliveryStatus'\n" +
            "FROM\n" +
            "\tshop_order a\n" +
            "WHERE\n" +
            "\ta.customer_id = #{CustomerId}\n" +
            "AND a.pay_status = 0;")
    List<ShopOrder> queryNoPayOrderListByCustomerId(String CustomerId);


    /**
     * 查找已付款订单
     * @param CustomerId
     * @return
     */
    @Select("SELECT\n" +
            "\ta.id AS 'id',\n" +
            "\t\ta.order_number AS 'orderNumber',\n" +
            "\t\ta.way_cost AS 'wayCost',\n" +
            "\t\ta.waybill_number AS 'waybillNumber',\n" +
            "\t\ta.transaction_no AS 'transactionNo',\n" +
            "\t\ta.remark_seller AS 'remarkSeller',\n" +
            "\t\ta.customer_id AS 'customerId',\n" +
            "\t\ta.product_id AS 'productId',\n" +
            "\t\ta.product_specification_id AS 'productSpecificationId',\n" +
            "\t\ta.product_code AS 'productCode',\n" +
            "\t\ta.product_name AS 'productName',\n" +
            "\t\ta.product_simplename AS 'productSimplename',\n" +
            "\t\ta.product_amount AS 'productAmount',\n" +
            "\t\ta.price AS 'price',\n" +
            "\t\ta.sales_attribute AS 'salesAttribute',\n" +
            "\t\ta.consignee AS 'consignee',\n" +
            "\t\ta.consignee_mobile AS 'consigneeMobile ',\n" +
            "\t\ta.consignee_call AS 'consigneeCall',\n" +
            "\t\ta.amount_payable AS 'amountPayable',\n" +
            "\t\ta.amount_paid AS 'amountPaid',\n" +
            "\t\ta.invoice_title AS 'invoiceTitle',\n" +
            "\t\ta.invoice_request AS 'invoiceRequest',\n" +
            "\t\ta.delivery_type AS 'deliveryType',\n" +
            "\t\ta.pay_status AS 'payStatus',\n" +
            "\t\ta.remark_buyer AS 'remarkBuyer',\n" +
            "\t\ta.add_time AS 'addTime',\n" +
            "\t\ta.pay_time AS 'payTime',\n" +
            "\t\ta.province AS 'province',\n" +
            "\t\ta.city AS 'city',\n" +
            "\t\ta.area AS 'area',\n" +
            "\t\ta.shopping_address_id AS 'shoppingAddressId',\n" +
            "\t\ta.consignee_code AS 'consigneeCode',\n" +
            "\t\ta.delivery_status AS 'deliveryStatus'\n" +
            "FROM\n" +
            "\tshop_order a\n" +
            "WHERE\n" +
            "\ta.customer_id = #{CustomerId}\n" +
            "AND a.pay_status = 1;")
    List<ShopOrder> queryPaidOrderListByCustomerId(String CustomerId);

    /**
     * 查找最近一笔订单的快递信息
     * @param customerId
     * @return
     */
    @Select("SELECT\n" +
            "\ta.courier_company AS courierCompany,\n" +
            "\ta.courier_number AS courierNumber\n" +
            "FROM\n" +
            "\tshop_order a\n" +
            "WHERE\n" +
            "\tpay_status = 1\n" +
            "AND customer_id = #{customerId}\n" +
            "ORDER BY\n" +
            "\tpay_time DESC\n" +
            "LIMIT 1;")
    ShopOrder queryLastOrderByCustomerId(String customerId);






	
}