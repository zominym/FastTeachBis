<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/includes/head.jsp" %>

<body>
    <%@ include file="/includes/header.jsp" %>

	<!-- Three columns of text below the carousel -->
	<div class="container marketing">

		<div class="mp-title">
			<h2>Gestion de l'exposition 2016</h2>
			<p>Sélectionnez la fonctionnalité voulue</p>
		</div>

		<div class="row">
			<div class="col-lg-4">
				<a href="/Controleur?action=ajouterAdherent"><img class="img-circle" src="images/people_add.png" width="140" height="140"></a>
				<h2>Ajouter un adhérent</h2>
			</div><!-- /.col-lg-4 -->
			<div class="col-lg-4">
				<a href="/Controleur?action=listerAdherent"><img class="img-circle" src="images/people_list.png" width="140" height="140"></a>
				<h2>Lister les adhérents</h2>
			</div><!-- /.col-lg-4 -->
			<div class="col-lg-4">
				<a href="/Controleur?action=listerOeuvres"><img class="img-circle" src="images/books_list.png" width="140" height="140"></a>
				<h2>Lister les oeuvres</h2>
			</div><!-- /.col-lg-4 -->
		</div><!-- /.row -->
		<div class="row">
			<div class="col-lg-4">
				<a href="/Controleur?action=listerProprietaires"><img class="img-circle" src="images/book_owner.png" width="140" height="140"></a>
				<h2>Lister les proprietaires</h2>
			</div><!-- /.col-lg-4 -->
			<div class="col-lg-4">
				<a href="/Controleur?action=listerReservations"><img class="img-circle" src="images/resa_list.png" width="140" height="140"></a>
				<h2>Lister les réservations</h2>
			</div><!-- /.col-lg-4 -->
		</div><!-- /.row -->

	</div>

<%@ include file="/includes/footer.jsp" %>