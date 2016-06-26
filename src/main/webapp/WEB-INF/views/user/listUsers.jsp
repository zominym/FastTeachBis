<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/head.jsp" %>

<body>
	<%@ include file="/WEB-INF/views/includes/header.jsp" %>

	<div class="container marketing">
		<div class="mp-title">
			<h1>Liste des utilisateurs</h1>
		</div>

		<table border="1" class="table table-bordered table-hover" >
			<tr>
				<th>Numéro</th>
				<th>Prénom</th>
				<th>Nom</th>
				<th>Rôle</th>
				<th colspan="3" class="mp-th-center">Actions</th>
			</tr>

			<c:forEach items="${myUsers}" var="item">
			<tr>
				<td>${item.userId}</td>
				<td>${item.name}</td>
				<td>${item.surname}</td>
				<td>${item.role}</td>
				<c:if test="${item.role == 'TRAINEE'}">
					<td class="action"><a href="/trainee/details?ID=${item.userId}">details</a></td>
					<td class="action"><a href="/trainee/edit/form?ID=${item.userId}"><span class="fa fa-pencil-square-o"></span></a></td>
					<td class="action"><a href="/user/delete?ID=${item.userId}"><span class="fa fa-eraser"></span></a></td>
				</c:if>
				<c:if test="${item.role == 'TRAINER'}">
					<td class="action"><a href="/trainer/details?ID=${item.userId}">details</a></td>
					<td class="action"><a href="/trainer/edit?ID=${item.userId}"><span class="fa fa-pencil-square-o"></span></a></td>
					<td class="action"><a href="/user/delete?ID=${item.userId}"><span class="fa fa-eraser"></span></a></td>
				</c:if>
				<c:if test="${item.role == 'ADMIN'}">
					<td class="action">admin</td>
				</c:if>
			</tr>
			</c:forEach>
		</table>
	</div>

	<script src="/js/navActivate.js" data-navselector="mp-nav-listAdh"></script>

<%@ include file="/WEB-INF/views/includes/footer.jsp" %>