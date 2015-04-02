<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sss" uri = "http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>www.prepas-concours.fr</h1>
	
	Recherche:
		
		<td>
		<form action="searchProduit.aspx" method="post">
			ID : <input type="text" name="idProduit" value = "${idProduit}">
			<input type="submit" value="Afficher">
		</form>
		<td>
		<td>
		<form action="index.aspx" method="post">
			<input type="submit" value="Tout Afficher">
		</form>
		<td>
	<hr/>
	Ajout:
		<form action="nouveauProduit.aspx" method="post">
			<table border="1" width="30%">
				<tr>
					<td>Nom</td>
					<td><input type="text" name="nom" value = "${produit.nom}"></td>
				</tr>
				<tr>
					<td>Description</td>
					<td><input type="text" name="description" value = "${produit.description}"></td>
				</tr>
				<tr>
					<td>Prix</td>
					<td><input type="text" name="prix" value = "${produit.prix}"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="Ajouter">
					</td>
				</tr>
			</table> 			
		</form>
	<hr/>
	<table border="1" width="50%">
		<tr>
			<td>Id</td>
			<td>Nom</td>
			<td>Description</td>
			<td>Prix</td>
			<td>Option</td>
		</tr>
		
		<!-- Liste produits -->	
		
		<sss:forEach items="${listeProduits}" var = "o">
			<tr>
				<td>${ o.idProduit }</td>
				<td>${ o.nom }</td>
				<td>${ o.description }</td>
				<td>${ o.prix } </td>
				<td>
					<a href="http://localhost:8080/SpringHibernateTP/supprimer.aspx?id=${ o.idProduit }">supprimer</a>
				</td>
				<!-- 
				<td>
					<form action="supprimer.aspx" method = "post">
						<input type="hidden" name="id" value = "${ o.idProduit }"/>
						<input type="hidden" name="action" value = "supprimer"/>
						<input type="submit" value="supprimer"/>
					</form> 			
				</td>
				 -->
				
			</tr>
		</sss:forEach>
		
	</table>
</body>
</html>