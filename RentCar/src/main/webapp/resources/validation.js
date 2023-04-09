function checkVehicle(htmlForm){
	
	const name = document.getElementById("vehicle_name").value;
	const rate = document.getElementById("hourly_rate").value;
	const code = document.getElementById("vehicle_code").value;


	if ((name == '' || name == undefined || name == null || name == 'null')) {
		alert("차량명이 입력되지 않았습니다.");
		return;
	} else if ((rate == '' || rate == undefined || rate == null || rate == 'null')) {
		alert("시간당 렌트비용이 입력되지 않았습니다.");
		return;
	} else if ((code == '' || code == undefined || code == null || code == 'null')) {
		alert("지점 코드가 입력되지 않았습니다.");
		return;
	}  else {
		htmlForm.submit();
	}
	
}

// 회원가입정보 확인
function checkValues(htmlForm) {

	let url = "regist?";

	const clientId = document.getElementById("client_id").value;
	const password = document.getElementById("password").value;
	const psCheck = document.getElementById("password_check").value;
	const name = document.getElementById("name").value;
	const phone = document.getElementById("phone").value;
	const driverCode = document.getElementById("driver_code").value;

	const postcode = document.getElementById("sample4_postcode").value;
	const roadAddress = document.getElementById("sample4_roadAddress").value;
	const jibunAddress = document.getElementById("sample4_jibunAddress").value;
	const detailAddress = document.getElementById("sample4_detailAddress").value;
	const extraAddress = document.getElementById("sample4_extraAddress").value;

	let check = true;

	if (clientId !== "")
		url += "&client_id=" + clientId;
	if (password === psCheck) {
		if (password !== "")
			url += "&password=" + password;
	} else {
		alert("비밀번호가 일치하지 않습니다.");
	}
	if (name !== "")
		url += "&client_id=" + name;
	if (phone !== "")
		url += "&phone=" + phone;
	if (driverCode !== "")
		url += "&driver_code=" + driverCode;
	if (postcode !== "" && roadAddress !== "" && jibunAddress !== "" && extraAddress !== "") {
		url += "&sample4_postcode=" + postcode;
		url += "&sample4_roadAddress=" + roadAddress;
		url += "&sample4_jibunAddress=" + jibunAddress;
		url += "&sample4_extraAddress=" + extraAddress;
	}
	if (detailAddress !== "") {
		url += "&sample4_detailAddress=" + detailAddress;
	}

	console.log(clientId);
	console.log(password);
	console.log(psCheck);
	console.log(name);
	console.log(phone);
	console.log(driverCode);
	console.log(postcode);
	console.log(roadAddress);
	console.log(jibunAddress);
	console.log(detailAddress);
	console.log(extraAddress);

	if (clientId === "") {
		alert('아이디가 입력되지 않았습니다.');
		check = false;
	} else if (password === "" || psCheck === "") {
		alert('비밀번호가 입력되지 않았습니다.');
		check = false;
	} else if (name === "") {
		alert('성함이 입력되지 않았습니다.');
		check = false;
	} else if (phone === "") {
		alert('휴대전화 번호가 입력되지 않았습니다.');
		check = false;
	} else if (driverCode === "") {
		alert('운전면허번호가 입력되지 않았습니다.');
		check = false;
	} else if (postcode === "" || roadAddress === "" || jibunAddress === "" || extraAddress === "") {
		alert('우편번호 찾기를 이용해 우편번호를 검색해주세요.');
		check = false;
	} else if (detailAddress === "") {
		alert('상세주소가 입력되지 않았습니다.');
		check = false;
	}

	if (check === false) {
		console.log(url);
		location.href = `${url}`;
	} else {
		alert("회원등록이 완료되었습니다.");
		htmlForm.submit();
	}
}

