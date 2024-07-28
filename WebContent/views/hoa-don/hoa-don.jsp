<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="UTF-8">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ultra Instinct</title>
    <jsp:include page="/views/page/header.jsp"/>
    <link rel="stylesheet" href="css/chitiethoadon.css">
    <style>
        /* Include the CSS here if not using external stylesheet */
    </style>
</head>
<body>
<div class="row">
    <jsp:include page="/views/page/nav.jsp"/>
    <div class="col-sm-9 m-1">
        <div class="p-1" style="margin-left: 20px;">
            <h3>Hóa đơn</h3>
        </div>
        <div class="p-1" style="margin-left: 20px;">
            <div class="input-group mb-3">
                <span class="input-group-text"><i class="fa-solid fa-magnifying-glass"></i></span>
                <input class="form-control" placeholder="Tìm mã hóa đơn">
                <a href="${pageContext.request.contextPath}/home"><i class="fa-solid fa-plus plus"></i></a>
            </div>
            <!-- Thêm phần mới dưới nút "Danh sách" -->
            <div class="filter-section">
                <div class="filter-item">
                    <label class="filter-label">Thời gian:</label>
                    <select class="form-control">
                        <option>Hôm nay</option>
                        <option>Lựa chọn khác</option>
                    </select>
                </div>
                <div class="filter-item">
                    <label class="filter-label">Trạng thái:</label>
                    <select class="form-control">
                        <option>Hoàn thành</option>
                        <option>Đã hủy</option>
                        <option>Đang xử lý</option>
                        <option>Không giao được</option>
                    </select>
                </div>
                <div class="filter-item">
                    <label class="filter-label">Người bán:</label>
                    <select class="form-control">
                        <option>Nguyễn Văn A</option>
                        <option>Đào Tấn Kiệt</option>
                    </select>
                </div>
            </div>
            <div class="row mt-2">
                <div class="col-sm-12">
                    <table class="table table-striped table-hover">
                        <thead>
                        <tr>
                            <th scope="col">Mã hóa đơn</th>
                            <th scope="col">Mã khách hàng</th>
                            <th scope="col">Mã nhân viên</th>
                            <th scope="col">Ngày lập</th>
                            <th scope="col">Trạng thái</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>HD001</td>
                            <td>KH001</td>
                            <td>NV001</td>
                            <td>2024-07-15</td>
                            <td>Đã thanh toán</td>
                        </tr>
                        <tr>
                            <td>HD002</td>
                            <td>KH002</td>
                            <td>NV002</td>
                            <td>2024-07-14</td>
                            <td>Chưa thanh toán</td>
                        </tr>
                        <tr>
                            <td>HD003</td>
                            <td>KH003</td>
                            <td>NV003</td>
                            <td>2024-07-13</td>
                            <td>Đã thanh toán</td>
                        </tr>
                        <tr>
                            <td>HD004</td>
                            <td>KH004</td>
                            <td>NV004</td>
                            <td>2024-07-12</td>
                            <td>Chưa thanh toán</td>
                        </tr>
                        <tr>
                            <td>HD005</td>
                            <td>KH005</td>
                            <td>NV005</td>
                            <td>2024-07-11</td>
                            <td>Đã thanh toán</td>
                        </tr>
                        <tr>
                            <td>HD006</td>
                            <td>KH006</td>
                            <td>NV006</td>
                            <td>2024-07-10</td>
                            <td>Chưa thanh toán</td>
                        </tr>
                        <!-- Add more rows as needed -->
                        </tbody>
                    </table>
                    <!-- Pagination -->
                    <nav aria-label="Page navigation example" class="pagination-container">
                        <ul class="pagination">
                            <li class="page-item"><a class="page-link" href="#">1</a></li>
                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item"><a class="page-link" href="#">...</a></li>
                            <li class="page-item"><a class="page-link" href="#">10</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/views/page/footer.jsp"/>
<script src="https://kit.fontawesome.com/b6b15d6477.js" crossorigin="anonymous"></script>
</body>
</html>
