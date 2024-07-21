<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="UTF-8">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Báo Cáo Hóa Đơn</title>
    <jsp:include page="/views/page/header.jsp"/>
    <link rel="stylesheet" href="css/baocaodoanhthu.css">
    <link rel="shortcut icon" type="image/png" href="img/logo1.png">
</head>

<body>

<div class="row">
    <jsp:include page="/views/page/nav.jsp"/>
    <div class="col-sm-9 m-2">
        <h3>Báo Cáo Hóa Đơn</h3>
        <div class="card">
            <b>Thời gian</b>
            <select class="form-select" aria-label="Default select example">
                <option selected>Chọn năm</option>
                <option value="1">Năm 2018</option>
                <option value="1">Năm 2019</option>
                <option value="1">Năm 2020</option>
                <option value="1">Năm 2021</option>
                <option value="1">Năm 2022</option>
                <option value="1">Năm 2023</option>
                <option value="1">Năm 2024</option>
            </select>
        </div>
        <table class="table">
            <thead>
            <tr>
                <th>Năm</th>
                <th>Số đơn thành công</th>
                <th>Số đơn hủy</th>
                <th>Tổng bán</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>2024</td>
                <td>1,204</td>
                <td>120</td>
                <td>12,526,420,000 vnđ</td>
            </tr>
            <tr>
                <td>2023</td>
                <td>1,167</td>
                <td>210</td>
                <td>11,37,120,000 vnđ</td>
            </tr>
            <tr>
                <td>2022</td>
                <td>946</td>
                <td>125</td>
                <td>9,139,421,000 vnđ</td>
            </tr>
            <tr>
                <td>2021</td>
                <td>867</td>
                <td>126</td>
                <td>7,152,412,000 vnđ</td>
            </tr>
            <tr>
                <td>2020</td>
                <td>523</td>
                <td>140</td>
                <td>6,319,376,000 vnđ</td>
            </tr>
            <tr>
                <td>2019</td>
                <td>412</td>
                <td>51</td>
                <td>4,286,931,000 vnđ</td>
            </tr>
            <tr>
                <td>2018</td>
                <td>1,521</td>
                <td>256</td>
                <td>13,286,931,000 vnđ</td>
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

</div>
<jsp:include page="/views/page/footer.jsp"/>
<script src="https://kit.fontawesome.com/b6b15d6477.js" crossorigin="anonymous"></script>

</body>

</html>