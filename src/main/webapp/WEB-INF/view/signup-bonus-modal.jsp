<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
    aria-modal="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">SIGNUP BONUS</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">x</span>
                </button>
            </div>
            <div class="modal-body p-0">
                <div class="osahan-promo">

                    <a href="#" class="text-decoration-none text-white">
                        <div class="bg-danger p-3 text-white">
                            <div class="row align-items-center">
                                <div class="col-6">
                                    <div class="d-flex align-items-center">
                                        <img class="p-osahan-logo" src="/app/img/logo.png">
                                        <div class="brand ml-2">
                                            <h5 class="m-0">RRMart</h5>
                                        </div>
                                    </div>
                                    <div class="pt-3">
                                        <p class="btn btn-outline-light mb-0"><i class="icofont-tag mr-1"></i> Get ${sessionScope.signupBonus} Rcoins as a SignUp Bonus</p>
                                    </div>
                                </div>
                                <div class="col-6 text-center">
                                    <img src="/app/img/promos/bonus.jpeg" class="img-fluid" style="border-radius: 5px; border: 2px solid;">
                                </div>
                            </div>
                        </div>
                    </a>
                    <div class="promo_detail">
                        <div class="title p-3 bg-white shadow-sm">
                            <h5 class="font-weight-bold text-danger">Get ${sessionScope.signupBonus} Rcoins as a SignUp Bonus</h5>
                            <p class="small text-muted m-0">Applicable For New Use Only...!!!</p>
                        </div>
                        <div class="p-3 bg-light">
                            <p class="font-weight-bold mb-2">Description</p>
                            <p class="small m-0">Get ${sessionScope.signupBonus} Rcoins as signup bonus by just fillup the below servey form.</p>
                            <p> 1 Rcoins = 1 Rupee</p>
                        </div>
                        <div class="p-3">
                            <p class="font-weight-bold mb-2">Steps to Get bonus Points</p>
                            <ul class="pl-3 mb-0">
                                <li class="text-muted">Click on <b>"GET NOW"</b> , it will redirect to survery form.</li>
                                <li class="text-muted">Fill Up all mandatory fields in that SURVEY FORM.</li>
                                <li class="text-muted">After dangerfully filling up the SURVEY FORM, you will automatically get the Rcoins into your <b>RRMart Wallet Balance</b>.
                                </li>
                                <li class="text-muted">You Can Able to view your wallet balance in your Profile</li>
                            </ul>
                        </div>
                    </div>
                </div>


            </div>
            <div class="modal-footer p-0 border-0">

                <div class="col-12 m-0 p-0">
                    <button type="button" class="btn btn-danger btn-lg btn-block" onclick="window.location.href='/survey-form'">Apply</button>
                </div>
            </div>
        </div>
    </div>
</div>