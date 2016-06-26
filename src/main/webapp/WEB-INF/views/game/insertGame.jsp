<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/head.jsp" %>

<body>
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>

    <div class="container marketing">
        <div class="mp-title">
            <h1> Ajout d'un utilisateur </h1>
        </div>
        <div>
            <form class="mp-form" name='identification' method="post" action="do" onsubmit="return test()">
                <div class="mp-input">
                    <p> Label du Jeu :</p>
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
