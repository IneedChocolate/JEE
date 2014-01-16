<nav>
			<a href="Accueil">Accueil</a>
	<c:choose>
		<c:when test="${ sessionScope.CURRENT_USER != null }">
			<c:out value="Bienvenu(e) ${ sessionScope.CURRENT_USER.pseudo }" />
			<a href="Upload_creation">Enregistrer une image</a>
			<a href="Deconnexion">Deconnexion</a>
		</c:when>
		<c:otherwise>
			<a href="Inscription">Inscription</a>
			<a href="Connexion">Connexion</a>
		</c:otherwise>
	</c:choose>
</nav>