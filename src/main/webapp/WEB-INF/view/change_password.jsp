<!DOCTYPE html>
<html lang="en">
   <head>
       <title>RRMart - Change Password</title>
      <%@include file="./menu/head.jsp"%>
   </head>
   <body>
      <div class="preloader-div">
      <div class="preloaderBg" id="preloader" onload="preloader()">
         <div class="preloader">
            <div class="preloader2"></div>
         </div>
     </div>
   </div>
      
      <div class="osahan-help">
         <div class="p-3 border-bottom">
            <div class="d-flex align-items-center">
               <a class="font-weight-bold text-danger text-decoration-none" href="/myaccount">
               <i class="icofont-rounded-left back-page"></i></a>
               <h6 class="font-weight-bold m-0 ml-3">Change Password</h6>
               <a class="toggle ml-auto" href="#"><i class="icofont-navigation-menu"></i></a>
            </div>
         </div>
      </div>
      <div id="edit_profile">
         <div class="p-3">
            <form name="signUpForm" id="signUpForm" action="/changeAcpassword" method="post">
                <input type="hidden" name="contactId" id="contactId" value="${sessionScope.contactId}">
               <!-- <div class="form-group">
                  <label for="firstname">First Name</label>
                  <input placeholder="Enter First Name" type="text" class="form-control" name="firstName"
                     id="firstname">
               </div>
               <div class="form-group">
                  <label for="lastname">Last Name</label>
                  <input placeholder="Enter Last Name" type="text" class="form-control" name="lastName" id="lastname">
               </div> -->
               <div class="form-group">
                  <label for="signUpMobileNo">Phone Number</label>
                  <input placeholder="Enter Phone Number" type="tel" name="phoneNo" readonly="readonly"
                     class="form-control" id="signUpMobileNo" value="${sessionScope.contactMobileNo}">
               </div>
              <div class="form-group">
                  <label for="oldpassword">Old Password</label>
                  
                  <div class="input-group mb-3">
                    <input type="password" placeholder="Enter Old Password" class="form-control" id="oldpassword" name="oldpassword">
                     <div class="input-group-append">
                        <span class="input-group-text" id="basic-addon2"><i class="icofont-eye" onclick="visibleHidePasswordFnc('oldpassword',this)"></i></span>
                     </div>
                  </div>
               </div>
               <div class="form-group">
                  <label for="confirmPassword">Confirm Password</label>
                  <div class="input-group mb-3">
                    <input type="password" placeholder="Enter New Password" class="form-control" id="newpassword" name="newpassword">
                     <div class="input-group-append">
                        <span class="input-group-text" id="basic-addon2"><i class="icofont-eye" onclick="visibleHidePasswordFnc('newpassword',this)"></i></span>
                     </div>
                  </div>
               </div>
               <!-- <div class="form-group">
                  <label for="referralCode">Referal Code <small>(Optional)</small> </label>
                  <input placeholder="Enter Referral Code" type="text" class="form-control" id="referralCode"
                     name="referralCode">
               </div> -->
               <button type="button" id="sign-up-btn" class="btn btn-danger rounded btn-lg btn-block" onclick="checkswl()">Change Password</button>
            </form>
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
          
               newpassword: {
                    validators: {
                        notEmpty: {
                            message: 'The password is required',
                        }, callback: {
                            message: 'The old password and new password are same',
                            callback: function (input) {
                                return $('#newpassword').val() != $('#oldpassword').val();
                            }
                        }
                    },
                },
                oldpassword: {
                    validators: {
                        notEmpty: {
                            message: 'Old password is required.'
                        }, remote: {
                            message: 'Old password is invalid. ',
                            url: "/checkoldpassword?contactId="+$("#contactId").val(),
                            type: 'POST',
                        },
                    }
                }
            //    referralCode: {
            //       validators: {
            //          stringLength: {
            //             max: 12,
            //             message: 'The Referral code must be 12 characters long'
            //          },
            //          // regexp: {
            //          //    regexp: /^[0-9]+$/,
            //          //    message: 'The Referral can only consist of number'
            //          // }
            //       }
            //    },

            }
         });
         $(".preloader-div").remove();

         // $('#sign-up-btn').click(function (e) {
         //    //alert()
         //    if ($('#signUpForm').data('formValidation').isValid() == null) {
         //       $('#signUpForm').data('formValidation').validate();
         //    }
         //    if ($('#signUpForm').data('formValidation').isValid() == true) {
         //       $('#sign-up-btn').attr("disabled", true);
         //       signUpBtnClickFnc();
         //    }
         // });


         // Sign UP form Validation :::: START ::::
      
        
         // Sign UP form Validation :::: ENDS ::::

      });


       function checkswl(){
        if ($('#signUpForm').data('formValidation').isValid() == null) {
            $('#signUpForm').data('formValidation').validate();
        }else if ($('#signUpForm').data('formValidation').isValid() == true) {
            Swal.fire({
                //title: "",
                text: "Are you sure to change your Password?",
                icon: "warning",
                showCancelButton: !0,
                confirmButtonText: "Yes"
            }).then(function (e) {
                if (e.value) {
                    //$("#sales_form").submit();
                    document.getElementById("signUpForm").submit();
                } else {
                }
            })
        }
    }


      //  signUpBtnClickFnc = () => {

      //   //  let firstname = $("#firstname").val();
      //   //  let lastname = $("#lastname").val();
      //    let signUpMobileNo = $("#signUpMobileNo").val();
      //    //let referralCode = $("#referralCode").val();
      //    //let userType = "customers";
      //    let contactId = $("#contactId").val();
      //    let password = $("#newPassword").val();

      //    if (signUpMobileNo != "0") {
      //       let data = {
      //          contactId: contactId,
      //          contactNo: signUpMobileNo,
      //          password: password
      //       }
      //       console.log(data);
      //       $.ajax({
      //          type: "POST",
      //          url:  "/user/updatePassword",
      //          data: data,
      //          success: function (data) {
      //             if (data.status) {
      //                Swal.fire({
      //                   icon: 'success',
      //                   title: 'Success',
      //                   text: data.message,
      //                   showConfirmButton: false,
      //                   timer: 1000
      //                })
      //                setTimeout(() => {
      //                    window.location.href="/editprofile";
      //                }, 1000);
      //             } else {
      //                Swal.fire({
      //                   icon: 'error',
      //                   title: 'Oops...',
      //                   text: 'Something Went Wrong',
      //                   showConfirmButton: false,
      //                   timer: 1000
      //                })
                     
      //                setTimeout(() => {
      //                   window.location.reload();
      //                }, 1000);
      //             }
      //          }
      //       });
      //    } else {

      //       Swal.fire({
      //          icon: 'error',
      //          title: 'Oops...',
      //          text: 'Something Went Wrong',
      //       }).then((result) => {
      //          if (result.isConfirmed) {
      //             window.location.reload();
      //          }
      //       })
      //    }


      //    // $("#otp-verification-div").show();
      //    // $("#sign-in-div").hide();
      //    // $("#sign-up-div").hide();
      //    //alert("INSIDE THIS FUNCTION");



      // }

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
      </script>
   </body>
</html>