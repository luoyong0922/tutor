$("ul li").click(function(e) {
	// make sure we cannot click the slider
	if($(this).hasClass('slider')) {
		return;
	}

	/* Add the slider movement */
	// what tab was pressed
	var whatTab = $(this).index();
	// Work out how far the slider needs to go
	var howFar = 160 * whatTab;
	$(".slider").css({
		left: howFar + "px"
	});

	/* Add the ripple */
	// Remove olds ones
	$(".ripple").remove();
	// Setup
	var posX = $(this).offset().left,
		posY = $(this).offset().top,
		buttonWidth = $(this).width(),
		buttonHeight = $(this).height();
	// Add the element
	$(this).prepend("<span class='ripple'></span>");
	// Make it round!
	if(buttonWidth >= buttonHeight) {
		buttonHeight = buttonWidth;
	} else {
		buttonWidth = buttonHeight;
	}
	// Get the center of the element
	var x = e.pageX - posX - buttonWidth / 2;
	var y = e.pageY - posY - buttonHeight / 2;
	// Add the ripples CSS and start the animation(添加ripple CSS并启动动画)
	$(".ripple").css({
		width: buttonWidth,
		height: buttonHeight,
		top: y + 'px',
		left: x + 'px'
	}).addClass("rippleEffect");
});

//Slider
jQuery(window).load(function() {
	jQuery('#slider').nivoSlider({
		effect: 'fold',
		slices: 15,
		animSpeed: 500, //Slide transition speed
		pauseTime: 5000,
		controlNav: false,
		directionNavHide: false,
		prevText: 'prev',
		nextText: 'next',
		startSlide: 0, //Set starting Slide (0 index)
		directionNav: true, //Next &amp; Prev
		afterLoad: function() {
			jQuery(".nivo-caption").animate({
				top: "60"
			}, {
				easing: "easeOutBack",
				duration: 500
			})
		},
		beforeChange: function() {
			jQuery(".nivo-caption").animate({
				top: "-300"
			}, {
				easing: "easeInBack",
				duration: 500
			})
		},
		afterChange: function() {
			jQuery(".nivo-caption").animate({
				top: "60"
			}, {
				easing: "easeOutBack",
				duration: 500
			})
		}
	});

});