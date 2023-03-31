<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>

    <title>RRMart - Wishlist</title>
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
                <h5 class="font-weight-bold m-0">Wishlist</h5>
                <a class="toggle ml-auto" href="#"><i class="icofont-navigation-menu"></i></a>
            </div>
        </div>
        <div class="osahan-body" id="cartbody">
            


        </div>
        <!-- Footer -->




        <%@include file="./menu/footer.jsp"%>


        <%@include file="./menu/sidenav.jsp"%>
        <%@include file="./footerjs.jsp"%>

        <script>
            let WISHLIST = [];
            let PRODUCTLIST = [];
            let CARTLIST = [];
            let CATEGORY_IMAGE_URL = "";
            let PRODUCT_IMAGE_URL = "";

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


            });


            let getcategoryAndProductList = () => {

                let contactId = '${sessionScope.contactId}'
                $.ajax({
                    type: "get",
                    url: "/user/wishlist/list",
                    data: {
                        contactId: contactId
                    },
                    success: function (data) {

                        if (data.status) {

                            WISHLIST = data.response.productList
                            PRODUCT_IMAGE_URL = data.response.productImageUrl
                            console.log(WISHLIST);
                            if (WISHLIST != null) {
                                setWishlistData(WISHLIST);
                            } else {
                                content = '<a href="javascript:void(0)">' +
                                    '<div class="p-3">' +
                                    '<div class="rounded shadow bg-danger d-flex align-items-center p-3 text-white">' +
                                    '<div class="more">' +
                                    '<h6 class="m-0">No Products Found...!!!</h6>' +
                                    '</div>' +
                                    '</div>' +
                                    '</div>' +
                                    '</a>';
                                $('.osahan-body').append(content);
                                $(".preloader-div").remove();
                            }
                            
                        } else {
                            content = '<a href="javascript:void(0)">' +
                                '<div class="p-3">' +
                                '<div class="rounded shadow bg-danger d-flex align-items-center p-3 text-white">' +
                                '<div class="more">' +
                                '<h6 class="m-0">No Products Found...!!!</h6>' +
                                '</div>' +
                                '</div>' +
                                '</div>' +
                                '</a>';
                            $('.osahan-body').append(content);
                            $(".preloader-div").remove();
                        }
                    }
                });
            }


            function setWishlistData(data) {
                let content = "";
                if (data.length > 0) {
                    $.each(data, function (indexInArray, wishlistVo) {


                        content +=
                            '<div class="cart-items bg-white position-relative border-bottom" id="wishlistProduct' +
                            wishlistVo.product_varient_id + '" data-sales-item="' + wishlistVo
                            .product_varient_id + '">' +
                            '<a href="#" class="position-absolute">' +
                            '</a>' +
                            ' <div class="d-flex  align-items-center p-3">' +
                            '<a href="/product/details?productId='+wishlistVo.product_varient_id+'&categoryId='+wishlistVo.category_id+'"><img src="' + PRODUCT_IMAGE_URL + wishlistVo.src +
                            `" class="img-fluid" onError="this.onerror=null;this.src='/app/img/logo.png';"></a>` +
                            '<a href="#" class="ml-3 text-dark text-decoration-none w-100">' +
                            '<h6 class="mb-1"> ' + wishlistVo.name + '</h6>' +
                            '<div class="row mt-2">'+
                            '    <div class="col-12 text-right">'+
                            '     <button type="button" class="rounded btn btn-sm btn-warning mr-2" style="font-weight:600;" onclick="plusQuantity('+wishlistVo.product_varient_id+','+wishlistVo.sellingprice+',1)">ADD TO CART</button>'+
                            '     <button type="button" class="rounded btn btn-sm btn-danger" onclick="deleteFromWishList('+wishlistVo.wishlist_id+','+wishlistVo.product_varient_id+')"><i class="icofont-trash"></i></button>'+
                            '    </div>'+
                            '</div>'+

                            '</a>' +
                            '</div>' +
                            '</div>';



                    });
                } else {
                    content = '<a href="javascript:void(0)">' +
                        '<div class="p-3">' +
                        '<div class="rounded shadow bg-danger d-flex align-items-center p-3 text-white">' +
                        '<div class="more">' +
                        '<h6 class="m-0">No Products Found...!!!</h6>' +
                        '</div>' +
                        '</div>' +
                        '</div>' +
                        '</a>';
                }

                $('.osahan-body').append(content);
                $(".preloader-div").remove();

            }


            let deleteFromWishList = (wishlistId,productVarientId) =>{

                if (wishlistId) {
                    $.ajax({
                        url: "/user/wishlist/delete",
                        type:"POST",
                        data: {wishlistId : wishlistId},
                        success: function(data,status) {
                            if(data.status){
                                console.log(data);
                                $("#wishlistProduct"+productVarientId).remove();
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
                } else {
                    console.log("No wihslist Found");
                }
            }
        </script>

</body>

</html>