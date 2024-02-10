<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.util.*" %>
    <%@ page import = "com.servlet.encapsulatedclass.Carsentity" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<style>
body {
  background-image: url('https://wallpapers.com/images/hd/black-mercedes-benz-commercial-vehicle-hd-228w1b7em83au8ca.jpg');
   background-repeat: no-repeat;
  background-attachment: fixed;
  background-position:center bottom;
  background-size: cover;
}
</style>
<h2>The details in your database are as follows</h2>
<table>
<%
Object obj=session.getAttribute("Details");
if (obj==null){
	out.print("No records found:");
}else{
	List<Carsentity> entity=(ArrayList<Carsentity>)obj;

%>
<tr>
<th>modelname:</th><th>variant:</tr><th>price:</th><th>topspeed:</th><th>fueltype:</th></tr>
<%
for (Carsentity c:entity){
%>
<tr><td><%=c.getModelname() %></td><td><%=c.getVariant() %></td><td><%=c.getPrice() %></td><td><%=c.getTopspeed() %></td>
<td><%=c.getFueltype() %></td></tr>
<%} } %>

<tr><td><button><a href="Index.html">Back to homepage</button>
</table>
</body>
</html>