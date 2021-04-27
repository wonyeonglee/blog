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
			console.log(result);
			if(result.length>=1){
				result.forEach(function(item){
					str='<tr>'
					str += "<td>"+item.idx+"</td>";
					str+="<td>"+item.writer+"</td>";
					str+="<td><a href = 'board/detail?idx=" + item.idx + "'>" + item.title + "</a></td>";
					str+="<td>"+item.date+"</td>";
					str+="<td>"+item.hit+"</td>";
					str+="</tr>"
					$('#boardtable').append(str);

        		})
				
			}
		}
		,
		error: function(result) {
		},
		complete: function() {
		}

	})
}
