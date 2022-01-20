    
<div class="fieldcontain ${hasErrors(bean: produto, field: 'valorPadrao', 'error')}">
    <label for="valorPadrao">
        <g:message code="produto.valorPadrao.label" default="valorPadrao" />
        <span class="required-indicator">*</span>
    </label>
    <g:field name="valorPadrao" 
            value="${formatNumber(number: produto.valorPadrao, format: '###,###,##0.00')}" 
            onkeyup="mascaraNumero(this);"/>
</div>