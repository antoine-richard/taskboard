<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Taskboard</title>
	<link rel="stylesheet" href="styles/taskboard.css" />
	<script type="text/javascript" src="scripts/taskboard.js"></script>
</head>
<body>
	<div id="content">
		<div>
			<form name="addForm" action="add">
				New task: 
				<input type="text" name="label" id="label" size="50"></input>
				<a href="#" onclick="Taskboard.add()">Add</a>
			</form>
			<a href="reset">Reset</a>
		</div>
		<div class="column">
			<h1>To Do</h1>
			<c:forEach items="${todo}" var="task">
				<p>
					${task.label}
					<a href="inProgress?id=${task._id}">&gt;</a>
				</p>
			</c:forEach>
		</div>
		<div class="column">
			<h1>In Progress</h1>
			<c:forEach items="${inProgress}" var="task">
				<p>
					${task.label}
					<a href="done?id=${task._id}">&gt;</a>
				</p>
			</c:forEach>
		</div>
		<div class="column">
			<h1>Done</h1>
			<c:forEach items="${done}" var="task">
				<p>
					${task.label}
					<a href="remove?id=${task._id}">x</a>
				</p>
			</c:forEach>
		</div>
	</div>
</body>
</html>