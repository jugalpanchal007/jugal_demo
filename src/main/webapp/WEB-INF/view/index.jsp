<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
   <head>

      <title>RRMart</title>
      <%@include file="./menu/head.jsp"%>
   
   </head>
   <body class="fixed-bottom-padding pb-0">
      <div class="theme-switch-wrapper">
         <label class="theme-switch" for="checkbox">
            <input type="checkbox" id="checkbox" />
            <div class="slider round"></div>
            <i class="icofont-moon"></i>
         </label>
         <em>Enable Dark Mode!</em>
      </div>
      <!-- Get Started -->
      <div class="d-flex align-items-center justify-content-center flex-column vh-100 osahan-get_started">
         <a class="text-center" href="/landing">
            <img src="/app/img/logo.png" class="gs-logo mb-3" alt="">
            <h2 class="font-weight-bold text-danger">RRMart</h2>
            <p class="text-dark">Your daily needs.</p>
         </a>
      </div>
      <!-- footer fixed -->
      <div class="osahan-fotter fixed-bottom">
         <a href="/landing" class="btn btn-danger btn-lg fixed-bottom">Get Started</a>
      </div>
      <!-- Navmenu START -->
      <%@include file="./menu/sidenav.jsp"%>
      <!-- Navmenu END -->
      <!-- Bootstrap core JavaScript -->
      <script src="/app/vendor/jquery/jquery.min.js"></script>
      <script src="/app/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
      <!-- slick Slider JS-->
      <script type="text/javascript" src="/app/vendor/slick/slick.min.js"></script>
      <!-- Sidebar JS-->
      <script type="text/javascript" src="/app/vendor/sidebar/hc-offcanvas-nav.js"></script>
      <!-- Custom scripts for all pages-->
      <script src="/app/js/osahan.js"></script>
   </body>
</html>