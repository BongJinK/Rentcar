package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.controller.BoardDao;

public class RemoveNoticeAction implements Action{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("board_number"));
		
		BoardDao dao = BoardDao.getInstance();
		dao.deleteBoardtByBoardNum(num);
		
		response.sendRedirect("notice");
	}

}
