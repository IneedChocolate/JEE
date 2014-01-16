<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ProjetJEE - Connexion</title>
	</head>
	<body>
		<c:set var="CURRENT_USER" value="${ CURRENT_USER }" scope="session" />
		<jsp:include page="menu.jsp" />
		<form method="POST" action="Connexion">
			<fieldset>
				<legend>Connexion</legend>
				<label for="username">Nom d'utilisateur</label>
				<input type="text" id="username" name="username" size="30" maxlength="30" />
				<br/>
				
				<label for="mdp">Mot de passe</label>
				<input type="password" id="mdp" name="mdp" size="30" maxlength="30" />
				<br/>
				
				<input type="submit" value="Connexion" />
			</fieldset>
		</form>
	</body>
</html>