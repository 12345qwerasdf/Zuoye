<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.lanqiao.store.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
        <!-- <i class="layui-icon layui-icon-home"></i>
        <a href="#">首页</a> -->
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
        <div class="mallSearch">
          <form action="" class="layui-form" novalidate>
            <input type="text" name="title" required  lay-verify="required" autocomplete="off" class="layui-input" placeholder="请输入需要的商品">
            <button class="layui-btn" lay-submit lay-filter="formDemo">
                <i class="layui-icon layui-icon-search"></i>
            </button>
            <input type="hidden" name="" value="">
          </form>
        </div>
      </div>
    </div>
  </div>


  <div class="content content-nav-base datails-content">
    <div class="main-nav">
      <div class="inner-cont0">
        <div class="inner-cont1 w1200">
          <div class="inner-cont2">
            <a href="search" class="active">所有商品</a>
            <a href="buytoday">今日团购</a>
            <a href="showorder">订单查询</a>
            <!-- <a href="information.html">母婴资讯</a>
            <a href="about.html">关于我们</a> -->
          </div>
        </div>
      </div>
    </div>
    <div class="data-cont-wrap w1200">
      <div class="crumb">
        <a href="login.jsp">首页</a>
        <span>></span>
        <a href="search">所有商品</a>
        <span>></span>
        <a href="javascript:;">产品详情</a>
      </div>
      
      <div class="product-intro layui-clear">
        <div class="preview-wrap">
          <a href="javascript:;"><img src="${ item.gif }"></a>
        </div>
        <div class="itemInfo-wrap">
          <div class="itemInfo">
            <div class="title">
              
              <h4>${ item.cname }</h4>
            </div>
            <div class="summary">  <!-- list.price*list.discount/10  -->
              <p class="activity"><span>价格</span><strong class="price">￥${ item.price}</strong></p>
              <p class="address-box"><span>送至</span><strong class="address">江西&nbsp;&nbsp;南昌&nbsp;&nbsp;东湖区</strong></p>
              <p><span>库存</span><strong style="font-size:20px">${ item.inventory}</strong></p>
              <p><span>销量</span><strong style="font-size:20px">${ item.sell}</strong></p>
            </div>
            <div class="choose-attrs">
              <div class="color layui-clear"><span class="title">颜&nbsp;&nbsp;&nbsp;&nbsp;色</span> <div class="color-cont">${item.color}</div>
            <!--   <div class="number layui-clear"><span class="title">数&nbsp;&nbsp;&nbsp;&nbsp;量</span><div class="number-cont"><span class="cut btn">-</span><input name="num" onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" maxlength="4" type=""  value="1"><span class="add btn">+</span></div></div> -->
            </div>
            <div class="choose-btns">
              <a href="shopcart?act=addcart&id=${item.cid}"><button class="layui-btn  layui-btn-danger car-btn"><i class="layui-icon layui-icon-cart-simple"></i>加入购物车</button></a>
            </div>
          </div>
        </div>
      </div>
      
      
      <div class="layui-clear">
        <div class="aside">
          <h4>热销推荐</h4>
          <div class="item-list">
            <div class="item">
              <a href="details?id=9"><img src=" res/static/img/lenovo3.jpg" ></a>
              <p><span>联想(Lenovo)拯救者Y7000P</span><span class="pric">￥6688</span></p>
            </div>
            <div class="item">
             <a href="details?id=13"> <img src=" res/static/img/xiaomi3.jpg"> </a>
              <p><span>小米(MI)Air  </span><span class="pric">￥9563.00</span></p>
            </div>
            <div class="item">
              <a href="details?id=4"><img src=" res/static/img/huawei3.jpg"></a>
              <p><span>华为(HUAWEI)MateBook 13 </span><span class="pric">￥4656.00</span></p>
            </div>
            <div class="item">
              <a href="details?id=12"><img src=" res/static/img/xiaomi2.jpg"></a>
              <p><span> 小米(MI)RedmiBook </span><span class="pric">￥8645.00</span></p>
            </div>
          </div>

        </div>
        <div class="detail">
           <br/> 
          <div class="item">
            <img src=" res/static/img/794.jpg">
          </div>
        </div>
      </div>
    </div>
  </div>
  </div>
  
  
<script type="text/javascript">
  layui.config({
    base: ' res/static/js/util/' //你存放新模块的目录，注意，不是layui的模块目录
  }).use(['mm','jquery'],function(){
      var mm = layui.mm,$ = layui.$;
      var cur = $('.number-cont input').val();
      $('.number-cont .btn').on('click',function(){
        if($(this).hasClass('add')){
          cur++;
         
        }else{
          if(cur > 1){
            cur--;
          }  
        }
        $('.number-cont input').val(cur)
      })
      
  });
</script>

<div class="footer" style="margin-bottom:0px">
    <div class="ng-promise-box">
      <div class="ng-promise w1200">
        <p class="text">
          <a class="icon1" href="javascript:;">7天无理由退换货</a>
          <a class="icon2" href="javascript:;">满99元全场免邮</a>
          <a class="icon3" style="margin-right: 0" href="javascript:;">100%品质保证</a>
        </p>
      </div>
    </div>
    <div class="mod_help w1200">                                     
      <p>
        <a href="javascript:;">关于我们</a>
        <span>|</span>
        <a href="javascript:;">帮助中心</a>
        <span>|</span>
        <a href="javascript:;">售后服务</a>
        <span>|</span>
        <a href="javascript:;">电脑资讯</a>
        <span>|</span>
        <a href="javascript:;">关于货源</a>
      </p>
      <p class="coty">电脑商城版权所有 &copy; 2012-2020 More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
    </div>
  </div>
</body>
</html>