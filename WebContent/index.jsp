<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Zendesk Coding Challenge</title>
<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.0/css/jquery.dataTables.css">
<style>
h1 {
	color: #65971D;
	text-align: center;
	font-family: serif;
}
table, td, th {
	border: 1px solid #65971D;
	font-family: sans-serif;
	text-align: center;
}
#outer {
	margin-left: auto; 
	margin-right: auto; 
	width: 70%; 
	border: 3px;
	background: rgb(243, 244, 248);
}
#example {
	cellspacing: 0;
	width: 100%;
}
#detail {
	padding-left: 10%;
    padding-right: 10%;
}
#id {
	font-family: sans-serif;
	background-color: gold;
    color: white;
    padding-left: 5%;
    padding-bottom: 1%;
    padding-top: 1%;
}
#subject {
	font-family: sans-serif;
	background-color: #65971D;
    color: white;
    padding-left: 5%;
    padding-right: 5%;
    padding-bottom: 1%;
    padding-top: 1%;
}
#description {
	font-family: sans-serif;
	background-color: rgb(243, 244, 248);
	font-size: inherit;
	padding-left: 5%;
	padding-right: 5%;
	padding-bottom: 3%;
    padding-top: 3%;
}
#btn {
    background-color: #65971D;
    color: white;
    padding: 15px 32px;
    text-align: center;
    display: inline-block;
    font-size: 16px;
}
</style>

<script type="text/javascript" src="//code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="//cdn.datatables.net/1.10.0/js/jquery.dataTables.js"></script>
<script type="text/javascript">

$(document).ready(function() {

	// the result block is hidden in order to put in the same page
	$("#detail").hide();
	
	// mouse over and out css when pointing the row of table
	$('#example').on('mouseover', 'tr', function(event){
    	$(this).css("background-color", "gold");
    });
	
	$('#example').on('mouseout', 'tr', function(event){
    	$(this).css("background-color", "initial");
    });
	
	// use dataTable library
    $("#example").dataTable( {
        "bProcessing": false,
        "bServerSide": false,
        "sort": "position",
        "sAjaxSource": "./TicketServlet",
        "aoColumns": [
            { "mDataProp": "id"},
            { "mDataProp": "subject"}
            ],
        
        // customized error message from dataTable (send email function is not included: just go to email page)
        "oLanguage": {
             "sEmptyTable":"Error!: Can't bring Zendesk Tickets. <br>"
                			+ "Please contact to "
                			+ "<a href='./email.jsp'>WooYoung@Zendesk</a> for solving this error"
            }
    } );
    
	// go to the the detail for clicked row of the dataTable 
    var oTable =  $('#example'). dataTable();
    $('#example').on('click', 'tr', function(event){
    	// the list block is hidden
    	$('#outer').hide();
    	
    	// individual detail div is shown
		$('#detail').show();
    	var oData = oTable.fnGetData(this);
    	
		document.getElementById("id").innerHTML = "ID&nbsp&nbsp&nbsp&nbsp" + oData.id + "</br>";
		document.getElementById("subject").innerHTML = "SUBJECT&nbsp&nbsp&nbsp&nbsp" + oData.subject + "</br>";
		document.getElementById("description").innerHTML = "<h3>DESCRIPTION: </h3>" + oData.description + "</br>";
	});	
	} );
</script>
</head>
<body>

<h1 >Zendesk Mobile Ticket Viewer<br><br></h1>
<!-- total list table -->
<table  id="outer">	<tr><td>
    <table id="example" class="display" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>ID</th>
                <th>Subject</th>
            </tr>
        </thead>       
    </table>
    </td></tr></table>
<!--individual ticket detail for clicked row -->
<div id="detail">
	<h3 id="id"></h3>
	<h3 id="subject"></h3>
	<h5 id="description"></h5>
<!-- 	button to go back to the list from the individual detail -->
	<input id="btn" type="button" onclick="location.href='./index.jsp';" value="Go to List" />
</div>
</body>
</html>