<%@page contentType="text/html; charset=utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="v-bind" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html"; charset="utf-8" >
	<title>大猿商城(dayuanit.COM)-综合网购首选-正品低价、品质保障、配送及时、轻松购物！</title>
	<link rel="stylesheet" href="/css4/reset.css" type="text/css">
	<link rel="stylesheet" href="/css4/style.css" type="text/css">
</head>
<body class="grey">
<div id="head">
	<div class="head_top">
		<div class="wrap clearfix">
			<div class="leftArea">
				<a href="#" id="collection">收藏大猿</a>
			</div>
			<div class="rightArea">欢迎${login_user_flag.userName }来到大猿网
			
			<c:if test="${empty login_user_flag }">
				<a href="/user/toLogin.do">[登录]</a><a href="/user/toRegist.do">[免费注册]</a>
			</c:if>
			
			</div>
		</div>
	</div>
	<div class="search">
		<div class="wrap">
			<div class="logo">
				<a href="#"><img src="/images/logo.png" alt="京西商城"></a>
			</div>
			
			<div class="shop_car">
				
				<span class="car"><a href="/car/toCart.do">购物车</a></span>
				<span class="num_text">0</span>
			</div>
			<div class="shop_car">
				
				<span class="car"><a href="/order/toOrder.do">订单</a></span>
				<span class="num_text">0</span>
			</div>
		</div>
	</div>
</div>

	<div class="bread wrap"><a class="index" href="/">首页</a><em>&gt;</em><a href="#">精品手机</a></div>

	<div class="commodity_info wrap clearfix">
		<div class="info_left">
			<div class="commodity_img"><img src="/images/sp.jpg" alt="商品图片"></div>
			<ul class="clearfix">
				<li class="imgOn"><img src="/images/img_list.jpg" alt="缩略图"></li>
				<li><img src="/images/img_list.jpg" alt="缩略图"></li>
				<li><img src="/images/img_list.jpg" alt="缩略图"></li>
				<li><img src="/images/img_list.jpg" alt="缩略图"></li>
				<li><img src="/images/img_list.jpg" alt="缩略图"></li>
			</ul>
		</div>
		
		
		<div class="info_right" >
			<h3 class="shop_name">${goods.goodsName }</h3>
			
			<dl class="price">
				<dt>京西价</dt>
				<dd><b>￥</b>${goods.price }</dd>
			</dl>
			<dl class="favourable">
				<dt>优惠</dt>
				<dd><span>满换购</span>${goods.tips }</dd>
			</dl>
			
			<div class="selection">
				<dl class="address">
				</dl>
				<dl>
					<dt>数量</dt>
					<dd class="clearfix" >
						<div class="num_select">							
							<input type="text" value=${goods.number }>							
						</div>
						<span class="limit_num">已卖<b>${goods.soldNumber}</b>件</span>
					</dd>
				</dl>
				
			</div>
			
			<div class="buy">
		  		<dl>
					<dt>购买</dt>
					<dd class="clearfix" id="app">							
						<div class="num_select">
							<span onclick="minus();">-</span>
								<input  type="text"  id="goodsNum" name="goodsNum" v-bind:value="a">
							<span onclick="plus();">+</span>
						</div>						
					<span class="limit_num">件</span>						
				</dl>
		
			<div class="buy_btn" id="app2">
				<a onclick="addCar();">加入购物车</a>
				<input type="hidden" id="goodsId" name="goodsId" value=${goods.id}>
				<input type="hidden" id="price" name="price" value=${goods.price}>
				<span class="ver_line"></span>
				<a onclick="addOrder();">立即购买</a>
			</div>			
			<p class="notice">注意：此商品可提供普通发票，不提供增值税发票。</p>
			</div>
			
		</div>
		
	</div>
<script type="text/javascript" src="/js/jquery-mini.js"></script>
<script type="text/javascript" src="/js/vue.js"></script>
<script type="text/javascript" charset="utf-8">

var vm = {};
var vm2 = {};
$(document).ready(function () {
    var data = { a: 1 };
	vm = new Vue({
        el: '#app',
        data: data,
		methods: {
            plus: function () {
				this.a++;
            },

            minus: function () {
				this.a--
            }
		}
    })

});

	function addCar() {		
		$.ajax({
	        url:'/car/addShopCar.do',
	        type:'POST', //GET
	        async:true,    //或false,是否异步
	        data:{
	        	goodsId:$('#goodsId').val(),
	        	goodsNum:$('#goodsNum').val()
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
	           /*  window.location.href='/car/toCart.do?goodsId=${goodsId}'; */
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
	
	function addOrder() {		
		$.ajax({
	        url:'/order/addOrder.do',
	        type:'POST', //GET
	        async:true,    //或false,是否异步
	        data:{
	        	goodsId:$('#goodsId').val(),
	        	goodsNum:$('#goodsNum').val(),
	        	price:$('#price').val()
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
	
	function plus() {
	    vm.plus();
	    alert(vm.a);
	}

    function minus() {

	    if (vm.a <= 1) {
	        return false;
		}
        vm.minus();
	    alert(vm.a);
    }
	</script>	
<div id="footer">
	<p>慕课简介|慕课公告| 招纳贤士| 联系我们|客服热线：400-675-1234</p>
	<p>Copyright © 2006 - 2014 慕课版权所有   京ICP备09037834号   京ICP证B1034-8373号   某市公安局XX分局备案编号：123456789123</p>
	<div class="credit_rating">
		<a href="#"><img src="/images/pj.jpg" alt="信用评价"></a>
		<a href="#"><img src="/images/pj.jpg" alt="信用评价"></a>
		<a href="#"><img src="/images/pj.jpg" alt="信用评价"></a>
		<a href="#"><img src="/images/pj.jpg" alt="信用评价"></a>
	</div>
</div>
</body>
</html>