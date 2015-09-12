<%@ page contentType="text/html" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html lang="en-US">
	<head>
		<script language="JavaScript" type="text/javascript" src="//code.jquery.com/jquery-1.11.3.min.js"></script>
		<script language="JavaScript" type="text/javascript" src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
		<link rel="stylesheet" type="text/css" href="css/style.css"/>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css"/>
	</head>
	<body>
		<div id="container">
			<div id="header">
				<div class="header-logo">
					<img src="images/logo.png" class="logo" alt="Food Now"/>
					<button type="button" class="btn login-button" aria-label="Left Align">
						<span class="glyphicon glyphicon-user login-span" aria-hidden="true"></span>
						<p class="enter">INGRESAR</p>
					</button>
				</div>    
			    <div class="row">
					<div class="col-md-12">
						<div class="tabbable-panel">
							<div class="tabbable-line">
								<ul class="nav nav-tabs ">
									<li class="active">
										<a href="#tab_default_1" data-toggle="tab">
											<span class="glyphicon glyphicon-home home-span" aria-hidden="true"></span>
										</a>
									</li>
									<li>
										<a href="#tab_default_2" data-toggle="tab">
										RESTORANES </a>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>