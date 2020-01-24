// Get the modal

var eventSuccess = false;

var modal = document.getElementById("myModal");
var resultOk = document.getElementById("id-result-ok");
var resultFail = document.getElementById("id-result-fail");
var eventWait = document.getElementById("id-event-wait");
var eventClose = document.getElementById("id-event-close");

var eventImage = document.getElementById("id-event-image");

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
    function sendData2 () {
		
		var str = '{ "result_code": 200, "result_msg": "SUCCESS",  "data": {    "event_id": "2020011301",    "phone_num": "01012345678",    "name": "홍길동"  }}';
		var obj = JSON.parse(str);
      modal.style.display = "none";
	  alert(obj.data.event_id);
      btn.style.display = "none";
      resultOk.style.display = "block";
	  
	  eventImage.src = "images/penha.jpg";
	  eventSuccess = true;
    }

	  function sendData() {

	    const XHR = new XMLHttpRequest();

	    // Bind the FormData object and the form element
	    const FD = new FormData( form );

	    // Define what happens on successful data submission
	    XHR.addEventListener( "load", function(event) {
			
        if (XHR.readyState == XMLHttpRequest.DONE) {
			//console(XHR.status);
			if(XHR.status == 200) {
				alert(event.target.responseText);
		    	/*alert("응모에 성공했습니다 !!");*/
				
				var json = event.target.responseText;
				var obj = JSON.parse(json);
				
				switch(obj.result_code) {
					case 200:
						alert(obj.result_msg);
						showEventButton(1);					
						break;
					case 511:
						alert(obj.result_msg);
						showEventButton(3);
						break;
					case 512:
						alert(obj.result_msg);
						showEventButton(4);				
					case 513:
						alert(obj.result_msg);
						showEventButton(2);	
					default :
						alert(obj.result_msg);
						showEventButton(2);	
				//if (obj.result_code
				//showEventButton(1);
				}
			}
			
	      } else {
		   		alert("중복 신청했습니다 !!");
		   	}
			modal.style.display = "none";
	    });
/*
	    // Define what happens in case of error
	    XHR.addEventListener( "error", function( event ) {
	      alert( 'Oops! Something went wrong.' );
	    });
*/
	    // Set up our request
	    XHR.open( "GET", "http://localhost:8080/cassandra/test?eventId=20010900&phoneNo=01012345678" );

	    // The data sent is what the user provided in the form
	    XHR.send( FD );
	  }
	 
	  // Access the form element...
	  let form = document.getElementById( "myForm" );

	  // ...and take over its submit event.
	  form.addEventListener( "submit", function ( event ) {

		  if (window.eventSuccess != true) {
	    event.preventDefault();
	    sendData();
		  }
	  });
});

window.onload  = function() {
	
  setTimeout("showEventButton(5)", 1000); 
}


function showEventButton(type) {
	/*
  resultOk.style.display = "none";
  resultFail.style.display = "none";
  eventWait.style.display = "none";
  btn.style.display = "block";
  */

	switch(type) {
		case 1 :
			resultOk.style.display = "block";
			resultFail.style.display = "none";
			eventWait.style.display = "none";
			eventClose.style.display = "none";
			btn.style.display = "none";
			break;
		case 2 :
			resultOk.style.display = "none";
			resultFail.style.display = "block";
			eventWait.style.display = "none";
			eventClose.style.display = "none";
			btn.style.display = "none";
			break;
		case 3 :
			resultOk.style.display = "none";
			resultFail.style.display = "none";
			eventWait.style.display = "block";
			eventClose.style.display = "none";
			btn.style.display = "none";
			break;	
		case 4 :
			resultOk.style.display = "none";
			resultFail.style.display = "none";
			eventWait.style.display = "none";
			eventClose.style.display = "block";
			btn.style.display = "none";
			break;	
		default :
			resultOk.style.display = "none";
			resultFail.style.display = "none";
			eventWait.style.display = "none";
			eventClose.style.display = "none";
			btn.style.display = "block";
			break;			
	}
}
/*
setInterval("ozit_interval_test()", 5000);
function ozit_timer_test(){ 
  sum += 1; 
}
*/
