<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/head.jsp" %>

<body>
	<%@ include file="/WEB-INF/views/includes/header.jsp" %>

	<div class="container marketing">

		<div class="mp-title">
			<h1>Resume de l'action</h1>
			<ul>
				<li>${action.actionId}</li>
				<li>${action.libaction}</li>
				<li>${action.scoremin}</li>
				<li><a href="/action/details?ID=${action.successor}">${action.successor}</a></li>
			</ul>

		</div>

		<div class="mp-title">
			<h1>Liste des action enfants</h1>
		</div>


		<table border="1" class="table table-bordered table-hover" >
			<tr>
				<th>Numéro</th>
				<th>Label</th>
				<th>Score Minimum</th>
				<th>Action Successeur</th>
				<th colspan="3" class="mp-th-center">Actions</th>
			</tr>

			<c:forEach items="${children}" var="item">
				<tr>
					<td>${item.actionId}</td>
					<td>${item.libaction}</td>
					<td>${item.scoremin}</td>
					<td><a href="/action/details?ID=${item.successor}">${item.successor}</a></td>
					<td class="action"><a href="/action/details?ID=${item.actionId}">details</a></td>
					<td class="action"><a href="/action/edit?ID=${item.actionId}"><span class="fa fa-pencil-square-o"></span></a></td>
					<td class="action"><a href="/action/delete?ID=${item.actionId}"><span class="fa fa-eraser"></span></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<script src="/js/navActivate.js" data-navselector="mp-nav-listAdh"></script>

<%@ include file="/WEB-INF/views/includes/footer.jsp" %>