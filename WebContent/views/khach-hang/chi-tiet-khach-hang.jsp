<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chi tiết khách hàng</title>
    <jsp:include page="/views/page/header.jsp"/>
    <link rel="stylesheet" href="css/quanlykhachhang.css">
    <link rel="shortcut icon" type="image/png" href="img/logo1.png">
</head>
<body>
<div class="row">
    <jsp:include page="/views/page/nav.jsp"/>
     <div class="col-sm-9 m-2">
            <div class="p-2" style="margin-left: 20px;">
                <div class="input-group mb-3">
                    <span class="input-group-text"><i class="fa-solid fa-magnifying-glass"></i></span>
                    <input class="form-control" placeholder="Tìm mã khách hàng">
                    <a href="ChiTietKhachHangForm.html"><i class="fa-solid fa-plus plus" data-bs-toggle="modal" data-bs-target="#exampleModal"></i></a>
                    <div>
                        <a href="${pageContext.request.contextPath}/khach-hang" class="btn custom-btn ms-3" type="button">Danh sách</a>
                    </div>          
                </div>
                <div class="invoice-details p-3 border rounded mt-4" style="background-color: #F5F5F5;">
                    <form>
                        <div class="text-center mb-5">
                            <h3>Cập nhập khách hàng</h3>
                        </div>
                        <div class="row mb-3 mb-4 align-items-center">
                            <div class="col-sm-2">
                                <label for="maKhachhang" class="form-label">Mã khách hàng</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="maKhachhang" >
                            </div>
                        </div>
                        <div class="row mb-3 mb-4 align-items-center">
                            <div class="col-sm-2">
                                <label for="tenKhachhang" class="form-label">Tên khách hàng</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="tenKhachhang">
                            </div>
                        </div>
                        <div class="row mb-3 mb-4">
                            <!-- Cặp 1 -->
                            <div class="col-sm-6">
                                <div class="row align-items-center">
                                    <div class="col-sm-4">
                                        <label for="soDienThoai" class="form-label">Số điện thoại</label>
                                    </div>
                                    <div class="col-sm-8">
                                        <input type="number" class="form-control" id="soDienThoai">
                                    </div>
                                </div>
                            </div>
                            
                            <!-- Cặp 2 -->
                            <div class="col-sm-6">
                                <div class="row align-items-center">
                                    <div class="col-sm-3" style="margin-top:7px;">
                                        <label for="gioiTinh" class="form-label">Giới tính</label>
                                    </div>
                                    <div class="col-sm-9">
                                        <div class="radio-inline">
                                            <input type="radio" id="nam" name="gioiTinh" value="nam">
                                            <label for="nam">Nam</label>
                                        </div>
                                        <div class="radio-inline">
                                            <input type="radio" id="nu" name="gioiTinh" value="nu">
                                            <label for="nu">Nữ</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row mb-3 mb-4 align-items-center">
                            <div class="col-sm-2">
                                <label for="email" class="form-label">Email</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="email" class="form-control" id="email" >
                            </div>
                        </div>
                        <div class="row mb-3 mb-4 align-items-center">
                            <div class="col-sm-2">
                                <label for="ngaySinh" class="form-label">Ngày sinh</label>
                            </div>
                            <div class="col-sm-4">
                                <input type="date" class="form-control" id="ngaySinh" >
                            </div>
                        </div>
                        <div class="row mb-3 mb-4">
                            <!-- Cặp 1 -->
                            <div class="col-sm-8">
                                <div class="row align-items-center">
                                    <div class="col-sm-3">
                                        <label for="diaChi" class="form-label">Địa chỉ</label>
                                    </div>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" id="diaChi">
                                    </div>
                                </div>
                            </div>
                            
                            <!-- Cặp 2 -->
                            <div class="col-sm-4">
                                <div class="row align-items-center">
                                    <div class="col-sm-8">
                                        <div class="radio-inline" style="margin-top:7px;">
                                            <input type="radio" id="macDinh" name="gioiTinh" value="macDinh">
                                            <label for="macDinh">Mặc định</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row mb-3 mb-4 align-items-center">
                            <div class="col-sm-2">
                                <label for="ghiChu" class="form-label">Ghi chú</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="ghiChu" >
                            </div>
                        </div>
                        
                        
                    </form>
                    <div class="text-end mt-3">
                        <button id="previousBtn" class="btn custom2-btn"> << </button>
                        <button id="nextBtn" class="btn custom2-btn"> >> </button>
                    </div>
                    <div class="text-end mt-4">
                        <button id="saveBtn" class="btn custom1-btn">Lưu</button>
                        <button id="deleteBtn" class="btn custom1-btn">Xóa</button>
                        <button id="editBtn" class="btn custom1-btn">Sửa</button>
                        <button id="newBtn" class="btn custom1-btn">Mới</button>
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
