<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chi tiết kho hàng</title>
    <jsp:include page="/views/page/header.jsp"/>
     <link rel="stylesheet" href="css/QuanLyKhoHang.css">
    <link rel="shortcut icon" type="image/png" href="img/logo1.png">
</head>

<body>
<div class="row">
    <jsp:include page="/views/page/nav.jsp"/>
   
        <div class="col-sm-9 m-2">
            <h3>Quản ký kho hàng</h3>
            <div class="row">
                <div class="input-group">
                    <span class="input-group-text"><i class="fa-solid fa-magnifying-glass"></i></span>
                    <input class="search form-control" placeholder="Tìm mã phiếu nhập, mã sản phẩm">
                    <a href="ChiTietKhoHangForm.html"><i class="fa-solid fa-plus plus"></i></a>
                </div>
                <a href="${pageContext.request.contextPath}/kho-hang" class="btn btn-success">Danh sách</a>
            </div>
            <div class="card">
                <div class="card-body">
                    <h2 class="text-center">Phiếu nhập kho</h2></div>
                    <div class="row">
                        <div class="col-sm-5">
                            <label>Mã nhập kho</label>
                            <input class="form-control" disabled>
                        </div>
                        <div class="col-sm-2">
                            <label>Ngày lập</label>
                            <input type="date" class="form-control">
                        </div>
                        <div class="col-sm-2">
                            <label>Trạng thái</label>
                            <select class="form-select" aria-label="Default select example">
                                <option selected>Hoàn thành</option>
                                <option value="1">Đã hủy</option>
                            </select>
                        </div>
                        <div class="col-sm-3">
                            <label>Mã nhân viên</label>
                            <input class="form-control">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-5">
                            <label>Mã sản phẩm</label>
                            <input class="form-control">
                        </div>
                        <div class="col-sm-4">
                            <label>Nhà cung cấp</label>
                            <select class="form-select" aria-label="Default select example">
                                <option selected>Garmin</option>
                                <option value="1">ASH</option>
                                <option value="1">Sony</option>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-5">
                            <label>Giá nhập</label>
                            <input class="form-control" placeholder="Nhập giá nhập">
                        </div>
                        <div class="col-sm-2">
                            <label>Số lượng</label>
                            <input type="number" class="form-control">
                        </div>
                    </div>
                    <table class="table">
                        <thead>
                          <tr>
                            <th scope="col">Mã sản phẩm</th>
                            <th scope="col">Tên sản phẩm</th>
                            <th scope="col">Giá nhập</th>
                            <th scope="col">Số lượng</th>
                            <th scope="col">Thành</th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr>
                            <td>010-02638-J0</td>
                            <td>Đồng hồ thông minh Forerunner 955, không có Solar, SEA, Đen</td>
                            <td>12,690,000 vnđ</td>
                            <td>1</td>
                            <td>12,690,000 vnđ</td>
                          </tr>
                          <tr>
                            <td>010-02638-J0</td>
                            <td>Đồng hồ thông minh Forerunner 955, không có Solar, SEA, Đen</td>
                            <td>12,690,000 vnđ</td>
                            <td>1</td>
                            <td>12,690,000 vnđ</td>
                          </tr>
                          <tr>
                            <td>010-02638-J0</td>
                            <td>Đồng hồ thông minh Forerunner 955, không có Solar, SEA, Đen</td>
                            <td>12,690,000 vnđ</td>
                            <td>1</td>
                            <td>12,690,000 vnđ</td>
                          </tr>
                        </tbody>
                    </table>
                    <div class="btn-control row">
                        <button class="btn btn-dark text-white"><i class="fa-solid fa-backward"></i></button>
                        <button class="btn btn-dark text-white"><i class="fa-solid fa-forward"></i></button>
                    </div>
                    <div class="btn-control row">
                        <button class="btn btn-success text-white">Lưu</button>
                        <button class="btn btn-success text-white">Sửa</button>
                        <button class="btn btn-success text-white">Xóa</button>
                        <button class="btn btn-success text-white">Mới</button>
                    </div>
                </div>
            </div>
        </div>
<jsp:include page="/views/page/footer.jsp"/>
</div>
<script src="https://kit.fontawesome.com/b6b15d6477.js" crossorigin="anonymous"></script>

</body>

</html>