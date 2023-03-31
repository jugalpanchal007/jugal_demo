<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>

   <title>RRMart - Home</title>
   <%@include file="./menu/head.jsp"%>
   <style>

       

      /* .osahan-body{pointer-events: none; } */
      img.img-fluid.item-img.w-100.mb-3 {
         padding: 0px 30px !important;
      }
      .member-plan.position-absolute {
         width: 100%;
         text-align: end;
      }

      .member-plan.position-absolute-discount {
         width: 100%;
         text-align: start;
      }
      .badge {
            padding-left: 9px;
            padding-right: 9px;
            -webkit-border-radius: 9px;
            -moz-border-radius: 9px;
            border-radius: 4px;
      }



      button.btn.btn-sm.wishlistbtn {
         padding: 0.25rem 0.5rem !important;
         font-size: 16px  !important;
         line-height: 1.5  !important;
         border: none  !important;
         color: #DC3545;
      }
      label.input-group-text {
         border: 1px solid #DC3545;
         color: #fff;
         font-weight: 500;
         background: #DC3545;
      }
      select#branchSelection {
         border: 1px solid #DC3545;
      }
      .custom-select:focus {
         border-color: #80bdff;
         outline: 0;
         box-shadow: 0 0 0 0.1rem rgb(225 0 0 / 0%);
      }
      /* .vheader{
         position: fixed;
            top: 0;
            z-index: 1030;
            width: 100%;
            box-shadow: 0 .125rem .25rem rgba(0,0,0,.075)!important;
         
      } */

      .twitter-typeahead{
         width : 100% !important;
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
   
   <!-- home page -->
  
   <div class="osahan-home-page">
      <div class="border-bottom p-3 container">
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
               
            </a> -->


            <%@include file="./searchbar.jsp"%>

            <%-- <div class="input-group rounded shadow-sm overflow-hidden bg-white  mr-3" id="searchBarcodediv">
                  <input type="text" autofocus="" onchange="getproduct()" class="form-control" placeholder="Scan Barcode/Enter Product Name" id="searchBarcode" name="searchBarcode" tabindex="1" autocomplete="off" spellcheck="false" dir="auto">
            </div> --%>
            
      </div>
      <!-- body -->

      <%@include file="./subheader.jsp"%>
    
      <div class="osahan-body">

         <div class="container">

           
         <div class="pt-3 pb-0">
            <div class="align-items-center px-3 mb-0">
               
               <div class="input-group input-group-sm mb-3 shadow-sm rounded">
                  <div class="input-group-prepend">
                    <label class="input-group-text" for="branchSelection">NEAR BY STORES </label>
                  </div>
                  <select class="custom-select" id="branchSelection" style="text-transform : uppercase;" onchange="changeBranchSelection(true);">
                    
                  </select>
                </div>
                 
            </div>
         </div>
            <!-- Promos -->

         <div class="pb-3 pt-0 osahan-promos " id="oshan-promos">
            <div class="d-flex align-items-center px-3 mb-2">
               <h6 class="m-0">What are you looking for?</h6>
               

              
            </div>
            <div class="advertise-slider">
               <%-- <div class="osahan-slider-item m-2">
                  <a href="javascript:void(0);"><img src="/app/img/promos/rr1.jpeg" class="img-fluid mx-auto rounded"
                        alt="Responsive image"></a>
               </div>
               <div class="osahan-slider-item m-2">
                  <a href="javascript:void(0);"><img src="/app/img/promos/rr2.jpeg" class="img-fluid mx-auto rounded"
                        alt="Responsive image"></a>
               </div>
               <div class="osahan-slider-item m-2">
                  <a href="javascript:void(0);"><img src="/app/img/promos/online_offline.jpeg" class="img-fluid mx-auto rounded"
                        alt="Responsive image"></a>
               </div> --%>
               
            </div>
         </div>

         <!-- categories -->
         <div class="py-3 ">
            <div class="d-flex align-items-center px-3 mb-2">
               <h6 class="m-0">Categories</h6>
               <a href="/categories" class="ml-auto text-danger">See more</a>
            </div>
            <div class="categories-slider" id="catListSlider">
               

            </div>
         </div>
         
         
         <div id="bestSellingProductsDiv">
            
         </div>
         <div id="productsWithCategories">
            
         </div>

          <div id="trendingProductsDiv">
            
         </div>
         


         <!-- Pick's Today -->
         <!-- <div class="title d-flex align-items-center mb-3 mt-3 px-3">
            <h6 class="m-0">Pick's Today</h6>
            <a class="ml-auto text-danger" href="picks_today.html">See more</a>
         </div> -->
         <!-- pick today -->
         <!-- <div class="pick_today px-3">
            <div class="row">
               <div class="col-6 pr-2">
                  <div class="list-card bg-white h-100 rounded overflow-hidden position-relative shadow-sm">
                     <div class="list-card-image">
                        <a href="product_details.html" class="text-dark">
                           <div class="member-plan position-absolute"><span class="badge m-3 badge-danger">10%</span>
                           </div>
                           <div class="p-3">
                              <img src="/app/img/listing/v1.jpg" class="img-fluid item-img w-100 mb-3">
                              <h6>Chilli</h6>
                              <div class="d-flex align-items-center">
                                 <h6 class="price m-0 text-danger">$0.8/kg</h6>
                                 <a href="cart.html" class="btn btn-danger btn-sm ml-auto">+</a>
                              </div>
                           </div>
                        </a>
                     </div>
                  </div>
               </div>
               <div class="col-6 pl-2">
                  <div class="list-card bg-white h-100 rounded overflow-hidden position-relative shadow-sm">
                     <div class="list-card-image">
                        <a href="product_details.html" class="text-dark">
                           <div class="member-plan position-absolute"><span class="badge m-3 badge-danger">5%</span>
                           </div>
                           <div class="p-3">
                              <img src="/app/img/listing/v2.jpg" class="img-fluid item-img w-100 mb-3">
                              <h6>Onion</h6>
                              <div class="d-flex align-items-center">
                                 <h6 class="price m-0 text-danger">$1.8/kg</h6>
                                 <a href="cart.html" class="btn btn-danger btn-sm ml-auto">+</a>
                              </div>
                           </div>
                        </a>
                     </div>
                  </div>
               </div>
            </div>
            <div class="row pt-3">
               <div class="col-6 pr-2">
                  <div class="list-card bg-white h-100 rounded overflow-hidden position-relative shadow-sm">
                     <div class="list-card-image">
                        <a href="product_details.html" class="text-dark">
                           <div class="member-plan position-absolute"><span class="badge m-3 badge-warning">5%</span>
                           </div>
                           <div class="p-3">
                              <img src="/app/img/listing/v3.jpg" class="img-fluid item-img w-100 mb-3">
                              <h6>Tomato</h6>
                              <div class="d-flex align-items-center">
                                 <h6 class="price m-0 text-danger">$1/kg</h6>
                                 <a class="ml-auto" href="cart.html">
                                    <div class="input-group input-spinner ml-auto cart-items-number">
                                       <div class="input-group-prepend">
                                          <button class="btn btn-danger btn-sm" type="button" id="button-plus"> +
                                          </button>
                                       </div>
                                       <input type="text" class="form-control" value="1">
                                       <div class="input-group-append">
                                          <button class="btn btn-danger btn-sm" type="button" id="button-minus"> −
                                          </button>
                                       </div>
                                    </div>
                                 </a>
                              </div>
                           </div>
                        </a>
                     </div>
                  </div>
               </div>
               <div class="col-6 pl-2">
                  <div class="list-card bg-white h-100 rounded overflow-hidden position-relative shadow-sm">
                     <div class="list-card-image">
                        <a href="product_details.html" class="text-dark">
                           <div class="member-plan position-absolute"><span class="badge m-3 badge-warning">15%</span>
                           </div>
                           <div class="p-3">
                              <img src="/app/img/listing/v4.jpg" class="img-fluid item-img w-100 mb-3">
                              <h6>Cabbage</h6>
                              <div class="d-flex align-items-center">
                                 <h6 class="price m-0 text-danger">$0.8/kg</h6>
                                 <a href="cart.html" class="btn btn-danger btn-sm ml-auto">+</a>
                              </div>
                           </div>
                        </a>
                     </div>
                  </div>
               </div>
            </div>
            <div class="row pt-3">
               <div class="col-6 pr-2">
                  <div class="list-card bg-white h-100 rounded overflow-hidden position-relative shadow-sm">
                     <div class="list-card-image">
                        <a href="product_details.html" class="text-dark">
                           <div class="member-plan position-absolute"><span class="badge m-3 badge-danger">10%</span>
                           </div>
                           <div class="p-3">
                              <img src="/app/img/listing/v5.jpg" class="img-fluid item-img w-100 mb-3">
                              <h6>Cauliflower</h6>
                              <div class="d-flex align-items-center">
                                 <h6 class="price m-0 text-danger">$1.8/kg</h6>
                                 <a href="cart.html" class="btn btn-danger btn-sm ml-auto">+</a>
                              </div>
                           </div>
                        </a>
                     </div>
                  </div>
               </div>
               <div class="col-6 pl-2">
                  <div class="list-card bg-white h-100 rounded overflow-hidden position-relative shadow-sm">
                     <div class="list-card-image">
                        <a href="product_details.html" class="text-dark">
                           <div class="member-plan position-absolute"><span class="badge m-3 badge-danger">10%</span>
                           </div>
                           <div class="p-3">
                              <img src="/app/img/listing/v6.jpg" class="img-fluid item-img w-100 mb-3">
                              <h6>Carrot</h6>
                              <div class="d-flex align-items-center">
                                 <h6 class="price m-0 text-danger">$0.8/kg</h6>
                                 <a href="cart.html" class="btn btn-danger btn-sm ml-auto">+</a>
                              </div>
                           </div>
                        </a>
                     </div>
                  </div>
               </div>
            </div>
         </div> -->
         <!-- Most sales -->
         <!-- <div class="title d-flex align-items-center p-3">
            <h6 class="m-0">Recommend for You</h6>
            <a class="ml-auto text-danger" href="recommend.html">26 more</a>
         </div> -->
         <!-- osahan recommend -->
         <!-- <div class="osahan-recommend px-3">
            <div class="row">
               <div class="col-12 mb-3">
                  <a href="product_details.html" class="text-dark text-decoration-none">
                     <div class="list-card bg-white h-100 rounded overflow-hidden position-relative shadow-sm">
                        <div class="recommend-slider rounded pt-2">
                           <div class="osahan-slider-item m-2 rounded">
                              <img src="/app/img/recommend/r1.jpg" class="img-fluid mx-auto rounded shadow-sm"
                                 alt="Responsive image">
                           </div>
                           <div class="osahan-slider-item m-2 rounded">
                              <img src="/app/img/recommend/r2.jpg" class="img-fluid mx-auto rounded shadow-sm"
                                 alt="Responsive image">
                           </div>
                           <div class="osahan-slider-item m-2 rounded">
                              <img src="/app/img/recommend/r3.jpg" class="img-fluid mx-auto rounded shadow-sm"
                                 alt="Responsive image">
                           </div>
                        </div>
                        <div class="p-3 position-relative">
                           <h6 class="mb-1 font-weight-bold text-danger">Fresh Orange
                           </h6>
                           <p class="text-muted">Orange Great Quality item from Jamaica.</p>
                           <div class="d-flex align-items-center">
                              <h6 class="m-0">$8.8/kg</h6>
                              <a class="ml-auto" href="cart.html">
                                 <div class="input-group input-spinner ml-auto cart-items-number">
                                    <div class="input-group-prepend">
                                       <button class="btn btn-danger btn-sm" type="button" id="button-plus"> + </button>
                                    </div>
                                    <input type="text" class="form-control" value="1">
                                    <div class="input-group-append">
                                       <button class="btn btn-danger btn-sm" type="button" id="button-minus"> −
                                       </button>
                                    </div>
                                 </div>
                              </a>
                           </div>
                        </div>
                     </div>
                  </a>
               </div>
               <div class="col-12 mb-3">
                  <a href="product_details.html" class="text-dark text-decoration-none">
                     <div class="list-card bg-white h-100 rounded overflow-hidden position-relative shadow-sm">
                        <div class="recommend-slider rounded pt-2">
                           <div class="osahan-slider-item m-2">
                              <img src="/app/img/recommend/r4.jpg" class="img-fluid mx-auto rounded shadow-sm"
                                 alt="Responsive image">
                           </div>
                           <div class="osahan-slider-item m-2">
                              <img src="/app/img/recommend/r5.jpg" class="img-fluid mx-auto rounded shadow-sm"
                                 alt="Responsive image">
                           </div>
                           <div class="osahan-slider-item m-2">
                              <img src="/app/img/recommend/r6.jpgplusQuantity" class="img-fluid mx-auto rounded shadow-sm"
                                 alt="Responsive image">
                           </div>
                        </div>
                        <div class="p-3 position-relative">
                           <h6 class="mb-1 font-weight-bold text-danger">Green Apple</h6>
                           <p class="text-muted">Green Apple Premium item from Vietnam.</p>
                           <div class="d-flex align-items-center">
                              <h6 class="m-0">$10.8/kg</h6>
                              <a class="ml-auto" href="cart.html">
                                 <div class="input-group input-spinner ml-auto cart-items-number">
                                    <div class="input-group-prepend">
                                       <button class="btn btn-danger btn-sm" type="button" id="button-plus"> + </button>
                                    </div>
                                    <input type="text" class="form-control" value="1">
                                    <div class="input-group-append">
                                       <button class="btn btn-danger btn-sm" type="button" id="button-minus"> −
                                       </button>
                                    </div>
                                 </div>
                              </a>
                           </div>
                        </div>
                     </div>
                  </a>
               </div>
               <div class="col-12 mb-3">
                  <a href="product_details.html" class="text-dark text-decoration-none">
                     <div class="list-card bg-white h-100 rounded overflow-hidden position-relative shadow-sm">
                        <div class="recommend-slider rounded pt-2">
                           <div class="osahan-slider-item m-2">
                              <img src="/app/img/recommend/r7.jpg" class="img-fluid mx-auto rounded shadow-sm"
                                 alt="Responsive image">
                           </div>
                           <div class="osahan-slider-item m-2">
                              <img src="/app/img/recommend/r8.jpg" class="img-fluid mx-auto rounded shadow-sm"
                                 alt="Responsive image">
                           </div>
                           <div class="osahan-slider-item m-2">
                              <img src="/app/img/recommend/r9.jpg" class="img-fluid mx-auto rounded shadow-sm"
                                 alt="Responsive image">
                           </div>
                        </div>
                        <div class="p-3 position-relative">
                           <h6 class="mb-1 font-weight-bold text-danger">Fresh Apple
                           </h6>
                           <p class="text-muted">Fresh Apple Premium item from Thailand.</p>
                           <div class="d-flex align-items-center">
                              <h6 class="m-0">$12.8/kg</h6>
                              <a class="ml-auto" href="cart.html">
                                 <div class="input-group input-spinner ml-auto cart-items-number">
                                    <div class="input-group-prepend">
                                       <button class="btn btn-danger btn-sm" type="button" id="button-plus"> + </button>
                                    </div>
                                    <input type="text" class="form-control" value="1">
                                    <div class="input-group-append">
                                       <button class="btn btn-danger btn-sm" type="button" id="button-minus"> −
                                       </button>
                                    </div>
                                 </div>
                              </a>
                           </div>
                        </div>
                     </div>
                  </a>
               </div>
            </div>
         </div> -->
         </div>
      </div>
   </div>
   <!-- Footer -->
   
   <%@include file="./menu/footer.jsp"%>
   <%@include file="./signup-bonus-modal.jsp"%>

   <%@include file="./menu/sidenav.jsp"%>

   <%@include file="./footerjs.jsp"%>
<%@include file="./menu/header-script.jsp"%> 


   

   <script>
      // $.blockUI({
      //    message:'<p style="margin-bottom:0px;">Currently This Service is Not Available</p>'
      // });
      var url_string = window.location.href
      var url = new URL(url_string);
      var survey = url.searchParams.get("survey");
      console.log(url);
      console.log(survey);

      let CATEGORYLIST = [];
      let PRODUCTLIST = [];
      let CARTLIST = [];
      let CATEGORY_IMAGE_URL = "";
      let PRODUCT_IMAGE_URL = "";
      let BEST_SELLING_ITEMS = [];
      const DISCOUNT_TYPE_PERCENTAGE = "percentage";
      const DISCOUNT_TYPE_AMOUNT = "amount";

      if (survey == null) {
         survey = 0;
      }

      

      toastr.options = {
         "preventDuplicates": true,
         "preventOpenDuplicates": true
      };
      $(function () {

         console.log("ready");

         
        // getBranchList();
         getAdvertisement();
         getCartList();
         
         toastr.options = {
            "preventDuplicates": true,
            "preventOpenDuplicates": true
         };

         

         


         // getcategoryAndProductList()
         
         // $(".osahan-.osahan-body").click(function (e) {
         //    e.preventDefault();
         //    Swal.fire({
         //       icon: 'warning',
         //       title: 'Oops...',
         //       text: 'Currently this Service Is Not available...!!!',
         //    }).then((result) => {
         //       if (result.isConfirmed) {
         //          // $("#mobileNo").focus();
         //       }
         //    })

         // });
         setTimeout(() => {
            let sessionContactId = '${sessionScope.contactId}'
            if(sessionContactId){
               let isSurveyFilled = '${sessionScope.isSurveyFilled}';
               if (isSurveyFilled) {
                  if (isSurveyFilled == '0') {
                     $("#exampleModal").modal("show");
                  }
               }
               
            }
            
         }, 1000);

         

      });



      let getcategoryAndProductList = (branchId) =>{

         // $('body').preloader({
         //    text: '', 
         //    percent: '', 
         //    zIndex: '9999', 
         //    setRelative: false 
         // });

         // $('body').css("overflow-y","hidden");
         let contactId = '${sessionScope.contactId}'
         $.ajax({
            type: "get",
            url: "/productandcategory/list",
            data : {contactId : contactId,branchId : branchId},
            success: function (data) {
               
               if (data.status) {
                  
                  CATEGORYLIST = data.response.categoryList;
                  PRODUCTLIST = data.response.productList
                  CATEGORY_IMAGE_URL = data.response.categoryImageUrl
                  PRODUCT_IMAGE_URL = data.response.productImageUrl

                  //console.log(data);

                  setCategoryData(CATEGORYLIST);

                  setProductWithCategoryDataSlider(CATEGORYLIST,PRODUCTLIST);

                  

               } else {
                  
               }
            }
         });
      }


      let setCategoryData = (catList) => {

         $("#catListSlider").empty();
         let content = "";
         if (catList != null) {
            
            let categoryImageUrl = CATEGORY_IMAGE_URL
            $.each(catList, function (index, categoryVo) { 
               let actualImagePath = categoryImageUrl+'/'+ categoryVo.categoryLogo;
               //https://s3-us-west-2.amazonaws.com/vasyerpsolutions/RRmart/product-image-pv/
               let newImagePath = actualImagePath.replace("https://s3-us-west-2.amazonaws.com/vasyerpsolutions/RRmart/product-image-pv","https://ik.imagekit.io/vhveqppefvx/tr:w-200,h-200/");
               if (categoryVo.categoryLogo != null) {
                  //console.log(categoryVo);
                  content +=' <div class="osahan-slider-item m-1 bg-white shadow-sm rounded">\n'+
                  '    <div class="col p-1">\n'+
                  '       <div class=" text-center  px-1 py-3 c-it"  >\n'+
                  '          <a href="/listing?categoryId='+categoryVo.categoryId+'" >\n'+
                  `             <img  class="img-fluid px-1 d-block lazy" data-src="`+newImagePath+`" style="margin: 0 auto !important;" onError="this.onerror=null;this.src='/app/img/logo.png';" >\n`+
                  '             <p class="m-0 pt-2 text-muted text-center cut-text">'+categoryVo.categoryName+'</p>\n'+
                  '          </a>\n'+
                  '       </div>\n'+
                  '    </div>\n'+
                  ' </div>';
               } else {
                  
               }
               
            });
            $('#catListSlider').append(content);
         } else {
            
         }
         
         $(".categories-slider").removeClass("slick-initialized");
         $(".categories-slider").removeClass("slick-slider");


         $('.categories-slider').slick({
            slidesToScroll: 3,
            slidesToShow: 8,
            arrows: false,
            responsive: [
               {
                     breakpoint: 1024,
                     settings: {
                     slidesToShow: 4,
                     slidesToScroll: 4,
                     centerPadding: '40px',
                     
                     }
                  },
               {
                  breakpoint: 768,
                  settings: {
                  arrows: false,
                  centerMode: true,
                  centerPadding: '40px',
                  slidesToShow: 3
                  }
               },
               {
                  breakpoint: 480,
                  settings: {
                  arrows: false,
                  centerMode: true,
                  centerPadding: '40px',
                  slidesToShow: 3
                  }
               }
            ]
         });

         $('img.lazy').Lazy({
            // your configuration goes here
            scrollDirection: 'vertical',
            effect: 'fadeIn',
            visibleOnly: true,
            onError: function(element) {
                  console.log('error loading ' + element.data('src'));
                  $(element).attr( "src", "/app/img/logo.png" );
                   element.data('src','/app/img/logo.png')
                  $(this).attr( "src", "/app/img/logo.png" );
                  console.log('error loading ' + element.data('src'));
            }
         });


      }




      let setProductWithCategoryDataSlider = (catList,prodList) => {
         $("#productsWithCategories").empty();
         
         let content = "";
         if (catList != null) {
            let categoryImageUrl = CATEGORY_IMAGE_URL
            let productImageUrl = PRODUCT_IMAGE_URL
            $.each(catList, function (index, categoryVo) { 

               if (categoryVo.categoryLogo != null) {
               
                  let productDivHideClass = 'm--hide'

                  content +='<div class="py-3  osahan-promos">\n'+
                              '    <div class="d-flex align-items-center px-3 mb-2">\n'+
                              '       <h6 class="m-0">'+categoryVo.categoryName+'</h6>\n'+
                              '       <a href="/listing?categoryId='+categoryVo.categoryId+'" class="ml-auto text-danger">See more</a>\n'+
                              '    </div>'+
                              '    <div class="promo-slider"> \n';


                                 

                        let innerContent = '';

                                 $.each(prodList, function (indexInArray, productVo) { 

                                    let subContent = "";
                                    let cartQty = 0;
                                    let repeat = false;

                                    //console.log("CARTLIST ::::: " +CARTLIST.length);
                                    let actualImagePath = productVo.imagepath;
                                    if(actualImagePath){
                                    	
                                    }else{
                                    	actualImagePath = productImageUrl;
                                    }

                                    let newImagePath = actualImagePath.replace("https://s3-us-west-2.amazonaws.com/vasyerpsolutions/RRmart/product-image-pv","https://ik.imagekit.io/vhveqppefvx/tr:w-200,h-200/");



                                    for (let j = 0; j < CARTLIST.length; j++) {
                                      
                                      // console.log("CARTLIST productVarientId ::::: " +CARTLIST[j].productVarientId);
                                       //console.log("VarientId ::::: " + productVo.productVarientId);
                                       if (CARTLIST[j].productVarientId == productVo.productVarientId) {
                                          repeat = true;
                                          cartQty = CARTLIST[j].qty;
                                       }
                                    }

                                    //console.log("REPEAT :: " + repeat);

                                    if (productVo.availableStockQuantity > 0) {
                                       if (repeat == true) {
                                          subContent = `<a data-toggle="collapse" style="display:none;" id="addToCartBtn`+productVo.productVarientId+`" href="#collapseExample`+productVo.productVarientId+`" role="button" aria-expanded="false"`+
                                                               `aria-controls="collapseExample`+productVo.productVarientId+`" onclick="addToCartFnc(this,`+productVo.productVarientId+`,`+productVo.sellingPrice+`,1,`+productVo.availableStockQuantity+`,`+productVo.stockId+`)" class="btn-danger btn-sm btn-block text-center mt-2 ml-auto">ADD TO CART</a>`+
                                                         `<div class="collapse qty_show mt-2 show" id="collapseExample`+productVo.productVarientId+`">`+
                                                               `<div>`+
                                                                  `<span class="ml-auto" href="#">`+
                                                                     `<form id='myform'`+
                                                                           `class="cart-items-number d-flex justify-content-between w-100">`+
                                                                           `<input type='button' value='-' class='qtyminus btn btn-success btn-sm' id="qtyminus`+productVo.productVarientId+`" field='quantity' onclick='minusQuantity(`+productVo.productVarientId+`,`+productVo.sellingPrice+`,`+cartQty+`,`+productVo.availableStockQuantity+`,`+productVo.stockId+`)' />`+
                                                                           `<input type='text' name='quantity`+productVo.productVarientId+`' readonly id='quantity`+productVo.productVarientId+`' value='`+cartQty+`' class='qty form-control' />`+
                                                                        `<input type='button' value='+' class='qtyplus btn btn-success btn-sm' id="qtyplus`+productVo.productVarientId+`" field='quantity' onclick='plusQuantity(`+productVo.productVarientId+`,`+productVo.sellingPrice+`,`+cartQty+`,`+productVo.availableStockQuantity+`,`+productVo.stockId+`)' />`+
                                                                     `</form>`+
                                                                  `</span>`+
                                                               `</div>`+
                                                         `</div>`;
                                       } else {
                                          subContent = `<a data-toggle="collapse" id="addToCartBtn`+productVo.productVarientId+`" href="#collapseExample`+productVo.productVarientId+`" role="button" aria-expanded="false"`+
                                                               `aria-controls="collapseExample`+productVo.productVarientId+`" onclick="addToCartFnc(this,`+productVo.productVarientId+`,`+productVo.sellingPrice+`,1,`+productVo.availableStockQuantity+`,`+productVo.stockId+`)" class="btn-danger btn-sm btn-block text-center mt-2 ml-auto">ADD TO CART</a>`+
                                                         `<div class="collapse qty_show mt-2" id="collapseExample`+productVo.productVarientId+`">`+
                                                               `<div>`+
                                                                  `<span class="ml-auto" href="#">`+
                                                                     `<form id='myform'`+
                                                                           `class="cart-items-number d-flex justify-content-between w-100">`+
                                                                           `<input type='button' value='-' class='qtyminus btn btn-success btn-sm' id="qtyminus`+productVo.productVarientId+`" field='quantity' onclick='minusQuantity(`+productVo.productVarientId+`,`+productVo.sellingPrice+`,`+cartQty+`,`+productVo.availableStockQuantity+`,`+productVo.stockId+`)' />`+
                                                                           `<input type='text' name='quantity`+productVo.productVarientId+`' readonly id='quantity`+productVo.productVarientId+`' value='0' class='qty form-control' />`+
                                                                        `<input type='button' value='+' class='qtyplus btn btn-success btn-sm' id="qtyplus`+productVo.productVarientId+`" field='quantity' onclick='plusQuantity(`+productVo.productVarientId+`,`+productVo.sellingPrice+`,`+cartQty+`,`+productVo.availableStockQuantity+`,`+productVo.stockId+`)' />`+
                                                                     `</form>`+
                                                                  `</span>`+
                                                               `</div>`+
                                                         `</div>`;
                                       }
                                    } else {
                                       subContent = '<span class="badge mt-2 mb-1 w-100 badge-danger">OUT OF STOCK</span>'
                                    }

                                    

                                    

                                    
                                     
                                    if(productVo.categoryId ==  categoryVo.categoryId){
                                       let wishlistIcon = 'far fa-heart';
                                       let contactId = '${sessionScope.contactId}'

                                       if (contactId) {
                                          if (productVo.wishlistId != 0) {
                                             wishlistIcon =  'fa fa-heart';
                                          } else {
                                             wishlistIcon = 'far fa-heart';
                                          }
                                       } else {
                                          wishlistIcon = 'far fa-heart';
                                       }

                                       let pcontent = '<h6 class="price m-0 text-danger"> ₹ '+productVo.sellingPrice+'/'+productVo.measurementCode+'</h6>\n';
                                       if (productVo.sellingPrice == productVo.mrp) {
                                          pcontent = '<h6 class="price m-0 text-danger">₹ '+productVo.sellingPrice+'/'+productVo.measurementCode+'</h6>\n';
                                       } else {
                                          pcontent = '<h6 class="price m-0 text-danger"><small><s>₹ '+productVo.mrp+'/'+productVo.measurementCode+'</s></small><br> ₹ '+productVo.sellingPrice+'/'+productVo.measurementCode+'</h6>\n';
                                       }


                                       
                                       let discountContent = '<div class="member-plan position-absolute-discount"><span class="badge m-1 badge-danger">5%</span></div>';
                                       discountContentIcon = '';
                                       if(productVo.discountType == DISCOUNT_TYPE_PERCENTAGE){
                                          discountContentIcon = '%'
                                       }else if(productVo.discountType == DISCOUNT_TYPE_AMOUNT){
                                          discountContentIcon = '&#x20B9;'
                                       }

                                       if(parseFloat(productVo.discount) == 0.0){
                                          discountContent = ''
                                       }else if(parseFloat(productVo.discount) != 0.0){
                                          //discountContent = '<div class="member-plan position-absolute-discount"><span class="badge m-1 badge-danger">'+productVo.discount + discountContentIcon+'</span></div>';
                                          if(productVo.discountType == DISCOUNT_TYPE_PERCENTAGE){
                                             discountContent = '<div class="member-plan position-absolute-discount"><span class="badge m-1 badge-success">'+productVo.discount + discountContentIcon+' Savings</span></div>';
                                          }else if(productVo.discountType == DISCOUNT_TYPE_AMOUNT){
                                             discountContent = '<div class="member-plan position-absolute-discount"><span class="badge m-1 badge-success">'+discountContentIcon+productVo.discount +' Savings</span></div>';
                                          }
                                       }

                                       innerContent +='       <div class="osahan-slider-item m-2">\n'+
                                       
                                                      '          <div class="list-card bg-white rounded overflow-hidden position-relative shadow-sm">\n'+
                                                      '             <div class="list-card-image"   >\n'+
                                                      '                   <div class="member-plan position-absolute"><button class="btn btn-sm wishlistbtn" id="wishlistbtn'+productVo.productVarientId+'" onclick="addRemoveToWishList('+productVo.productVarientId+',this)">'+
                                                      '                   <input type="hidden" id="wishlistId'+productVo.productVarientId+'" value="'+productVo.wishlistId+'"/><i class="'+wishlistIcon+'"></i></button></div>'+
                                                                           discountContent+
                                                      '                   <div class="p-3">\n'+
                                                      '                    <a href="/product/details?productId='+productVo.productVarientId+'&categoryId='+productVo.categoryId+'" class="text-dark">\n'+
                                                      `                      <img class="img-fluid item-img w-100 mb-3 lazy" data-src="`+newImagePath+`" data-error="/app/img/logo.png">\n`+
                                                      '                      <p class="cut-text">'+productVo.productName+'</p>\n'+
                                                      '                      <div class="align-items-center">\n'+
                                                                                 pcontent+
                                                      
                                                                                 subContent+
                                                      '                      </div>\n'+
                                                      '                     </a>\n'+
                                                      '                   </div>\n'+
                                                      
                                                      '             </div>\n'+
                                                      '          </div>\n'+
                                                      '       </div>\n';
                                    }
                                 });
                                  
                  content += innerContent;          
                  content +=   '</div> </div>';
               } else {
                  
               }
               
            });
            $('#productsWithCategories').append(content);

            $('.promo-slider').slick({
               infinite: false,
               //centerPadding: '70px',
               speed: 300,
               slidesToShow:2,
               //adaptiveHeight: true,
               arrows: false,
               //dots:true,
               //autoplay: true
               infinite: false,
               speed: 300,
               slidesToShow: 5,
               slidesToScroll: 5,
               responsive: [
                  {
                     breakpoint: 1024,
                     settings: {
                     slidesToShow: 5,
                     slidesToScroll: 5,
                     centerPadding: '40px',
                     
                     }
                  },
                  
                  {
                     breakpoint: 768,
                     settings: {
                     slidesToShow: 3,
                     slidesToScroll: 3,
                     centerPadding: '40px',
                     }
                  },
                  {
                     breakpoint: 480,
                     settings: {
                     slidesToShow: 2,
                     slidesToScroll: 2,
                     centerPadding: '40px',
                     }
                  }
                  // You can unslick at a given breakpoint now by adding:
                  // settings: "unslick"
                  // instead of a settings object
               ]
            });

            
            $('img.lazy').Lazy({
               // your configuration goes here
               scrollDirection: 'vertical',
               effect: 'fadeIn',
               visibleOnly: true,
               onError: function(element) {
                     console.log('error loading ' + element.data('src'));
                     $(element).attr( "src", "/app/img/logo.png" );
                  $(this).attr( "src", "/app/img/logo.png" );
                   element.data('src','/app/img/logo.png')
                  console.log('error loading ' + element.data('src'));
               }
            });
            // remove preloader
            $(".preloader-div").remove();

            getBestsellingProducts();
         } else {
            
         }
         
      

      }




      let getCartList = () =>{

         let conatctId = "${sessionScope.contactId}";


         $.ajax({
               url: "/cart/getlist",
               type:"GET",
               success: function(data,status) {
               if(data.status){

                  CARTLIST = data.response;
               }else{
                  //toastr.error('',data.message);
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

      let getBestsellingProducts = () =>{

         $.ajax({
               url: "/bestsellingitem",
               type:"GET",
               success: function(data,status) {
               if(data.status){

                  BEST_SELLING_ITEMS = data.response.mapList;
                  setBestSellingProducts(BEST_SELLING_ITEMS);
                  setTrendingProducts(BEST_SELLING_ITEMS.reverse())

               }else{
                  //toastr.error('',data.message);
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

       let setBestSellingProducts = (bestSellingItemslist) => {
         $("#bestSellingProductsDiv").empty();
         
         let content = "";
         
            let productImageUrl = PRODUCT_IMAGE_URL

                  content +='<div class="py-3  osahan-promos">\n'+
                              '    <div class="d-flex align-items-center px-3 mb-2">\n'+
                              '       <h6 class="m-0">Best Selling Products</h6>\n'+
                              //'       <a href="/listing?categoryId='+categoryVo.categoryId+'" class="ml-auto text-danger">See more</a>\n'+
                              '    </div>'+
                              '    <div class="bestselleritems-slider"> \n';


                                 

                        let innerContent = '';

                                 $.each(bestSellingItemslist, function (indexInArray, productVo) { 

                                    let subContent = "";
                                    let cartQty = 0;
                                    let repeat = false;

                                    //console.log("CARTLIST ::::: " +CARTLIST.length);
                                    let actualImagePath =productVo.src;
                                   // console.log(actualImagePath);
                                    if(actualImagePath){
                                    	
                                    }else{
                                    	actualImagePath = productImageUrl;
                                    }

                                    let newImagePath = actualImagePath.replace("https://s3-us-west-2.amazonaws.com/vasyerpsolutions/RRmart/product-image-pv","https://ik.imagekit.io/vhveqppefvx/tr:w-200,h-200/");


                                       let pcontent = '<h6 class="price m-0 text-danger"> ₹ '+productVo.selling_price+'/'+productVo.measurementcode+'</h6>\n';
                                       if (productVo.selling_price == productVo.mrp) {
                                          pcontent = '<h6 class="price m-0 text-danger">₹ '+productVo.selling_price+'/'+productVo.measurementcode+'</h6>\n';
                                       } else {
                                          pcontent = '<h6 class="price m-0 text-danger"><small><s>₹ '+productVo.mrp+'/'+productVo.measurementcode+'</s></small><br> ₹ '+productVo.selling_price+'/'+productVo.measurementcode+'</h6>\n';
                                       }

                                    for (let j = 0; j < CARTLIST.length; j++) {
                                      
                                      // console.log("CARTLIST productVarientId ::::: " +CARTLIST[j].productVarientId);
                                       //console.log("VarientId ::::: " + productVo.productVarientId);
                                       if (CARTLIST[j].productVarientId == productVo.product_varient_id) {
                                          repeat = true;
                                          cartQty = CARTLIST[j].qty;
                                       }
                                    }

                                    //console.log("REPEAT :: " + repeat);

                                    if (repeat == true) {
                                       subContent = `<a data-toggle="collapse" style="display:none;" id="addToCartBtn`+productVo.product_varient_id+`" href="#collapseExamplebestselling`+productVo.product_varient_id+`" role="button" aria-expanded="false"`+
                                                            `aria-controls="collapseExamplebestselling`+productVo.product_varient_id+`" onclick="addToCartFnc(this,`+productVo.product_varient_id+`,`+productVo.selling_price+`,1)" class="btn-danger btn-sm btn-block text-center mt-2 ml-auto">ADD TO CART</a>`+
                                                      `<div class="collapse qty_show mt-2 show" id="collapseExamplebestselling`+productVo.product_varient_id+`">`+
                                                            `<div>`+
                                                               `<span class="ml-auto" href="#">`+
                                                                  `<form id='myform'`+
                                                                        `class="cart-items-number d-flex justify-content-between w-100">`+
                                                                        `<input type='button' value='-' class='qtyminus btn btn-success btn-sm' field='quantity' onclick='minusQuantity(`+productVo.product_varient_id+`,`+productVo.selling_price+`,1)' />`+
                                                                        `<input type='text' name='quantity`+productVo.product_varient_id+`' readonly id='quantity`+productVo.product_varient_id+`' value='`+cartQty+`' class='qty form-control' />`+
                                                                     `<input type='button' value='+' class='qtyplus btn btn-success btn-sm' field='quantity' onclick='plusQuantity(,`+productVo.product_varient_id+`,`+productVo.selling_price+`,1)' />`+
                                                                  `</form>`+
                                                               `</span>`+
                                                            `</div>`+
                                                      `</div>`;
                                    } else {
                                       subContent = `<a data-toggle="collapse" id="addToCartBtn`+productVo.product_varient_id+`" href="#collapseExamplebestselling`+productVo.product_varient_id+`" role="button" aria-expanded="false"`+
                                                            `aria-controls="collapseExamplebestselling`+productVo.product_varient_id+`" onclick="addToCartFnc(this,`+productVo.product_varient_id+`,`+productVo.selling_price+`,1)" class="btn-danger btn-sm btn-block text-center mt-2 ml-auto">ADD TO CART</a>`+
                                                      `<div class="collapse qty_show mt-2" id="collapseExamplebestselling`+productVo.product_varient_id+`">`+
                                                            `<div>`+
                                                               `<span class="ml-auto" href="#">`+
                                                                  `<form id='myform'`+
                                                                        `class="cart-items-number d-flex justify-content-between w-100">`+
                                                                        `<input type='button' value='-' class='qtyminus btn btn-success btn-sm' field='quantity' onclick='minusQuantity(`+productVo.product_varient_id+`,`+productVo.selling_price+`,1)' />`+
                                                                        `<input type='text' name='quantity`+productVo.product_varient_id+`' readonly id='quantity`+productVo.product_varient_id+`' value='0' class='qty form-control' />`+
                                                                     `<input type='button' value='+' class='qtyplus btn btn-success btn-sm' field='quantity' onclick='plusQuantity(`+productVo.product_varient_id+`,`+productVo.selling_price+`,1)' />`+
                                                                  `</form>`+
                                                               `</span>`+
                                                            `</div>`+
                                                      `</div>`;
                                    }

                                    subContent = ""; 

                                       innerContent +='       <div class="osahan-slider-item m-2">\n'+
                                                      '          <div class="list-card bg-white rounded overflow-hidden position-relative shadow-sm">\n'+
                                                      '             <div class="list-card-image" style="text-align: -webkit-center;"  >\n'+
                                                      '                <a href="/product/details?productId='+productVo.product_varient_id+'&categoryId='+productVo.category_id+'" class="text-dark">\n'+
                                                      '                   <div class="p-2">\n'+
                                                      `                      <img class="img-fluid item-img lazy" data-src="`+newImagePath+`" onError="this.onerror=null;this.src='/app/img/logo.png';">\n`+
                                                      '                      <p class="cut-text">'+productVo.name+'</p>\n'+
                                                      '                      <div class="align-items-center">\n'+
                                                      
                                                                                 pcontent+subContent+
                                                      '                      </div>\n'+
                                                      '                   </div>\n'+
                                                      '                </a>\n'+
                                                      '             </div>\n'+
                                                      '          </div>\n'+
                                                      '       </div>\n';
                                    
                                 });
                                  
                  content += innerContent;          
                  content +=   '</div> </div>';
               
            $('#bestSellingProductsDiv').append(content);

            $('.bestselleritems-slider').slick({
               infinite: true,
               //centerPadding: '70px',
               speed: 300,
               //slidesToShow:2,
               //adaptiveHeight: true,
               arrows: false,
               autoplay: true,
               infinite: false,
               speed: 300,
               slidesToShow: 5,
               slidesToScroll: 5,
               responsive: [
                  {
                     breakpoint: 1024,
                     settings: {
                     slidesToShow: 5,
                     slidesToScroll: 5,
                     centerPadding: '40px',
                     
                     }
                  },
                  
                  {
                     breakpoint: 768,
                     settings: {
                     slidesToShow: 3,
                     slidesToScroll: 3,
                     centerPadding: '40px',
                     }
                  },
                  {
                     breakpoint: 480,
                     settings: {
                     slidesToShow:3,
                     slidesToScroll: 2,
                     centerPadding: '40px',
                     }
                  }
                  // You can unslick at a given breakpoint now by adding:
                  // settings: "unslick"
                  // instead of a settings object
               ]
            });

            
            $('img.lazy').Lazy({
               // your configuration goes here
               scrollDirection: 'vertical',
               effect: 'fadeIn',
               visibleOnly: true,
               onError: function(element) {
                     console.log('error loading ' + element.data('src'));
                     $(element).attr( "src", "/app/img/logo.png" );
                  $(this).attr( "src", "/app/img/logo.png" );
                   element.data('src','/app/img/logo.png')
                  console.log('error loading ' + element.data('src'));
               }
            });
            // remove preloader
            $(".preloader-div").remove();
        
      }

      let setTrendingProducts = (trendingProductlist) => {
         $("#trendingProductsDiv").empty();
         
         let content = "";
         
            let productImageUrl = PRODUCT_IMAGE_URL

                  content +='<div class="py-3  osahan-promos">\n'+
                              '    <div class="d-flex align-items-center px-3 mb-2">\n'+
                              '       <h6 class="m-0 text-center">TRENDING PRODUCTS</h6>\n'+
                              //'       <a href="/listing?categoryId='+categoryVo.categoryId+'" class="ml-auto text-danger">See more</a>\n'+
                              '    </div>'+
                              '    <div class="trendingProduct-slider"> \n';


                                 

                        let innerContent = '';

                                 $.each(trendingProductlist, function (indexInArray, productVo) { 

                                    let subContent = "";
                                    let cartQty = 0;
                                    let repeat = false;

                                    //console.log("CARTLIST ::::: " +CARTLIST.length);
                                    let actualImagePath =productVo.src;
                                   // console.log(actualImagePath);
                                    if(actualImagePath){
                                    	
                                    }else{
                                    	actualImagePath = productImageUrl;
                                    }

                                    let newImagePath = actualImagePath.replace("https://s3-us-west-2.amazonaws.com/vasyerpsolutions/RRmart/product-image-pv","https://ik.imagekit.io/vhveqppefvx/tr:w-200,h-200/");


                                    let pcontent = '<h6 class="price m-0 text-danger"> ₹ '+productVo.selling_price+'/'+productVo.measurementcode+'</h6>\n';
                                    if (productVo.selling_price == productVo.mrp) {
                                       pcontent = '<h6 class="price m-0 text-danger">₹ '+productVo.selling_price+'/'+productVo.measurementcode+'</h6>\n';
                                    } else {
                                       pcontent = '<h6 class="price m-0 text-danger"><small><s>₹ '+productVo.mrp+'/'+productVo.measurementcode+'</s></small><br> ₹ '+productVo.selling_price+'/'+productVo.measurementcode+'</h6>\n';
                                    }

                                    for (let j = 0; j < CARTLIST.length; j++) {
                                      
                                      // console.log("CARTLIST productVarientId ::::: " +CARTLIST[j].productVarientId);
                                       //console.log("VarientId ::::: " + productVo.productVarientId);
                                       if (CARTLIST[j].productVarientId == productVo.product_varient_id) {
                                          repeat = true;
                                          cartQty = CARTLIST[j].qty;
                                       }
                                    }

                                    //console.log("REPEAT :: " + repeat);

                                    if (repeat == true) {
                                       subContent = `<a data-toggle="collapse" style="display:none;" id="addToCartBtn`+productVo.product_varient_id+`" href="#collapseExamplebestselling`+productVo.product_varient_id+`" role="button" aria-expanded="false"`+
                                                            `aria-controls="collapseExamplebestselling`+productVo.product_varient_id+`" onclick="addToCartFnc(this,`+productVo.product_varient_id+`,`+productVo.selling_price+`,1)" class="btn-danger btn-sm btn-block text-center mt-2 ml-auto">ADD TO CART</a>`+
                                                      `<div class="collapse qty_show mt-2 show" id="collapseExamplebestselling`+productVo.product_varient_id+`">`+
                                                            `<div>`+
                                                               `<span class="ml-auto" href="#">`+
                                                                  `<form id='myform'`+
                                                                        `class="cart-items-number d-flex justify-content-between w-100">`+
                                                                        `<input type='button' value='-' class='qtyminus btn btn-success btn-sm' field='quantity' onclick='minusQuantity(`+productVo.product_varient_id+`,`+productVo.selling_price+`,1)' />`+
                                                                        `<input type='text' name='quantity`+productVo.product_varient_id+`' readonly id='quantity`+productVo.product_varient_id+`' value='`+cartQty+`' class='qty form-control' />`+
                                                                     `<input type='button' value='+' class='qtyplus btn btn-success btn-sm' field='quantity' onclick='plusQuantity(,`+productVo.product_varient_id+`,`+productVo.selling_price+`,1)' />`+
                                                                  `</form>`+
                                                               `</span>`+
                                                            `</div>`+
                                                      `</div>`;
                                    } else {
                                       subContent = `<a data-toggle="collapse" id="addToCartBtn`+productVo.product_varient_id+`" href="#collapseExamplebestselling`+productVo.product_varient_id+`" role="button" aria-expanded="false"`+
                                                            `aria-controls="collapseExamplebestselling`+productVo.product_varient_id+`" onclick="addToCartFnc(this,`+productVo.product_varient_id+`,`+productVo.selling_price+`,1)" class="btn-danger btn-sm btn-block text-center mt-2 ml-auto">ADD TO CART</a>`+
                                                      `<div class="collapse qty_show mt-2" id="collapseExamplebestselling`+productVo.product_varient_id+`">`+
                                                            `<div>`+
                                                               `<span class="ml-auto" href="#">`+
                                                                  `<form id='myform'`+
                                                                        `class="cart-items-number d-flex justify-content-between w-100">`+
                                                                        `<input type='button' value='-' class='qtyminus btn btn-success btn-sm' field='quantity' onclick='minusQuantity(`+productVo.product_varient_id+`,`+productVo.selling_price+`,1)' />`+
                                                                        `<input type='text' name='quantity`+productVo.product_varient_id+`' readonly id='quantity`+productVo.product_varient_id+`' value='0' class='qty form-control' />`+
                                                                     `<input type='button' value='+' class='qtyplus btn btn-success btn-sm' field='quantity' onclick='plusQuantity(`+productVo.product_varient_id+`,`+productVo.selling_price+`,1)' />`+
                                                                  `</form>`+
                                                               `</span>`+
                                                            `</div>`+
                                                      `</div>`;
                                    }

                                    subContent = ""; 

                                       innerContent +='       <div class="osahan-slider-item m-2">\n'+
                                                      '          <div class="list-card bg-white rounded overflow-hidden position-relative shadow-sm">\n'+
                                                      '             <div class="list-card-image"  style="text-align: -webkit-center;" >\n'+
                                                      '                <a href="/product/details?productId='+productVo.product_varient_id+'&categoryId='+productVo.category_id+'" class="text-dark">\n'+
                                                      '                   <div class="p-2">\n'+
                                                      `                      <img class="img-fluid item-img lazy" data-src="`+newImagePath+`" onError="this.onerror=null;this.src='/app/img/logo.png';">\n`+
                                                      '                      <p class="cut-text">'+productVo.name+'</p>\n'+
                                                      '                      <div class="align-items-center">\n'+
                                                                                    pcontent+
                                                                                 subContent+
                                                      '                      </div>\n'+
                                                      '                   </div>\n'+
                                                      '                </a>\n'+
                                                      '             </div>\n'+
                                                      '          </div>\n'+
                                                      '       </div>\n';
                                    
                                 });
                                  
                  content += innerContent;          
                  content +=   '</div> </div>';
               
            $('#trendingProductsDiv').append(content);

            $('.trendingProduct-slider').slick({
               infinite: true,
               //centerPadding: '70px',
               speed: 300,
               //slidesToShow:2,
               //adaptiveHeight: true,
               arrows: false,
               autoplay: true,
               infinite: false,
               speed: 300,
               slidesToShow: 5,
               slidesToScroll: 5,
               responsive: [
                  {
                     breakpoint: 1024,
                     settings: {
                     slidesToShow: 5,
                     slidesToScroll: 5,
                     centerPadding: '40px',
                     
                     }
                  },
                  
                  {
                     breakpoint: 768,
                     settings: {
                     slidesToShow: 3,
                     slidesToScroll: 3,
                     centerPadding: '40px',
                     }
                  },
                  {
                     breakpoint: 480,
                     settings: {
                     slidesToShow:3,
                     slidesToScroll: 2,
                     centerPadding: '40px',
                     }
                  }
                  // You can unslick at a given breakpoint now by adding:
                  // settings: "unslick"
                  // instead of a settings object
               ]
            });

            
            $('img.lazy').Lazy({
               // your configuration goes here
               scrollDirection: 'vertical',
               effect: 'fadeIn',
               visibleOnly: true,
               onError: function(element) {
                    console.log('error loading ' + element.data('src'));
                    $(element).attr( "src", "/app/img/logo.png" );
                  $(this).attr( "src", "/app/img/logo.png" );
                  element.data('src','/app/img/logo.png')
                  console.log('error loading ' + element.data('src','/app/img/logo.png'));
               }
            });
            // remove preloader
            $(".preloader-div").remove();
        
      }

      let getAdvertisement = () =>{


         $.ajax({
               url: "/user/offers",
               type:"GET",
               success: function(data,status) {
               if(data.status){
                  //CARTLIST = data.response;
                  let content = "";

                  let imgsrc = data.response.imgsrc;
                  let offerList = data.response.offerList;
                  $(".advertise-slider").empty();

                  $.each(offerList, function (indexInArray, advertisementVo) { 
                        let url = imgsrc +'/'+ advertisementVo.advertisement_id + '/'+  advertisementVo.src;
                        content  += '<div class="osahan-slider-item m-2">'+
                              '<a href="javascript:void(0);"><img src="'+url+'" class="img-fluid mx-auto rounded" alt="Responsive image"></a>'+
                           '</div>';
                  });

                  $(".advertise-slider").append(content);



                  // Promo Slider
                     $('.advertise-slider').slick({
                     //centerMode: true,
                     
                     // infinite: true,
                     // speed: 300,
                     // slidesToShow: 4,
                     // arrows: false,
                     // adaptiveHeight: false,
                     // responsive: [
                     //          {
                     //             breakpoint: 1024,
                     //             settings: {
                     //             slidesToShow: 6,
                     //             slidesToScroll: 6,
                     //             centerPadding: '40px',
                                 
                     //             }
                     //          },
                              
                     //          {
                     //             breakpoint: 600,
                     //             settings: {
                     //             slidesToShow: 3,
                     //             slidesToScroll: 3,
                     //             centerPadding: '40px',
                     //             }
                     //          },
                     //          {
                     //             breakpoint: 480,
                     //             settings: {
                     //             slidesToShow: 4,
                     //             slidesToScroll: 4,
                     //             centerPadding: '40px',
                     //             }
                     //          }
                     //          // You can unslick at a given breakpoint now by adding:
                     //          // settings: "unslick"
                     //          // instead of a settings object
                     //       ]

                     slidesToShow: 3,
                     arrows: false,
                     //dots: true,
                     infinite: true,
                     responsive: [
                        {
                           breakpoint: 768,
                           settings: {
                           arrows: false,
                           centerMode: true,
                           centerPadding: '40px',
                           slidesToShow: 1
                           }
                        },
                        {
                           breakpoint: 480,
                           settings: {
                           arrows: false,
                           centerMode: true,
                           centerPadding: '40px',
                           slidesToShow: 1
                           }
                        }
                     ]
                     });
                  


               }else{
                  // toastr.error('',data.message);
                  console.log(data.message);
                  $("#oshan-promos").hide();
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


   addRemoveToWishList =(productVarientId,e) =>{


      let contactId = '${sessionScope.contactId}';

      if (contactId) {
         console.log(productVarientId);
         

         let wishlistId = $("#wishlistId"+productVarientId).val();
         console.log(wishlistId);

         let className = $(e).find('i').attr("class");
         if (className == 'fa fa-heart') {
            $(e).find('i').attr("class","far fa-heart");
         } else {
            $(e).find('i').attr("class","fa fa-heart");
         }

         
         if(wishlistId == 0){

            let data = {
               productVarientId : productVarientId,
               contactId : contactId,
               isDeleted : 0,
               isSavelater : 0,
               wishlistId : 0
            }

             $.ajax({
                  url: "/user/wishlist/save",
                  type:"POST",
                  data: data,
                  success: function(data,status) {
                     if(data.status){
                        console.log(data);
                        $("#wishlistId"+productVarientId).val(data.response.wishlistId);
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

         }else{

            console.log("INSIDE ELZE");
            $.ajax({
                  url: "/user/wishlist/delete",
                  type:"POST",
                  data: {wishlistId : wishlistId},
                  success: function(data,status) {
                     if(data.status){
                        console.log(data);
                        $("#wishlistId"+productVarientId).val(0);
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

        
      } else {
         Swal.fire({
              icon: 'error',
              title: 'Oops...',
              text: "Please Login First...!!!",
          }).then((result) => {
              if (result.isConfirmed) {
                window.location.href="/signin"
              }
          })
      }
      
      
   }





      




     

   </script>
   
   


</body>

</html>