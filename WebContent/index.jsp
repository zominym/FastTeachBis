<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/includes/header.jsp" %>

<body>
    <%@ include file="/includes/pageHeader.jsp" %>

	<h2>Gestion de l'exposition 2016</h2>
	<p>Sélectionnez la fonctionnalité voulue</p>
	<ul>
		<li><a href="Controleur?action=ajouterAdherent">Ajout Adhérent</a></li>
		<li><a href="Controleur?action=listerAdherent">Lister les adhérents</a></li>
		<li><a href="Controleur?action=listerOeuvres">Lister les oeuvres</a></li>
	</ul>

<%@ include file="/includes/footer.jsp" %>