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
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <style>
        .error { color: red; }
        .success { color: green; }
        .hidden { display: none; }
    </style>
</head>
<body>
    <div class="row">
          <jsp:include page="/views/page/nav.jsp"/>
        <div class="col-sm-9 m-1">
            <div class="p-1">
                <div class="text-dark p-2">
                    <h2>Thay đổi mật khẩu</h2>
                </div>
                <div class="invoice-details p-5 border rounded mt-3" style="background-color: white;">
                    <form id="changePasswordForm">
                        <div class="row mb-3 mb-4 align-items-center">
                            <div class="col-sm-6">
                                <label for="mkCu" class="form-label">Mật khẩu cũ</label>
                                <i id="mkCuIcon" class="fa-regular fa-circle-check hidden"></i>
                                <input type="password" class="form-control" id="mkCu">
                                <span id="mkCuError" class="error hidden">Mật khẩu cũ không đúng</span>
                            </div>
                        </div>
                        <div class="row mb-3 mb-4 align-items-center">
                            <div class="col-sm-6">
                                <label for="mkMoi" class="form-label">Mật khẩu mới</label>
                                <i id="mkMoiIcon" class="fa-regular fa-circle-check hidden"></i>
                                <input type="password" class="form-control" id="mkMoi">
                            </div>
                        </div>
                        <div class="row mb-3 mb-4 align-items-center">
                            <div class="col-sm-6">
                                <p id="mkMoiGuidelines">Tạo mật khẩu an toàn với các kí tự sau:</p>
                                <p id="lengthError" class="error hidden">+ Tối thiểu 12 kí tự</p>
                                <p id="uppercaseError" class="error hidden">+ Ít nhất 1 kí tự viết hoa</p>
                                <p id="lowercaseError" class="error hidden">+ Ít nhất 1 kí tự viết thường</p>
                                <p id="specialCharError" class="error hidden">+ Ít nhất 1 kí tự đặc biệt</p>
                                <p id="numberError" class="error hidden">+ Ít nhất 1 chữ số</p>
                            </div>
                        </div>
                        <div class="row mb-3 mb-4 align-items-center">
                            <div class="col-sm-6">
                                <label for="xacNhanMK" class="form-label">Xác nhận mật khẩu mới</label>
                                <i id="xacNhanMKIcon" class="fa-regular fa-circle-check hidden"></i>
                                <input type="password" class="form-control" id="xacNhanMK">
                                <span id="xacNhanMKError" class="error hidden">Mật khẩu xác nhận không khớp</span>
                            </div>
                        </div>
                        <div class="row mb-3 mb-4 align-items-center">
                            <div class="col-sm-6">
                                <button id="doiMK" class="btn btn-success custom1-btn" type="button">Đổi mật khẩu</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
<jsp:include page="/views/page/footer.jsp"/>
    <script src="https://kit.fontawesome.com/b6b15d6477.js" crossorigin="anonymous"></script>
    <script>
        document.getElementById('doiMK').addEventListener('click', function() {
            const mkCu = document.getElementById('mkCu').value;
            const mkMoi = document.getElementById('mkMoi').value;
            const xacNhanMK = document.getElementById('xacNhanMK').value;

            const oldPassword = 'Longbaby12309@@'; // Hardcoded old password

            let isValid = true;

            // Validate old password
            if (mkCu !== oldPassword) {
                document.getElementById('mkCuError').classList.remove('hidden');
                document.getElementById('mkCuIcon').classList.add('hidden');
                isValid = false;
            } else {
                document.getElementById('mkCuError').classList.add('hidden');
                document.getElementById('mkCuIcon').classList.remove('hidden');
                document.getElementById('mkCuIcon').classList.add('success');
            }

            // Validate new password
            const lengthError = mkMoi.length < 12;
            const uppercaseError = !/[A-Z]/.test(mkMoi);
            const lowercaseError = !/[a-z]/.test(mkMoi);
            const specialCharError = !/[!@#$%^&*(),.?":{}|<>]/.test(mkMoi);
            const numberError = !/[0-9]/.test(mkMoi);

            document.getElementById('lengthError').classList.toggle('hidden', !lengthError);
            document.getElementById('uppercaseError').classList.toggle('hidden', !uppercaseError);
            document.getElementById('lowercaseError').classList.toggle('hidden', !lowercaseError);
            document.getElementById('specialCharError').classList.toggle('hidden', !specialCharError);
            document.getElementById('numberError').classList.toggle('hidden', !numberError);

            if (lengthError || uppercaseError || lowercaseError || specialCharError || numberError) {
                document.getElementById('mkMoiIcon').classList.add('hidden');
                isValid = false;
            } else {
                document.getElementById('mkMoiIcon').classList.remove('hidden');
                document.getElementById('mkMoiIcon').classList.add('success');
            }

            // Validate confirm password
            if (mkMoi !== xacNhanMK) {
                document.getElementById('xacNhanMKError').classList.remove('hidden');
                document.getElementById('xacNhanMKIcon').classList.add('hidden');
                isValid = false;
            } else {
                document.getElementById('xacNhanMKError').classList.add('hidden');
                document.getElementById('xacNhanMKIcon').classList.remove('hidden');
                document.getElementById('xacNhanMKIcon').classList.add('success');
            }

            if (isValid) {
                alert('Mật khẩu đã được thay đổi thành công!');
            }
        });

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
    