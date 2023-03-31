<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">

<head>
   <title>RRMart - Address</title>
   <%@include file="./menu/head.jsp"%>
   <style>
      .select2-container--default .select2-selection--single {
         background-color: #fff;
         border: 1px solid #aaa;
         border-radius: 4px;
         border-bottom: 1px solid #cacdd0;
         border-top: 0px;
         border-left: 0px;
         border-right: 0px;
         background-color: transparent;
         border-radius: 0px;
         font-size: 13px;
         box-shadow: none !important;
      }
      .map-overlay {
         max-width: 600px;
         height: 200px;
         margin: 0 auto;
         background-color: #fff;
         position: relative;
         border-radius: 2px;
         }

         #map_new {
            max-width: 550px;
            height: 200px;
            margin: 0 auto;
         }

         #map_edit {
            max-width: 550px;
            height: 200px;
            margin: 0 auto;
         }

         .pac-container {
            background-color: #fff;
            position: absolute!important;
            z-index: 99999999999999;
            border-radius: 2px;
            border-top: 1px solid #d9d9d9;
            font-family: Arial,sans-serif;
            box-shadow: 0 2px 6px rgb(0 0 0 / 30%);
            -moz-box-sizing: border-box;
            -webkit-box-sizing: border-box;
            box-sizing: border-box;
            overflow: hidden;
         }

   </style>
   
</head>

