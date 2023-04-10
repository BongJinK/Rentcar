function reservation(htmlForm) {

	let bookingdate = document.getElementById('booking_date').value;
	let returndate = document.getElementById('return_date').value;
	
	let bookingTime = document.getElementById('booking_time').value.split(":");
	let returnTime = document.getElementById('return_time').value.split(":");

	const start = new Date(bookingdate);
	start.setHours(parseInt(bookingTime[0]));
	start.setMinutes(parseInt(bookingTime[1]));
	
	const end = new Date(returndate);	
	end.setHours(parseInt(returnTime[0]));
	end.setMinutes(parseInt(returnTime[1]));
	
	const currentDate = new Date();
	
	console.log("start : ", start);
	console.log("end : ", end);
	console.log("end < start : ",end < start);
	console.log("end.getTime < start.getTime : ",end.getTime() < start.getTime());
	console.log("start.getTime() < currentDate.getTime() : ", start.getTime() < currentDate.getTime());
	
	let gap = end.getTime() - start.getTime();
	gap = gap / (1000 * 60 * 60);
	console.log(gap);
	
	if (start < currentDate) {
		alert("대여일은 현재 시간 이후로 선택하여 주세요.")
		return;
	} else if (end.getTime() < start.getTime()) {
		alert("반납일은 대여일보다 빠를 수 없습니다.")
		return;
	} else if (start.getTime() < currentDate.getTime()) {
		alert("대여시간은 현재 시간 이후로 선택하여 주세요.")
		return;
	}

	htmlForm.time_diff.value = gap;
	htmlForm.submit();
}