
<div class="fieldcontain ${hasErrors(bean: produto, field: 'nome', 'error')}">
    <label for="nome">
        <g:message code="produto.nome.label" default="nome" />
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="nome" value="${produto.nome}" />
</div>

<div id="div-valor-padrao" style="position: relative;">
    <g:render template="valorPadrao" model="[produto:produto]" />
</div>