<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script type="text/javascript">
	
	

</script>
</head>
<body>

	<form id="loginForm" action="${pageContext.request.contextPath }/upload/uploadFile.do" method="post"
	enctype="multipart/form-data">
		<label>头像</label><input type="file" name="file" id="file"><br>
		<label>姓名</label><input name="name" id="name"><br>
		<input type="submit" value="上传" id="loginBtn">
	</form>
	<form action="${pageContext.request.contextPath }/upload/downLoad.do">
		<img alt="衣服" src="${pageContext.request.contextPath }/upload/yifu.jpg">
		<input name="filePath" value="/upload/yifu.jpg" type="hidden">
		<input type="submit" value="下载">
	</form>
</body>
</html>