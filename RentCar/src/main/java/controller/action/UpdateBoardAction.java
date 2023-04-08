package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardRequestDto;
import board.controller.BoardDao;
import client.Client;

public class UpdateBoardAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int boardNum = Integer.parseInt(request.getParameter("board_number"));
		int type = Integer.parseInt(request.getParameter("type"));

		Client client = (Client) request.getSession().getAttribute("log");
		String boardWriter = client.getId();

		String title = request.getParameter("title");
		String content = request.getParameter("content");

		BoardDao boardDao = BoardDao.getInstance();
		BoardRequestDto dto = new BoardRequestDto(boardNum, type, boardWriter, title, content, null, null);

		boardDao.updateBoard(dto);

		if (type == 0)
			response.sendRedirect("notice");
		else
			response.sendRedirect("review");
	}

}
