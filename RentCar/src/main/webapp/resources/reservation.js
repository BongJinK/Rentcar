function reservation(htmlForm) {

	let bookingdate = document.getElementById('booking_date');
	let returndate = document.getElementById('return_date');
	let bookingTime = document.getElementById('booking_time');
	let returnTime = document.getElementById('return_time');

	let now = new Date();
	let currentDate = new Date(now.getFullYear(), now.getMonth(), now.getDate());
	let currentTime = now.getTime();

	let bdValue = new Date(bookingdate.value);
	let rdValue = new Date(returndate.value);
	// 오류방지 최초시간대로 설정
	let btValue = new Date(`1970-01-01T${bookingTime.value}`);
	let rtValue = new Date(`1970-01-01T${returnTime.value}`);

	if (bdValue < currentDate) {
		alert("렌트일은 오늘 날짜 이후로 선택하여 주세요.")
		return;
	} else if (rdValue <= bdValue) {
		alert("반납일은 대여일 이후로 선택하여 주세요.[최소 1일 렌트]")
		return;
	} else if (btValue.getTime() === currentDate.getTime() && btValue.getTime() < currentTime) {
		alert("대여시간은 현재 시간 이후로 선택하여 주세요.")
		return;
	}
	
	let timeDiff = rtValue.getTime() - bdValue.getTime();
	let timeDiffHour = Math.ceil(timeDiff / ( 1000 * 60 * 60 )) ;

	htmlForm.booking_date.value = bdValue.toISOString().split(0, 10);
	htmlForm.return_date.value = rdValue.toISOString().split(0, 10);
	htmlForm.booking_time.value = btValue.toTimeString().split(0, 5);
	htmlForm.return_time.value = rtValue.toTimeString().split(0, 5);
	htmlForm.time_diff.value = timeDiffHour;

	htmlForm.submit();
}