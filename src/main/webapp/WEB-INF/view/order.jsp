<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
   <head>

      <title>RRMart - My Orders</title>
      <%@include file="./menu/head.jsp"%>
      <style>
         .m--hide{
            display: none !important;
         }
         td,th {
            vertical-align: middle !important; 
         }
         .dark td,.dark th {
            color: #fff;
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
      
      <div class="osahan-order " id="orderMainListDiv">
         <div class="order-menu">
            <h5 class="font-weight-bold p-3 d-flex align-items-center">My Order <a class="toggle ml-auto" href="#"><i class="icofont-navigation-menu"></i></a></h5>
            <!-- <div class="row m-0 text-center">
               <div class="col pb-2 border-success border-bottom">
                  <a href="complete_order.html" class="text-success font-weight-bold text-decoration-none">Completed</a>
               </div>
               <div class="col pb-2 border-bottom">
                  <a href="progress_order.html" class="text-muted text-decoration-none">On Progress</a>
               </div>
               <div class="col pb-2 border-bottom">
                  <a href="canceled_order.html" class="text-muted text-decoration-none">Canceled</a>
               </div>
            </div> -->
         </div>
         <div class="order-body ">
            <div class="p-3" id="noOrdersDiv" style="display: none;">
               <a href="javascript:void(0);" class="text-decoration-none">
                  <div class="rounded shadow bg-danger d-flex align-items-center p-3 text-white">
                     <div class="more">
                        <h6 class="m-0">No Data Avilable</h6><br>
                        <p class="small m-0">Currently cart is not available.</p>
                     </div>
                     <!-- <div class="ml-auto"><i class="icofont-simple-right"></i></div> -->
                  </div>
               </a>
            </div>
            <div class="container" id="orderListDiv">
              
            </div>
            
         </div>
      </div>

      <div class="osahan-status m--hide" id="orderMainDetailsDiv">
         <div class="p-3 border-bottom">
            <div class="d-flex align-items-center">
               <a class="font-weight-bold text-danger text-decoration-none" href="javascript:void(0)" onclick="showOrderListDiv()">
               <i class="icofont-rounded-left back-page"></i></a>
               <input type="hidden" id="salesId" value="0">
               <span class="font-weight-bold ml-3 h6 mb-0" ># <span id="salesNo"></span></span>
               <a class="toggle ml-auto" href="#"><i class="icofont-navigation-menu"></i></a>
            </div>
         </div>
         <!-- status complete -->
         <div class="p-3 status-order bg-white border-bottom d-flex align-items-center">
            <p class="m-0"><i class="icofont-ui-calendar"></i> <span id="salesDate"></span></p>
            <div class="ml-auto" id="cancelOrderBtnDiv">
               
            </div>
         </div>
         <div class="p-3 border-bottom">
            <h6 class="font-weight-bold ">Order Status : 
               <span class=" text-white py-1 px-2 mb-0 rounded small ml-2" id="deliveryStatus" style="text-transform : uppercase;"></span>
            </h6>
            <hr>
            <h6 class="font-weight-bold ">Branch Name : 
               <span class=" text-muted py-1 px-2 mb-0 rounded small ml-2" id="branchName" style="text-transform : uppercase;"></span>
            </h6>
            <hr>
            <div class="row mt-2">
               <div class="col-6">
                  <p class="font-weight-bold  mb-0 text-left">Payment Status <br>
                     <span class=" py-1 mb-0 rounded small mt-1 text-left" id="paymentStatusDetail" style="text-transform : uppercase;"></span>
                  </p>
               </div>
               <div class="col-6">
                  <p class="font-weight-bold text-right   mb-0">Payment Mode<br>
                     <span class=" py-1 mb-0 rounded small mt-1 text-right" id="paymentModeDetail" style="text-transform : uppercase;"></span>
                  </p>
               </div>
            </div>
            
         </div>
         <!-- <div class="p-3 border-bottom">
            
            
         </div> -->
         <!-- Destination -->
         <div class="p-3 border-bottom bg-white">
            <h6 class="font-weight-bold">Destination</h6>
            <p class="m-0 small" id="shipingAddress">####### ##### #### ##### ###### </p>
         </div>
         <div class="p-3 border-bottom">
            <p class="font-weight-bold small mb-1">Courier</p>
            <img src="/app/img/logo.png" class="img-fluid sc-osahan-logo mr-2"> <span class="small text-danger font-weight-bold">RR Mart
            </span>
         </div>
         <div class="border-bottom p-3 bg-white">
            <h6 class="text-center"> Items</h6>
            <table class="table table-sm table-borderless" style="vertical-align: middle;" >
               <thead>
                  <tr>
                     <th>Image</th>
                     <th>Prduct Name</th>
                     <th class="text-right">Mrp</th>
                     <th class="text-right">SP</th>
                     <th class="text-center">Qty</th>
                     <th >Net</th>
                  </tr>
               </thead>
               <tbody id="salesItemTableBody">
                  
               </tbody>
            </table>
         </div>
         <!-- total price -->
         <!-- Destination -->
         <div class="p-3 border-bottom bg-white">
            <div class="d-flex align-items-center mb-2"  id="subTotalDiv">
               <h6 class="font-weight-bold mb-1">Sub Total</h6>
               <h6 class="font-weight-bold ml-auto mb-1" id="subTotal">0</h6>
            </div>
            <div class="d-flex align-items-center mb-2" id="usedCoinsDiv">
               <h6 class="font-weight-bold mb-1">Coins Used On this Order</h6>
               <h6 class="font-weight-bold ml-auto mb-1" id="usedCoins">0</h6>
            </div>
            <div class="d-flex align-items-center mb-2">
               <h6 class="font-weight-bold mb-1">Total Paid Amount</h6>
               <h6 class="font-weight-bold ml-auto mb-1" id="grandTotal">0</h6>
            </div>
            <p class="m-0 small text-muted">You can check your order detail here,<br>Thank you for order.</p>
         </div>
      </div>
      <!-- Navmenu START -->
      <%@include file="./menu/footer.jsp"%>
      <%@include file="./signup-bonus-modal.jsp"%>

      <%@include file="./menu/sidenav.jsp"%>
      <!-- Navmenu END -->
     <%@include file="./footerjs.jsp"%>
      <script>
         
         let ORDERLIST =[];

         let orderCount = 5;
         $(function () {
            

            // $(".order-body").click(function (e) { 
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


           
            getSalesList('${sessionScope.contactId}')
            //getSalesDetails(7)

         });

         getSalesList = (contactId) =>{
            if (contactId) {
               $.ajax({
                     url: "/user/sales",
                     data : {contactId : contactId},
                     type:"GET",
                     success: function(data,status) {
                     if(data.status){
                        console.log(data.response);
                        ORDERLIST = data.response;
                        setOrderListData(ORDERLIST);
                     }else{
                        toastr.error('',data.message);
                         $(".preloader-div").remove();
                          $("#noOrdersDiv").show();
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
               toastr.error('',"Please Login First");
                $(".preloader-div").remove();
               $("#noOrdersDiv").show();
            }
         }

        


         setOrderListData = (orderList) =>{

            $("#orderListDiv").empty();
             let content = "";
             if (orderList.length > 0) {
                $("#noOrdersDiv").hide();
                $.each(orderList, function (indexInArray, orderVo) { 
                   let badgeStatusColor = "bg-success";
                   let statusValue = 'ORDER PLACED'
                  switch (orderVo.deliveryStatus) {
                     case 'orderplaced':
                        badgeStatusColor = 'bg-info';
                        statusValue = 'ORDER PLACED';
                     break;
                     
                     case 'dispatched':
                        badgeStatusColor = 'bg-info';
                        statusValue = 'DISPATCHED'
                     break;
                     
                     case 'shipped':
                        badgeStatusColor = 'bg-info';
                        statusValue = 'SHIPPED'
                     break;
                     
                     case 'outfordelivery':
                        badgeStatusColor = 'bg-warning';
                        statusValue = 'OUT FOR DELIVERY'
                     break;
                     
                     case 'delivered':
                        badgeStatusColor = 'bg-success';
                        statusValue = 'DELIVERED'
                     break;

                     case 'canceled':
                        badgeStatusColor = 'bg-danger';
                        statusValue = 'CANCELLED'
                     break;
                     
                     default:
                        badgeStatusColor = "bg-info";
                        statusValue = 'ORDER PLACED';
                        break;
                  }

                  let totalPayment = (orderVo.total - orderVo.usedCoins).toFixed(0);
                  let paymentStatusFlag = ((orderVo.total - orderVo.paidAmount) == 0) ? 'PAID' : 'PENDING';
                  let branchName = orderVo.branchName;
                  
                  if (orderVo.deliveryStatus == 'canceled') {
                     paymentStatusFlag = "CANCELLED";
                  }

                  content+= '<div class="pb-3">'+
                     '<a href="javascript:void(0);" class="text-decoration-none text-dark" onclick="showOrderDetailsDiv('+orderVo.salesId+','+orderVo.branchId+')">'+
                        '<div class="p-3 rounded shadow-sm bg-white">'+
                           '<div class="d-flex align-items-center mb-2">'+
                              '<p class="'+badgeStatusColor+' text-white py-1 px-2 mb-0 rounded small" style="text-transform : uppercase;">'+statusValue+'</p>'+
                              '<p class="text-muted ml-auto small mb-0"><i class="icofont-clock-time"></i> '+moment(orderVo.salesDate).format('DD/MM/YYYY')+'</p>'+
                           '</div>'+
                           '<div class="d-flex align-items-center mb-2">'+
                              '<p class="text-dark mb-0 rounded small" style="text-transform : uppercase;"><strong>Branch Name : </strong>'+branchName+'</p>'+
                              // '<p class="text-muted ml-auto small mb-0"><i class="icofont-clock-time"></i> '+moment(orderVo.salesDate).format('DD/MM/YYYY')+'</p>'+
                           '</div>'+
                           '<div class="d-flex">'+
                              '<p class="text-muted m-0">Order No.<br>'+
                                 '<span class="text-dark font-weight-bold">#'+orderVo.salesNo+'</span>'+
                              '</p>'+
                              '<p class="text-muted text-center m-0 ml-auto">Payment Status<br>'+
                                 '<span class="text-dark  text-center font-weight-bold">'+paymentStatusFlag+'</span>'+
                              '</p>'+
                              '<p class="text-muted m-0 ml-auto text-right ">Total Payment<br>'+
                                 '<span class="text-dark font-weight-bold">&#x20B9; '+totalPayment+'</span>'+
                              '</p>'+
                           '</div>'+
                        '</div>'+
                  '</a>'+
                  '</div>';


               });

             } else {
               $("#noOrdersDiv").show();
             }




            
           
            $("#orderListDiv").append(content);
            $(".preloader-div").remove();

         }

         showOrderDetailsDiv = (salesId,branchId) =>{
            getSalesDetails(salesId,branchId);
         }

         showOrderListDiv= () =>{
            $("#orderMainListDiv").removeClass("m--hide");
            $("#orderMainDetailsDiv").addClass("m--hide");
         }

         getSalesDetails = (salesId,branchId) =>{
            $.ajax({
                  url: "/user/sales/details",
                  type:"GET",
                  data : {salesId : salesId,branchId : branchId},
                  success: function(data,status) {
                     if(data.status){
                        console.log(data.response);
                        setOrderDetailsData(data.response[1],data.response[0])
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


         setOrderDetailsData =(salesData,imageUrl) =>{

            console.log(salesData);
            if (salesData.length > 0) {
               $("#salesId").val(salesData[0].salesId);
               $("#salesNo").html(salesData[0].salesNo); 
               //$("#salesDate").html(moment(salesData[0].createdOn,'MM-DD-YYYY HH:MM:SS').format('DD/MM/YYYY HH:MM:SS A'));
               $("#salesDate").html(salesData[0].createdOn);
                  let badgeStatusColor = "bg-success";
                   let statusValue = 'ORDER PLACED'
                  switch (salesData[0].deliveryStatus) {
                     case 'orderplaced':
                        badgeStatusColor = 'bg-info';
                        statusValue = 'ORDER PLACED';
                     break;
                     
                     case 'dispatched':
                        badgeStatusColor = 'bg-info';
                        statusValue = 'DISPATCHED'
                     break;
                     
                     case 'shipped':
                        badgeStatusColor = 'bg-info';
                        statusValue = 'SHIPPED'
                     break;
                     
                     case 'outfordelivery':
                        badgeStatusColor = 'bg-warning';
                        statusValue = 'OUT FOR DELIVERY'
                     break;
                     
                     case 'delivered':
                        badgeStatusColor = 'bg-success';
                        statusValue = 'DELIVERED'
                     break;

                     case 'canceled':
                        badgeStatusColor = 'bg-danger';
                        statusValue = 'CANCELLED'
                     break;
                     
                     default:
                        badgeStatusColor = "bg-info";
                        statusValue = 'ORDER PLACED';
                        break;
                  }
               $("#deliveryStatus").html(statusValue);
               $("#branchName").html(salesData[0].branchName);
               $("#deliveryStatus").addClass(badgeStatusColor);
               $("#shipingAddress").html(salesData[0].shippingAddress);
               
               let content= "";
               let grandTotal  = 0;
               let totalPayment = (salesData[0].total - salesData[0].usedCoins).toFixed(0);
               let paymentStatusFlag = ((salesData[0].total - salesData[0].paidAmount) == 0) ? 'PAID' : 'PENDING';

               if(salesData[0].deliveryStatus == 'canceled'){
                  paymentStatusFlag = 'CANCELLED'
               }

               $("#paymentStatusDetail").html(paymentStatusFlag);
               let paymentMode = salesData[0].paymentMode;
               if ( paymentMode == 'cod') {
                  paymentMode = 'cash on delivery'
               }else if ( paymentMode == 'razorpay') {
                  paymentMode = 'Online payment'
               }else{

               }
               $("#paymentModeDetail").html(paymentMode);

               $("#salesItemTableBody").empty();
               $("#cancelOrderBtnDiv").empty();
               $.each(salesData, function (indexInArray, data) { 
                  grandTotal += parseFloat(data.netAmount);
                  content +='<tr>'+
                              '<td><img src="'+data.imagePath+'" class="img-fluid rounded mx-auto d-block" alt="Image" style="height:50px;"></td>'+
                              '<td>'+data.productName+'</td>'+
                              '<td class="text-right">'+(data.mrp).toFixed(0)+'</td>'+
                              '<td class="text-right">'+(data.netAmount/data.qty).toFixed(0)+'</td>'+
                              '<td  class="text-center">'+data.qty+'</td>'+
                              '<td class="text-right">'+data.netAmount.toFixed(0)+'</td>'+
                           '</tr>';

                           let cancelOrderBtn = `<button type="button" class="btn btn-danger btn-sm " onclick="cancelOrder(`+data.salesId+`,`+data.contactId+`,`+data.branchId+`)"><i class="icofont-close-circled mr-1"></i>Cancel Order</button>`;
                           if(data.deliveryStatus == 'orderplaced'){
                              $("#cancelOrderBtnDiv").html(cancelOrderBtn);
                           }
                  
               });

               $("#salesItemTableBody").append(content);

               console.log("COINS USED : " +salesData[0].usedCoins);
               if(salesData[0].usedCoins == 0){
                 
                 
                  // $("#subTotalDiv").hide();
                  // $("#usedCoinsDiv").hide();
                  $("#subTotalDiv").addClass("m--hide");
                  $("#usedCoinsDiv").addClass("m--hide");
                  $("#grandTotal").html("&#x20B9; " + grandTotal.toFixed(0));
                  
               }else{

                  $("#subTotalDiv").removeClass("m--hide");
                  $("#usedCoinsDiv").removeClass("m--hide");
                  // $("#subTotalDiv").show();
                  // $("#usedCoinsDiv").show();
                  $("#subTotal").html("&#x20B9; " + grandTotal.toFixed(0));
                  $("#usedCoins").html("" + salesData[0].usedCoins.toFixed(0));
                 // alert((parseFloat(grandTotal) - parseFloat(salesData[0].usedCoins)))
                  $("#grandTotal").html("&#x20B9; " + (parseFloat(grandTotal) - parseFloat(salesData[0].usedCoins)).toFixed(0));

                  
               }
               
               
            }else{

               $("#salesId").val(0);
               $("#salesNo").html('###');
               $("#salesDate").html('###');
               $("#deliveryStatus").html('###');
               $("#shipingAddress").html('###');
               let content= "<tr><td colspan='5' >No Data Found</td></tr>"
               $("#salesItemTableBody").append(content);
               $("#grandTotal").html("&#x20B9;" + " 0");
            }

            $("#orderMainDetailsDiv").removeClass("m--hide");
            $("#orderMainListDiv").addClass("m--hide");

         }

         cancelOrder = (salesId,userId,branchId) => {

            Swal.fire({
               icon:'warning',
               title: 'Warning',
               text: 'Are You Sure to cancle Order ?',
               showCancelButton: true,
               confirmButtonText: 'Yes',
            }).then((result) => {
               if (result.isConfirmed) {
                  $.ajax({
                        url: "/user/sales/cancel",
                        type:"POST",
                        data : {salesId : salesId,userId : userId,branchId : branchId},
                        success: function(data,status) {
                           if(data.status){
                              Swal.fire({
                                 icon: 'success',
                                 title: 'Success',
                                 text: data.message,
                                 showConfirmButton: false,
                                 timer: 500
                              })
                              setTimeout(() => {
                                 window.location.reload();
                              }, 500);
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
      </script> 
      
   </body>
</html>