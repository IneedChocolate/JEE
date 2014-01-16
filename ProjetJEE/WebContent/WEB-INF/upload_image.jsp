<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Enregistrement d'une image</title>
	</head>
	<body>
		<jsp:include page="menu.jsp" />
		<form method="POST" action="Upload_creation" enctype="multipart/form-data">
		
			<c:forEach items="${ tableau_test }" var="s" >
	        	<tr><c:out value="${ s }" /></tr>
	        </c:forEach>
	        
			<label>Selectionner l'image à enregistrer</label>
			<input type="file" name="image_name" id="image_name" />
			<input type="submit" value="Enregistrer" />
		</form>
	</body>
</html>