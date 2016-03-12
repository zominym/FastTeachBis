<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/includes/head.jsp" %>

<body>
    <%@ include file="/includes/header.jsp" %>
    <div class="container marketing">
        <div class="mp-title">
            <h1> Ajout d'une oeuvre pour la vente</h1>
        </div>

        <form class="mp-form" name='identification' method="post" action="Controleur?action=insererOeuvreVente&idProprietaire=${idProprietaire}" onsubmit="return test()">
            <div class="mp-input">
                <p>Nom de l'oeuvre : </p>
                <input class="form-control" type="text" name="txtnom" value=""  id ="nom">
            </div>

            <div class="mp-input">
                <p>Prix de l'oeuvre :</p>
                <div class="input-group">
                    <input class="form-control" type="number" name="numprix" id ="ville">
                    <div class="input-group-addon">€</div>
                </div>

            </div>

            <div class="mp-input">
                <button class="btn btn-lg btn-primary btn-block" type="submit">Ajouter</button>
            </div>

        </form>
        <BR>
    </div>

<%@ include file="/includes/footer.jsp" %>