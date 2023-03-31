<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
   <head>
      <title>RRMart - Order Success</title>
      <%@include file="./menu/head.jsp"%>
   </head>
   <body>
      <div class="theme-switch-wrapper">
         <label class="theme-switch" for="checkbox">
            <input type="checkbox" id="checkbox" />
            <div class="slider round"></div>
            <i class="icofont-moon"></i>
         </label>
         <em>Enable Dark Mode!</em>
      </div>
      <div class="osahan-success bg-success vh-100">
         <div class="p-5 text-center">
            <i class="icofont-check-circled display-1 text-warning"></i>
            <h1 class="text-white font-weight-bold"><c:if test="${not empty sessionScope.contactName}" >${sessionScope.contactName} ,</c:if> Your order has been successful 🎉</h1>
            <%-- <p class="text-white">Check your order status in <a href="complete_order.html" class="font-weight-bold text-decoration-none text-white">My Order</a> about next steps information.</p> --%>
         </div>
      </div>
      <!-- continue -->
      <div class="fixed-bottom fixed-bottom-auto bg-white rounded p-3 m-3 text-center">
         <h6 class="font-weight-bold mb-2">Thank You For Shoping With Us</h6>
         <%-- <p class="small text-muted">Your order will be prepared and will come soon</p> --%>
         <a href="/home" class="btn rounded btn-warning btn-lg btn-block">Continue Shoping</a>
      </div>
      <%@include file="./menu/sidenav.jsp"%>
      <!-- Bootstrap core JavaScript -->
      <script src="/app/vendor/jquery/jquery.min.js"></script>
      <script src="/app/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
      <!-- slick Slider JS-->
      <script type="text/javascript" src="/app/vendor/slick/slick.min.js"></script>
      <script src="/app/vendor/preloader/js/jquery.preloader.min.js"></script>
      <script src="/app/vendor/toastr.js"></script>
      <!-- Sidebar JS-->
      <script type="text/javascript" src="/app/vendor/sidebar/hc-offcanvas-nav.js"></script>
      <!-- Custom scripts for all pages-->
      <script src="/app/js/osahan.js"></script>
      <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
   </body>
</html>