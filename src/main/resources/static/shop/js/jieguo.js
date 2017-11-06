$(function(){
	$("#qiandaobtn").click(function(){
		$(".qiandaoed-bg").show();
		document.getElementById("qiandao-btn-txt").innerHTML="已签到";
		document.getElementById("qiandao-icon").src="../img/index1/y3-2.png";
	});
	
	$("#qiandao-close").click(function(){
		$(".qiandaoed-bg").hide();
	});
	
	
	$("#beauty").click(function(){
		$(".beauty-bg").show();
	});
	
	$("#beauty-close").click(function(){
		$(".beauty-bg").hide();
	});
	
});