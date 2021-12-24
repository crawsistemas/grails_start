<div class="fieldcontain">
    <label for="valorTotalItem">
        <g:message code="vendaItem.valorTotal.label" default="valorTotal" />
    </label>
        <g:field name="valorTotalItem" value="${formatNumber(number: vendaItem.valorTotalItem, format: '###,###,##0.00')}" onkeyup="mascaraNumero(this);" />
        <button type="button" class="btn btn-sm btn-info" onclick="ajaxPost(this,'${createLink(action:'carregarValorTotal')}', 'div-valor-total');">Carregar Total</button>
</div>
