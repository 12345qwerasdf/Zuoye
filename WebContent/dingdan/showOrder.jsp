<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Document</title>
  <link rel="stylesheet" type="text/css" href=" res/static/css/main.css">
  <link rel="stylesheet" type="text/css" href=" res/layui/css/layui.css">
  <script type="text/javascript" src=" res/layui/layui.js"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
</head>
<body>

  <div class="site-nav-bg">
    <div class="site-nav w1200">
      <p class="sn-back-home">
        
        <!-- <a href="#">首页</a> -->
      </p>
      <div class="sn-quick-menu">
         <div class="login"> <c:choose>
			<c:when test="${user == null }">
			<!-- 顶部未登录 -->
			<a href="login.jsp">登陆</a>
			</c:when>
			<c:otherwise>
			<!-- 顶部已登录 -->
			欢迎:<strong>${user.username }</a>
			
			 | <a href="logout">退出</a>
			</c:otherwise>
		</c:choose></div>
        <div class="sp-cart"><a href="shopcart?act=look">购物车</a><span></span></div>
      </div>
    </div>
  </div>



  <div class="header">
    <div class="headerLayout w1200">
      <div class="headerCon">
        <h1 class="mallLogo">
          <a href="#" title="电脑商城">
            <img src=" res/static/img/lo.png">
          </a>
        </h1>
        <!-- <div class="mallSearch">
          <form action="" class="layui-form" novalidate>
            <input type="text" name="title" required  lay-verify="required" autocomplete="off" class="layui-input" placeholder="请输入需要的商品">
            <button class="layui-btn" lay-submit lay-filter="formDemo">
                <i class="layui-icon layui-icon-search"></i>
            </button>
            <input type="hidden" name="" value="">
          </form>
        </div> -->
      </div>
    </div>
  </div>


  <div class="content content-nav-base shopcart-content">
    <div class="main-nav">
      <div class="inner-cont0">
        <div class="inner-cont1 w1200">
          <div class="inner-cont2">
            <a href="search" class="active">所有商品</a>
            <a href="buytoday">今日团购</a>
          
          </div>
        </div>
      </div>
    </div>
    <div class="banner-bg w1200">
      <h3>欢迎选购</h3>
      <p>各种品牌电脑随意购</p>
    </div>
    <div class="cart w1200">
    	<div class="cart-table-th"> 
    	  
   
		<table class="layui-table" lay-even lay-skin="nob">
			  <colgroup>
			    <col width="100">
			    <col width="50">
			    <col width="50">
			    <col width="200">
			    <col width="150">
			  </colgroup>
			  <thead>
			   
			    <tr>
			      <th>订单编号</th>
			      <th>用户名</th>
			      <th>总金额</th> 
			      <th>收获地址</th>
			      <th>支付状态</th>
			      
			    </tr> 
			    
			  </thead>
			  <tbody>
    

    <c:forEach items="${orders}" var="item">
			    <tr>
			      <td>${item.ordernum}</td>
			      <td>${user.username}</td>
			      <td>￥${item.totalmoney}</td>
			      <td>${item.address}</td>
			      <c:if test="${item.status==2}">
				  <td><button type="button" class="layui-btn layui-btn-disabled">已付款</button></td>
					 </c:if>
				   <c:if test="${item.status==1}">
				  <td><a href="submitorder?orderNum=${item.ordernum}&total=${item.totalmoney}" class="layui-btn layui-btn-danger">去付款</a></td>
					 </c:if>	
			     
			    </tr>
			    </c:forEach>
		  </tbody>
		</table>
		 </div>
      
    </div>
  </div>

<script type="text/javascript">
  layui.config({
    base: ' res/static/js/util/' //你存放新模块的目录，注意，不是layui的模块目录
  }).use(['mm','jquery','element','car'],function(){
    var mm = layui.mm,$ = layui.$,element = layui.element,car = layui.car;
    
    // 模版导入数据
    // var html = demo.innerHTML,
    // listCont = document.getElementById('list-cont');
    // mm.request({
    //   url: ' json/shopcart.json',
    //   success : function(res){
    //     listCont.innerHTML = mm.renderHtml(html,res)
    //     element.render();
    //     car.init()
    //   },
    //   error: function(res){
    //     console.log(res);
    //   }
    // })
    // 
    car.init()


});
</script>
</body>
</html>