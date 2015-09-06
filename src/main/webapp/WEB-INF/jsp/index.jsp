<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1"> 
            <link rel="stylesheet" href="<c:out value='res/css/bootstrap.min.css'/>">
                <link rel="stylesheet" href="<c:out value='res/css/jquery.datetimepicker.css'/>">
                <link rel="stylesheet" href="<c:out value='res/css/style.css'/>">
                </head>
                <body>
                    <div class="container">
                        <div class="row">
                            <div class="well well-lg col-lg-12 col-md-12" id="header">
                                <h2 class="text-center text-primary">Per Diem Calculator</h2>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-4 col-md-4">
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
                                    <div class="form-group">
                                        <label for="breakfast">Breakfasts NOT included
                                        </label>
                                        <input class="form-control" type="text" id="breakfast" value="0" name="breakfast">
                                    </div>
                                </form:form>
                                <div id="img">
                                    <img class="round" src="<c:out value='res/img/blue_earth.png'/>" alt="globe">
                                </div>
                            </div>
                            <div id="perDiem" class="col-lg-8 col-md-8 "></div>
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
                        //getPerDiem(id);
                        calculate();
                    });

                    $('#breakfast').blur(function() {
                        calculate();
                    })

                    function calculate() {
                        $('#dateFromMessage').empty();
                        if (dateFrom && dateTo) {
                            var diff= new Date(dateTo - dateFrom);
                            var id = $('#country option:selected').attr('id');
                            if (diff > 0 && id > 0 ) {
                                var breakfast=parseInt($('#breakfast').val());
                                if (breakfast==NaN) {
                                    breakfast = 0;
                                    $('#breakfast').val(0);
                                }
                                console.log(breakfast);
                                var address= 'perDiem/'+dateFrom.getTime() +'/'+dateTo.getTime()+'/'+ id + '/' + breakfast;
                                console.log(address);
                                $.ajax({
                                        url: 'perDiem/'+dateFrom.getTime() +'/'+dateTo.getTime()+'/'+ id + '/' + breakfast,
                                        dataType: "json",
                                        success: function(data) {
                                            $('#perDiem').empty();
                                            var v_dateFrom = new Date(data.dateFrom);
                                            var v_dateTo = new Date(data.dateTo);
                                            $('#perDiem').addClass("well");
                                            var res="<div class='well'><h3 class='text-center text-primary'> Settlement </h3><br/>"
                                            + "<h4 class='text-center text-success'> Basic Elements</h4>"
                                            + "<table class='table'><tr><th>Date From</th><th>Date To</th><th>Currency</th><th>Rate</th></tr>"
                                            + "<tr><td>"+v_dateFrom.toISOString() +"</td><td>" + v_dateTo.toISOString() + "</td><td>"+ data.roe.code 
                                            + "</td><td>"+data.perDiem.rate+"</td></tr></table><br/>"
                                            + "<h4 class='text-center text-warning'> Rate Of Exchange</h4></br>"
                                            + "<table class='table'><tr><th>Tab.No</th><th>Published</th><th>Currency</th><th>ROE</th></tr>"
                                            + "<tr><td>"+data.roe.tabId +"</td><td>" + data.roe.published + "</td><td>"+ data.roe.code + "</td><td>"+data.roe.roe+"</td></tr></table><br/>"
                                            + "<h4 class='text-center text-danger'> Calculation Results</h4></br>"
                                            + "<table class='table'><tr><th>Days</th><th>Hours</th><th>Total Per Diem</th><th>Breakfast</th><th>Due in " 
                                                + data.roe.code +"</th><th>Due in PLN</th></tr>"
                                                + "<tr><td>"+data.days+"</td><td>" + data.hours + "</td><td>"+data.totalPerDiem + '</td><td>'+ data.breakfastDeduction + '</td><td>'
                                                + data.dueInCurrency + "</td><td>"+data.dueInPLN +"</td></tr></table><br/>"
                                            + "</div>";
                                            $('#perDiem').append(res);

                                        }
                                });
                            } else {
                                if (diff < 0) {
                                    $('#dateFromMessage').append('<p class="text-danger">Date From must be earlier than date to</p>');
                                }
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
                                        $('#perDiem').empty();
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
