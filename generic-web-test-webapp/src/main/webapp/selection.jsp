<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html
   xmlns:myweb2="urn:myweb2">
<head>
<script language="javascript" SRC="verif.js">
</script>
<script language="javascript" src="my_ajax.js">
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Selection</title>
</head>
<body>
<h1> SELECTION (1:catégorie , 2:produit)</h1>
<!-- appel ici du servlet hjsDynServlet de façon a generer 
     le code "html+javascript" de la vue associee
     a la classe java "model_view.Selection" -->
<jsp:include page="hjsDynServlet?view=Selection" />
<!--  le code javascript genere a besoin de verif.js 
      et eventuellement my_ajax.js a incorporer dans la partie
      <head> <script language="javascript" src=".....js"> ...
      de la page JSP courante -->
<hr/>
<a href="test_hjs.jsp">retour vers index / test_hjs</a>
</body>
</html>