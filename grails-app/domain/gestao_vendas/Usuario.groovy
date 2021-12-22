package gestao_vendas

class Usuario {
    //----- ATRIBUTOS -----
    String nome
    String usuario
    String senha

    //----- CONTRAINTS -----
    static constraints = {
        nome (maxLength:255)
        usuario(maxLength:50)
        senha(maxLength:50,validator:{val,obj->
            def letters = 'a'..'z'
            boolean hasNumber = false
            boolean hasLetter = false
            for (c in val){
                if (c.isNumber()){ hasNumber = true}
                if (letters.contains(c.toLowerCase())){ hasLetter = true}
            }
            return(hasLetter && hasNumber)
        })
    }

    // ----- MAPS ----- 
    static mapping = {
        id generator:'sequence', params:[sequence:'sequence_usuario']
    }
}
