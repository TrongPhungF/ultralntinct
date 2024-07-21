<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Ultra Instinct</title>
    <jsp:include page="/views/page/header.jsp"/>
    <link rel="stylesheet" href="css/index.css">
    <link rel="shortcut icon" type="image/png" href="img/logo1.png">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        .notification-container {
            background-color: #f2f2f2;
            padding: 20px;
            margin: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        .notification-title {
            font-size: 20px;
            font-weight: bold;
            margin-bottom: 10px;
        }
        .notification-message {
            font-size: 16px;
            margin-bottom: 20px;
        }
        .notification-benefits {
            font-size: 16px;
            margin-bottom: 20px;
        }
        .notification-actions {
            display: flex;
            justify-content: flex-end;
        }
        .notification-actions button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-left: 10px;
        }
        .notification-actions button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="row">
    <jsp:include page="/views/page/nav.jsp"/>
        <div class="col-sm-9 notification-container">
            <div class="notification-title">Bật Thông Báo</div>
            <div class="notification-message">
                Để được thông báo về các sự kiện mới và cập nhật quan trọng, vui lòng bật quyền nhận thông báo cho ứng dụng của chúng tôi.
            </div>
            <div class="notification-benefits">
                Khi bạn bật thông báo, bạn sẽ nhận được:
                <ul>
                    <li>Cập nhật về các tính năng mới</li>
                    <li>Thông báo về sự kiện quan trọng</li>
                    <li>Nhắc nhở về các hạn chót và lịch trình</li>
                    <li>Thông tin về các ưu đãi và khuyến mãi</li>
                </ul>
            </div>
            <div class="notification-actions">
                <button onclick="enableNotifications()">Bật Thông Báo</button>
                <button onclick="dismissNotification()">Bỏ Qua</button>
            </div>
        </div>
    </div>
<jsp:include page="/views/page/footer.jsp"/>
    <script src="https://kit.fontawesome.com/b6b15d6477.js" crossorigin="anonymous"></script>
    <script>
        function enableNotifications() {
            // Code để xử lý khi người dùng nhấn "Bật Thông Báo"
            console.log("Người dùng đã bật thông báo.");
        }

        function dismissNotification() {
            // Code để xử lý khi người dùng nhấn "Bỏ Qua"
            console.log("Người dùng đã bỏ qua thông báo.");
        }
    </script>
</body>
</html>