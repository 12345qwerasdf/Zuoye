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
        <i class="layui-icon layui-icon-home"></i>
        <a href="index.html">首页</a>
      </p>
      <div class="sn-quick-menu">
        <div class="login"><a href="login.jsp">登录</a></div>
        <div class="sp-cart"><a href="shopcart?act=look">购物车</a><span>2</span></div>
      </div>
    </div>
  </div>



  <div class="header">
    <div class="headerLayout w1200">
      <div class="headerCon">
        <h1 class="mallLogo">
          <a href="#" title="母婴商城">
            <img src=" res/static/img/lo.png">
          </a>
        </h1>
        <div class="mallSearch">
          <form action="search" class="layui-form" novalidate>
            <input type="text"  name="title"  autocomplete="off" class="layui-input" placeholder="请输入需要的商品">
            <button class="layui-btn"  id="search" type="submit">
                <i class="layui-icon layui-icon-search"></i>
            </button>
            <input type="hidden" name="" value="">
          </form>
        </div>
      </div>
    </div>
  </div>


  <div class="content content-nav-base commodity-content">
    <div class="main-nav">
      <div class="inner-cont0">
        <div class="inner-cont1 w1200">
          <div class="inner-cont2">
            <a href="search?brand=all" class="active">所有商品</a>
            <a href="buytoday.html">今日团购</a>
            <a href="information.html">母婴资讯</a>
            <a href="about.html">关于我们</a>
          </div>
        </div>
      </div>
    </div>
    <div class="commod-cont-wrap">
      <div class="commod-cont w1200 layui-clear">
        <div class="left-nav">
          <div class="title">所有分类</div>
          <div class="list-box">
            <dl>
             <dd><a href="search?brand=huawei">华为</a></dd>
             <dd><a href="search?brand=lenovo">联想</a></dd>
             <dd><a href="search?brand=xiaomi">小米</a></dd>
            </dl>
           
            
          </div>
        </div>
        <div class="right-cont-wrap">
          <div class="right-cont">
            <div class="sort layui-clear">
              <a class="active" href="search?arr=sell" id ="sell" event = 'volume'>销量</a>
              <a href="search?arr=price" event = 'price' id="price">价格</a>
             <!--  <a href="search?arr=newprod" event = 'newprod'>新品</a>
              <a href="search?arr=coll" event = 'collection'>收藏</a> -->
            </div>
            <div class="prod-number">
              <span> &nbsp</span>
            </div>
            <div class="cont-list layui-clear" id="list-cont">
            
            	
            	<c:forEach items="${list }" var="item">
            		<div class="item">
		                <div class="img">
		                  <a href="details.jsp"><img src=" ${item.gif } "></a>
		                </div>
		                <div class="text">
		                  <p class="title">${item.cname }</p>
		                  <p class="price">
		                    <span class="pri">￥${item.price }</span>
		                    <span class="nub">已售${item.sell }</span>
		                  </p>
		                </div>
		              </div>
            	</c:forEach>
            
             
            </div>
            
           
            <div id="demo0" style="text-align: center;"></div>
          </div>
        </div>
      </div>
    </div>
  </div>
 
<script>


    layui.config({
    base: ' res/static/js/util/' //你存放新模块的目录，注意，不是layui的模块目录
  }).use(['mm','laypage','jquery'],function(){
      var laypage = layui.laypage,$ = layui.$,
     mm = layui.mm;
       laypage.render({
        elem: 'demo0'
        ,count: 100 //数据总数
      });  

     $('.sort a').on('click',function(){
      $(this).addClass('active').siblings().removeClass('active');
    }) 
     $('.list-box dt').on('click',function(){
      if($(this).attr('off')){
        $(this).removeClass('active').siblings('dd').show()
        $(this).attr('off','')
      }else{
        $(this).addClass('active').siblings('dd').hide()
        $(this).attr('off',true)
      }
    }) 

}); 

</script> 

</body>
</html>