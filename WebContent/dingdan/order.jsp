<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.lanqiao.store.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
        <i class="layui-icon layui-icon-home"></i>
        <a href="commodity.jsp">首页</a>
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
       <!--  <div class="sp-cart"><a href="shopcart.jsp">购物车</a><span>2</span></div> -->
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
            <a href="showorder?id=${user.id}">订单查询</a>
          
          </div>
        </div>
      </div>
    </div>
    <div class="layui-container"style="height: 200px; width:89%; background-color:#e2e2e2 ; margin-top:20px;margin-bottom: 20px; "> 
    	 <div class="layui-inline iphone">
                <div class="layui-input-inline" style="padding: 50px;">
                	<div style="float: left; margin-top: 20px;">
                		<i class="layui-icon layui-icon-location iphone-icon"  style="font-size: 50px; color: #FF5722;" ></i>
                	</div>
               
               <div id="" style="float: right; margin-left: 20px;">
               	
               
               <p style="font-size: 25px;">${user.username}</p></br><h4>${user.phone}</h4>
               <p style="font-size: 10px;">${user.address }</p>
               </div>
                </div>
              </div>
    </div>

    <div class="cart w1200">
      <div class="cart-table-th">
        <div class="th th-chk">
          <div class="select-all">
            <div class="cart-checkbox">
              <input class="check-all check" id="allCheckked" type="hidden" value="true">
            </div>
          <label style="font: 20px;">&nbsp;确认订单</label>
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
            配送方式
          </div>
        </div>  
      </div>
      <div class="OrderList">
        <div class="order-content" id="list-cont">
       <c:forEach items="${list1}" var="item">
          <ul class="item-content layui-clear">
            <li class="th th-chk">
              <div class="select-all">
                <div class="cart-checkbox">
                  <input class="CheckBoxShop check" id="" type="hidden" num="all" name="select-all" value="true">
                </div>
              </div>
            </li>
            <li class="th th-item">
              <div class="item-cont">
                <a href="javascript:;"><img src="${item.gif }" alt=""></a>
                <div class="text">
                  <div class="title">${item.cname}</div>
                  <p><span>黑色</span>  <span>130</span>cm</p>
                </div>
              </div>
            </li>
            <li class="th th-price">
              <span class="th-su">${item.price}</span>
            </li>
            <li class="th th-amount">
              <div class="box-btn layui-clear">
                <!--<div class="less layui-btn">-</div>-->
                <input class="Quantity-input" type="" name="" value="${item.num}" disabled="disabled">
                <!--<div class="add layui-btn">+</div>-->
              </div>
            </li>
            <li class="th th-sum">
              <span class="sum">${item.price*item.num}</span>
            </li>
            <li class="th th-op">
              <span class="dele-btn">普通配送</span>
            </li>
          </ul>
          </c:forEach>
          <!-- <ul class="item-content layui-clear">
            <li class="th th-chk">
              <div class="select-all">
                <div class="cart-checkbox">
                  <input class="CheckBoxShop check" id="" type="hidden" num="all" name="select-all" value="true">
                </div>
              </div>
            </li>
            <li class="th th-item">
              <div class="item-cont">
                <a href="javascript:;"><img src=" res/static/img/paging_img2.jpg" alt=""></a>
                <div class="text">
                  <div class="title">宝宝T恤棉质小衫</div>
                  <p><span>粉色</span>  <span>130</span>cm</p>
                </div>
              </div>
            </li>
            <li class="th th-price">
              <span class="th-su">189.00</span>
            </li>
            <li class="th th-amount">
              <div class="box-btn layui-clear">
              
                <input class="Quantity-input" type="" name="" value="1" disabled="disabled">
              
              </div>
            </li>
            <li class="th th-sum">
              <span class="sum">189.00</span>
            </li>
            <li class="th th-op">
              <span class="dele-btn">普通配送</span>
            </li>
          </ul> -->
          
        </div>
      </div>


      <div class="FloatBarHolder layui-clear">
        <div class="th th-chk">
          <div class="select-all">
            <div class="cart-checkbox">
              <input class="check-all check" id="" name="select-all" type="hidden"  value="true">
            </div>
            <% 
            int num=0;
            double total=0;
            List<Shopcart> list1=(List)request.getAttribute("list1");
            for(Shopcart l:list1){
            	num+=l.getNum();
            	double s=Double.parseDouble(l.getPrice());
            	total+=s*l.getNum();
            	
            }
            %>
            <label>&nbsp;&nbsp;已选<span class="Selected-pieces"></span><%=num %>件</label>
             
          </div>
        </div>
        <!--<div class="th batch-deletion">
          <span class="batch-dele-btn">批量删除</span>
        </div>-->
        <div class="th Settlement">
        <form action="submitorder?total=<%=total%>" method="post">
       <button class="layui-btn" type="submit">提交订单</button> 
        </form>
        
         <%--  <a href="submitorder?total=<%=total%>"><button class="layui-btn">提交订单</button></a> --%>
        </div>
        <div class="th total">
          <p>应付：<span class="pieces-total"><%=total %></span></p>
        </div>
      </div>
      


      
    </div>
  </div>

<!-- <script type="text/javascript">
  layui.config({
    base: ' res/static/js/util/' //你存放新模块的目录，注意，不是layui的模块目录
  }).use(['mm','jquery','element','car'],function(){
    var mm = layui.mm,$ = layui.$,element = layui.element,car = layui.car;
    
    
    car.init()


});
</script> -->
</body>
</html>