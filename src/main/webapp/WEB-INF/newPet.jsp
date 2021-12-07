<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
			<!DOCTYPE html>
			<html>

			<head>
				<meta charset="UTF-8">
				<title>Insert title here</title>
			</head>

			<body>
				<h1>Create new pet</h1>
				
				<form:form action="/pets/create" method="post" modelAttribute="pett">
					<p>
						<form:label path="name">Name</form:label>
						<form:errors path="name"/>
						<form:input type = "text" path="name"/>
					</p>
					<p>
						<form:label path="description">Description</form:label>
						<form:errors path="description"/>
						<form:textarea path="description"/>
					</p>
					<p>
						<form:label path="age">age</form:label>
						<form:errors path="age" />
						<form:input type="number" path="age"/>
					</p>

					<input type="submit" value="Submit"/>
				</form:form>

			</body>

			</html>