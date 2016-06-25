<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/head.jsp" %>

<%--<script type="text/javascript" src="js/fonctControle.js" />--%>

<body>
<%@ include file="/WEB-INF/views/includes/header.jsp" %>

<div class="container marketing">
    <div class="mp-title">
        <h1> Ajout d'un utilisateur </h1>
    </div>
    <div>
        <form class="mp-form" name='identification' method="post" action="insertUser" onsubmit="return test()">
            <div class="mp-input">
                <p> Nom de l'utilisateur :</p>
                <input class="form-control" type="text" name="txtname" value="" id ="name" required autofocus>
            </div>
            <div class="mp-input">
                <p>Prenom de l'utilisateur :</p>
                <input class="form-control" type="text" name="txtfirstname"  id ="firstname" required>
            </div>
            <div class="mp-input">
                <p>Adresse email de l'utilisateur :</p>
                <input class="form-control" type="text" name="txtemail" id ="email" required>
            </div>
            <div class="mp-input">
                <p>Mot de passe de l'utilisateur :</p>
                <input class="form-control" type="password" name="pwd" id ="password" required>
            </div>
            <div class="mp-input">
                <p>Adresse email de l'utilisateur :</p>
                <select class="form-control" name="slcrole" id ="role" required>
                    <option value="trainee" selected>Apprenti</option>
                    <option value="trainer">Entraîneur</option>
                    <option value="admin">Admnistrateur</option>
                </select>
            </div>
            <br/>
            <!-- Boutons Ajouter -->
            <div class="mp-input">
                <button class="btn btn-lg btn-primary btn-block" type="submit">Ajouter</button>
            </div>
        </form>
    </div>
</div>

<script src="../../js/navActivate.js" data-navselector="mp-nav-addAdh"></script>

<%@ include file="/WEB-INF/views/includes/footer.jsp" %>