<body class="fixed-bottom-padding">
<div class="preloader-div">
      <div class="preloaderBg" id="preloader" onload="preloader()">
         <div class="preloader">
            <div class="preloader2"></div>
         </div>
     </div>
   </div>
 
   <div class="osahan-my_address">
      <div class="p-3 border-bottom">
         <div class="d-flex align-items-center">
            <a class="font-weight-bold text-danger text-decoration-none" href="/cart">
               <i class="icofont-rounded-left back-page"></i></a>
            <h5 class="font-weight-bold m-0 ml-3">My Address</h5>

            <a class="toggle ml-3 ml-auto" href="#"><i class="icofont-navigation-menu"></i></a>
         </div>
      </div>
      <div class="p-3" id="addressDiv">
         <!-- <div class="custom-control custom-radio px-0 mb-3 position-relative border-custom-radio">
               <input type="radio" id="customRadioInline1" name="customRadioInline1" class="custom-control-input" checked>
               <label class="custom-control-label w-100" for="customRadioInline1">
                  <div>
                     <div class="p-3 bg-white rounded shadow-sm w-100">
                        <div class="d-flex align-items-center mb-2">
                           <p class="mb-0 h6">Home</p>
                           <p class="mb-0 badge badge-success ml-auto">Default</p>
                        </div>
                        <p class="small text-muted m-0">1001 Veterans Blvd</p>
                        <p class="small text-muted m-0">Redwood City, CA 94063</p>
                        <p class="pt-2 m-0 text-right"><span class="small"><a href="#" data-toggle="modal" data-target="#addAddressModal" class="text-decoration-none text-success"><i class="icofont-edit"></i> Edit</a></span>
                           <span class="small ml-3"><a href="#" data-toggle="modal" data-target="#Delete" class="text-decoration-none text-danger"><i class="icofont-trash"></i> Delete</a></span>
                        </p>
                     </div>
                  </div>
               </label>
            </div>
            <div class="custom-control custom-radio px-0 position-relative border-custom-radio">
               <input type="radio" id="customRadioInline2" name="customRadioInline1" class="custom-control-input">
               <label class="custom-control-label w-100" for="customRadioInline2">
                  <div>
                     <div class="p-3 rounded bg-white shadow-sm w-100">
                        <div class="d-flex align-items-center mb-2">
                           <p class="mb-0 h6">Work</p>
                        </div>
                        <p class="small text-muted m-0">Model Town, Ludhiana</p>
                        <p class="small text-muted m-0">Punjab 141002, India</p>
                        <p class="pt-2 m-0 text-right"><span class="small"><a href="#" data-toggle="modal" data-target="#addAddressModal" class="text-decoration-none text-success"><i class="icofont-edit"></i> Edit</a></span>
                           <span class="small ml-3"><a href="#" data-toggle="modal" data-target="#Delete" class="text-decoration-none text-danger"><i class="icofont-trash"></i> Delete</a></span>
                        </p>
                     </div>
                  </div>
               </label>
            </div> -->
         <div class="custom-control custom-radio px-0 mb-3 position-relative border-custom-radio">
            <input type="radio" id="customRadioInline1" name="customRadioInline1" class="custom-control-input" checked>
            <label class="custom-control-label w-100" for="customRadioInline1">
               <div>
                  <div class="p-3 bg-white rounded shadow-sm w-100">
                     <div class="d-flex align-items-center mb-2">
                        <p class="mb-0 h6">No Address Found</p>
                     </div>

                  </div>
               </div>
            </label>
         </div>
      </div>
      
      <c:if test="${not empty sessionScope.contactId}" >
       <div class="container">
         <button type="button" class="btn btn-danger btn-block ml-auto rounded shadow"  data-toggle="modal" data-target="#addAddressModal">
            <i class="icofont-plus mr-1"></i> ADD NEW ADDRESS
         </button>
      </div>

      <c:choose>
         <c:when test="${not empty sessionScope.contactId}">
            <c:if test="${not empty sessionScope.subTotal &&  sessionScope.subTotal != 0 }" >
               <form action="/payment" method="POST" id="payment">
                  <input type="hidden" id="addressId" name="addressId" value="0">
                  <a href="javascript:void(0)" onclick="payment()">
                     <div class="p-3">
                        <div class="rounded shadow bg-success d-flex align-items-center p-3 text-white">
                           <div class="more">
                              <h6 class="m-0">Proceed to Payment </h6>
                           </div>
                           <div class="ml-auto"><i class="icofont-simple-right"></i></div>
                        </div>
                     </div>
                  </a>
               </form>
            </c:if>
         </c:when>
         <c:otherwise>
         </c:otherwise>
      </c:choose>

      </c:if>
      
   </div>
   <!-- Footer -->
   <%@include file="./menu/footer.jsp"%>

   <%@include file="./menu/sidenav.jsp"%>

   <!-- Modal -->
   <div class="modal fade" id="Delete" tabindex="-1" role="dialog" aria-labelledby="DeleteModalLabel"
      aria-hidden="true">
      <div class="modal-dialog modal-sm modal-dialog-centered">
         <div class="modal-content">
            <div class="modal-header">
               <h5 class="modal-title" id="DeleteModalLabel">Delete</h5>
               <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
               </button>
            </div>
            <div class="modal-body text-center d-flex align-items-center">
               <div class="w-100 px-3">
                  <i class="icofont-trash text-danger display-1 mb-5"></i>
                  <h6>Are you sure you want to delete this?</h6>
                  <p class="small text-muted m-0">1001 Veterans Blvd</p>
                  <p class="small text-muted m-0">Redwood City, CA 94063</p>
               </div>
            </div>
            <div class="modal-footer p-0 border-0">
               <div class="col-6 m-0 p-0">
                  <button type="button" class="btn border-top btn-lg btn-block" data-dismiss="modal">Close</button>
               </div>
               <div class="col-6 m-0 p-0">
                  <button type="button" class="btn btn-danger btn-lg btn-block">Delete</button>
               </div>
            </div>
         </div>
      </div>
   </div>
   <div class="modal fade" id="addAddressModal" tabindex="-1" role="dialog" aria-labelledby="addAddressModalLabel"
      aria-hidden="true">
      <div class="modal-dialog">
         <form id="addAddressForm" name="addAddressForm" >
            <div class="modal-content">
               <div class="modal-header">
                  <h5 class="modal-title" id="addAddressModalLabel">Add Delivery Address</h5>
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                     <span aria-hidden="true">&times;</span>
                  </button>
               </div>
               <div class="modal-body">

                  <div class="form-row">
                     <!-- <div class="col-md-12 form-group">
                        <label class="form-label">Delivery Area</label>
                        <div class="input-group">
                           <input placeholder="Delivery Area" type="text" class="form-control">
                           <div class="input-group-append"><button id="button-addon2" type="button"
                                 class="btn btn-outline-secondary"><i class="icofont-pin"></i></button></div>
                        </div>
                     </div> -->

                     <input type="hidden" name="contactAddressId" id="contactAddressId" value="0">
                     <input type="hidden" name="lat" id="lat" value="0">
                     <input type="hidden" name="lng" id="lng" value="0">
                     <input type="hidden" name="contactId" id="contactId" value="0">
                     <input type="hidden" name="name" id="name" value="">
                     <input type="hidden" name="phoneNo" id="phoneNo" value="">
                     <input type="hidden" name="isDefault" id="isDefault" value="0">
                     <div class="col-md-12 form-group"><label class="form-label">Address Line 1</label>
                        <input
                           placeholder="Complete Address e.g. house number, street name" type="text" id="addressLine1"
                           name="addressLine1"
                           class="form-control">
                     </div>
                     <div class="col-md-12 form-group"><label class="form-label">Address Line 2</label><input
                           placeholder="Landmark e.g. near by places" type="text" id="addressLine2"
                           name="addressLine2"
                           class="form-control">
                     </div>
                     
                     <div class="col-md-12 form-group">
                        <label class="form-label">Country</label>
                        <select name="countriesCode" id="countriesCode" class="select2 form-control" style="width: 100%"
                            data-allow-clear="true" data-placeholder="Select Country" data-dropdownmodal="addAddressModal" onchange="getStateList('countriesCode','stateCode')">
                           
                        </select>
                     </div>
                     <div class="col-md-12 form-group">
                        <label class="form-label">State</label>
                        <select name="stateCode" id="stateCode" class="select2 form-control" style="width: 100%" 
                        data-allow-clear="true" data-placeholder="Select State"  data-dropdownmodal="addAddressModal"  onchange="getCityList('stateCode','cityCode')" >
                           
                        </select>
                     </div>
                     <div class="col-md-12 form-group">
                        <label class="form-label">City</label>
                        <select name="cityCode" id="cityCode" class="select2 form-control" style="width: 100%" 
                           data-allow-clear="true" data-placeholder="Select City"  data-dropdownmodal="addAddressModal">
                           
                        </select>
                     </div>
                     <div class="col-md-12 form-group"><label class="form-label">Pincode</label><input
                           placeholder="Enter Pincode/Postal Code" name="pinCode" id="pinCode" type="text"
                           class="form-control">
                     </div>

                     <div class="col-md-12 form-group">
                        <label class="form-label">Delivery Location</label>
                        <div class="input-group mb-2" >
                           <input name="place" id="place_new" type="text" class="form-control"
                           onchange="getLocationByAutocomplete('place_new','map_new','new')"
                            >
                            <input type="hidden" name="lat" id="lat_new" value="">
                            <input type="hidden" name="lng" id="lng_new" value="">
                           <div class="input-group-append"><button id="button-addon2" type="button"
                                 class="btn btn-outline-danger"><i class="icofont-pin"></i></button></div>
                        </div>

                          <div class="map-overlay">
                           <div id="map_new"></div>
                        </div>
                     </div>
                     

                     <!-- <div class="mb-0 col-md-12 form-group">
                        <label class="form-label">Nickname</label>
                        <div class="btn-group btn-group-toggle w-100" data-toggle="buttons">
                           <label class="btn btn-outline-secondary active">
                              <input type="radio" name="options" id="option1" checked> Home
                           </label>
                           <label class="btn btn-outline-secondary">
                              <input type="radio" name="options" id="option2"> Work
                           </label>
                           <label class="btn btn-outline-secondary">
                              <input type="radio" name="options" id="option3"> Other
                           </label>
                        </div>
                     </div> -->
                  </div>

               </div>
               <div class="modal-footer p-0 border-0">
                  <div class="col-6 m-0 p-0">
                     <button type="button" class="btn border-top btn-lg btn-block" data-dismiss="modal">Close</button>
                  </div>
                  <div class="col-6 m-0 p-0">
                     <button type="button" class="btn btn-success btn-lg btn-block" id="addNewAddressBtn">Save Address</button>
                  </div>
               </div>
            </div>
         </form>
      </div>
   </div>

   <div class="modal fade" id="editAddressModal" tabindex="-1" role="dialog" aria-labelledby="editAddressModalLabel"
      aria-hidden="true">
      <div class="modal-dialog">
         <form id="editAddressForm" name="editAddressForm" >
            <div class="modal-content">
               <div class="modal-header">
                  <h5 class="modal-title" id="editAddressModalLabel">Edit Delivery Address</h5>
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                     <span aria-hidden="true">&times;</span>
                  </button>
               </div>
               <div class="modal-body">

                  <div class="form-row">
                     <!-- <div class="col-md-12 form-group">
                        <label class="form-label">Delivery Area</label>
                        <div class="input-group">
                           <input placeholder="Delivery Area" type="text" class="form-control">
                           <div class="input-group-append"><button id="button-addon2" type="button"
                                 class="btn btn-outline-secondary"><i class="icofont-pin"></i></button></div>
                        </div>
                     </div> -->

                     <input type="hidden" name="contactAddressId" id="contactAddressId" value="0">
                     <input type="hidden" name="lat" id="lat" value="0">
                     <input type="hidden" name="lng" id="lng" value="0">
                     <input type="hidden" name="contactId" id="contactId" value="0">
                     <input type="hidden" name="name" id="name" value="">
                     <input type="hidden" name="phoneNo" id="phoneNo" value="">
                     <input type="hidden" name="isDefault" id="isDefault" value="0">
                     <div class="col-md-12 form-group"><label class="form-label">Address Line 1</label>
                        <input
                           placeholder="Complete Address e.g. house number, street name" type="text" id="addressLine1"
                           name="addressLine1"
                           class="form-control">
                     </div>
                     <div class="col-md-12 form-group"><label class="form-label">Address Line 2</label><input
                           placeholder="Landmark e.g. near by places" type="text" id="addressLine2"
                           name="addressLine2"
                           class="form-control">
                     </div>
                     
                     <div class="col-md-12 form-group">
                        <label class="form-label">Country</label>
                        <select name="countriesCode" id="editcountriesCode" class="select2 form-control" style="width: 100%"
                            data-allow-clear="true" data-placeholder="Select Country"  data-dropdownmodal="editAddressModal" onchange="getStateList('editcountriesCode','editstateCode')">
                           
                        </select>
                     </div>
                     <div class="col-md-12 form-group">
                        <label class="form-label">State</label>
                        <select name="stateCode" id="editstateCode" class="select2 form-control" style="width: 100%" 
                        data-allow-clear="true" data-placeholder="Select State"  data-dropdownmodal="editAddressModal"  onchange="getCityList('editstateCode','editcityCode')" >
                           
                        </select>
                     </div>
                     <div class="col-md-12 form-group">
                        <label class="form-label">City</label>
                        <select name="cityCode" id="editcityCode" class="select2 form-control" style="width: 100%" 
                           data-allow-clear="true" data-placeholder="Select City"  data-dropdownmodal="editAddressModal">
                           
                        </select>
                     </div>
                     <div class="col-md-12 form-group"><label class="form-label">Pincode</label><input
                           placeholder="Enter Pincode/Postal Code" name="pinCode" id="pinCode" type="text"
                           class="form-control">
                     </div>

                     <div class="col-md-12 form-group">
                        <label class="form-label">Delivery Location</label>
                        <div class="input-group mb-2" >
                           <input placeholder="Delivery Area" name="place" id="place_edit" type="text" class="form-control"
                              onchange="getLocationByAutocomplete('place_edit','map_edit','edit')">
                            <input type="hidden" name="lat" id="lat_edit" value="">
                            <input type="hidden" name="lng" id="lng_edit" value="">
                           <div class="input-group-append"><button id="button-addon2" type="button"
                                 class="btn btn-outline-danger"><i class="icofont-pin"></i></button></div>
                        </div>

                          <div class="map-overlay">
                           <div id="map_edit"></div>
                        </div>
                     </div>

                     <!-- <div class="mb-0 col-md-12 form-group">
                        <label class="form-label">Nickname</label>
                        <div class="btn-group btn-group-toggle w-100" data-toggle="buttons">
                           <label class="btn btn-outline-secondary active">
                              <input type="radio" name="options" id="option1" checked> Home
                           </label>
                           <label class="btn btn-outline-secondary">
                              <input type="radio" name="options" id="option2"> Work
                           </label>
                           <label class="btn btn-outline-secondary">
                              <input type="radio" name="options" id="option3"> Other
                           </label>
                        </div>
                     </div> -->
                  </div>

               </div>
               <div class="modal-footer p-0 border-0">
                  <div class="col-6 m-0 p-0">
                     <button type="button" class="btn border-top btn-lg btn-block" data-dismiss="modal">Close</button>
                  </div>
                  <div class="col-6 m-0 p-0">
                     <button type="button" class="btn btn-success btn-lg btn-block" id="editAddressBtn">Save Changes</button>
                  </div>
               </div>
            </div>
         </form>
      </div>
   </div>
   </div>
   
   <%@include file="./footerjs.jsp"%>
   <script type="text/javascript" src="/app/vendor/formvalidation/formValidation.min.js"></script>
   <script type="text/javascript" src="/app/vendor/formvalidation/framework/bootstrap.min.js"></script>
   <script type="text/javascript" src="/app/js/location-ajax.js"></script>
   <script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>

   <script>
      let ADDRESSLIST = [];
      toastr.options = {
         "preventDuplicates": true,
         "preventOpenDuplicates": true
      };

      var latitude_default = 23.0225 ;
      var longitude_default = 72.5714 ;
      
      getLocationByAutocomplete('place_new','map_new','new')
      getLocationByAutocomplete('place_edit','map_edit','edit')

      $(document).ready(function () {


         let getCountryFnc = getCountryList('countriesCode');
         getAddress()
         $("#contactId").val('${sessionScope.contactId}');
         $("#phoneNo").val('${sessionScope.contactMobileNo}');
         $("#name").val('${sessionScope.contactName}');

          // SELECT2 INITIALIZATION : START
          $('.select2').each(function() {
            var placeholder = $(this).data('placeholder');
            var clear = $(this).data('allow-clear');
            var dropdownParent =  $(this).data('dropdownmodal');
            $(this).select2({
               placeholder:placeholder,
               allowClear : clear,
               dropdownParent : $('#'+dropdownParent)
            }); 
         });
         // SELECT2 INITIALIZATION : END

         

         // Address form Validation :::: START ::::
         
         $('#addAddressForm').formValidation({
               framework: 'bootstrap',
               excluded: ":disabled",
               /*live:'disabled', */
               button: {
                  selector: "#addNewAddressBtn",
                  disabled: "disabled"
               },
               icon: null,
               fields: {
                  addressLine1 : {
                     validators: {
                     notEmpty: {
                           message: 'This field is required.'
                        },
                     }
                  },
                  addressLine2 : {
                     validators: {
                     notEmpty: {
                           message: 'This field is required.'
                        },
                     }
                  },
                  countriesCode : {
                     validators: {
                     notEmpty: {
                           message: 'This field is required.'
                        },
                     }
                  },
                  stateCode : {
                     validators: {
                     notEmpty: {
                           message: 'This field is required.'
                        },
                     }
                  },
                  cityCode : {
                     validators: {
                     notEmpty: {
                           message: 'This field is required.'
                        },
                     }
                  },
                  place : {
                     validators: {
                     notEmpty: {
                           message: 'This field is required.'
                        },
                     }
                  },
                  pinCode : {
                     validators: {
                     notEmpty: {
                           message: 'This field is required.'
                        },
                        stringLength: {
                           min: 6,
                           max: 6,
                           message: 'Pin code must be 6 digit.'
                        },
                        regexp: {
                           regexp: /^[0-9+]+$/,
                           message: 'Pincode consist only numbers.'
                        },
                     },
                  }
               }
         });
         // Address form Validation :::: ENDS ::::

         // Address form Validation :::: START ::::
        
         $('#editAddressForm').formValidation({
               framework: 'bootstrap',
               excluded: ":disabled",
               /*live:'disabled', */
               button: {
                  selector: "#editAddressBtn",
                  disabled: "disabled"
               },
               icon: null,
               fields: {
                  addressLine1 : {
                     validators: {
                     notEmpty: {
                           message: 'This field is required.'
                        },
                     }
                  },
                  addressLine2 : {
                     validators: {
                     notEmpty: {
                           message: 'This field is required.'
                        },
                     }
                  },
                  countriesCode : {
                     validators: {
                     notEmpty: {
                           message: 'This field is required.'
                        },
                     }
                  },
                  stateCode : {
                     validators: {
                     notEmpty: {
                           message: 'This field is required.'
                        },
                     }
                  },
                  cityCode : {
                     validators: {
                     notEmpty: {
                           message: 'This field is required.'
                        },
                     }
                  },
                  place : {
                     validators: {
                     notEmpty: {
                           message: 'This field is required.'
                        },
                     }
                  },
                  pinCode : {
                     validators: {
                     notEmpty: {
                           message: 'This field is required.'
                        },
                        stringLength: {
                           min: 6,
                           max: 6,
                           message: 'Pin code must be 6 digit.'
                        },
                        regexp: {
                           regexp: /^[0-9+]+$/,
                           message: 'Pincode consist only numbers.'
                        },
                     },
                  }
               }
         });
         // Address form Validation :::: ENDS ::::


         $('#addAddressModal').on('hidden.bs.modal', function () {
				$(this).find('form').trigger('reset');
				// $(this).find('select').select2("val", "").trigger('change');
            
				$(this).find('select').val( "").trigger('change');
				$('#addAddressForm').data('formValidation').resetForm();
			})

         $('#addNewAddressBtn').click(function (e) {
               if ($('#addAddressForm').data('formValidation').isValid() == null) {
               $('#addAddressForm').data('formValidation').validate();
               }
               if ($('#addAddressForm').data('formValidation').isValid() == true) {
               $('#addNewAddressBtn').attr("disabled", true);
                  if (ADDRESSLIST.length == 0 ) {
                     $("#addAddressForm #isDefault").val(1);
                  } else {
                     
                  }
                  saveNewAddressFnc('addAddressForm');
               }
         });


         $('#editAddressBtn').click(function (e) {
               if ($('#editAddressForm').data('formValidation').isValid() == null) {
               $('#editAddressForm').data('formValidation').validate();
               }
               if ($('#editAddressForm').data('formValidation').isValid() == true) {
               $('#editAddressBtn').attr("disabled", true);
                  saveNewAddressFnc('editAddressForm');
               }
         });


      });


      let getAddress = () => {
         $.ajax({
            url: "/user/get/address",
            type: "GET",
            success: function (data, status) {
               if (data.status) {
                  console.log(data);

                  if (data.response.length > 0) {
                     ADDRESSLIST = data.response;

                     setAddressData(data.response)
                  }
               } else {
                  $("#addressId").val(0);
                   $(".preloader-div").remove();
                  toastr.error('', data.message);
               }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
               if (XMLHttpRequest.status == 0) {
                  toastr.error('', ' Check Your Network.');
               } else if (XMLHttpRequest.status == 404) {
                  toastr.error('', 'Requested URL not found.');
               } else if (XMLHttpRequest.status == 500) {
                  toastr.error('', 'Internel Server Error.');
               } else {
                  toastr.error('', 'Unknow Error.\n' + XMLHttpRequest.responseText);
               }
            }
         });
      }

      let saveNewAddressFnc = (formId) =>{
            var formData = JSON.parse(JSON.stringify(jQuery('#'+formId).serializeArray()));
                console.log(formData);

                $.ajax({
                    type: "post",
                    url: "/address/save",
                    data: formData,
                    success: function (response) {
                        if (response.status) {
                            Swal.fire({
                                icon: 'success',
                                title: 'Success',
                                text: response.message,
                            }).then((result) => {
                                if (result.isConfirmed) {
                                 getAddress();
                                 $("#addAddressModal").modal('hide');
                                 $("#editAddressModal").modal('hide');
                                }
                            })
                        } else {
                            Swal.fire({
                                icon: 'error',
                                title: 'Ooops...!!!',
                                text: response.message,
                            }).then((result) => {
                                if (result.isConfirmed) {
                                    window.location.href = "/home"
                                }
                            })
                        }
                    }
                });
        }


      function setAddressData(addressList) {


         $("#addressDiv").empty();
         let content = "";

         $.each(addressList, function (indexInArray, addressVo) { 
            

            content += '<div class="custom-control custom-radio px-0 mb-3 position-relative border-custom-radio">' +
               '<input type="radio" id="contactAddress'+addressVo.contactAddressId+'" name="contactAddress" class="custom-control-input" checked=""  value="'+addressVo.contactAddressId+'" >' +
               '<label class="custom-control-label w-100" for="contactAddress'+addressVo.contactAddressId+'">' +
               '<div>' +
               '<div class="p-3 bg-white rounded shadow-sm w-100">' +
               '<div class="d-flex align-items-center mb-2">' +
               //'<p class="mb-0 h6">Home</p>' +
               //'<p class="mb-0 badge badge-success ml-auto">Default</p>' +
               '</div>' +
               '<p class="small text-muted m-0">' + addressVo.addressLine1 + '</p>' +
               '<p class="small text-muted m-0">' + addressVo.addressLine2 + '</p>' +
               '<p class="small text-muted m-0">' + addressVo.cityName + ', ' + addressVo.stateName + ', ' + addressVo.countriesName + ', ' + addressVo.pinCode + '</p>' +
               `<p class="pt-2 m-0 text-right"><span class="small"><a href="#" data-toggle="modal" data-target="#editAddressModal" onclick="setAddressDataForEdit('`+addressVo.contactAddressId+`')" class="text-decoration-none text-success"><i class="icofont-edit"></i> Edit</a></span>`+
               '<span class="small ml-3"><a href="javascript:void(0)" class="text-decoration-none text-danger" onclick="deleteAddress('+addressVo.contactAddressId+')"><i class="icofont-trash"></i> Delete</a></span>'+
               '</p>'+
               '</div>' +
               '</div>' +
               '</label>' +
               '</div>';
         });

        
         

         $("#addressDiv").prepend(content);

         $(".preloader-div").remove();

         let addressId  = "${sessionScope.addressId}";
         if (addressId) {
            $("#contactAddress" + addressId).prop("checked", true).trigger('change');
         } 

      }

      function payment() {

         let addId = $('input[name="contactAddress"]:checked').val();
         if (addId != null && addId != undefined && addId != "") {
            $("#addressId").val(addId);
         } else {
            $("#addressId").val(0);
         }
         //alert(addId)
         if ($("#addressId").val() == 0) {
            if (ADDRESSLIST.length > 0) {
               toastr.error("", "Please Select Address...!!!");   
            } else {
               toastr.error("", "No Address Found...!!!");
            }
            
         } else {
            $("#payment").submit();
         }

      }

      let setAddressDataForEdit = (addressId) =>{

         let addressVo =  ADDRESSLIST.filter(item=> item.contactAddressId == addressId);
         console.log(addressVo);
         $("#editAddressForm #contactId").val(addressVo[0].contactId);
         $("#editAddressForm #contactAddressId").val(addressVo[0].contactAddressId);
         $("#editAddressForm #lat").val(addressVo[0].lat);
         $("#editAddressForm #lng").val(addressVo[0].lng);
         $("#editAddressForm #name").val(addressVo[0].name);
         $("#editAddressForm #phoneNo").val(addressVo[0].phoneNo);
         $("#editAddressForm #isDefault").val(addressVo[0].isDefault);
         $("#editAddressForm #addressLine1").val(addressVo[0].addressLine1);
         $("#editAddressForm #addressLine2").val(addressVo[0].addressLine2);
         $("#editcountriesCode").data('default',addressVo[0].countriesCode);
         $("#editstateCode").data('default',addressVo[0].stateCode);
         $("#editcityCode").data('default',addressVo[0].cityCode);
         $("#editAddressForm #pinCode").val(addressVo[0].pinCode);
         $("#editAddressForm #place_edit").val(addressVo[0].place).trigger("change");

         getCountryList('editcountriesCode');
         
      }

      let deleteAddress = (contactAddressId) => {
         console.log(contactAddressId);

         if (contactAddressId) {

            Swal.fire({
            title: 'Are you sure?',
            text: "You won't be able to revert this!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonText: 'Yes, delete it!'
            }).then((result) => {
               if (result.isConfirmed) {
                   $.ajax({
                        url: "/user/address/delete",
                        type:"POST",
                        data : {contactAddressId : contactAddressId},
                        success: function(data,status) {
                           if(data.status){
                              window.location.reload();
                           }else{
                              toastr.error('',data.message);
                           }
                        },
                        error: function(XMLHttpRequest, textStatus, errorThrown) { 
                           if (XMLHttpRequest.status == 0) {
                              toastr.error('',' Check Your Network.');
                           } else if (XMLHttpRequest.status == 404) {
                              toastr.error('','Requested URL not found.');
                           } else if (XMLHttpRequest.status == 500) {
                              toastr.error('','Internel Server Error.');
                           }  else {
                              toastr.error('','Unknow Error.\n' + XMLHttpRequest.responseText);
                           }     
                        }
                  });
               }
            })
           
           
         }
      }

   </script>

</body>

</html>