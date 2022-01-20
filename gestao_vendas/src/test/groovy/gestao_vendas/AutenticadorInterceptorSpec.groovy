package gestao_vendas

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class AutenticadorInterceptorSpec extends Specification implements InterceptorUnitTest<AutenticadorInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test autenticador interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"autenticador")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
