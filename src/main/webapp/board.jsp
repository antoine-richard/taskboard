<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Taskboard</title>
	<link rel="stylesheet" href="styles/taskboard.css" />
</head>
<body>
	<div id="content">
		<div>
			<form action="add">
				New task: 
				<input type="text" name="label" size="30"></input>
				<input type="submit" value="Add" />
			</form>
			<input type="button" value="Reset board" onclick="window.location='reset'"/>
		</div>
		<div class="column">
			<h1>To Do</h1>
			<c:forEach items="${todo}" var="task">
				<p>
					${task.label}
					<input type="button" value=">" onclick="window.location='inProgress?id=${task._id}'"/>
				</p>
			</c:forEach>
		</div>
		<div class="column">
			<h1>In Progress</h1>
			<c:forEach items="${inProgress}" var="task">
				<p>
					${task.label}
					<input type="button" value=">" onclick="window.location='done?id=${task._id}'"/>
				</p>
			</c:forEach>
		</div>
		<div class="column">
			<h1>Done</h1>
			<c:forEach items="${done}" var="task">
				<p>
					${task.label}
					<input type="button" value="X" onclick="window.location='remove?id=${task._id}'"/>
				</p>
			</c:forEach>
		</div>
	</div>
</body>
</html>