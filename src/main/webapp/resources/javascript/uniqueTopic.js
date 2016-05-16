$(document).ready(function() {

    
	var $unique = $('input.unique');
	$unique.click(function() {
	    $unique.filter(':checked').not(this).removeAttr('checked');
	});
 
    
});