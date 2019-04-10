	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	    pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Online Shopping</title>
	<link rel="stylesheet" type="text/css" href="http://localhost:8080/OnlineShopping/resources/libraries/css/bootstrap.css"/>
	<link href="https://cdn.datatables.net/1.10.9/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css" href="http://localhost:8080/OnlineShopping/resources/styles/custom.css"/>
	</head>
	
	<body id="page-top" class="index">
		<nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a tabindex="-1" class="navbar-brand" href="${pageContext.request.contextPath }">Online Shopping</a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
					<li class="dropdown">
					<li><a href="/OnlineShopping/user/viewCategories">View Categories</a></li>
					<li><a href="/OnlineShopping/user/viewProducts">View Products</a></li>
                    <li class="dropdown">
                        <a tabindex="-1" href="#" class="dropdown-toggle" data-toggle="dropdown">Admin<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                          <li><a href="/OnlineShopping/admin/viewUsers">View/Edit Users</a></li>
                          <li><a href="/OnlineShopping/admin/viewOrders">View/Edit Orders</a></li>
                          <li><a href="/OnlineShopping/admin/editCategories">Edit Categories</a></li>
                          <li><a href="/OnlineShopping/admin/editProducts">Edit Products</a></li>
                        </ul>
                    </li>
                    <c:if test = "${empty pageContext.request.userPrincipal}">
                		<li><a href="/OnlineShopping/registration">Register</a></li>
      				</c:if>
      				<c:if test = "${not empty pageContext.request.userPrincipal}">
                    	<li class="dropdown">
                        	<a tabindex="-1" href="#" class="dropdown-toggle" data-toggle="dropdown">Welcome: <c:out value="${pageContext.request.userPrincipal.name}"/><b class="caret"></b></a>
                        	<ul class="dropdown-menu">
                    			<li><a href="/OnlineShopping/user/updateInfo">Update Info</a></li>
                    			<li><a href="/OnlineShopping/user/viewUserOrders">View User Orders</a></li>
	             	   			<li><a href="/OnlineShopping/logout">Logout</a></li>
                			</ul>
                		</li>
      				</c:if>
                </ul>
            </div>
        </div>
    </nav>