<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="javax.servlet.ServletContext,java.util.Map,com.lanqiao.store.model.Shopcart"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

application.removeAttribute("user");
request.getSession().removeAttribute("user");
/* request.getSession().removeAttribute("cart");
request.getSession().removeAttribute("details");
request.getSession().removeAttribute("shopcart");
 */
response.sendRedirect("search"); %>
</body>
</html>