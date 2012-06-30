package com.taskboard.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taskboard.business.TaskboardService;

/**
 * Servlet handling task removing
 */
@WebServlet("/add")
public class AddTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Delete the task identified by given id
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String label = request.getParameter("label");
		TaskboardService.get().add(label);
		response.sendRedirect("board");
	}

}
