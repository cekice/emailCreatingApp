<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<style>           
.blue-button{
	background: #25A6E1;
	filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#25A6E1',endColorstr='#188BC0',GradientType=0);
	padding:3px 5px;
	color:#fff;
	font-family:'Helvetica Neue',sans-serif;
	font-size:12px;
	border-radius:2px;
	-moz-border-radius:2px;
	-webkit-border-radius:4px;
	border:1px solid #1A87B9
}     
table {
  font-family: "Helvetica Neue", Helvetica, sans-serif;
   width: 50%;
}
th {
  background: SteelBlue;
  color: white;
}
 td,th{
                border: 1px solid gray;
                width: 25%;
                text-align: left;
                padding: 5px 10px;
            }
</style>
</head>
<body>
    <form:form method="POST" modelAttribute="customer" action="/pohs/addCustomer" commandName="customer">
<table>
		<tr>
			<th colspan="2">Customer</th>
		</tr>
		<tr>
	<form:hidden path="idCustomer" />
          <td><form:label path="nameCustomer">Customer Name:</form:label></td>
          <td><form:input path="nameCustomer" size="30" maxlength="30"></form:input></td>
        </tr>
		<tr>
			    <td><form:label path="passCustomer">Password:</form:label></td>
          <td><form:input type="password" path="passCustomer" size="30" maxlength="30"></form:input></td>
		</tr>
              <tr>
			    <td><form:label path="genderCustomer">Gender:</form:label></td>
          <td><form:radiobutton path="genderCustomer" value="Male" />Male
              <form:radiobutton path="genderCustomer" value="Female" />Female</td>
		</tr>
                        
		<tr>
			<td colspan="2" ><input value="Submit" type="submit"
				class="blue-button" /></td>
		</tr>
	</table> 
</form:form>
</br>
<h3>Customer List</h3>
<c:if test="${!empty listAllCustomers}">
	<table class="tg">
	<tr>
		<th width="80">Choose</th>
                <th width="80">Id</th>
		<th width="120">Customer Name</th>
		<th width="120">Password</th>
		<th width="60">Gender</th>
                <th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listAllCustomers}" var="customer">
		<tr>
                        <td><a href="<c:url value='/getAllProducts' />" >Choose</a></td>
			<td>${customer.idCustomer}</td>
			<td>${customer.nameCustomer}</td>
			<td>${customer.passCustomer}</td>
                        <td>${customer.genderCustomer}</td>
			<td><a href="<c:url value='/updateCustomer/${customer.idCustomer}' />" >Edit</a></td>
			<td><a href="<c:url value='/deleteCustomer/${customer.idCustomer}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>