<%--
  Created by IntelliJ IDEA.
  User: vil
  Date: 11/03/16
  Time: 09:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/includes/head.jsp" %>
<body>
    <%@ include file="/includes/header.jsp" %>

    <div class="container marketing">
        <div class="mp-title">
            <h1>Liste des réservations</h1>
        </div>

        <table border="1" class="table table-bordered table-hover" >
            <tr>
                <th>Oeuvre</th>
                <th>Adhérent</th>
                <th>Date de réservation</th>
            </tr>

            <c:forEach items="${mesReservations}" var="resa">
            <tr>
                <td>${resa.getOeuvrevente().getTitreOeuvrevente()}</td>
                <td>${resa.getAdherent().getNomAdherent()}</td>
                <td>${resa.getDate()}</td>
            </tr>
            </c:forEach>
        </table>
    </div>
<%@ include file="/includes/footer.jsp" %>
