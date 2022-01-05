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
        valorTotal(validator:{val,obj->val>0},nullable:false)
        itensVenda(nullable:false, validator:{val,obj->!val.isEmpity()})
    }



    // ----- MAPS ----- 
    static mapping = {
        id generator:'sequence', params:[sequence:'sequence_venda']
    }

}

