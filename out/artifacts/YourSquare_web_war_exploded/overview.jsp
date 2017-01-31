<%@page import="java.util.List"%>
<%@page import="model.User"%>
<%@page import="model.Ad"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="utf-8">
	<meta http-equiv="x-ua-compatible" content="ie=edge">
	<title>YourSquare</title>
	<meta name="description" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link rel="icon" href="favicon.ico">
	<!-- Place favicon.ico in the root directory -->

	<link rel="stylesheet" href="css/main.css">
	<link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" >
</head>
<body>
	<%
		User user = (User) session.getAttribute("user") ;
		List<Ad> adList = (List<Ad>) session.getAttribute("ads");
	%>
	<%--<h2><%=user.getName()%> <%=user.getSurname()%></h2>--%>
	<%----%>
	<%--<ol>--%>
		<%--<%for(Ad ad: adList){ %>--%>
		<%--<li>Tytuł: <%=ad.getTitle() %></li>--%>
		<%--<li>Treść: <%=ad.getContent()%></li>--%>
		<%--<li>Cena: <%=ad.getFee()%></li>--%>
		<%--<%}%>--%>
	<%--</ol>--%>
	<%--<a href="finalize" class="fin"></a>--%>

	<img src="img/logo.png" class="logo">

	<div>
		<form action="#" class="login-form">
			<font style="font-family: Proxima Nova Rg" color="white" class="finalize-form-font">Twoje ogłoszenie</font><br>
			<font style="font-family: Proxima Nova Rg" color="white" class="finalize-form-font2">______________________</font>
			<font style="font-family: Proxima Nova Rg" color="white" class="finalize-font0"><%=user.getName()%> <%=user.getSurname()%></font>
			<%for(Ad ad: adList){ %>
			<font style="font-family: Proxima Nova Rg" color="white" class="finalize-font1">
				Tytuł: <%=ad.getTitle() %><br>
				Treść: <%=ad.getContent()%><br>
				Cena: <%=ad.getFee()%></font><br>
			<%}%>
		</form>
	</div>

	<div>
		<a href="finalize" class="fin2"></a>
	</div>

	<footer style="font-family: Proxima Nova Rg" class="footer">©YourSquare | All rights reserved</footer>

</body>
</html>