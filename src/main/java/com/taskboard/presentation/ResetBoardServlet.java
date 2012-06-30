package com.taskboard.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taskboard.business.TaskboardService;

/**
 * Servlet handling the board reset
 */
@WebServlet("/reset")
public class ResetBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Reset the data in the taskboard
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TaskboardService.get().resetTaskboard();
		response.sendRedirect("board");
	}

}
