<%@page import="modele.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Page jsp de test</title>
	</head>
	<body>
		<p> Partie attribut/paramètre </p>
		Phrase de test : ${ test }
		<br/>
		Auteur : ${ param.auteur }
		
		<p> Partie du bean </p>
		<p>
            Récupération du bean : <br/>
            Pseudo : ${ utilisateur.pseudo } <br/>
			Mot de passe : ${ utilisateur.passwd }
        </p>
        Test : <c:out value="${test}" /> <br/>
        <c:set var="CURRENT_USER" value="${ utilisateur }" scope="session" />
        Pseudo Session : 
        <c:out value="${ sessionScope.CURRENT_USER.pseudo }" >
        	Pas de pseudo
        </c:out><br/>
        <c:set target="${ sessionScope.CURRENT_USER }" property="pseudo" value="deuxieme pseudo" />
        Deuxieme pseudo :
        <c:out value="${ sessionScope.CURRENT_USER.pseudo }" />
        <br/>
        <h3>Test conditionnel</h3>
        <c:choose>
        	<c:when test="${ sessionScope.CURRENT_USER.pseudo == 'deuxieme pseud' }"> True </c:when>
        	<c:otherwise> False </c:otherwise>
        </c:choose>
        <h3>Test boucle</h3>
        <table>
	        <c:forEach items="${ tableau_test }" var="s" >
	        	<tr><c:out value="${ s }" /></tr>
	        </c:forEach>
        </table>
	</body>
</html>