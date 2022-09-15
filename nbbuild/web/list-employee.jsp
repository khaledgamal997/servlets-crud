<%@ page import="java.util.*,com.khaled.servletdemo.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee table</title>
</head>
<%
List<Employee> emp = (List<Employee>) request.getAttribute("employee_list");
%>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>employee list</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
			<input type="button" value="Add Employee"
				onclick="window.location.href='add-employee-form.jsp';return false;">
			<table>
				<tr>
					<th>ID</th>
					<th>First name</th>
					<th>Last Name</th>
					<th>Title</th>
					<th>Action</th>
				</tr>
				<%
				for (Employee e : emp) {
				%>
				<tr>
					<td><%=e.getId()%></td>
					<td><%=e.getFirstName()%></td>
					<td><%=e.getLastName()%></td>
					<td><%=e.getTitle()%></td>
					<td><a
						href="EmployeeController?command=LOAD&employeeId=<%=e.getId()%>">Update</a>|
						<a
						href="EmployeeController?command=DELETE&employeeId=<%=e.getId()%>"
						onclick="if(!(confirm('Are you sure you want to delete this employee:<%=e.getId()%>'))) return false">Delete</a></td>

				</tr>
				<%
				}
				%>

			</table>
		</div>
	</div>
</body>
</html>