<%@ page import="java.util.*"%>
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
		<font color="green" size="6">${ADDED}</font>
	</center>
	<br />
	<%
		Object obj = request.getAttribute("MGS");
	
	if(obj != null){%>
	<br />
	<center>
		<font color="red" size="6"><%=obj%></font> <br /> <a href="index.jsp"><h2>Go
				To Search Page</h2></a>
	</center>
	<% 
	}else {
		obj = session.getAttribute("BOOKS");
		ArrayList<String> blist = (ArrayList<String>)obj;
		for(String bnm : blist){
	%>
	<form action="addtocart.jlc" method="post">
		<input type="hidden" name="bname" value="<%= bnm %>" /> <font
			size="5"><%= bnm %><input type="submit" value="Add To Cart" /></font>
	</form>
	<%	} %>
	<br/>
	<form action="showcart.jlc">
		<input type="submit" value="Show Cart" />
	</form>
	<% } %>
</body>
</html>