<script src="/app/typehead/handlebars.js"></script>
<script src="/app/typehead/typeahead.bundle.js"></script>

<script>
      $( document ).ready(function() {
            //getBranch();
            reintittypeahead();
            // setHomeData(0);
      });

      // let getBranch = () =>{
      //       $.ajax({
      //             type: "get",
      //             url: "/branchlist",
      //             success: function (data) {
      //                   if (data.status) {
      //                         setBranchData(data.response);
      //                   } else {

      //                   }
      //             }
      //       });
      // }

      // let setBranchData = (catList) => {
      //       $("#branch").empty();
      //       if (catList != null) {

      //             $.each(catList.branchList, function (key, value) {
      //                   if("${companyId}"==value.userFrontId){
      //                         $("#branch").append($('<option selected></option>').val(value.userFrontId).html(value.name));
      //                   }else{
      //                         $("#branch").append($('<option></option>').val(value.userFrontId).html(value.name));
      //                   }

      //             });
      //             getBestSellingItem();

      //       } else {

      //       }
      // }

      function reintittypeahead(){

            $("#searchBarcode").typeahead("destroy");
            var a = $("#searchBarcode").val();

            $('#searchBarcodediv').text("");
            $('#searchBarcodediv').html('<input type="text" autofocus="" class="form-control" placeholder="Search for Products.." id="searchBarcode" tabindex="1" autocomplete="off" spellcheck="false" dir="auto" value="' + a + '">');

            var n = new Bloodhound({
                  datumTokenizer: Bloodhound.tokenizers.obj.whitespace("value"),
                  queryTokenizer: Bloodhound.tokenizers.whitespace,
                  prefetch: '/json/product43.json',
                  limit: 100

            });
             //alert("V!!!");

            var myTypeahead=  $("#searchBarcode").typeahead({
                  hint: !0,
                  highlight: !0,
                  minLength: 1,
                  limit: 100
            }, {
                  name: "Product",
                  display: "value",
                  limit: 100,
                  source: n,
                  templates: {
                        suggestion: Handlebars.compile('<div title="{{value}}"><strong>{{value}}</strong></div>')
                  }
            }).on('typeahead:selected', function (event, selection) {
                  myTypeahead.typeahead('val', '');
                  sell(selection.id,selection.categoryId);
            });
      }
      function sell(id,categoryId){
            window.location.href='/product/details?productId='+id+'&categoryId='+categoryId;
            
      }
      // function setHomeData(id){
      //       if(id==1){
      //             setcartBlank();
      //       }else {
      //             getBestSellingItem();
      //       }
      // }
      // function setcartBlank(){

      //       swal({
      //             title: "Are you sure to change Store?",
      //             text: "Cart will be empty, You won't be able to revert this!",
      //             type: "warning",
      //             showCancelButton: !0,
      //             confirmButtonText: "Yes"
      //   selected    }).then(function (e) {
      //             if (e.value) {
      //                   $.ajax({
      //                         type: "get",
      //                         url: "/changesession",
      //                         data :{
      //                               branchId: $("#branch").val()
      //                         },
      //                         success: function (data) {
      //                               if (data.status) {

      //                               } else {

      //                               }
      //                         }
      //                   });
      //                   getBestSellingItem();
      //                   //$("#sales_form").submit();

      //             } else {
      //             }
      //       })
      // }
</script>