$(document).ready(function(){
	getBoardList();
})

function getBoardList() {
	$.ajax({
		type: 'GET',
		url: '/getBoardList',
		success: function(result) {
			//들고오면 테이블에 뿌리기 
			//페이징 처리는 다음에 .. 

			if(result.length>1){
				
				for(var i=0;i<result.length;i++){
					console.log(result[i]);
					console.log(result[i].idx);
					str='<tr>'
					str += "<td>"+result[i].idx+"</td>";
					str+="<td>"+result[i].writer+"</td>";
					str+="<td>"+result[i].title+"</td>";
					str+="<td>"+result[i].date+"</td>";
					str+="<td>"+result[i].hit+"</td>";
					str+="</tr>"
					console.log(str);
					$('#boardtable').append(str);
				}
			}
		}
		,
		error: function(result) {
		},
		complete: function() {
		}

	})
}
