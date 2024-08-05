<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="UTF-8">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ultra Instinct</title>
    <jsp:include page="/views/page/header.jsp"/>
    <link rel="stylesheet" href="css/index.css">
    <style>
        /* Include the CSS here if not using external stylesheet */
    </style>
</head>
<body>
<div class="row">
        <jsp:include page="/views/page/nav.jsp"/>
    <div class="col-6 mt-2">
            <div class="p-2" style="background-color: #27AE60; border-radius: 5px;">
              <div class="input-group">
                <span class="input-group-text"><i class="fa-solid fa-magnifying-glass"></i></span>
                <input class="form-control" placeholder="Tìm kiếm mã sản phẩm">
              </div>
            </div>
            <table class="table" style="margin-top: 10px;">
              <thead>
                <tr>
                  <th scope="col">STT</th>
                  <th scope="col">Mã sản phẩm</th>
                  <th scope="col">Tên sản phẩm</th>
                  <th scope="col">Số lượng</th>
                  <th scope="col">Giá bán</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1</td>
                  <td>010-02562-50</td>
                  <td>Garmin forerunner 55 xám</td>
                  <td>1</td>
                  <td>5,025,000 vnd</td>
                </tr>
              </tbody>
          </table>
      </div>
            
        <div class="col-5 m-2" style="margin-top: 10px; width: 480px;">
            <div class="card">
                <div class="card-body">
                    <div class="row btn-group align-items-center">
                        <div class="col-sm-3">
                          <select class="form-select">
                            <option>Bán nhanh</option>
                            <option>Bán giao hàng</option>
                          </select>
                        </div>
                        <div class="col-sm-9 text-end">
                          10/09/2004 19:30
                        </div>
                      </div>
                    <div class="row" style="margin-top: 10px; margin-left: 0px; width: 430px;">
                        <input type="search" id="form1" class="form-control p-2" placeholder="Tìm kiếm mã khách hàng" />
                        <button class="plus"><i class="fa-solid fa-plus" data-bs-toggle="modal" data-bs-target="#exampleModal"></i></button>
                    </div>
                    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog modal-dialog-centered">
                          <div class="modal-content">
                            <div class="modal-header bg-white border-0">
                              <h4 class="modal-title" id="exampleModalLabel">Thêm khách hàng</h4>
                              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <div class="themkh row align-items-center">
                                    <label class="col-sm-4">Mã khách hàng</label> <input placeholder="Nhập mã khách hàng" class="ipthemkh form-control col-sm-8">
                                </div>
                                <div class="themkh row align-items-center">
                                    <label class="col-sm-4">Tên khách hàng</label> <input placeholder="Nhập tên khách hàng" class="ipthemkh form-control col-sm-8">
                                </div>
                                <div class="themkh row align-items-center">
                                    <label class="col-sm-4">Số điện thoại</label> <input placeholder="Nhập số điện thoại" class="ipthemkh form-control col-sm-8">
                                </div>
                                <div class="themkh row align-items-center">
                                    <label class="col-sm-4">Địa chỉ</label> <input placeholder="Nhập địa chỉ" class="ipthemkh form-control col-sm-8">
                                </div>
                                <div class="themkh row align-items-center">
                                    <label class="col-sm-4">Giới tính</label>
                                    <div class="col-sm-8 btn-group">
                                      <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1">
                                        <label class="form-check-label" for="inlineRadio1">Nam</label>
                                      </div>
                                      <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2">
                                        <label class="form-check-label" for="inlineRadio2">Nữ</label>
                                      </div>
                                    </div>
                                </div>
                                <div class="themkh row align-items-center">
                                    <label class="col-sm-4">Email</label> <input placeholder="Nhập Email" class="ipthemkh form-control col-sm-8">
                                </div>
                            </div>
                            <div class="modal-footer bg-white border-0">
                              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
                              <button type="button" class="btn btn-primary">Lưu</button>
                            </div>
                          </div>
                        </div>
                    </div>
                    <div style="margin-top: 20px; margin-left: 0px; ">
                      <div class="row d-flex align-items-center" style="flex-wrap: nowrap; margin-bottom: 10px;">
                       <input class="form-control" style="width: 150px;margin-left:13px;" placeholder="Mã khách hàng">
                       <input class="form-control " style="width: 200px;margin-left:40px;" placeholder="Tên khách hàng">
                      </div>         
                      <table class="table" style="margin-top: 10px;">
                        <thead>
                          <tr>
                            <th scope="col">STT</th>
                            <th scope="col">Tên SP</th>
                            <th scope="col">Số lượng</th>
                            <th scope="col">Giá bán</th>
                            <th scope="col">Tổng</th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr>
                            <td>1</td>
                            <td>Garmin forerunner 55 xám</td>
                            <td>1</td>
                            <td>5,025,000 vnd</td>
                            <td>5,025,000 vnd</td>
                          </tr>
                        </tbody>
                    </table>
                    <div class="row m-2 align-content-center">
                    Tổng tiền
                    <b class="text-end" style="margin-top: -30px;">1,000,000 vnđ</b>
                    </div>
                    
                    </div>
                </div>
                <div class="card-footer bg-white border-0">
                    <button class="btn btn-success w-100">Thanh toán</button>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="/views/page/footer.jsp"/>
<script src="https://kit.fontawesome.com/b6b15d6477.js" crossorigin="anonymous"></script>
<script>
document.addEventListener('DOMContentLoaded', function () {
    const navItems = document.querySelectorAll('.nav-item');
    navItems.forEach(item => {
        item.addEventListener('click', () => {
            navItems.forEach(i => i.classList.remove('active'));
            item.classList.add('active');
        });
    });
});
</script>
</body>
</html>