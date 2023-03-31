<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
   <head>
     
       <title>RRMart - Cart</title>
       <%@include file="./menu/head.jsp"%>
      
      <link href="/app/vendor/sidebar/demo.css" rel="stylesheet">
   </head>
   <body class="fixed-bottom-padding">
      <div class="preloader-div">
         <div class="preloaderBg" id="preloader" onload="preloader()">
            <div class="preloader">
               <div class="preloader2"></div>
            </div>
         </div>
      </div>
      
      <div class="osahan-cart">
      <div class="p-3 border-bottom">
         <div class="d-flex align-items-center">
            <h5 class="font-weight-bold m-0">Cart</h5>
            <a class="toggle ml-auto" href="javascript:void(0);"><i class="icofont-navigation-menu"></i></a>
         </div>
      </div>
      <div class="card">
         <div class="card-body p-1 mb-1">
            <p class="text-danger text-center"><b> Note : Cart value will be grater than or equal to <span id="minorderamount"></span> Rs</b></p>
         </div>
      </div>
      <div class="osahan-body" id="cartbody">

         
      
      </div>
      <!-- Footer -->

      <form action="/myaddress" method="POST" id="addressForm">
         <input type="hidden" id="subtotal" name="subTotal" value="0">
         <a href="javascript:void(0)" onclick="checkout()" id="cartCheckOutBtn">
            <div class="p-3">
               <div class="rounded shadow bg-danger d-flex align-items-center p-3 text-white">
                  <div class="more">
                  <h6 class="m-0">Subtotal &#x20B9; <span id="subtotalspan">0</span></h6>
                  <p class="small m-0">Proceed to checkout</p>
                  </div>
                  <div class="ml-auto"><i class="icofont-simple-right"></i></div>
               </div>
            </div>
         </a>
      </form>

     
   <%@include file="./menu/footer.jsp"%>
   

   <%@include file="./menu/sidenav.jsp"%>
      <%@include file="./footerjs.jsp"%>
      
      <script>

      let CATEGORYLIST = [];
      let PRODUCTLIST = [];
      let CARTLIST = [];
      let CATEGORY_IMAGE_URL = "";
      let PRODUCT_IMAGE_URL = "";
      let MINIMUM_ONLINE_ORDER_AMOUNT = "";

         $(function () {
            toastr.options = {
               "preventDuplicates": true,
               "preventOpenDuplicates": true
            };
            getcategoryAndProductList();
            
         
            // $(".osahan-body").click(function (e) { 
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

            getMinimumOnlineOrderAmount();

            
         });

         let checkout = () =>{

            
            if ($("#subtotal").val() == 0) {
               toastr.error("","Cart Is Empty...!!!");
            } else {
               let stotal = parseFloat($("#subtotal").val());
               let minimumorderamount = parseFloat(MINIMUM_ONLINE_ORDER_AMOUNT);
               if (stotal >= minimumorderamount) {
                  $("#addressForm").submit();
               } else {
                  toastr.error("Cart Value Must Be Grater than "+parseFloat(MINIMUM_ONLINE_ORDER_AMOUNT)+"...!!!","");
               }
               
            }
            
         }


         let getcategoryAndProductList = () =>{

            let contactId = '${sessionScope.contactId}'
            let branchId = '${sessionScope.branchId}'
               $.ajax({
                  type: "get",
                  url: "/productandcategory/list",
                  data: {contactId : contactId , branchId : branchId},
                  success: function (data) {
                     
                     if (data.status) {
                        
                        CATEGORYLIST = data.response.categoryList;
                        PRODUCTLIST = data.response.productList
                        CATEGORY_IMAGE_URL = data.response.categoryImageUrl
                        PRODUCT_IMAGE_URL = data.response.productImageUrl


                        getCartList();
                     } else {
                        
                     }
                  }
               });
            }


         let getCartList = () =>{
            $.ajax({
                  url: "/cart/getlist",
                  type:"GET",
                  success: function(data,status) {
                  if(data.status){

                     CARTLIST = data.response;

                     setCartData(CARTLIST);
                     
                  }else{
                     toastr.error('',data.message);
                     $(".preloader-div").remove();
                    
                  }
                  },
                  error: function(XMLHttpRequest, textStatus, errorThrown) { 
                     $(".preloader-div").remove();
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


         function setCartData(data) { 
            let content = "";
            if (data.length > 0) {
               $.each(data, function (indexInArray, value) { 
                  let cartQty = value.qty;
                  // var productVos = PRODUCTLIST.filter(item=> item.productVarientId == value.productVarientId);

                  let contactId = '${sessionScope.contactId}'
                  let branchId = '${sessionScope.branchId}'

                  console.log(data);
                     getProductByProductVarientId(value.productVarientId,branchId,contactId).then((data) => {

                        
                        if( data.response!=null ){
                              var product =  data.response.product;
                              
                              let pcontent = '<h6 class="price m-0 text-danger"> ₹ '+product.sellingPrice+'/'+product.measurementCode+'</h6>\n';
                              if (product.sellingPrice == product.mrp) {
                                 pcontent = '<h6 class="price m-0 text-danger">₹ '+product.sellingPrice+'/'+product.measurementCode+'</h6>\n';
                              } else {
                                 pcontent = '<h6 class="price m-0 text-danger"><small><s>₹ '+product.mrp+'/'+product.measurementCode+'</s></small> ₹ '+product.sellingPrice+'/'+product.measurementCode+'</h6>\n';
                              }
                              


                              let content_new = '<div class="cart-items bg-white position-relative border-bottom" id="cartproduct'+product.productVarientId+'" data-sales-item="'+product.productVarientId+'">'+
                                          '<a href="javascript:void(0);" class="position-absolute">'+
                                          '</a>'+
                                       ' <div class="d-flex  align-items-center p-3">'+
                                             `<a href="javascript:void(0);"><img src="`+product.imagepath+`" onError="this.onerror=null;this.src='/app/img/logo.png';" class="img-fluid"></a>`+
                                          '<a href="javascript:void(0);" class="ml-3 text-dark text-decoration-none w-100">'+
                                                '<h6 class="mb-1"> '+product.productName+'</h6>'+
                                                pcontent+
                                                '<div class="d-flex align-items-center justify-content-between">'+
                                                ' <p class="total_price font-weight-bold m-0">&#x20B9; '+product.sellingPrice+'</p>'+
                                                   '<div class="">'+
                                                         `<div class="collapse qty_show mt-2 show ml-auto" id="collapseExample`+product.productVarientId+`">`+
                                                         `<div>`+
                                                            `<span class="ml-auto" href="javascript:void(0);">`+
                                                               `<form id='myform'`+
                                                                     `class="cart-items-number d-flex justify-content-between w-100">`+
                                                                     `<input type="button" value="-" class='qtyminus btn btn-success btn-sm' id="qtyminus`+product.productVarientId+`" field='quantity' onclick='minusQuantity(`+product.productVarientId+`,`+product.sellingPrice+`,`+cartQty+`,`+product.availableStockQuantity+`,`+product.stockId+`)' />`+
                                                                     `<input type='text' name='quantity`+product.productVarientId+`' readonly id='quantity`+product.productVarientId+`' value='`+cartQty+`' class='qty form-control' />`+
                                                                     `<input type='hidden' id='item`+product.productVarientId+`' value='`+product.productVarientId+`' />`+
                                                                     `<input type='hidden' id='price`+product.productVarientId+`'  value='`+product.sellingPrice+`' />`+
                                                                  `<input type="button"  value="+" class='qtyplus btn btn-success btn-sm' id="qtyplus`+product.productVarientId+`" field='quantity' onclick='plusQuantity(`+product.productVarientId+`,`+product.sellingPrice+`,`+cartQty+`,`+product.availableStockQuantity+`,`+product.stockId+`)' />`+
                                                               `</form>`+
                                                            `</span>`+
                                                         `</div>`+
                                                   `</div>`+
                                                   '</div>'+
                                                '</div>'+
                                             '</a>'+
                                          '</div>'+
                                       '</div>';

                                    
                                       $('#cartbody').append(content_new);
                                       setSubTotal();
                                       
                     }
                   
                        
                  }).catch((error) => {
                     console.log(error)
                  })

                 
                  

               });
            }else{
               content +="-";
               $('#cartbody').append(content);
               setSubTotal();
            }


            $(".preloader-div").remove();

          }


          let getProductByProductVarientId = (productVarientId,branchId,contactId) => {
            
				return new Promise((resolve, reject) => {
					$.ajax({
						url: "/get/product/"+productVarientId+"/json",
						type: 'POST',
                  data : {branchId : branchId , contactId : contactId},
						success: function (data) {
							resolve(data)
						},
						error: function (error) {
							reject(error)
						},
					})
				})
			}


         let getMinimumOnlineOrderAmount = () =>{
            $.ajax({
                  url: "/minimumorderamount",
                  type:"GET",
                  success: function(data,status) {
                     if(data.status){
                        MINIMUM_ONLINE_ORDER_AMOUNT = data.response;
                     }else{
                        MINIMUM_ONLINE_ORDER_AMOUNT = "0";
                        toastr.error('',data.message);
                        $(".preloader-div").remove();
                     
                     }


                     $("#minorderamount").html(MINIMUM_ONLINE_ORDER_AMOUNT);
                  },
                  error: function(XMLHttpRequest, textStatus, errorThrown) { 
                     $(".preloader-div").remove();
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

     
      </script> 

   </body>
</html>