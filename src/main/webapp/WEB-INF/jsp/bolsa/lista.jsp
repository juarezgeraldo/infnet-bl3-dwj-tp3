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

						<form action="/bolsa" method="GET">
							<button type="submit" class="btn btn-link">Incluir</button>
						</form>

						<hr>

						<c:if test="${not empty lista}">
							<c:if test="${not empty msg}">
								<div class="alert alert-success">
									<strong>Sucesso!</strong> ${msg}
								</div>
							</c:if>

							<h4>Quantidade de bolsas cadastradas: ${lista.size()}!!!</h4>

							<hr>

							<table class="table table-striped">
								<thead>
									<tr>
										<th>Id</th>
										<th>Nome</th>
										<th>Material</th>
										<th>Com fecho?</th>
										<th>Cor</th>
										<th>Dificuldade</th>
										<th>Valor base</th>
										<th>Usuário do cadastro</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="a" items="${lista}">
										<tr>
											<td>${a.id}</td>
											<td>${a.nome}</td>
											<td style="text-align:center">${a.material}</td>
											<td style="text-align:center">
												<c:choose>
													<c:when test="${a.comFecho}">
														<span>Sim</span>
													</c:when>
													<c:when test="${!a.comFecho}">
														<span>Não</span>
													</c:when>
												</c:choose>
											</td>
											<td style="text-align:center">${a.cor}</td>
											<td style="text-align:right">${a.dificuldade}</td>
											<td style="text-align:right">${a.valorBase}</td>
											<td style="text-align:center">${a.usuario.nome}</td>
											<!-- <td><a href="/bolsa/${a.id}/editar">Editar</a></td> -->
											<td><a href="/bolsa/${a.id}/excluir">Excluir</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</c:if>

						<c:if test="${empty lista}">
							<h4>Não há bolsas cadastradas!!!</h4>
						</c:if>
					</div>
				</body>

				</html>