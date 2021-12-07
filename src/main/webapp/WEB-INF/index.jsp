<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>Hello pets</h1>

	${allPets}

	<table class="table">
		<thead>
		  <tr>
			<th scope="col">ID</th>
			<th scope="col">Name</th>
			<th scope="col">Age</th>
			<th scope="col">Description</th>
			<th scope="col">Actions</th>
		  </tr>
		</thead>


		<tbody>

		<c:forEach items='${allPets}' var='p'>
			<tr>
				<th scope="row">${p.id}</th>
				<td> <a href="/pet/info/${p.id}">${p.name}</a></td>
				<td>${p.age}</td>
				<td>${p.description}</td>
				<td><a href="/pet/edit/${p.id}">Edit</a> | <a href="/pet/delete/${p.id}">Delete</a></td>
			</tr>
		
		</c:forEach>

		</tbody>
	  </table>

	  <a href="pets/new">create new pet</a>

</body>
</html>