<div class="osahan-menu-fotter fixed-bottom bg-white text-center border-top">
   <div class="row m-0">
      <a href="/home" class="text-dark small col font-weight-bold text-decoration-none p-2">
         <p class="h5 m-0"><i class="icofont-grocery"></i></p>
         Shop
      </a>
      <a href="/cart" class="text-dark col small text-decoration-none p-2">
         <p class="h5 m-0"><i class="icofont-cart"></i>
            <span class='badge badge-warning cartCount'>
               <c:if test="${not empty sessionScope.cartList}">
                  ${sessionScope.cartList.size()}
               </c:if>
            </span>
         </p>
         Cart
      </a>
      <a href="/order" class="text-dark col small text-decoration-none p-2">
         <p class="h5 m-0"><i class="icofont-bag"></i></p>
         Order
      </a>


      <c:choose>
         <c:when test="${not empty sessionScope.contactId}">
            <a href="/myaccount" class="text-dark small col text-decoration-none p-2">
               <p class="h5 m-0"><i class="icofont-user"></i></p>
               My Account
            </a>
         </c:when>

         <c:otherwise>
            <a href="/signin" class="text-dark small col text-decoration-none p-2">
               <p class="h5 m-0"><i class="icofont-lock"></i></p>
               Login
            </a>

         </c:otherwise>
      </c:choose>


   </div>
</div>

<footer class="section-footer border-top bg-white" style="width: 100%; position: absolute;" id="webFooter">
   <%-- <section class="footer-top py-4">
      <div class="container">
         <div class="row">
            <div class="col-md-4">
               <div class="form-inline">
                  <select class="custom-select mr-2">
                     <option>USD</option>
                     <option>EUR</option>
                     <option>RUBL</option>
                  </select>
                  <select class="custom-select">
                     <option>United States</option>
                     <option>Russia</option>
                     <option>Uzbekistan</option>
                  </select>
               </div>

            </div>
            <div class="col-md-4">
               <form>
                  <div class="input-group">
                     <input type="text" placeholder="Email" class="form-control" name="">
                     <span class="input-group-append">
                        <button type="submit" class="btn btn-success"> Subscribe</button>
                     </span>
                  </div>

               </form>
            </div>
            <div class="col-md-4 text-md-right">
               <a href="#" class="btn btn-icon btn-light"><i class="icofont-facebook"></i></a>
               <a href="#" class="btn btn-icon btn-light"><i class="icofont-twitter"></i></a>
               <a href="#" class="btn btn-icon btn-light"><i class="icofont-instagram"></i></a>
               <a href="#" class="btn btn-icon btn-light"><i class="icofont-youtube"></i></a>
            </div>
         </div>

      </div>

   </section> --%>

   <!-- <section class="footer-main border-top pt-5 pb-4">
      <div class="container">
         <div class="row">
            <aside class="col-md">
               <h6 class="title">Products</h6>
               <ul class="list-unstyled list-padding">
                  <li> <a href="listing.html" class="text-dark">Listing</a></li>
                  <li> <a href="product_details.html" class="text-dark">Detail</a></li>
                  <li> <a href="picks_today.html" class="text-dark">Trending</a></li>
                  <li> <a href="recommend.html" class="text-dark">Recommended</a></li>
                  <li> <a href="fresh_vegan.html" class="text-dark">Most Popular</a></li>
               </ul>
            </aside>
            <aside class="col-md">
               <h6 class="title">Checkout Process</h6>
               <ul class="list-unstyled list-padding">
                  <li> <a href="cart.html" class="text-dark">Cart</a></li>
                  <li> <a href="cart.html" class="text-dark">Order Address</a></li>
                  <li> <a href="cart.html" class="text-dark">Delivery Time</a></li>
                  <li> <a href="cart.html" class="text-dark">Order Payment</a></li>
                  <li> <a href="checkout.html" class="text-dark">Checkout</a></li>
                  <li> <a href="successful.html" class="text-dark">Successful</a></li>
               </ul>
            </aside>
            <aside class="col-md">
               <h6 class="title">My Order</h6>
               <ul class="list-unstyled list-padding">
                  <li> <a href="my_order.html" class="text-dark">My order</a></li>
                  <li> <a href="status_complete.html" class="text-dark">Status Complete</a></li>
                  <li> <a href="status_onprocess.html" class="text-dark">Status on Process</a></li>
                  <li> <a href="status_canceled.html" class="text-dark">Status Canceled</a></li>
                  <li> <a href="review.html" class="text-dark">Review</a></li>
               </ul>
            </aside>
            <aside class="col-md">
               <h6 class="title">My Account</h6>
               <ul class="list-unstyled list-padding">
                  <li> <a class="text-dark" href="my_account.html"> My account</a></li>
                  <li> <a class="text-dark" href="promos.html"> Promos</a></li>
                  <li> <a class="text-dark" href="my_address.html"> My address</a></li>
                  <li> <a class="text-dark" href="terms_conditions.html"> Terms &amp; conditions</a></li>
                  <li> <a class="text-dark" href="help_support.html"> Help &amp; support</a></li>
                  <li> <a class="text-dark" href="help_ticket.html"> Help ticket</a></li>
                  <li> <a class="text-dark" href="signin.html"> Logout</a></li>
               </ul>
            </aside>
            <aside class="col-md">
               <h6 class="title">Extra Pages</h6>
               <ul class="list-unstyled list-padding">
                  <li><a href="promo_details.html" class="text-dark"> Promo Details </a></li>
                  <li><a href="terms_conditions.html" class="text-dark"> Conditions </a></li>
                  <li><a href="help_support.html" class="text-dark"> Help Support </a></li>
                  <li><a href="refund_payment.html" class="text-dark"> Refund Payment </a></li>
                  <li><a href="faq.html" class="text-dark"> FAQ </a></li>
                  <li><a href="signin.html" class="text-dark"> Sign In </a></li>
               </ul>
            </aside>
         </div>

      </div>

   </section> -->


   <section class="footer-bottom border-top py-2">
      <div class="container">
         <div class="row">
            <div class="col-md-6">
               <span class="pr-2">&#169; 2021 RRMART</span>
               <span class="pr-2"><a href="privacy.html" class="text-dark">Privacy</a></span>
               <span class="pr-2"><a href="terms&amp;conditions.html" class="text-dark">Terms &amp;
                     Conditions</a></span>
            </div>
            <div class="col-md-6 text-md-right">
               <a href=""><img src="https://askbootstrap.com/preview/grofarweb/img/playmarket.png" height="30"></a>
            </div>
         </div>

      </div>

   </section>
</footer>