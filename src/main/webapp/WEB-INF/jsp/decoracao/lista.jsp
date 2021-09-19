<%@page import="br.edu.infnet.appArtesanato.model.domain.Bolsa" %>
	<%@page import="java.util.List" %>
		<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
				<!DOCTYPE html>
				<html>

				<c:import url="/WEB-INF/jsp/header.jsp"></c:import>


				<body>

					<c:import url="/WEB-INF/jsp/menu.jsp"></c:import>

					<div class="container">

						<form action="/decoracao" method="GET">
							<button type="submit" class="btn btn-link">Incluir</button>
						</form>

						<hr>

						<c:if test="${not empty lista}">
							<c:if test="${not empty msg}">
								<c:if test="${not empty idMsg}">
									<c:if test="${idMsg == 'sucesso'}">
										<div class="alert alert-success">
											<strong>Sucesso!</strong> ${msg}
										</div>
									</c:if>
									<c:if test="${idMsg == 'erro'}">
										<div class="alert alert-danger">
											<strong>ERRO!</strong> ${msg}
										</div>
									</c:if>
								</c:if>
								<c:if test="${empty idMsg}">
									<div class="alert alert-success">
										<strong>Sucesso!</strong> ${msg}
									</div>
								</c:if>
							</c:if>

							<h4>Quantidade de decorações cadastradas: ${lista.size()}!!!</h4>

							<hr>

							<table class="table table-striped">
								<thead>
									<tr>
										<th>Id</th>
										<th>Tipo</th>
										<th>Nome</th>
										<th>Fabricação própria</th>
										<th>Qtd Peças</th>
										<th>É de vidro?</th>
										<th>Valor base</th>
										<th>Usuário do cadastro</th>
										<th>Ação</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="a" items="${lista}">
										<tr>
											<td>${a.id}</td>
											<td style="text-align:center">${a.tipo}</td>
											<td style="text-align:center">
												<c:choose>
													<c:when test="${a.proprio}">
														<span>Sim</span>
													</c:when>
													<c:when test="${!a.proprio}">
														<span>Não</span>
													</c:when>
												</c:choose>
											</td>
											<td>${a.nome}</td>
											<td style="text-align:center">${a.qtdPecasConjunto}</td>
											<td style="text-align:center">
												<c:choose>
													<c:when test="${a.vidro}">
														<span>Sim</span>
													</c:when>
													<c:when test="${!a.vidro}">
														<span>Não</span>
													</c:when>
												</c:choose>
											</td>
											<td style="text-align:right">${a.valorBase}</td>
											<td style="text-align:center">${a.usuario.nome}</td>
											<td><a href="/decoracao/${a.id}/excluir">Excluir</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</c:if>

						<c:if test="${empty lista}">
							<h4>Não há decoraçoes cadastradas!!!</h4>
						</c:if>
					</div>
				</body>

				</html>