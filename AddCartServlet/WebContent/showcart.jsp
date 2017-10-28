<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>JLC Book Store</h1>
<h2>Book Search</h2>
</center>
<%
		Object obj = request.getAttribute("MGS");
	 if(obj != null){%>
	<br />
	<center>
		<font color="red" size="6"><%=obj%></font> <br /> <a href="index.jsp"><h2>Go
				To Search Page</h2></a>
	</center>
	<% 
	}
	else{
		obj = session.getAttribute("CART");
		ArrayList<String> blist = (ArrayList<String>)obj;
		for(String bnm : blist){
	%>
	<form action="removefromcart.jlc" method="post">
		<input type="hidden" name="bname" value="<%= bnm %>" /> <font
			size="5"><%= bnm %><input type="submit" value="Remove From Cart" /></font>
	</form>
	<%	} %>
	<br/>
	<center><a href = "placeholder.jsp">Place Holder</a></center>
	<%	} %>
	<center><a href = "showbooks.jsp">Add To cart</a></center>
</body>
</html>