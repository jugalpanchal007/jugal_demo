<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">

<head>

   <title>RRMart - Sign In</title>
   <%@include file="./menu/head.jsp"%>
   <style>
      
      .digit-group input {
         width: 30px;
         height: 50px;
         background-color: #fff;
         border: none;
         line-height: 50px;
         text-align: center;
         font-size: 24px;
         font-weight: 200;
         color: #000;
         margin: 0 2px;
      }
      .input-group-text {
         display: -ms-flexbox;
         display: flex;
         -ms-flex-align: center;
         align-items: center;
         padding: 5px;
         margin-bottom: 0;
         font-size: 1.2rem;
         font-weight: 400;
         line-height: 1.5;
         
         text-align: center;
         white-space: nowrap;
         background-color: transparent;
         
         border-radius: 0.25rem;
         border-bottom: 1px solid #cacdd0 !important;
         border-top: 0px !important;
         border-right: 0px !important;
         border-left: 0px !important;
      }

         div#some_div {
            font-size: 16px;
        }
        .m--hide {
            display: none !important;
        }
        .limiter,
        .container-login100 {
            height: 100%;
        }
        .disabled {
            cursor: default;
        }

        @media only screen and (max-width: 767px){

         .login-div {
            width: calc(100% - 40px) !important;
         }
        }

        .login-page{
           position:relative;
           height:100vh;
           padding-bottom:0px;
         
         }
      .login-div{margin-left:auto;margin-right:auto;
         
      }

        #center_form {
            position: absolute !important;
            width: 100% !important;
            top: 50% !important;
            transform: translateY(-50%) !important;
         }


   </style>
</head>

