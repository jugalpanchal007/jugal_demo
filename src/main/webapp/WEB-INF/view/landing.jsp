<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
   <head>

      <title>RRMart - Landing Page</title>

      <%@include file="./menu/head.jsp"%>
   </head>
   <body class="fixed-bottom-padding p-0">
      <div class="theme-switch-wrapper">
         <label class="theme-switch" for="checkbox">
            <input type="checkbox" id="checkbox" />
            <div class="slider round"></div>
            <i class="icofont-moon"></i>
         </label>
         <em>Enable Dark Mode!</em>
      </div>
      <!-- landing page -->
      <div class="landing-page bg-white">
         <a class="position-absolute btn-sm btn btn-outline-danger m-4 zindex" href="/signin">Skip <i class="icofont-bubble-right"></i></a>         <!-- slider -->
         <div class="osahan-slider m-0">
            <div class="osahan-slider-item text-center">
               <div class="d-flex align-items-center justify-content-center vh-100 flex-column">
                  <i class="icofont-sale-discount display-1 text-danger"></i>
                  <h4 class="my-4 text-dark">Best Prices & Offers</h4>
                  <p class="text-center text-muted mb-5 px-4">Cheaper prices than your local supermarket, great cashback offers to top it off.</p>
               </div>
            </div>
            <div class="osahan-slider-item text-center">
               <div class="d-flex align-items-center justify-content-center vh-100 flex-column">
                  <i class="icofont-cart display-1 text-danger"></i>
                  <h4 class="my-4 text-dark">Wide Assortment</h4>
                  <p class="text-center text-muted mb-5 px-4">Choose from 5000+ products across food, personal care, household & other categories.</p>
               </div>
            </div>
            <div class="osahan-slider-item text-center">
               <div class="d-flex align-items-center justify-content-center vh-100 flex-column">
                  <i class="icofont-support-faq display-1 text-danger"></i>
                  <h4 class="my-4 text-dark">Easy Returns</h4>
                  <p class="text-center text-muted mb-5 px-4">Not satisfied with a product? Return it at the doorstep & get a refund within hours.</p>
               </div>
            </div>
         </div>
      </div>
      <!-- footer fixed -->
      <div class="osahan-fotter fixed-bottom">
         <a href="/signin" class="btn btn-danger btn-lg fixed-bottom">Get Started</a>
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