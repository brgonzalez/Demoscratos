$(document).ready(function() {
    var max_fields      = 10; //maximum input boxes allowed
    var wrapper         = $(".input_fields_wrap"); //Fields wrapper
    var add_button      = $(".add_field_button"); //Add button ID
    
    var x = 1; //initlal text box count
    $(add_button).click(function(e){ //on add input button click
        e.preventDefault();
        if(x < max_fields){ //max input box allowed
            x++; //text box increment
            $(wrapper).append('<div><input type="text" name="optionsQuestion[]" class="form-control"/><a href="#" class="remove_field"><span id="icon" class="glyphicon glyphicon-minus-sign"></span></a></div>'); //add input box
        }
    });
    
    $(wrapper).on("click",".remove_field", function(e){ //user click on remove text
        e.preventDefault(); $(this).parent('div').remove(); x--;
    })
    
    $("#votable").click( function(){
    	
    	if($(this).is(':checked')){
    		$('#settings-vote').show();
    		$(this).val('true');

    	}
    	if(!$(this).is(':checked')){
    		$('#settings-vote').hide();
    		$('#space-selections').hide();
    		$(this).val('false');
    		$('#semiPublic').val('false');
    		$("#secret").val('false');
    		$("#simple").val('false');
    		$("#multiselection").val('false');
    		$("#selection").val('false');


    		//Resetear los inputs

    	}
     });
    
    
    
    $("#semiPublic").click (function(){
    	if($(this).is(':checked')){
    		$("#secret").attr("checked", false);
    		$("#secret").val('false');
    		$(this).val('true');
    	}
    });
    
    $("#secret").click (function(){
    	if($(this).is(':checked')){
    		$("#semiPublic").attr("checked", false);
    		$("#semiPublic").val('false');
    		$(this).val('true');
    	}
    });
    
    
    $("#simple").click (function(){
    	if($(this).is(':checked')){
    		$("#multiselection").attr("checked", false);
    		$("#selection").attr("checked", false);
    		
    		$("#multiselection").val('false');
    		$("#selection").val('false');
    		
    		$(this).val('true');		
    		
    		$('#space-selections').hide();
    	}

    });
    
    $("#selection").click (function(){
    	if($(this).is(':checked')){
    		$('#space-selections').show();
    		
    		$("#multiselection").attr("checked", false);
    		$("#simple").attr("checked", false);
    		
    		$("#multiselection").val('false');
    		$("#simple").val('false');
    		
    		$(this).val('true');	
    	}
    	if(!$(this).is(':checked')){
    		$('#space-selections').hide();
    	}
    });
    
    $("#multiselection").click (function(){
    	if($(this).is(':checked')){
    		$('#space-selections').show();
    		
    		$("#selection").attr("checked", false);
    		$("#simple").attr("checked", false);
    		
    		$("#selection").val('false');
    		$("#simple").val('false');
    		
    		$(this).val('true');
    		

    	}
    	if(!$(this).is(':checked')){
    		$('#space-selections').hide();
    	}
    });
    
    
    
    
    
});
/*
    $("#myonoffswitch").click( function(){
       if( $(this).is(':checked') ) alert("checked");
    });
});



/*

<div class="fieldwrapper" id="field1">
    <input id ="input-options"type="text" class="fieldname form-control">
    <button type="button" class="remove btn btn-remove btn-danger" id="remove">
            <span class="glyphicon glyphicon-minus"></span>

    </button>

    <button type="button"  class="add btn btn-success btn-add " id="add">
        <span class="glyphicon glyphicon-plus"></span>
    </button>   
</div>
*/