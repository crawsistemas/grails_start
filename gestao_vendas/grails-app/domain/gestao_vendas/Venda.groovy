package gestao_vendas

class Venda {

    //----- ATRIBUTOS ------
    Cliente cliente
    List itensVenda
    BigDecimal valorTotal

    // ----- RELAÇÕES -----
    static hasMany = [itensVenda:VendaItem]

    static constraints = {
        cliente(nullable:false)
        valorTotal(nullable:false,min:0.0)
        itensVenda(nullable:false, validator:{val,obj->!val.isEmpty()})
    }



    // ----- MAPS ----- 
    static mapping = {
        id generator:'sequence', params:[sequence:'sequence_venda']
    }

}

