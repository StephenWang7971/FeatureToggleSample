<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="self-expressive-code"%>   
<%@ page session="false" %>
<html>
<head>
	<%@include file="./base.jsp"%>
	<title>Home</title>
</head>
<body>
<h1>
	<sec:toggle feature="featureA" >
		<a href="${basePath}/featureA">Feature A</a>
	</sec:toggle>
		
		<br>
		
	<sec:toggle feature ="featureB" >
		<a href="${basePath}/featureB">Feature B</a>
	</sec:toggle>
	
		<br>
		
	<sec:toggle feature ="featureC" >
		<a href="${basePath}/featureC">Feature C</a>
	</sec:toggle>
	
		<br>
		
	<sec:toggle feature ="featureD" >
		<a href="${basePath}/featureD">Feature D</a>
	</sec:toggle>
</h1>

</body>
</html>
