//const BASEURL = "http://localhost:8080/api/ecommerce";
const BASEURL = "https://erp.rrmart.in/api/ecommerce";

function getCountryList(id) {
    try {
        $.get(BASEURL+"/country",
            function(response) {
                if (response.status) {
                    $('#'+id).empty();
                    $('#'+id).append("<option></option>");
                    $.each(response.response, function(indexInArray, country) {
                        var newOption = new Option(country.countriesName, country.countriesCode, false, false);
                        $('#'+id).append(newOption);
                    });
                    if ($('#' + id).data("default") != undefined){
                        $('#' + id).val($('#' + id).data("default")).trigger('change');
                    }else{
                        $('#'+id).val("IN").trigger('change');
                    }
                }
                
                
                // var selectedCountry = $('#'+id).val();
                //getStateList(selectedCountry);
            },
        );

        return true;
    } catch (error) {
        console.log(error);
        return false;
    }

    
}

function getStateList(countryid,stateid) {
    var countryCode = $('#'+countryid).val();
    if (countryCode) {
        $.get(BASEURL+"/state/" + countryCode,
            function(response) {

                if (response.status) {
                    $('#'+stateid).empty();
                    $('#'+stateid).append("<option></option>");
                    $.each(response.stateList, function(indexInArray, state) {
                        var newOption = new Option(state.stateName, state.stateCode, false, false);
                        $('#'+stateid).append(newOption);
                    });
                    if ($('#' + stateid).data("default") != undefined){
                        $('#' + stateid).val($('#' + stateid).data("default")).trigger('change');
                    }else{
                        $('#'+stateid).val("24").trigger('change');
                    }
                    //$('#'+stateid).val("").trigger('change');
                    // var selectedState = $('#'+stateid).val();
                    //getCityList(selectedState);
                } else {
                    
                }
                
            },
        );
    } else {
        console.log("Country Not Selected");
    }
}

function getCityList(stateid,cityid) {
    var stateCode = $('#'+stateid).val();
    if (stateCode) {
        $.get(BASEURL+"/city/" + stateCode,
            function(response) {
                if (response.status) {
                    $('#'+cityid).empty();
                    var defaultOption = new Option();
                    $('#'+cityid).append(defaultOption);
                    $.each(response.cityList, function(indexInArray, city) {
                        var newOption = new Option(city.cityName, city.cityCode, false, false);
                        $('#'+cityid).append(newOption);
                    });
                    if ($('#' + cityid).data("default") != undefined){
                        $('#' + cityid).val($('#' + cityid).data("default")).trigger('change');
                    }else{
                        $('#'+cityid).val("938").trigger('change');
                    }
                    //$('#'+cityid).val("").trigger('change');
                    // var selectedCity = $('#'+cityid).val();
                } else {
                    
                }
            },
        );
    } else {
        console.log("State Not Selected");
    }
}

// function homeaddress(checked) {
//     if (checked) {
//         $('#homeAddress').val($('#currentAddress').val()).trigger('input');
//         $('#homeCountriesCode').val($('#currentCountriesCode').val()).trigger('change');
//         setTimeout(function(){
//             $('#homeStateCode').val($('#currentStateCode').val()).trigger('change');
//         }, 500);
//         setTimeout(function(){
//             $('#homeCityCode').val($('#currentCityCode').val()).trigger('change');
//             //$('#homeStateCode').val($('#currentStateCode').val()).trigger('change');
//         }, 1000);
//         $('#homePinCode').val($('#currentPinCode').val()).trigger('input');
//     }
// }

$('#countriesCode').change(function(e) {
    var countriesCode = $('#countriesCode').val();
    if(countriesCode != ''){
    	getStateList(countriesCode);
    }
    else{
    	$('#stateCode').val("").trigger('change');
    }
});

$('#stateCode').change(function(e) {
    var stateCode = $('#stateCode').val();
    if(stateCode != ''){
    	getCityList(stateCode);
    }
    else{
    	$('#cityCode').val("").trigger('change');
    }
});
