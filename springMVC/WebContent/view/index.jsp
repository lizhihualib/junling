<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		
		$("#loginBtn").click(function(){
			$.ajax({
				url:"${pageContext.request.contextPath }/spring/login4.do",
				type:"post",
				dataType:"json",
				data:$("#loginForm").serialize(),
				success:function(logins){
					$.each(logins.list,function(index,login){
						alert(login.id+"  "+login.name+"  "+login.pwd);
					})
					//alert(login.id+"  "+login.name+"  "+login.pwd);
					location.href="${pageContext.request.contextPath }/spring/toMain.do"
				},
				error:function(error){
					alert("error"+error)
				}
			})
		})
		
	})

</script>
</head>
<body>
${username}${pwd}
	<form id="loginForm" action="${pageContext.request.contextPath }/spring/login.do" method="post">
		<label>id</label><input name="id" id="id"><br>
		<label>姓名</label><input name="name" id="name"><br>
		<label>密码</label><input name="pwd" id="pwd"><br>
		<label>验证码</label><input name="checkcode" id="checkcode"><br>
		<input type="button" value="登录" id="loginBtn">
	</form>
</body>
</html>