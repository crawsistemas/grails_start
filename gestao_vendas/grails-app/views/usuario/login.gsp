gestao_vendas
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'usuario.label', default: 'Usuario')}" />
		<title>Login</title>
	</head>
	<body>
		<a href="#" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>

		<div id="login-div" class="content scaffold-create" role="main">
			<h1>Login</h1>

			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
				<g:hasErrors bean="${usuario}">
			<ul class="errors" role="alert">
				<g:eachError bean="${usuario}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			
			<g:form action="autenticar">
				<div class="mb-3">
					<label for="usuario" class="form-label">Usuario</label>
					<input type="text" class="form-control" id="usuario" aria-describedby="emailHelp" name="usuario">
				</div>
				<div class="mb-3">
					<label for="senha" class="form-label">Senha</label>
					<input type="password" class="form-control" id="senha" name="senha">
				</div>
				<button type="submit" class="btn btn-primary">Login</button>
			</g:form>
		</div>
	</body>
</html>
