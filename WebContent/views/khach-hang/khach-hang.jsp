<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="UTF-8">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ultra Instinct</title>
    <jsp:include page="/views/page/header.jsp"/>
    <link rel="stylesheet" href="css/quanlykhachhang.css">
    <style>
        .radio-inline {
            display: inline-block;
            margin-right: 20px;
        }
    </style>
</head>
<body>
    <div class="row">
    <jsp:include page="/views/page/nav.jsp"/>
        <div class="col-sm-9 m-2">
            <div class="p-2" style="margin-left: 20px;">
                <div class="input-group mb-3">
                    <span class="input-group-text"><i class="fa-solid fa-magnifying-glass"></i></span>
                    <input class="form-control" placeholder="Tìm mã khách hàng">
                    <a href="${pageContext.request.contextPath}/chi-tiet-khach-hang"><i class="fa-solid fa-plus plus" ></i></a>
                    <div>
                        <a href="KhachHangForm.html" class="btn custom-btn ms-3" type="button">Danh sách</a>
                    </div>          
                </div>
                <div class="invoice-details p-3 border rounded mt-4" style="background-color: #F5F5F5; color: dimgray; ">
                    <h3 class="mb-4 text-center">Danh sách khách hàng</h3>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col" style="color: dimgray;">Mã khách hàng</th>
                                <th scope="col" style="color: dimgray;">Tên khách hàng</th>
                                <th scope="col" style="color: dimgray;">Số điện thoại</th>
                                <th scope="col" style="color: dimgray;">Email</th>
                                <th scope="col" style="color: dimgray;">Ngày đăng ký</th>
                                <th scope="col" style="color: dimgray;">Mã nhân viên</th>
                                <th scope="col" style="color: dimgray;">Tổng bán</th>
                                <th scope="col" style="color: dimgray;"></th>
                                <th scope="col" style="color: dimgray;"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>KH001</td>
                                <td>Nguyễn Thị Minh Ngọc</td>
                                <td>081236344</td>
                                <td>minhngoc@gmail.com</td>
                                <td>2022-02-07</td>
                                <td>NV001</td>
                                <td>4,255,000</td>
                                <td><i class="fa-solid fa-trash-can"></i></td>
                                <td><i class="fa-solid fa-pen"></i></td>
                                

                            </tr>
                            <tr>
                                <td>KH002</td>
                                <td>Lưu Nữ Kim Nguyên</td>
                                <td>0123871783</td>
                                <td>kimnguyen@gmail.com</td>
                                <td>2022-02-07</td>
                                <td>NV001</td>
                                <td>4,255,000</td>
                                <td><i class="fa-solid fa-trash-can"></i></td>
                                <td><i class="fa-solid fa-pen"></i></td>
                            </tr>
                            <tr>
                                <td>KH003</td>
                                <td>Đào Tuấn Kiệt</td>
                                <td>081236344</td>
                                <td>tuanKit@gmail.com</td>
                                <td>2022-24-07</td>
                                <td>NV001</td>
                                <td>4,255,000</td>
                                <td><i class="fa-solid fa-trash-can"></i></td>
                                <td><i class="fa-solid fa-pen"></i></td>
                            </tr>
                            <tr>
                                <td>KH004</td>
                                <td>Trần Văn Long</td>
                                <td>081236344</td>
                                <td>longtran@gmail.com</td>
                                <td>2022-07-08</td>
                                <td>NV001</td>
                                <td>4,255,000</td>
                                <td><i class="fa-solid fa-trash-can"></i></td>
                                <td><i class="fa-solid fa-pen"></i></td>
                            </tr>
                            <tr>
                                <td>KH005</td>
                                <td>Đinh Thị Mai Nhu</td>
                                <td>081236344</td>
                                <td>longtran@gmail.com</td>
                                <td>2022-07-08</td>
                                <td>NV001</td>
                                <td>4,255,000</td>
                                <td><i class="fa-solid fa-trash-can"></i></td>
                                <td><i class="fa-solid fa-pen"></i></td>
                            </tr>
                            <tr>
                                <td>KH006</td>
                                <td>Trần Mạnh Hùng</td>
                                <td>081236344</td>
                                <td>longtran@gmail.com</td>
                                <td>2022-07-08</td>
                                <td>NV001</td>
                                <td>4,255,000</td>
                                <td><i class="fa-solid fa-trash-can"></i></td>
                                <td><i class="fa-solid fa-pen"></i></td>
                            </tr>
                            <tr>
                                <td>KH007</td>
                                <td>Phạm Đình Nguyễn Văn</td>
                                <td>081236344</td>
                                <td>longtran@gmail.com</td>
                                <td>2022-07-08</td>
                                <td>NV001</td>
                                <td>4,255,000</td>
                                <td><i class="fa-solid fa-trash-can"></i></td>
                                <td><i class="fa-solid fa-pen"></i></td>
                            </tr>
                           
                            <!-- Thêm các hàng (rows) khác tại đây -->
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
<jsp:include page="/views/page/footer.jsp"/>
    <script src="https://kit.fontawesome.com/b6b15d6477.js" crossorigin="anonymous"></script>
</body>
</html>
    