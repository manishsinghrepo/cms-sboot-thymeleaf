<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>Hello World - Student Form</title>
	<link rel="stylesheet" type="text/css"    href="${pageContext.request.contextPath}/resources/css/font.css">
	<link rel="stylesheet" type="text/css"    href="/css/font.css">
</head>

<body>
<div align="center">
	<form:form action="addCustomer" modelAttribute="customer">

       <table>
        <tr>
            <td>First Name </td>
            <td><form:input path="firstName" name="firstName" />
            <form:errors path="firstName" cssClass="error" />
            </td>
		</tr>
        <tr>
            <td>Last Name</td>
		 <td><form:input path="lastName" name="lastName"  />
		 <form:errors path="lastName" cssClass="error" />
		 </td>
		</tr>
        <tr>
                 <td>Gender </td>
                 <td><form:radiobuttons path="gender" items="${genderList}"  /></td>
           </tr>

	    <tr>
             <td>State</td>
    		 <td>
    		 <form:select path="state">
                           <form:option value="-" label="--Please Select"/>
                           <form:options items="${stateList}" />
              </form:select>
    		 </td>
    	</tr>
          <tr>
                 <td>Language </td>
         		 <td><form:checkboxes path="languages" items="${languageList}"  /></td>
           </tr>


		<tr>
		<td colspan="2">
		<input type="submit"  value="Submit"/>
		</td>
		</tr>

	</form:form>
</div>
</body>

</html>

