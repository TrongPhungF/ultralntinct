<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="bootstrap-5.3.3-dist/js/bootstrap.bundle.min.js"></script>

<%
if (request.getAttribute("errorMessage") != null) {
%>
<script>
  showErrorDialog('<%=request.getAttribute("errorMessage")%>');
</script>
<%
}
%>

<div class="modal fade" id="errorModal" tabindex="-1" aria-labelledby="errorModalLabel" aria-hidden="true">
 <div class="modal-dialog" role="document">
  <div class="modal-content">
   <div class="modal-header">
    <h5 class="modal-title" id="errorModalLabel">Thất Bại</h5>
    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
   </div>
   <div class="modal-body">
    <p id="errorMessage"></p>
   </div>
   <div class="modal-footer">
    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
   </div>
  </div>
 </div>
</div>

<div class="modal fade" id="successModal" tabindex="-1" aria-labelledby="successMessageLabel" aria-hidden="true">
 <div class="modal-dialog" role="document">
  <div class="modal-content">
   <div class="modal-header">
    <h5 class="modal-title" id="successMessageLabel">Thành Công</h5>
    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
   </div>
   <div class="modal-body">
    <p id="successMessage"></p>
   </div>
   <div class="modal-footer">
    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
   </div>
  </div>
 </div>
</div>

<script>

function showErrorDialog(message) {
    document.getElementById('errorMessage').textContent = message;
    var errorModal = new bootstrap.Modal(document.getElementById('errorModal'));
    errorModal.show();
}

function showSuccessDialog(message) {
 document.getElementById('successMessage').textContent = message;
 var successModal = new bootstrap.Modal(document.getElementById('successModal'));
 successModal.show();
}

  const navItems = document.querySelectorAll('.nav-item');
  navItems.forEach(item => {
    item.addEventListener('click', () => {
      navItems.forEach(i => i.classList.remove('active'));
      item.classList.add('active');
    });
  });
</script>