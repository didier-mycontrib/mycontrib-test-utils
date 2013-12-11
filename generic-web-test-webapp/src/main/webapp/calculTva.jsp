<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html
   xmlns:myweb2="urn:myweb2">
<head>
<script language="javascript" SRC="verif.js">
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calcul TVA</title>
</head>
<body>
<h1> CALCUL TVA </h1>
<!-- appel ici du servlet hjsDynServlet de façon a generer 
     le code "html+javascript" de la vue associee
     à la classe java "model_view.CalculTva" -->
<jsp:include page="hjsDynServlet?view=CalculTva"  />
<!--  le code javascript généré à besoin de verif.js 
      et eventuellement my_ajax.js a incorporer dans la partie
      <head> <script language="javascript" src=".....js"> ...
      de la page JSP courante -->
<hr/>
<a href="test_hjs.jsp">retour vers index / test_hjs</a>
</body>
</html>