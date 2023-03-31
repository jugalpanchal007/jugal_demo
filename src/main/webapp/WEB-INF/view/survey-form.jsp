<!DOCTYPE html>
<html lang="en">

<head>
    
    <title>RRMart - Survey Form</title>
    <%@include file="./menu/head.jsp"%>

    <style>
        .form-check {
            position: relative;
            display: block;
            padding-left: 1.25rem;
            margin-bottom: 7px;
            font-weight: 600;
        }

        .card {
            background: transparent !important;
        }
        label.custom-control-label.w-100 {
            padding: 7px;
            margin-bottom: 7px;
            font-weight: 500;
        }
        .m--hide{
            display : none !important; 
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
    <!-- home page -->
    <div class="osahan-home-page">
        <div class="border-bottom p-3">
            <div class="title d-flex align-items-center">
                <a href="/home" class="text-decoration-none text-dark d-flex align-items-center">
                    <img class="osahan-logo mr-2" src="/app/img/logo.png">
                    <h4 class="font-weight-bold text-danger m-0">RRMart</h4>
                </a>
                <p class="ml-auto m-0">
                    <!-- <a href="notification.html" class="text-decoration-none bg-white p-1 rounded shadow-sm d-flex align-items-center">
                  <i class="text-dark icofont-notification"></i>
                  <span class="badge badge-danger p-1 ml-1 small">2</span>
                  </a> -->
                </p>
                <a class="toggle ml-3" href="#"><i class="icofont-navigation-menu"></i></a>
            </div>
            <!-- <a href="search.html" class="text-decoration-none">
               <div class="input-group mt-3 rounded shadow-sm overflow-hidden bg-white">
                  <div class="input-group-prepend">
                     <button class="border-0 btn btn-outline-secondary text-danger bg-white"><i class="icofont-search"></i></button>
                  </div>
                  <input type="text" class="shadow-none border-0 form-control pl-0" placeholder="Search for Products.." aria-label="" aria-describedby="basic-addon1">
               </div>
            </a> -->
        </div>
        <!-- body -->
        <div class="osahan-body">
            <!-- categories -->
            <form id="surveyForm">
                <div class="p-3 osahan-categories">
                    <h6 class="mb-2 text-center">SURVEY FORM</h6>
                    <p class="text-center">Note : Please Fill up all mandatory ( <span class="text-danger">*</span> )
                        details</p>
                    <input type="hidden" name="userId" id="userId" value="0">
                    <div class="row m-0" id="surveyDiv">

                    </div>

                    <div class="row m--hide" id="submitandresrtBtnDiv">
                        <div class="col-12 pl-0 pr-1 py-1">
                            <div class="bg-white shadow-sm rounded">
                                <div class="card" style="border: none;">

                                    <div class="card-body pt-1 pb-2">
                                        <div class="row">
                                            <div class="col-6 p-1">
                                                <button type="button" name="" id="submitBtn"
                                                    class="btn btn-danger btn-lg btn-block">SUBMIT</button>
                                            </div>
                                            <div class="col-6 p-1">
                                                <button type="reset" name="" id="reserFormValidations" onclick="resetFormValidationsFnc()"
                                                    class="btn btn-dark btn-lg btn-block">RESET</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </form>


        </div>
    </div>
    <%@include file="./menu/footer.jsp"%>
    <%@include file="./menu/sidenav.jsp"%>
    <!-- Bootstrap core JavaScript -->
    <script src="/app/vendor/jquery/jquery.min.js"></script>
    <script src="/app/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- slick Slider JS-->
    <script type="text/javascript" src="/app/vendor/slick/slick.min.js"></script>
    <!-- Sidebar JS-->
    <!-- Include JS START-->
    <script src="/app/vendor/preloader/js/jquery.preloader.min.js"></script>
    <script src="/app/vendor/toastr.js"></script>

    <script src="/app/js/globalscript.js"></script>
    
   <script type="text/javascript" src="/app/vendor/formvalidation/formValidation.min.js"></script>
   <script type="text/javascript" src="/app/vendor/formvalidation/framework/bootstrap.min.js"></script>
    <script>

        let questionCount = 0
        let questionsValidations =  {
                  validators: {
                    notEmpty: {
                        message: 'Please Select one answer.'
                     },
                  }
               }
        $(function () {
            
            let sessionContactId = '${sessionScope.contactId}';
            let userId = 0
            if (sessionContactId) {
                userId = sessionContactId
            } 
            let contactId = parseInt(userId);
            if (contactId != 0) {
                $("#userId").val(contactId);
            } else {
                Swal.fire({
                    icon: 'error',
                    title: 'ERROR',
                    text: 'Please login again...!!!',
                }).then((result) => {
                    if (result.isConfirmed) {
                        window.location.href = "/signin"
                    }
                })
            }
            $("#userId").val(contactId);

            // Sign UP form Validation :::: START ::::
            const form = document.getElementById('signUpForm');
            $('#surveyForm').formValidation({
                framework: 'bootstrap',
                excluded: ":disabled",
                /*live:'disabled', */
                button: {
                    selector: "#submitBtn",
                    disabled: "disabled"
                },
                icon: null,
                fields: {
                    
                }
            });
            // Sign UP form Validation :::: ENDS ::::

            $('#submitBtn').click(function (e) {

                if ($('#surveyForm').data('formValidation').isValid() == null) {
                $('#surveyForm').data('formValidation').validate();
                }
                if ($('#surveyForm').data('formValidation').isValid() == true) {
                $('#submitBtn').attr("disabled", true);
                    saveSurveyFnc();
                }
            });

            getsurveyDetails()


        });

        saveSurveyFnc = () =>{
            $('#submitBtn').attr("disabled", true);
            var formData = JSON.parse(JSON.stringify(jQuery('#surveyForm').serializeArray()));
                console.log(formData);

                $.ajax({
                    type: "post",
                    url: "/survey/save",
                    data: formData,
                    success: function (response) {
                        if (response.status) {
                            Swal.fire({
                                icon: 'success',
                                title: 'Success',
                                text: response.message,
                                showConfirmButton: false,
                                timer: 1500
                            })
                            setTimeout(() => {
                                localStorage.setItem("isSurveyFilled", parseInt("1"));
                                    let signupBonus = parseFloat(localStorage.getItem("signupBonus"));
                                    let walletBalance = parseFloat(localStorage.getItem("walletBalance"));
                                    localStorage.setItem("walletBalance",walletBalance + signupBonus);
                                    window.location.href = "/home"
                            }, 1500);

                        } else {
                            Swal.fire({
                                icon: 'error',
                                title: 'Ooops...!!!',
                                text: response.message,
                                showConfirmButton: false,
                                timer: 1500
                            })
                            
                            setTimeout(() => {
                                window.location.href = "/home"
                            }, 1500);
                        }
                    }
                });
        }

        getsurveyDetails = () =>{

            $("#surveyDiv").empty();

            $.ajax({
                type: "get",
                url: "/survey/questions",
                success: function (data) {
                    if (data.status) {
                        $("#surveyDiv").empty();

                        let maincontent = "";
                        questionCount = data.response.length;
                        $.each(data.response, function (index, res) { 
                            let subcontent = "";
                            maincontent += ''+
                                            '<div class="col-12 pl-0 pr-1 py-1">\n'+
                                                '                            <div class="bg-white shadow-sm rounded px-2 py-3 c-it">\n'+
                                                '                                <div class="card" style="border: none;">\n'+
                                                '                                    <div class="card-body p-2">\n'+
                                                '                                        <h6 class="card-title">Q. '+res.surveyQuestion+'<span class="text-danger">*</span> </h6>\n'+
                                                '<input type="hidden" name="surveyAnswers['+index+'].surveyQuestionId"\n'+
                                                '                                                value="'+res.surveyQuestionId+'" ><div class="form-group">';

                                                $.each(res.surveyOptionVos, function (indexInArray, optionsVos) { 
                                                    subcontent += ''+
                                                    '<div class="custom-control custom-radio px-0 position-relative border-custom-radio">\n'+
                                                        '<input class="custom-control-input" type="radio" name="surveyAnswers['+index+'].surveyOptionId"\n'+
                                                        ' id="option'+optionsVos.surveyOptionId+'" value="'+optionsVos.surveyOptionId+'" >\n'+
                                                        '    <label class="custom-control-label w-100" for="option'+optionsVos.surveyOptionId+'">\n'+
                                                        '        '+optionsVos.surveyOption+'\n'+
                                                        '    </label>\n'+
                                                    '</div>\n';
                                                });

                                            maincontent += subcontent;
                                            maincontent +='                           </div></div>\n'+
                                                '                                </div>\n'+
                                                '                            </div>\n'+
                                                '                        </div>';

                           
                        });

                        $("#surveyDiv").append(maincontent);
                        $("#submitandresrtBtnDiv").removeClass("m--hide");

                        $.each(data.response, function (i, value) { 
                            $('#surveyForm').formValidation('addField', 'surveyAnswers['+i+'].surveyOptionId', questionsValidations);
                        });

                        $(".preloader-div").remove();

                    } else {

                        $(".preloader-div").remove();

                        Swal.fire({
                            icon: 'error',
                            title: 'Oops...',
                            text: 'No survey Details Found...!!!',
                        }).then((result) => {
                            if (result.isConfirmed) {
                                window.location.href="/home"
                            }
                        })
                        
                    }
                }
            });
        }

        let resetFormValidationsFnc =  () => {
                $("#surveyForm").trigger('reset');
				$('#surveyForm').data('formValidation').resetForm();
        }
    </script>
   <!-- Include Js END -->
   <script type="text/javascript" src="/app/vendor/sidebar/hc-offcanvas-nav.js"></script>
   <!-- Custom scripts for all pages-->
   <script src="/app/js/osahan.js"></script>
   <!-- sweet alert 2 CDN -->
   <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

</body>

</html>