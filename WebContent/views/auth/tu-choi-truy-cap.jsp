<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>403 Forbidden - Ultra Instinct</title>
    <style>
        body {
            background: #f5f5f5;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            font-family: Arial, sans-serif;
        }
        .container {
            text-align: center;
            padding: 20px;
            border: 1px solid #ccc;
            background: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
        }
        .container h1 {
            font-size: 3em;
            color: #333;
        }
        .container p {
            font-size: 1.2em;
            color: #666;
            margin: 20px 0;
        }
        .container a {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }
        .container a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Từ chối truy cập 403</h1>
        <p>Bạn không có quyền truy cập vào trang này. Vui lòng kiểm tra quyền hạn của bạn hoặc liên hệ với quản trị viên.</p>
        <a href="${pageContext.request.contextPath}/home">Quay lại trang chủ</a>
    </div>
</body>
</html>
