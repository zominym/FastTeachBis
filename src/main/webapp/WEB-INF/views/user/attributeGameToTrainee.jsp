<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/head.jsp" %>

<%--<script type="text/javascript" src="js/fonctControle.js" />--%>

<body>
<%@ include file="/WEB-INF/views/includes/header.jsp" %>

<div class="container marketing">
    <div class="mp-title">
        <h1> Attribution d'un jeu à un apprenti</h1>
    </div>
    <div>
        <form class="mp-form" name='identification' method="post" action="trainee/attribute/validation" onsubmit="return test()">

            <div class="mp-input">
                <p>Apprenti :</p>
                <select class="form-control" name="slcuser" id ="user" required>
                    <c:forEach items="${myUsers}" var="item">
                        <option value=${item.id}>${item.name} ${item.surname}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="mp-input">
                <p>Jeu à attribuer :</p>
                <select class="form-control" name="slcgame" id ="game" required>
                    <c:forEach items="${myGames}" var="item">
                        <option value=${item.gameId}>${item.gameLabel}</option>
                    </c:forEach>
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
