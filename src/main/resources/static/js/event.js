// Get the modal

var eventSuccess = false;

var modal = document.getElementById("myModal");

var eventMessage = document.getElementById("id-event-message");
var eventMessageList = [
	"정상적으로 등록되었습니다.",	// 200
	"이벤트 준비중입니다. 잠시 후 이용해 주헤요!!",	// 511
	"이벤트가 종료되었습니다.",	// 512
	"이벤트 중복 오류입니다. !!",  // 513
	""						// 미정의
	];
var eventMessageNo = 1;

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
						eventMessageNo = 0;
						showEventButton(false);	
						break;
					case 511:
						alert(obj.result_msg);
						eventMessageNo = 1;
						showEventButton(false);
						break;
					case 512:
						alert(obj.result_msg);
						eventMessageNo = 2;
						showEventButton(false);
					case 513:
						alert(obj.result_msg);
						eventMessageNo = 3;
						showEventButton(false);
					default :
						alert(obj.result_msg);
						eventMessageNo = 4;
						eventMessageList[4] = obj.result_msg;
						showEventButton(false);
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
	showEventButton(false);
  setTimeout("showEventButton(true)", 3000); 
}


function showEventButton(flag) {
	/*
  resultOk.style.display = "none";
  resultFail.style.display = "none";
  eventWait.style.display = "none";
  btn.style.display = "block";
  */
	if (flag) {
		eventMessage.style.display = "none";
		btn.style.display = "block";
	} else {
		btn.style.display = "none";	
		eventMessage.innerHTML = "<p>" + eventMessageList[eventMessageNo] + "</p>";
		eventMessage.style.display = "block";
		//eventMessage.innerHTML = "<p>" + eventMessageList[eventMessageNo] + "</p>";
		
	}

}
/*
setInterval("ozit_interval_test()", 5000);
function ozit_timer_test(){ 
  sum += 1; 
}
*/
