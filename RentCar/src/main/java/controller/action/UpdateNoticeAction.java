package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardRequestDto;
import board.controller.BoardDao;
import client.Client;

public class UpdateNoticeAction implements Action{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int type = Integer.parseInt(request.getParameter("type"));
		Client client = (Client) request.getSession().getAttribute("log");
		String boardWriter = client.getId();
		System.out.println(boardWriter);
		String title = request.getParameter("title");
		System.out.println(title);
		String content = request.getParameter("content");
		System.out.println(content);
		
		BoardDao boardDao = BoardDao.getInstance();
		BoardRequestDto dto = new BoardRequestDto(0, type, boardWriter, title, content, null, null);
		boardDao.updateBoard(dto);
		
		response.sendRedirect("notice");
	}

}
