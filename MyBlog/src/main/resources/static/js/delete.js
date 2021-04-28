function checkPassword(){
	console.log("들어옴");
	
	var idx = $('input[name=idx]').val();
	var password = $('input[name=password]').val();

	$.ajax({
		type: 'GET',
		url: '/board/delete/getPassword',
		data : {idx,password},
		success: function(result) {
			//들고오면 테이블에 뿌리기 
			//페이징 처리는 다음에 .. 
			if(result.password == password){
				console.log("비밀번호 일치");
				$('#submiBtn').attr('disabled',false);
			}
			else{
				alert("비밀번호가 일치하지않습니다");
			}
		}
		,
		error: function(result) {
		},
		complete: function() {
		}

	})
}