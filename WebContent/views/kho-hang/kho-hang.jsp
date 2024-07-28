<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="UTF-8">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ultra Instinct</title>
    <jsp:include page="/views/page/header.jsp"/>
    <link rel="stylesheet" href="css/KhoHang.css">
    <link rel="shortcut icon" type="image/png" href="img/logo1.png">
</head>
<body>   
        <div class="row">
        <jsp:include page="/views/page/nav.jsp"/>
        <div class="col-sm-7 m-2">
            <h3>Quản lý kho hàng</h3>
            <div class="input-group">
                <span class="input-group-text"><i class="fa-solid fa-magnifying-glass"></i></span>
                <input class="form-control" placeholder="Tìm mã phiếu nhập, mã sản phẩm">
                <a href="${pageContext.request.contextPath}/chi-tiet-kho-hang"><i class="fa-solid fa-plus plus"></i></a>
            </div>
            <table class="table">
                <thead>
                  <tr>
                    <th scope="col">Mã phiếu nhập</th>
                    <th scope="col">Mã sản phẩm</th>
                    <th scope="col">Mã nhập kho</th>
                    <th scope="col">Mã nhà cung cấp</th>
                    <th scope="col">Giá nhập</th>
                    <th scope="col">Số lượng</th>
                    <th scope="col"></th>
                    <th scope="col"></th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>PN001</td>
                    <td>010-02562-50</td>
                    <td>NK001</td>
                    <td>Garmin Brand Store</td>
                    <td>3,950,000 vnd</td>
                    <td>100</td>
                    <td scope="col"><i class="fa-solid fa-trash"></i></td>
                    <td scope="col"><i class="fa-solid fa-pen"></i></td>
                  </tr>
                  <tr>
                    <td>PN001</td>
                    <td>010-02562-50</td>
                    <td>NK001</td>
                    <td>Garmin Brand Store</td>
                    <td>3,950,000 vnd</td>
                    <td>100</td>
                    <td scope="col"><i class="fa-solid fa-trash"></i></td>
                    <td scope="col"><i class="fa-solid fa-pen"></i></td>
                  </tr>
                  <tr>
                    <td>PN001</td>
                    <td>010-02562-50</td>
                    <td>NK001</td>
                    <td>Garmin Brand Store</td>
                    <td>3,950,000 vnd</td>
                    <td>100</td>
                    <td scope="col"><i class="fa-solid fa-trash"></i></td>
                    <td scope="col"><i class="fa-solid fa-pen"></i></td>
                  </tr>
                  <tr>
                    <td>PN001</td>
                    <td>010-02562-50</td>
                    <td>NK001</td>
                    <td>Garmin Brand Store</td>
                    <td>3,950,000 vnd</td>
                    <td>100</td>
                    <td scope="col"><i class="fa-solid fa-trash"></i></td>
                    <td scope="col"><i class="fa-solid fa-pen"></i></td>
                  </tr>
                  <tr>
                    <td>PN001</td>
                    <td>010-02562-50</td>
                    <td>NK001</td>
                    <td>Garmin Brand Store</td>
                    <td>3,950,000 vnd</td>
                    <td>100</td>
                    <td scope="col"><i class="fa-solid fa-trash"></i></td>
                    <td scope="col"><i class="fa-solid fa-pen"></i></td>
                  </tr>
                  <tr>
                    <td>PN001</td>
                    <td>010-02562-50</td>
                    <td>NK001</td>
                    <td>Garmin Brand Store</td>
                    <td>3,950,000 vnd</td>
                    <td>100</td>
                    <td scope="col"><i class="fa-solid fa-trash"></i></td>
                    <td scope="col"><i class="fa-solid fa-pen"></i></td>
                  </tr>
                  <tr>
                    <td>PN001</td>
                    <td>010-02562-50</td>
                    <td>NK001</td>
                    <td>Garmin Brand Store</td>
                    <td>3,950,000 vnd</td>
                    <td>100</td>
                    <td scope="col"><i class="fa-solid fa-trash"></i></td>
                    <td scope="col"><i class="fa-solid fa-pen"></i></td>
                  </tr>
                  <tr>
                    <td>PN001</td>
                    <td>010-02562-50</td>
                    <td>NK001</td>
                    <td>Garmin Brand Store</td>
                    <td>3,950,000 vnd</td>
                    <td>100</td>
                    <td scope="col"><i class="fa-solid fa-trash"></i></td>
                    <td scope="col"><i class="fa-solid fa-pen"></i></td>
                  </tr>
                  <tr>
                    <td>PN001</td>
                    <td>010-02562-50</td>
                    <td>NK001</td>
                    <td>Garmin Brand Store</td>
                    <td>3,950,000 vnd</td>
                    <td>100</td>
                    <td scope="col"><i class="fa-solid fa-trash"></i></td>
                    <td scope="col"><i class="fa-solid fa-pen"></i></td>
                  </tr>
                  <tr>
                    <td>PN001</td>
                    <td>010-02562-50</td>
                    <td>NK001</td>
                    <td>Garmin Brand Store</td>
                    <td>3,950,000 vnd</td>
                    <td>100</td>
                    <td scope="col"><i class="fa-solid fa-trash"></i></td>
                    <td scope="col"><i class="fa-solid fa-pen"></i></td>
                  </tr>
                </tbody>
            </table>
            <nav aria-label="Page navigation example">
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
        <div class="col-sm-2 m-2">
            <a href="KhoHangForm.html" class="btn btn-success form-control" style="margin-top: 45px;">
                Danh sách
            </a>
            <div class="card" style="padding: 10px; margin-top: 10px;">
                <b>Nhà cung cấp</b>
                <select class="form-select" aria-label="Default select example">
                    <option selected>Chọn nhà cung cấp</option>
                    <option value="1">Garmin</option>
                    <option value="2">ASH</option>
                    <option value="3">Sony</option>
                  </select>
            </div>
        </div>
    </div>
 <script src="https://kit.fontawesome.com/b6b15d6477.js" crossorigin="anonymous"></script>
</body>
</html>