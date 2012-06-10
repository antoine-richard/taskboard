package com.sqli.taskboard.presentation;

import static com.sqli.taskboard.entities.Task.DONE;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sqli.taskboard.business.TaskboardService;

/**
 * Servlet handling the "done" status
 */
@WebServlet("/done")
public class TaskDoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Flags the task identified by the given id as "done"
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TaskboardService.get().updateTaskStatus(request.getParameter("id"), DONE);
		response.sendRedirect("board");
	}

}
