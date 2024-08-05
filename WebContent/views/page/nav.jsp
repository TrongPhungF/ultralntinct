<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<%-- <%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<fmt:setLocale value="${sessionScope.lang}" scope="request"/>
<fmt:setBundle basename="global" scope="request" />
<nav class="menu navbar col-sm-2">
        <div class="logo-container">
            <a href="${pageContext.request.contextPath}/home" class="navbar-brand">
                <img src="img/logo.png" alt="Ultra Instinct" class="logo">
            </a>
        </div>
    <ul class="nav">
            <li class="nav-item col-sm-12 start">
                <i class="fa-solid fa-layer-group"></i>
                <a href="${pageContext.request.contextPath}/home" class="nav-label" style="text-decoration: none; color: #666;"><fmt:message key="menu.trangchu"/></a>
                <span class="select"></span>
            </li>
            <li class="nav-item col-sm-12 ">
                <i class="fa-solid fa-layer-group"></i>
                <a href="${pageContext.request.contextPath}/ban-hang" class="nav-label" style="text-decoration: none; color: #666;"><fmt:message key="menu.banhang"/></a>
                <span class="select"></span>
            </li>
            <li class="nav-item col-sm-12">
                <i class="fa-solid fa-money-bills"></i>
                <a href="${pageContext.request.contextPath}/hoa-don" class="nav-label" style="text-decoration: none; color: #666;"><fmt:message key="menu.giaodich"/></a>
                <span class="select"></span>
            </li>
            <li class="nav-item col-sm-12 dropend">
                <i class="fa-solid fa-boxes-stacked"></i>
                <span class="nav-label dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false"><fmt:message key="menu.hanghoa"/></span>
                <span class="select"></span>
                <ul class="dropdown-menu">
                    <a href="${pageContext.request.contextPath}/san-pham" style="text-decoration: none;" class="nav-item"><fmt:message key="menu.sanpham"/></a>
                    <a href="${pageContext.request.contextPath}/kho-hang" style="text-decoration: none;" class="nav-item"><fmt:message key="menu.kho"/></a>
                </ul>
            </li>
            <li class="nav-item col-sm-12 dropend">
                <i class="fa-solid fa-chart-simple"></i>
                 <a href="${pageContext.request.contextPath}/bao-cao-doanh-thu" class="nav-label" style="text-decoration: none; color: #666;"><fmt:message key="menu.baocao"/></a>
                <span class="select"></span>
            </li>
            <li class="nav-item col-sm-12">
                <i class="fa-solid fa-user-group"></i>
                <a href="${pageContext.request.contextPath}/khach-hang" class="nav-label" style="text-decoration: none; color: #666;"><fmt:message key="menu.khachhang"/></a>
                <span class="select"></span>
            </li>
            <li class="nav-item col-sm-12">
                <i class="fa-solid fa-circle-user"></i>
                <a href="${pageContext.request.contextPath}/nhan-vien" class="nav-label" style="text-decoration: none; color: #666;"><fmt:message key="menu.nhanvien"/></a>
                <span class="select"></span>
            </li>
            <li class="nav-item col-sm-12 setting">
                <i class="fa-solid fa-question"></i>
                <a href="#" class="nav-label" style="text-decoration: none; color: #666;"><fmt:message key="menu.hoidap"/></a>
                <span class="select"></span>
            </li>
            <li class="nav-item col-sm-12  dropend">
                <i class="fa-solid fa-gear"></i>
                <span class="nav-label dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false"><fmt:message key="menu.caidat"/></span>
                <span class="select"></span>
                <ul class="dropdown-menu profile" style="position: absolute; flex-direction: column-reverse; margin-top: -175px;">
                    <a href="${pageContext.request.contextPath}/dieu-khoan-va-bao-mat" class="nav-item" style="text-decoration: none;"><fmt:message key="menu.dieukhoanbaomat"/></a>
                    <a href="${pageContext.request.contextPath}/thong-bao" class="nav-item" style="text-decoration: none;"><fmt:message key="menu.thongbao"/></a>
                    <a href="${pageContext.request.contextPath}/thay-doi-mat-khau" class="nav-item" style="text-decoration: none;"><fmt:message key="menu.doimatkhau"/></a>
                    <a href="${pageContext.request.contextPath}/thong-tin-tai-khoan" class="nav-item" style="text-decoration: none;"><fmt:message key="menu.thongtintaikhoan"/></a>
                </ul>
            </li>
            <li class="nav-item col-sm-12  dropend">
                <i class="fa-solid fa-gear"></i>
                <span class="nav-label dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false"><fmt:message key="menu.ngonngu"/></span>
                <span class="select"></span>
                <ul class="dropdown-menu profile" style="position: absolute; flex-direction: column-reverse; margin-top: -175px;">
                    <a href="${pageContext.request.contextPath}/home?lang=vi" class="nav-item" style="text-decoration: none;">Tiếng Việt</a>
                    <a href="${pageContext.request.contextPath}/home?lang=en" class="nav-item" style="text-decoration: none;">English</a>
                    <a href="${pageContext.request.contextPath}/home?lang=cn" class="nav-item" style="text-decoration: none;">简体中文</a>
                    <a href="${pageContext.request.contextPath}/home?lang=ja" class="nav-item" style="text-decoration: none;">日本語</a>
                </ul>
            </li>
            <li class="col-sm-12">
                <img src="img/avatar.jpg" width="50px" height="50px" style="border-radius: 50%; margin-left: 30px; margin-top: 10px;">
                <b>TANi</b>
                <a href="${pageContext.request.contextPath}/dang-xuat"><i class="fa-solid fa-right-from-bracket float-end nav-item" style="margin-top: 15px; padding: 10px; border-radius: 5px; margin-right: 25px;"></i></a>
            </li>
        </ul>
    </nav>
