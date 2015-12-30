$(function() {
	// 设置footer始终在页面底部
	var windowHeight = $(document).height();
	var bodyHeight = $(document.body).height();
	if(windowHeight > bodyHeight) {
		$('.content').css('height',windowHeight - 219);
	}
	$(window).resize(function(){
		var windowHeight = $(document).height();
		if(windowHeight > bodyHeight) {
			$('.content').css('height',windowHeight - 219);
		}			
	});
});