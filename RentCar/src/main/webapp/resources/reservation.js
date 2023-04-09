function reservation(htmlForm) {

	let bookingdate = document.getElementById('booking_date').value;
	let returndate = document.getElementById('return_date').value;
	let bookingTime = document.getElementById('booking_time').value;
	let returnTime = document.getElementById('return_time').value;

	let now = new Date();
	let currentDate = new Date(now.getFullYear(), now.getMonth(), now.getDate());
	let currentTime = now.getTime();
	

	let bdValue = new Date(bookingdate);
	let rdValue = new Date(returndate);
	let btValue = new Date(`1970-01-01T${bookingTime}`);
	let rtValue = new Date(`1970-01-01T${returnTime}`);
	
	let bookingTimeInput = document.getElementById('booking_time');
	let returnTimeInput = document.getElementById('return_time');

bookingTimeInput.addEventListener('change', function() {
    bookingTime = bookingTimeInput.value;
    btValue = new Date(`1970-01-01T${bookingTime}`);
});

returnTimeInput.addEventListener('change', function() {
    returnTime = returnTimeInput.value;
    rtValue = new Date(`1970-01-01T${returnTime}`);
});
	
	
	console.log("뭐지?");
	console.log(btValue);
	console.log(rtValue);

	if (bdValue < currentDate) {
		alert("렌트일은 오늘 날짜 이후로 선택하여 주세요.")
		return;
	} else if (rdValue <= bdValue) {
		alert("반납일은 대여일 이후로 선택하여 주세요.")
		return;
	} else if (btValue.getTime() === currentDate.getTime() && btValue.getTime() < currentTime) {
		alert("대여시간은 현재 시간 이후로 선택하여 주세요.")
		return;
	}
	
	console.log(rtValue.getTime());
	console.log(bdValue.getTime());

	let timeDiff = rtValue.getTime() - bdValue.getTime();
	let timeDiffHour = Math.ceil(timeDiff / (1000 * 60 * 60) );
	
	console.log(timeDiffHour);

	htmlForm.booking_date.value = bdValue.toISOString().slice(0, 10);
	htmlForm.return_date.value = rdValue.toISOString().slice(0, 10);
	htmlForm.booking_time.value = btValue.toTimeString().slice(0, 5);
	htmlForm.return_time.value = rtValue.toTimeString().slice(0, 5);
	htmlForm.time_diff.value = timeDiffHour;

	htmlForm.submit();
}