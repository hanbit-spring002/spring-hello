$(function() {
	$('#btn-save').on('click', function() {
		var article = {
			title: $('#txt-title').val(),
			contents: $('#txt-contents').val()
		};
		
		$.ajax({
			url: '/api/save',
			method: 'POST',
			dataType: 'json',
			contentType: 'application/json; charset=utf-8',
			data: JSON.stringify(article),
			success: function() {
				location.href = '/';
			}
		});
	});
});