<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <jsp:include page="/views/page/header.jsp"/>
    <title>Đăng nhập</title>
    <style>
        body {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    background-image: url("${pageContext.request.contextPath}/img/bg.jpg");
    background-size: cover;
    background-position: center;
}
.login-container {
    background: rgba(255, 255, 255, 0.9);
    padding: 2rem;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    max-width: 400px;
    width: 100%;
}
.form-control:focus {
    box-shadow: none;
    border-color: #4CAF50;
}
.btn-primary {
    background-color: #4CAF50;
    border-color: #4CAF50;
}
.btn-primary:hover {
    background-color: #45A049;
    border-color: #45A049;
}
.forgot-password {
    margin-top: 10px;
    text-align: center;
}
    </style>
</head>

<body>
    <div class="login-container">
        <h2 class="text-center">Đăng Nhập</h2>
        <form>
            <div class="mb-3">
                <label for="username" class="form-label">Tên đăng nhập</label>
                <input type="text" class="form-control" id="username" placeholder="Tên đăng nhập">
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Mật khẩu</label>
                <input type="password" class="form-control" id="password" placeholder="Mật khẩu">
            </div>
            <button type="submit" class="btn btn-primary w-100">Đăng Nhập</button>
        </form>
        <div class="forgot-password">
            <a href="#">Quên mật khẩu?</a>
        </div>
    </div>

    <jsp:include page="/views/page/footer.jsp"/>
    <script src="https://kit.fontawesome.com/b6b15d6477.js" crossorigin="anonymous"></script>
</body>

</html>