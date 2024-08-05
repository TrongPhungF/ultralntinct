<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="UTF-8">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ultra Instinct</title>
    <jsp:include page="page/header.jsp"/>
    <link rel="stylesheet" href="css/index.css">
    <link rel="shortcut icon" type="image/png" href="img/logo1.png">
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
        }
        .main-content {
            margin-left: 250px;
            padding: 20px;
        }
        .header {
            background-color: #fff;
            padding: 10px 20px;
            display: flex;
            border-radius: 10px;
    width: 1055px;
            margin-left: 20px;
            align-items: center;
            justify-content: space-between;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        .header input[type="search"] {
            padding: 10px;
            width: 1000px;
            border-radius: 25px;
            border: 1px solid #ddd;
            outline: none;
            transition: all 0.3s ease;
        }
        .header input[type="search"]:focus {
            border-color:#198754;
        }
        .header .right-icons {
            display: flex;
            align-items: center;
        }
        .header .right-icons a {
            margin-left: 20px;
            text-decoration: none;
            color: #333;
            transition: color 0.3s ease;
        }
        .header .right-icons a:hover {
            color: #198754;
        }
        .container {
            padding: 20px;
        }
        .stats {
            display: flex;
            justify-content: space-between;
            margin-bottom: 20px;
        }
        .stats .stat {
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            flex: 1;
            margin-right: 20px;
            text-align: center;
            transition: transform 0.3s ease;
        }
        .stats .stat:hover {
            transform: translateY(-5px);
        }
        .stats .stat:last-child {
            margin-right: 0;
        }
        .stats .stat h3 {
            margin: 0;
            font-size: 24px;
        }
        .stats .stat p {
            margin: 5px 0 0;
            color: #198754;
        }
        .cards {
            display: flex;
            justify-content: space-between;
        }
        .card {
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            width: 48%;
            transition: transform 0.3s ease;
        }
        .card:hover {
            transform: translateY(-5px);
        }
        .card-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 10px;
        }
        .card h4 {
            margin: 0;
            color:#198754;
        }
        .card table {
            width: 100%;
            border-collapse: collapse;
        }
        .card table th, .card table td {
            padding: 10px;
            border-bottom: 1px solid #eee;
            text-align: left;
        }
        .card table th {
            background-color: #f5f5f5;
        }
        .card .view-all {
            text-decoration: none;
            color: #198754;
        }
        .view-button {
            background-color:#198754;
            color: white;
            border: none;
            padding: 8px 12px;
            border-radius: 25px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        .view-button:hover {
            background-color: #198754;
        }
        .profile-pic {
            width: 40px;
            height: 40px;
            border-radius: 50%;
        }
    </style>
</head>
<body>
<div class="row">
        <jsp:include page="page/nav.jsp"/>
    <div class="col-9 m-2">
    <div >
        <div class="header">
            <input type="search" placeholder="Search...">
        </div>
        <div class="container">
            <div class="stats">
                <div class="stat">
                    <h3>2194</h3>
                    <p>Customer</p>
                </div>
                <div class="stat">
                    <h3>53</h3>
                    <p>New Customer</p>
                </div>
                <div class="stat">
                    <h3>3435</h3>
                    <p>Products Sold.</p>
                </div>
                <div class="stat">
                    <h3>46,350,000 VND</h3>
                    <p>Income</p>
                </div>
            </div>
            <div class="cards">
                <div class="card">
                    <div class="card-header">
                        <h4>Recent Payments</h4>
                        <a href="#" class="view-all">View All</a>
                    </div>
                    <table>
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Address</th>
                                <th>Amount</th>
                                <th>Option</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>John Doe</td>
                                <td>123 Đường Nguyễn Huệ,
								Phường Bến Nghé, Quận 1,
								Thành phố Hồ Chí Minh,
								Việt Nam.</td>
                                <td>1,200,000 VND</td>
                                <td><button class="view-button">View</button></td>
                            </tr>
                            <tr>
                                <td>John Doe</td>
                                <td>St. James College</td>
                                <td>$120</td>
                                <td><button class="view-button">View</button></td>
                            </tr>
                            <tr>
                                <td>John Doe</td>
                                <td>St. James College</td>
                                <td>$120</td>
                                <td><button class="view-button">View</button></td>
                            </tr>
                            <tr>
                                <td>John Doe</td>
                                <td>St. James College</td>
                                <td>$120</td>
                                <td><button class="view-button">View</button></td>
                            </tr>

                            <!-- Repeat similar rows as needed -->
                        </tbody>
                    </table>
                </div>
                <div class="card">
                    <div class="card-header">
                        <h4>New Customer</h4>
                        <a href="#" class="view-all">View All</a>
                    </div>
                    <table>
                        <thead>
                            <tr>
                                <th>Profile</th>
                                <th>Name</th>
                                <th>Option</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><img src="profile-pic.jpg" alt="Profile" class="profile-pic"></td>
                                <td>John Steve Doe</td>
                                <td><button class="view-button">View</button></td>
                            </tr>
                            <tr>
                                <td><img src="profile-pic.jpg" alt="Profile" class="profile-pic"></td>
                                <td>John Steve Doe</td>
                                <td><button class="view-button">View</button></td>
                            </tr>
                            <tr>
                                <td><img src="profile-pic.jpg" alt="Profile" class="profile-pic"></td>
                                <td>John Steve Doe</td>
                                <td><button class="view-button">View</button></td>
                            </tr>
                            <tr>
                                <td><img src="profile-pic.jpg" alt="Profile" class="profile-pic"></td>
                                <td>John Steve Doe</td>
                                <td><button class="view-button">View</button></td>
                            </tr>
                            <!-- Repeat similar rows as needed -->
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>

    </div>
    <jsp:include page="page/footer.jsp"/>
<script src="https://kit.fontawesome.com/b6b15d6477.js" crossorigin="anonymous"></script>
<script>
document.addEventListener('DOMContentLoaded', function () {
    const navItems = document.querySelectorAll('.nav-item');
    navItems.forEach(item => {
        item.addEventListener('click', () => {
            navItems.forEach(i => i.classList.remove('active'));
            item.classList.add('active');
        });
    });
});
</script>
</body>
</html>