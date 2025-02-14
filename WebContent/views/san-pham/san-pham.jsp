<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh sách sản phẩm</title>
    <jsp:include page="/views/page/header.jsp"/>
    <link rel="stylesheet" href="css/quanlysanpham.css">
    <link rel="shortcut icon" type="image/png" href="img/logo1.png">
</head>
<body>

<div class="row">
    <jsp:include page="/views/page/nav.jsp"/>
    <div class="col-9 m-2">
        <div class="p-2" style="margin-left: 20px;">
            <div class="input-group mb-3">
                <form action="${pageContext.request.contextPath}/san-pham" class="search-form">
                    <span class="input-group-text"><i class="fa-solid fa-magnifying-glass"></i></span>
                    <input class="form-control" name="sanPhamKeySearch" placeholder="Tìm mã sản phẩm, tên sản phẩm">
                    <a href="${pageContext.request.contextPath}/chi-tiet-san-pham" class="plus-link">
                        <i class="fa-solid fa-plus plus"></i>
                    </a>
                    <button class="btn custom-btn ms-1" type="submit">Tìm kiếm</button>
                </form>
            </div>
            <div class="invoice-details p-3 border rounded mt-4"
                 style="background-color: #F5F5F5; color: dimgray;">
                <h3 class="mb-4 text-center">Danh sách sản phẩm</h3>
                <c:if test="${not empty errorMessage}">
                         <div class="alert alert-danger">${errorMessage}</div>
                    </c:if>
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col" style="color: dimgray;">STT</th>
                        <th scope="col" style="color: dimgray;">Mã sản phẩm</th>
                        <th scope="col" style="color: dimgray;">Mã loại sản phẩm</th>
                        <th scope="col" style="color: dimgray;">Tên sản phẩm</th>
                        <th scope="col" style="color: dimgray;">Giá niêm yết</th>
                        <th scope="col" style="color: dimgray;">Hình</th>
                        <th scope="col" style="color: dimgray;">Chỉnh sửa</th>
                        <th scope="col" style="color: dimgray;">Xóa</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="sanPham" items="${sanPhamList}" varStatus="status">
                        <tr>
                            <td><c:out value="${status.index + 1}"/></td>
                            <td><c:out value="${sanPham.maSanPham}"/></td>
                            <td><c:out value="${sanPham.loaiSanPham.maLoaiSanPham}"/></td>
                            <td><c:out value="${sanPham.tenSanPham}"/></td>
                            <td><c:out value="${sanPham.giaNiemYet}"/></td>
                            <td><img src="${sanPham.hinh != null ? sanPham.hinh : 'img/unnamed.png'}" alt="Hình sản phẩm" width="100" height="100"/></td>
                            <td>
                                <a href="${pageContext.request.contextPath}/chi-tiet-san-pham?maSanPham=${sanPham.maSanPham}" class="btn btn-link">
                                    <i class="fa-solid fa-pen"></i>
                                </a>
                            </td>
                            <td>
			                             <form action="${pageContext.request.contextPath}/san-pham" method="post" onsubmit="return confirm('Bạn có chắc chắn muốn xóa sản phẩm này?');">
									    <input type="hidden" name="_method" value="delete">
									    <input type="hidden" name="maSanPham" value="${sanPham.maSanPham}">
									    <button type="submit" class="btn btn-link">
									        <i class="fa-solid fa-trash-can"></i>
									    </button>
									</form>

			            </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <nav aria-label="Page navigation example" class="pagination-container">
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
    </div>
</div>
<jsp:include page="/views/page/footer.jsp"/>
<script src="https://kit.fontawesome.com/b6b15d6477.js" crossorigin="anonymous"></script>
</body>
</html>
