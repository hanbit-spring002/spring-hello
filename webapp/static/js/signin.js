$(function() {
	$('#form-signin').on('submit', function(event) {
		this.action = '/signin';
		this.method = 'post';
		
		$(this).submit();
	});
});