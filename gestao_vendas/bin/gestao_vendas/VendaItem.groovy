package gestao_vendas

class VendaItem {
    //----- ATRIBUTOS -----
    Produto  produto
    BigDecimal valorUnitario
    BigDecimal quantidade
    BigDecimal desconto
    BigDecimal valorTotalItem
    
    //----- RELAÇÕES -----
    static belongsTo = Venda
    static haMany = [produto:Produto]
    
    //----- CONTRAINTS -----
    static constraints = {
        produto(nullable:true)
        valorUnitario(nullable:false,editable:false)   //PUXA VALOR DO PRODUTO
        quantidade(nullable:false)
        desconto(nullable:true)
        valorTotalItem(nullable:false, validator:{val, obj-> val>0},editable:false) //SETADO PELO CONTROLLER
    }

    // ------- SETTERS E GETTERS -------
    public void setValorUnitario(BigDecimal valorUnitario){
        this.valorUnitario = valorUnitario
    }
    public void setValorTotalItem(BigDecimal valorTotalItem){
        this.valorTotalItem = valorTotalItem
    }

    // ------- FIM SETTERS E GETTERS ------- 

    // ------- MÉTODOS -------



    public void calcularValorTotal(){
        this.setValorTotalItem(this.quantidade*produto.precoPadrao - this.desconto)
    }

    // ----- MAPS ----- 
    static mapping = {
        id generator:'sequence', params:[sequence:'sequence_vendaItem']
    }

}
