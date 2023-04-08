package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardRequestDto;
import board.controller.BoardDao;
import client.Client;

public class WriteBoardAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int type = Integer.parseInt(request.getParameter("type"));
		Client client = (Client) request.getSession().getAttribute("log");
		String boardWriter = client.getId();
		System.out.println(boardWriter);
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		BoardDao boardDao = BoardDao.getInstance();
		BoardRequestDto dto = new BoardRequestDto(0, type, boardWriter, title, content, null, null);
		boardDao.writeBoard(dto);

		if (type == 0)
			response.sendRedirect("notice");
		else
			response.sendRedirect("review");
	}

}
