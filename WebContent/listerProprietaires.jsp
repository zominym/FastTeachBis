<%@ include file="/includes/header.jsp" %>

<body>
	<%@ include file="/includes/pageHeader.jsp" %>
	<P align="center"><FONT face="Arial" size="5" color="#004080"><U>
<STRONG>Listing des Adhérents </STRONG></U></FONT><P>

	<TABLE BORDER="1" class="table table-bordered" >
		<CAPTION>Tableau des Proprietaires</CAPTION>
		<TR>
			<TH>Numero</TH>
			<TH>Nom</TH>
			<TH>Prénom</TH>
			<TH>Ajouter Oeuvre Vente</TH>
		</TR>

		<c:forEach items="${mesProprietaires}" var="item">
			<tr>
				<td>${item.idProprietaire}</td>
				<td>${item.nomProprietaire}</td>
				<td>${item.prenomProprietaire}</td>
                <td><a href="Controleur?action=ajouterOeuvreVente&idProprietaire=${item.idProprietaire}">Ajouter Oeuvre Vente</a></td>
			</tr>
		</c:forEach>
	</TABLE>

<%@ include file="/includes/footer.jsp" %>