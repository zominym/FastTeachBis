<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/includes/head.jsp" %>

<body>
	<%@ include file="/includes/header.jsp" %>
	<div class="container marketing">
		<div class="mp-title">
			<h1>Liste des oeuvres</h1>
		</div>

		<table border="1" class="table table-bordered table-hover" >
			<caption>Oeuvres en prêt</caption>
			<tr>
				<th>Titre</th>
				<th>Proprietaire</th>
			</tr>

			<c:forEach items="${mesOeuvreprets}" var="item">
			<tr>
				<td>${item.getTitreOeuvrepret()}</td>
				<td>${item.getProprietaire().getNomProprietaire()} ${item.getProprietaire().getPrenomProprietaire()}</td>
			</tr>
			</c:forEach>
		</table>

		<table border="1" class="table table-bordered table-hover" >
			<caption>Tableau des Oeuvres en vente</caption>
			<tr>
				<th>Titre</th>
				<th class="mp-th-center">Etat</th>
				<th>Prix</th>
				<th>Proprietaire</th>
				<th>Réserver pour ...</th>
				<th class="mp-th-center">Supprimer</th>
			</tr>

			<c:forEach items="${mesOeuvreventes}" var="item">
			<tr>
				<td>${item.titreOeuvrevente}</td>
				<td class="mp-th-center">
					<c:choose>
						<c:when test="${item.etatOeuvrevente == 'L'}">
							<span class="fa fa-unlock"></span>
						</c:when>
						<c:otherwise>
							<span class="fa fa-lock"></span>
						</c:otherwise>
					</c:choose>
				</td>
				<td>${item.prixOeuvrevente} €</td>
				<td>${item.getProprietaire().getNomProprietaire()} ${item.proprietaire.getPrenomProprietaire()}</td>
				<td class="mp-th-center">
				<c:if test="${item.etatOeuvrevente == 'L'}">
					<form action="Controleur?" method="get">
						<input type="hidden" name="action" value="reserverOeuvreVente"/>
						<input type="hidden" name="idOeuvrevente" value="${item.idOeuvrevente}"/>
						<select class="selectpicker" name="idAdherent" id="id_resa">
						<c:forEach items="${mesAdherents}" var="ad">
							<option value="${ad.idAdherent}">${ad.nomAdherent}</option>
						</c:forEach>
						</select>
						<button class="btn btn-default" type="submit">Réserver</button>
					</form>
				</c:if>
				</td>
				<td class="action"><a href="Controleur?action=supprimerOeuvreVente&idOeuvrevente=${item.idOeuvrevente}"><span class="fa fa-eraser"></span></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<script src="/js/navActivate.js" data-navselector="mp-nav-listO"></script>

<%@ include file="/includes/footer.jsp" %>
