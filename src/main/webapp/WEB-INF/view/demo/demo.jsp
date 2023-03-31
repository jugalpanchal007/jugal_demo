<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello React</title>

<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>

<script crossorigin src="https://unpkg.com/react@16.13.1/umd/react.development.js"></script>
<script crossorigin src="https://unpkg.com/react-dom@16.13.1/umd/react-dom.development.js"></script>
<script crossorigin src='https://unpkg.com/react-router-dom@5.0.0/umd/react-router-dom.min.js'></script>

<script src="https://unpkg.com/@babel/standalone/babel.min.js"></script>
<script type="text/babel" src="/js/components/Component.js"></script>

<script>var exports = {};</script> 
<script type="text/babel">
$( document ).ready(function() {
    console.log( "ready!" );
    ReactDOM.render( <Component/>, document.getElementById('mydiv'));
});
</script>

</head>
<body>
	<div id="mydiv">
	</div>
</body>
</html>