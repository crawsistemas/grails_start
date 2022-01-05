<div class="fieldcontain" />
    <label for="nome" />
        <g:message code="cliente.nome.label" default="nome" />
        <span class="required-indicator">*</span>
    </label>
        <g:textField name="nome" value="${cliente.nome}" />
</div>

<div class="fieldcontain" />
    <label for="cpfCnpj" />
        <g:message code="cliente.cpfCnpj.label" default="cpfCnpj" />
        <span class="required-indicator">*</span>
    </label>
        <g:textField name="cpfCnpj" value="${cliente.cpfCnpj}" />
</div>

<div class="fieldcontain" />
    <label for="email" />
        <g:message code="cliente.email.label" default="email" />
    </label>
        <g:textField name="cliente.email" value="${cliente.email}" />
</div>