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
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
</head>
<body>

  <div class="site-nav-bg">
    <div class="site-nav w1200">
      <p class="sn-back-home">
        <i class="layui-icon layui-icon-home"></i>
        <a href="#">首页</a>
      </p>
      <div class="sn-quick-menu">
        <div class="login"><a href="login.jsp">登录</a></div>
       <!--  <div class="login"><a href="login.html">管理中心</a></div>
        <div class="sp-cart"><a href="shopcart?act=look">购物车</a><span>2</span></div> -->
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
          <!--   <a href="information.html">母婴资讯</a>
            <a href="about.html">关于我们</a> -->
          </div>
        </div>
      </div>
    </div>
    <div class="login-bg">
      <div class="login-cont w1200">
      <!-- style="height: 440px; right: 100px;top: 200px;" -->
        <div class="form-box" style="height:510px;" >
        	
        	
          <form class="layui-form" action="register"  >
            <legend>用户注册</legend>
        <div class="layui-inline iphone">
                <div class="layui-input-inline">
                  <i class="layui-icon layui-icon-username iphone-icon"></i>
		            <input id="pnum"  type="text" name="username" lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
		              </div>
              </div>
               <div class="layui-inline iphone">
                <div class="layui-input-inline">
                 <i class="layui-icon layui-icon-snowflake iphone-icon"></i>
		           <input id="pnum" type="password" name="password" lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
		               </div>
              </div>
		            <div class="layui-form-item" >
					    <!-- <label class="layui-form-label">单选框</label> -->
					    <div class="layui-input-block" style="margin-left:0px" >
					   
					   <label class="layui-form-label">性别:</label><input type="radio" name="sex" value="男" title="男">
					   <input  type="radio" name="sex" value="女" title="女" checked>
					    </div>
					  </div>
		         	  <div class="layui-inline iphone">
                <div class="layui-input-inline">
                <i class="layui-icon layui-icon-cellphone-fine iphone-icon"></i>
		         <input id="pnum" type="text" name="phone" lay-verify="required" placeholder="请输入电话" autocomplete="off" class="layui-input">
		           </div>
					  </div>
					    <div class="layui-inline iphone">
				
                <div class="layui-input-inline">
                <i class="layui-icon layui-icon-location iphone-icon"></i>
		            <input id="pnum" type="text" name="address" lay-verify="required" placeholder="请输入收货地址" autocomplete="off" class="layui-input">
	          </div>
					  </div>
            <div class="layui-form-item login-btn">
              <div class="layui-input-block">
                <button class="layui-btn" type="submit" >提交</button>
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
	    	if(username.trim().length == 0) {
	    		alert("用户名不能为空！");
	    	}
	    }
	    function checkPassword(){
	    	/* var password = $("#password").val();
	    	password = password.trim(); */
	    	var password = $("#password").val().trim();
	    	if(password.length< 6 || password.length > 16) {
	    		alert("密码需在6位-16位之间");//弹窗
	    	}
	    }
	    function checkCommit(){
	    	var password = $("#password").val().trim();
	    	var commit = $("#commit").val().trim();
	    	if(password != commit && password.length != 0){
	    		alert("两次输入的密码不一样，请修正！");
	    	}
	    }
	    function checkNickname(){
	    	var nickname = $("#nickname").val();
	    	if(nickname.trim().length == 0) {
	    		alert("昵称不能为空！");
	    	}
	    }
	    function checkEmail(){
	    	var email = $("#email").var().trim();
	    	var reg = /^[a-xA-Z1-9]+@[a-xA-Z0-9]+\.[a-z]+$/;
	    	if(reg.test(email)==false){
	    		alert("邮箱格式有误！");
	    	}
	    }
	    
	    function checkRegisterInfo(){
	    	var username = $("#username").val();
	    	if(username.trim().length == 0) {
	    		alert("用户名不能为空！");
	    		return false;
	    	}
	    	
	    	var password = $("#password").val().trim();
	    	if(password.length < 6 || password.length > 16) {
	    		alert("密码需在6位-16位之间");//弹窗
	    		return false;
	    	}
	    	
	    	var password = $("#password").val().trim();
	    	var commit = $("#commit").val().trim();
	    	if(password != commit && password.length != 0){
	    		alert("两次输入的密码不一样，请修正！");
	    		return false;
	    	}
	    	
	    	var nickname = $("#nickname").val();
	    	if(nickname.trim().length == 0) {
	    		alert("昵称不能为空！");
	    		return false;
	    	}
	    	
	    	var email = $("#email").var().trim();
	    	var reg = /^[a-xA-Z1-9]+@[a-xA-Z0-9]+\.[a-z]+$/;
	    	if(reg.test(email)==false){
	    		alert("邮箱格式有误！");
	    		return false;
	    	}
	    	
	    	return true;
	    }
	</script>
<script>
//Demo
layui.use('form', function(){
  var form = layui.form;
  
  //监听提交
  form.on('submit(formDemo)', function(data){
    layer.msg(JSON.stringify(data.field));
    return false;
  });
});
</script>
</body>
</html>