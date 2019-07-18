<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Document</title>
  <script type="text/javascript" src="res/static/js/jquery-1.8.3.js"></script>
  <link rel="stylesheet" type="text/css" href=" res/static/css/main.css">
  <link rel="stylesheet" type="text/css" href=" res/layui/css/layui.css">
  <script type="text/javascript" src=" res/layui/layui.js"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
</head>
<!-- <script type="text/javascript">
		$(function(){
		function sub(){
		$.ajax({
		url:"shopupdate",
			data:{"val":'sub',"id":${shopcart.id}},
			type:"post",
			dataType :"text",
			success :function(result){//
				//alert(result);
			},
			error:function(){
				alert("请求失败");
			}
		}
		})
		})
		
</script>
 -->
<body>

  <div class="site-nav-bg">
    <div class="site-nav w1200">
      <p class="sn-back-home">
      
        <!-- <a href="#">首页</a> -->
      </p>
      <div class="sn-quick-menu">
        <div class="login">
        <c:choose>
			<c:when test="${user == null }">
			<!-- 顶部未登录 -->
			<a href="login.jsp">登陆</a>
			</c:when>
			<c:otherwise>
			<!-- 顶部已登录 -->
			欢迎:<strong>${user.username }</a>
			
			 | <a href="logout">退出</a>
			</c:otherwise>
		</c:choose>
        </div>
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
       <!--  <div class="mallSearch">
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
             <a href="showorder">订单查询</a>
            <!--  <a href="showorder">订单查询</a> -->
           
          </div>
        </div>
      </div>
    </div>
   
    <div class="cart w1200">
      <div class="cart-table-th">
        <div class="th th-chk">
          <div class="select-all">
            <div class="cart-checkbox">
              <input class="check-all check" id="allCheckked" type="checkbox" >
            </div>
          <label>&nbsp;&nbsp;全选</label>
          </div>
        </div>
        <div class="th th-item">
          <div class="th-inner">
            商品
          </div>
        </div>
        <div class="th th-price">
          <div class="th-inner">
            单价
          </div>
        </div>
        <div class="th th-amount">
          <div class="th-inner">
            数量
          </div>
        </div>
        <div class="th th-sum">
          <div class="th-inner">
            小计
          </div>
        </div>
        <div class="th th-op">
          <div class="th-inner">
            操作
          </div>
        </div>  
      </div>
      <form id="form1" action="order" method="post">
      <div class="OrderList">
        <div class="order-content" id="list-cont">
           <!-- session -->
         <c:forEach items="${shopcart}" var="shopcart">
          		<ul class="item-content layui-clear">
            <li class="th th-chk">
              <div class="select-all">
                <div class="cart-checkbox">
                  <input class="CheckBoxShop check" id="" type="checkbox" num="all" name="select-all" value="true">
                </div>
              </div>
            </li>
            <li class="th th-item">
              <div class="item-cont">
                 <a href="javascript:;"><img src=" ${shopcart.value.gif }" alt=""></a> 
                <div class="text">
                  <div class="title">${shopcart.value.cname }</div>
                 <!--  <p><span>粉色</span>  <span>130</span>cm</p> -->
                </div>
              </div>
            </li>
            <li class="th th-price">
              <span class="th-su">${shopcart.value.price }</span>
            </li>
            <li class="th th-amount">
              <div class="box-btn layui-clear">
             <%--  <a href="shopupdate?var=sub&id=${shopcart.id}">-</a>
             <a href="shopupdate?var=add&id=${shopcart.id }">+</a>
              --%>
                <div class="less layui-btn"><a href="shopupdate?var=sub&id=${shopcart.value.cid}">-</a></div>
                <input class="Quantity-input" type="" name="" value="${shopcart.value.num }" disabled="disabled">
                <div class="add layui-btn"><a href="shopupdate?var=add&id=${shopcart.value.cid}">+</a></div>
              </div>
            </li>
            <li class="th th-sum">
              <span class="sum"> ${shopcart.value.price*shopcart.value.num } </span>
            </li>
            <li class="th th-op">
               <a href="shopcart?act=delete&id=${shopcart.value.cid}"><span class="dele-btn" >删除</span></a>
            </li>
          </ul>
          
          </c:forEach>
        
        
          
          
          
          <c:forEach items="${list}" var="shopcart">
         
          		<ul class="item-content layui-clear">
            <li class="th th-chk">
              <div class="select-all">
                <div class="cart-checkbox">
                  <input class="CheckBoxShop check" id="" type="checkbox"  name="select-all" value="${shopcart.id }">
                </div>
              </div>
            </li>
            <li class="th th-item">
              <div class="item-cont">
                <a href="javascript:;"><img src=" ${shopcart.gif }" alt=""></a>
                <div class="text">
                  <div class="title">${shopcart.cname }</div>
                 <!--  <p><span>粉色</span>  <span>130</span>cm</p> -->
                </div>
              </div>
            </li>
            <li class="th th-price">
              <span class="th-su">${shopcart.price }</span>
            </li>
            <li class="th th-amount">
              <div class="box-btn layui-clear">
              <!-- href="shopupdate?var=sub&id=${shopcart.id } -->
                <div class="less layui-btn"> <a href="shopupdate?var=sub&id=${shopcart.id}&act=look">-</a></div>
                <input class="Quantity-input" type="" name="" value="${shopcart.num }" disabled="disabled">
                <div class="add layui-btn"><a href="shopupdate?var=add&id=${shopcart.id}&act=look">+</a></div>
              </div>
            </li>
            <li class="th th-sum">
              <span class="sum">${shopcart.count }</span>
            </li>
            <li class="th th-op">
               <a href="shopcart?act=delete&id=${shopcart.id}"><span class="dele-btn" >删除</span></a>
            </li>
          </ul>
          
         
          
          
   </c:forEach>
        </div>
      </div>
