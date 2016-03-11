<%--
  Created by IntelliJ IDEA.
  User: vil
  Date: 11/03/16
  Time: 09:25
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/includes/header.jsp" %>
<body>
    <%@ include file="/includes/pageHeader.jsp" %>

    <P align="center"><STRONG>Listing des réservations </STRONG></P>

    <TABLE BORDER="1" class="table table-bordered" >
        <CAPTION>Tableau des réservations</CAPTION>
        <TR>
            <TH>Oeuvre</TH>
            <TH>Adhérent</TH>
            <TH>Date de réservation</TH>
        </TR>

        <c:forEach items="${mesReservations}" var="resa">
            <tr>
                <td>${resa.getOeuvrevente().getTitreOeuvrevente()}</td>
                <td>${resa.getAdherent().getNomAdherent()}</td>
                <td>${resa.getDate()}</td>
            </tr>
        </c:forEach>
    </TABLE>

