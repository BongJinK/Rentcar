package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import client.ClientRequestDto;
import client.controller.ClientDao;

public class ADupdateInfomation implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String driverCode = request.getParameter("driver_code");
		String id = request.getParameter("client_id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");

		String address = request.getParameter("address_postNum") + ",";
		address += request.getParameter("address_roadNm") + ",";
		address += request.getParameter("address_jibun") + ",";
		address += request.getParameter("address_detail") + ",";
		address += request.getParameter("address_extra");

		ClientDao clientDao = ClientDao.getInstance();
		ClientRequestDto clientDto = new ClientRequestDto(driverCode, id, password, name, phone, address);
		clientDao.updateClient(clientDto);

		response.sendRedirect("clientmanagement");
	}
}
