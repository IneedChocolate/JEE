<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>ProjetJEE - Inscription</title>
	</head>
	<body>
		<jsp:include page="menu.jsp" />
		<form method="POST" action="Inscription">
			<fieldset>
				<legend>Inscription</legend>
				<label for="username">Nom d'utilisateur</label>
				<input type="text" id="username" name="username" value="<c:out value="${ user.pseudo }" />" size="30" maxlength="60"/>
				<span class="erreur">${ form.erreurs['username'] }</span>
				<br/>
				
				<label for="mdp">Mot de passe</label>
				<input type="password" id="mdp" name="mdp" value="" size="30" />
				<span class="erreur">${ form.erreurs['mdp'] }</span>
				<br/>
				
				<label for="confirm">Confirmer le mot de passe</label>
				<input type="password" id="confirm" name="confirm" value="" size="30" />
				<span class="erreurs">${ form.erreurs['confirm'] }</span>
				<br/>
				
				<input type="submit" value="Inscription" />
				<br/>
				
				<p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
			</fieldset>
		</form>
	</body>
</html>