<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/head.jsp" %>

<body>
	<%@ include file="/WEB-INF/views/includes/header.jsp" %>

	<div class="container marketing">
		<div class="mp-title">
			<h1>Liste des propriétaires</h1>
		</div>

		<table border="1" class="table table-bordered table-hover" >
			<tr>
				<th>Numero</th>
				<th>Nom</th>
				<th>Prénom</th>
				<th class="mp-th-center">Ajouter une oeuvre</th>
			</tr>

			<c:forEach items="${mesProprietaires}" var="item">
			<tr>
				<td>${item.idProprietaire}</td>
				<td>${item.nomProprietaire}</td>
				<td>${item.prenomProprietaire}</td>
				<td class="action"><a href="ajouterOeuvreVente?idProprietaire=${item.idProprietaire}"><span class="fa fa-plus-square"></span></a></td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<script src="/js/navActivate.js" data-navselector="mp-nav-listOw"></script>

<%@ include file="/WEB-INF/views/includes/footer.jsp" %>