<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>myWeb2</title>
</head>
<body>
	  <a href="calculTva.jsp">calcul de Tva (sans ajax)</a> <br/>
	  <a href="selection.jsp">Selection catégorie/produit (avec ajax)</a> <br/>
      <a href="Essais_ajax.html">essai ajax (html sans java)</a> <br/>
                                   <hr/>
	  <pre>
       Mini framework web basé sur l'intropsection d'un JavaBean annoté avec:
       @DynInput pour input avec éventuel @Min et @Max 
          de façon à générer automatiquement une vérification de saisie en javascript 
       @DynOutput pour output
       @DynAction pour methode d'action lié au submit
       @DynInput(selectFrom="listeXxx") et @SelectItem pour génération automatique de liste déroulante
       @AjaxOnChange(refresh="details_depends_on_me") pour rafraichir une liste détails via Ajax
       @DynView pour vue web globale englobant formulaire(input) + zones "output" 
       -------
       A peaufiner : * présentation (via tableau et classe CSS)
                     * paramétrages fins (libellés spécifiques, ...) 
                     * tests pour améliorer fiabilité/robustesse
                     * intégrer ce mini framework dans un framework englobant de type Spring WEB MVC
                       pour bénéficier globalement :
                            - d'une navigation centralisée "MVC2 / Front controller"
                            - d'une prise en charge "IOC" pour injection des services métiers en arrière plan
	  </pre>
</body>
</html>