<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
   <head>
      <title>RRMart - T & C</title>
      <%@include file="./menu/head.jsp"%>
   </head>
   <body class="fixed-bottom-padding">
      
      <div class="osahan-help">
         <div class="p-3 border-bottom">
            <div class="d-flex align-items-center">
               <a class="font-weight-bold text-danger text-decoration-none" href="/myaccount">
               <i class="icofont-rounded-left back-page"></i></a>
               <a class="toggle ml-auto" href="#"><i class="icofont-navigation-menu"></i></a>
            </div>
         </div>
      </div>
      <div class="help_support">
         <div class="border-bottom">
            <a href="/termsAndConditions" class="text-decoration-none"><button class="p-3 bg-white d-flex align-items-center btn w-100" type="button">
            Terms & Conditions 
            <i class="text-danger icofont-rounded-right ml-auto"></i>
            </button></a>
         </div>
         <div class="border-bottom">
            <a href="/privacy" class="text-decoration-none"><button class="p-3 bg-white d-flex align-items-center btn w-100" type="button">
            Privacy Policy
            <i class="text-danger icofont-rounded-right ml-auto"></i>
            </button></a>
         </div>
         <div class="border-bottom">
            <a href="/refundPayment" class="text-decoration-none"><button class="p-3 bg-white d-flex align-items-center btn w-100" type="button">
            Refund Policy 
            <i class="text-danger icofont-rounded-right ml-auto"></i>
            </button></a>
         </div>
      </div>
      <%@include file="./menu/footer.jsp"%>

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
      <script src="/app/vendor/preloader/js/jquery.preloader.min.js"></script>
      <script src="/app/js/globalscript.js"></script>


      <script>

         $(function () {

            

         });
      </script> 
   </body>
</html>