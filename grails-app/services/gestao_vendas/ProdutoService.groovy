package gestao_vendas

import grails.gorm.services.Service

@Service(Produto)
interface ProdutoService {

    Produto get(Serializable id)

    List<Produto> list(Map args)

    Long count()

    void delete(Serializable id)

    Produto save(Produto produto)

}