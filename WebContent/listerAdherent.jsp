<%@ include file="/includes/header.jsp" %>

<body>
	<P>
		<A href="index.jsp"><FONT face="Arial" color="#004080">Retour
				Accueil</FONT></A>
	</P>
	<P align="center">
		<FONT face="Arial" size="5" color="#004080"><U> <STRONG>Listing&nbsp;des
					Adh�rents </STRONG></U></FONT>
	</P>

	<TABLE BORDER="1" class="table table-bordered">
		<CAPTION>Tableau des Adh�rents</CAPTION>
		<TR>
			<TH>Numero</TH>
			<TH>Nom</TH>
			<TH>Pr�nom</TH>
			<TH>Ville</TH>

		</TR>

		<c:forEach items="${mesAdherents}" var="item">
			<tr>
				<td>${item.idAdherent}</td>
				<td>${item.nomAdherent}</td>
				<td>${item.prenomAdherent}</td>
                <td>${item.villeAdherent}</td>
			</tr>
		</c:forEach>
	</TABLE>

<%@ include file="/includes/footer.jsp" %>