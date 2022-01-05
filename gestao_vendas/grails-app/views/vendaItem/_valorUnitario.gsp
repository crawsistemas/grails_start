<div class="fieldcontain">
    <label for="valorUnitario">
        <g:message code="vendaItem.valorUnitario.label" default="valorUnitario" />
        <span class="required-indicator">*</span>
    </label>
        <g:field name="valorUnitario" value="${formatNumber(number: vendaItem.produto?.valorPadrao, format: '###,###,##0.00')}" onkeyup="mascaraNumero(this);" />
        <button type="button" class="btn btn-sm btn-info" onclick="ajaxPost(this,'${createLink(action:'carregarValorUnitario')}', 'div-valor-unitario');">Carregar Unitario</button>
</div>