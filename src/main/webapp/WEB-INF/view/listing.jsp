<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
   <title>RRMart - Category List</title>

   <%@include file="./menu/head.jsp"%>
   <style>
      .member-plan.position-absolute-discount {
         width: 100%;
         text-align: start;
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
   
   <div class="osahan-listing">
      <div class="p-3 container" >
         <div class="d-flex align-items-center">
            <a class="font-weight-bold text-danger text-decoration-none" href="/home"><i
                  class="icofont-rounded-left back-page"></i></a><span
               class="font-weight-bold ml-3 h6 mb-0" id="categoryName"></span>
            <a class="toggle ml-auto" href="#"><i class="icofont-navigation-menu"></i></a>
         </div>
         <%@include file="./searchbar.jsp"%>
      </div>
      <%@include file="./subheader.jsp"%>
       
      <div class="osahan-listing px-3 bg-white container" >
         <div class="row border-bottom border-top" id="productListDiv">
            
         </div>
         
      </div>
   </div>
   <!-- filter and sort START -->
   <!-- <div class="row m-0 text-center border-bottom border-top fixed-bottom bg-white">
         <div class="col-6 p-0 border-right">
            <a href="#" data-toggle="modal" data-target="#exampleModal" class="btn text-muted"><i class="icofont-filter mr-2"></i> Filter</a>
         </div>
         <div class="col-6 p-0">
            <a href="#" data-toggle="modal" data-target="#exampleModal" class="btn text-muted"><i class="icofont-signal mr-2"></i> Sort</a>
         </div>
      </div> -->

   <!-- filter and sort ENDS -->

   <!-- Navmenu START -->
   <%@include file="./menu/footer.jsp"%>
   <%@include file="./signup-bonus-modal.jsp"%>

   <%@include file="./menu/sidenav.jsp"%>
   <!-- Navmenu END -->

   <%@include file="./footerjs.jsp"%>
   <%@include file="./menu/header-script.jsp"%> 

   <script>

      var url_string = window.location.href
      var url = new URL(url_string);
      var categoryId = url.searchParams.get("categoryId");
      console.log(url);
      console.log(categoryId);
       const DISCOUNT_TYPE_PERCENTAGE = "percentage";
      const DISCOUNT_TYPE_AMOUNT = "amount";
      let PRODUCTLIST = [];
      $(function () {

         getProductListByCategory(categoryId);
      
      });



      let getProductListByCategory = (categoryId) => {
         let productImageUrl = ""
         let contactId = '${sessionScope.conatctId}'
          let branchId = '${sessionScope.branchId}'
         $.ajax({
            type: "get",
            url: "/product/listbycategory",
            data: {
               categoryId: categoryId,
               contactId : contactId,
               branchId : branchId
            },
            success: function (data) {

               if (data.status) {

                  PRODUCTLIST = data.response.productList
                  
                  
                  if(data.response.productList){
                	  $("#categoryName").html(data.response.productList[0].categoryName);
                      productImageUrl = data.response.productImageUrl
                      console.log(data);
                      setProductListData(PRODUCTLIST, productImageUrl);
                  }else{
                	  
                	  let content = '<a class="col w-100" href="javascript:void(0)">' +
                      '<div class="p-3">' +
                      '<div class="rounded shadow bg-danger d-flex align-items-center p-3 text-white">' +
                      '<div class="more">' +
                      '<h6 class="m-0">No Products Found...!!!</h6>' +
                      '</div>' +
                      '</div>' +
                      '</div>' +
                      '</a>';
	                  $('#productListDiv').html(content);
	                  //$(".preloader-div").remove();
                	  toastr.error("No Products Found...!!!");
                	  //$("#categoryName").html("No Products Found...!!!");
                	  $(".preloader-div").remove();
                  }
                  

               } else {
                  $(".preloader-div").remove();
               }
            }
         });
      }


      let setProductListData = (productList, productImageUrl) => {
         $("#productListDiv").empty();
         let content = "";
         if (productList != null) {
            $.each(productList, function (index, productVo) {
               //console.log(productVo);


               let actualImagePath = productVo.imagepath;

               if (actualImagePath) {
                  
               } else {
                  actualImagePath = productImageUrl
               }

               let newImagePath = actualImagePath.replace("https://s3-us-west-2.amazonaws.com/vasyerpsolutions/RRmart/product-image-pv","https://ik.imagekit.io/vhveqppefvx/tr:w-100,h-100/");

               let pcontent = '<h6 class="price m-0 text-danger"> ₹ '+productVo.sellingPrice+'/'+productVo.measurementCode+'</h6>\n';
               if (productVo.sellingPrice == productVo.mrp) {
                  pcontent = '<h6 class="price m-0 text-danger">₹ '+productVo.sellingPrice+'/'+productVo.measurementCode+'</h6>\n';
               } else {
                  pcontent = '<h6 class="price m-0 text-danger"><small><s>₹ '+productVo.mrp+'/'+productVo.measurementCode+'</s></small> ₹ '+productVo.sellingPrice+'/'+productVo.measurementCode+'</h6>\n';
               }


               let discountContent = '<div class="member-plan position-absolute-discount"><span class="badge m-1 badge-success">5%</span></div>';
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
                     discountContent = '<div class="member-plan position-absolute-discount"><span class="badge m-1 badge-success">'+productVo.discount + discountContentIcon+' Savings</span></div>';
                  }else if(productVo.discountType == DISCOUNT_TYPE_AMOUNT){
                     discountContent = '<div class="member-plan position-absolute-discount"><span class="badge m-1 badge-success">'+discountContentIcon+productVo.discount +' Savings</span></div>';
                  }
               }

               content += ' <div class="col-lg-2 col-md-3 col-sm-6 col-6 p-0" style="border: 1px solid #dee2e6!important;">'+
                              '<div class="list-card-image" >'+
                                 '<a href="/product/details?productId='+productVo.productVarientId+'&categoryId='+productVo.categoryId+'" class="text-dark">'+
                                 discountContent+
                                    //'<div class="member-plan position-absolute"><span class="badge m-3 badge-danger">10%</span></div>'+
                                    '<div class="p-3">'+
                                       `<img src="`+newImagePath+`" class="img-fluid item-img w-100 mb-3 p-3" onError="this.onerror=null;this.src='/app/img/logo.png';">`+
                                       '<h6 class="cut-text">'+productVo.productName+'</h6>'+
                                       '<div class="d-flex align-items-center">'+
                                          pcontent+
                                          //'<a href="javascript:void(0);" class="btn btn-danger btn-sm ml-auto">+</a>'+
                                       '</div>'+
                                    '</div>'+
                                 '</a>'+
                              '</div>'+
                           '</div>';

            });
            $('#productListDiv').append(content);

            $(".preloader-div").remove();
         } else {
            $(".preloader-div").remove();
         }

      }
   </script>
</body>

</html>