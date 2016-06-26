<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/head.jsp" %>
<body>
	<%@ include file="/WEB-INF/views/includes/header.jsp" %>

	<!-- Three columns of text below the carousel -->
	<div class="container marketing">

		<div class="mp-title">
			<h2>Application de formation à la conduite en aéroport</h2>
			<p>Sélectionnez la fonctionnalité voulue</p>
		</div>

		<div class="row">
			<div class="col-lg-4">
				<a href="users/list"><img class="img-circle" src="../../images/people_list.png" width="140" height="140"></a>
				<h2>Consulter la totalité des utilisateurs</h2>
			</div><!-- /.col-lg-4 -->
			<div class="col-lg-4">
				<a href="trainees/list"><img class="img-circle" src="../../images/people_list.png" width="140" height="140"></a>
				<h2>Consulter les apprenants</h2>
			</div><!-- /.col-lg-4 -->
			<div class="col-lg-4">
				<a href="trainers/list"><img class="img-circle" src="../../images/books_list.png" width="140" height="140"></a>
				<h2>Consulter les entraîneurs</h2>
			</div><!-- /.col-lg-4 -->
		</div><!-- /.row -->


	</div>
<%@ include file="/WEB-INF/views/includes/footer.jsp" %>