package gestao_vendas

import org.springframework.dao.DataIntegrityViolationException
import grails.converters.JSON

class VendaItemController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [vendaItemList: VendaItem.list(params), vendaItemTotal: VendaItem.count()]
    }

    def listVendaItem(int length, int start){
        params.max = length;
        params.offset = start;
        int iCol=0;
        String search = params.getAt("search[value]")?.toString()?.trim(), 
               orderColumn = params.getAt("order[0][column]");
        
        List dados = VendaItem.createCriteria().list(params) {
            if (search && !search.equals("")){
                or {
                    //INSERIR RESTRIÇÕES DE FILTRO NAS COLUNAS
                }
            }
            
            if (orderColumn && params.getAt("columns["+orderColumn+"][data]")?.toString()!="")
                order(params.getAt("columns["+orderColumn+"][data]"),params.getAt("order[0][dir]"))
            else 
                order("id","desc")
        }
        
        def recordsTotal = VendaItem.count();
        def recordsFiltered = dados.totalCount;

        //CODIGO ABAIXO PERMITE A PESONALIZAÇÃO DO RETORNO
        dados = dados.collect {it -> return [
            id : it.id,
            produto: it.produto,
            valorUnitario: it.valorUnitario,
            quantidade: it.quantidade,
            desconto: it.desconto,
            valorTotalItem: it.valorTotalItem

        ]}
        
        render contentType: "text/json", text: ["draw":params.draw,"recordsTotal":recordsTotal,"recordsFiltered":recordsFiltered,"data": dados ] as JSON;
    }

    def create() {
        [vendaItem: new VendaItem(params)]
    }

    def save() {
        def vendaItem = new VendaItem(params)
        if (!vendaItem.save(flush: true)) {
            render(view: "create", model: [vendaItem: vendaItem])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'vendaItem.label', default: 'VendaItem'), vendaItem.id])
        redirect(action: "index", id: vendaItem.id)
    }

    def edit(Long id) {
        def vendaItem = VendaItem.get(id)
        if (!vendaItem) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'vendaItem.label', default: 'VendaItem'), id])
            redirect(action: "index")
            return
        }

        [vendaItem: vendaItem]
    }

    def update(Long id, Long version) {
        def vendaItem = VendaItem.get(id)
        if (!vendaItem) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'vendaItem.label', default: 'VendaItem'), id])
            redirect(action: "index")
            return
        }

        if (version != null) {
            if (vendaItem.version > version) {
                vendaItem.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'vendaItem.label', default: 'VendaItem')] as Object[],
                          "Another user has updated this VendaItem while you were editing")
                render(view: "edit", model: [vendaItem: vendaItem])
                return
            }
        }

        vendaItem.properties = params

        if (!vendaItem.save(flush: true)) {
            render(view: "edit", model: [vendaItem: vendaItem])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'vendaItem.label', default: 'VendaItem'), vendaItem.id])
        redirect(action: "index", id: vendaItem.id)
    }

    def delete(Long id) {
        def vendaItem = VendaItem.get(id)
        if (!vendaItem) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'vendaItem.label', default: 'VendaItem'), id])
            redirect(action: "index")
            return
        }

        try {
            vendaItem.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'vendaItem.label', default: 'VendaItem'), id])
            redirect(action: "index")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'vendaItem.label', default: 'VendaItem'), id])
            redirect(action: "edit", id: id)
        }
    }


    def carregarValorUnitario(){
        //le os valores atuais (no caso apenas o produto)
        def vendaItem = new VendaItem(params)
        render(template: "valorUnitario", model:[vendaItem:vendaItem] )
    }

    def carregarValorTotal(){
        //le os valores atuais (no caso apenas o produto)
        def vendaItem = new VendaItem(params)
        vendaItem.valorTotalItem = vendaItem.valorUnitario*vendaItem.quantidade - vendaItem.desconto
        render(template: "valorTotal", model:[vendaItem:vendaItem] )
    }
}
