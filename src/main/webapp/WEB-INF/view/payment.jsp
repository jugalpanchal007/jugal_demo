<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
   <head>
      <title>RRMart - Payment</title>
      <%@include file="./menu/head.jsp"%>
   </head>
   <body class="fixed-bottom-padding">
     
      <div class="osahan-payment">
         <div class="p-3 border-bottom">
            <div class="d-flex align-items-center">
               <a class="font-weight-bold text-danger text-decoration-none" href="/myaddress">
               <i class="icofont-rounded-left back-page"></i></a>
               <h6 class="font-weight-bold m-0 ml-3">Payment Method</h6>
               <a class="toggle ml-auto" href="#"><i class="icofont-navigation-menu"></i></a>
            </div>
         </div>
         <form action="/placeOrder" method="POST" id="checkoutForm">
            <input type="hidden" name="branchId" value="${sessionScope.branchId}" id="branchId">
            <div class="checkout pb-0 pt-3 pr-3 pl-3">
               <!-- <div class="accordion" id="accordionExample">
                  <div class="osahan-card rounded shadow-sm bg-white mb-3">
                     <div class="osahan-card-header" id="headingOne">
                        <h2 class="mb-0">
                           <button class="d-flex p-3 align-items-center border-0 btn btn-outline-success bg-white text-decoration-none text-success w-100" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                           <i class="icofont-credit-card mr-3"></i> Credit/Debit Card
                           <i class="icofont-rounded-down ml-auto"></i>
                           </button>
                        </h2>
                     </div>
                     <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
                        <div class="osahan-card-body p-3 border-top">
                           <h6 class="m-0">Add new card</h6>
                           <p class="small">WE ACCEPT <span class="osahan-card ml-2 font-weight-bold">( Master Card / Visa Card / Rupay )</span></p>
                           <form>
                              <div class="form-row">
                                 <div class="col-md-12 form-group">
                                    <label class="form-label font-weight-bold small">Card number</label>
                                    <div class="input-group">
                                       <input placeholder="Card number" type="number" class="form-control">
                                       <div class="input-group-append"><button id="button-addon2" type="button" class="btn btn-outline-secondary"><i class="icofont-credit-card"></i></button></div>
                                    </div>
                                 </div>
                                 <div class="col-md-8 form-group"><label class="form-label font-weight-bold small">Valid through(MM/YY)</label><input placeholder="Enter Valid through(MM/YY)" type="number" class="form-control"></div>
                                 <div class="col-md-4 form-group"><label class="form-label font-weight-bold small">CVV</label><input placeholder="Enter CVV Number" type="number" class="form-control"></div>
                                 <div class="col-md-12 form-group"><label class="form-label font-weight-bold small">Name on card</label><input placeholder="Enter Card number" type="text" class="form-control"></div>
                                 <div class="col-md-12 form-group">
                                    <div class="custom-control custom-checkbox"><input type="checkbox" id="custom-checkbox1" class="custom-control-input"><label title="" type="checkbox" for="custom-checkbox1" class="custom-control-label small pt-1">Securely save this card for a faster checkout next time.</label></div>
                                 </div>
                              </div>
                           </form>
                        </div>
                     </div>
                  </div>
                  <div class="osahan-card rounded shadow-sm bg-white mb-3">
                     <div class="osahan-card-header" id="headingTwo">
                        <h2 class="mb-0">
                           <button class="d-flex p-3 align-items-center btn text-decoration-none text-success w-100" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                           <i class="icofont-globe mr-3"></i> Net Banking
                           <i class="icofont-rounded-down ml-auto"></i>
                           </button>
                        </h2>
                     </div>
                     <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
                        <div class="osahan-card-body p-3 border-top">
                           <form>
                              <div class="btn-group btn-group-toggle w-100" data-toggle="buttons">
                                 <label class="btn btn-outline-secondary active">
                                 <input type="radio" name="options" id="option1" checked=""> HDFC
                                 </label>
                                 <label class="btn btn-outline-secondary">
                                 <input type="radio" name="options" id="option2"> ICICI
                                 </label>
                                 <label class="btn btn-outline-secondary">
                                 <input type="radio" name="options" id="option3"> AXIS
                                 </label>
                              </div>
                              <div class="form-row pt-3">
                                 <div class="col-md-12 form-group">
                                    <label class="form-label small font-weight-bold">Select Bank</label><br>
                                    <select class="custom-select form-control">
                                       <option>Bank</option>
                                       <option>KOTAK</option>
                                       <option>SBI</option>
                                       <option>UCO</option>
                                    </select>
                                 </div>
                              </div>
                           </form>
                        </div>
                     </div>
                  </div>
                  <div class="osahan-card rounded shadow-sm bg-white mb-3">
                     <div class="osahan-card-header" id="headingThree">
                        <h2 class="mb-0">
                           <button class="d-flex p-3 align-items-center btn text-decoration-none text-success w-100" type="button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                           <i class="icofont-dollar mr-3"></i> Cash on Delivery
                           <i class="icofont-rounded-down ml-auto"></i>
                           </button>
                        </h2>
                     </div>
                     <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
                        <div class="border-top">
                           <div class="card-body">
                              <div class="custom-control custom-checkbox mr-sm-2">
                                 <input type="checkbox" class="custom-control-input" id="customControlAutosizing">
                                 <label class="custom-control-label" for="customControlAutosizing">
                                    <b>Cash</b><br>
                                    <p class="small text-muted m-0">Please keep exact change handy to help us serve you better</p>
                                 </label>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div> -->
               <div class="card rounded shadow bg-white">
                  <div class="card-body">
                     <h5 class="card-title mb-3" style="text-transform: uppercase; text-align: center;">Select Payment Mode</h5>
                     <div class="border-top">
                        <div class="card-body">
                           <div class="custom-control custom-radio mr-sm-2">
                              <input type="radio" checked="checked" class="custom-control-input" id="cod" value="cod" name="payment">
                              <label class="custom-control-label" for="cod">
                                 <b>Cash</b><br>
                                 <p class="small text-muted m-0">Please keep exact change handy to help us serve you better</p>
                              </label>
                           </div>
                        </div>
                     </div>

                     <div class="border-top">
                        <div class="card-body">
                           <div class="custom-control custom-radio mr-sm-2">
                              <input type="radio" class="custom-control-input" id="razorpay" value="razorpay" name="payment">
                              <label class="custom-control-label" for="razorpay">
                                 <b>Online</b><br>
                                 <p class="small text-muted m-0">Proceeded to pay Online</p>
                              </label>
                           </div>
                        </div>
                     </div>
                     
                  </div>
               </div>
            
            </div>

            <a href="javascript:void(0)">
               <div class="p-3">
                  <div class="rounded shadow bg-white d-block align-items-center p-3 text-dark">
                     <div class="more">
                        <div class="row mb-2">
                           <div class="col-12">
                              <div class="custom-control custom-checkbox mr-sm-2">
                                 <input type="checkbox" class="custom-control-input" id="usedCoins" value="0" name="usedCoins">
                                 <label class="custom-control-label" for="usedCoins">
                                    <b>You are elegible to apply <span id="redemptionPoints">0</span> Points</b> <br>
                                    <p class="small text-muted m-0">Current Wallet Balance : <span id="walletBalance"></span></p>
                                 </label>
                              </div>
                           </div>
                        </div>
                     <div class="row">
                        <div class="col-6">
                           <h6 class="m-0">Subtotal </h6>
                        </div>
                        <div class="col-6 text-right" >
                           <h6 id="subtotalh6"> &#x20B9; 
                              <c:choose>
                                 <c:when test="${not empty sessionScope.subTotal}">
                                    <input type="hidden" name="subTotal" id="subTotal" value="${sessionScope.subTotal}">
                                    <span id="subTotalDiv">${sessionScope.subTotal}</span>
                                   
                                 </c:when><c:otherwise>0</c:otherwise>
                              </c:choose>
                           </h6>
                        </div>
                     </div>
                       

                    
                     </div>
                    
                  </div>
               </div>
            </a>

            <div class="pb-3 pt-0 pr-3 pl-3">
               <button type="button" class="w-100 rounded shadow bg-white" style="border: none;" id="checkOutBtn" >
                  <div class="p-3">
                     <div class="rounded shadow bg-success d-flex align-items-center p-3 text-white">
                        <div class="more">
                        <h6 class="m-0">Proceed to Checkout </h6>
                        </div>
                        <div class="ml-auto" id="icon-div"><i class="icofont-simple-right"></i></div>
                     </div>
                  </div>
               </button>
            </div>
         </form>
      </div>
      <!-- continue -->
      <div class="fixed-bottom">
         <a href="#" class="btn btn-success btn-block">Continue</a>
      </div>
      <!-- Modal -->
      <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
         <div class="modal-dialog">
            <div class="modal-content">
               <div class="modal-header">
                  <h5 class="modal-title" id="exampleModalLabel">Add Payment</h5>
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                  </button>
               </div>
               <form action="my_address.html">
                  <div class="modal-body">
                     <div class="form-group">
                        <label for="addAddress1">Address Name</label>
                        <input type="text" class="form-control" id="addAddress1" required>
                     </div>
                     <div class="form-group">
                        <label for="addAddress2">Enter Full Address</label>
                        <input type="text" class="form-control" id="addAddress2" required>
                     </div>
                  </div>
                  <div class="modal-footer">
                     <button type="button" class="btn btn-outline-secondary" data-dismiss="modal">Close</button>
                     <button type="submit" class="btn btn-outline-success">Save changes</button>
                  </div>
               </form>
            </div>
         </div>
      </div>
       <!-- Footer -->
       <%@include file="./menu/footer.jsp"%>

       <%@include file="./menu/sidenav.jsp"%>
      <!-- Bootstrap core JavaScript -->
      <script src="/app/vendor/jquery/jquery.min.js"></script>
      <script src="/app/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
      <!-- slick Slider JS-->
      <script type="text/javascript" src="/app/vendor/slick/slick.min.js"></script>

      <script src="/app/vendor/preloader/js/jquery.preloader.min.js"></script>
      <script src="/app/vendor/toastr.js"></script>

      <script src="/app/js/globalscript.js"></script>
      <!-- Sidebar JS-->
      <script type="text/javascript" src="/app/vendor/sidebar/hc-offcanvas-nav.js"></script>
      <!-- Custom scripts for all pages-->
      <script src="/app/js/osahan.js"></script>

      <script>
         let WALLETBALANCE = '${sessionScope.walletBalance}';
         let CASHBACKPERCENTAGE = parseFloat(0);
         let subtotal = '${sessionScope.subTotal}';
         let SUBTOTAL = parseFloat(0);
         let ACTUALSUBTOTAL =  '${sessionScope.subTotal}';
         let BRANCHID = '${sessionScope.branchId}';
         if(subtotal){
            SUBTOTAL = parseFloat(subtotal);
         }

         // console.log("BEFORE   :" + SUBTOTAL );
         // console.log("WALLETBALANCE :" + WALLETBALANCE );
         // console.log("CASHBACKPERCENTAGE :" + CASHBACKPERCENTAGE );
         // console.log("subtotal :" + subtotal );
         // console.log("SUBTOTAL :" + SUBTOTAL );
         // console.log("ACTUALSUBTOTAL :" + ACTUALSUBTOTAL );
         // console.log("SUBTOTAL :" + SUBTOTAL );


         let getcashbackpercentage =() => {
            let percentage = parseFloat(0);
            $.ajax({
                  url: "/getcashbackpercentage",
                  type:"GET",
                  success: function(data,status) {
                     if(data.status){
                        //alert(data.response)
                        CASHBACKPERCENTAGE = data.response;
                        $("#redemptionPoints").html(calculatepercentageWiseReddemCount());
                     }
                  },
                  error: function(XMLHttpRequest, textStatus, errorThrown) { 
                     CASHBACKPERCENTAGE = 0;
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



         getcashbackpercentage()
         

         // console.log("AFTER 1   :" + SUBTOTAL );
         // console.log("WALLETBALANCE :" + WALLETBALANCE );
         // console.log("CASHBACKPERCENTAGE :" + CASHBACKPERCENTAGE );
         // console.log("subtotal :" + subtotal );
         // console.log("SUBTOTAL :" + SUBTOTAL );
         $(document).ready(function () {
            
            $("#walletBalance").html(WALLETBALANCE);
            $("#redemptionPoints").html(CASHBACKPERCENTAGE);
      
         });

         $("#checkOutBtn").click(function (e) { 
            e.preventDefault();
            $("#icon-div").html('<i class="fa fa-spinner fa-spin"></i>');
            $("#checkOutBtn").attr("disabled", "disabled");
            // $("#usedCoins").attr("readonly", true);
            let sessionSubTotal = '${sessionScope.subTotal}';
            if(sessionSubTotal){

               if (BRANCHID) {
                  $("#checkoutForm").submit();   
               } else {
                  toastr.error('Please Select Branch');
               }
               
            }else{
               toastr.error('Please Login again');
               $("#icon-div").html('<i class="icofont-simple-right"></i>');
               // $("#usedCoins").attr("readonly", true);
               setTimeout(() => {
                  window.location.href="/userlogout";
               }, 500);
            }
            
         });



         let calculatepercentageWiseReddemCount = () =>{

            let points = parseFloat(0);

            if (SUBTOTAL != 0) {
               //CASHBACKPERCENTAGE = getcashbackpercentage();
               //console.log("CASHBACKPERCENTAGE : "+ CASHBACKPERCENTAGE);

               if(isNaN(CASHBACKPERCENTAGE) || isNaN(SUBTOTAL)){
                  points=parseFloat(0);
               }else{
                  points = Math.round(((CASHBACKPERCENTAGE/100) * SUBTOTAL));
               }

               if(points != 0){
                  if(points > WALLETBALANCE){
                     points = WALLETBALANCE
                  }
               }
            } 
            return points;
         }


        
         $("#usedCoins").on('change', function() {
            let actualTotal = SUBTOTAL;
            let redeemPoints = calculatepercentageWiseReddemCount();

            // console.log("usedCoins change 1   :" + SUBTOTAL );
            // console.log("actualTotal :" + actualTotal );
            // console.log("redeemPoints :" + redeemPoints );
               
            let walletPoints = WALLETBALANCE;
            if ($(this).is(':checked')) {
               $(this).attr('value', '1');
               console.log("true");
               //console.log(parseFloat(actualTotal)  - parseFloat(redeemPoints));
               $("#usedCoins").val(redeemPoints);
               $("#subTotalDiv").html((parseFloat(actualTotal)  - parseFloat(redeemPoints)).toFixed(1)  );
            } else {
            $(this).attr('value', '0');
               console.log("false");
               //$("#usedCoins").val(parseFloat(actualTotal).toFixed(1) );
               $("#usedCoins").val(0);
               $("#subTotalDiv").html(parseFloat(actualTotal).toFixed(1) );
            }
         
         //  $('#checkbox-value').text($('#checkbox1').val());
         });
      </script>


     
</html>