package com.taskboard.presentation;

import static com.taskboard.data.Task.IN_PROGRESS;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taskboard.business.TaskboardService;

/**
 * Servlet handling the "in progress" status
 */
@WebServlet("/inProgress")
public class TaskInProgressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Flags the task identified by the given id as "in progress"
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TaskboardService.get().updateTaskStatus(request.getParameter("id"), IN_PROGRESS);
		response.sendRedirect("board");
	}

}
