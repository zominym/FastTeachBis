<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/head.jsp" %>

<body>
	<%@ include file="/WEB-INF/views/includes/header.jsp" %>

	<div class="container marketing">
		<div class="mp-title">
			<h1>Liste des objectifs de la mission : ${mission.missionLabel}</h1>
		</div>

		<table border="1" class="table table-bordered table-hover" >
			<tr>
				<th>Numéro</th>
				<th>Label</th>
				<th>Score Minimum</th>
				<th colspan="3" class="mp-th-center">Actions</th>
			</tr>

			<c:forEach items="${objectives}" var="item">
			<tr>
				<td>${item.objectiveId}</td>
				<td>${item.objectiveLabel}</td>
				<td>${item.totalScoreMin}</td>
				<td class="action"><a href="/objective/details?ID=${item.objectiveId}">details</a></td>
				<td class="action"><a href="/objective/edit?ID=${item.objectiveId}"><span class="fa fa-pencil-square-o"></span></a></td>
				<td class="action"><a href="/objective/delete?ID=${item.objectiveId}"><span class="fa fa-eraser"></span></a></td>
			</tr>
			</c:forEach>
		</table>
	</div>

	<script src="/js/navActivate.js" data-navselector="mp-nav-listAdh"></script>

<%@ include file="/WEB-INF/views/includes/footer.jsp" %>