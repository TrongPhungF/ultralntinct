<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<nav class="menu navbar col-sm-2">
        <div class="logo-container">
            <a href="${pageContext.request.contextPath}/home" class="navbar-brand">
                <img src="img/logo.png" alt="Ultra Instinct" class="logo">
            </a>
        </div>
        <ul class="nav">
            <li class="nav-item col-sm-12 start">
                <i class="fa-solid fa-layer-group"></i>
                <a href="${pageContext.request.contextPath}/home" class="nav-label" style="text-decoration: none; color: #666;">Bán hàng</a>
                <span class="select"></span>
            </li>
            <li class="nav-item col-sm-12">
                <i class="fa-solid fa-money-bills"></i>
                <a href="${pageContext.request.contextPath}/hoa-don" class="nav-label" style="text-decoration: none; color: #666;">Giao dịch</a>
                <span class="select"></span>
            </li>
            <li class="nav-item col-sm-12 dropend">
                <i class="fa-solid fa-boxes-stacked"></i>
                <span class="nav-label dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">Hàng hóa</span>
                <span class="select"></span>
                <ul class="dropdown-menu">
                    <a href="${pageContext.request.contextPath}/san-pham" style="text-decoration: none;" class="nav-item">Quản lý sản phẩm</a>
                    <a href="${pageContext.request.contextPath}/kho-hang" style="text-decoration: none;" class="nav-item">Quản lý kho</a>
                </ul>
            </li>
            <li class="nav-item col-sm-12 dropend">
                <i class="fa-solid fa-chart-simple"></i>
                <span class="nav-label dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">Báo cáo</span>
                <span class="select"></span>
                <ul class="dropdown-menu">
                    <a href="${pageContext.request.contextPath}/bao-cao-doanh-thu" class="nav-item"style="text-decoration: none;">Báo cáo doanh thu</a>
                    <a href="${pageContext.request.contextPath}/bao-cao-hoa-don" class="nav-item" style="text-decoration: none;">Báo cáo đơn hàng</a>
                    <a href="${pageContext.request.contextPath}/bao-cao-khach-hang" class="nav-item"style="text-decoration: none;">Báo cáo khách hàng</a>
                </ul>
            </li>
            <li class="nav-item col-sm-12">
                <i class="fa-solid fa-user-group"></i>
                <a href="${pageContext.request.contextPath}/khach-hang" class="nav-label" style="text-decoration: none; color: #666;">Khách hàng</a>
                <span class="select"></span>
            </li>
            <li class="nav-item col-sm-12">
                <i class="fa-solid fa-circle-user"></i>
                <a href="${pageContext.request.contextPath}/nhan-vien" class="nav-label" style="text-decoration: none; color: #666;">Nhân viên</a>
                <span class="select"></span>
            </li>
            <li class="nav-item col-sm-12 setting">
                <i class="fa-solid fa-question"></i>
                <a href="#" class="nav-label" style="text-decoration: none; color: #666;">Hỏi đáp</a>
                <span class="select"></span>
            </li>
            <li class="nav-item col-sm-12  dropend">
                <i class="fa-solid fa-gear"></i>
                <span class="nav-label dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">Cài đặt</span>
                <span class="select"></span>
                <ul class="dropdown-menu profile" style="position: absolute; flex-direction: column-reverse; margin-top: -175px;">
                    <a href="${pageContext.request.contextPath}/dieu-khoan-va-bao-mat" class="nav-item" style="text-decoration: none;">Điều khoản & bảo mật</a>
                    <a href="${pageContext.request.contextPath}/thong-bao" class="nav-item" style="text-decoration: none;">Thông báo</a>
                    <a href="${pageContext.request.contextPath}/thay-doi-mat-khau" class="nav-item" style="text-decoration: none;">Đổi mật khẩu</a>
                    <a href="${pageContext.request.contextPath}/thong-tin-tai-khoan" class="nav-item" style="text-decoration: none;">Thông tin tài khoản</a>
                </ul>
            </li>
            <li class="col-sm-12">
                <img src="img/avatar.jpg" width="50px" height="50px" style="border-radius: 50%; margin-left: 30px; margin-top: 10px;">
                <b>TANi</b>
                <a href="${pageContext.request.contextPath}/dang-xuat"><i class="fa-solid fa-right-from-bracket float-end nav-item" style="margin-top: 15px; padding: 10px; border-radius: 5px; margin-right: 25px;"></i></a>
            </li>
        </ul>
    </nav>
