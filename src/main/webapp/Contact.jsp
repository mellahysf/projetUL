<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Categories</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<div id="nouvelContact">
	<form method="post" action="Contact">
		<input type="text" class="input" name="nom" placeholder="Nom" required pattern="[A-Za-z]{1,15}$">
		<br>
		<input type="text" class="input" name="prenom" placeholder="Prenom" required pattern="[A-Za-z]{1,15}$">
		<br>
		<input type="text" class="input" name="telephone" placeholder="Telephone" required pattern="[0-9]{10}">
		<br>
		<input type="text" class="input" name="type" placeholder="Type de telephone" required pattern="[A-Za-z0-9_]{1,15}$">
		<br>
		<input type="text" class="input" name="email" placeholder="email" required pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$">
		<br>
		<button  type="submit" class="btn btn-primary">Valider</button>
		<a href="AfficherContact"><button  type="submit" class="btn btn-primary">Retour</button></a>
	</form>
</div>

</body>
</html>