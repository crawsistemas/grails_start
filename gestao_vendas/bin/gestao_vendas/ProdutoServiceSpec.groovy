package gestao_vendas

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ProdutoServiceSpec extends Specification {

    ProdutoService produtoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Produto(...).save(flush: true, failOnError: true)
        //new Produto(...).save(flush: true, failOnError: true)
        //Produto produto = new Produto(...).save(flush: true, failOnError: true)
        //new Produto(...).save(flush: true, failOnError: true)
        //new Produto(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //produto.id
    }

    void "test get"() {
        setupData()

        expect:
        produtoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Produto> produtoList = produtoService.list(max: 2, offset: 2)

        then:
        produtoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        produtoService.count() == 5
    }

    void "test delete"() {
        Long produtoId = setupData()

        expect:
        produtoService.count() == 5

        when:
        produtoService.delete(produtoId)
        sessionFactory.currentSession.flush()

        then:
        produtoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Produto produto = new Produto()
        produtoService.save(produto)

        then:
        produto.id != null
    }
}
