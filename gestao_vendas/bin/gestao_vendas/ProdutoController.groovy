package gestao_vendas

import org.springframework.dao.DataIntegrityViolationException
import grails.converters.JSON

class ProdutoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [produtoList: Produto.list(params), produtoTotal: Produto.count()]
    }

    def listProduto(int length, int start){
        params.max = length;
        params.offset = start;
        int iCol=0;
        String search = params.getAt("search[value]")?.toString()?.trim(), 
               orderColumn = params.getAt("order[0][column]");
        
        List dados = Produto.createCriteria().list(params) {
            if (search && !search.equals("")){
                or {
                    ilike("nome", "%"+search+"%")
                    sqlRestriction("to_char(this_.valor_padrao, 'FM999G999G990D00') like ?", [search+"%"])
                }
            }
            
            if (orderColumn && params.getAt("columns["+orderColumn+"][data]")?.toString()!="")
                order(params.getAt("columns["+orderColumn+"][data]"),params.getAt("order[0][dir]"))
            else 
                order("id","desc")
        }
        
        def recordsTotal = Produto.count();
        def recordsFiltered = dados.totalCount;

        //CODIGO ABAIXO PERMITE A PESONALIZAÇÃO DO RETORNO
        dados = dados.collect {it -> return [
            id : it.id,
            nome : it.nome,
            valorPadrao : formatNumber(number:it.valorPadrao, format:"###,###,##0.00")
        ]}
        
        render contentType: "text/json", text: ["draw":params.draw,"recordsTotal":recordsTotal,"recordsFiltered":recordsFiltered,"data": dados ] as JSON;
    }

    def create() {
        [produto: new Produto(params)]
    }

    def save() {
        def produto = new Produto(params)
        if (!produto.save(flush: true)) {
            render(view: "create", model: [produto: produto])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'produto.label', default: 'Produto'), produto.id])
        redirect(action: "index", id: produto.id)
    }

    def edit(Long id) {
        def produto = Produto.get(id)
        if (!produto) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'produto.label', default: 'Produto'), id])
            redirect(action: "index")
            return
        }

        [produto: produto]
    }

    def update(Long id, Long version) {
        def produto = Produto.get(id)
        if (!produto) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'produto.label', default: 'Produto'), id])
            redirect(action: "index")
            return
        }

        if (version != null) {
            if (produto.version > version) {
                produto.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'produto.label', default: 'Produto')] as Object[],
                          "Another user has updated this Produto while you were editing")
                render(view: "edit", model: [produto: produto])
                return
            }
        }

        produto.properties = params

        if (!produto.save(flush: true)) {
            render(view: "edit", model: [produto: produto])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'produto.label', default: 'Produto'), produto.id])
        redirect(action: "index", id: produto.id)
    }

    def delete(Long id) {
        def produto = Produto.get(id)
        if (!produto) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'produto.label', default: 'Produto'), id])
            redirect(action: "index")
            return
        }

        try {
            produto.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'produto.label', default: 'Produto'), id])
            redirect(action: "index")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'produto.label', default: 'Produto'), id])
            redirect(action: "edit", id: id)
        }
    }

    def carregarValorUltimoProduto(){
        //le os valores atuais preenchidos na view e preenche um objeto chamado produto
        def produto = new Produto(params) 

        //Consulta para localizar ultimo produto inserido
        def ultimoProduto = Produto.createCriteria().get(){
            order("id", "desc")
            maxResults(1)
        }
        //se encontrar um produto, carrega o valor dele
        if (ultimoProduto) 
            produto.valorPadrao = ultimoProduto.valorPadrao

        //renderiza a view com a template atualizada, passando como parametro os valores novos do produto
        render(template: "valorPadrao", model:[produto: produto])
    }
}
