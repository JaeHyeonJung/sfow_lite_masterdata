<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
/* Safari syntax */
:-webkit-full-screen {
  background-color: yellow;
}

/* IE11 */
:-ms-fullscreen {
  background-color: yellow;
}

/* Standard syntax */
:fullscreen {
  background-color: yellow;
}

/* Style the button */
button {
  padding: 20px;
  font-size: 20px;
}
</style>
</head>
<body>

<h2>Fullscreen with JavaScript</h2>
<p>Click on the "Open Fullscreen" button to open this page in fullscreen mode. Close it by either clicking the "Esc" key on your keyboard, or with the "Close Fullscreen" button.</p>

<button onclick="openFullscreen();">Open Fullscreen</button>
<button onclick="closeFullscreen();">Close Fullscreen</button>

<script>
var elem = document.documentElement;
function openFullscreen() {
	
  if (elem.requestFullscreen) {
    elem.requestFullscreen();
  } else if (elem.webkitRequestFullscreen) { 
    elem.webkitRequestFullscreen();
	
  } else if (elem.msRequestFullscreen) {
    elem.msRequestFullscreen();
  }
}

function closeFullscreen() {
  if(document.exitFullscreen) {
    document.exitFullscreen();
  } else if (document.webkitExitFullscreen) { 
    document.webkitExitFullscreen();
  } else if (document.msExitFullscreen) { 
    document.msExitFullscreen();
  }
}
</script>


</body>
</html>