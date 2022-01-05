package gestao_vendas

class Cliente {
    //----- ATRIBUTOS -----
    String nome
    String cpfCnpj
    String email

    //----- RELAÇÕES -----


    //----- CONTRAINTS -----
    static constraints = {
        nome(maxLength:255,nullable:false)
        cpfCnpj(validator: {value,obj->
            return (value.length() == 11 || value.length()==14) && value.isNumber()
            })
        email(email:true,nullable:true)
    }

    // ----- MAPS ----- 
    static mapping = {
        id generator:'sequence', params:[sequence:'sequence_cliente']
    }
}
