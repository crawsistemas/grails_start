package gestao_vendas

import grails.gorm.services.Service

@Service(Cliente)
interface ClienteService {

    Cliente get(Serializable id)

    List<Cliente> list(Map args)

    Long count()

    void delete(Serializable id)

    Cliente save(Cliente cliente)

}