<html>
<meta http-equiv="refresh" content="5">
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Common Infrastructure Smoke test</title>
<style type="text/css">
body {
	background-image: url('images/bg.png');
}
  div.table {
    display: table;
    width: calc(100% - 10px);
    
    padding: 5px;
  }
  div.spalte { 
    display: table-cell;
    
    vertical-align:middle;
    padding: 5px;
  }
  div.title {
  	font-size: 20;
  }
    div.smoke {
  	font-size: 40;
  }
  
  table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
  }
</style>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.js"></script>
<script type="text/javascript">

$(document).ready(function(){
    $('#checks td.y_n').each(function(){
        if ($(this).text() == '0') {
            $(this).css('background-color','#f00');
        }
        else{
        	$(this).css('background-color','#458b74');
        }
    });
});

</script>
</head>
<body>

  <div class="table">
      <div class="spalte" style="width: 401px"> <img border="0" src="images/pro7_logo.png"     alt="Pro7 Logo" width="304" height="228">  </div>
      <div class="spalte" style="font-size: 70">
      	<div class=title>Common Infrastructure</div>
      	<div class=Smoke>Smoke Test</div>
      	
      
      </div>
      
  </div>


	<br>
	<br>

	
	<table cellpadding="20" cellspacing="10" style="border: 3px;" rules="none" id="checks">
	
	
	<tr>
		<th>checkid.</th>
		<th>description</th>
		<th>Expected Min</th>
		<th>Expected Max</th>
		<th>Last Check Result</th>
		<th>Status OK</th>
	</tr>
		<c:forEach items="${listofchecks}" var="check" varStatus="index" >
		<tr>
			
			<td align="left"><c:out default="Not Available" value="${check.checkid}"/></td>
			<td align="left"><c:out default="Not Available" value="${check.description}"/></td>
			<td align="left"><c:out default="Not Available" value="${check.expectedresultMin}"/></td>
			<td align="left"><c:out default="Not Available" value="${check.expectedresultMax}"/></td>
			<td align="left"><c:out default="Not Available" value="${check.lastcheckresult}"/></td>
			<td class="y_n" align="left">${check.statusok}</td>
		</tr>
		
		
		</c:forEach>
</table>


</body>
</html>