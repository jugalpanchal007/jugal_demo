<!DOCTYPE html>
<html lang="en">

<head>
   
   <title>RRMart - Product Details</title>
   <%@include file="./menu/head.jsp"%>
   <style>
      .fixed-bottom .btn, .fixed-bottom.btn {
         height: 59px;
         border-radius: 0px;
         display: flex;
         align-items: center;
         justify-content: center;
         font-size: 16px;
         font-weight: 500;
         padding: 12px 14px;
         border: none;
         margin: 0px;
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
   

   <div class="p-3 bg-white">
      <div class="d-flex align-items-center">
         <a class="font-weight-bold text-danger text-decoration-none" href="javascript:void(0);" onclick="goBackFromProductDetailPage();">
            <i class="icofont-rounded-left back-page"></i> Back
         </a>
         <%-- <a class="ml-auto font-weight-bold text-white text-decoration-none" href="javascript:void(0);">
            <i class="icofont-heart p-2 bg-danger shadow-sm rounded-circle"></i>
         </a> --%>
         <!-- <a class="font-weight-bold text-white text-decoration-none ml-2" href="#">
            <i class="icofont-share p-2 bg-success shadow-sm rounded-circle"></i>
         </a> -->
         <a class="toggle ml-3 ml-auto" href="#"><i class="icofont-navigation-menu"></i></a>
      </div>
   </div>
   <div class="px-3 bg-white pb-3">
      <div class="pt-0">
         <h3 class="font-weight-bold" id="productName"></h3>
         <p class="font-weight-light text-dark m-0 d-flex align-items-center">
            Product Price :  <b class="h6 text-dark m-0" id="productPrice"></b>
            <span id="productPriceDiscount">50% OFF</span>
         </p>
         <a href="Javascript:void(0);">
            <div class="rating-wrap d-flex align-items-center mt-2">
               <ul class="rating-stars list-unstyled">
                  <li>
                     <i class="icofont-star text-warning"></i>
                     <i class="icofont-star text-warning"></i>
                     <i class="icofont-star text-warning"></i>
                     <i class="icofont-star text-warning"></i>
                     <i class="icofont-star"></i>
                  </li>
               </ul>
               <p class="label-rating text-muted ml-2 small"> (245 Reviews)</p>
            </div>
         </a>
      </div>
      <!-- <div class="pt-2">
         <div class="row">
            <div class="col-6">
               <p class="font-weight-bold m-0">Delivery</p>
               <p class="text-muted m-0">Free</p>
            </div>
            <div class="col-6">
               <p class="font-weight-bold m-0">Available in:</p>
               <p class="text-muted m-0">1 kg, 2 kg, 5 kg</p>
            </div>
         </div>
      </div> -->
   </div>



   <div class="osahan-product">

      <div class="product-details">
         <div class="recommend-slider py-1">
            <div class="osahan-slider-item m-2">
               <img src="/app/img/recommend/r1.jpg" class="img-fluid mx-auto shadow-sm rounded" alt="Responsive image">
            </div>
            
         </div>
         <div class="details">
            <div class="bg-white" style="padding: 5px 15px;">
               <div class=" align-items-center">
                  <!-- d-flex removed from above div  -->
                  <!-- Product VAriants -->
                  <!-- <div class="btn-group osahan-radio btn-group-toggle" data-toggle="buttons">
                     <label class="btn btn-secondary active">
                        <input type="radio" name="options" id="option1" checked> 4 pcs
                     </label>
                     <label class="btn btn-secondary">
                        <input type="radio" name="options" id="option2"> 6 pcs
                     </label>
                     <label class="btn btn-secondary">
                        <input type="radio" name="options" id="option3"> 1 kg
                     </label>
                  </div> -->
                  <!--/ Product VAriants -->
                  <div id="addToCartDiv">

                  </div>
               </div>
            </div>
            <div class="p-3">

               <!-- search Product -->
               <!-- <div class="input-group mb-3 rounded shadow-sm overflow-hidden bg-white">
                  <div class="input-group-prepend">
                     <button class="border-0 btn btn-outline-secondary text-success bg-white"><i
                           class="icofont-search"></i></button>
                  </div>
                  <input type="text" class="shadow-none border-0 form-control form-control-lg pl-0"
                     placeholder="Type your city (e.g Chennai, Pune)" aria-label="" aria-describedby="basic-addon1">
               </div> -->

               <p class="font-weight-bold mb-2">Product Details</p>
               <p class="text-muted small" id="productDescription">High quality Fresh Orange fruit exporters from South Korea for sale. All
                  citrus trees belong to the single genus Citrus and remain almost entirely interfertile. This includes
                  grapefruits, lemons, limes, oranges, and various other types and hybrids. The fruit of any citrus tree
                  is considered a hesperidium, a kind of modified berry; it is covered by a rind originated by a rugged
                  thickening of the ovary wall.</p>
               <p class="font-weight-bold mb-3">Maybe You Like this.</p>
               <div class="row bg-white" id="otherProductDetailsDiv">
                  
               </div>
               
            </div>
         </div>
         <div class="fixed-bottom pd-f bg-white d-flex align-items-center border-top">
            <a href="/cart" class="btn btn-warning btn-block"><i class="icofont-cart mr-2"></i> Go To Cart</a>
            <a href="/home" class="btn btn-success btn-block">Continue Shoping</a>
         </div>
      </div>
   </div>
   <%@include file="./menu/footer.jsp"%>
    <%@include file="./menu/sidenav.jsp"%>
    <!-- Bootstrap core JavaScript -->
    <%@include file="./footerjs.jsp"%>
 
    <script>
       // $.blockUI({
       //    message:'<p style="margin-bottom:0px;">Currently This Service is Not Available</p>'
       // });

       toastr.options = {
               "preventDuplicates": true,
               "preventOpenDuplicates": true
            };
 
       var url_string = window.location.href
       var url = new URL(url_string);
       var categoryId = url.searchParams.get("categoryId");
       var productId = url.searchParams.get("productId");
       console.log(url);
       console.log(categoryId);
       let PRODUCTLIST = [];
       let OTHERPRODUCTLIST = [];
       let ACTUALPRODUCT = [];
       let CARTLIST = [];
             const DISCOUNT_TYPE_PERCENTAGE = "percentage";
      const DISCOUNT_TYPE_AMOUNT = "amount";

       $(function () {
 
         getCartList();
         getProductListByCategory(categoryId);
 
       });
 
 
 
       let getProductListByCategory = (categoryId) => {
          let contactId = '${sessionScope.contactId}'
          let branchId = '${sessionScope.branchId}'
          let productImageUrl = ""
          $.ajax({
             type: "get",
             url: "/product/listbycategory",
             data: {
                categoryId: categoryId,
                contactId : contactId,
                branchId : branchId,
             },
             success: function (data) {
 
               if (data.status) {
 
                  
                  PRODUCTLIST = data.response.productList
                  console.log(PRODUCTLIST);
                  ACTUALPRODUCT = PRODUCTLIST.filter(product => product.productVarientId == productId);
                  OTHERPRODUCTLIST = PRODUCTLIST.filter(product => product.productVarientId != productId);

                  productImageUrl = data.response.productImageUrl
                  setProductListData(OTHERPRODUCTLIST, productImageUrl);
                  setActualProductData(ACTUALPRODUCT, productImageUrl)

                  
 
               } else {
                  
               }
             }
          });
       }
 
 
      let setProductListData = (productList, productImageUrl) => {
          $("#otherProductDetailsDiv").empty();
          let content = "";
          if (productList != null) {
             $.each(productList, function (index, productVo) {

                let actualImagePath = productVo.imagepath;

                if (actualImagePath) {
                   
                } else {
                   actualImagePath = productImageUrl;
                }

                                    let newImagePath = actualImagePath.replace("https://s3-us-west-2.amazonaws.com/vasyerpsolutions/RRmart/product-image-pv","https://ik.imagekit.io/vhveqppefvx/tr:w-200,h-200/");


               let subContent = "";
                                    let cartQty = 0;
                                    let repeat = false;

                                    console.log("CARTLIST ::::: " +CARTLIST.length);

                                    for (let j = 0; j < CARTLIST.length; j++) {
                                      
                                       console.log("CARTLIST productVarientId ::::: " +CARTLIST[j].productVarientId);
                                       console.log("VarientId ::::: " + productVo.productVarientId);
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
                                                                        `<input type='button' value='-' class='qtyminus btn btn-success btn-sm' field='quantity' onclick='minusQuantity(`+productVo.productVarientId+`,`+productVo.sellingPrice+`,`+cartQty+`,`+productVo.availableStockQuantity+`,`+productVo.stockId+`)' />`+
                                                                        `<input type='text' name='quantity`+productVo.productVarientId+`' readonly id='quantity`+productVo.productVarientId+`' value='`+cartQty+`' class='qty form-control' />`+
                                                                     `<input type='button' value='+' class='qtyplus btn btn-success btn-sm' field='quantity' onclick='plusQuantity(`+productVo.productVarientId+`,`+productVo.sellingPrice+`,`+cartQty+`,`+productVo.availableStockQuantity+`,`+productVo.stockId+`)' />`+
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
                                                                        `<input type='button' value='-' class='qtyminus btn btn-success btn-sm' field='quantity' onclick='minusQuantity(`+productVo.productVarientId+`,`+productVo.sellingPrice+`,`+cartQty+`,`+productVo.availableStockQuantity+`,`+productVo.stockId+`)' />`+
                                                                        `<input type='text' name='quantity`+productVo.productVarientId+`' readonly id='quantity`+productVo.productVarientId+`' value='0' class='qty form-control' />`+
                                                                     `<input type='button' value='+' class='qtyplus btn btn-success btn-sm' field='quantity' onclick='plusQuantity(`+productVo.productVarientId+`,`+productVo.sellingPrice+`,`+cartQty+`,`+productVo.availableStockQuantity+`,`+productVo.stockId+`)' />`+
                                                                  `</form>`+
                                                               `</span>`+
                                                            `</div>`+
                                                      `</div>`;
                                    }

                                    } else {
                                       subContent = '<span class="badge mt-2 mb-1 w-100 badge-danger">OUT OF STOCK</span>'
                                    }

                //console.log(productVo);

               //   if(productVo.categoryId ==  categoryVo.categoryId){
               //    let wishlistIcon = 'far fa-heart';
               //    let contactId = '${sessionScope.contactId}'

               //    if (contactId) {
               //       if (productVo.wishlistId != 0) {
               //          wishlistIcon =  'fa fa-heart';
               //       } else {
               //          wishlistIcon = 'far fa-heart';
               //       }
               //    } else {
               //       wishlistIcon = 'far fa-heart';
               //    }

                  let pcontent = '<h6 class="price m-0 text-danger"> &#x20B9; '+productVo.sellingPrice+'/'+productVo.measurementCode+'</h6>\n';
                  if (productVo.sellingPrice == productVo.mrp) {
                     pcontent = '<h6 class="price m-0 text-danger">&#x20B9; '+productVo.sellingPrice+'/'+productVo.measurementCode+'</h6>\n';
                  } else {
                     pcontent = '<h6 class="price m-0 text-danger"><small><s>&#x20B9; '+productVo.mrp+'/'+productVo.measurementCode+'</s></small><br> &#x20B9; '+productVo.sellingPrice+'/'+productVo.measurementCode+'</h6>\n';
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

                
                content += ' <div class="col-6 p-0" style="border: 1px solid #dee2e6!important;">'+
                               '<div class="list-card-image" >'+
                                  '<a href="/product/details?productId='+productVo.productVarientId+'&categoryId='+productVo.categoryId+'" class="text-dark">'+
                                     discountContent+
                                     '<div class="p-3">'+
                                        `<img src="`+newImagePath+`" class="img-fluid item-img w-100 mb-3 p-3" onError="this.onerror=null;this.src='/app/img/logo.png';">`+
                                        '<h6 class="cut-text">'+productVo.productName+'</h6>'+
                                        '<div class="align-items-center">'+
                                            pcontent+
                                           subContent+
                                        '</div>'+
                                     '</div>'+
                                  '</a>'+
                               '</div>'+
                            '</div>';
                 
 
             });
             $('#otherProductDetailsDiv').append(content);
          } else {
 
          }
 
       }

       let setActualProductData = (productList, productImageUrl) => {

          if (productList != null) {
             let content = "";
             $(".recommend-slider").empty();
             $.each(productList, function (index, productVo) {

               let actualImagePath = productVo.imagepath;

               if (actualImagePath) {
                   
                } else {
                   actualImagePath = productImageUrl;
                }


                                    let newImagePath = actualImagePath.replace("https://s3-us-west-2.amazonaws.com/vasyerpsolutions/RRmart/product-image-pv","https://ik.imagekit.io/vhveqppefvx/tr:w-200,h-200/");

               
                if (productVo.imagepath != "" && productVo.imagepath != null) {
                  for (let index = 0; index < 3; index++) {
                     content += ' <div class="osahan-slider-item m-2">'+
                              `<img src="`+newImagePath+`"  onError="this.onerror=null;this.src='/app/img/logo.png';" class="img-fluid mx-auto shadow-sm rounded bg-white p-4" alt="Responsive image">`+
                           '</div>';
                  }
                } else {
                  for (let index = 0; index < 3; index++) {
                     content += ' <div class="osahan-slider-item m-2">'+
                              '<img src="/app/img/defaultImages/default-product-image.jpg" class="img-fluid mx-auto shadow-sm rounded bg-white p-4" alt="Responsive image">'+
                           '</div>';
                  }
                }

                let subContent = "";
               let cartQty = 0;
               let repeat = false;

               console.log("CARTLIST ::::: " +CARTLIST.length);

               for (let j = 0; j < CARTLIST.length; j++) {
                  
                  console.log("CARTLIST productVarientId ::::: " +CARTLIST[j].productVarientId);
                  console.log("VarientId ::::: " + productVo.productVarientId);
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
                                                      `<input type='button' value='-' class='qtyminus btn btn-success btn-sm' field='quantity' onclick='minusQuantity(`+productVo.productVarientId+`,`+productVo.sellingPrice+`,`+cartQty+`,`+productVo.availableStockQuantity+`,`+productVo.stockId+`)' />`+
                                                      `<input type='text' name='quantity`+productVo.productVarientId+`' readonly id='quantity`+productVo.productVarientId+`' value='`+cartQty+`' class='qty form-control' />`+
                                                   `<input type='button' value='+' class='qtyplus btn btn-success btn-sm' field='quantity' onclick='plusQuantity(`+productVo.productVarientId+`,`+productVo.sellingPrice+`,`+cartQty+`,`+productVo.availableStockQuantity+`,`+productVo.stockId+`)' />`+
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
                                                      `<input type='button' value='-' class='qtyminus btn btn-success btn-sm' field='quantity' onclick='minusQuantity(`+productVo.productVarientId+`,`+productVo.sellingPrice+`,`+cartQty+`,`+productVo.availableStockQuantity+`,`+productVo.stockId+`)' />`+
                                                      `<input type='text' name='quantity`+productVo.productVarientId+`' readonly id='quantity`+productVo.productVarientId+`' value='0' class='qty form-control' />`+
                                                   `<input type='button' value='+' class='qtyplus btn btn-success btn-sm' field='quantity' onclick='plusQuantity(`+productVo.productVarientId+`,`+productVo.sellingPrice+`,`+cartQty+`,`+productVo.availableStockQuantity+`,`+productVo.stockId+`)' />`+
                                                `</form>`+
                                             `</span>`+
                                          `</div>`+
                                    `</div>`;
                  }
               } else {
                  subContent = '<span class="badge mt-2 mb-1 w-100 badge-danger">OUT OF STOCK</span>'
               }

               //  let addToCartContent  = ""
               //  addToCartContent += `<a data-toggle="collapse" id="addToCartBtn`+productVo.productId+`" href="#collapseExample`+productVo.productId+`" role="button" aria-expanded="false"`+
               //          `aria-controls="collapseExample`+productVo.productId+`" onclick="addToCartFnc(this)" class="btn-danger btn-lg btn-block text-center  ml-auto">ADD TO CART</a>`+
               //    `<div class="collapse qty_show " id="collapseExample`+productVo.productId+`">`+
               //          `<div>`+
               //             `<span class="ml-auto" href="#">`+
               //                `<form id='myform'`+
               //                      `class="cart-items-number d-flex justify-content-between w-100">`+
               //                      `<input type='button' value='-' class='qtyminus btn btn-success btn-lg' field='quantity' onclick='minusQuantity(`+productVo.productId+`)' />`+
               //                      `<input type='text' name='quantity`+productVo.productId+`' readonly id='quantity`+productVo.productId+`' value='1' class='qty form-control' />`+
               //                   `<input type='button' value='+' class='qtyplus btn btn-success btn-lg' field='quantity' onclick='plusQuantity(`+productVo.productId+`)' />`+
               //                `</form>`+
               //             `</span>`+
               //          `</div>`+
               //    `</div>`;
                  $("#addToCartDiv").html(subContent);


                  let pcontent = '<h6 class="price m-0 text-danger"> &#x20B9; '+productVo.sellingPrice+'/'+productVo.measurementCode+'</h6>\n';
                  if (productVo.sellingPrice == productVo.mrp) {
                     pcontent = '<h6 class="price m-0 text-danger">&#x20B9; '+productVo.sellingPrice+'/'+productVo.measurementCode+'</h6>\n';
                  } else {
                     pcontent = '<h6 class="price m-0 text-danger"><small><s>&#x20B9; '+productVo.mrp+'/'+productVo.measurementCode+'</s></small> &#x20B9; '+productVo.sellingPrice+'/'+productVo.measurementCode+'</h6>\n';
                  }

                  let discountContent = '<span class="badge m-1 badge-success">5%</span>';
                     discountContentIcon = '';
                     if(productVo.discountType == DISCOUNT_TYPE_PERCENTAGE){
                        discountContentIcon = '%'
                     }else if(productVo.discountType == DISCOUNT_TYPE_AMOUNT){
                        discountContentIcon = '&#x20B9;'
                     }

                     if(parseFloat(productVo.discount) == 0.0){
                        discountContent = ''
                     }else if(parseFloat(productVo.discount) != 0.0){
                        //discountContent = '<div class="member-plan position-absolute-discount"><span class="badge m-1 badge-success">'+productVo.discount + discountContentIcon+'</span></div>';
                        if(productVo.discountType == DISCOUNT_TYPE_PERCENTAGE){
                           discountContent = '<div class=""><span class="badge m-1 badge-success">'+productVo.discount + discountContentIcon+' Savings</span></div>';
                        }else if(productVo.discountType == DISCOUNT_TYPE_AMOUNT){
                           discountContent = '<div class=""><span class="badge m-1 badge-success">'+discountContentIcon+productVo.discount +' Savings</span></div>';
                        }
                     }
                

               $("#productName").html(productVo.productName);
               $("#productDescription").html((productVo.productDescription  == "") ? productVo.productName : productVo.productDescription);
               $("#productPrice").html(pcontent);
               $("#productPriceDiscount").html(discountContent);


 
             });
             $(".recommend-slider").append(content);


             $('.recommend-slider').slick({
               centerMode: true,
               infinite: true,
               speed: 300,
               slidesToShow: 1,
               adaptiveHeight: true,
               arrows: false,
               autoplay: true
            });

            $(".preloader-div").remove();
          } else {
            $(".preloader-div").remove();
          }
 
       }

         $("#addToCartBtn").click(function (e) {
            e.preventDefault();
            Swal.fire({
               icon: 'warning',
               title: 'Oops...',
               text: 'Currently this Service Is Not available...!!!',
            }).then((result) => {
               if (result.isConfirmed) {
                  // $("#mobileNo").focus();
               }
            })

         });

         let getCartList = () =>{

            $.ajax({
                  url: "/cart/getlist",
                  type:"GET",
                  success: function(data,status) {
                  if(data.status){
                     //console.log(data.response);
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

         let goBackFromProductDetailPage = () => {
            window.location.href="/listing?categoryId="+categoryId;
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