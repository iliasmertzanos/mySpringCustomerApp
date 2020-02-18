<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Customer</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container1">
		<h3>Customer</h3>
	
		<form:form action="saveCustomer" modelAttribute="customer" method="POST">

			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td ><form:input path="firstName" disabled="true"/></td>
					</tr>
				
					<tr>
						<td><label>Last name:</label></td>
						<td><form:input path="lastName" disabled="true"/></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td ><form:input path="email" disabled="true"/></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		
	
	</div>
	
	<div id="container2">
		<h3>Save Address</h3>
	
		<form:form action="saveAddress" modelAttribute="address" method="POST">

			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Street:</label></td>
						<td><form:input path="street" /></td>
					</tr>
				
					<tr>
						<td><label>Number:</label></td>
						<td><form:input path="number" /></td>
					</tr>
					
					<tr>
						<td><label>Country:</label></td>
						<td><form:input path="country" /></td>
					</tr>
					
					<tr>
						<td><label>State:</label></td>
						<td><form:input path="state" /></td>
					</tr>
					
					<tr>
						<td><label>City:</label></td>
						<td><form:input path="city" /></td>
					</tr>
					
					<tr>
						<td><label>Postal code:</label></td>
						<td><form:input path="postCode" /></td>
					</tr>
					
					<tr>
						<td hidden="" > <label>customer id:</label></td>
						<td hidden="" ><form:input path="customer.id" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/address/list">Back to List</a>
		</p>
	</div>

</body>

</html>










