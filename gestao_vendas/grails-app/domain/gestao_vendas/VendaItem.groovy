package gestao_vendas

class VendaItem {
    //----- ATRIBUTOS -----
    Produto  produto
    BigDecimal valorUnitario = 0
    BigDecimal quantidade = 1
    BigDecimal desconto = 0
    BigDecimal valorTotalItem = 0
    
    //----- RELAÇÕES -----
    static belongsTo = Venda
    
    //----- CONTRAINTS -----
    static constraints = {
        produto(nullable:false)
        valorUnitario(nullable:false)   //PUXA VALOR DO PRODUTO
        quantidade(nullable:false,min:0.0)
        desconto(nullable:true)
        valorTotalItem(nullable:false, min:0.0) //SETADO PELO CONTROLLER
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
