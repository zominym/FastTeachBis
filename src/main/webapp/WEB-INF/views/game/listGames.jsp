<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/head.jsp" %>

<body>
	<%@ include file="/WEB-INF/views/includes/header.jsp" %>

	<div class="container marketing">
		<div class="mp-title">
			<h1>Liste des jeux</h1>
		</div>

		<table border="1" class="table table-bordered table-hover" >
			<tr>
				<th>Numéro</th>
				<th>Prénom</th>
				<th>Nom</th>
				<th>Rôle</th>
				<th colspan="3" class="mp-th-center">Actions</th>
			</tr>

			<c:forEach items="${games}" var="item">
			<tr>
				<td>${item.gameId}</td>
				<td>${item.gameLabel}</td>
				<td class="action"><a href="/game/details?ID=${item.gameId}">details</a></td>

				<td class="action"><a href="/game/edit?ID=${item.gameId}"><span class="fa fa-pencil-square-o"></span></a></td>
				<td class="action"><a href="/game/delete?ID=${item.gameId}"><span class="fa fa-eraser"></span></a></td>
			</tr>
			</c:forEach>
		</table>
	</div>

	<script src="/js/navActivate.js" data-navselector="mp-nav-listAdh"></script>

<%@ include file="/WEB-INF/views/includes/footer.jsp" %>