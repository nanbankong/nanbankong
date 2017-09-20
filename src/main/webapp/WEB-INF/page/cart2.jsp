<%@page contentType="text/html; charset=utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="v-bind" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head lang="en">
		<meta charset="utf-8" />
		<title>cart</title>
		<link rel="stylesheet" type="text/css" href="/css5/public.css"/>
		<link rel="stylesheet" type="text/css" href="/css5/proList.css" />
	</head>
	<body>			
			<div class="site">
				<p class=" wrapper clearfix">
					<span class="fl">购物车</span>
					<img class="top" src="/img/temp/cartTop01.png">
					<a href="index.html" class="fr">继续购物&gt;</a>
				</p>
			</div>
			
			
		<div id = "goodsShow">	
			<div class="table wrapper">
				<div class="tr">
					<div>商品</div>
					<div>单价</div>
					<div>数量</div>
					<div>小计</div>
					<div>操作</div>
				</div>
				<div class="th" v-for="(goods, index) in shopCar">
					<div class="pro clearfix">
						<label class="fl">
							<input type="checkbox" v-bind:id="index" v-on:click="goodChecked"/>
    						<span></span>
						</label>
						<a class="fl" href="#">
							<dl class="clearfix">
								<dt class="fl"><img src="/img/temp/cart01.jpg"></dt>
								<dd class="fl">
									<p>{{goods.xx.goodsName}}</p>
									<p>{{goods.xx.price}}</p>
								</dd>
							</dl>
						</a>
					</div>
					<div class="price">￥{{goods.xx.price}}</div>
					<div class="number" >
						<p class="num clearfix">
						
							<img class="fl sub" src="/img/temp/sub.jpg" v-on:click="subCount(index)">
							
							<span class="fl" id = "shopCartDetail">{{goods.goodsNum}}</span>
							
							<img class="fl add" src="/img/temp/add.jpg" v-on:click="plusCount(index)">
						</p>
					</div>
					<div class="price sAll" >￥{{goods.goodsNum * goods.xx.price}}</div>
					<div class="price"><a class="del" href="#2" v-on:click="deleteCar(goods.id)">删除{{goods.id}}</a></div>
				</div>			
				<div class="goOn">空空如也~<a href="index.html">去逛逛</a></div>
				<div class="tr clearfix">
					<label class="fl">
						<input class="checkAll" type="checkbox" id="selectAll" onclick="selectAll()"/>
						<span></span>
					</label>
					<p class="fl">
						<a href="#">全选</a>
						<a href="#" class="del">删除</a>
					</p>
					<p class="fr">
						<span>共<small id="sl">0</small>件商品</span>
						<span>合计:&nbsp;<small id="totalAmount">￥0.00</small></span>
						
						<a href="#" class="count" v-on:click="settlement()">结算</a>
					</p>
				</div>
				<div class="shop_car">
				
				
			</div>
		</div>			
	</div>	
<script src="/js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="/js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="/js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="/js/cart.js" type="text/javascript" charset="utf-8"></script>		
	
	
<script type="text/javascript" src="/js/jquery-mini.js"></script>
<script type="text/javascript" src="/js/vue.min.js"></script>
<script type="text/javascript" charset="utf-8">
var goodsShow = {};
	$(document).ready(function() {
		goodsShow = new Vue({
			el : '#goodsShow',
			data : {
				shopCar : [
				]
			},
			methods:{
				deleteCar:function(id) {
					deleteCar(id);
				},
				
				plusCount : function(index) {
					var cg = this.shopCar[index];
					cg.goodsNum += 1;
					countAmount();
				},
				
				subCount : function(index) {
					var cg = this.shopCar[index];
					if (cg.goodsNum <= 1) {
						return;
					}
					cg.goodsNum -= 1;
					countAmount();
				},
				
				goodChecked : function() {
					countAmount();
				},
				
				settlement : function() {
					settlement();
				}
			}
		});
		
		getListCart();
	});
	
	function settlement() {
		var goodArray =[];
		$('.th :checkbox').each(function (){
			if ($(this).is(':checked')) {
				var attrValue = $(this).attr('id');
				goodArray.push(attrValue);
				
			}
		});
		
		var total = 0;		
		for (var i=0; i<goodArray.length; i++) {
			var index = goodArray[i];
			var good = goodsShow.shopCar[index];					
			
			addOrder(good);
			
		}
	}
	
	function addOrder(good) {		
		$.ajax({
	        url:'/order/addOrder.do',
	        type:'POST', //GET
	        async:true,    //或false,是否异步
	        data:{
	        	goodsId:good.goodsId,
	        	goodsNum:good.goodsNum,
	        	price:good.xx.price
	        },
	        timeout:5000,    //超时时间
	        dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
	        beforeSend:function(xhr){
	            console.log(xhr)
	            console.log('发送前')
	        },
	        success:function(data,textStatus,jqXHR){
	            var obj = data;
	            alert(obj.success);
	            
	            if (!data.success) {
	            	alert(data.message);
	            	return;
	            }
	           window.location.href='/order/toOrder.do?goodsId=${goodsId}'; 
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
	
	
	function selectAll() {
		$('.th :checkbox').each(function (){
			if ($('#selectAll').is(':checked')) {
				$(this).prop('checked', true);
			} else {
				$(this).prop('checked', false);
			}
		});
		countAmount();
	}
	
	function countAmount() {
		var goodArray =[];
		$('.th :checkbox').each(function (){
			if ($(this).is(':checked')) {
				var attrValue = $(this).attr('id');
				goodArray.push(attrValue);
				
			}
		});
		
		var total = 0;		
		for (var i=0; i<goodArray.length; i++) {
			var index = goodArray[i];
			var good = goodsShow.shopCar[index];
			var price = good.xx.price;			
			var num = good.goodsNum;
			
			total += price * num;
		}		
		$('#totalAmount').html(total);
	}
	
	function getListCart() {
   		$.ajax({
               url:'/car/listCarGoods.do',
               type:'POST', //GET
               async:true,    //或false,是否异步
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
                  
                  	goodsShow.shopCar = data.data;
                   var len = data.data.length;
                   for (var i=0; i<len;i++) {
	                   	var cg = data.data[i];
	                   	getGoods(cg, i);
                   }                
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
	
	function getGoods(cg, index) {
   		$.ajax({
               url:'/goods/getGoods.do',
               type:'POST', //GET
               async:true,    //或false,是否异步
               data:{
            	   goodsId:cg.goodsId,
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
                   //cg["goodss"] = data.data;
                   goodsShow.$set(cg, "xx", data.data);
                  // goodsShow.shopCar.splice(index, 1, cg)
                    
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
	
	function deleteCar(id) {
   		alert(id);
		if (confirm("你确信要删除商品吗？")) {
			$.ajax({
                url:'/car/deleteCar.do',
                type:'POST', //GET
                async:true,    //或false,是否异步
                data:{
                	carId:id
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
                    window.location.href = '/car/toCart.do?';
                    
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
	

</script>		
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
			<a href="#" class="toptop" style="display: none;">
			<dl>
				<dt><img src="/img/gt4.png"/></dt>
				<dd>返回<br />顶部</dd>
			</dl>
			</a>
			<p>400-800-8200</p>
		</div>

	</body>
</html>
