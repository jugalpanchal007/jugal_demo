<div class="bg-white" style="background-color:#DC3545 !important;" id="subheader">
    <div class="container menu-bar d-flex align-items-center p-2">
        <ul class="list-unstyled form-inline mb-0">

            <c:choose>
                <c:when test="${not empty sessionScope.contactId}">
                    <li class="nav-item active">
                        <a class="nav-link text-white pl-0" href="/home">
                            <i class="icofont-home mr-1"></i>HOME <span class="sr-only"></span></a>
                    </li>

                    <li class="nav-item active">
                        <a class="nav-link text-white pl-2" href="/order">
                            <i class="icofont-bag mr-1"></i>MY ORDERS<span class="sr-only"></span>
                        </a>
                    </li>

                    <li class="nav-item active">
                        <a class="nav-link text-white pl-2" href="/wishlist">
                            <i class="icofont-heart mr-1"></i>MY WISHLIST<span class="sr-only"></span>
                        </a>
                    </li>

                    <li class="nav-item active">
                        <a class="nav-link text-white pl-2" href="/categories">
                            <i class="icofont-shopping-cart mr-1"></i>ALL CATEGORIES<span class="sr-only"></span>
                        </a>
                    </li>
                </c:when>
                
                <c:otherwise>
                    <li class="nav-item active">
                        <a class="nav-link text-white pl-0" href="/home">
                            <i class="icofont-home mr-1"></i>HOME <span class="sr-only"></span></a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link text-white pl-2" href="/order">
                            <i class="icofont-bag mr-1"></i>MY ORDERS<span class="sr-only"></span>
                        </a>
                    </li>
                </c:otherwise>
            </c:choose>
            




        </ul>
        <%-- <div class="list-unstyled form-inline mb-0 ml-auto">
            <a href="picks_today.html" class="text-white px-3 py-2">Trending</a>
            <a href="promos.html" class="text-white bg-offer px-3 py-2"><i
                    class="icofont-sale-discount h6"></i>Promos</a>
        </div> --%>
        <div class="ml-auto d-flex align-items-center">

            

            <c:choose>
                <c:when test="${not empty sessionScope.contactId}">
                        <a href="/userlogout" class="mr-2 text-dark bg-light rounded-pill p-2 icofont-size border shadow-sm">
                            <i class="icofont-login"></i>
                        </a>

                        <a href="mailto:care@rrmart.in" data-toggle="modal" data-target="#login"
                            class="mr-2 text-dark bg-light rounded-pill p-2 icofont-size border shadow-sm">
                            <i class="icofont-mail"></i>
                        </a>

                        <a href="/cart" class="ml-2 text-dark bg-light rounded-pill p-2 icofont-size border shadow-sm">
                            <i class="icofont-shopping-cart"></i>
                        </a>
                        <div class="dropdown ml-2 mr-3">
                            <a href="#" class="dropdown-toggle text-white" id="dropdownMenuButton" data-toggle="dropdown"
                                aria-haspopup="true" aria-expanded="true">
                                Hi ${sessionScope.contactName}
                            </a>
                            <div class="dropdown-menu dropdown-menu-right top-profile-drop"
                                aria-labelledby="dropdownMenuButton">
                                <a class="dropdown-item" href="/myaccount">My Profile</a>
                                <a class="dropdown-item" href="/wallet/transactions">Wallet Transaction</a>
                                <a class="dropdown-item" href="/myaddress">My address</a>
                                <a class="dropdown-item" href="/helpSupport">Help &amp; Support</a>
                                <a class="dropdown-item" href="/userlogout">Logout</a>
                                
                            </div>
                        </div>
                </c:when>
                
                <c:otherwise>
                         <a href="/login" class="mr-2 text-dark bg-light rounded-pill p-2 icofont-size border shadow-sm">
                            <i class="icofont-login"></i>
                        </a>

                        <a href="mailto:care@rrmart.in" data-toggle="modal" data-target="#login"
                            class="mr-2 text-dark bg-light rounded-pill p-2 icofont-size border shadow-sm">
                            <i class="icofont-mail"></i>
                        </a>
                </c:otherwise>
            </c:choose>

            
        </div>
    </div>
</div>