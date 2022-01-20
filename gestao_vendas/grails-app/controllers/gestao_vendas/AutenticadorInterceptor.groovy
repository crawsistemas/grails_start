package gestao_vendas


class AutenticadorInterceptor {

    AutenticadorInterceptor() {
        matchAll()
        .excludes(controller:"usuario",action:"login")
        .excludes(controller:"usuario",action:"autenticar")
    }

    boolean before() { 
        if(session.user){
            // println "logado"
            true
        }else{
            redirect(controller:"usuario",action:"login")
            // println "n logado"
            false

        }
        
     }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
