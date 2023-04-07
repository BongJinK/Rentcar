package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import client.Client;
import client.ClientRequestDto;
import client.controller.ClientDao;

public class UpdateInformation implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClientDao clientDao = ClientDao.getInstance();
		String driverCode = request.getParameter("driver_code");
		String id = request.getParameter("client_id");
		Client client = clientDao.getClientById(id);

		if (client != null) {
			String password = client.getPassword();

			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address_postNum") + ",";
			address += request.getParameter("address_roadNm") + ",";
			address += request.getParameter("address_jibun") + ",";
			address += request.getParameter("address_detail") + ",";
			address += request.getParameter("address_extra");

			ClientRequestDto clientDto = new ClientRequestDto(driverCode, id, password, name, phone, address);
			clientDao.updateClient(clientDto);

			client = clientDao.getClientById(id);
			request.getSession().setAttribute("log", client);

			response.sendRedirect("/");
		}
	}

}
