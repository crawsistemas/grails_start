package gestao_vendas

class Produto {

    String nome
    BigDecimal valorPadrao

    static constraints = {
        nome(nullable:false)
        valorPadrao(nullable:true)
    }

    // ------- SETTERS E GETTERS -------
    public void setNome(String nome) {
        this.nome = nome?.trim()?.toUpperCase();
    }
    // ------- FIM SETTERS E GETTERS -------

    // ------- MAPPING -------
    static mapping = {
        id generator:'sequence', params:[sequence:'sequence_produto']
    }
    // ------- FIM MAPPING -------
}
