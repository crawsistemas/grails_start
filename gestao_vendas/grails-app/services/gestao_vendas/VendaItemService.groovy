package gestao_vendas

import grails.gorm.services.Service

@Service(VendaItem)
interface VendaItemService {

    VendaItem get(Serializable id)

    List<VendaItem> list(Map args)

    Long count()

    void delete(Serializable id)

    VendaItem save(VendaItem vendaItem)

}