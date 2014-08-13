<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
	
	String serverPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort(); 
			
	pageContext.setAttribute("basePath", basePath);
	pageContext.setAttribute("serverPath", serverPath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<style type="text/css">
	body{
		margin:0;
	}
	</style>
	
	<script type="text/javascript" src="${basePath}/resources/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="${basePath}/resources/js/jquery-ui-1.10.4.min.js"></script>
	<link rel="stylesheet" href="${basePath}/resources/css/jquery-ui-1.10.4.min.css"></link>
	