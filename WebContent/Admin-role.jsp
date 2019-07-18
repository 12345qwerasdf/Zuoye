<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.lanqiao.store.model.*"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>角色管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 管理员管理 <span class="c-gray en">&gt;</span> 角色管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="cl pd-5 bg-1 bk-gray"> <span class="l">  <a class="btn btn-primary radius" href="Member-add.jsp" ><i class="Hui-iconfont">&#xe600;</i> 添加角色</a> </span> 
	<table class="table table-border table-bordered table-hover table-bg">
		<thead>
			<tr>
				<th scope="col" colspan="6">用户管理</th>
			</tr>
			<tr class="text-c">				
								<th>ID</th>
								<th>用户名</th>
								<th>性别</th>
								<th>密码</th>								
								<th>电话</th>
								<th>地址</th>
								<th>操作</th>
				
			</tr>
			<%
						List users= (List)request.getAttribute("users");
					%>
		</thead>
		<tbody>
			<%
				if(users!=null){
				for(int i=0;i<users.size();i++){
					 User user = (User)users.get(i);
			%>
			<tr class="text-c">
				<td><%=user.getId() %></td>
				<td><%=user.getUsername() %></td>
				<td><%=user.getSex() %></td>
				<td><%=user.getPassword() %></td>
				<td><%=user.getPhone()%></td>
				<td><%=user.getAddress() %></td>
				<td class="f-14"><a title="编辑" href="updateadmin1?u_id=<%=user.getId() %>" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a> <a title="删除" href="javascript:;" onclick="delemp('<%=user.getId() %>')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
			</tr>
		
				<%	
							}
							}
							%>
		</tbody>
	</table>
	<%
				Integer cp = (Integer)request.getAttribute("cp");
			%>
				<a href="adminsearch?cp=<%=cp-1%>">上一页</a>&nbsp;&nbsp;
				<a href="adminsearch?cp=<%=cp+1%>">下一页</a>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript">
function delemp(u_id){
	
	var flag = window.confirm("是否确定删除");
	
	if(flag){
		
		window.location.href="admindelete001?u_id="+u_id;
	
	}
	
}

</script>
</body>
</html>