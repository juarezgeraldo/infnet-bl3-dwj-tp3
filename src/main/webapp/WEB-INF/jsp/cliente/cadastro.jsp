<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!DOCTYPE html>
		<html>

		<c:import url="/WEB-INF/jsp/header.jsp"></c:import>

		<body>
			<c:import url="/WEB-INF/jsp/menu.jsp"></c:import>

			<div class="container">
				<h2>Cadastro de Clientes</h2>

				<table class="table table-borderless">
					<tbody>
						<tr>
							<td>
								<form action="/cliente/cep" method="POST">
									<div class="input-group mb-3">
										<input type="text" class="form-control" placeholder="Informe o CEP" required minlength="8"
											aria-label="CEP" aria-describedby="basic-addon2" value="${enderecoCli.cep}" maxlength="8"
											name="cep">
										<div class="input-group-append">
											<button class="btn btn-outline-secondary" type="submit">Pesquisa
												CEP</button>
										</div>
									</div>

								</form>
							</td>
							<td>
								<form action="/cliente/incluir" method="POST">

									<div class="form-group">
										<label>Nome:</label>
										<input type="text" class="form-control" required
											placeholder="Entre com o nome do cliente" value="${cliente.nome}"
											name="nome">
									</div>

									<div class="form-group">
										<label>E-mail:</label>
										<input type="email" class="form-control" required value="${cliente.email}" name="email">
									</div>

									<div class="form-group">
										<label>Telefone:</label>
										<input type="text" class="form-control" data-mask="(00) 0000-0000" data-mask-selectonfocus="true"
											required value="${cliente.telefone}"
											name="telefone">
									</div>


									<div class="form-group">
										<label>CEP:</label>
										<input type="text" class="form-control" required placeholder="informe o cep"
											value="${enderecoCli.cep}" name="cep">
									</div>

									<div class="form-group">
										<label>Logradouro:</label>
										<input type="text" class="form-control" placeholder="informe o logradouro" required 
											value="${enderecoCli.logradouro}" name="logradouro">
									</div>

									<div class="form-group">
										<label>Número:</label>
										<input type="text" class="form-control" placeholder="informe o número" required 
											value="${enderecoCli.numero}" name="numero">
									</div>

									<div class="form-group">
										<label>Complemento:</label>
										<input type="text" class="form-control" placeholder="informe o complemento"
											value="${enderecoCli.complemento}" name="complemento">
									</div>

									<div class="form-group">
										<label>Bairro:</label>
										<input type="text" class="form-control" placeholder="Informe o bairro"
											value="${enderecoCli.bairro}" name="bairro">
									</div>

									<div class="form-group">
										<label>Cidade:</label>
										<input type="text" class="form-control" placeholder="Informe a localidade" required 
											value="${enderecoCli.localidade}" name="localidade">
									</div>

									<div class="form-group">
										<label>UF:</label>
										<input type="text" class="form-control" placeholder="Informe a UF" required size="5"
											value="${enderecoCli.uf}" name="uf">
									</div>


									<br />
									<div class="form-group">
										<label>Usuario do cadastro:</label>
										<span>${user.nome}</span>
									</div>

									<button type="submit" class="btn btn-default">Cadastrar</button>
								</form>
							</td>
						</tr>
					</tbody>
				</table>
			</div>

		</body>

		</html>

		$(document).ready(function(){
			$('#telefone').mask('(00) 0000-0000#');
		});