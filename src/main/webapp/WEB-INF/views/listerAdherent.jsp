<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/head.jsp" %>

<body>
	<%@ include file="/WEB-INF/views/includes/header.jsp" %>

	<div class="container marketing">
		<div class="mp-title">
			<h1>Liste des adhérents</h1>
		</div>


		<table border="1" class="table table-bordered table-hover" >
			<tr>
				<th>Numéro</th>
				<th>Nom</th>
				<th>Prénom</th>
				<th>Ville</th>
				<th colspan="2" class="mp-th-center">Actions</th>
			</tr>

			<c:forEach items="${mesAdherents}" var="item">
			<tr>
				<td>${item.idAdherent}</td>
				<td>${item.nomAdherent}</td>
				<td>${item.prenomAdherent}</td>
				<td>${item.villeAdherent}</td>
				<td class="action"><a href="modifierAdherent&idAdherent=${item.idAdherent}"><span class="fa fa-pencil-square-o"></span></a></td>
				<td class="action"><a href="supprimerAdherent&idAdherent=${item.idAdherent}"><span class="fa fa-eraser"></span></a></td>
			</tr>
			</c:forEach>
		</table>
	</div>

	<script src="/js/navActivate.js" data-navselector="mp-nav-listAdh"></script>

<%@ include file="/WEB-INF/views/includes/footer.jsp" %>