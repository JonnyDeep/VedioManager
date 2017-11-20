<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title></title>
	<link rel="stylesheet" type="text/css" href="../css/login.css">
	<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/bootstrap.css" rel="stylesheet">
<script src="../js/jquery-3.1.0.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/login.js"></script>
</head>
<body>
<div class="container">
        <div class="card card-container">
            <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
            <img id="profile-img" class="profile-img-card" src="../images/avatar_2x.png" />
            <p id="profile-name" class="profile-name-card"></p>
            <form class="form-signin" action="login.action" method="post">
                <span id="reauth-email" class="reauth-email"></span>
                <input type="text" id="inputEmail" class="form-control" placeholder="用户名" required autofocus name="user.userName">
                <input type="password" id="inputPassword" class="form-control" placeholder="密码" required name="user.password">
                 <div id="warning" style="display:none">*用户名或密码错误！</div>
                <div id="remember" class="checkbox">
                    <label>
                        <input type="checkbox" value="remember-me"> 记住我
                    </label>
                </div>
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">确&nbsp;定</button>
            </form><!-- /form -->
            <a href="#" class="forgot-password">
                忘记密码
            </a>
    </div><!-- /card-container -->
</div><!-- /container -->
</body>


</html>