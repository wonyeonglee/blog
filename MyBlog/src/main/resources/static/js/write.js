function checkForm(){
	if($('#title').val()=="" || $('#writer').val()=="" || $('#password').val()=="" || $("#content").val()==""){
		alert("내용을 모두 입력해주세요");
		return false;
	}
	else{
		return true;
	}
}