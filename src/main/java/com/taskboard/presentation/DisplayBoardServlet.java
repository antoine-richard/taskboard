package com.taskboard.presentation;

import static com.taskboard.entities.Task.DONE;
import static com.taskboard.entities.Task.IN_PROGRESS;
import static com.taskboard.entities.Task.TODO;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taskboard.business.TaskboardService;

/**
 * Servlet handling the displaying of the taskboard
 */
@WebServlet("/board")
public class DisplayBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Initializes the database at startup
	 */
	@Override
	public void init() throws ServletException {
		TaskboardService.get().initTaskboard();
		super.init();
	}

	/**
	 * Gets the tasks
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("todo", 	   TaskboardService.get().findTasksByStatus(TODO));
		request.setAttribute("inProgress", TaskboardService.get().findTasksByStatus(IN_PROGRESS));
		request.setAttribute("done", 	   TaskboardService.get().findTasksByStatus(DONE));
		getServletContext().getRequestDispatcher("/board.jsp").forward(request, response);
	}

}
