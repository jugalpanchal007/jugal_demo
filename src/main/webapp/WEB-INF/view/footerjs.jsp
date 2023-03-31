<!-- Bootstrap core JavaScript -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<script src="/app/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- slick Slider JS-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.js"></script>
<!-- Sidebar JS-->
<!-- Include JS START-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>

<script src="/app/js/globalscript.js"></script>

<!-- Include Js END -->
<script type="text/javascript" src="/app/vendor/sidebar/hc-offcanvas-nav.js"></script>
<!-- Custom scripts for all pages-->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="/app/js/osahan.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js" crossorigin="anonymous"
    referrerpolicy="no-referrer"></script>

<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery.lazy/1.7.9/jquery.lazy.min.js"></script>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery.lazy/1.7.9/jquery.lazy.plugins.min.js">
</script>

<script>
    $(function () {
        let a = '${session.contactId}'
        if(a){

        }else{
            //alert();
            localStorage.clear();
            window.location.redirect = "/userlogout";
        }
    });
</script>
<script>


    let BRANCH_SELECTION_FLAG = true;
    let latitude = "";
    let longitude = "";

        let default_latitude = 23.0235063;
        let default_longitude = 72.5323024;
    //search by location start
    getLocation();
    // var input = document.getElementById('maparea');
    // var autocomplete = new google.maps.places.Autocomplete(input);

    // google.maps.event.addListener(autocomplete, 'place_changed', function () {
    //     var place = autocomplete.getPlace();
    //     var lat = place.geometry.location.lat();
    //     var lng = place.geometry.location.lng();

    //     console.log(lat);
    //     console.log(lng);

    //     $("#lat").val(lat);
    //     $("#lng").val(lng);

    // });

    $("#maparea").change(function (e) {
        //alert(this.value);
        if (this.value == "") {
            $("#lat").val("");
            $("#lng").val("");
        }
    });

    //search by location end

    function getLocation() {
        if (navigator.geolocation) {
           // alert(navigator.geolocation);
            navigator.geolocation.getCurrentPosition(showPosition,showError,{timeout:1000});

        } else {
           // alert("ELSE");
            console.log("Geolocation is not supported by this browser.");
        }
        // if ('geolocation' in navigator) {
        //     navigator.geolocation.getCurrentPosition(showPosition,showError);
        // } else {
        //     console.log("Geolocation is not supported by this browser.");
        // }
    }

    function showPosition(position) {
        // x.innerHTML = "Latitude: " + position.coords.latitude + 
        // "<br>Longitude: " + position.coords.longitude;
        //alert("showPosition");
        console.log("Latitude: " + position.coords.latitude);
        console.log("Longitude: " + position.coords.longitude);
         latitude = position.coords.latitude;
         longitude = position.coords.longitude;

        $("#lat").val(position.coords.latitude);
        $("#lng").val(position.coords.longitude);

        

        //alert("showPosition");

        if (latitude) {
            
        } else {
            latitude = default_latitude;
        }

        if (longitude) {
            
        } else {
            longitude = default_longitude;
        }

        let contactIdForUpdateLatLng = '${sessionScope.contactId}'; 
        <c:if test = "${not empty sessionScope.contactId}" >
            try {
                updateLatLngAjax(${sessionScope.contactId}, latitude, longitude);
            } catch (error) {
                console.log(error);
            }
        </c:if>

        $("#lat_new").val(position.coords.latitude);
        $("#lng_new").val(position.coords.longitude);

        $("#lat_edit").val(position.coords.latitude);
        $("#lng_edit").val(position.coords.longitude);

        getBranchList(latitude,longitude)

        marktheMapFnc(latitude,longitude,'map_new');
        marktheMapFnc(latitude,longitude,'map_edit');

        getReverseGeocodingData(latitude,longitude);

        // var map = new GMaps({
        //     el: '#map',
        //     lat: latitude,
        //     lng: longitude
        // });

        // map.addMarker({
        //     lat: latitude,
        //     lng: longitude
        // });

       
                 

    }


    function showError(error) {
        let message = "";
        switch(error.code) {
            case error.PERMISSION_DENIED:
            message = "User denied the request for Geolocation."
            break;
            case error.POSITION_UNAVAILABLE:
            message = "Location information is unavailable."
            break;
            case error.TIMEOUT:
            message = "The request to get user location timed out."
                
            break;
            case error.UNKNOWN_ERROR:
            message = "An unknown error occurred."
            break;

            
        }

        $("#lat_new").val(default_latitude);
        $("#lng_new").val(default_longitude);

        $("#lat_edit").val(default_latitude);
        $("#lng_edit").val(default_longitude);

        getBranchList(default_latitude,default_longitude);

        console.log(message)
    }






    

    let updateLatLngAjax = (contactId, lat, lng) => {

        let data = {
            contactId: contactId,
            lat: lat,
            lng: lng
        }
        $.ajax({
            url: "/updatelatlng",
            type: "POST",
            data: data,
            success: function (data, status) {
                if (data.status) {
                    console.log(data.message);
                } else {
                    toastr.error('', data.message);
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                if (XMLHttpRequest.status == 0) {
                    toastr.error('', ' Check Your Network.');
                } else if (XMLHttpRequest.status == 404) {
                    toastr.error('', 'Requested URL not found.');
                } else if (XMLHttpRequest.status == 500) {
                    toastr.error('', 'Internel Server Error.');
                } else {
                    toastr.error('', 'Unknow Error.\n' + XMLHttpRequest.responseText);
                }
            }
        });
    }

    let getBranchList = (lat, lng) =>{

        let data = {
            lat: lat,
            lng: lng
        }
        console.log(data);
         $.ajax({
               url: "/user/branch/list",
               type: "POST",
               data: data,
               success: function(data,status) {
               if(data.status){
                  let content = "";
                  let branchList = data.response;
                  $("#branchSelection").empty();
                  let sessionBranchId = "${sessionScope.branchId}";

                  let sortedBranchlistWithLatLng = branchList.filter(branch => branch.lat != null);
                  console.log("aaw");
                  console.log(sortedBranchlistWithLatLng);
                    let sortedBranchlistWithOutLatLng = branchList.filter(branch => branch.lat);
                    console.log("aawo");
                  console.log(sortedBranchlistWithLatLng);


                     let sortedBranchlist = branchList.sort( alphabetically(true) );

                    console.log("sortedBranchlist");
                    console.log(sortedBranchlist);

                //   $.each(sortedBranchlist, function (indexInArray, userVo) { 
                //      let selected = 'selected';
                     
                //         // if (userVo.userfrontId == 2) {
                //         //    content  += '<option value="'+userVo.userfrontId+'" selected>'+userVo.name+'</option>';
                //         // } else {
                //         //    content  += '<option value="'+userVo.userfrontId+'">'+userVo.name+'</option>';
                //         // }

                //         if (sessionBranchId) {
                //            if (userVo.userfrontId == sessionBranchId) {
                //               content  += '<option value="'+userVo.userfrontId+'" selected>'+userVo.name+'</option>';
                //            } else {
                //               content  += '<option value="'+userVo.userfrontId+'">'+userVo.name+'</option>';
                //            }

                //         } else {
                //            if (userVo.userfrontId == 43) {
                //               content  += '<option value="'+userVo.userfrontId+'">'+userVo.name+'</option>';
                //            } else {
                //               content  += '<option value="'+userVo.userfrontId+'">'+userVo.name+'</option>';
                //            }

                //         }
                //         //content  += '<option value="'+userVo.userfrontId+'">'+userVo.name+'</option>';
                //   });



                    let selected = 'selected';
                    if (sessionBranchId) {

                        console.log("INSODE IFF");
                        for (let i = 0; i < sortedBranchlist.length; i++) {
                      
                            console.log("INSODE IFF loop");
                            if (sortedBranchlist[i].userfrontId == sessionBranchId) {
                                content  += '<option value="'+sortedBranchlist[i].userfrontId+'" selected>'+sortedBranchlist[i].name+'</option>';
                            } else {
                                content  += '<option value="'+sortedBranchlist[i].userfrontId+'">'+sortedBranchlist[i].name+'</option>';
                            }
                            
                        }      
                    }else{
                        console.log("INSODE ELSE");
                        for (let j = 0; j < sortedBranchlist.length; j++) {
                      
                            console.log("INSODE ELSE LOOp[");
                            if (j == 0 ) {
                                content  += '<option value="'+sortedBranchlist[j].userfrontId+'" selected>'+sortedBranchlist[j].name+'</option>';
                            } else {
                                content  += '<option value="'+sortedBranchlist[j].userfrontId+'">'+sortedBranchlist[j].name+'</option>';
                            }
                            
                        }     
                    }


                  $("#branchSelection").empty();
                  $("#branchSelection").append(content);

                        let branchId = $("#branchSelection").val();

                        console.log("branchId-->" + branchId);

                        if (branchId) {
                            $.ajax({
                                url: "/user/set/branch",
                                type:"GET",
                                data : {branchId : branchId},
                                success: function(res,status) {
                                    if(res.status){
                                    
                                        //toastr.success("BRANCH SET SUCCESSFULLY");
                                        CATEGORYLIST = [];
                                        PRODUCTLIST = [];
                                        CARTLIST = [];
                                        CATEGORY_IMAGE_URL = "";
                                        PRODUCT_IMAGE_URL = "";
                                        BEST_SELLING_ITEMS = [];
                                        
                                        getcategoryAndProductList(res.response)

                                    }else{
                                        toastr.error('',res.message);
                                        console.log(res.message);
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
                            console.log("Branch Id Is Not Found");
                        }

                  BRANCH_SELECTION_FLAG = false;


               }else{
                  // toastr.error('',data.message);
                  console.log(data.message);
                  
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


      let changeBranchSelection = (flag) =>{

                Swal.fire({
                title: 'Are you sure?',
                text: "You cart for this branch will be disgarded..!!!",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Yes, Change it!'
                }).then((result) => {
                    if (result.isConfirmed) {

                        let cont = `<div class="preloader-div">`+
                                        `<div class="preloaderBg" id="preloader" onload="preloader()">`+
                                            `<div class="preloader">`+
                                                `<div class="preloader2"></div>`+
                                            `</div>`+
                                        `</div>`+
                                    `</div>`;


                        $("body").prepend(cont);
                         let branchId = $("#branchSelection").val();

                        if (branchId) {
                            $.ajax({
                                url: "/user/set/branch",
                                type:"GET",
                                data : {branchId : branchId},
                                success: function(res,status) {
                                    if(res.status){
                                    
                                        //toastr.success("BRANCH SET SUCCESSFULLY");
                                        CATEGORYLIST = [];
                                        PRODUCTLIST = [];
                                        CARTLIST = [];
                                        CATEGORY_IMAGE_URL = "";
                                        PRODUCT_IMAGE_URL = "";
                                        BEST_SELLING_ITEMS = [];
                                        
                                        getcategoryAndProductList(res.response);

                                        //$(".preloader-div").remove();
                                        disgardCart();

                                    }else{
                                        toastr.error('',res.message);
                                        console.log(res.message);
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
                            console.log("Branch Id Is Not Found");
                        }
                    }else{
                        let sessionBranchId = "${sessionScope.branchId}";
                        $("#branchSelection").val(sessionBranchId);
                    }
                })

               

           
         



      }


    //   function compare( a, b ) {
    //     if (a.lat  && a.lng) {

    //         console.log("INSIDE first IF --->");
    //         if ( a.distance < b.distance ){
    //             console.log("INSIDE secone IF --->");
    //             return -1;
    //         }
    //         if ( a.distance > b.distance ){
    //             console.log("INSIDE tyhf IF --->");
    //             return 1;
    //         } 
    //     }else{

    //         console.log("INSIDE 111 IF --->");
    //         return 0;
    //     }
            
    //     }

    function alphabetically(ascending) {

  return function (a, b) {

    // equal items sort equally
    if (a.lat === b.lat) {
        return 0;
    }
    // nulls sort after anything else
    else if (!a.lat) {
        return 1;
    }
    else if (!b.lat) {
        return -1;
    }
    // otherwise, if we're ascending, lowest sorts first
    else if (ascending) {
        return a.distance < b.distance ? -1 : 1;
    }
    // if descending, highest sorts first
    else { 
        return a.distance < b.distance ? 1 : -1;
    }

  };

}


        let disgardCart = () =>{
            $.ajax({
                url: "/cart/disgardCart",
                type:"GET",
                success: function(res,status) {
                    if(res.status){
                    
                        toastr.success("CART DISGARDED SUCCESSFULLY");
                        $(".cartCount").html("0");
        

                    }else{
                        toastr.error('',res.message);
                        console.log(res.message);
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

        let getLocationByAutocomplete = (searchInputId,mapid,mapType) => {

            var input = document.getElementById(searchInputId);
            var autocomplete = new google.maps.places.Autocomplete(input);
            google.maps.event.addListener(autocomplete, 'place_changed', function() 
            {
                var place = autocomplete.getPlace();
                var lat = place.geometry.location.lat();
                var lng = place.geometry.location.lng();
                
                console.log(lat);
                console.log(lng);
                
                $("#lat_"+mapType).val(lat);
                $("#lng_"+mapType).val(lng);

                marktheMapFnc(lat,lng,mapid);
            });
        }


        let marktheMapFnc =  (lat,lng,mapid)=>{

            var myCenter = new google.maps.LatLng(lat,lng );
            var mapCanvas = document.getElementById(mapid);
            var mapOptions = {center: myCenter, zoom: 17,
            mapTypeId: google.maps.MapTypeId.TERRAIN
            }
            var map = new google.maps.Map(mapCanvas, mapOptions);
            var marker = new google.maps.Marker({position:myCenter});
            marker.setMap(map);
            var infowindow = new google.maps.InfoWindow({
            content:"You were here"
            });
            infowindow.open(map,marker);
        }

        function getReverseGeocodingData(lat, lng) {
            
            var latlng = new google.maps.LatLng(lat, lng);
            // This is making the Geocode request
            var geocoder = new google.maps.Geocoder();

            console.log(geocoder);
            geocoder.geocode({ 'latLng': latlng },  (results, status) =>{
                if (status !== google.maps.GeocoderStatus.OK) {
                    
                    alert(status);
                }
                // This is checking to see if the Geoeode Status is OK before proceeding
                if (status == google.maps.GeocoderStatus.OK) {
                    console.log(results);
                    var address = (results[0].formatted_address);
                }
            });
        }

        
</script>


<script src="https://cdn.onesignal.com/sdks/OneSignalSDK.js" async=""></script>

<style>
    #onesignal-bell-container.onesignal-reset {
       position: absolute !important;
        top: 66px !important;
        bottom: auto !important;
        z-index: 99999;
        left: auto !important;
        right: 30px !important;
    }

    #onesignal-bell-container.onesignal-reset .onesignal-bell-launcher.onesignal-bell-launcher-md .onesignal-bell-launcher-button {
        width: 32px !important;
        height: 32px !important;
    }
</style>
<c:if test = "${not empty sessionScope.contactId}" >
<script>
    $(function () {

        console.log("OneSignal Ready:");
        
        OneSignal.push(function () {
            console.log("OneSignal User Out1:");
            // Occurs when the user's subscription changes to a new value.
            OneSignal.on('subscriptionChange', function (isSubscribed) {
                console.log("OneSignal User Out2:" + isSubscribed);
                if (isSubscribed) {
                    console.log("OneSignal Out3 ID:" +  isSubscribed);
                    OneSignal.getUserId(function (userId) {
                        console.log("OneSignal User ID:" +  userId);
                        //alert("OneSignal User ID:" +  userId);
                        $.post("/onesignal/save", {
                            id: userId
                        }, function (data, status) {

                            console.log("User front ID:" + data);
                            var myCustomUniqueUserId = data;
                            OneSignal.push(function () {
                                OneSignal.setExternalUserId(myCustomUniqueUserId);
                            });
                            OneSignal.push(function () {
                                var id = OneSignal.getExternalUserId();
                                console.log("Get OneSignal User ID:",
                                    id);
                            });
                        });

                    });
                } else {
                    OneSignal.getUserId(function (userId) {
                        console.log("OneSignal User ID:"+ userId);
                        //alert("OneSignal User ID:"+ userId);
                        $.post("/onesignal/delete", {
                            id: userId
                        }, function (data, status) {
                            console.log("User front ID:" + data);

                        });

                    });
                }
                console.log("The user's subscription state is now:", isSubscribed);
            });

            // This event can be listened to via the `on()` or `once()` listener.
        });
    });
</script>

<script>
    window.OneSignal = window.OneSignal || [];
    OneSignal.push(function () {
        OneSignal.init({
            appId: '<spring:eval expression="@environment.getProperty('ONE_SIGNAL_APP_ID')"/>',
            safari_web_id: "",
            notifyButton: {
                enable: true,
                size: 'small', /* One of 'small', 'medium', or 'large' */
                theme: 'default', /* One of 'default' (red-white) or 'inverse" (white-red) */
                position: 'bottom-right',
                text: {
                    'tip.state.unsubscribed': '',
                    'tip.state.subscribed': "",
                    'tip.state.blocked': "",
                }
            },
            allowLocalhostAsSecureOrigin: true,
        });
    });
</script>
</c:if>





<!-- <script src="https://cdn.onesignal.com/sdks/OneSignalSDK.js" async=""></script>
<script>
window.OneSignal = window.OneSignal || [];
OneSignal.push(function() {
    OneSignal.init({
    appId: "d11a8ff3-eae2-4596-9195-fa99d6c2c13e",
    safari_web_id: "",
    notifyButton: {
        enable: true,
    },
    });
});
</script> -->