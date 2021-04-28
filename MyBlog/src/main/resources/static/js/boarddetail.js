$(document).ready(function(){
	getCommentList();
	
})

function getCommentList(){
	var idx = $('input[name=idx]').val();
	$.ajax({
		type: 'GET',
		url: '/getCommentList',
		data : {idx},
		success: function(result) {
			console.log(result);
			for(var i=0;i<result.length;i++){
				var str = "<div>"
				str += result[i].content+"</div></hr>"
				$("#comment").append(str);
			}
			
		},
		error: function(result) {
		},
		complete: function() {
		}

	})
}
