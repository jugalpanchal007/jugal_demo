<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
   <head>
      
      <title>RRMart - Edit Profile</title>
      <%@include file="./menu/head.jsp"%>
   </head>
   <body>
   <div class="preloader-div">
      <div class="preloaderBg" id="preloader">
         <div class="preloader">
            <div class="preloader2"></div>
         </div>
     </div>
   </div>
      
      <div class="osahan-profle">
         <div class="p-3 border-bottom">
            <div class="d-flex align-items-center">
               <a class="font-weight-bold text-danger text-decoration-none" href="/myaccount">
               <i class="icofont-rounded-left back-page"></i></a>
               <h6 class="font-weight-bold m-0 ml-3">Edit Profile</h6>
               <a class="toggle ml-auto" href="#"><i class="icofont-navigation-menu"></i></a>
            </div>
         </div>
      </div>
      <div id="edit_profile">
         <div class="p-3">
            <form name="signUpForm" id="signUpForm">
               <input type="hidden" name="conatactId" id="contactId" value="${sessionScope.contactId}">
               <div class="form-group">
                  <label for="firstname">First Name</label>
                  <input placeholder="Enter First Name" type="text" class="form-control" name="firstName"
                     id="firstname" value="${sessionScope.firstName}">
               </div>
               <div class="form-group">
                  <label for="lastname">Last Name</label>
                  <input placeholder="Enter Last Name" type="text" class="form-control" name="lastName" id="lastname" value="${sessionScope.lastName}">
               </div>
               <div class="form-group">
                  <label for="signUpMobileNo">Phone Number</label>
                  <input placeholder="Enter Phone Number" type="tel" name="phoneNo"
                     class="form-control" id="signUpMobileNo" value="${sessionScope.contactMobileNo}">
               </div>

               <button type="button" id="sign-up-btn" class="btn btn-danger rounded btn-lg btn-block">Save Changes</button>
            </form>
         </div>
         <div class="additional">
            <div class="change_password border-bottom border-top">
               <a href="/changepassword" class="p-3 bg-white btn d-flex align-items-center">Change Password 
               <i class="icofont-rounded-right ml-auto"></i></a>
            </div>
            <%-- <div class="deactivate_account border-bottom">
               <a href="deactivate_account.html" class="p-3 bg-white btn d-flex align-items-center">Deactivate Account 
               <i class="icofont-rounded-right ml-auto"></i></a>
            </div> --%>
         </div>
      </div>
      </div>
      <!-- Navmenu START -->
      <%@include file="./menu/footer.jsp"%>
      <%@include file="./menu/sidenav.jsp"%>
      <%@include file="./footerjs.jsp"%>
      <script type="text/javascript" src="/app/vendor/formvalidation/formValidation.min.js"></script>
      <script type="text/javascript" src="/app/vendor/formvalidation/framework/bootstrap.min.js"></script>
      <script>
         $(function () {
            $(".preloader-div").remove();
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
               // password: {
               //    validators: {
               //       notEmpty: {
               //          message: 'The password is required',
               //       },
               //    },
               // },
               // confirmPassword: {
               //    validators: {
               //       notEmpty: {
               //          message: 'The Confirm Password is required. '
               //       },
               //       callback: {
               //          message: 'The password and its confirm are not the same',
               //          callback: function (input) {
               //             return $('#newPassword').val() == $('#confirmPassword').val();
               //          }
               //       }
               //    }
               // },
               

            }
         });
         
         // Sign UP form Validation :::: ENDS ::::


         signUpBtnClickFnc = () => {

            let firstname = $("#firstname").val();
            let lastname = $("#lastname").val();
            let signUpMobileNo = $("#signUpMobileNo").val();
            let contactId = $("#contactId").val();

            if (signUpMobileNo != "0") {
               let data = {
                  firstName: firstname,
                  lastName: lastname,
                  contactNo: signUpMobileNo,
                  contactId : contactId
                  
               }
               console.log(data);
               $.ajax({
                  type: "POST",
                  url:  "/user/update/profile",
                  data: data,
                  success: function (data) {
                     if (data.status) {

                        localStorage.setItem("contactId", parseInt(data.response.contactId));
                        localStorage.setItem("isSurveyFilled", parseInt(data.response.isSurveyFilled));
                        localStorage.setItem("contactName", data.response.firstName + " " + data.response.lastName);
                        localStorage.setItem("contactMobileNo", data.response.mobNo);

                        Swal.fire({
                           icon: 'success',
                           title: 'Success',
                           text: data.message,
                        }).then((result) => {
                           if (result.isConfirmed) {
                              window.location.reload();
                           }
                        })
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
         });
      </script> 
   </body>
</html>