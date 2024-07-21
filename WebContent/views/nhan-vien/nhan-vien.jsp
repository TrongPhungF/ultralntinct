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
                    <input class="form-control" placeholder="Tìm kiếm mã nhân viên">
                    <a href="ChiTietNhanVienForm.html"><i class="fa-solid fa-plus plus" data-bs-toggle="modal" data-bs-target="#exampleModal"></i></a>
                    <div>
                        <a href="NhanVienForm.html" class="btn custom-btn ms-3" type="button">Danh sách</a>
                    </div>          
                </div>
                <div class="invoice-details p-3 border rounded mt-4" style="background-color: #F5F5F5; color: dimgray; ">
                    <h3 class="mb-4 text-center">Danh sách nhân viên</h3>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col" style="color: dimgray;">Mã nhân viên</th>
                                <th scope="col" style="color: dimgray;">Tên nhân viên</th>
                                <th scope="col" style="color: dimgray;">Ngày sinh</th>
                                <th scope="col" style="color: dimgray;">Giới tính</th>
                                <th scope="col" style="color: dimgray;">Số điện thoại</th>
                                <th scope="col" style="color: dimgray;">Email</th>
                                <th scope="col" style="color: dimgray;">Vai trò</th>
                                <th scope="col" style="color: dimgray;"></th>
                                <th scope="col" style="color: dimgray;"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>NV001</td>
                                <td>Nguyễn Thị Minh Ngọc</td>
                                <td>1999-02-07</td>
                                <td>Nữ</td>
                                <td>081236344</td>
                                <td>minhngoc@gmail.com</td>
                                <td>Quản trị viên</td>
                                <td><i class="fa-solid fa-trash-can"></i></td>
                                <td><i class="fa-solid fa-pen"></i></td>
                                

                            </tr>
                            <tr>
                                <td>NV002</td>
                                <td>Lưu Nữ Kim Nguyên</td>
                                <td>2000-24-06</td>
                                <td>Nữ</td>
                                <td>081212384</td>
                                <td>kimnguyen@gmail.com</td>
                                <td>Quản trị viên</td>
                                <td><i class="fa-solid fa-trash-can"></i></td>
                                <td><i class="fa-solid fa-pen"></i></td>
                            </tr>
                            <tr>
                                <td>NV003</td>
                                <td>Đào Tuấn Kiệt</td>
                                <td>2004-10-09</td>
                                <td>Nam</td>
                                <td>081236344</td>
                                <td>tuankit@gmail.com</td>
                                <td>Quản trị viên</td>
                                <td><i class="fa-solid fa-trash-can"></i></td>
                                <td><i class="fa-solid fa-pen"></i></td>
                            </tr>
                            <tr>
                                <td>NV004</td>
                                <td>Trần Văn Long</td>
                                <td>2004-01-10</td>
                                <td>Nam</td>
                                <td>081236344</td>
                                <td>longtran@gmail.com</td>
                                <td>Nhân viên bán hàng</td>
                                <td><i class="fa-solid fa-trash-can"></i></td>
                                <td><i class="fa-solid fa-pen"></i></td>
                            </tr>
                            <tr>
                                <td>NV005</td>
                                <td>Nguyễn Xuân Công</td>
                                <td>2000-01-02</td>
                                <td>Nam</td>
                                <td>081236344</td>
                                <td>xuancong@gmail.com</td>
                                <td>Nhân viên bán hàng</td>
                                <td><i class="fa-solid fa-trash-can"></i></td>
                                <td><i class="fa-solid fa-pen"></i></td>
                            </tr>
                            <tr>
                                <td>NV006</td>
                                <td>Lê Thị Ánh Linh</td>
                                <td>2004-06-07</td>
                                <td>Nữ</td>
                                <td>081234344</td>
                                <td>anhlinh@gmail.com</td>
                                <td>Nhân viên bán hàng</td>
                                <td><i class="fa-solid fa-trash-can"></i></td>
                                <td><i class="fa-solid fa-pen"></i></td>
                            </tr>
                            <tr>
                                <td>NV007</td>
                                <td>Phạm Ngọc Dương</td>
                                <td>2004-09-07</td>
                                <td>Nam</td>
                                <td>081236344</td>
                                <td>ngocduong@gmail.com</td>
                                <td>Nhân viên kho</td>
                                <td><i class="fa-solid fa-trash-can"></i></td>
                                <td><i class="fa-solid fa-pen"></i></td>
                            </tr>
                            <tr>
                                <td>NV008</td>
                                <td>Nguyễn Bảo Kha</td>
                                <td>2004-31-07</td>
                                <td>Nam</td>
                                <td>081236344</td>
                                <td>baokha@gmail.com</td>
                                <td>Nhân viên kho</td>
                                <td><i class="fa-solid fa-trash-can"></i></td>
                                <td><i class="fa-solid fa-pen"></i></td>
                            </tr>
                            <tr>
                                <td>NV009</td>
                                <td>Nguyễn Tấn Duy</td>
                                <td>2004-28-01</td>
                                <td>Nam</td>
                                <td>0812313244</td>
                                <td>tanduy@gmail.com</td>
                                <td>Nhân viên kho</td>
                                <td><i class="fa-solid fa-trash-can"></i></td>
                                <td><i class="fa-solid fa-pen"></i></td>
                            </tr>
                            <tr>
                                <td>NV010</td>
                                <td>Nguyễn Văn Anh</td>
                                <td>2002-28-07</td>
                                <td>Nam</td>
                                <td>0812136344</td>
                                <td>anhvan@gmail.com</td>
                                <td>Nhân viên kho</td>
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
    <script>
        const navItems = document.querySelectorAll('.nav-item');
        navItems.forEach(item => {
          item.addEventListener('click', () => {
            navItems.forEach(i => i.classList.remove('active'));
            item.classList.add('active');
          });
        });
    </script>
</body>
</html>
    