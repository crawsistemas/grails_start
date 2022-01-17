<div class="fieldcontain" >
    <label for="cliente" >
        <g:message code="venda.cliente.label" default="cliente" />
        <span class="required-indicator">*</span>
    </label>
        <g:select name="cliente.id" from="${gestao_vendas.Cliente.list()}" value="${venda.cliente?.id}" optionKey="id" optionValue="nome"  />
</div>

<%-- ADCIONAR ITEM A LISTA --%>
<div id="div-itens-venda" >
    <g:render template="itensVenda" />
</div>

<%-- VALOR TOTAL --%>
