<form method="post" action="Contact">
	<input type="text" class="input" name="nom" placeholder="Nom" required
		pattern="[A-Za-z]{1,15}$" value="${ contact.nom }"> <br>
	<input type="text" class="input" name="prenom" placeholder="Prenom"
		required pattern="[A-Za-z]{1,15}$" value="${ contact.prenom }">
	<br> <input type="text" class="input" name="telephone"
		placeholder="Telephone" required pattern="[0-9]{10}"
		value="${ contact.telephone }"> <br> <input type="text"
		class="input" name="type" placeholder="Type de telephone" required
		pattern="[A-Za-z0-9_]{1,15}$" value="${ contact.type }"> <br>
	<input type="text" class="input" name="email" placeholder="email"
		required pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"
		value="${ contact.email }"> <br>
	<button class="btn btn-primary">Valider</button>
</form>