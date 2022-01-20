<div class="fieldcontain ${hasErrors(bean: usuario, field: 'nome', 'error')}">
    <label for="nome">
        <g:message code="usuario.nome.label" default="nome" />
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="nome" value="${usuario.nome}" />
</div>

<div class="fieldcontain ${hasErrors(bean: usuario, field: 'usuario', 'error')}">
    <label for="usuario">
        <g:message code="usuario.usuario.label" default="usuario" />
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="usuario" value="${usuario.usuario}" />
</div>

<div class="fieldcontain ${hasErrors(bean: usuario, field: 'senha', 'error')}">
    <label for="senha">
        <g:message code="usuario.senha.label" default="senha" />
        <span class="required-indicator">*</span>
    </label>
    <g:field name="senha" value="${usuario.senha}" type="password" />
</div>

