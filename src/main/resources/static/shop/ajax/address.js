$(document).ready(function(){
	getAndSetAddressInfo();
	$("#addAddress").click(editInfo);
});

var addressList;
//异步获取地址信息
function getAndSetAddressInfo(){
	//获取从cookie里获取openId
	var openid=$.cookie("openid");
//	var openid='123';
	var url=$.cookie("domain")+"shop/address/"+openid;
	$.get(url,function(result){
		if(result.status){
			addressList=result.data;
			setAddressInfoList(addressList);//设置地址信息列表
		}else{
			mui.alert(result.msg);
		}
	});
}
//设置地址信息列表
function setAddressInfoList(list){
	var ul=$("#addressul");
	for(var i in list){
		var li=$("#liModel").clone().show();
		li.find(".order-add1 span").html(list[i].province+list[i].city+list[i].area+list[i].completeAddress);
		li.find("#recname").html(list[i].name);
		li.find("#phone").html(list[i].mobile);
		li.find("input:radio[name=radio3]").val(list[i].isDefault);
		li.data("id",list[i].id);
		li.appendTo(ul);
	}
	$(".editButton").click(editInfo);
	$(".deleteButton").click(deleteInfo);
	$(".address-list > li > p").click(function(e) {
            $(this).parent().addClass("curr").siblings().removeClass("curr");
            setTimeout(function() {
                if (sessionStorage.url == 'confirm')
                    history.back();
            }, 500);
    });
	$("input:radio[name=radio3]").each(function(){
		if($(this).val()==1){
			$(this).attr("checked", true);
		}
	});
	//设置默认地址
	$("input:radio[name=radio3]").change(function(){
		var id=$(this).parent().parent().parent().data("id");
		doSetDefault(id);
	});
}
//设置默认地址
function doSetDefault(id){
	var url=$.cookie('domain')+'shop/address/set-default-address/'+id;
	$.get(url,function(result){
		if(result.status==0){
			mui.alert(result.msg);
		}else{
			window.location.reload();
		}
	});
}
//删除地址信息
function deleteInfo(){
	$(".deleteButton").click(function(e) {
            var self = this;
            var id=$(self).parent().parent().data("id");
            //console.log(id);
            e.preventDefault();
            layer.open({
                content: '确定删除此收货地址？',
                btn: ['确定', '不要'],
                yes: function(index) {
                    //console.log(index);
                    $(self).parent().parent().remove();
                    deleteAddressInfoById(id);
                    layer.closeAll();
                }
            });
        });
}
//发送请求删除地址信息
function deleteAddressInfoById(id){
	var url=$.cookie("domain")+'shop/address/delete/'+id;
	//console.log(url);
	$.get(url,function(result){
		if(result.status==0){
			mui.alert(result.msg);
		}
	});
}
//编辑地址信息
function editInfo(){
	
	var title;
	var url;
	if($(this).hasClass("saveButton")){
		title="新增";
		url=$.cookie('domain')+'shop/address/save';
	}else{
		title="修改";
		url=$.cookie('domain')+'shop/address/update';
	}
            var html = ['<div class="shade_content_div">',
                '        <div class="shade_from">',
                '            <div>',
                '                <input class="input_style" type="hidden"  name="" id="addressId" value="" >',
                '            </div>',
                '            <div>',
                '                <input class="input_style" type="hidden"  name="" id="customerId" value="" >',
                '            </div>',
                '            <div>',
                '                <input class="input_style" type="hidden"  name="" id="isDefault" value="" >',
                '            </div>',
                '            <div>',
                '                <span class="span_style" id="">省&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;分</span>',
                '                <input class="input_style" type="" name="" id="province" value="" placeholder="&nbsp;&nbsp;请输入您的所在省份">',
                '            </div>',
                '            <div>',
                '                <span class="span_style" id="">城&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;市</span>',
                '                <input class="input_style" type="" name="" id="city" value="" placeholder="&nbsp;&nbsp;请输入您的所在城市">',
                '            </div>',
                '             <div>',
                '                <span class="span_style" id="">地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;区</span>',
                '                <input class="input_style" type="" name="" id="area" value="" placeholder="&nbsp;&nbsp;请输入您的所在地区">',
                '            </div>',
                '            <div>',
                '                <span class="span_style" id="">详细地址</span>',
                '                <input class="input_style" type="" name="" id="completeAddress" value="" placeholder="&nbsp;&nbsp;请输入您的详细地址">',
                '            </div>',
                '            <div>',
                '                <span class="span_style" id="">邮政编号</span>',
                '                <input class="input_style" type="" name="" id="postcode" value="" placeholder="&nbsp;&nbsp;请输入您的邮政编号">',
                '            </div>',
                '            <div>',
                '                <span class="span_style" id="">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</span>',
                '                <input class="input_style" type="" name="" id="name" value="" placeholder="&nbsp;&nbsp;请输入您的姓名">',
                '            </div>',
                '            <div>',
                '                <span class="span_style" id="">手机号码</span>',
                '                <input class="input_style" type="" name="" id="mobile" value="" placeholder="&nbsp;&nbsp;请输入您的手机号码">',
                '            </div>',
                '        </div>',
                '    </div>'
            ].join("");
            layer.open({
                title: [
                    title+'收货地址',
                    'background-color:#03A9F4; color:#fff;'
                ],
                anim: 'up',
                content: html,
                btn: ['确认', '取消'],
                yes: function(index){
                	saveOrUpdate(url);
                	layer.close(index);
                }
            });
        //根据获取的id来设置表单信息
        if($(this).hasClass("editButton")){
        	 var id=$(this).parent().parent().data("id");
        	setFormDataInfo(id);
        }
       
}
//发送异步请求提交表单数据
function saveOrUpdate(url){
	//console.log("saveOrUpdate");
	var param;
	console.log(url);
	if(url.endsWith('save')){
		param=getFormDataBySave();
	}else{
		param=getFormDataByUpdate();
	}
	
	$.post(url,param,function(result){
		if(result.status==0){
			layer.open({
				content: result.msg,
                btn: ['确定'],
                yes: function(index) {
                    layer.closeAll();
                }
           });
		}else{
			 //window.location.reload();
		}
	});
}
//获取新增表单数据
function getFormDataBySave(){
	//通过cookie来获取openid
	//var customerId=$.cookie("openid");
	//因为测试
	var openid="123";
	var province=$("#province").val();
	console.log(province);
	var city=$("#city").val();
	var area=$("#area").val();
	var completeAddress=$("#completeAddress").val();
	var postcode=$("#postcode").val();
	var name=$("#name").val();
	var mobile=$("#mobile").val();
	//地址默认为0
	var isDefault=0;
	var param={
		"openid":openid,
		"province":province,
		"city":city,
		"area":area,
		"completeAddress":completeAddress,
		"postcode":postcode,
		"name":name,
		"mobile":mobile,
		"isDefault":isDefault
	};
	return param;
}
//获取修改表单数据
function getFormDataByUpdate(){
	var id=$("#addressId").val();
	//console.log(id);
	//通过cookie来获取openid
	//var customerId=$.cookie("openid");
	//因为测试
	var openid="123";
	var customerId=$("#customerId").val();
	var province=$("#province").val();
	var city=$("#city").val();
	var area=$("#area").val();
	var completeAddress=$("#completeAddress").val();
	var postcode=$("#postcode").val();
	var name=$("#name").val();
	var mobile=$("#mobile").val();
	//地址默认为url中的参数
	var isDefault=$("#isDefault").val();
	console.log(isDefault);
	var param={
		"id":id,
		"customerId":customerId,
		"province":province,
		"city":city,
		"area":area,
		"completeAddress":completeAddress,
		"postcode":postcode,
		"name":name,
		"mobile":mobile,
		"isDefault":isDefault
	};
	return param;
}
//设置表单数据
function setFormDataInfo(id){
	//console.log(id);
	for(var i in addressList){
		if(addressList[i].id==id){
			$("#addressId").val(id);
			$("#customerId").val(addressList[i].customerId);
			$("#isDefault").val(addressList[i].isDefault);
			$("#province").val(addressList[i].province);
			$("#city").val(addressList[i].city);
			$("#area").val(addressList[i].area);
			$("#completeAddress").val(addressList[i].completeAddress);
			$("#postcode").val(addressList[i].postcode);
			$("#name").val(addressList[i].name);
			$("#mobile").val(addressList[i].mobile);
			break;
		}
	}
}

