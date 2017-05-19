<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
    <%@ page import="Entity.Contact" %>
    <%@ page isELIgnored="false" %>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <script>
        $(document).ready(function(){
            $('#afficher').show();
            $('#modifierContact').hide();
            $('#b1').click(function(){
                $('#modifierContact').show();
                $('#afficher').hide();
            });
            

           
        });
    </script>
<div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Gestion Contact</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="Contact">Ajouter Contact <span class="sr-only">(current)</span></a></li>

      </ul>
      
      <ul class="nav navbar-nav navbar-right">

    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
  <div id="afficher">
	<table >

  <tr>
    <th>Nom</th>
    <th>Prénom</th>
    <th>Téléphone</th>
    <th>Type</th>
    <th>Email</th>
  </tr>
       <c:forEach var="contact" items="${contacts}">
    

		<tr>
			<td>${ contact.nom }</td>
			<td>${ contact.prenom }</td>
			<td>${ contact.telephone }</td>
			<td>${ contact.type }</td>
			<td>${ contact.email }</td> 
			<td>
				<a href="AfficherContact?id=${contact.id}"><button type="submit" class="btn btn-primary" id="contact" name='contactId'>Modifier</button></a>
				<a href="AfficherContact?idS=${contact.id}"><button type="submit" class="btn btn-primary" id="contact" name='contactId'>Supprimer</button></a>
				
			</td>
		</tr>
			</c:forEach>
	</table>			
	</div>
	
			<!--  <div id="modifierContact">
							<form method="post" action="Contact">
					<input type="text" class="input" name="nom" placeholder="Nom" required pattern="[A-Za-z]{1,15}$" value="${ contact.nom }">
					<br>
					<input type="text" class="input" name="prenom" placeholder="Prenom" required pattern="[A-Za-z]{1,15}$" value="${ contact.prenom }">
					<br>
					<input type="text" class="input" name="telephone" placeholder="Telephone" required pattern="[0-9]{10}" value="${ contact.telephone }">
					<br>
					<input type="text" class="input" name="type" placeholder="Type de telephone" required pattern="[A-Za-z0-9_]{1,15}$" value="${ contact.type }">
					<br>
					<input type="text" class="input" name="email" placeholder="email" required pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" value="${ contact.email }">
					<br>
					<button   class="btn btn-primary">Valider</button>
				</form>
			</div>-->
	
		




</body>
</html>