<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="UTF-8">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Ultra Instinct</title>
            <jsp:include page="/views/page/header.jsp" />
            <link rel="stylesheet" href="css/index.css">
            <style>
            </style>
        </head>

        <body>
            <div class="row">
                <jsp:include page="/views/page/nav.jsp" />
                <div class="col-6">
                    <div class="p-2" style="background-color: #27AE60; border-radius: 5px;">
                        <div class="input-group">
                            <form action="${pageContext.request.contextPath}/ban-hang" class="search-form">
                                <input class="form-control" name="sanPhamKeySearch" placeholder="Tìm kiếm mã sản phẩm">
                                <button class="btn" type="submit">Tìm kiếm</button>
                            </form>
                        </div>
                    </div>
                    <table class="table" style="margin-top: 10px;">
                        <thead>
                            <tr>
                                <th scope="col" style="width: 5%;">STT</th>
                                <th scope="col" style="width: 20%;">Mã sản phẩm</th>
                                <th scope="col" style="width: 30%;">Tên sản phẩm</th>
                                <th scope="col" style="width: 10%;">Số lượng</th>
                                <th scope="col" style="width: 15%;">Giá bán</th>
                                <th scope="col" style="width: 15%;">Hình ảnh</th>
                                <th scope="col" style="width: 5%;"></th>
                            </tr>
                        </thead>
                        <tbody id="productTableBody">
                            <c:forEach var="sanPham" items="${sanPhamList}" varStatus="status">
                                <tr>
                                    <td style="width: 5%;">
                                        <c:out value="${status.index + 1}" />
                                    </td>
                                    <td style="width: 20%;">
                                        <c:out value="${sanPham.maSanPham}" />
                                    </td>
                                    <td style="width: 30%;"><a
                                            href="${pageContext.request.contextPath}/chi-tiet-san-pham?maSanPham=${sanPham.maSanPham}">
                                            <c:out value="${sanPham.tenSanPham}" />
                                        </a></td>
                                    <td style="width: 10%;">
                                        <c:out value="${sanPham.soLuongTon}" />
                                    </td>
                                    <td style="width: 5%;">
                                        <c:out value="${sanPham.giaNiemYet}" />
                                    </td>
                                    <td style="width: 15%;"><img
                                            src="${sanPham.hinh != null ? sanPham.hinh : 'img/unnamed.png'}"
                                            alt="Hình sản phẩm" width="100" height="100" /></td>
                                    <td><a href="#"> <i class="fa-solid fa-plus"
                                                onclick="addSanPhamByMaSanPham('${sanPham.maSanPham}')"></i></a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>

                <div class="col-6" style="margin-top: 10px; width: 550px;">
                    <div class="card">
                        <div class="card-body">
                            <div class="row btn-group align-items-center">
                                <div class="col-sm-3">
                                    <select class="form-select">
                                        <option>Bán nhanh</option>
                                        <option>Bán giao hàng</option>
                                    </select>
                                </div>
                                <div class="col-sm-9 text-end">10/09/2004 19:30</div>
                            </div>
                            <div class="row" style="margin-top: 10px; margin-left: 0px; width: 430px;">
                                <form action="${pageContext.request.contextPath}/ban-hang">
                                    <input type="search" name="inputMaKhachHang" class="form-control p-2"
                                        placeholder="Tìm kiếm mã khách hàng" />
                                    <button class="plus">
                                        <i class="fa-solid fa-plus"></i>
                                    </button>
                                </form>
                            </div>
                            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                                aria-hidden="true">
                                <div class="modal-dialog modal-dialog-centered">
                                    <div class="modal-content">
                                        <div class="modal-header bg-white border-0">
                                            <h4 class="modal-title" id="exampleModalLabel">Thêm khách hàng</h4>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            <div class="themkh row align-items-center">
                                                <label class="col-sm-4">Mã khách hàng</label> <input
                                                    placeholder="Nhập mã khách hàng"
                                                    class="ipthemkh form-control col-sm-8">
                                            </div>
                                            <div class="themkh row align-items-center">
                                                <label class="col-sm-4">Tên khách hàng</label> <input
                                                    placeholder="Nhập tên khách hàng"
                                                    class="ipthemkh form-control col-sm-8">
                                            </div>
                                            <div class="themkh row align-items-center">
                                                <label class="col-sm-4">Số điện thoại</label> <input
                                                    placeholder="Nhập số điện thoại"
                                                    class="ipthemkh form-control col-sm-8">
                                            </div>
                                            <div class="themkh row align-items-center">
                                                <label class="col-sm-4">Địa chỉ</label> <input
                                                    placeholder="Nhập địa chỉ" class="ipthemkh form-control col-sm-8">
                                            </div>
                                            <div class="themkh row align-items-center">
                                                <label class="col-sm-4">Giới tính</label>
                                                <div class="col-sm-8 btn-group">
                                                    <div class="form-check form-check-inline">
                                                        <input class="form-check-input" type="radio"
                                                            name="inlineRadioOptions" id="inlineRadio1" value="option1">
                                                        <label class="form-check-label" for="inlineRadio1">Nam</label>
                                                    </div>
                                                    <div class="form-check form-check-inline">
                                                        <input class="form-check-input" type="radio"
                                                            name="inlineRadioOptions" id="inlineRadio2" value="option2">
                                                        <label class="form-check-label" for="inlineRadio2">Nữ</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="themkh row align-items-center">
                                                <label class="col-sm-4">Email</label> <input placeholder="Nhập Email"
                                                    class="ipthemkh form-control col-sm-8">
                                            </div>
                                        </div>
                                        <div class="modal-footer bg-white border-0">
                                            <button type="button" class="btn btn-secondary"
                                                data-bs-dismiss="modal">Hủy</button>
                                            <button type="button" class="btn btn-primary">Lưu</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <form action="${pageContext.request.contextPath}/ban-hang">
                            <div style="margin-top: 20px; margin-left: 0px;">
                                <div class="row d-flex align-items-center"
                                    style="flex-wrap: nowrap; margin-bottom: 10px;">
                                    <input readonly class="form-control" style="width: 150px; margin-left: 13px;"
                                        placeholder="Mã khách hàng" id="maKhachHang" value="${khachHang.maKhachHang}">
                                    <input id="tenKhachHang" class="form-control "
                                        style="width: 200px; margin-left: 40px;" placeholder="Tên khách hàng"
                                        value="${khachHang.tenKH}">
                                </div>
                                <table class="table" style="margin-top: 10px; font-size: 9px;">
                                    <thead>
                                        <tr>
                                            <th scope="col" style="width: 5%;">STT</th>
                                            <th scope="col" style="width: 20%;">Mã sản phẩm</th>
                                            <th scope="col" style="width: 30%;">Tên SP</th>
                                            <th scope="col" style="width: 10%;">Số lượng</th>
                                            <th scope="col" style="width: 5%;">Giá bán</th>
                                            <th scope="col" style="width: 10%;">Hình ảnh</th>
                                            <th scope="col" style="width: 5%;">Tổng</th>
                                        </tr>
                                    </thead>
                                    <tbody id="productTableBodyAdd" style="font-size: 8px;">
                                    </tbody>
                                </table>
                                <div class="row m-2 align-content-center">
                                    Tổng tiền <b class="text-end" id="totalPrice" style="margin-top: -30px;"></b>
                                </div>
                                <div class="card-footer bg-white border-0">
                                    <button type="submit" class="btn btn-success w-100">Thanh toán</button>
                                </div>
                            </div>
                        </form>
                        </div>
                    </div>


                </div>
            </div>
            </div>
            <jsp:include page="/views/page/footer.jsp" />
            <script src="https://kit.fontawesome.com/b6b15d6477.js" crossorigin="anonymous"></script>
            <script>
                document.addEventListener('DOMContentLoaded', function () {
                    setupNavItems();
                });

                function setupNavItems() {
                    const navItems = document.querySelectorAll('.nav-item');
                    navItems.forEach(item => {
                        item.addEventListener('click', () => {
                            navItems.forEach(i => i.classList.remove('active'));
                            item.classList.add('active');
                        });
                    });
                }

                function clearCustomerData(maKhachHangSpan, tenKhachHangSpan) {
                    maKhachHangSpan.textContent = '';
                    tenKhachHangSpan.textContent = '';
                }

                function addSanPhamByMaSanPham(maSanPham) {
                    var inputMaKhacHang = document.getElementById('maKhachHang').value;

                    if (!inputMaKhacHang) {
                        alert('Vui lòng nhập mã khách hàng trước khi thêm sản phẩm.');
                        return;
                    }

                    var rowToClone = findRowByMaSanPham(maSanPham, 'productTableBody');
                    if (rowToClone) {
                        var updateTableBody = document.getElementById('productTableBodyAdd');
                        var duplicateRow = findRowByMaSanPham(maSanPham, 'productTableBodyAdd');
                        if (duplicateRow) {
                            incrementQuantityAndTotal(duplicateRow);
                        } else {
                            cloneAndAppendRow(rowToClone, updateTableBody);
                        }
                        updateTotalPrice();
                    } else {
                        console.error('Row not found for maSanPham:', maSanPham);
                    }
                }

                function findRowByMaSanPham(maSanPham, tableBodyId) {
                    var rows = document.getElementById(tableBodyId).getElementsByTagName('tr');
                    for (let i = 0; i < rows.length; i++) {
                        var cells = rows[i].getElementsByTagName('td');
                        console.log(rows[i])
                        if (cells[1].textContent.trim() === maSanPham.trim()) {
                            return rows[i];
                        }
                    }
                    return null;
                }

                function incrementQuantityAndTotal(row) {
                    const quantityCell = row.getElementsByTagName('td')[3];
                    const currentQuantity = parseInt(quantityCell.textContent);
                    quantityCell.textContent = currentQuantity + 1;

                    const priceCell = row.getElementsByTagName('td')[4];
                    const totalCell = row.getElementsByTagName('td')[6];
                    const price = parseInt(priceCell.textContent.replace(/[^0-9]/g, ''));
                    totalCell.textContent = (price * (currentQuantity + 1)).toLocaleString('vi-VN', { style: 'currency', currency: 'VND' });
                }

                function cloneAndAppendRow(rowToClone, updateTableBody) {
                    const newRow = rowToClone.cloneNode(true);

                    const actionCell = newRow.getElementsByTagName('td')[6];
                    actionCell.textContent = newRow.getElementsByTagName('td')[4].textContent;

                    const quantityCell = newRow.getElementsByTagName('td')[3];
                    quantityCell.textContent = '1';

                    updateTableBody.appendChild(newRow);
                }

                function updateTotalPrice() {
                    const updateTableBody = document.getElementById('productTableBodyAdd');
                    const updateRows = updateTableBody.getElementsByTagName('tr');
                    let total = 0;

                    for (let i = 0; i < updateRows.length; i++) {
                        const totalCell = updateRows[i].getElementsByTagName('td')[6];
                        const price = parseInt(totalCell.textContent.replace(/[^0-9]/g, ''));
                        total += price;
                    }
                    document.getElementById('totalPrice').textContent = total.toLocaleString('vi-VN', { style: 'currency', currency: 'VND' });
                }
            </script>
        </body>

        </html>