package controller.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import booking.BookingRequestDto;
import booking.controller.BookingDao;
import client.Client;

public class ReserveVehicleAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		int rentalTime = Integer.parseInt(request.getParameter("time_diff"));

		Client client = (Client) request.getSession().getAttribute("log");
		String clientId = "";
		String driverCode = "";
		if (client != null) {
			clientId = client.getId();
			driverCode = client.getDriverCode();
		}

		String bookingDate = request.getParameter("booking_date");
		String returnDate = request.getParameter("return_date");
		String bookingTime = request.getParameter("booking_time");
		String returnTime = request.getParameter("return_time");
		String bookingStr = bookingDate + " " + bookingTime;
		String returnStr = returnDate + " " + returnTime;
		Date bkDate = null;
		Date reDate = null;
		Timestamp bookDateTime = null;
		Timestamp returnDateTime = null;
		try {
			bkDate = sdf.parse(bookingStr);
			if (bkDate != null)
				bookDateTime = new Timestamp(bkDate.getTime());

			reDate = sdf.parse(returnStr);
			if (reDate != null)
				returnDateTime = new Timestamp(reDate.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		String vehicleCode = request.getParameter("vehicle_code");

		BookingRequestDto dto = new BookingRequestDto(rentalTime, clientId, bookDateTime, returnDateTime, driverCode,
				vehicleCode);
		BookingDao dao = BookingDao.getInstance();
		dao.createBooking(dto);

		response.sendRedirect("/");
	}

}
