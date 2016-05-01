<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/head.jsp" %>

<body>
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>


    <div class="container marketing">
        <div class="mp-title">
            <h1> Modification d'un adhérent </h1>
        </div>
        <div>
            <form class="mp-form" name='identification' method="post" action="updaterAdherent&idAdherent=${idAdherent}" onsubmit="return test()">
                <div class="mp-input">
                    <p> Nom de l'adherent :</p>
                    <input class="form-control" type="text" name="txtnom" value="" id ="nom" required autofocus>
                </div>
                <div class="mp-input">
                    <p>Prenom de l'adherent :</p>
                    <input class="form-control" type="text" name="txtprenom"  id ="prenom" required>
                </div>
                <div class="mp-input">
                    <p>Ville de l'adherent :</p>
                    <input class="form-control" type="text" name="txtville" id ="ville" required>
                </div>
                <br/>
                <!-- Boutons Ajouter -->
                <div class="mp-input">
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Ajouter</button>
                </div>
            </form>
        </div>
    </div>

<%@ include file="/WEB-INF/views/includes/footer.jsp" %>