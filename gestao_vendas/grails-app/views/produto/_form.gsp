
<div class="fieldcontain ${hasErrors(bean: produto, field: 'nome', 'error')}">
    <label for="nome">
        <g:message code="produto.nome.label" default="nome" />
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="nome" value="${produto.nome}" />
</div>

<div class="fieldcontain ${hasErrors(bean: produto, field: 'valorPadrao', 'error')}">
    <label for="valorPadrao">
        <g:message code="produto.valorPadrao.label" default="valorPadrao" />
    </label>
    <g:field name="valorPadrao" value="${formatNumber(number: produto.valorPadrao, format: '###,###,##0.00')}" onkeyup="mascaraNumero(this);"/>
</div>