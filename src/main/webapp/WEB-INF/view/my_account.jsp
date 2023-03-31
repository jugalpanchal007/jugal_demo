<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
   <head>

    <title>RRMart - My Account</title>
       <%@include file="./menu/head.jsp"%>
      
   </head>
   <body class="fixed-bottom-padding">
   <div class="preloader-div">
      <div class="preloaderBg" id="preloader">
         <div class="preloader">
            <div class="preloader2"></div>
         </div>
     </div>
   </div>
      
      <div class="osahan-account">
         <div class="p-3 border-bottom">
            <div class="d-flex align-items-center">
               <h5 class="font-weight-bold m-0">My Account</h5>
               <a class="toggle ml-auto" href="#"><i class="icofont-navigation-menu"></i></a>
            </div>
         </div>
         <div class="p-4 profile text-center border-bottom">
            <img src="/app/img/logo.png" class="img-fluid rounded-pill">
            <h6 class="font-weight-bold m-0 mt-2" id="contactName">VasyERP Solutions Pvt. Ltd.</h6>
            <p class="small text-muted mb-1" id="contactMobileNo">example@gmail.com</p>
            <p><i class="icofont-wallet"></i> Wallet Balance :  <span id="walletBalance">0</span></p>
            <a href="editprofile" class="btn btn-danger btn-sm"><i class="icofont-pencil-alt-5"></i> Edit Profile</a>
         </div>
         <div class="account-sections">
            <ul class="list-group">
               <c:if test="${not empty sessionScope.contactId}" >
                  <a href="/wallet/transactions" class="text-decoration-none text-dark">
                     <li class="border-bottom bg-white d-flex align-items-center p-3">
                        <i class="icofont-wallet osahan-icofont bg-info"></i>Wallet Transaction
                        <span class="badge badge-info p-1 badge-pill ml-auto"><i class="icofont-simple-right"></i></span>
                     </li>
                  </a>
                  <a href="/myaddress" class="text-decoration-none text-dark">
                     <li class="border-bottom bg-white d-flex align-items-center p-3">
                        <i class="icofont-address-book osahan-icofont bg-dark"></i>My Address
                        <span class="badge badge-success p-1 badge-pill ml-auto"><i class="icofont-simple-right"></i></span>
                     </li>
                  </a>
               </c:if>
               <a href="/terms" class="text-decoration-none text-dark">
                  <li class="border-bottom bg-white d-flex align-items-center p-3">
                     <i class="icofont-info-circle osahan-icofont bg-primary"></i>Terms, Privacy & Policy
                     <span class="badge badge-success p-1 badge-pill ml-auto"><i class="icofont-simple-right"></i></span>
                  </li>
               </a>
               <a href="/helpSupport" class="text-decoration-none text-dark">
                  <li class="border-bottom bg-white d-flex align-items-center p-3">
                     <i class="icofont-phone osahan-icofont bg-warning"></i>Help & Support
                     <span class="badge badge-success p-1 badge-pill ml-auto"><i class="icofont-simple-right"></i></span>
                  </li>
               </a>
               <a href="/userlogout" class="text-decoration-none text-dark" onclick="logoutFnc();">
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
      <!-- Navmenu START -->
   <%@include file="./menu/footer.jsp"%>
   <%@include file="./signup-bonus-modal.jsp"%>

   <%@include file="./menu/sidenav.jsp"%>
   <%@include file="./footerjs.jsp"%>
      <script>
      
         // $.blockUI({
         //    message:'<p style="margin-bottom:0px;">Currently This Service is Not Available</p>'
         // })

         $(function () {
            
            $("#contactName").html('${sessionScope.contactName}');
            $("#contactMobileNo").html('${sessionScope.contactMobileNo}');
            $("#walletBalance").html('${sessionScope.walletBalance}');

            // $(".profile").click(function (e) { 
            //    e.preventDefault();
            //    Swal.fire({
            //          icon: 'warning',
            //          title: 'Oops...',
            //          text: 'Currently this Service Is Not available...!!!',
            //       }).then((result) => {
            //          if (result.isConfirmed) {
            //             // $("#mobileNo").focus();
            //          }
            //       })
               
            // });
            $(".preloader-div").remove();

         });
      </script> 
      
   </body>
</html>