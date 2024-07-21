<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Báo cáo doanh thu</title>
    <jsp:include page="/views/page/header.jsp"/>
    <link rel="stylesheet" href="css/baocaodoanhthu.css">
    <link rel="shortcut icon" type="image/png" href="img/logo1.png">
</head>

<body>

<div class="row">
    <jsp:include page="/views/page/nav.jsp"/>
    <div class="col-sm-7 m-2">
        <h3>Báo cáo doanh thu</h3>
        <div class="input-group">
            <span class="input-group-text"><i class="fa-solid fa-magnifying-glass"></i></span>
            <input class="form-control" placeholder="Tìm mã sản phẩm">
        </div>
        <table class="table">
            <thead>
            <tr>
                <th>Mã sản phẩm</th>
                <th>Tên sản phẩm</th>
                <th>Mã loại</th>
                <th>Số lượng bán</th>
                <th>Doanh thu</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>010-02809-80</td>
                <td>Forerunner 965, GPS, SEA, Black</td>
                <td>garmin</td>
                <td>120</td>
                <td>1,526,420,000 vnd</td>
            </tr>
            <tr>
                <td>010-02809-81</td>
                <td>Forerunner 965, GPS, SEA, White</td>
                <td>garmin</td>
                <td>50</td>
                <td>437,120,000 vnd</td>
            </tr>
            <tr>
                <td>010-02809-82</td>
                <td>Forerunner 965, GPS, SEA, Amp Yellow</td>
                <td>garmin</td>
                <td>12</td>
                <td>139,421,000 vnd</td>
            </tr>
            <tr>
                <td>010-02562-50</td>
                <td>Đồng hồ thông minh Forerunner 55, GPS, KOR/SEA, Đen</td>
                <td>loa</td>
                <td>7</td>
                <td>152,412,000 vnd</td>
            </tr>
            <tr>
                <td>010-02562-51</td>
                <td>Đồng hồ thông minh Forerunner 55, GPS, KOR/SEA, màu đá trắng</td>
                <td>garmin</td>
                <td>140</td>
                <td>319,376,000 vnd</td>
            </tr>
            <tr>
                <td>010-02562-52</td>
                <td>Đồng hồ thông minh Forerunner 55, GPS, KOR/SEA, màu xanh aqua</td>
                <td>garmin</td>
                <td>256</td>
                <td>286,931,000 vnd</td>
            </tr>
            <tr>
                <td>010-02562-53</td>
                <td>Đồng hồ thông minh Forerunner 55, GPS, KOR/SEA, màu xám</td>
                <td>garmin</td>
                <td>256</td>
                <td>286,931,000 vnd</td>
            </tr>
            <tr>
                <td>1006016</td>
                <td>Marshall Woburn 3</td>
                <td>loa</td>
                <td>256</td>
                <td>286,931,000 vnd</td>
            </tr>
            <tr>
                <td>1006010</td>
                <td>Marshall Stanmore 3</td>
                <td>loa</td>
                <td>256</td>
                <td>286,931,000 vnd</td>
            </tr>
            <tr>
                <td>1006004</td>
                <td>Marshall Acton 3</td>
                <td>loa</td>
                <td>256</td>
                <td>286,931,000 vnd</td>
            </tr>
            </tbody>
        </table>
        <nav aria-label="Page navigation example">
            <ul class="pagination justify-content-center">
                <li class="page-item">
                    <a class="page-link" href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item">
                    <a class="page-link" href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
    <div class="col-sm-2 m-2">
        <div class="card">
            <b>Thời gian</b>
            <select class="form-select" aria-label="Default select example">
                <option selected>Chọn thời gian</option>
                <option value="1">Lựa chọn khác</option>
            </select>
        </div>
        <div class="card">
            <b>Mã loại</b>
            <select class="form-select" aria-label="Default select example">
                <option selected>Chọn Chọn mã lạoi</option>
                <option value="1">Loa</option>
                <option value="2">Garmin</option>
            </select>
        </div>
    </div>
</div>
<jsp:include page="/views/page/footer.jsp"/>
<script src="https://kit.fontawesome.com/b6b15d6477.js" crossorigin="anonymous"></script>

</body>

</html>