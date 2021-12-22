package gestao_vendas

class Produto {

    //----- ATRIBUTOS -----
    String nome
    BigDecimal valorPadrao
    
    //----- RELAÇÕES -----
    static belongsTo = VendaItem

    //----- CONTRAINTS -----
    static constraints = {
        nome(nullable:false)
        valorPadrao(nullable:true)
    }


    // ------- SETTERS E GETTERS -------
    public void setNome(String nome) {
        this.nome = nome?.trim()?.toUpperCase();
    }
    
    public void setValorPadrao(BigDecimal valorPadrao){
        this.valorPadrao = valorPadrao
    }
    // ------- FIM SETTERS E GETTERS -------

    // ------- MAPPING -------
    static mapping = {
        id generator:'sequence', params:[sequence:'sequence_produto']
    }
    // ------- FIM MAPPING -------
}
