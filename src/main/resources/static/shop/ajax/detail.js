$(document).ready(function() {
	$("#ask").click(function() {
				var btnArray = ['否', '是'];
				mui.confirm('离开本页面前往公众号？', '我要咨询', btnArray, function(e) {
					if(e.index == 1) {
						WeixinJSBridge.invoke('closeWindow', {}, function(res) {});

					} else {}
				})
			});
	doGetProductInfo(getUrlParam('productId'));//获取产品信息
	doGetProductSpecifications(getUrlParam('productId'))//获取产品规格
	$("#submitId").click(doSubmitOrder);//提交订单
});
var psList;//商品规格集合
//获取商品规格
function doGetProductSpecifications(id){
	var url=$.cookie('domain')+'shop/product-specification/'+id;
	$.get(url,function(result){
		if(result.status){
			//console.log(result.data);
			psList=result.data;
			setColorAndSize(result.data);//设置颜色和大小
			selectColorAndSize(result.data);//选择颜色和大小
			selectProductAmount(result.data);//选择商品数量
			
		}else{
			mui.alert(result.msg);
		}
	});
}
//根据颜色和大小获取规格id
function getProductSpecificationsId(color,size){
	var productSpecificationsId;
	for(var i in psList){
		if(psList[i].color==color&&psList[i].name==size){
			productSpecificationsId=psList[i].id;
			break;
		}
	}
	return productSpecificationsId;
}
//提交订单
function doSubmitOrder(){
	var colorStr=$("#colorId .cur").html();
	var sizeStr=$("#sizeId .cur").html();
	var count=$("#count").html();
	var inventory=$("#inventory").html();
	var productId=getUrlParam('productId');
	var needIntegration=$("#needIntegration").html();
	if(!(colorStr&&sizeStr)){
		mui.alert("选择规格");
	}else{
		/*console.log(inventory);
		console.log(count);*/
		if(parseInt(count)>parseInt(inventory)){
			//console.log(count>inventory);
			mui.alert("库存不够:购买数量="+count+"库存="+inventory);
		}else{
			var productSpecificationsId=getProductSpecificationsId(colorStr,sizeStr);
			//console.log(productSpecificationsId);
			submitOrder(productId,productSpecificationsId,count);//提交数据
			needIntegration=needIntegration/count;//获得单件积分
			$.cookie("color",colorStr);$.cookie("size",sizeStr);//把颜色和尺寸存在cookie里
			$.cookie("needIntegration",needIntegration);//把积分存在cookie里
		}
	}
}
function submitOrder(productId,productSpecificationsId,count){
	/*var list={
		"prodcutId":prodcutId,
		"productSpecificationsId":productSpecificationsId,
		"count":count
	};*/
	window.location.href = "confirm.html?productId="+productId+"&productSpecificationsId="+
									productSpecificationsId+"&count="+count;

}
//选择商品数量
function selectProductAmount(list){
	var down = document.getElementById("down");
	var count = document.getElementById("count");
	var up=document.getElementById("up");
		down.onclick = function() {
			if(count.innerHTML > 1) {
				count.innerHTML--;	
			} else {
				count.innerHTML = 1;
			}
			$("#needIntegration").html(getTotal(list));
		}
		up.onclick=function(){
			count.innerHTML++;
			$("#needIntegration").html(getTotal(list));
		}		
		
}
function getTotal(list){
	var needIntegration=setIntegration(list);
	var total=needIntegration*$("#count").html();
	if(total)
	return total;
}
//选择颜色和规格
function selectColorAndSize(list){
		$(".middle .xia li").click(function() {
			$(this).addClass('cur').siblings().removeClass('cur');
			setIntegration(list);
			//var sumIntegration=result.needIntegration*count.innerHTML;
			//$("#needIntegration").html(sumIntegration+"积分 (库存"+result.inventory+")");
	});
	
}

