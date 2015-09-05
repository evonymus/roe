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
                                    </div>
                                    <div class="form-group">
                                        <label for="dateTo">Date To:</label>
                                        <input name="dateTo" placeholder=" date to" value="" id="dateTo" type="text" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label for="country">Country</label>
                                        <select name="country" id="country" class="form-control" placeholder="country"></select>
                                    </div>
                                </form:form>
                            </div>
                            <div id="test"></div>
                        </div>
                    </div>
                </body>

                <script src="<c:out value='res/js/bootstrap.min.js'/>"> </script>
                <script src="<c:out value='res/js/jquery-2.1.4.min.js'/>"> </script>
                <script src="<c:out value='res/js/jquery.datetimepicker.js'/>"> </script>
                <script>
                    $('#dateFrom').datetimepicker({
                    });

                    $('#dateTo').datetimepicker({
                    });

                    $('#country').change(function() {
                        var id = $(this).children(":selected").attr("id");
                        alert(id);
                    });
                    function getCurrency() {
                        $.ajax({
                                url: 'service/countryList',
                                datType: "json",
                                success: function(data){
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
