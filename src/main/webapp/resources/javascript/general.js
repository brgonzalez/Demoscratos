$(document).ready(function() {

  $('#btnDelete').click(function() {
	  console.log("puta")
    bootbox.confirm("Are you sure want to delete?", function(result) {
      alert("Confirm result: " + result);
    });
  });
});

