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
</head>
<body>
    <div class="row">
    <jsp:include page="/views/page/nav.jsp"/>

        <div class="col-sm-9 m-1">
            <div class="p-1">
                <div class="invoice-details p-3 border rounded mt-3" style="background-color: white;">
                    <form>
                        <div class="text-center mb-5">
                            <h3>Thông tin người dùng</h3>
                        </div>
                        <div class="row mb-3 mb-4 align-items-center">
                            <div class="col-sm-6">
                                <label for="maNV" class="form-label">Mã nhân viên</label>
                                <input type="text" class="form-control" id="maNV" >
                           
                        </div>
                        </div>
                       
                        <div class="row mb-3 mb-4">
                            <!-- Cặp 1 -->
                            <div class="col-sm-6">
                                <div class="row align-items-center">
                                    <div class="col-sm-12">
                                        <label for="tenNV" class="form-label">Tên nhân viên</label>
                                        <input type="text" class="form-control" id="tenNV">
                                    </div>
                                </div>
                            </div>
                            
                            <!-- Cặp 2 -->
                            <div class="col-sm-6">
                                <div class="row align-items-center">
                                    <div class="col-sm-12">
                                        <label for="hoNV" class="form-label">Họ nhân viên</label>
                                
                                        <input type="text" class="form-control" id="hoNV">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row mb-3 mb-4 align-items-center">
                            <div class="col-sm-6">
                                <label for="soDT" class="form-label">Số điện thoại</label>
                                <input type="number" class="form-control" id="soDT" >
                           
                        </div>
                        </div>
                        <div class="row mb-3 mb-4 align-items-center">
                            <div class="col-sm-6">
                                <label for="diaChi" class="form-label">Địa chỉ</label>
                                <input type="text" class="form-control" id="diaChi" >
                           
                        </div>
                        </div>
                    </form>
                    <div class="text-end mt-auto">
                        <button id="huy" class="btn btn-danger custom1-btn ">Hủy</button>
                        <button id="luu" class="btn btn-success custom1-btn">Lưu</button>
                    </div>
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

    