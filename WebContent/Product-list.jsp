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
<title>电脑</title>
<link rel="stylesheet" href="lib/zTree/v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
</head>
<body class="pos-r">

<div style="margin-left:200px;">
	<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 产品管理 <span class="c-gray en">&gt;</span> 产品列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
	<div class="page-container">
	
			<input type="text" name="cid" id="cid01" placeholder=" 产品id" style="width:250px" class="input-text">
			<button  onclick="seach()" name="" id="" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜产品</button>
		</div>
		<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"> <a class="btn btn-primary radius" onclick="product_add('添加产品','http://localhost/XinaMu/Product_add.jsp')" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加产品</a></span> <span class="r"></div>
		<div class="mt-20">
			<table class="table table-border table-bordered table-bg table-hover table-sort">
				<thead>
					<tr class="text-c">
						
								<th>C_ID</th>
								<th>Cname</th>
								<th>Color</th>
								<th>Cpu</th>
								<th>Gra</th>								
								<th>Price</th>
								<th>Inventory</th>
								<th>Sell</th>
								<th>Mold</th>
								<th>操作</th>
					</tr>
					<%
						List computers = (List)request.getAttribute("computers");
					%>
				</thead>
				<tbody>
					<%
						if(computers!=null){
						for(int i=0;i<computers.size();i++){
							  Computer computer = (Computer)computers.get(i);
					%>
					<tr class="text-c va-m">
						<td><%=computer.getCid() %></td>
						<td><%=computer.getCname() %></td>
						<td><%=computer.getColor() %></td>
						<td><%=computer.getCpu() %></td>
						<td><%=computer.getGra() %></td>
						<td><%=computer.getPrice() %></td>
						<td><%=computer.getInventory()%></td>
						<td><%=computer.getSell()  %></td>
						<td><%=computer.getMold()  %></td>
						<td>
							
							<a onclick="delemp('<%=computer.getCid() %>')" class="btn btn-danger">删除</a>
							<a href="toupdate?c_id=<%=computer.getCid() %>" class="btn btn-danger">修改</a>
						</td>
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
				<a href="search01?cp=<%=cp-1%>">上一页</a>&nbsp;&nbsp;
				<a href="search01?cp=<%=cp+1%>">下一页</a>
		</div>
	</div>
</div>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
		function delemp(c_id){
			
			var flag = window.confirm("是否确定删除");
			
			if(flag){
				
				window.location.href="delete?c_id="+c_id;
			
			}
			
		}	
		function product_add(add){
			
			
				
				window.location.href="http://localhost/XinaMu/Product_add.jsp";
			
			
			
		}	
		function seach(){
			
			var cid1=document.getElementById("cid01").value; 
			
			window.location.href="search01?cid="+cid1;
		}
	
	</script>
</body>
</html>