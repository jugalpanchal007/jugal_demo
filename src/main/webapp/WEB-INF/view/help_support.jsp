<!DOCTYPE html>
<html lang="en">

<head>
 
   <title>RRMart - Help & Support</title>
   <%@include file="./menu/head.jsp"%>
</head>

<body class="fixed-bottom-padding">
  
   <div class="osahan-help">
      <div class="p-3 border-bottom">
         <div class="d-flex align-items-center">
            <a class="font-weight-bold text-danger text-decoration-none" href="/myaccount">
               <i class="icofont-rounded-left back-page"></i></a>
            <h6 class="font-weight-bold m-0 ml-3">Help & Support</h6>
            <a class="toggle ml-auto" href="#"><i class="icofont-navigation-menu"></i></a>
         </div>
      </div>
   </div>
   <div class="p-3" id="content">
      
      
   </div>

   <div class="osahan-account">
      <h4 class="mb-3 text-center">Help & Support</h4>
      <div class="p-4 profile text-center border-bottom">
         <img src="/app/img/logo.png" class="img-fluid " style="border-radius: 5px;">
         <h6 class="font-weight-bold m-0 mt-2" id="contactName">RRMart</h6>
         <p>Below Provided contact details for help and support, feel free to contact us</p>
         
      </div>
      <div class="account-sections">
         <ul class="list-group">
            <a href="tel:+918690057150" class="text-decoration-none text-dark">
               <li class="border-bottom bg-white d-flex align-items-center p-3">
                  <i class="icofont-phone osahan-icofont bg-warning"></i> +91-86900 57150
                  <span class="badge badge-info p-1 badge-pill ml-auto"><i class="icofont-simple-right"></i></span>
               </li>
            </a>
            <a href="mailto:care@rrmart.in" class="text-decoration-none text-dark">
               <li class="border-bottom bg-white d-flex align-items-center p-3">
                  <i class="icofont-email osahan-icofont bg-info"></i>  care@rrmart.in
                  <span class="badge badge-info p-1 badge-pill ml-auto"><i class="icofont-simple-right"></i></span>
               </li>
            </a>
            <a href="/logout" class="text-decoration-none text-dark" onclick="logoutFnc();">
               <li class="border-bottom bg-white d-flex  align-items-center p-3">
                  <i class="icofont-lock osahan-icofont bg-danger"></i> Logout
               </li>
            </a>
            <script>

               logoutFnc = () => {
                  localStorage.clear();
               }
             </script>
         </ul>
      </div>
   </div>

   <%@include file="./menu/footer.jsp"%>
   <%@include file="./signup-bonus-modal.jsp"%>

   <%@include file="./menu/sidenav.jsp"%>
   <!-- Bootstrap core JavaScript -->
   <script src="/app/vendor/jquery/jquery.min.js"></script>
   <script src="/app/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
   <!-- slick Slider JS-->
   <script type="text/javascript" src="/app/vendor/slick/slick.min.js"></script>
   <!-- Sidebar JS-->
   <!-- Include JS START-->
   <script src="/app/vendor/preloader/js/jquery.preloader.min.js"></script>
   <script src="/app/vendor/toastr.js"></script>

   <script src="/app/js/globalscript.js"></script>

   <!-- Include Js END -->
   <script type="text/javascript" src="/app/vendor/sidebar/hc-offcanvas-nav.js"></script>
   <!-- Custom scripts for all pages-->
   <script src="/app/js/osahan.js"></script>
   <!-- sweet alert 2 CDN -->
   <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
   <script>
      $(function () {

         

      });
   </script>
</body>

</html>