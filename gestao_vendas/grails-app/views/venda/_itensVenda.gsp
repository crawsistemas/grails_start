<div class="fieldcontain" >
    <button type="button" 
            class="btn btn-sm btn-info"
            onclick="ajaxPost(this, '${createLink(action:'adicionarItem')}', 'div-itens-venda');">
            Adicionar Item</button>
    
    <table>
        <thead>
            <th>Nome Produto</th>
            <th>Valor Unitario</th>
            <th>Quantidade</th>
            <th>Desconto</th>
            <th>Valor Total Item</th>
            <th></th>
        </thead>
        <tbody>
            <g:each var="it" status="i" in="${venda.itensVenda}" >
                <tr>
                    <td><g:select name="itensVenda[${i}].produto.id" 
                                from="${gestao_vendas.Produto.list()}" 
                                optionKey="id" 
                                optionValue="nome" 
                                value="${it.produto?.id}" 
                                onchange="ajaxPost(this,'${createLink(action:'carregarValores')}?indice=${i}','div-itens-venda');"/></td>
                    <td><g:field name="itensVenda[${i}].valorUnitario" 
                                value="${formatNumber(number: it.valorUnitario, format: '###,###,##0.00')}" onkeyup="mascaraNumero(this)" 
                                readonly="true"/></td>
                    <td><g:field name="itensVenda[${i}].quantidade" 
                                value="${it.quantidade}"
                                onblur="ajaxPost(this,'${createLink(action:'carregarValores')}?indice=${i}','div-itens-venda');"/></td>
                                    
                    <td><g:field name="itensVenda[${i}].desconto" 
                                    value="${it.desconto}"
                                    onblur="ajaxPost(this,'${createLink(action:'carregarValores')}?indice=${i}','div-itens-venda');"/></td>
                    <td><g:field name="itensVenda[${i}].valorTotalItem" 
                                    value="${formatNumber(number: it.valorTotalItem, format: '###,###,##0.00')}" 
                                    onkeyup="mascaraNumerp(this)"
                                    readonly="true"/></td>
                    <td><button type="button" class="btn btn-sm btn-info" 
                                    onclick="ajaxPost(this,'${createLink(action:'removerItem')}?indice=${i}', 'div-itens-venda');"> Remover Item</button></td>
                </tr>
            </g:each>
        </tbody>
    </table>
    <div id="div-valor-total">
        <g:render template="valorTotal" model="['venda':venda]" />
    </div>
</div>

