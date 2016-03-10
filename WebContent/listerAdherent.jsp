<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/includes/header.jsp" %>

<body>
	<%@ include file="/includes/pageHeader.jsp" %>
	<P align="center"><FONT face="Arial" size="5" color="#004080"><U>
<STRONG>Listing des Adhérents </STRONG></U></FONT><P>

	<TABLE BORDER="1" class="table table-bordered" >
		<CAPTION>Tableau des Adhérents</CAPTION>
		<TR>
			<TH>Numero</TH>
			<TH>Nom</TH>
			<TH>Prénom</TH>
			<TH>Ville</TH>
			<TH>Modifier</TH>
			<TH>Supprimer</TH>
		</TR>

		<c:forEach items="${mesAdherents}" var="item">
			<tr>
				<td>${item.idAdherent}</td>
				<td>${item.nomAdherent}</td>
				<td>${item.prenomAdherent}</td>
                <td>${item.villeAdherent}</td>
                <td><a href="Controleur?action=modifierAdherent&idAdherent=${item.idAdherent}">Modifier</a></td>
                <td><a href="Controleur?action=supprimerAdherent&idAdherent=${item.idAdherent}">Supprimer</a></td>
            </tr>
		</c:forEach>
	</TABLE>

<%@ include file="/includes/footer.jsp" %>