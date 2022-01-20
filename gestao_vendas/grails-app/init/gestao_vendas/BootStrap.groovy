package gestao_vendas

import grails.util.Environment

class BootStrap {

    def init = { servletContext ->
        switch(Environment.current) {
            case Environment.DEVELOPMENT:
                def user = new Usuario(nome:"Luiz",usuario:"luiz",senha:"g1234")
                if(!user.save(flush:true)){println user.errors}
            break

        }
    }
    def destroy = {
    }
}
