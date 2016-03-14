<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/includes/head.jsp" %>

<%--<script type="text/javascript" src="js/fonctControle.js" />--%>

<body>
    <%@ include file="/includes/header.jsp" %>

    <div class="container marketing">
        <div class="mp-title">
            <h1> Ajout d'un adhérent </h1>
        </div>
        <div>
            <form class="mp-form" name='identification' method="post" action="Controleur?action=insererAdherent" onsubmit="return test()">
                <div class="mp-input">
                    <p> Nom de l'adherent :</p>
                    <input class="form-control" type="text" name="txtnom" value="" id ="nom">
                </div>
                <div class="mp-input">
                    <p>Prenom de l'adherent :</p>
                    <input class="form-control" type="text" name="txtprenom"  id ="prenom">
                </div>
                <div class="mp-input">
                    <p>Ville de l'adherent :</p>
                    <input class="form-control" type="text" name="txtville" id ="ville">
                </div>
                <br/>
                <!-- Boutons Ajouter -->
                <div class="mp-input">
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Ajouter</button>
                </div>
            </form>
        </div>
    </div>

    <script src="js/navActivate.js" data-navselector="mp-nav-addAdh"></script>

<%@ include file="/includes/footer.jsp" %>