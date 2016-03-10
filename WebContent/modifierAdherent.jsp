<%@ include file="/includes/header.jsp" %>

<SCRIPT language="Javascript" type="text/javascript">
<script type="text/javascript" src="js/foncControle.js"></script>

<body>
    <%@ include file="/includes/pageHeader.jsp" %>
	<H1> Modification d'un adhérent </H1>

<DIV align="center">
<FORM  name='identification' method="post" action="Controleur?action=updaterAdherent&idAdherent=${idAdherent}" onsubmit="return teste()">
     <P align="left"><FONT face="Arial" color="#004080"></FONT>
     
		<FONT face="Arial" color="#004080"> <BR>&nbsp;  &nbsp;  &nbsp; Nom de l'adherent : </FONT>
	    <INPUT type="text" name="txtnom" value=""  id ="nom"> <BR>
        <FONT face="Arial" color="#004080">
		<BR>Prenom de l'adherent : </FONT>
        <INPUT type="text" name="txtprenom"  id ="prenom"  > <BR>
        
        <FONT face="Arial" color="#004080"> <BR>&nbsp;  &nbsp;  &nbsp; Ville de l'adherent :</FONT>
        <INPUT type="text" name="txtville" id ="ville">
        <FONT face="Arial" color="#004080">	<BR></FONT><BR>
        
          <!-- Boutons Modifier -->
          
        <INPUT type="submit" name="bt"  value="Modifier" >
        <FONT face="Arial" color="#004080"></FONT>
        &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      
</P></FORM>
</DIV>
<BR>

<%@ include file="/includes/footer.jsp" %>