<body class="fixed-bottom-padding login-page">
   <div class="preloader-div">
      <div class="preloaderBg" id="preloader" onload="preloader()">
         <div class="preloader">
            <div class="preloader2"></div>
         </div>
     </div>
   </div>
   
   <!-- sign in START-->
  
   <div id="center_form" class="" style="background: none;">
      <div class="container-fluid">
         <div class="row">
            <div class="col-lg-4 col-md-4 col-sm-12 login-div">
               <div class="card rounded shadow-sm">
                  <div class="card-body p-0">
                     <input type="hidden" name="otphidden" id="otphidden" value="0">
                     <div id="sign-in-div">
                        <div class="osahan-signin">
                           <div class="border-bottom p-3 d-flex align-items-center  justify-content-center">
                              <a href="/home" class="text-decoration-none text-dark d-flex align-items-center">
                                 <img class="osahan-logo mr-2" src="/app/img/logo.png">
                                 <h4 class="font-weight-bold text-danger m-0">RRMart</h4>
                              </a>
                           </div>
                           <div class="p-3">
                              <h2 class="my-0 text-center">Welcome</h2>
                              <p class="small text-center">Sign in to Continue.</p>
                              <form name="signinform" >
                                 <div class="form-group">
                                    <label for="mobileNo">Mobile Number</label>
                                    <input placeholder="Enter Mobile No." type="tel" class="form-control" id="mobileNo"
                                       aria-describedby="mobileHelp" >
                                    
                                 </div>
                                 
                                 <div class="form-group mt-2 text-right">
                                    <a class="text-muted  small py-2 m-2 w-100" href="/forgotPassword">Forgot Password.</a>
                                 </div>
                  
                                 <button type="button" id="sign-in-btn" onclick="signInBtnClickFnc()"
                                    class="btn btn-danger btn-lg rounded btn-block mt-2">Click Here to Continue</button>
                              </form>
                              
                              
                           </div>
                        </div>
                        <!-- footer fixed -->
                        <!-- <div class="osahan-fotter fixed-bottom" id="sign-in-footer">
                           <a href="javascript:void(0);" id="sign-in-footer-btn" class="btn btn-block btn-lg bg-white" >Don't have an account? Sign up</a>
                        </div> -->
                     </div>
                     <!-- sign in END-->
                  
                     <!-- sign up START-->
                     <div id="sign-up-div">
                        <div class="osahan-signup">
                           <div class="border-bottom p-3 d-flex align-items-center  justify-content-center">
                              <a href="/home" class="text-decoration-none text-dark d-flex align-items-center">
                                 <img class="osahan-logo mr-2" src="/app/img/logo.png">
                                 <h4 class="font-weight-bold text-danger m-0">RRMart</h4>
                              </a>
                           </div>
                           <div class="p-3">
                              <h2 class="my-0">Let's get started</h2>
                              <p>Create account to see our top picks for you!</p>
                              <form name="signUpForm" id="signUpForm">
                                 <div class="form-group">
                                    <label for="firstname">First Name</label>
                                    <input placeholder="Enter First Name" type="text" class="form-control" name="firstName"
                                       id="firstname">
                                 </div>
                                 <div class="form-group">
                                    <label for="lastname">Last Name</label>
                                    <input placeholder="Enter Last Name" type="text" class="form-control" name="lastName" id="lastname">
                                 </div>
                                 <div class="form-group">
                                    <label for="signUpMobileNo">Phone Number</label>
                                    <input placeholder="Enter Phone Number" type="tel" name="phoneNo" readonly="readonly"
                                       class="form-control" id="signUpMobileNo">
                                 </div>
                                 <div class="form-group">
                                    <label for="newPassword">Password</label>
                                    <input placeholder="Enter Password" type="password" id="newPassword" name="password"
                                       class="form-control">
                                 </div>
                                 <div class="form-group">
                                    <label for="confirmPassword">Confirm Password</label>
                                    <input placeholder="Confirm Password" type="password" id="confirmPassword" name="confirmPassword"
                                       class="form-control">
                                 </div>
                                 <div class="form-group">
                                    <label for="referralCode">Referal Code <small>(Optional)</small> </label>
                                    <input placeholder="Enter Referral Code" type="text" class="form-control" id="referralCode"
                                       name="referralCode">
                                 </div>
                  
                                 <button type="button" id="sign-up-btn" class="btn btn-danger rounded btn-lg btn-block">Create
                                    Account</button>
                              </form>
                  
                           </div>
                        </div>
                        <!-- footer fixed -->
                        <!-- <div class="osahan-fotter fixed-bottom" id="sign-up-footer">
                           <a href="javascript:void(0);" class="btn btn-block btn-lg bg-white" >Don't have an account? Sign up</a>
                        </div> -->
                     </div>
                     <!-- sign up END-->
                  
                     <!--OTP verification START-->
                     <div class="osahan-verification" id="otp-verification-div">
                        <div class="border-bottom p-3 d-flex align-items-center  justify-content-center">
                           <a href="/home" class="text-decoration-none text-dark d-flex align-items-center">
                              <img class="osahan-logo mr-2" src="/app/img/logo.png">
                              <h4 class="font-weight-bold text-danger m-0">RRMart</h4>
                           </a>
                        </div>
                        <div class="osahan-form p-3 text-center my-3">
                           <h2>Verify your number</h2>
                           <p>Enter the 4-digit code we sent to you</p>
                           <p>
                              <p id="mobileNoText">98*** ***76</p>
                              <p style="color: #dc3545!important;" onclick="window.location.reload()">Click here to Change number</p>
                           </p>
                           <!-- <input type="text" autocomplete="one-time-code" inputmode="numeric" /> -->
                           <form action="get_started.html">
                              <div class="row my-5 px-1" id="digit-group" data-group-name="digits" data-autosubmit="true"
                                 autocomplete="off">
                                 <div class="col px-2">
                                    <input type="tel" placeholder="0" id="digit-1" name="digit-1" data-next="digit-2"
                                       class="form-control opt form-control-lg text-center" maxlength="1" oninput="otpInputChangeFnc()">
                                 </div>
                                 <div class="col px-2">
                                    <input type="tel" placeholder="0" id="digit-2" name="digit-2" data-next="digit-3"
                                       data-previous="digit-1" class="form-control opt form-control-lg text-center" maxlength="1"
                                       oninput="otpInputChangeFnc()">
                                 </div>
                                 <div class="col px-2">
                                    <input type="tel" placeholder="0" id="digit-3" name="digit-3" data-next="digit-4"
                                       data-previous="digit-2" class="form-control opt form-control-lg text-center" maxlength="1"
                                       oninput="otpInputChangeFnc()">
                                 </div>
                                 <div class="col px-2">
                                    <input type="tel" placeholder="0" id="digit-4" name="digit-4" data-previous="digit-3"
                                       class="form-control opt form-control-lg text-center" maxlength="1" oninput="otpInputChangeFnc()">
                                 </div>
                              </div>
                              <p> <div id="some_div" align="center" style="color:red"></div></p>
                              <p><a href="javascript:void(0);" class="text-decoration-none text-danger" id="resendOtpBtn" onclick="resendOtpFnc()">RESEND OTP</a></p>
                              <button type="button" class="btn btn-danger btn-block btn-lg" id="verfy-otp-btn"
                                 onclick="verifyOTPFnc()">Verify OTP</button>
                           </form>
                        </div>
                     </div>
                     <!--OTP verification END-->
                  
                     <!--PASSWORD verification START-->
                     <div class="osahan-verification" id="password-verification-div">
                        <div class="border-bottom p-3 d-flex align-items-center  justify-content-center">
                           <%-- <a class="font-weight-bold text-danger text-decoration-none" href="javascript:void(0);"
                              onclick="window.location.reload()"><i class="icofont-rounded-left back-page"></i></a> --%>
                           <%-- <a class="toggle ml-auto" href="#"><i class="icofont-navigation-menu"></i></a> --%>
                           <a href="/home" class="text-decoration-none text-dark d-flex align-items-center">
                              <img class="osahan-logo mr-2" src="/app/img/logo.png">
                              <h4 class="font-weight-bold text-danger m-0">RRMart</h4>
                           </a>
                        </div>
                        <div class="osahan-form p-3 text-center my-3">
                           <h2>Verify!!!</h2>
                           <p class="small text-center">Please Enter Your password</p>
                           <form action="#">
                              <div class="row my-5 px-5" autocomplete="off">
                                 <div class="col px-2">
                                    <div class="input-group mb-3">
                                       <input type="password" placeholder="Enter your password here" id="password" name="password"
                                       class="form-control form-control-lg text-center">
                                       <div class="input-group-append">
                                          <span class="input-group-text" id="basic-addon2"><i class="icofont-eye" onclick="visibleHidePasswordFnc('password',this)"></i></span>
                                       </div>
                                    </div>
                                    <%-- <input type="password" placeholder="Enter your password here" id="password" name="password"
                                       class="form-control form-control-lg text-center"> --%>
                                 </div>
                                 
                              </div>
                              <div class="form-group">
                                 <a class="text-muted text-right small py-2 m-2 w-100" href="/forgotPassword">Forgot Password.</a>
                              </div>
                              <button type="button" class="btn btn-danger btn-block btn-lg" id="verfy-password-btn"
                                 onclick="verifyPasswordFnc()">Continue</button>
                           </form>
                        </div>
                     </div>
                     <!--PASSWORD verification END-->
                  </div>
               </div>
            </div>
         </div>
      </div>
   </div>
  


   <%@include file="./footerjs.jsp"%>
   <script type="text/javascript" src="/app/vendor/formvalidation/formValidation.min.js"></script>
   <script type="text/javascript" src="/app/vendor/formvalidation/framework/bootstrap.min.js"></script>
   

   <!-- Include JS START-->
   <script>
      let mobNo = 0;
      var timeLeft = 59;
      var elem = document.getElementById('some_div');
      var timerId = 0;
      $(function () {

         $("#sign-up-div").hide();
         $("#otp-verification-div").hide();
         $("#password-verification-div").hide();

         $("#newPassword").keyup(function(){
            if($('#confirmPassword').val()!="") {
               $('#signUpForm').formValidation('revalidateField', 'confirmPassword');
            }
         });

         $(".preloader-div").remove();


         $("#mobileNo").on('keypress',function(e) {
            if(e.which == 13) {
              $("#sign-in-btn").click(function (e) { 
                 e.preventDefault();
              });
            }
         });


         $('#sign-up-btn').click(function (e) {
            if ($('#signUpForm').data('formValidation').isValid() == null) {
               $('#signUpForm').data('formValidation').validate();
            }
            if ($('#signUpForm').data('formValidation').isValid() == true) {
               $('#sign-up-btn').attr("disabled", true);
               signUpBtnClickFnc();
            }
         });


         // Sign UP form Validation :::: START ::::
         const form = document.getElementById('signUpForm');
         $('#signUpForm').formValidation({
            framework: 'bootstrap',
            excluded: ":disabled",
            /*live:'disabled', */
            button: {
               selector: "#sign-up-btn",
               disabled: "disabled"
            },
            icon: null,
            fields: {
               firstName: {
                  validators: {
                     stringLength: {
                        max: 50,
                        message: 'The First name must be less than 50 characters'
                     },
                     notEmpty: {
                        message: 'The First name is required'
                     },
                     regexp: {
                        regexp: /^[a-zA-Z_-\s-]+$/,
                        message: 'The Name can only consist of alphabetical.'
                     },
                  }
               },
               lastName: {
                  validators: {
                     stringLength: {
                        max: 50,
                        message: 'The Last name must be less than 50 characters'
                     },
                     notEmpty: {
                        message: 'The Last name is required'
                     },
                     regexp: {
                        regexp: /^[a-zA-Z_-\s-]+$/,
                        message: 'The Name can only consist of alphabetical.'
                     },
                  }
               },
               phoneNo: {
                  validators: {
                     notEmpty: {
                        message: 'Mobile No is required.'
                     },

                  }
               },
               password: {
                  validators: {
                     notEmpty: {
                        message: 'The password is required',
                     },            
                  },
               },
               confirmPassword: {
                  validators: {
                     notEmpty: {
                        message: 'The Confirm Password is required. '
                     },
                     callback: {
                       message: 'The password and its confirm are not the same',
                       callback: function (input) {
                           return $('#newPassword').val() == $('#confirmPassword').val();
                       }
                    }
                  }
               },
               referralCode: {
                  validators: {
                     stringLength: {
                        max: 12,
                        message: 'The Referral code must be 12 characters long'
                     },
                     // regexp: {
                     //    regexp: /^[0-9]+$/,
                     //    message: 'The Referral can only consist of number'
                     // }
                  }
               },

            }
         });
         // Sign UP form Validation :::: ENDS ::::

      });


      signInBtnClickFnc = () => {

         $("#sign-in-btn").prop('disabled', true);
         let mobileNo = $("#mobileNo").val();
         let mobileNoText = "";
         var filter = /^\d*(?:\.\d{1,2})?$/;

         if (mobileNo) {
            if (filter.test(mobileNo)) {
               if (mobileNo.length == 10) {
                  console.log("valid");
                  mobNo = mobileNo;
                  mobileNoText = mobNo.substring(0, 2) + "X - XXX - X" + mobNo.substring(7)
                  $("#mobileNoText").html(mobileNoText);

                  // check user existing or not
                  checkExistingUser();

                  

                  //if not then send otp
                  //send otp fnc

                  //else show div to enter password



               } else {

                  Swal.fire({
                     icon: 'error',
                     title: 'Oops...',
                     text: 'Please put 10  digit mobile number',
                  }).then((result) => {
                     if (result.isConfirmed) {
                        $("#mobileNo").focus();
                     }
                  })
                  $("#sign-in-btn").prop('disabled', false);

                  return false;
               }
            } else {

               Swal.fire({
                  icon: 'error',
                  title: 'Oops...',
                  text: 'Please put 10  digit mobile number',
               }).then((result) => {
                  if (result.isConfirmed) {
                     $("#mobileNo").focus();
                  }
               })
               return false;
               $("#sign-in-btn").prop('disabled', false);
            }
         } else {
            Swal.fire({
               icon: 'error',
               title: 'Oops...',
               text: 'Please Enter mobile number',
            }).then((result) => {
               if (result.isConfirmed) {
                  $("#mobileNo").focus();
               }
            })
            return false;
            $("#sign-in-btn").prop('disabled', false);
         }

      }

      signUpBtnClickFnc = () => {

         let firstname = $("#firstname").val();
         let lastname = $("#lastname").val();
         let signUpMobileNo = mobNo;
         let referralCode = $("#referralCode").val();
         let userType = "customers";
         let password = $("#newPassword").val();

         if (signUpMobileNo != "0") {
            let data = {
               firstName: firstname,
               lastName: lastname,
               contactNo: signUpMobileNo,
               referralCode: referralCode,
               type: userType,
               password: password
            }
            console.log(data);
            $.ajax({
               type: "POST",
               url:  "/user/signup",
               data: data,
               success: function (data) {
                  if (data.status) {

                     localStorage.setItem("contactId", parseInt(data.response.contactId));
                     localStorage.setItem("isSurveyFilled", parseInt(data.response.isSurveyFilled));
                     localStorage.setItem("contactName", data.response.firstName + " " + data.response.lastName);
                     localStorage.setItem("contactMobileNo", data.response.mobNo);
                     localStorage.setItem("walletBalance", data.response.walletBalance);
                     localStorage.setItem("signupBonus", data.response.signupBonus);


                     Swal.fire({
                        icon: 'success',
                        title: 'Success',
                        text: data.message,
                        showConfirmButton: false,
                        timer: 1000
                     });
                     setTimeout(() => {
                        window.location.href = "/home"
                     }, 1000);

                  } else {
                     Swal.fire({
                        icon: 'error',
                        title: 'Oops...',
                        text: 'Something Went Wrong',
                        showConfirmButton: false,
                        timer: 1000
                     })
                     setTimeout(() => {
                        window.location.reload();
                     }, 1000);
                  }
               }
            });
         } else {

            Swal.fire({
               icon: 'error',
               title: 'Oops...',
               text: 'Something Went Wrong',
            }).then((result) => {
               if (result.isConfirmed) {
                  window.location.reload();
               }
            })
         }


         // $("#otp-verification-div").show();
         // $("#sign-in-div").hide();
         // $("#sign-up-div").hide();
         //alert("INSIDE THIS FUNCTION");



      }

      sendOTPFnc = (mobileNo) => {
         console.log(mobileNo);
         let url =  "/user/sendotp";
         $.ajax({
            type: "POST",
            url: url,
            data: {
               mobileNo: mobileNo
            },
            success: function (response) {
               if (response) {
                  // show hide div
                  $("#otp-verification-div").show();
                  $("#sign-in-div").hide();
                  $("#sign-up-div").hide();
                  $("#password-verification-div").hide();

                  toastr.success("OTP SEND SUCCESFULLY");
                  timerId = setInterval(countdown, 1000);
                  timeLeft = 59;
                    $("#some_div").removeClass("m--hide");
                    $("#resendOtpBtn").hide();

               } else {
                  Swal.fire({
                     icon: 'error',
                     title: 'Oops...',
                     text: 'Something Went Wrong',
                  }).then((result) => {
                     if (result.isConfirmed) {
                        window.location.reload();
                     }
                  })
                  return false;
               }
            }
         });

      }

      function countdown() {
            //	 console.log("countdown");
            if (timeLeft == -1) {
                clearTimeout(timerId);
                // elem.innerHTML = timeLeft + ' seconds remainingcomplete';
                $("#resendOtpBtn").show();
                $("#some_div").addClass("m--hide");
                //  doSomething();
            } else {
                if (timeLeft > 9) {
                    elem.innerHTML = '00 : ' + timeLeft; //+ ' seconds remaining';
                } else {
                    elem.innerHTML = '00 : 0' + timeLeft;
                }
                timeLeft--;
            }
        }

      resendOtpFnc = () => {
         $('#resendOtpBtn').hide();
         let mobileNumber = mobNo;
         if (mobileNumber != "0") {
            sendOTPFnc(mobileNumber);
         } else {

         }


      }

      verifyOTPFnc = () => {
         $("#verfy-otp-btn").prop('disabled', true);
         var otp = "";
         $('#digit-group').find('input').each(function () {
            otp += $(this).val();
         });
         console.log(otp);

         //get otp by ajax
         //alert()
         $.ajax({
            type: "POST",
            url:  "/user/verifyotp",
            data: {
               mobileNo: mobNo,
               otp: otp
            },
            success: function (data) {
               if (data.status) {
                  Swal.fire({
                     icon: 'success',
                     title: 'Success!!!',
                     text: 'OTP verified Successully!',
                     showConfirmButton: false,
                     timer: 1500
                  })

                  if (data.response.isExistingCustomer == "0") {
                     setTimeout(() => {
                        $("#otp-verification-div").hide();
                        $("#sign-in-div").hide();
                        $("#sign-up-div").show();
                        $("#signUpMobileNo").val(mobNo);
                     }, 1500);
                  } else {
                     setTimeout(() => {
                        localStorage.setItem("contactId", parseInt(data.response.isExistingCustomer));
                        localStorage.setItem("isSurveyFilled", parseInt(data.response
                           .isSurveyFilled));
                        localStorage.setItem("contactName", data.response.contactName);
                        localStorage.setItem("contactMobileNo", data.response.contactMobileNo);
                        localStorage.setItem("walletBalance", data.response.walletBalance);
                        localStorage.setItem("signupBonus", data.response.signupBonus);
                        window.location.href = "/home";
                     }, 1500);
                     $("#verfy-otp-btn").prop('disabled', false);
                  }
               } else {
                  Swal.fire({
                     icon: 'warning',
                     title: 'Oops!!!',
                     text: data.message,
                     showConfirmButton: false,
                     timer: 1500
                  })
                  $("#verfy-otp-btn").prop('disabled',false);
               }
            }
         });
      }

      checkExistingUser = () => {

         $.ajax({
            type: "POST",
            url:  "/user/isExisting",
            data: {
               mobileNo: mobNo
            },
            success: function (data) {
               if (data.status) {

                  if (data.response.isExistingCustomer == "0") {
                     sendOTPFnc(mobNo)
                  } else {
                     $("#sign-up-div").hide();
                     $("#otp-verification-div").hide();
                     $("#sign-in-div").hide();
                     $("#password-verification-div").show();
                     $("#signInBtnClickFnc").prop('disabled', true);
                  }
               } else {
                  if (data.response.isExistingCustomer == "0") {
                     sendOTPFnc(mobNo)
                  }
               }
            }
         });

      }

      otpInputChangeFnc = () => {
         console.log("inside otpInputChangeFnc");
         $('#digit-group').find('input').each(function () {
            $(this).attr('maxlength', 1);
            $(this).on('keyup', function (e) {


               console.log("hiiii");
               var parent = $($(this).parent().parent());
               console.log(parent);
               if (e.keyCode === 8 || e.keyCode === 37) {
                  console.log($(this));
                  var prev = parent.find('input#' + $(this).data('previous'));
                  console.log("hiiii---> " + prev);

                  if (prev.length) {
                     $(prev).select();
                  }
               } else if ((e.keyCode >= 48 && e.keyCode <= 57) || (e.keyCode >= 65 && e.keyCode <= 90) ||
                  (e.keyCode >= 96 && e.keyCode <= 105) || e.keyCode === 39) {
                  var next = parent.find('input#' + $(this).data('next'));

                  if (next.length) {
                     $(next).select();
                  } else {
                     if (parent.data('autosubmit')) {
                        $("#verfy-otp-btn").trigger("click");
                     }
                  }
               } else {
                  console.log(e.keyCode);
               }
            });
         });
      }

      verifyPasswordFnc = () => {

         var password = $("#password").val();
         console.log(password);
         if (password != "") {
            $.ajax({
               type: "POST",
               url:  "/user/checkpassword",
               data: {
                  mobileNo: mobNo,
                  password: password
               },
               success: function (data) {
                  if (data.status) {
                     Swal.fire({
                        icon: 'success',
                        title: 'Success!!!',
                        text: 'Verified Successully!',
                        showConfirmButton: false,
                        timer: 1500
                     })

                     setTimeout(() => {
                        localStorage.setItem("contactId", parseInt(data.response.isExistingCustomer));
                        localStorage.setItem("isSurveyFilled", parseInt(data.response
                           .isSurveyFilled));
                        localStorage.setItem("contactName", data.response.contactName);
                        localStorage.setItem("contactMobileNo", data.response.contactMobileNo);
                        localStorage.setItem("walletBalance", data.response.walletBalance);
                        localStorage.setItem("signupBonus", data.response.signupBonus);
                        window.location.href = "/home";
                     }, 1500);
                  } else {
                     if (data.message == "wrong_password") {
                        Swal.fire({
                           icon: 'error',
                           title: 'Oops...',
                           text: 'Please Enter Correct Password',
                        }).then((result) => {
                           if (result.isConfirmed) {
                              $("#password").focus();
                           }
                        })
                     }
                  }
               }
            });
         } else {
            Swal.fire({
               icon: 'error',
               title: 'Oops...',
               text: 'Please Enter Password',
            }).then((result) => {
               if (result.isConfirmed) {
                  $("#password").focus();
               }
            })
            return false;
         }


      }

      let visibleHidePasswordFnc =  (id,e) =>{
         var x = document.getElementById(id);
         if (x.type === "password") {
            x.type = "text";
            $(e).removeClass("icofont-eye");
            $(e).addClass("icofont-eye-blocked");
         } else {
            x.type = "password";
            $(e).removeClass("icofont-eye-blocked");
            $(e).addClass("icofont-eye");
         }
          
      }

      let hidePasswordFnc =  (id) =>{
          $('#'+id).attr('type', 'password'); 
      }
   </script>
   <script>
      if ('OTPCredential' in window) {
         window.addEventListener('DOMContentLoaded', e => {
            const input = document.querySelector('input[autocomplete="one-time-code"]');
            if (!input) return;
            const ac = new AbortController();
            const form = input.closest('form');
            if (form) {
               form.addEventListener('submit', e => {
                  ac.abort();
               });
            }
            navigator.credentials.get({
               otp: {
                  transport: ['sms']
               },
               signal: ac.signal
            }).then(otp => {
               input.value = otp.code;
               //$("#otpInput").val(otp.code);
            }).catch(err => {
               console.log(err);
            });
         });
      }
   </script>

</body>

</html>