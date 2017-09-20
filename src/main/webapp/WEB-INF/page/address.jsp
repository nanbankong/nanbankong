<%@page contentType="text/html; charset=utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head lang="en">
		<meta charset="utf-8" />
		<title>大猿商城-地址管理</title>
		<link rel="stylesheet" type="text/css" href="/css5/public.css"/>
		<link rel="stylesheet" type="text/css" href="/css5/mygxin.css" />
	</head>
	<body>
		<!------------------------------head------------------------------>
		<div class="head ding">
			<div class="wrapper clearfix">
				<div class="clearfix" id="top">
					<h1 class="fl"><a href="index.html"><img src="/img/logo.png"/></a></h1>
					<div class="fr clearfix" id="top1">
						<p class="fl">
							<a href="login.html" id="login">登录</a>
							<a href="reg.html" id="reg">注册</a>
						</p>
					</div>
				</div>				
			</div>
		</div>
		<!------------------------------idea------------------------------>
		<div class="address mt">
			<div class="wrapper clearfix">
				<a href="index.html" class="fl">首页</a>
				<span>/</span>
				<a href="mygxin.html">个人中心</a>
				<span>/</span>
				<a href="address.html" class="on">地址管理</a>
			</div>
		</div>
		
		<!------------------------------Bott------------------------------>
		<div class="Bott">
			<div class="wrapper clearfix">
				<div class="zuo fl">
					<h3>
						<a href="#"><img src="/img/tx.png"/></a>
						<p class="clearfix"><span class="fl">[羊羊羊]</span><span class="fr">[退出登录]</span></p>
					</h3>
					<div>
						<h4>我的交易</h4>
						<ul>
							<li><a href="cart.html">我的购物车</a></li>
							<li><a href="myorderq.html">我的订单</a></li>
							<li><a href="myprod.html">评价晒单</a></li>
						</ul>
						<h4>个人中心</h4>
						<ul>
							<li><a href="mygxin.html">我的中心</a></li>
							<li class="on"><a href="address.html">地址管理</a></li>
						</ul>
						<h4>账户管理</h4>
						<ul>
							<li><a href="mygrxx.html">个人信息</a></li>
							<li><a href="remima.html">修改密码</a></li>
						</ul>
					</div>
				</div>
				<div class="you fl" id="addreShow">
					<h2>收货地址</h2>
					<div class="add">
						<div>
							<a href="#2" id="addxad"><img src="/img/jia.png"/></a>
							<span>添加新地址</span>
						</div>
					</div>	
						<div class="add" v-for="(address, index) in addresses">
							<div >
								<p>{{address.userRealName}}</p>
								<p>{{address.phone}}</p>
								<p>{{address.province}} {{address.city}} {{address.area}}</p>
								<p>{{address.detail}}</p>
								<p>
								<span v-on:click="modifyAdd(index)">修改</span>
								<span v-on:click="delAdd(index)">删除</span>
							</div>
						</div>				
				</div>
			</div>
		</div>
		<!--编辑弹框-->
		<!--遮罩-->
		<div class="mask"></div>
		<div class="adddz">
			<form action="#" method="get">
				<input type="text" placeholder="姓名" id="realName" class="on" />
				<input type="text" placeholder="手机号" id="phone"/>
				<div class="city">
					<select name="" id="addProvince" onchange="listCity();">
						<option value="xxx">省份/自治区</option>
					</select>
					<select id="addCity" onchange="listArea();">
						<option value="xxx">城市/地区</option>
					</select>
					<select id="addArea">
						<option value="xxx">区/县</option>
					</select>
				</div>
				默认地址：
				<input type="radio" id="xx" name="defAdd" value="2" style="width: 20px;height: 20px">否
				<input type="radio" id="xxx" name="defAdd" value="1" style="width: 20px;height: 20px">是
				<input type="hidden" value="modify" id="xxx">
				<textarea name="" rows="" cols="" id="detailAddress" placeholder="详细地址"></textarea>
				<div class="bc">
					<input type="button"  id="save" value="保存" />
					<input type="button" value="取消" />
				</div>
			</form>
		</div>
	
		<!--返回顶部-->
		<div class="gotop">
			<a href="cart.html">
			<dl>
				<dt><img src="/img/gt1.png"/></dt>
				<dd>去购<br />物车</dd>
			</dl>
			</a>
			<a href="#" class="dh">
			<dl>
				<dt><img src="/img/gt2.png"/></dt>
				<dd>联系<br />客服</dd>
			</dl>
			</a>
			<a href="mygxin.html">
			<dl>
				<dt><img src="/img/gt3.png"/></dt>
				<dd>个人<br />中心</dd>
			</dl>
			</a>
			<a href="#" class="toptop" style="display: none">
			<dl>
				<dt><img src="/img/gt4.png"/></dt>
				<dd>返回<br />顶部</dd>
			</dl>
			</a>
			<p>400-800-8200</p>
		</div>
		<div class="footer">
			<p class="dibu">最家家居&copy;2013-2017公司版权所有 京ICP备080100-44备0000111000号<br />
			违法和不良信息举报电话：400-800-8200，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</p>
		</div>		
		<script type="text/javascript" src="/js/jquery-mini.js"></script>
		<script type="text/javascript" src="/js/vue.js"></script>
		<script type="text/javascript">
			var showAddress = {};
			var modifyAddressId = -1;
			var actionFlag = false;
			$(document).ready(function() {				
				showAddress = new Vue({
					el : '#addreShow',
					data : {
						addresses : []
					}, 
					methods : {
						modifyAdd : function(index) {
							
							$('.mask').show();
							$('.adddz').show();
							
							var address = this.addresses[index];
							initModify(address);
							actionFlag = false;
						},
						delAdd : function(index) {
							var address = this.addresses[index];
							alert(address.userRealName);
							deleteAdd(address);
						}
					}
				});
				
				$('#addxad').click(function() {
					initAddAddress();
					$('.mask').show();
					$('.adddz').show();
					listProvince();
					actionFlag = true;
				});
				
				$('.bc>input').click(function() {
					$('.mask').hide();
					$('.adddz').hide();
				});
				
				$('#save').click(function() {
					choseAction();
				});
				
				loadAddress();				
			});
			
			function choseAction() {
				if (actionFlag) {
					add();
				} else {
					modify();
				}
			}
			
			function deleteAdd(address) {
		   		
				if (confirm("你确信要删除商品吗？")) {
					$.ajax({
		                url:'/address/delete.do',
		                type:'POST', //GET
		                async:true,    //或false,是否异步
		                data:{
		                	addressId:address.id
		                },
		                timeout:5000,    //超时时间
		                dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
		                beforeSend:function(xhr){
		                    console.log(xhr)
		                    console.log('发送前')
		                },
		                success:function(data,textStatus,jqXHR){
		                    
		                    if (!data.success) {
		                    	alert(data.message);
		                    	return;
		                    }
		                    
		                    alert('删除成功');
		              
			            	 loadAddress();
		                    
		                },
		                error:function(xhr,textStatus){
		                    console.log('错误')
		                    console.log(xhr)
		                    console.log(textStatus)
		                },
		                complete:function(){
		                    console.log('结束')
		                }
		            });
				} else {
					alert('删除失败');
				}
			}
						
			function modify() {
				$.ajax({
		            url:'/address/modify.do',
		            type:'POST', //GET
		            async:false,    //或false,是否异步
		            data:{
		            	realName : $('#realName').val(),
		            	phone : $('#phone').val(),
						provinceCode : $('#addProvince').val(),
						cityCode : $('#addCity').val(),
						areaCode : $('#addArea').val(),
		            	detailAddress : $('#detailAddress').val(),
		            	type : $('input:radio[name="defAdd"]:checked').val(),
		            	addressId : modifyAddressId
		            },
		            timeout:5000,    //超时时间
		            dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
		            beforeSend:function(xhr){
		                console.log(xhr)
		                console.log('发送前')
		            },
		            success:function(data,textStatus,jqXHR){
		            	 if (!data.success) {
		                 	alert(data.message);
		                 	return;
		                 }
		            	 
		            	 alert('success');
		            	 loadAddress();
		                 
		             },
		            error:function(xhr,textStatus){
		                console.log('错误')
		                console.log(xhr)
		                console.log(textStatus)
		            },
		            complete:function(){
		                console.log('结束')
		            }
		        });
			}
			
			function initModify(address) {
				alert(address.id);
				listProvince();
				$('#realName').val(address.userRealName);
				$('#phone').val(address.phone);
				$('#addProvince').val(address.provinceCode);
				listCity();
				$('#addCity').val(address.cityCode);
				
				listArea();
				$('#addArea').val(address.areaCode);
				$('#detailAddress').val(address.detail);
				
				if (1 == address.isDef) {
					$('input:radio[name="defAdd"][value="1"]').prop('checked', true);
				} else {
					$('input:radio[name="defAdd"][value="2"]').prop('checked', true);
				}
				
				modifyAddressId = address.id;
			}
			
			function loadAddress() {
				$.ajax({
		            url:'/address/listAddress.do',
		            type:'POST', //GET
		            async:false,    //或false,是否异步
		            data:{
		            },
		            timeout:5000,    //超时时间
		            dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
		            beforeSend:function(xhr){
		                console.log(xhr)
		                console.log('发送前')
		            },
		            success:function(data,textStatus,jqXHR){
		            	 if (!data.success) {
		                 	alert(data.message);
		                 	return;
		                 }
		            	 
						showAddress.addresses = data.data;
						
		             },
		            error:function(xhr,textStatus){
		                console.log('错误')
		                console.log(xhr)
		                console.log(textStatus)
		            },
		            complete:function(){
		                console.log('结束')
		            }
		        });
			}
			
			
			function add() {
				
				$.ajax({
		            url:'/address/addAddress.do',
		            type:'POST', //GET
		            async:false,    //或false,是否异步
		            data:{
		            	realName : $('#realName').val(),
		            	phone : $('#phone').val(),
						provinceCode : $('#addProvince').val(),
						cityCode : $('#addCity').val(),
						areaCode : $('#addArea').val(),
		            	detailAddress : $('#detailAddress').val(),
		            	type : $('input:radio[name="defAdd"]:checked').val()
		            },
		            timeout:5000,    //超时时间
		            dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
		            beforeSend:function(xhr){
		                console.log(xhr)
		                console.log('发送前')
		            },
		            success:function(data,textStatus,jqXHR){
		            	 if (!data.success) {
		                 	alert(data.message);
		                 	return;
		                 }
		            	 
		            	 alert('success');
		            	 loadAddress();
		             },
		            error:function(xhr,textStatus){
		                console.log('错误')
		                console.log(xhr)
		                console.log(textStatus)
		            },
		            complete:function(){
		                console.log('结束')
		            }
		        });
			}
			
			function initAddAddress() {
				$('#realName').val('');
				$('#phone').val('');
				$('#addProvince').val('xxx');
				$('#addCity').val('xxx');
				$('#addArea').val('xxx');
				$('#detailAddress').val('');
			}
			
			function listArea() {
				$.ajax({
		            url:'/province/listArea.do',
		            type:'POST', //GET
		            async:false,    //或false,是否异步
		            data:{
		            	cityCode:$('#addCity').val()
		            },
		            timeout:5000,    //超时时间
		            dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
		            beforeSend:function(xhr){
		                console.log(xhr)
		                console.log('发送前')
		            },
		            success:function(data,textStatus,jqXHR){
		            	 if (!data.success) {
		                 	alert(data.message);
		                 	return;
		                 }
		                 
		                var results = data.data;
		                var msg = '<option value="xxx">区/县</option>';
		               	for (var i=0; i<results.length; i++) {
		               		var area = results[i];
		               		msg += '<option value="'+area.code+'">'+ area.name+'</option>'; 
		               	}
		               	
		               	$('#addArea').html(msg);
		             },
		            error:function(xhr,textStatus){
		                console.log('错误')
		                console.log(xhr)
		                console.log(textStatus)
		            },
		            complete:function(){
		                console.log('结束')
		            }
		        });
			}
			
			
			function listCity() {
				$.ajax({
		            url:'/province/listCity.do',
		            type:'POST', //GET
		            async:false,    //或false,是否异步
		            data:{
		            	provinceCode:$('#addProvince').val()
		            },
		            timeout:5000,    //超时时间
		            dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
		            beforeSend:function(xhr){
		                console.log(xhr)
		                console.log('发送前')
		            },
		            success:function(data,textStatus,jqXHR){
		            	 if (!data.success) {
		                 	alert(data.message);
		                 	return;
		                 }
		                 
		                var results = data.data;
		                var msg = '<option value="xxx">城市/地区</option>';
		               	for (var i=0; i<results.length; i++) {
		               		var city = results[i];
		               		msg += '<option value="'+city.code+'">'+ city.name+'</option>'; 
		               	}
		               	
		               	$('#addCity').html(msg);
		               	$('#addArea').html('<option value="xxx">区/县</option>');
		             },
		            error:function(xhr,textStatus){
		                console.log('错误')
		                console.log(xhr)
		                console.log(textStatus)
		            },
		            complete:function(){
		                console.log('结束')
		            }
		        });
			}
			
			function listProvince() {
				$.ajax({
		            url:'/province/listProvince.do',
		            type:'POST', //GET
		            async:false,    //或false,是否异步
		            data:{
		            },
		            timeout:5000,    //超时时间
		            dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
		            beforeSend:function(xhr){
		                console.log(xhr)
		                console.log('发送前')
		            },
		            success:function(data,textStatus,jqXHR){
		            	 if (!data.success) {
		                 	alert(data.message);
		                 	return;
		                 }
		                 
		                var results = data.data;
		                var msg = '';
		               	for (var i=0; i<results.length; i++) {
		               		var pro = results[i];
		               		msg += '<option value="'+pro.code+'">'+ pro.name+'</option>'; 
		               		
		               	}
		               	
		               	$('#addProvince').append(msg);
		             },
		            error:function(xhr,textStatus){
		                console.log('错误')
		                console.log(xhr)
		                console.log(textStatus)
		            },
		            complete:function(){
		                console.log('结束')
		            }
		        });
			}
		</script>
	</body>
</html>
