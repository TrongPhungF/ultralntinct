<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="UTF-8">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ultra Instinct</title>
    <jsp:include page="/views/page/header.jsp"/>
    <link rel="stylesheet" href="css/danhsachnhanvien.css">
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
                    <a href="${pageContext.request.contextPath}/chi-tiet-nhan-vien"><i class="fa-solid fa-plus plus" ></i></a>
                    <div>
                        <a href="${pageContext.request.contextPath}/nhan-vien" class="btn custom-btn ms-3" type="button">Danh sách</a>
                    </div>          
                </div>
                <div class="invoice-details p-3 border rounded mt-4" style="background-color: #F5F5F5; color: dimgray; ">
                    <h3 class="mb-4 text-center">Danh sách nhân viên</h3>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col" style="color: dimgray;">Mã nhân viên</th>
                                <th scope="col" style="color: dimgray;">Tên nhân viên</th>
                                <th scope="col" style="color: dimgray;">Mật khẩu</th>
                                <th scope="col" style="color: dimgray;">Số điện thoại</th>
                                <th scope="col" style="color: dimgray;">Email</th>
                                <th scope="col" style="color: dimgray;">Vai trò</th>
                                <th scope="col" style="color: dimgray;"></th>
                                <th scope="col" style="color: dimgray;"></th>
                               
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="nhanVien" items="${nhanVienList}">
                                <tr>
                                    <td><c:out value="${nhanVien.maNhanVien}"/></td>
                                    <td><c:out value="${nhanVien.tenNhanVien}"/></td>
                                    <td><c:out value="${nhanVien.matKhau}"/></td>
                                    <td><c:out value="${nhanVien.soDienThoai}"/></td>
                                    <td><c:out value="${nhanVien.email}"/></td>
                                    <td><c:out value="${nhanVien.chucVu}"/></td>
                                    <td><i class="fa-solid fa-trash-can"></i></td>
                                    <td><i class="fa-solid fa-pen"></i></td>
                                </tr>
                            </c:forEach>
                            <!-- Thêm các hàng (rows) khác tại đây -->
                         
                            <tr>
                                <td>NV011</td>
                                <td>Nguyễn Văn Anh</td>
                                <td>12345456</td>
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
    