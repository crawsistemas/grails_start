<div class="fieldcontain" >
    <button type="button" class="btn btn-sm btn-info" onclick="ajaxPost(this, '${createLink(action:'adicionarItem')}', 'div-itens-venda');">Adicionar Item</button>
    
    <table>
        <thead>
            <th>Nome Produto</th>
            <th>Valor Unitario</th>
            <th>Quantidade</th>
            <th>Desconto</th>
            <th>Valor Total Item</th>
            <th>Remover</th>
        </thead>
        <tbody>
            <g:each var="it" status="i" in="${venda.itensVenda}" >
                <tr>
                    <td><g:select name="itensVenda[${i}].produto.id" from="${gestao_vendas.Produto.list()}" optionKey="id" optionValue="nome" value="${it.produto?.id}"/></td>
                    <td><g:textField name="itensVenda[${i}].valorUnitario" value="${it.valorUnitario}"/> </td>
                    <td><g:textField name="itensVenda[${i}].quantidade" value="${it.quantidade}"/></td>
                    <td><g:textField name="itensVenda[${i}].desconto" value="${it.desconto}"/></td>
                    <td><g:textField name="itensVenda[${i}].valorTotalItem" value="${it.valorTotalItem}"/></td>
                    <td><button type="button" class="btn btn-sm btn-info" onclick="ajaxPost(this, '${createLink(action:'removerItem')}', 'div-itens-venda');">Remover Item</button></td>
                </tr>
            </g:each>
        </tbody>
    </table>
</div>

