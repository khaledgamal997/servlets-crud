<%@ page import="java.util.*, com.khaled.servletdemo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>employee list</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
			<form action="EmployeeController" method="POST">
				<table>
					<tbody>
						<tr>
							<td><label>First Name</label></td>

							<td><input type="text" name="firstName"></td>
						</tr>
						<tr>
							<td><label>Last Name</label></td>

							<td><input type="text" name="lastName"></td>
						</tr>
						<tr>
							<td><label>Title</label></td>

							<td><input type="text" name="title"></td>
						</tr>
						<tr>
							<td><label></label></td>

							<td><input type="submit" name="save"></td>
						</tr>
					</tbody>
				</table>
			</form>
			<p>
				<a href="EmployeeController"> Back To Employees List</a>
			</p>
		</div>
	</div>

</body>
</html>