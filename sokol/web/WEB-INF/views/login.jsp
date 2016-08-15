<%--
  Created by IntelliJ IDEA.
  User: denspbru
  Date: 15.08.16
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <meta name="description" content="">
    <meta name="author" content="">

    <title>Login Page</title>
    <link href="/css/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="/css/signin.css" type="text/css"  rel="stylesheet" />
    <script type="text/javascript" href="/js/jquery-3.1.0.min.js"></script>
    <script type="text/javascript" href="/css/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">

    <form class="form-signin" action="/second">
        <h2 class="form-signin-heading">СОКОЛ</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> Remember me
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Вход</button>
        <a class="btn btn-lg btn-info btn-block" href="/register">Регистрация</a>
    </form>

</div> <!-- /container -->


</body>
</html>
