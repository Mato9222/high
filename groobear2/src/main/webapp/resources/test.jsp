<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		File file = new File("c://");
		File[] files = file.listFiles();
		for(File f: files)
		{
			out.println(f.getAbsolutePath()+"<br/>");
		}
	
	%>
</body>
</html>