// 아이디, 비밀번호, 운전면허번호 제외 변경 확인
function checkInfo(htmlForm) {

	let url = "inquiryinfo?";

	const clientId = document.getElementById("client_id").value;
	const name = document.getElementById("name").value;
	const phone = document.getElementById("phone").value;
	const driverCode = document.getElementById("driver_code").value;

	const postcode = document.getElementById("sample4_postcode").value;
	const roadAddress = document.getElementById("sample4_roadAddress").value;
	const jibunAddress = document.getElementById("sample4_jibunAddress").value;
	const detailAddress = document.getElementById("sample4_detailAddress").value;
	const extraAddress = document.getElementById("sample4_extraAddress").value;

	let check = true;

	if (clientId !== "")
		url += "&client_id=" + clientId;
	if (name !== "")
		url += "&client_id=" + name;
	if (phone !== "")
		url += "&phone=" + phone;
	if (driverCode !== "")
		url += "&driver_code=" + driverCode;
	if (postcode !== "" && roadAddress !== "" && jibunAddress !== "" && extraAddress !== "") {
		url += "&sample4_postcode=" + postcode;
		url += "&sample4_roadAddress=" + roadAddress;
		url += "&sample4_jibunAddress=" + jibunAddress;
		url += "&sample4_extraAddress=" + extraAddress;
	}
	if (detailAddress !== "") {
		url += "&sample4_detailAddress=" + detailAddress;
	}


	if (clientId === "") {
		alert('아이디가 입력되지 않았습니다.');
		check = false;
	} else if (name === "") {
		alert('성함이 입력되지 않았습니다.');
		check = false;
	} else if (phone === "") {
		alert('휴대전화 번호가 입력되지 않았습니다.');
		check = false;
	} else if (driverCode === "") {
		alert('운전면허번호가 입력되지 않았습니다.');
		check = false;
	} else if (postcode === "" || roadAddress === "" || jibunAddress === "" || extraAddress === "") {
		alert('우편번호 찾기를 이용해 우편번호를 검색해주세요.');
		check = false;
	} else if (detailAddress === "") {
		alert('상세주소가 입력되지 않았습니다.');
		check = false;
	}

	if (check === false) {
		console.log(url);
		location.href = `${url}`;
	} else {
		alert("회원정보가 수정되었습니다.");
		htmlForm.submit();
	}
}

// 비밀번호 변경 확인
function checkPassword(htmlForm) {

	let url = "updatepassword?";

	const id = document.getElementById("client_id").value;
	const password = document.getElementById("password").value;
	const psCheck = document.getElementById("password_check").value;

	if (password === psCheck) {
		url += "&client_id=" + id + "&password=" + password;
		htmlForm.submit();
	} else {
		location.href = `${url}`;
	}
}

function leaveCheck() {
	if (confirm("탈퇴하면 복구가 불가능합니다.\n 정말로 삭제하시겠습니까?")) {
		location.href = "../service?command=leave";
	} else {
		location.href = "inquiryinfo";
	}
}


//본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
function execDaumPostcode() {
	new daum.Postcode(
		{
			oncomplete: function(data) {
				// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

				// 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
				// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
				var roadAddr = data.roadAddress; // 도로명 주소 변수
				var extraRoadAddr = ''; // 참고 항목 변수

				// 법정동명이 있을 경우 추가한다. (법정리는 제외)
				// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
				if (data.bname !== ''
					&& /[동|로|가]$/g
						.test(data.bname)) {
					extraRoadAddr += data.bname;
				}
				// 건물명이 있고, 공동주택일 경우 추가한다.
				if (data.buildingName !== ''
					&& data.apartment === 'Y') {
					extraRoadAddr += (extraRoadAddr !== '' ? ', '
						+ data.buildingName
						: data.buildingName);
				}
				// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
				if (extraRoadAddr !== '') {
					extraRoadAddr = ' ('
						+ extraRoadAddr
						+ ')';
				}

				// 우편번호와 주소 정보를 해당 필드에 넣는다.
				document
					.getElementById('sample4_postcode').value = data.zonecode;
				document
					.getElementById("sample4_roadAddress").value = roadAddr;
				document
					.getElementById("sample4_jibunAddress").value = data.jibunAddress;

				// 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
				if (roadAddr !== '') {
					document
						.getElementById("sample4_extraAddress").value = extraRoadAddr;
				} else {
					document
						.getElementById("sample4_extraAddress").value = '';
				}

				var guideTextBox = document
					.getElementById("guide");
				// 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
				if (data.autoRoadAddress) {
					var expRoadAddr = data.autoRoadAddress
						+ extraRoadAddr;
					guideTextBox.innerHTML = '(예상 도로명 주소 : '
						+ expRoadAddr
						+ ')';
					guideTextBox.style.display = 'block';

				} else if (data.autoJibunAddress) {
					var expJibunAddr = data.autoJibunAddress;
					guideTextBox.innerHTML = '(예상 지번 주소 : '
						+ expJibunAddr
						+ ')';
					guideTextBox.style.display = 'block';
				} else {
					guideTextBox.innerHTML = '';
					guideTextBox.style.display = 'none';
				}
			}
		}).open();
}
