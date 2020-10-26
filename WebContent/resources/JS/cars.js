$(document).ready(function() {

	$('.card').mouseenter(function() {

		$(this).animate({
			width : "99%",
			color:" #0000ff"
		}, 700);

	});

	$('.card').mouseleave(function() {

		$(this).animate({
			width : "100%",
			color:"#000000"
		}, 700);
	});
});