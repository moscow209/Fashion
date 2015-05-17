!function ($) {
$(function(){
  // Fix for dropdowns on mobile devices for bootstrap bug https://github.com/twitter/bootstrap/issues/4550
  $('body').on('touchstart.c6321', '.c6323', function (e) { 
	  e.stopPropagation(); 
  });
  $(document).on('click','.c6323 a',function(){
	  document.location = $(this).attr('href');
  });
})
}(window.jQuery)
