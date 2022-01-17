<div class="fieldcontain" >
    <label for="valorTotal">
        <g:message code="venda.valorTotal.label" default="valorTotal" />
    </label>
        <g:textField name="valorTotal" 
                     value="${formatNumber(number: venda.valorTotal, format: '###,###,##0.00')}"
                     readonly="true" />

</div>