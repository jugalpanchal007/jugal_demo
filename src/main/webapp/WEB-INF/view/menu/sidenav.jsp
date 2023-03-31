<nav id="main-nav">
    <ul class="second-nav">
        <c:if test="${not empty sessionScope.contactId}" >
            <li><a href="/myaccount"><i class="icofont-user mr-2"></i> My Profile</a></li>
            <li><a href="/refer"><i class="icofont-gift mr-2"></i> Refer & Earn Program</a></li>
            <li><a href="/categories"><i class="icofont-dropbox mr-2"></i> Shop By Category</a></li>
            <li><a href="/wishlist"><i class="icofont-heart mr-2"></i> My Wishlist</a></li>
        </c:if>
        
        <li><a href="/order"><i class="icofont-cart mr-2"></i> My Orders</a></li>
        <!-- <li><a href="javascript:void(0);"><i class="icofont-cart mr-2"></i> Change Language</a></li>
        <li><a href="javascript:void(0);"><i class="icofont-cart mr-2"></i> Offers</a></li> -->
        <li>
          <a href="mailto:care@rrmart.in"><i class="icofont-email mr-2"></i>Email us: care@rrmart.in</a>
        </li>
        
        

       
        
        <!-- <li>
            <a href="#"><i class="icofont-login mr-2"></i> Authentication</a>
            <ul>
                <li> <a href="account-setup.html">Account Setup</a></li>
                <li><a href="signin.html">Sign in</a></li>
                <li><a href="signup.html">Sign up</a></li>
                <li><a href="verification.html">Verification</a></li>
            </ul>
        </li>
        <li><a href="get_started.html"><i class="icofont-check-circled mr-2"></i> Get Started</a></li>
        <li><a href="landing.html"><i class="icofont-paper-plane mr-2"></i> Landing</a></li>
        <li><a href="home.html"><i class="icofont-ui-home mr-2"></i> Homepage</a></li>
        <li><a href="notification.html"><i class="icofont-notification mr-2"></i> Notification</a></li>
        <li><a href="search.html"><i class="icofont-search-1 mr-2"></i> Search</a></li>
        <li><a href="listing.html"><i class="icofont-list mr-2"></i> Listing</a></li>
        <li><a href="picks_today.html"><i class="icofont-flash mr-2"></i> Trending</a></li>
        <li><a href="recommend.html"><i class="icofont-like mr-2"></i> Recommend</a></li>
        <li><a href="fresh_vegan.html"><i class="icofont-badge mr-2"></i> Most Popular</a></li>
        <li><a href="product_details.html"><i class="icofont-search-document mr-2"></i> Product Details</a></li>
        <li><a href="cart.html"><i class="icofont-cart mr-2"></i> Cart</a></li>
        <li><a href="order_address.html"><i class="icofont-location-pin mr-2"></i> Order Address</a></li>
        <li><a href="delivery_time.html"><i class="icofont-ui-calendar mr-2"></i> Delivery Time</a></li>
        <li><a href="order_payment.html"><i class="icofont-money mr-2"></i> Order Payment</a></li>
        <li><a href="checkout.html"><i class="icofont-checked mr-2"></i> Checkout</a></li>
        <li><a href="successful.html"><i class="icofont-gift mr-2"></i> Successful</a></li>
        <li>
            <a href="#"><i class="icofont-sub-listing mr-2"></i> My Order</a>
            <ul>
                <li><a href="complete_order.html">Complete Order</a></li>
                <li><a href="status_complete.html">Status Complete</a></li>
                <li><a href="progress_order.html">Progress Order</a></li>
                <li><a href="status_onprocess.html">Status on Process</a></li>
                <li><a href="canceled_order.html">Canceled Order</a></li>
                <li><a href="status_canceled.html">Status Canceled</a></li>
                <li><a href="review.html">Review</a></li>
            </ul>
        </li>
        <li>
            <a href="#"><i class="icofont-ui-user mr-2"></i> My Account</a>
            <ul>
                <li> <a href="my_account.html">My Account</a></li>
                <li><a href="edit_profile.html">Edit Profile</a></li>
                <li><a href="change_password.html">Change Password</a></li>
                <li><a href="deactivate_account.html">Deactivate Account</a></li>
                <li><a href="my_address.html">My Address</a></li>
            </ul>
        </li>
        <li>
            <a href="#"><i class="icofont-page mr-2"></i> Pages</a>
            <ul>
                <li> <a href="promos.html">Promos</a></li>
                <li><a href="promo_details.html">Promo Details</a></li>
                <li><a href="terms_conditions.html">Terms & Conditions</a></li>
                <li><a href="privacy.html">Privacy</a></li>
                <li><a href="terms&conditions.html">Conditions</a></li>
                <li> <a href="help_support.html">Help Support</a></li>
                <li>  <a href="help_ticket.html">Help Ticket</a></li>
                <li>  <a href="refund_payment.html">Refund Payment</a></li>
                <li>  <a href="faq.html">FAQ</a></li>
            </ul>
        </li>
        <li>
            <a href="#"><i class="icofont-link mr-2"></i> Navigation Link Example</a>
            <ul>
                <li>
                <a href="#">Link Example 1</a>
                <ul>
                    <li>
                        <a href="#">Link Example 1.1</a>
                        <ul>
                            <li><a href="#">Link</a></li>
                            <li><a href="#">Link</a></li>
                            <li><a href="#">Link</a></li>
                            <li><a href="#">Link</a></li>
                            <li><a href="#">Link</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">Link Example 1.2</a>
                        <ul>
                            <li><a href="#">Link</a></li>
                            <li><a href="#">Link</a></li>
                            <li><a href="#">Link</a></li>
                            <li><a href="#">Link</a></li>
                        </ul>
                    </li>
                </ul>
                </li>
                <li><a href="#">Link Example 2</a></li>
                <li><a href="#">Link Example 3</a></li>
                <li><a href="#">Link Example 4</a></li>
                <li data-nav-custom-content>
                <div class="custom-message">
                    You can add any custom content to your navigation items. This text is just an example.
                </div>
                </li>
            </ul>
        </li> -->
    </ul>
    
    <ul class="bottom-nav">
    <li class="email">
        <a class="text-danger" href="/home">
            <p class="h5 m-0"><i class="icofont-home text-danger"></i></p>
            Home
        </a>
    </li>
    <li class="github">
        <a href="/cart">
            <p class="h5 m-0"><i class="icofont-cart"></i> <span class='badge badge-warning cartCount' > 
               
                <c:if test="${not empty sessionScope.cartList}">
                    ${sessionScope.cartList.size()}
                </c:if>
                
                
             </span></p>
            CART
        </a>
    </li>
    <c:choose>
       <c:when test="${not empty sessionScope.contactId}">
            <li class="github">
                <a href="/userlogout" onclick="logoutFnc();">
                    <p class="h5 m-0"><i class="icofont-lock"></i></p>
                    LOGOUT
                </a>
            </li>
       </c:when>
    
       <c:otherwise>
            <li class="github">
                <a href="/signin">
                    <p class="h5 m-0"><i class="icofont-lock"></i></p>
                    LOGIN
                </a>
            </li>
       </c:otherwise>
    </c:choose>
    <%-- <li class="ko-fi">
        <a href="help_ticket">
            <p class="h5 m-0"><i class="icofont-headphone"></i></p>
            Help
        </a>
    </li> --%>
    
    <li class="ko-fi">
        <div class="theme-switch-wrapper">
            <label class="theme-switch" for="checkbox">
                <input type="checkbox" id="checkbox" />
                <div class="slider round"></div>
                <i class="icofont-moon"></i>
            </label>
            <em>Enable Dark Mode!</em>
        </div>
    </li> 
    
    <script>
    
        logoutFnc = () => {
            localStorage.clear();
        }

        
    </script>
    </ul>

    
</nav>