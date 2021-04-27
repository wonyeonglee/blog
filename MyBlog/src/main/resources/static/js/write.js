function write(){
	var $form = $("form[name=write-form]");
	$.ajax({
		type: 'GET',
		url: '/write/',
		success: function(result) {
			//들고오면 테이블에 뿌리기 
			//페이징 처리는 다음에 .. 
		}
		,
		error: function(result) {
		},
		complete: function() {
		}

	})
}