<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<!DOCTYPE html>
<html>
<head>
<title>Cart</title>
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

<div align="center">
<h1>Shopping Cart</h1>
<table border="2" >

<tr>
			<th colspan="6">Cart</th>
</tr>
<tr>
    <th width="80" >Id</th>
    <th width="120">Name</th>
    <th width="120">Price</th>
    <th width="60">Quantity</th>
    <th width="80">Delete</th>
    <th width="220">Sub Total</th>

 
</tr>

<c:set var="total" value="0"></c:set>
<c:forEach var="pr" items="${sessionScope.cart}">
<c:set var="total" value="${total + pr.product.priceProduct * pr.product.quantityProduct}"></c:set>
<tr>
<td>${pr.product.idProduct }</td>
<td>${pr.product.nameProduct }</td>
<td>${pr.product.priceProduct }</td>
<td>${pr.product.quantityProduct }</td>
<td><a href="${pageContext.request.contextPath}/sell/deleteProduct/${pr.product.idProduct }" >Delete</a></td>
<td>${pr.product.priceProduct * pr.product.quantityProduct}</td>
</tr>


  
  
  
  
</c:forEach>

<tr><td colspan="5" align="right">Total</td>
<td>${total}</td>

</tr>
</table>
<a href="${pageContext.request.contextPath}/getAllProducts">Continue Shopping</a>  <br>

</div>



</body>
</html>
