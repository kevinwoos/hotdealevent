// Get the modal
var modal = document.getElementById("myModal");

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal
btn.onclick = function() {
  modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
  modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}

window.addEventListener( "load", function () {
	  function sendData() {

	    const XHR = new XMLHttpRequest();

	    // Bind the FormData object and the form element
	    const FD = new FormData( form );

	    // Define what happens on successful data submission
	    XHR.addEventListener( "load", function(event) {
	        if (XHR.readyState == XMLHttpRequest.DONE && XHR.status == 200 && event.target.responseText == "false" ) {
		    	alert("응모에 성공했습니다 !!");
	        } else {
		   		alert("중복 신청했습니다 !!");
		   	}
	      } );

	    // Define what happens in case of error
	    XHR.addEventListener( "error", function( event ) {
	      alert( 'Oops! Something went wrong.' );
	    } );

	    // Set up our request
	    XHR.open( "POST", "http://localhost:8080/cache/dup" );


	    // The data sent is what the user provided in the form
	    XHR.send( FD );
	  }
	 
	  // Access the form element...
	  let form = document.getElementById( "myForm" );

	  // ...and take over its submit event.
	  form.addEventListener( "submit", function ( event ) {
	    event.preventDefault();

	    sendData();
	  } );
	} );