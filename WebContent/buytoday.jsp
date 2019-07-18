<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Document</title>
  <link rel="stylesheet" type="text/css" href="res/static/css/main.css">
  <link rel="stylesheet" type="text/css" href="res/layui/css/layui.css">
  <link rel="stylesheet" type="text/css" href="res/layui/css/bootstrap.min.css">
  <script type="text/javascript" src="res/layui/layui.js"></script>
  <script type="text/javascript" src="res/layui/jquery-2.2.3.min.js"></script>
  <script type="text/javascript" src="res/layui/bootstrap.min.js"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
</head>
<body>

  <div class="site-nav-bg">
    <div class="site-nav w1200">
      <p class="sn-back-home">
       <!--  <i class="layui-icon layui-icon-home"></i> -->
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
            <img src="res/static/img/lo.png">
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


  <div class="content content-nav-base buytoday-content">
  
   
  
    <!-- <div id="list-cont"> -->
      <div class="main-nav">
        <div class="inner-cont0">
          <div class="inner-cont1 w1200">
            <div class="inner-cont2">
              <a href="search" style="margin-left:-170px;">所有商品</a>
              <a style="margin-left:-40px;" href="buytoday?act=display" class="active">今日团购</a>
             <a href="showorder">订单查询</a>
            </div>
          </div>
        </div>
      </div>
      <div class="banner-box">
       <div class="banner"></div> 
       <!-- <div >
       <img  alt="" src="res/static/img/timg6.jpg" style=" height:380px;width:100%;background-size: cover; cursor: pointer;" >
       </div> -->
      </div>
      <div class="product-list-box">
        <div class="product-list w1200">  
          <div class="tab-title">
            <a href="javascript:;" class="active tuang" data-content="tuangou" style="text-decoration: none">今日团购</a>
           
          </div>
          <div class="list-cont" cont = 'tuangou'>
            <div class="item-box layui-clear">
            
            <c:forEach items="${Computer }" var="list" varStatus="status">
              <div class="item">
              <a href="details?id=${list.cid }&price=${list.price*list.discount/10 }" style="text-decoration: none">
                <img src="${list.gif }" alt="" width="290px" height="330px">
                <div class="text-box">
                  <p class="title">${list.cname }</p>
                  <p class="plic">
                    <span class="ciur-pic">￥${list.price*list.discount/10 }</span>
                    <span class="Ori-pic">￥${list.price }</span>
                    <span class="discount">${list.discount }折</span>/
                  </p>
                </div>
              </a>
              </div>  
             </c:forEach>           
            </div>
            <!-- <div id="demo0" style="text-align: center;"></div> -->
            <div >
		  	 	<ul class="pagination">
		  	 		<li <c:if test="${cp eq 1 }"> class="disabled" </c:if>>
		  	 			<a href="buytoday?act=display&cp=${cp>1?cp-1:cp }">上一页</a>
		  	 		</li>
		  	 		<c:forEach begin="1" end="${totalPage }" step="1" var="item">		  	 		
		  	 			<li <c:if test="${cp==item }"> class="active" </c:if>>
		  	 				<a href="buytoday?act=display&cp=${item }">${item }</a>
		  	 			</li>
		  	 		</c:forEach>
		  	 		<li <c:if test="${cp eq totalPage }"> class="disabled" </c:if>>
		  	 			<a href="buytoday?act=display&cp=${cp+1>totalPage?totalPage:cp+1 }">下一页</a>
		  	 		</li>
		  	 	</ul>    
		  	 </div>
          </div>

		</div>  
      </div>
      <div class="footer-wrap">
        <div class="footer w1200">
          <div class="title">
            <h3>团购销量榜</h3>
          </div>
          <div class="list-box layui-clear" id="footerList">
          
          <c:forEach items="${ListRank }" var="sell" varStatus="status">
            <div class="item">
             
              <img src="${sell.gif }" alt="" width="320px" height="380px">
              <div class="text">
                <div class="right-title-number">${status.index+1 }</div>
                <div class="commod">
                  <p>${sell.cname }</p>
                  <span>￥${sell.price }</span>
                </div>
              </div>
            </div>
          </c:forEach>  
          </div>
        </div>
      </div>
    <!-- </div> -->
  </div>
  
  <div class="footer">
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
  

  
<script>

  layui.config({
    base: ' resource/res/static/js/util/' //你存放新模块的目录，注意，不是layui的模块目录
  }).use(['mm','laypage','jquery'],function(){
      var laypage = layui.laypage,$ = layui.$;
     mm = layui.mm;
    


      $('body').on('click','*[data-content]',function(){
        $(this).addClass('active').siblings().removeClass('active')
        var dataConte = $(this).attr('data-content');
        $('*[cont]').each(function(i,item){
          var itemCont = $(item).attr('cont');
          console.log(item)
          if(dataConte === itemCont){
            $(item).removeClass('layui-hide');
          }else{
            $(item).addClass('layui-hide');
          }
        })
      })
    // 模版引擎导入
    //  var html = demo.innerHTML;
    //  var listCont = document.getElementById('list-cont');
    //  // console.log(layui.router("#/about.html"))
    // mm.request({
    //     url: ' json/buytoday.json',
    //     success : function(res){
    //       console.log(res)
    //       listCont.innerHTML = mm.renderHtml(html,res)
    //     },
    //     error: function(res){
    //       console.log(res);
    //     }
    //   })

});
</script>


</body>
</html>