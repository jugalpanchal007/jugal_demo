/*
Template Name: Grofar - Online Grocery Supermarket HTML Mobile Template
Author: Askbootstrap
Author URI: https://themeforest.net/user/askbootstrap
Version: 1.0
*/

(function($) {
"use strict"; // Start of use strict

// Tooltip
$('[data-toggle="tooltip"]').tooltip();

// Osahan Slider
$('.osahan-slider').slick({
  centerMode: false,
  slidesToShow: 1,
  arrows: false,
  dots: true
});

// $('.categories-slider').slick({
//   slidesToScroll: 3,
//   slidesToShow: 8,
//   arrows: false,
//   responsive: [
//     {
//       breakpoint: 768,
//       settings: {
//         arrows: false,
//         centerMode: true,
//         centerPadding: '40px',
//         slidesToShow: 3
//       }
//     },
//     {
//       breakpoint: 480,
//       settings: {
//         arrows: false,
//         centerMode: true,
//         centerPadding: '40px',
//         slidesToShow: 3
//       }
//     }
//   ]
// });

// Promo Slider
// $('.promo-slider').slick({
//   centerMode: true,
//   infinite: true,
//   speed: 300,
//   slidesToShow: 1,
//   arrows: false,
//   adaptiveHeight: true
// });

// Recommend Slider
// $('.recommend-slider').slick({
//   centerMode: true,
//   infinite: true,
//   speed: 300,
//   slidesToShow: 1,
//   adaptiveHeight: true,
//   arrows: false,
//   autoplay: true
// });

// Trending Slider
$('.trending-slider').slick({
  centerPadding: '30px',
  slidesToShow: 2,
  arrows: false,
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

// Sidebar
var $main_nav = $('#main-nav');
  var $toggle = $('.toggle');

  var defaultOptions = {
      disableAt: false,
      customToggle: $toggle,
      levelSpacing: 40,
      navTitle: 'RR-MART',
      levelTitles: true,
      levelTitleAsBack: true,
      pushContent: '#container',
      insertClose: 2
  };

// call our plugin
var Nav = $main_nav.hcOffcanvasNav(defaultOptions);  

// Dark Mode
const toggleSwitch = document.querySelector('.theme-switch input[type="checkbox"]');
const currentTheme = localStorage.getItem('theme');
if (currentTheme) {
    document.documentElement.setAttribute('class', currentTheme);
  
    if (currentTheme === 'dark') {
        toggleSwitch.checked = true;
    }
}
function switchTheme(e) {
    if (e.target.checked) {
        document.documentElement.setAttribute('class', 'dark');
        localStorage.setItem('theme', 'dark');
    }
    else {        document.documentElement.setAttribute('class', 'light');
          localStorage.setItem('theme', 'light');
    }    
}
toggleSwitch.addEventListener('change', switchTheme, false);

})(jQuery); // End of use strict

function setSubTotal(){
  var subTotal= 0;
  var $salesItem = $("#cartbody").find("[data-sales-item]").not(".m--hide");
  //console.log($salesItem)
  $salesItem.each(function () {
     var id = $(this).attr("data-sales-item");
     var item = $('#item'+id).val();
     var quantity = 0;
     if($('#quantity'+id).val() != ""){
        quantity = parseFloat($('#quantity'+id).val());
     }
     var price = 0;
     if($('#price'+id).val() != ""){
        price = parseFloat($('#price'+id).val());
     }
     
     subTotal+=(price*quantity);
  });

  if (parseFloat(subTotal) < 500) {
   
    $( "#cartCheckOutBtn" ).prop( "disabled", true );
  } else {
    
    $( "#cartCheckOutBtn" ).prop( "disabled", false );
  }

  $('#subtotalspan').html(subTotal);
  $('#subtotal').val(subTotal);
}

// Quantity JS
let addToCartFnc = (e,id,price,quantity,availableQty,stockId) =>{
  $("#"+e.id).hide();
  $("#quantity"+id).val()
  console.log("addToCartFnc");
  plusQuantity(id,price,quantity,availableQty,stockId);
}

let plusQuantity= (productVarientId,price,quantity,availableQty,stockId) => {

  let qty = parseFloat($("#quantity"+productVarientId).val());
  let currentqty = qty + 1;

  if (currentqty  > availableQty) {
    toastr.error("Available quantity is " + availableQty);
  } else {
    
    $("#quantity"+productVarientId).val(parseInt(qty + 1));
    
    $("#qtyplus" +productVarientId ).attr("disabled", true);
      console.log("plusQuantity");
      let data =  {
        productVarientId : productVarientId,
        price: price,
        quantity : quantity,
        stockId : stockId
      }
      $.ajax({
        type: "post",
        url: "/cart/addtocart/add",
        data: data,
        success: function (res) {
          if (res.status) {
            toastr.success(res.message);
            console.log(res.response);
            
            if (res.response != null) {
              $(".cartCount").html(res.response.length);  
              
            }else{
              $(".cartCount").html("0");
            }
            $("#qtyplus" +productVarientId ).attr("disabled", false);
          } else {
            console.log(res.message);
            if (res.message == "Please Login Again") {
              Swal.fire({
                  icon: 'error',
                  title: 'Oops...',
                  text: "Please Login First...!!!",
              }).then((result) => {
                  if (result.isConfirmed) {
                    window.location.href="/signin"
                  }
              })
            } else {
              toastr.error(res.message);
            }
            $(".cartCount").html("0");
            $("#qtyplus" +productVarientId ).attr("disabled",false);
          }
        }
      });
  }

  setSubTotal();
}

let minusQuantity= (productVarientId,price,quantity,availableQty,stockId) => {
  console.log(availableQty);
  let qty = parseFloat($("#quantity"+productVarientId).val());
  $("#qtyminus" +productVarientId ).attr("disabled", true);
  if (qty == 1) {
     $("#collapseExample"+productVarientId).removeClass("show");
     $("#addToCartBtn"+productVarientId).show();
     $("#quantity"+productVarientId).val(parseInt(qty - 1));
     $("#cartproduct"+productVarientId).remove();
  } else {
     $("#quantity"+productVarientId).val(parseInt(qty - 1));
  }

  let data =  {
    productVarientId : productVarientId,
    price: price,
    quantity : quantity,
    stockId : stockId
  }
  $.ajax({
    type: "post",
    url: "/cart/addtocart/minus",
    data: data,
    success: function (res) {
      if (res.status) {
        //console.log(res.response);

        toastr.success(res.message);
        if (res.response != null) {
          $(".cartCount").html(res.response.length);  
        }else{
          $(".cartCount").html("0");
        }

        $("#qtyminus" +productVarientId ).attr("disabled", false);
        
      } else {
        //console.log(res.message);
        //toastr.error(res.message);
        if (res.message == "Please Login Again") {
          Swal.fire({
              icon: 'error',
              title: 'Oops...',
              text: "Please Login First...!!!",
          }).then((result) => {
              if (result.isConfirmed) {
                window.location.href="/signin"
              }
          })
        } else {
          toastr.error(res.message);
        }
        
        $(".cartCount").html("0");

        $("#qtyminus" +productVarientId ).attr("disabled", false);
      }
    }
  });
  setSubTotal();
}