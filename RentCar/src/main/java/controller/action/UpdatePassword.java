package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import client.Client;
import client.controller.ClientDao;

public class UpdatePassword implements Action{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("client_id");
		String password = request.getParameter("password");
		
		ClientDao clientDao = ClientDao.getInstance();
		clientDao.updatePasswordById(id, password);

		Client client = clientDao.getClientById(id);
		request.getSession().setAttribute("log", client);
		
		response.sendRedirect("/");
		
	}

}
