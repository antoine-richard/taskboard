package com.sqli.taskboard.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sqli.taskboard.business.TaskboardService;

/**
 * Servlet handling task removing
 */
@WebServlet("/remove")
public class RemoveTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Delete the task identified by given id
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TaskboardService.get().remove(request.getParameter("id"));
		response.sendRedirect("board");
	}

}
