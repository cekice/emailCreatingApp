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
    <form:form method="POST" modelAttribute="product" action="/pohs/addProduct" commandName="product">
<table>
		<tr>
			<th colspan="2">Product</th>
		</tr>
		<tr>
	<form:hidden path="idProduct" />
          <td><form:label path="nameProduct">Product Name:</form:label></td>
          <td><form:input path="nameProduct" size="30" maxlength="30"></form:input></td>
        </tr>
		<tr>
			    <td><form:label path="priceProduct">Product Price:</form:label></td>
          <td><form:input path="priceProduct" size="30" maxlength="30"></form:input> BAM</td>
		</tr>  
                <tr>
			    <td><form:label path="quantityProduct">Quantity:</form:label></td>
          <td><form:radiobutton path="quantityProduct" value="1" />1 
              <form:radiobutton path="quantityProduct" value="2" />2
              <form:radiobutton path="quantityProduct" value="3" />3
          </td>
		</tr>
		<tr>
			<td colspan="2" ><input value="Submit" type="submit"
				class="blue-button" /></td>
		</tr>
	</table> 
</form:form>
</br>

<h3>Product List</h3>
<c:if test="${!empty listAllProducts}">
	<table class="tg">
	<tr>
		<th width="80">Product Id</th>
		<th width="120">Product Name</th>
		<th width="120">Product Price</th>
                <th width="60">Edit</th>
		<th width="60">Delete</th>
		<th width="60">Buy</th>

        </tr>
	<c:forEach items="${listAllProducts}" var="product">
		<tr>
			<td>${product.idProduct}</td>
			<td>${product.nameProduct}</td>
			<td>${product.priceProduct}</td>
			<td><a href="<c:url value='/updateProduct/${product.idProduct}' />" >Edit</a></td>
			<td><a href="<c:url value='/deleteProduct/${product.idProduct}' />" >Delete</a></td>
			<td><a href="<c:url value='/sell/ordernow/${product.idProduct}' />" >Buy</a></td>

                </tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>