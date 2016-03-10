<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/includes/header.jsp" %>

<body>
	<%@ include file="/includes/pageHeader.jsp" %>
	<P align="center"><FONT face="Arial" size="5" color="#004080"><U> <STRONG>Listing des Oeuvres </STRONG></U></FONT><P>

	<TABLE BORDER="1" class="table table-bordered" >
		<CAPTION>Tableau des Oeuvres en pret</CAPTION>
		<TR>
			<TH>Id</TH>
			<TH>Titre</TH>
			<TH>Id Proprietaire</TH>
		</TR>

		<c:forEach items="${mesOeuvreprets}" var="item">
			<tr>
				<td>${item.idOeuvrepret}</td>
				<td>${item.titreOeuvrepret}</td>
				<td>${item.proprietaire.idProprietaire}</td>
			</tr>
		</c:forEach>
	</TABLE>

	<TABLE BORDER="1" class="table table-bordered" >
		<CAPTION>Tableau des Oeuvres en vente</CAPTION>
		<TR>
			<TH>Id</TH>
			<TH>Titre</TH>
			<TH>Etat</TH>
			<TH>Prix</TH>
			<TH>Id Proprietaire</TH>
			<TH>Reserver</TH>
			<TH>Supprimer</TH>
		</TR>

		<c:forEach items="${mesOeuvreventes}" var="item">
			<tr>
				<td>${item.idOeuvrevente}</td>
				<td>${item.titreOeuvrevente}</td>
				<td>${item.etatOeuvrevente}</td>
				<td>${item.prixOeuvrevente}</td>
				<td>${item.proprietaire.idProprietaire}</td>
				<td>
                    <form action="Controleur?" method="get">
                    <input type="hidden" name="action" value="reserverOeuvreVente"/>
                    <input type="hidden" name="idOeuvrevente" value="${item.idOeuvrevente}"/>
                    <select name="idAdherent" id="id_resa">
                        <c:forEach items="${mesAdherents}" var="ad">
                            <option value="${ad.idAdherent}">${ad.nomAdherent}</option>
                        </c:forEach>
                    </select>
                    <input type="submit">
                    </form>
				</td>
				<td><a href="Controleur?action=supprimerOeuvreVente&idOeuvrevente=${item.idOeuvrevente}">Supprimer</a></td>
			</tr>
		</c:forEach>
	</TABLE>


<%@ include file="/includes/footer.jsp" %>
