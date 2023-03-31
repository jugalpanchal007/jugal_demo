<!DOCTYPE html>
<html lang="en">

<head>
   <title>RRMart - Refer & Earn</title>
   <%@include file="./menu/head.jsp"%>
</head>

<body class="fixed-bottom-padding">
<div class="preloader-div">
      <div class="preloaderBg" id="preloader" onload="preloader()">
         <div class="preloader">
            <div class="preloader2"></div>
         </div>
     </div>
   </div>
   
   <!-- home page -->
   <div class="osahan-home-page">
      <div class="border-bottom p-3">
         <div class="title d-flex align-items-center">
            <a href="/home" class="text-decoration-none text-dark d-flex align-items-center">
               <img class="osahan-logo mr-2" src="/app/img/logo.png">
               <h4 class="font-weight-bold text-danger m-0">RRMart</h4>
            </a>
            <p class="ml-auto m-0">
               <!-- <a href="notification.html" class="text-decoration-none bg-white p-1 rounded shadow-sm d-flex align-items-center">
                  <i class="text-dark icofont-notification"></i>
                  <span class="badge badge-danger p-1 ml-1 small">2</span>
                  </a> -->
            </p>
            <a class="toggle ml-3" href="#"><i class="icofont-navigation-menu"></i></a>
         </div>
         <!-- <a href="search.html" class="text-decoration-none">
               <div class="input-group mt-3 rounded shadow-sm overflow-hidden bg-white">
                  <div class="input-group-prepend">
                     <button class="border-0 btn btn-outline-secondary text-success bg-white"><i class="icofont-search"></i></button>
                  </div>
                  <input type="text" class="shadow-none border-0 form-control pl-0" placeholder="Search for Products.." aria-label="" aria-describedby="basic-addon1">
               </div>
            </a> -->
      </div>
      <!-- body -->
      <div class="osahan-body">
         <div class="osahan-promo">

            <a href="#" class="text-decoration-none text-white">
               <div class="bg-danger p-3 text-white">
                  <div class="row align-items-center">
                     <div class="col-6">
                        <div class="d-flex align-items-center">
                           <!-- <img class="p-osahan-logo" src="img/logo.png"> -->
                           <div class="brand ml-2">
                              <h5 class="m-0">Refer & Earn</h5>
                           </div>
                        </div>
                        <div class="pt-3">
                           <p class="btn btn-outline-light mb-0"><i class="icofont-tag mr-1"></i>
                           <c:choose><c:when test="${not empty sessionScope.referralBonus}">${sessionScope.referralBonus}</c:when><c:otherwise>0</c:otherwise></c:choose>
                            Rcoins on
                              referring a friend.</p>
                        </div>
                     </div>
                     <div class="col-6 text-center">
                        <img src="/app/img/promos/refer-and-earn.jpeg" class="img-fluid"
                           style="border-radius: 5px; border: 2px solid;">
                     </div>
                  </div>
               </div>
            </a>
            <a href="#" class="text-decoration-none text-white">
               <div class="bg-white p-3 text-white">
                  <div class="row align-items-center">
                     <div class="col-6">
                       
                        <div class="pt-2">
                           <a href="/wallet/transactions" class="btn btn-outline-danger btn-block mb-0"><i class="icofont-tag mr-1"></i> Earned Points : <br>
                           <span id="walletBalance">0</span>
                           </a>
                        </div>
                     </div>
                     <div class="col-6">
                        <div class="pt-2">
                           <a  href="/wallet/transactions" class="btn btn-outline-danger btn-block mb-0"><i class="icofont-tag mr-1"></i> Referral Count : <br>
                           <span id="referralCount">0</span>
                           </a>
                        </div>
                     </div>
                  </div>
               </div>
            </a>
            <div class="promo_detail">
               <div class="title p-3 bg-white shadow-sm">
                  <h5 class="font-weight-bold text-danger">Get 
                     <c:choose><c:when test="${not empty sessionScope.referralBonus}">${sessionScope.referralBonus}</c:when><c:otherwise>0</c:otherwise></c:choose> 
                     Rcoins as a Referral Bonus</h5>
                  <p class="small text-muted m-0">Applicable For Refer Only...!!!</p>
               </div>
               <div class="title p-3 bg-white shadow-sm">
                  <div class="input-group mb-3">
                     <input type="text" class="form-control" placeholder="Your referral Code" id="referralCode"
                        value="9726098261" readonly aria-describedby="basic-addon2">
                     <div class="input-group-append">
                        <button class="btn btn-danger" type="button" onclick="copyToClipboard('referralCode')">Copy to
                           Clipboard</button>
                     </div>
                  </div>
                  <div class="account-sections">
                     <p class="font-weight-bold mb-2">Invite Users By </p>
                     <a href="javascript:void(0);" onclick="inviteBySms();"><i
                           class="icofont-ui-messaging osahan-icofont bg-warning"></i></a>
                     <a href="javascript:void(0);" onclick="inviteByWhatsapp();"><i
                           class="icofont-brand-whatsapp osahan-icofont bg-success"></i></a>
                     <!-- <a href="http://"><i class="icofont-telegram osahan-icofont bg-info"></i></a> -->


                  </div>
               </div>
               <div class="p-3 bg-light">
                  <p class="font-weight-bold mb-2">Description</p>
                  <p class="small m-0">Get 
                  <c:choose><c:when test="${not empty sessionScope.referralBonus}">${sessionScope.referralBonus}</c:when><c:otherwise>0</c:otherwise></c:choose>
                   Rcoins as referraal bonus by just by refer.</p>
                  <p> 1 Rcoins = 1 Rupee</p>
               </div>

               <div class="p-3">
                  <p class="font-weight-bold mb-2">Steps to Get bonus Points</p>
                  <ul class="pl-3 mb-0">
                     <li class="text-muted">Click on <b>"GET NOW"</b> , it will redirect to survery form.</li>
                     <li class="text-muted">Fill Up all mandatory fields in that SURVEY FORM.</li>
                     <li class="text-muted">After successfully filling up the SURVEY FORM, you will automatically get
                        the Rcoins into your <b>RRMart Wallet Balance</b>.
                     </li>
                  </ul>
               </div>
            </div>
                  <!-- Footer -->
            <%@include file="./menu/footer.jsp"%>
            <%@include file="./signup-bonus-modal.jsp"%>

            <%@include file="./menu/sidenav.jsp"%>
            <!-- Bootstrap core JavaScript -->
            <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
            
            <script src="/app/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
            <!-- slick Slider JS-->
            <script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.js"></script>
            <!-- Sidebar JS-->
            <!-- Include JS START-->
            <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>

            <script src="/app/js/globalscript.js"></script>

            <!-- Include Js END -->
            <script type="text/javascript" src="/app/vendor/sidebar/hc-offcanvas-nav.js"></script>
            <!-- Custom scripts for all pages-->
            <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
            <script src="/app/js/osahan.js"></script>
            <script>

               $("#referralCode").val("${sessionScope.referralCode}");
               let sessionContactId = "${sessionScope.contactId}";

               if (sessionContactId) {
                  getReferralCode(sessionContactId);
               }else{
                  $("#referralCount").val(0);
               }

               $(function () {
                  $(".preloader-div").remove();
                  $("#walletBalance").html('${sessionScope.walletBalance}');
               });

               function copyToClipboard(id) {

                  /* Get the text field */
                  var copyText = document.getElementById(id);
                  /* Select the text field */
                  copyText.select();
                  copyText.setSelectionRange(0, 99999); /* For mobile devices */
                  /* Copy the text inside the text field */
                  document.execCommand("copy");
                  /* Alert the copied text */
                  Swal.fire({
                     icon: 'success',
                     title: 'Success',
                     text: 'Copied Successfully...!!!',
                  }).then((result) => {

                  })
               }

               function inviteBySms() {

                  let message = 'Hey, Download and Sign with my referral code in RRMart App.%0A' +
                     'Referral Code : ' + '${sessionScope.referralCode}' + '%0A' +
                     'Download Link : https://play.google.com/store/apps/details?id=com.raptureretails.rrmart  ';
                  window.location.href = "sms:?body=" + message;
               }

               

               function inviteByWhatsapp() {

                  let message = 'Hey, Download and Sign with my referral code in RRMart App.%0A' +
                     'Referral Code : ' + '${sessionScope.referralCode}' + '%0A' +
                     'Download Link : https://play.google.com/store/apps/details?id=com.raptureretails.rrmart  ';
                  window.location.href = "whatsapp://send?abid=phonenumber&text=" + message;
               }


               function getReferralCode(contactId) {
                  $.ajax({
                     type: "POST",
                     url:  "/user/getReferralCount",
                     data: {contactId : contactId},
                     success: function (data) {
                      
                        if (data.status) {
                           $("#referralCount").html(data.response);
                        } else {
                           $("#referralCount").html(0);
                        }
                     }
                  });
               }
            </script>
            


</body>

</html>