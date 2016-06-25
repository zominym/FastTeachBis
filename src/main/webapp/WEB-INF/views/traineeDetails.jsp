<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/head.jsp" %>

<body>
	<%@ include file="/WEB-INF/views/includes/header.jsp" %>

	<div class="container marketing">

		<div class="mp-title">
			<h1>Resume de l'apprenant</h1>
			<ul>
				<li>${trainee.ID}</li>
				<li>${trainee.name}</li>
				<li>${trainee.surname}</li>
				<li>${trainee.mail}</li>
			</ul>

		</div>

		<div class="mp-title">
			<h1>Liste des jeux</h1>
		</div>


		<table border="1" class="table table-bordered table-hover" >
			<tr>
				<th>Numéro</th>
				<th>Label</th>
			</tr>

			<c:forEach items="${traineeGames}" var="item">
			<tr>
				<td>${item.gameId}</td>
				<td>${item.gameLabel}</td>
			</tr>
			</c:forEach>
		</table>
	</div>

	<script src="/js/navActivate.js" data-navselector="mp-nav-listAdh"></script>

<%@ include file="/WEB-INF/views/includes/footer.jsp" %>