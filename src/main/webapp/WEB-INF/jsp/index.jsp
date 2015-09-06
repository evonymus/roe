<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1"> 
            <link rel="stylesheet" href="<c:out value='res/css/bootstrap.min.css'/>">
                <link rel="stylesheet" href="<c:out value='res/css/jquery.datetimepicker.css'/>">
                </head>
                <body>
                    <div class="container">
                        <div class="row">
                            <div class="well well-lg col-lg-12" id="header">
                                <h2 class="text-center text-primary">Rates Of Exchange</h2>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-4">
                                <form:form id="form" role="form">
                                    <div class="form-group">
                                        <label for="dateFrom">Date From</label>
                                        <input type="text" placeholder="date from" class="form-control" value="" name="dateFrom" id="dateFrom">
                                        <div id="dateFromMessage"></div>
                                    </div>
                                    <div class="form-group">
                                        <label for="dateTo">Date To:</label>
                                        <input name="dateTo" placeholder=" date to" value="" id="dateTo" type="text" class="form-control">
                                        <div id="dateToMessage"></div>
                                    </div>
                                    <div class="form-group">
                                        <label for="country">Country</label>
                                        <select name="country" id="country" class="form-control" placeholder="country"></select>
                                    </div>
                                </form:form>
                            </div>
                            <div id="perDiem" class="col-lg-8 "></div>
                        </div>
                    </div>
                </body>

                <script src="<c:out value='res/js/bootstrap.min.js'/>"> </script>
                <script src="<c:out value='res/js/jquery-2.1.4.min.js'/>"> </script>
                <script src="<c:out value='res/js/jquery.datetimepicker.js'/>"> </script>
                <script>
                    var dateFrom;
                    var dateTo;
                    $('#dateFrom').datetimepicker({
                            timepicker:false,
                            onChangeDateTime:function(dp,$input) {
                                var newDateFrom = new Date($input.val());
                                if (newDateFrom != dateFrom) {
                                    dateFrom = newDateFrom;
                                    calculate();
                                }
                            },
                            timepicker:false
                    });

                    $('#dateTo').datetimepicker({
                            timepicker:false,
                            onChangeDateTime:function(dp,$input) {
                                var newDateTo=new Date($input.val());
                                if (newDateTo != dateTo) {
                                    dateTo = newDateTo;
                                    calculate();
                                }
                            },
                            timepicker:false
                    });

                    $('#country').change(function() {
                        var id = $(this).children(":selected").attr("id");
                        getPerDiem(id);
                    });

                    function calculate() {
                        $('#dateFromMessage').empty();
                        if (dateFrom && dateTo) {
                            var diff= new Date(dateTo - dateFrom);
                            if (diff < 0) {
                                $('#dateFromMessage').append('<p class="text-danger">Date From must be earlier than date to</p>');
                            } else {
                                var id = $('#country').children(":selected").attr("id");
                                var adress='perDiem/'+dateFrom.toISOString() +'/'+dateTo.toISOString()+'/'+ id;
                                alert(adress);
                                $.ajax({
                                    url:'perDiem/'+dateFrom.toISOString() +'/'+dateTo.toISOString()+'/'+ id,
                                    dataType: "json",
                                    success: function(data) {
                                        $('#perDiem').append('<p>'+data.dueInCurrency + '</>');
                                    }

                                });
                            }
                        }
                    }

                    function getPerDiem(idCountry) {
                        $('#perDiem').empty();
                        if(idCountry) {
                            $.ajax({
                                    url: 'perDiem/'+ idCountry,
                                    dataType: "json",
                                    success: function(data) {
                                        $('#perDiem').addClass("well");
                                        var res = "<h4 class='text-center text-primary'> Per Diem Data</h4><table class='table' > <tr><th>Currency</th><th>Code</th><th>Rate</th></tr><tr><td>" 
                                        + data.currency.name + "</td><td>" + data.currency.code + "</td><td>" + data.rate + "</td></tr></table>";

                                        $('#perDiem').append(res);
                                    }
                            });
                        }
                    }
                    function getCurrency() {
                        $.ajax({
                                url: 'service/countryList',
                                datType: "json",
                                success: function(data){
                                    $("#country").append('<option></option>');
                                    $.each(data, function(i, country) {
                                        $("#country").append('<option id=' + country.id + ' >' + country.name + '</option>')
                                    });
                                }
                        });

                    }
                    $(document).ready(function() {
                        getCurrency();
                    });
                </script>
            </html>
