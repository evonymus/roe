<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1"> 
            <link rel="stylesheet" href="<c:out value='res/css/bootstrap.min.css'/>">
                <script src="<c:out value='res/js/bootstrap.min.js'/>"> </script>
                <script src="<c:out value='res/js/jquery-2.1.4.min.js'/>"> </script>
                <script>
                    function getCurrency() {
                        $.ajax({
                                url: 'item/currencyList',
                                datType: "json",
                                success: function(data){
                                    $.each(data, function(i, currency) {
                                        $("#code").append('<option>' + currency.curCode + '</option>')
                                    });
                                }

                        });

                    }
                    $(document).ready(function() {
                        $("#test").html("<p>Hello</p>");
                        getCurrency();

                    });
                </script>
            </head>
            <body>
                <div class="container">
                    <div class="row">
                        <div class="well well-lg col-lg-12" id="header">
                            <h2 class="text-center text-primary">Rates Of Exchange</h2>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-4" id="nav">
                            <form:form id="menu">
                                Date:<input type=text id="datepicker" ><br/>
                            Code: <select id="code" name="code"></select>
                        </form:form>
                    </div>
                    <div id="test"></div>
                </div>
            </div>
        </body>
    </html>
