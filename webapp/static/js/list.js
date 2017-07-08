$(function() {
	$('#btn-write').on('click', function() {
		location.href = '/board/write';
	});	
	
	$('#btn-search').on('click', function() {
		var keyword = $('#txt-keyword').val();
		
		$.ajax({
			url: '/api/search',
			method: 'GET',
			data: {
				keyword: keyword
			},
			success: function(result) {
				setList(result);
			}
		});
	});
	
	function setList(list) {
		$('tbody').empty();
		
		for (var i=0; i<list.length; i++) {
			var row = list[i];
			
			var rowHtml = '<tr>';
			rowHtml += '<td>' + row.no + '</td>';
			rowHtml += '<td>' + row.title + '</td>';
			rowHtml += '<td>' + row.views + '</td>';
			rowHtml += '<td>' + row.updateDt + '</td>';
			rowHtml += '</tr>';
			
			$('tbody').append(rowHtml);
		}
	}
});













