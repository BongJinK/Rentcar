function exchangeClientInformation(htmlForm) {

	let url = "cmupdate?";

	const id = document.getElementById("client_id").value;
	const password = document.getElementById("password").value;
	const name = document.getElementById("name").value;
	const driverCode = document.getElementById("driver_code").value;
	const phone = document.getElementById("phone").value;

	const postcode = document.getElementById("sample4_postcode").value;
	const roadAddress = document.getElementById("sample4_roadAddress").value;
	const jibunAddress = document.getElementById("sample4_jibunAddress").value;
	const detailAddress = document.getElementById("sample4_detailAddress").value;
	const extraAddress = document.getElementById("sample4_extraAddress").value;

	let check = true;
	
	console.log(check);

	console.log(id);
	console.log(password);
	console.log(name);
	console.log(phone);
	console.log(driverCode);
	console.log(postcode);
	console.log(roadAddress);
	console.log(jibunAddress);
	console.log(detailAddress);
	console.log(extraAddress);

	if (id !== "")
		url += "client_id=" + id;
	if (password !== "")
		url += "&password=" + password;
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
	
	console.log(url);

	if (id === "") {
		alert('아이디가 입력되지 않았습니다.');
		check = false;
	} else if (password === "") {
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

	console.log(url);
	console.log(check);
	if (check === false) {
		location.href = `${url}`;
	} else {
		console.log("끝");
		alert("회원정보가 수정되었습니다.");
		htmlForm.submit();
	}
}