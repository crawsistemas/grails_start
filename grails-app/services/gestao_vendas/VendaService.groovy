package gestao_vendas

import grails.gorm.services.Service

@Service(Venda)
interface VendaService {

    Venda get(Serializable id)

    List<Venda> list(Map args)

    Long count()

    void delete(Serializable id)

    Venda save(Venda venda)

}