<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chi tiết sản phẩm</title>
    <jsp:include page="/views/page/header.jsp"/>
    <link rel="stylesheet" href="css/quanlysanpham.css">
    <link rel="shortcut icon" type="image/png" href="img/logo1.png">
</head>
<body>
<div class="row">
    <jsp:include page="/views/page/nav.jsp"/>
    <div class="col-sm-9">
        <div class="p-2" style="margin-left: 20px;">
            <div class="input-group mb-3">
                <span class="input-group-text"><i class="fa-solid fa-magnifying-glass"></i></span>
                <input class="form-control" placeholder="Tìm kiếm mã sản phẩm, tên sản phẩm">
                <a href="ChiTietSanPhamForm.html"><i class="fa-solid fa-plus plus mt-3" data-bs-toggle="modal"
                        data-bs-target="#exampleModal"></i></a>
                <div>
                    <a href="${pageContext.request.contextPath}/san-pham" class="btn custom-btn ms-3" type="button">Danh sách</a>
                </div>
            </div>
            <div class="invoice-details p-3 border rounded mt-5" style="background-color: #F5F5F5;">
                <form action="${pageContext.request.contextPath}/san-pham" method="post">
                    <input type="hidden" name="_method" value="put">
                    <input type="hidden" name="sanPhamNo" value="${sanPham.sanPhamNo}">
                    <div class="text-center mb-5">
                        <h3>Chi tiết sản phẩm</h3>
                    </div>
                    <div class="row">
                        <div class="col-sm-3">
                            <img src="img/fenix/7progray.jpg" alt="Product Image" class="product-image" width="200px" height="200px">
                        </div>
                        <div class="col-sm-9">
                            <div class="row mb-3 mb-4 align-items-center">
                                <div class="col-sm-2">
                                    <label for="maSanPham" class="form-label">Mã sản phẩm</label>
                                </div>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="maSanPham" name="maSanPham" value="${sanPham.maSanPham}">
                                </div>
                            </div>
                            <div class="row mb-3 mb-4 align-items-center">
                                <div class="col-sm-2">
                                    <label for="tenSanPham" class="form-label">Tên sản phẩm</label>
                                </div>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="tenSanPham" name="tenSanPham" value="${sanPham.tenSanPham}">
                                </div>
                            </div>
                            <div class="row mb-3 mb-4">
                                <!-- Cặp 1 -->
                                <div class="col-sm-6">
                                    <div class="row align-items-center">
                                        <div class="col-sm-4">
                                            <label for="maLoaiSanPham" class="form-label">Mã phân loại</label>
                                        </div>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" id="maLoaiSanPham" name="maLoaiSanPham" value="${sanPham.loaiSanPham.maLoaiSanPham}">
                                        </div>
                                    </div>
                                </div>

                                <!-- Cặp 2 -->
                                <div class="col-sm-6">
                                    <div class="row align-items-center">
                                        <div class="col-sm-4">
                                            <label for="giaNiemYet" class="form-label">Giá niêm yết</label>
                                        </div>
                                        <div class="col-sm-8">
                                            <input type="number" class="form-control" id="giaNiemYet" name="giaNiemYet" value="${sanPham.giaNiemYet}">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="text-end mt-3">
                        <button id="previousBtn" class="btn custom2-btn">&lt;&lt;</button>
                        <button id="nextBtn" class="btn custom2-btn">&gt;&gt;</button>
                    </div>
                    <div class="text-end mt-4">
                        <button id="saveBtn" class="btn custom1-btn">Lưu</button>
                        <button id="deleteBtn" class="btn custom1-btn">Xóa</button>
                        <button id="editBtn" class="btn custom1-btn">Sửa</button>
                        <button id="newBtn" class="btn custom1-btn">Mới</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/views/page/footer.jsp"/>
<script src="https://kit.fontawesome.com/b6b15d6477.js" crossorigin="anonymous"></script>
</body>
</html>
