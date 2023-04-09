package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vehicle.VehicleRequestDto;
import vehicle.controller.VehicleDao;

public class RegistVehicelAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("vehicle_name");
		int rate = Integer.parseInt(request.getParameter("hourly_rate"));
		String code = request.getParameter("vehicle_code");

		VehicleRequestDto dto = new VehicleRequestDto(null, name, rate, code, null, null);
		VehicleDao vehicleDao = VehicleDao.getInstance();
		vehicleDao.createVehicle(dto);

		response.sendRedirect("/rent");
	}

}
