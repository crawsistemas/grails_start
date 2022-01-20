package gestao_vendas

class LoginTagLib {
    def loginControl = {
        if(request.getSession(false) && session.user){
            out << "Ola ${session.user.nome}, "
            out << """${link(action:"logout",controller:"usuario"){"Logout"}}?"""
        } else {
            out << """${link(action:"login", controller:"usuario"){"Login"}} """
        }
    }
}
