$(document).ready(function(){
	setPageInfo();//设置页面信息
	//console.log(productId);
	$("#submitOrder").click(postOrderInfo);
	$("#editAddress").click(skipToEditAddress);
});
function skipToEditAddress(){
	window.location.href="address.html";
}
//提交订单信息
function postOrderInfo(){
	//获取提交信息
	var addressId=$.cookie("addressId");
	var productId=getUrlParam("productId");//产品id	
	var productSpecificationsId=getUrlParam("productSpecificationsId");//产品规格id
	var count=getUrlParam("count");//购买数量
	var invoiceRequest=$("input:radio[name='fapiao']:checked").val();//发票要求
	var remarkBuyer=$("#remarkBuyer").val();//卖家留言
	var invoiceTitle=$("#invoiceTitle").val();//发票抬头
	
	//mui.alert(invoiceTitle);
	var formData={
		"productId":productId,
		"productSpecificationId":productSpecificationsId,
		"productAmount":count,
		"invoiceRequest":invoiceRequest,
		"remarkBuyer":remarkBuyer,
		"invoiceTitle":invoiceTitle,
		"addressId":addressId
	};//提交数据
	var url=$.cookie("domain")+'shop/order/save-order';//提交地址
	$.post(url,formData,function(result){
		if(result.status){
			var orderId=result.data.orderId;
			window.location.href='zhifu.html?orderId='+orderId;
		}else{
			mui.alert(result.msg);
		}
	});
}
function setPageInfo(){
	//获取上个页面参数
	var productId=getUrlParam("productId");
	var productSpecificationsId=getUrlParam("productSpecificationsId");
	var count=getUrlParam("count");
	var needIntegration=$.cookie("needIntegration");
	$("#count").html(count);
	$("#pictureUrlDefault").attr("src",$.cookie("pictureUrlDefault"));
	$("#nameAndDescription").html($.cookie("nameAndDescription"));
	$("#colorAndSize").html("颜色:"+$.cookie("color")+" 尺寸:"+$.cookie("size"));
	$("#needIntegration").html(needIntegration+"积分");
	$("#productInfo").attr("href","detail.html?productId="+productId);
	$("#counts").html(count);
	$("#sumIntegration").html(count*needIntegration);
	doGetAddressInfo();//获取客户所有的地址信息
}
//获取客户所有的地址信息
function doGetAddressInfo(){
	//获取从cookie里获取openId
	var openid=$.cookie("openid");
//	var openid='123';
	var url=$.cookie("domain")+"shop/address/"+openid;
	$.get(url,function(result){
		if(result.status){
			var addressList=result.data;
			setDefaultAddressInfo(addressList);//设置默认地址信息
		}else{
			mui.alert(result.msg);
		}
	});
}
//设置默认地址
function setDefaultAddressInfo(list){
	var receiveName;
	var mobile;
	var defaultAddress;
	for(var i in list){
		if(list[i].isDefault){
			receiveName=list[i].name;
			mobile=list[i].mobile;
			defaultAddress=list[i].province+list[i].city+list[i].area+list[i].completeAddress;
			$.cookie("addressId",list[i].id);
			break;
		}
	}
	$("#receiveName").html(receiveName);
	$("#mobile").html(mobile);
	$("#defaultAddress").html(defaultAddress);
}
//移除cookie
/*function removeCookie(){
	$.cookie("pictureUrlDefault",null);
}*/
//获取url中的参数
function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg); //匹配目标参数
	if(r != null) return unescape(r[2]);
	return null; //返回参数值
}