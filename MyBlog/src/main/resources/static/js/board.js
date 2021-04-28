$(document).ready(function(){
	getBoardList();
	
})

function getBoardList() {
	$.ajax({
		type: 'GET',
		url: '/getBoardList',
		success: function(result) {
			if(result.length>=1){
				result.forEach(function(item){
					str='<tr>'
					str += "<td>"+item.idx+"</td>";
					str+="<td>"+item.writer+"</td>";
					str+="<td><a href = '/board/detail?idx=" + item.idx + "'>" + item.title + "</a></td>";
					str+="<td>"+item.date+"</td>";
					str+="<td>"+item.hit+"</td>";
					str+="</tr>"
					$('#boardtable').append(str);
        		})				
			}
		},
		error: function(result) {
		},
		complete: function() {
		}

	})
}
function sortTable(n){
	
	var rows = $('#boardtable tbody tr');
	rows = Array.prototype.slice.call( rows, 0 );
	//오름차순 정렬
	rows.sort( function( row1, row2 ){
    	var cell1 = row1.getElementsByTagName("td")[n]; //n번째 column
    	var cell2 = row2.getElementsByTagName("td")[n]; //n번째 column
    	var value1 = cell1.textContent || cell1.innerText; 
    	var value2 = cell2.textContent || cell2.innerText;
		if(n==0 || n==4){
			value1 = Number(value1);
			value2 = Number(value2);
		}
	
		if( value1 < value2 ) return -1;
    	if( value1 > value2 ) return 1;
    	return 0;
  	});

 	//sort된 순서대로 다시 table에 추가
	for(var i=0;i<rows.length;i++){
		$('#boardtable').append(rows[i]);
	}
	
	console.log(rows);
}
