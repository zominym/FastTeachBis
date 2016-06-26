<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/head.jsp" %>

<body>
	<%@ include file="/WEB-INF/views/includes/header.jsp" %>

	<div class="container marketing">
		<div class="mp-title">
			<h1>Liste des missions du jeu : ${game.gameLabel}</h1>
		</div>

		<table border="1" class="table table-bordered table-hover" >
			<tr>
				<th>Numéro</th>
				<th>Label</th>
				<th colspan="3" class="mp-th-center">Actions</th>
			</tr>

			<c:forEach items="${missions}" var="item">
			<tr>
				<td>${item.missionId}</td>
				<td>${item.missionLabel}</td>
				<td class="action"><a href="/mission/details?ID=${item.missionId}">details</a></td>
				<td class="action"><a href="/mission/edit?ID=${item.missionId}"><span class="fa fa-pencil-square-o"></span></a></td>
				<td class="action"><a href="/mission/delete?ID=${item.missionId}"><span class="fa fa-eraser"></span></a></td>
			</tr>
			</c:forEach>
		</table>
	</div>

	<script src="/js/navActivate.js" data-navselector="mp-nav-listAdh"></script>

<%@ include file="/WEB-INF/views/includes/footer.jsp" %>