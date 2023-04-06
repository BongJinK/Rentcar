package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import client.ClientRequestDto;
import client.controller.ClientDao;

public class RegistAction implements Action{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String clientId = request.getParameter("client_id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String driver_code = request.getParameter("driver_code");
		String address = request.getParameter("address_roadNm") + " ";
		address += request.getParameter("address_detail") + " ";
		address += request.getParameter("address_extra");
		
		ClientRequestDto clientDto = new ClientRequestDto(driver_code, clientId, password, name, phone, address);
		
		ClientDao clientDao = ClientDao.getInstance();
		clientDao.createClient(clientDto);
		
		System.out.println("회원등록댐?");
		response.sendRedirect("/");
	}

}
