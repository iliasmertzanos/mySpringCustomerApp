<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List of Customer addresses</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>List of customer addresses</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<input type="button" value="Add address"
				   onclick="window.location.href='showFormForAddAddress?customerId=${customerId}'; return false;"
				   class="add-button"
			/>
			<input type="button" value="Back to customers"
				   onclick="window.location.href='list'; return false;"
				   class="add-button"
			/>
			<table>
				<tr>
					<th>Street</th>
					<th>Number</th>
					<th>Country</th>
					<th>State</th>
					<th>City</th>
					<th>Postal code</th>
				</tr>
				
				<!-- loop over and print our customer addresses -->
				<c:forEach var="tempAddresses" items="${addresses}">					
					<tr>
						<td> ${tempAddresses.street} </td>
						<td> ${tempAddresses.number} </td>
						<td> ${tempAddresses.country} </td>
						<td> ${tempAddresses.state} </td>
						<td> ${tempAddresses.city} </td>
						<td> ${tempAddresses.postCode} </td>						
					</tr>				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









