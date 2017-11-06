var myScroll, pullDownEl, pullDownOffset, pullUpEl, pullUpOffset, generatedCount = 0;
var categoryId;
var page = 2;

function loaded() {

	$("#model").hide();
	categoryId = getUrlParam('categoryId');
	var categoryName= $.cookie(categoryId);
	$("title").html(categoryName);
	$.cookie(categoryId,null);
//	categoryName = getUrlParam('categoryName');
	console.log("categoryId=" + categoryId);
	console.log("categoryName=" + categoryName);

	//动画部分
	pullDownEl = document.getElementById('pullDown');
	pullDownOffset = pullDownEl.offsetHeight;
	pullUpEl = document.getElementById('pullUp');
	pullUpOffset = pullUpEl.offsetHeight;
	myScroll = new iScroll('wrapper', {
		useTransition: true,
		topOffset: pullDownOffset,
		onRefresh: function() {
			if(pullDownEl.className.match('loading')) {
				pullDownEl.className = '';
				pullDownEl.querySelector('.pullDownLabel').innerHTML = '下拉刷新';
			} else if(pullUpEl.className.match('loading')) {
				pullUpEl.className = '';
				pullUpEl.querySelector('.pullUpLabel').innerHTML = '上拉加载更多';
			}
		},
		onScrollMove: function() {

			if(this.y > 5 && !pullDownEl.className.match('flip')) {
				pullDownEl.className = 'flip';
				pullDownEl.querySelector('.pullDownLabel').innerHTML = '释放刷新';
				this.minScrollY = 0;
			} else if(this.y < 5 && pullDownEl.className.match('flip')) {
				pullDownEl.className = '';
				pullDownEl.querySelector('.pullDownLabel').innerHTML = 'Pull down to refresh...';
				this.minScrollY = -pullDownOffset;
			} else if(this.y < (this.maxScrollY - 5) && !pullUpEl.className.match('flip')) {
				pullUpEl.className = 'flip';
				pullUpEl.querySelector('.pullUpLabel').innerHTML = '释放刷新';
				this.maxScrollY = this.maxScrollY;
			} else if(this.y > (this.maxScrollY + 5) && pullUpEl.className.match('flip')) {
				pullUpEl.className = '';
				pullUpEl.querySelector('.pullUpLabel').innerHTML = 'Pull up to load more...';
				this.maxScrollY = pullUpOffset;
			}
		},
		onScrollEnd: function() {
			if(pullDownEl.className.match('flip')) {
				pullDownEl.className = 'loading';
				pullDownEl.querySelector('.pullDownLabel').innerHTML = '加载中';
				pullDownAction(); // Execute custom function (ajax call?)
			} else if(pullUpEl.className.match('flip')) {
				pullUpEl.className = 'loading';
				pullUpEl.querySelector('.pullUpLabel').innerHTML = '加载中';
				pullUpAction(); // Execute custom function (ajax call?)
			}
		}
	});

	loadAction();
}


document.addEventListener('touchmove', function(e) {
	e.preventDefault()
}, false); //阻止冒泡

document.addEventListener('DOMContentLoaded', function() {
	setTimeout(loaded, 0);
}, false);

//初始状态，加载数据
function loadAction() {
	getData(categoryId, 1, 10);

	myScroll.refresh();
}

//下拉刷新当前数据
function pullDownAction() {
	setTimeout(function() {
		//这里执行刷新操作
		mui.toast("刷新成功");

		myScroll.refresh();
	}, 400);
}

//上拉加载更多数据
function pullUpAction() {
	setTimeout(function() {
//		mui.toast("上拉刷新...")
		getData(categoryId, page++, 10);
		myScroll.refresh();
	}, 400);
}

function getData(categoryId, curPage, pageSize) {
	var url = $.cookie("domain") + "shop/category/page";
	var data = {
		id: categoryId,
		curPage: curPage,
		pageSize: pageSize

	};
	$.getJSON(url, data, function(result) {
		if(result.status != 1) {
			mui.alert(result.msg);
			//联网失败的回调,隐藏下拉刷新和上拉加载的状态;
			return;
		}

		console.log(JSON.stringify(result.data));
		addData(result.data);

	});

}

function addData(list) {
	console.log("数据量:=" + list.length);
	if(list.length==0){
		mui.toast("没有更多数据了");
		$(".pullUpLabel").html("没有更多数据了");
		
	}

	for(var i in list) {
		var $model = $("#model").clone().show();
		var p = list[i];
		$model.find(".tit").html(p.name);
		$model.find(".jifen").html(p.points + "积分");
		$model.find("a").attr("href", "detail.html?productId=" + p.id);
		$model.find("img").attr("src", p.pictureUrlDefault);

		$model.appendTo("#model-parent");

	}

}

//获取url中的参数
function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg); //匹配目标参数
	if(r != null) return unescape(r[2]);
	return null; //返回参数值
}