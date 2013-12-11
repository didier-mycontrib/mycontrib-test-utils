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
	  <a href="selection.jsp">Selection cat�gorie/produit (avec ajax)</a> <br/>
      <a href="Essais_ajax.html">essai ajax (html sans java)</a> <br/>
                                   <hr/>
	  <pre>
       Mini framework web bas� sur l'intropsection d'un JavaBean annot� avec:
       @DynInput pour input avec �ventuel @Min et @Max 
          de fa�on � g�n�rer automatiquement une v�rification de saisie en javascript 
       @DynOutput pour output
       @DynAction pour methode d'action li� au submit
       @DynInput(selectFrom="listeXxx") et @SelectItem pour g�n�ration automatique de liste d�roulante
       @AjaxOnChange(refresh="details_depends_on_me") pour rafraichir une liste d�tails via Ajax
       @DynView pour vue web globale englobant formulaire(input) + zones "output" 
       -------
       A peaufiner : * pr�sentation (via tableau et classe CSS)
                     * param�trages fins (libell�s sp�cifiques, ...) 
                     * tests pour am�liorer fiabilit�/robustesse
                     * int�grer ce mini framework dans un framework englobant de type Spring WEB MVC
                       pour b�n�ficier globalement :
                            - d'une navigation centralis�e "MVC2 / Front controller"
                            - d'une prise en charge "IOC" pour injection des services m�tiers en arri�re plan
	  </pre>
</body>
</html>