$(document).ready(function() {
	
	
	//设置导航栏url
			$("#my-point-url").attr("href",$.cookie("myPointUrl"));
			
			$("#my-shop-url").attr("href",$.cookie("MyShopUrl"));
			$("#my-url").attr("href",$.cookie("myUrl"));
			
			
			
			$("#ask").click(function() {
				var btnArray = ['否', '是'];
				mui.confirm('离开本页面前往公众号？', '我要咨询', btnArray, function(e) {
					if(e.index == 1) {
						WeixinJSBridge.invoke('closeWindow', {}, function(res) {});

					} else {}
				})
			});
			
			$("#kuaidi").click(function(){
				//http://www.yearcontest.com/shop/order/kauidi/666
				var url =$.cookie("domain") + "shop/order/kauidi/"+$.cookie("openid");
				$.getJSON(url,function(result){
					console.log(JSON.stringify(result));
					if(result.status!=1){
						mui.alert(result.msg);
						return ;
					}
					var courierCompany = result.data.courierCompany;
					var courierNumber = result.data.courierNumber;
					
					window.location = "https://m.kuaidi100.com/index_all.html?type="+courierCompany+"&postid="+courierNumber;
					
				});
			});
	
	
	
	
	$("#new-model1").hide();
	$("#new-model2").hide();
	doGetIndexImages();
	doGetNewProduct();
	doGetIndexCategory();

});

/**
 * 获取首页分类商品 http://www.yearcontest.com/shop/index/category
 */
function doGetIndexCategory() {
	var url = $.cookie('domain') + "shop/index/category";
	$.getJSON(url, function(result) {
		//		console.log("首页分类商品 =" + JSON.stringify(result));
		if(result.status != 1) {
			mui.alert(resizeBy.msg);
			return;
		}
		var data = result.data;
		//设置分类名
		for(var key in data) {
			//console.log("category的名字=" + key);
			var categoryName = key; //分类的名称
			var categoryList = data[key]; //该分类下的商品
			//console.log(JSON.stringify(categoryList));
			var model = $("#model_type").clone().show();
			model.find("#keyName").html(categoryName);
			model.appendTo("#main");
			model.find("#model_pro_par").addClass(categoryName);
			setTypeProduct(categoryList, categoryName);
		}
	});
}
//设置分类商品
function setTypeProduct(list, key) {
	for(var i in list) {
		var p = list[i];
		var model = $("#model_pro").clone().show();
		model.find("#type_img").attr('src', p.pictureUrlDefault);
		model.find("#type_name").html(p.name);
		model.find("#type_points").html(p.points);
		model.find('.productId').attr('href', 'detail.html?productId=' + list[i].id);
		model.appendTo("." + key);
	}
}

function doGetNewProduct() {

	var url = $.cookie('domain') + "shop/index/new-product";
	$.get(url, function(result) {
		console.log(JSON.stringify(result));
		if(result.status != 1) {
			mui.alert(result.msg);
			return;
		}
		setProductRows(result.data);
	});
}

function setProductRows(list) {

	for(var i = 0; i < 2; i++) {
		var newp = list[i];
		var $model = $("#new-model1").clone().show();
		$model.find("a").attr("href", 'detail.html?productId=' + newp.id);
		$model.find(".tit").html(newp.name);
		$model.find(".point").html(newp.points);
		$model.find("img").attr("src", newp.pictureUrlDefault);

		$model.appendTo("#new-model1-parent");

	}
	for(var i = 2; i < 5; i++) {
		var newp2 = list[i];
		var $model = $("#new-model2").clone().show();
		$model.find("a").attr("href", 'detail.html?productId=' + newp2.id);
		$model.find("img").attr("src", newp2.pictureUrlDefault);
		$model.find(".tit").html(newp2.name);
		$model.find(".point").html(newp2.points);

		$model.appendTo("#new-model2-parent");
	}

	//	for(var i in list) {
	//		var $model = $("#model").clone().show();
	//		$model.find("#picture").attr("src", list[i].pictureUrlDefault);
	//		$model.find("#name").html(list[i].name);
	//		$model.find("#point").html(list[i].points);
	//		$model.find('.productId').attr('href', 'detail.html?productId=' + list[i].id);
	//		$model.appendTo(".model-new");
	//	}

}

function doGetIndexImages() {
	var url = $.cookie('domain') + "shop/index/image";
//	var url = "http://192.168.1.241:8082/shop/index/image";
	$.get(url, function(result) {
//		alert(url);
		if(result.status) {
			setIndexImage(result.data);
			setSwiper();
		} else {
			mui.alert(result.msg);
		}
	});
}

function setIndexImage(list) {
	//console.log("ok");
	var indexImages = $("#indexImages");
	indexImages.empty();
	for(var i in list) {
		if(list[i].pictureUrl == '#') {
			continue;
		}
		var indexImage = '<div class="swiper-slide" >' +
			'<a href="javascript:void(0)">' +
			'<img class="swiper-lazy" src="#" alt=""></a></div>';
		//indexImage=indexImage.replace('count',i);
		indexImage = indexImage.replace('#', list[i].pictureUrl);
		indexImages.append(indexImage);
	}

	/*var lastImage='<div class="swiper-slide swiper-slide-duplicate" data-swiper-slide-index="0">'
				+'<a href="javascript:void(0)"><img class="swiper-lazy swiper-lazy-loaded" alt="" src="#"></a></div>';
	lastImage=lastImage.replace('#',list[0].pictureUrl);
	indexImages.append(lastImage);*/
}

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