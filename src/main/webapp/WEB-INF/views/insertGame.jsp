<%--
  Created by IntelliJ IDEA.
  User: sydne
  Date: 26/06/2016
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="/WEB-INF/views/includes/header.jsp" %>

<div class="container marketing">
    <div class="mp-title">
        <h1> Ajout d'un utilisateur </h1>
    </div>
    <div>
        <form class="mp-form" name='identification' method="post" action="insertGame" onsubmit="return test()">
            <div class="mp-input">
                <p> Description du Jeu :</p>
                <input class="form-control" type="text" name="txtlabel" value="" id ="label" required autofocus>
            </div>
            <br/>
            <!-- Boutons Ajouter -->
            <div class="mp-input">
                <button class="btn btn-lg btn-primary btn-block" type="submit">Ajouter</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