</form>


      <div class="FloatBarHolder layui-clear">
        <div class="th th-chk">
          <div class="select-all">
            <div class="cart-checkbox">
              <input class="check-all check" id="" name="selectall" type="checkbox"  value="true">
            </div>
            <label>&nbsp;&nbsp;已选<span class="Selected-pieces">0</span>件</label>
          </div>
        </div>
        <div class="th batch-deletion">
          <span class="batch-dele-btn">批量删除</span>
        </div>
        <div class="th Settlement">
          <button class="layui-btn" onclick="addClick()">添加订单</button>
        </div>
        <div class="th total">
          <p>应付：<span id="total" class="pieces-total">0</span></p>
        </div>
      </div>
    </div>
  </div>
<!-- <input type="button" value="提交" onclick="document.getElementById('form1').submit();"> -->

<!-- <script type="text/javascript">
if ($("input[type='checkbox']").attr('checked')) {
    // do something
} -->


<script type="text/javascript">
		var zhi 
		function addClick(){ 
		var total=$("#total").html().substr(1);
		$(document).ready(function(){
		var idsstr = " ";
		var zhi = " ";
		$("input[name='select-all']").each(function(){ //遍历table里的全部checkbox 
		idsstr += $(this).val() + ","; //获取所有checkbox的值
		if($(this).attr("checked")) //如果被选中
		zhi += $(this).val() + ","; //获取被选中的值
		});
		if(idsstr.length > 0) //如果获取到
		idsstr = idsstr.substring(0, idsstr.length - 1); //把最后一个逗号去掉
		if(zhi.length > 0) //如果获取到
		zhi = zhi.substring(0, zhi.length - 1); //把最后一个逗号去掉
		document.getElementById('form1').action="order?to="+total+"&zhi="+zhi 
		document.getElementById('form1').submit() 
});
}

</script>



 <script type="text/javascript">
  layui.config({
    base: ' res/static/js/util/' //你存放新模块的目录，注意，不是layui的模块目录
  }).use(['mm','jquery','element','car'],function(){
    var mm = layui.mm,$ = layui.$,element = layui.element,car = layui.car;

    car.init()


});
</script> 
</body>
</html>