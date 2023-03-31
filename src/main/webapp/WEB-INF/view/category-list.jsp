<!DOCTYPE html>
<html lang="en">

<head>

 <title>RRMart - Category List</title>
   <%@include file="./menu/head.jsp"%>
   <style>
      .hidden {
      display: none;
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
  
   <div class="osahan-listing ">
      <div class="p-3 container">
         <div class="d-flex align-items-center">
            <a class="font-weight-bold text-danger text-decoration-none" href="/home"><i
                  class="icofont-rounded-left back-page"></i></a><span
               class="font-weight-bold ml-3 h6 mb-0" id="categoryName">All Categories</span>
            <a class="toggle ml-auto" href="#"><i class="icofont-navigation-menu"></i></a>
         </div>
         <div class="input-group mt-3 rounded shadow-sm overflow-hidden bg-white" id="searchBarcodediv">
            <div class="input-group-prepend">
               <button class="border-0 btn btn-outline-secondary text-danger bg-white"><i class="icofont-search"></i></button>
            </div>
            <input type="text" autofocus="" onchange="getproduct()" 
              class="shadow-none border-0 form-control pl-0" 
              placeholder="Enter Category Name" id="searchBarcode"   
              name="searchBarcode" tabindex="1" autocomplete="off" spellcheck="false" dir="auto" data-search>
         </div> 
      </div>
       <%@include file="./subheader.jsp"%>
      <div class="osahan-listing px-3 bg-white  container" >
      
        
         <div class="row border-bottom border-top mt-2 items" id="categoryListDiv">
            
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
   <!-- <%@include file="./menu/header-script.jsp"%>  -->

   <script>

      var url_string = window.location.href
      var url = new URL(url_string);
      var categoryId = url.searchParams.get("categoryId");
      console.log(url);
      console.log(categoryId);
      let CATEGORYLIST = [];
      let CATEGORY_IMAGE_URL = ""
      const DISCOUNT_TYPE_PERCENTAGE = "percentage";
      const DISCOUNT_TYPE_AMOUNT = "amount";
      $(function () {
        
         getcategoryAndProductList();


      });

      // Search START

      $('[data-search]').on('keyup', function() {
         var searchVal = $(this).val();
         var filterItems = $('[data-filter-item]');

         if ( searchVal != '' ) {
            filterItems.addClass('hidden');
            $('[data-filter-item][data-filter-name*="' + searchVal.toLowerCase() + '"]').removeClass('hidden');
         } else {
            filterItems.removeClass('hidden');
         }
      });
      // Search END 



      let getcategoryAndProductList = () =>{
         $.ajax({
            type: "get",
            url: "/categories/list",
            success: function (data) {
               
               if (data.status) {
                  
                  CATEGORYLIST = data.response.categoryList
                  CATEGORY_IMAGE_URL = "https://s3-us-west-2.amazonaws.com/vasyerpsolutions/RRmart/product-image-pv/43/category"
                  //console.log(data);

                  setCategoryData(CATEGORYLIST,CATEGORY_IMAGE_URL);
               } else {
                  $(".preloader-div").remove();
               }
            }
         });
      }


      let setCategoryData = (categoryList, categoryImageUrl) => {
         $("#categoryListDiv").empty();
         let content = "";
         if (categoryList != null) {

            let sortedList = categoryList.sort(alphabeticallySort(true));
            $.each(sortedList, function (index, categoryVo) {
                let categoryImage = '/app/img/logo.png';

                if(categoryVo.categoryLogo != null && categoryVo.categoryLogo != ""){
                    categoryImage = categoryImageUrl+'/'+categoryVo.categoryLogo
                }
               //console.log(categoryVo);

               let discountContent = '<div class="member-plan position-absolute"><span class="badge m-3 badge-danger">10%</span></div>';
               discountContentIcon = '%';
               if(categoryVo.discount.discount_type == DISCOUNT_TYPE_PERCENTAGE){
                  discountContentIcon = '%'
               }else if(categoryVo.discount.discount_type == DISCOUNT_TYPE_AMOUNT){
                  discountContentIcon = '&#x20B9;'
               }

               if (categoryVo.discount) {
                  if(parseFloat(categoryVo.discount.discount) == 0.0){
                     discountContent = ''
                  }else if(parseFloat(categoryVo.discount.discount) != 0.0){
                     if(categoryVo.discount.discount_type == DISCOUNT_TYPE_PERCENTAGE){
                        discountContent = '<div class="member-plan position-absolute"><span class="badge m-3 badge-danger">'+categoryVo.discount.discount+discountContentIcon+' off</span></div>';
                     }else if(categoryVo.discount.discount_type == DISCOUNT_TYPE_AMOUNT){
                        discountContent = '<div class="member-plan position-absolute"><span class="badge m-3 badge-danger">'+discountContentIcon+categoryVo.discount.discount+' off</span></div>';
                     }

                  }
               } else {
                  discountContent = ''
               }

               console.log(discountContent);

                console.log(categoryImage);

                let CatfilterName = (categoryVo.categoryName).toLowerCase();

               content += ' <div class="col-lg-2 col-md-3 col-sm-4 col-4 p-0" style="border: 1px solid #dee2e6!important;" data-filter-item data-filter-name="'+CatfilterName+'">'+
                              '<div class="list-card-image" >'+
                                 '<a href="/listing?categoryId='+categoryVo.categoryId+'" class="text-dark">'+
                                 //discountContent+
                                    '<div class="p-1 text-center">'+
                                       `<img src="`+categoryImage+`" onError="this.onerror=null;this.src='/app/img/logo.png';" class="img-fluid item-img mb-3 p-3" style=" width : 100px; height :90px;">`+
                                       '<h6 style="text-transform : uppercase;">'+categoryVo.categoryName+'</h6>'+
                                       '<div class="d-flex align-items-center">'+
                                        //   '<h6 class="price m-0 text-danger"> '+categoryVo.sellingPrice+'/'+categoryVo.measurementCode+'</h6>'+
                                        //   '<a href="javascript:void(0);" class="btn btn-danger btn-sm ml-auto">+</a>'+
                                       '</div>'+
                                    '</div>'+
                                 '</a>'+
                              '</div>'+
                           '</div>';

            });
            $('#categoryListDiv').append(content);
            
            $(".preloader-div").remove();
         } else {
            $(".preloader-div").remove();
         }

      }

      let alphabeticallySort = (ascending) => {

            return function (a, b) {

                // equal items sort equally
                if (a === b) {
                    return 0;
                }
                // nulls sort after anything else
                else if (a === null) {
                    return 1;
                }
                else if (b === null) {
                    return -1;
                }
                // otherwise, if we're ascending, lowest sorts first
                else if (ascending) {
                    return a < b ? -1 : 1;
                }
                // if descending, highest sorts first
                else { 
                    return a < b ? 1 : -1;
                }

            };

        }
   </script>

</body>

</html>