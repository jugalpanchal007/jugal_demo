<!DOCTYPE html>
<html lang="en">
   <head>
      <title>RRMart - Wallet Transactions</title>
      <%@include file="./menu/head.jsp"%>
      
   </head>
   <body class="fixed-bottom-padding">
      <div class="preloader-div">
         <div class="preloaderBg" id="preloader" onload="preloader()">
            <div class="preloader">
               <div class="preloader2"></div>
            </div>
      </div>
      </div>
      
      <div class="osahan-order">
         <div class="order-menu">
            <h5 class="font-weight-bold p-3 d-flex align-items-center">Wallet Transactions <a class="toggle ml-auto" href="#"><i class="icofont-navigation-menu"></i></a></h5>
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
         <div class="order-body px-3 pt-3" id="transactionsDiv">
            
         </div>
      </div>
      <!-- Footer -->
      <%@include file="./menu/footer.jsp"%>
            <%@include file="./signup-bonus-modal.jsp"%>

            <%@include file="./menu/sidenav.jsp"%>
             <%@include file="./footerjs.jsp"%>
            <script>
            
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

                  getwalletTransactions();

               });


               getwalletTransactions = () => {
                  let contactId = '${sessionScope.contactId}';
                  if(contactId){
                     $.ajax({
                        type: "GET",
                        url: "/uesr/wallet/transactions",
                        data: {contactId : contactId},
                        success: function (data) {
                              if (data.status) {
                                 $("#transactionsDiv").empty();
                                 let content = "";
                                 $.each(data.response, function (indexInArray, res) { 
                                       let transactionType = res.walletTransactionType;
                                       let date = moment(res.walletTransactionDate).format('DD/MM/YYYY hh:mm:ss A');
                                       let transactiontitle = ""
                                       let transactionNo = "#TRN00"+ res.walletTransactionId;
                                       let bgcolor = ""
                                       let points = res.actualPoints
                                       let pointsColor = "success"
                                       let description = "";
                                       if (transactionType == "signUpBonus") {
                                          transactiontitle = "SIGN UP BONUS"
                                          bgcolor = "success";
                                          points ='+ '+ res.actualPoints
                                          description = res.description;
                                          pointsColor = "success"
                                       } else if (transactionType == "referral"){
                                          transactiontitle = "REFERRAL BONUS"
                                          bgcolor = "info";
                                          points ='+ '+ res.actualPoints
                                          pointsColor = "success"
                                          description = res.description;
                                       }else{
                                          transactiontitle = "EXPANSE"
                                          bgcolor = "danger";
                                          points ='- '+ res.actualPoints
                                          pointsColor = "danger"
                                          description = res.description;
                                          let a = description.split('#');
                                          description = "#"+a[1];
                                       }
                                       

                                       content += '<div class="pb-3">\n'+
                                       '               <a href="javascript:void(0);" class="text-decoration-none text-dark">\n'+
                                       '                  <div class="p-3 rounded shadow-sm bg-white">\n'+
                                       '                     <div class="d-flex align-items-center mb-3">\n'+
                                       '                        <p class="bg-'+bgcolor+' text-white font-weight-bold py-1 px-2 mb-0 rounded small">'+transactiontitle+'</p>\n'+
                                       '                        <p class="text-muted ml-auto small font-weight-bold mb-0"><i class="icofont-clock-time font-weight-bolds"></i> '+date+'</p>\n'+
                                       '                     </div>\n'+
                                       '                     <div class="d-flex">\n'+
                                       '                        <p class="text-muted m-0">Transaction. ID<br>\n'+
                                       '                           <span class="text-dark font-weight-bold">'+transactionNo+'</span>\n'+
                                       '                        </p>\n'+
                                       '                        <p class="text-muted m-0 ml-auto text-center">Transaction On<br>\n'+
                                       '                            <span class="text-dark font-weight-bold  text-center">'+description+'</span>\n'+
                                       '                         </p>\n'+
                                       '                        <p class="text-muted m-0 ml-auto text-right">Points<br>\n'+
                                       '                           <span class="text-right font-weight-bold text-'+pointsColor+'">'+points+'</span>\n'+
                                       '                        </p>\n'+
                                       '                     </div>\n'+
                                       '                  </div>\n'+
                                       '               </a>\n'+
                                       '            </div>';

                                 });

                                 $("#transactionsDiv").append(content);

                              } else {
                                 $("#transactionsDiv").empty();
                                 content="<p>No Transactions Found </p>";
                                 $("#transactionsDiv").append(content);
                              }
                           $(".preloader-div").remove();
                        }
                     });
                  }else{
                     toastr.error('Session Expired Please Login Again');
                     setTimeout(() => {
                        window.location.href="/userlogout";
                     }, 500);

                  }
                 
               }
            </script> 

   </body>
</html>