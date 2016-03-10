<%@ include file="/includes/header.jsp" %>

<SCRIPT language="Javascript" type="text/javascript">
<script type="text/javascript" src="js/foncControle.js"></script>

<body>
    <%@ include file="/includes/pageHeader.jsp" %>
	<H1> Ajout d'une Oeuvre Vente </H1>

<DIV align="center">
<FORM  name='identification' method="post" action="Controleur?action=insererOeuvreVente&idProprietaire=${idProprietaire}" onsubmit="return teste()">
     <P align="left"><FONT face="Arial" color="#004080"></FONT>
       
		<FONT face="Arial" color="#004080"> <BR>&nbsp;  &nbsp;  &nbsp; Nom de l'oeuvre : </FONT>
	    <INPUT type="text" name="txtnom" value=""  id ="nom"> <BR>
        <FONT face="Arial" color="#004080"> <BR></FONT><BR>
		
		     <FONT face="Arial" color="#004080"> <BR>&nbsp;  &nbsp;  &nbsp; Prix de l'oeuvre :</FONT>
        <INPUT type="number" name="numprix" id ="ville">
        <FONT face="Arial" color="#004080">	<BR></FONT><BR>
        
          <!-- Boutons Ajouter -->
          
        <INPUT type="submit" name="bt"  value="Ajouter" >
        <FONT face="Arial" color="#004080"></FONT>
        &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      
</P></FORM>
</DIV>
<BR>

<%@ include file="/includes/footer.jsp" %>