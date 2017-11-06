$(document).ready(function(){
	$("#submitPay").click(doPayingIntegration);
});
function doPayingIntegration(){
	var orderId=getUrlParam("orderId");
	var payPassword=$("input:password").val();
	//console.log(payPassword);
	var url=$.cookie("domain")+'shop/order/pay';
	var param={
		"orderId":orderId,
		"payPassword":payPassword
	};
	$.post(url,param,function(result){
		//to_do
		if(result.status!=1){
			mui.alert(result.msg);
			return;
		}
		mui.alert("支付成功");
		window.location = 'index.html';
	});
}
//获取url中的参数
function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg); //匹配目标参数
	if(r != null) return unescape(r[2]);
	return null; //返回参数值
}