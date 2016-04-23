$(document).ready(function() {
    $("#add").click(function() {
        var intId = $("#question div").length + 1;
        var fieldWrapper = $("<div class=\"fieldwrapper\" id=\"field" + intId + "\"/>");
        var fName = $("<input  id =\"input-options\" type=\"text\" class=\"fieldname form-control\" />");
        var removeButton = $("<button type=\"button\"  class=\"remove btn btn-remove btn-danger \" id=\"remove\"><span class=\"glyphicon glyphicon-minus\"></span></button>");
        removeButton.click(function() {
            $(this).parent().remove();
        });
        fieldWrapper.append(fName);
        fieldWrapper.append(removeButton);
        $("#question").append(fieldWrapper);
    });

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