//设置积分并获取积分
function setIntegration(list){
	var colorStr=$("#colorId .cur").html();
	var sizeStr=$("#sizeId .cur").html();
	//console.log(colorStr+","+sizeStr);
	var needIntegration;//所需积分
	var inventory;//库存
	if(colorStr&&sizeStr){
		for(var i in list){
			if(list[i].color==colorStr&&list[i].name==sizeStr){
				needIntegration=list[i].needIntegration;
				inventory=list[i].inventory;
				break;
			}else{
				inventory=0;
				needIntegration=0;
			}
		}
		$("#needIntegration").html(needIntegration);
		$("#inventory").html(inventory);
	}
	//var result={'needIntegration':needIntegration,'inventory':inventory};
	return needIntegration;
}
//设置颜色和尺寸
function setColorAndSize(list){
	//console.log("setColor()="+list);
	var colorList=new Array();
	var sizeList=new Array();
	var integrationList=new Array();
	for(var i in list){
		colorList.push(list[i].color);
		sizeList.push(list[i].name);
		integrationList.push(list[i].needIntegration);
	}
	$.unique(colorList);
	$.unique(sizeList);
	setColor(colorList);
	setSize(sizeList);
	var maxIntegration=Math.max.apply(Math,integrationList);
	var minIntegration=Math.min.apply(Math,integrationList);
	//console.log(maxIntegration+","+minIntegration);
	$("#needIntegration").html(minIntegration+"~"+maxIntegration);
}
//设置尺寸
function setSize(list){
	var sizeul=$("#sizeId");
	sizeul.empty();
	for(var i in list){
		var liStr='<li class="ra3">color</li>';
		liStr=liStr.replace('color',list[i]);
		sizeul.append(liStr);
	}
	
}
//设置颜色
function setColor(list){
	var colorul=$("#colorId");
	colorul.empty();
	for(var i in list){
		var liStr='<li class="ra3">color</li>';
		liStr=liStr.replace('color',list[i]);
		colorul.append(liStr);
	}
	
}
//获取商品信息
function doGetProductInfo(id) {
	var url = $.cookie('domain') + 'shop/product/' + id;
	$.get(url, function(result) {
		if(result.status) {
			setProductPage(result.data);
			//console.log(result.data);
		} else {
			mui.alert(result.msg);
		}
	});
}
//给页面赋值
function setProductPage(obj) {
	var list = [obj.pictureUrlDefault, obj.pictureUrl2,
		obj.pictureUrl3, obj.pictureUrl4,
		obj.pictureUrl5, obj.pictureUrl6
	];
	setImageSwiper(list); //设置图片轮播
	$(".title").html(obj.name + " :" + obj.description);
	$("#points").html(obj.points);
	var detail = obj.details;
//	detail = $(detail).replaceAll("<");
//	detail=detail.replace('&lt;',"<").replaceAll('&gt;','>').replaceAll('&quot;','"');
	var str=$("#rich_details").html(detail).text();
	//console.log(str);
	$("#rich_details").html(str);
	
	setProductAttrLayer(obj); //設置商品屬性彈出框
	$("#imgId").attr('src',obj.pictureUrlDefault);
	$(".tit").html(obj.name);
	
	$.cookie("pictureUrlDefault",obj.pictureUrlDefault);//图片存在cookie里
	$.cookie("nameAndDescription",obj.name+","+obj.description);//cookie里存姓名和描述
}
//设置商品属性弹出框
function setProductAttrLayer(obj) {
	$("#openbox").click(function(e) {
		e.preventDefault();
		var html = [
			'   <dl class=\"detail-list clearfix\">',

			' <dd><span>商品编号：</span><span>' + obj.productNo + '</span></dd>',
			'   </dl>',
			'   <dl class=\"detail-list clearfix\">',

			'  <dd><span>商品分类：</span><span>' + obj.productType + '</span></dd>',
			'   </dl>',
			'   <dl class=\"detail-list clearfix\">',

			'   <dd><span>品牌：</span><span>' + obj.brand + '</span></dd>',
			'   </dl>',
			'   <dl class=\"detail-list clearfix\">',

			'  <dd><span>上市年份：' + obj.marketDate + '</span></dd>',
			'   </dl>',
			'   <dl class=\"detail-list clearfix\">',
			'   <dd><span>适用對象：' + obj.target + '</span></dd>',

			'   </dl>',

			'   <dl class=\"detail-list clearfix\">',

			'  <dd><span>材质：</span><span>' + obj.vampTexture + '</span></dd>',
			'   </dl>',

			'   <dl class=\"detail-list clearfix\">',
			'   <dt><span>是否新品：</span><span>' + (obj.isNew ? "是" : "否") + '</span></dt>',

			'   </dl>',
			'   <dl class=\"detail-list clearfix\">',

			'  <dd><span>功能: ' + obj.function+'</span></dd>',
			'   </dl>'

		].join("");
		layer.open({
			title: [
				'商品属性',
				'background-color:#03A9F4; color:#fff;'
			],
			anim: 'up',
			content: html,
			btn: ['关闭']
		});
	});
}
//设置图片轮播
function setImageSwiper(list) {

	var indexImages = $(".swiper-wrapper");
	indexImages.empty();
	for(var i in list) {
		if(list[i].pictureUrl == '#') {
			continue;
		}
		var indexImage = '<div class="swiper-slide" >' +
			'<a href="javascript:void(0)">' +
			'<img class="swiper-lazy" src="#" alt=""></a></div>';
		//indexImage=indexImage.replace('count',i);
		indexImage = indexImage.replace('#', list[i]);
		indexImages.append(indexImage);
	}
	setSwiper();
}
//初始化Swiper
function setSwiper() {
	var banner = new Swiper('.banner', {
		autoplay: 5000,
		paginationClickable: true,
		lazyLoading: true,
		loop: true
	});

	$('a.slide-menu').on('click', function(e) {
		var wh = $('div.wrapper').height();
		$('div.slide-mask').css('height', wh).show();
		$('aside.slide-wrapper').css('height', wh).addClass('moved');
	});

	$('div.slide-mask').on('click', function() {
		$('div.slide-mask').hide();
		$('aside.slide-wrapper').removeClass('moved');
	});

}
//获取url中的参数
function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg); //匹配目标参数
	if(r != null) return unescape(r[2]);
	return null; //返回参数值
}