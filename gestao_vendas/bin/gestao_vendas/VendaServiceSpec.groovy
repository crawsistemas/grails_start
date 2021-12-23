package gestao_vendas

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class VendaServiceSpec extends Specification {

    VendaService vendaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Venda(...).save(flush: true, failOnError: true)
        //new Venda(...).save(flush: true, failOnError: true)
        //Venda venda = new Venda(...).save(flush: true, failOnError: true)
        //new Venda(...).save(flush: true, failOnError: true)
        //new Venda(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //venda.id
    }

    void "test get"() {
        setupData()

        expect:
        vendaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Venda> vendaList = vendaService.list(max: 2, offset: 2)

        then:
        vendaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        vendaService.count() == 5
    }

    void "test delete"() {
        Long vendaId = setupData()

        expect:
        vendaService.count() == 5

        when:
        vendaService.delete(vendaId)
        sessionFactory.currentSession.flush()

        then:
        vendaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Venda venda = new Venda()
        vendaService.save(venda)

        then:
        venda.id != null
    }
}
