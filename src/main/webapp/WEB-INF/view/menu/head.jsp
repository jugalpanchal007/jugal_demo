      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <meta name="description" content="">
      <meta name="author" content="">
      <link rel="icon" type="image/png" href="/app/img/logo.png">
     
      <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
      <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
      <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
      <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
      
      <!-- Slick Slider -->
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.css"/>
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick-theme.min.css" />
      
      <!-- Icofont Icon-->
      <link href="/app/vendor/icons/icofont.min.css" rel="stylesheet" type="text/css">
      <!-- Bootstrap core CSS -->
      <link href="/app/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
      <!-- Custom styles for this template -->
      <link href="/app/css/style.css" rel="stylesheet">
      <!-- Sidebar CSS -->
      <link href="/app/vendor/sidebar/demo.css" rel="stylesheet">
      <link rel="stylesheet" href="/app/vendor/formvalidation/formValidation.min.css">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.css"/>
      <link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" />
      <link  rel="stylesheet" href="/app/css/preloader-new.css" />
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" />
      <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDZki79RP5qfiGJk2SqlJdhZkQbLBFMnC8&libraries=places&v=weekly"></script> 
        <%-- <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCVSPNR1aP4M8sHStPjYzrJ2c-qiQH7G5I&libraries=places&v=weekly"></script> --%>
    
      <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">

      <style>
            .cartCount {
                  font-size: 10px;
                  background: #ff0000;
                  color: #fff;
                  padding: 3px !important;
                  vertical-align: top;
                  margin-left: -10px;
            }
            .badge {
                  padding-left: 9px;
                  padding-right: 9px;
                  -webkit-border-radius: 9px;
                  -moz-border-radius: 9px;
                  border-radius: 9px;
            }

            .label-warning[href],
            .badge-warning[href] {
            background-color: #c67605;
            }


            div#searchBarcode_listbox {
                  background-color: #fff;
                  z-index: 999999 !important;
                  max-height: 350px;overflow-y: auto;
            }

         .tt-menu{z-index: 999999 !important;max-height: 350px;overflow-y: auto;width:100% !important;position:static !important;}

         .tt-suggestion.tt-selectable {padding: 5px !important;}

         .tt-suggestion{
            background: #FFFFFF !important;
            font-weight: bold !important;
            width:100% !important;
            max-height: 100px !important;
        }

        .twitter-typeahead{
              position: relative;
            display: inline-block;
            width: 100%;
        }


            @media screen  and (min-width : 1024px){
                  .osahan-menu-fotter{
                        display: none;
                  }
            }

            @media screen  and (max-width : 1024px){
                  #subheader,#webFooter{
                        display: none;
                  }
            }
      </style>