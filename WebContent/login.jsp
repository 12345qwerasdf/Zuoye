<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Document</title>
  <link rel="stylesheet" type="text/css" href=" res/static/css/main.css">
  <link rel="stylesheet" type="text/css" href=" res/layui/css/layui.css">
  <script type="text/javascript" src=" res/layui/layui.js"></script>
   <script type="text/javascript" src=" res/static/js/jquery-2.2.3.js"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
</head>
<body>

  <div class="site-nav-bg">
    <div class="site-nav w1200">
      <p class="sn-back-home">
        <!-- <i class="layui-icon layui-icon-home"></i>
        <a href="login.jsp">首页</a> -->
      </p>
      <div class="sn-quick-menu">
   
       <div class="login"><a href="login1.jsp">后台登录</a></div>
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
          <form action="search" class="layui-form" novalidate>
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


  <div class="content content-nav-base  login-content">
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
    <div class="login-bg">
      <div class="login-cont w1200">
        <div class="form-box">
          <form class="layui-form" action="login" method="post" onsubmit="return checkInfo()">
            <legend>用户登录</legend>
            <div class="layui-form-item">
              <div class="layui-inline iphone">
                <div class="layui-input-inline">
                   <i class="layui-icon layui-icon-username iphone-icon"></i>
                  <input type="tel" name="username" onblur="checkUsername()" id="username" lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
                </div>
              </div>
              <div class="layui-inline iphone">
                <div class="layui-input-inline">
                 <i class="layui-icon layui-icon-snowflake iphone-icon"></i>
                  <input id="password" onblur="checkPassword()" type="password" name="password" lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
                  <!-- <input type="button" class="layui-btn" id="find"  value="验证码" />  -->
                </div>
              </div>
            </div>
            <div class="layui-form-item login-btn">
              <div class="layui-input-block">
                <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1" >登录</button>
               
              </div>
              <div class="layui-input-block">
              	<a href="register.jsp"><button type="button" class="layui-btn" id="" >注册</button></a>
                <!-- <button type="button" class="layui-btn" id="zhuce" >注册</button> -->
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
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
        <a href="javascript:;">母婴资讯</a>
        <span>|</span>
        <a href="javascript:;">关于货源</a>
      </p>
      <p class="coty">母婴商城版权所有 &copy; 2012-2020</p>
    </div>
  </div>
 <script type="text/javascript">
	
 function checkUsername(){
		var username = $("#username").val();
		if(username.trim().length == 0){
			alert("用户名不能为空");
		
			//$("#errorMessage").html("用户名不能为空");
		}else{
			//$("#errorMessage").html("");
		}
		
	}
	
	
	function checkPassword(){
		var password = $("#password").val();
		password = password.trim();
		if(password.length < 6 || password.length >16){
			alert("密码必须在6-16位之间");
		}
	}
	
	function checkInfo(){
		var username = $("#username").val();
		if(username.trim().length == 0){
			alert("用户名不能为空");
			return false;
		}
		var password = $("#password").val();
		password = password.trim();
		if(password.length < 6 || password.length >16){
			alert("密码必须在6-16位之间");
			return false;
		}
		return true;
	}
 
 
 
 </script>
</body>
</html>