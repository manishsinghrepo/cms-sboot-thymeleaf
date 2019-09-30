<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css"    href="/static/css/font.css">
<head>
<title>
Customer confirmation page
</title>

</head>
<body>
<h2>Customer has been Register successfully.</h2>
<br><br>
<table>
<tr><td>
<b>Customer name: </b>
</td>
<td>${customer.firstName} ${customer.lastName} </td>
</tr>
<tr><td>
<b>Customer State: </b>
</td>
<td>${customer.state}  </td>
</tr>
</table>
</br>

</body>

</html>





