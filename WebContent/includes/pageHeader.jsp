<%--
  Created by IntelliJ IDEA.
  User: vil
  Date: 13/02/16
  Time: 21:15
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<head>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">Médiathèque de POLYTECH</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="/ProjetOeuvres">Accueil</a></li>
                    <li><a href="Controleur?action=ajouterAdherent">Ajout adhérents</a></li>
                    <li><a href="Controleur?action=listerAdherent">Lister les adhérents</a></li>
                    <li><a href="Controleur?action=listerOeuvres">Lister les oeuvres</a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
    </nav>
</head>