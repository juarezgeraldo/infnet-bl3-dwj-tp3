<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!DOCTYPE html>
		<html>

		<c:import url="/WEB-INF/jsp/header.jsp"></c:import>

		<body>

			<c:import url="/WEB-INF/jsp/menu.jsp"></c:import>

			<div class="container">
				<h3>Sistema de encomendas para artesanato</h3>
				<h4>AT da disciplina de Desenvolvimento Web com Java EE</h4>
				<br />
				<br />
				<br />
				<h4>Estatística de registros no sistema:</h4>
				<ul class="list-group">
					<li class="list-group-item">Quantidade de Usuários <span class="badge">${qtUsuarios}</span></li>
					<li class="list-group-item">Quantidade de Clientes <span class="badge">${qtClientes}</span></li>
					<li class="list-group-item">Quantidade de Acessórios <span class="badge">${qtAcessorios}</span></li>
					<li class="list-group-item">Quantidade de Bolsas <span class="badge">${qtBolsas}</span></li>
					<li class="list-group-item">Quantidade de Decorações <span class="badge">${qtDecoracoes}</span></li>
					<li class="list-group-item">Quantidade de itens de Artesanato <span
							class="badge">${qtArtesanatos}</span></li>
					<li class="list-group-item">Quantidade de Encomendas <span class="badge">${qtEncomendas}</span></li>
				</ul>
			</div>

		</body>

		</html>